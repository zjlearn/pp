package com.galaxy.moon.pp.util;

import com.galaxy.moon.pp.common.IPSCONSTANTS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.RSAPublicKeySpec;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by zhangjun1 on 2018/2/5
 * ips demo中的源代码
 */
public class IPSCertUtil {
    private static final Logger log = LoggerFactory.getLogger(IPSCertUtil.class);

    /**
     * 证书容器.
     */
    private static KeyStore keyStore = null;
    /**
     * 密码加密证书
     */
    private static X509Certificate encryptCert = null;


    /**
     * 验证签名证书.
     */
    private static X509Certificate validateCert = null;
    /**
     * 验签证书存储Map.
     */
    private static Map<String, X509Certificate> certMap = new HashMap<String, X509Certificate>();
    /**
     * 根据传入证书文件路径和密码读取指定的证书容器.(一种线程安全的实现方式)
     */
    private final static ThreadLocal<KeyStore> certKeyStoreLocal = new ThreadLocal<KeyStore>();
    /**
     * 基于Map存储多商户RSA私钥
     */
    private final static Map<String, KeyStore> certKeyStoreMap = new ConcurrentHashMap<String, KeyStore>();

    static {
        init();
    }

    /**
     * 初始化所有证书.
     */
    public static void init() {

        initSignCert();
//        initValidateCertFromDir();// 初始化所有的验签证书
    }

    /**
     * 加载签名证书
     */
    public static void initSignCert() {
        if (null != keyStore) {
            keyStore = null;
        }
        try {
            keyStore = getKeyInfo(IPSCONSTANTS.IPS_FILE_HOME+ "mer_privateKey.pfx", "111111", "PKCS12");
            log.info("InitSignCert Successful. CertId=["
                    + getSignCertId() + "]");
        } catch (IOException e) {
            log.error("InitSignCert Error", e);
        }
    }

    /**
     * 根据传入的证书文件路径和证书密码加载指定的签名证书
     *
     * @deprecated
     */
    public static void initSignCert(String certFilePath, String certPwd) {
        log.info("加载证书文件[" + certFilePath + "]和证书密码[" + certPwd
                + "]的签名证书开始.");
        certKeyStoreLocal.remove();
        File files = new File(certFilePath);
        if (!files.exists()) {
            log.info("证书文件不存在,初始化签名证书失败.");
            return;
        }
        try {
            certKeyStoreLocal.set(getKeyInfo(certFilePath, certPwd, "PKCS12"));
        } catch (IOException e) {
            log.error("加载签名证书失败", e);
        }
        log.info("加载证书文件[" + certFilePath + "]和证书密码[" + certPwd
                + "]的签名证书结束.");
    }


    /**
     * 加载RSA签名证书
     *
     * @param certFilePath
     * @param certPwd
     */
    public static void loadRsaCert(String certFilePath, String certPwd) {
        KeyStore keyStore = null;
        try {
            keyStore = getKeyInfo(certFilePath, certPwd, "PKCS12");
            certKeyStoreMap.put(certFilePath, keyStore);
            log.info("LoadRsaCert Successful");
        } catch (IOException e) {
            log.error("LoadRsaCert Error", e);
        }
    }


    /**
     * @param path
     * @return
     */
    private static X509Certificate initCert(String path) {
        X509Certificate encryptCertTemp = null;
        CertificateFactory cf = null;
        FileInputStream in = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            in = new FileInputStream(path);
            encryptCertTemp = (X509Certificate) cf.generateCertificate(in);
            // 打印证书加载信息,供测试阶段调试
            log.info("[" + path + "][CertId="
                    + encryptCertTemp.getSerialNumber().toString() + "]");
        } catch (CertificateException e) {
            log.error("InitCert Error", e);
        } catch (FileNotFoundException e) {
            log.error("InitCert Error File Not Found", e);
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error(e.toString());
                }
            }
        }
        return encryptCertTemp;
    }

    /**
     * 从指定目录下加载验证签名证书
     */
    public static void initValidateCertFromDir() {
        certMap.clear();
        String dir = "D://certs/";
        if (isEmpty(dir)) {
            log.info("ERROR: acpsdk.validateCert.dir is empty");
            return;
        }
        CertificateFactory cf = null;
        FileInputStream in = null;
        try {
            cf = CertificateFactory.getInstance("X.509");
            File fileDir = new File(dir);
            File[] files = fileDir.listFiles(new CerFilter());
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                in = new FileInputStream(file.getAbsolutePath());
                validateCert = (X509Certificate) cf.generateCertificate(in);
                certMap.put(validateCert.getSerialNumber().toString(),
                        validateCert);
                // 打印证书加载信息,供测试阶段调试
                log.info("[" + file.getAbsolutePath() + "][CertId="
                        + validateCert.getSerialNumber().toString() + "]");
            }
            log.info("LoadVerifyCert Successful");
        } catch (CertificateException e) {
            log.error("LoadVerifyCert Error", e);
        } catch (FileNotFoundException e) {
            log.error("LoadVerifyCert Error File Not Found", e);
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error(e.toString());
                }
            }
        }
    }


    /**
     * 获取签名证书私钥（单证书模式）
     *
     * @return
     */
    public static PrivateKey getSignCertPrivateKey() {
        try {
            Enumeration<String> aliasenum = keyStore.aliases();
            String keyAlias = null;
            if (aliasenum.hasMoreElements()) {
                keyAlias = aliasenum.nextElement();
            }
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias, "111111".toCharArray());
            return privateKey;
        } catch (KeyStoreException e) {
            log.error("getSignCertPrivateKey Error", e);
            return null;
        } catch (UnrecoverableKeyException e) {
            log.error("getSignCertPrivateKey Error", e);
            return null;
        } catch (NoSuchAlgorithmException e) {
            log.error("getSignCertPrivateKey Error", e);
            return null;
        }
    }


    /**
     * 获取加密证书公钥.密码加密时需要
     *
     * @return
     */
    public static PublicKey getEncryptCertPublicKey() {
        if (null == encryptCert) {
            String path = IPSCONSTANTS.IPS_FILE_HOME + "bank_publicKey.cer";
            //SDKConfig.getConfig().getEncryptCertPath();
            if (!isEmpty(path)) {
                encryptCert = initCert(path);
                return encryptCert.getPublicKey();
            } else {
                log.info("ERROR: acpsdk.encryptCert.path is empty");
                return null;
            }
        } else {
            return encryptCert.getPublicKey();
        }
    }


    /**
     * 获取签名证书中的证书序列号（单证书）
     *
     * @return 证书的物理编号
     */
    public static String getSignCertId() {
        try {
            Enumeration<String> aliasenum = keyStore.aliases();
            String keyAlias = null;
            if (aliasenum.hasMoreElements()) {
                keyAlias = aliasenum.nextElement();
            }
            X509Certificate cert = (X509Certificate) keyStore
                    .getCertificate(keyAlias);
            return cert.getSerialNumber().toString();
        } catch (Exception e) {
            log.error("getSignCertId Error", e);
            return null;
        }
    }


    /**
     * 将证书文件读取为证书存储对象
     *
     * @param pfxkeyfile 证书文件名
     * @param keypwd     证书密码
     * @param type       证书类型
     * @return 证书对象
     * @throws IOException
     */
    public static KeyStore getKeyInfo(String pfxkeyfile, String keypwd,
                                      String type) throws IOException {
        FileInputStream fis = null;
        try {
            KeyStore ks = null;
            if ("JKS".equals(type)) {
                ks = KeyStore.getInstance(type);
            } else if ("PKCS12".equals(type)) {
                String jdkVendor = System.getProperty("java.vm.vendor");
                String javaVersion = System.getProperty("java.version");
                log.info("java.vm.vendor=[" + jdkVendor + "]");
                log.info("java.version=[" + javaVersion + "]");
//				Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
                if (null != jdkVendor && jdkVendor.startsWith("IBM")) {
                    // 如果使用IBMJDK,则强制设置BouncyCastleProvider的指定位置,解决使用IBMJDK时兼容性问题
                    Security.insertProviderAt(
                            new org.bouncycastle.jce.provider.BouncyCastleProvider(),
                            1);
                    printSysInfo();
                } else {
                    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
                }
//				ks = KeyStore.getInstance(type, "BC");
                ks = KeyStore.getInstance(type);
            }
            log.info("Load RSA CertPath=[" + pfxkeyfile + "],Pwd=["
                    + keypwd + "]");
            fis = new FileInputStream(pfxkeyfile);
            char[] nPassword = null;
            nPassword = null == keypwd || "".equals(keypwd.trim()) ? null
                    : keypwd.toCharArray();
            if (null != ks) {
                ks.load(fis, nPassword);
            }
            return ks;
        } catch (Exception e) {
            if (Security.getProvider("BC") == null) {
                log.info("BC Provider not installed.");
            }
            log.error("getKeyInfo Error", e);
            if ((e instanceof KeyStoreException) && "PKCS12".equals(type)) {
                Security.removeProvider("BC");
            }
            return null;
        } finally {
            if (null != fis)
                fis.close();
        }
    }

    // 打印系统环境信息
    public static void printSysInfo() {
        log.info("================= SYS INFO begin====================");
        log.info("os_name:" + System.getProperty("os.name"));
        log.info("os_arch:" + System.getProperty("os.arch"));
        log.info("os_version:" + System.getProperty("os.version"));
        log.info("java_vm_specification_version:"
                + System.getProperty("java.vm.specification.version"));
        log.info("java_vm_specification_vendor:"
                + System.getProperty("java.vm.specification.vendor"));
        log.info("java_vm_specification_name:"
                + System.getProperty("java.vm.specification.name"));
        log.info("java_vm_version:"
                + System.getProperty("java.vm.version"));
        log.info("java_vm_name:" + System.getProperty("java.vm.name"));
        log.info("java.version:" + System.getProperty("java.version"));
        printProviders();
        log.info("================= SYS INFO end=====================");
    }

    public static void printProviders() {
        log.info("Providers List:");
        Provider[] providers = Security.getProviders();
        for (int i = 0; i < providers.length; i++) {
            log.info(i + 1 + "." + providers[i].getName());
        }
    }

    /**
     * 证书文件过滤器
     */
    static class CerFilter implements FilenameFilter {
        public boolean isCer(String name) {
            if (name.toLowerCase().endsWith(".cer")) {
                return true;
            } else {
                return false;
            }
        }

        public boolean accept(File dir, String name) {
            return isCer(name);
        }
    }


    /**
     * 使用模和指数生成RSA公钥 注意：此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同
     *
     * @param modulus  模
     * @param exponent 指数
     * @return
     */
    public static PublicKey getPublicKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            log.error("构造RSA公钥失败：" + e);
            return null;
        }
    }

    /**
     * 判断字符串是否为NULL或空
     *
     * @param s 待判断的字符串数据
     * @return 判断结果 true-是 false-否
     */
    public static boolean isEmpty(String s) {
        return null == s || "".equals(s.trim());
    }
}
