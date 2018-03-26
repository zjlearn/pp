package com.galaxy.moon.pp;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * create by zhangjun1 on 2018/3/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class jsonTest {

    @Test
    public void testJson() {
        JSONObject jsonObject = new JSONObject();
        List<LabelAddress>  labelAddressList = new ArrayList<>();
        LabelAddress labelAddress = new LabelAddress(0, "http://you.163.com/xxxx/1");
        LabelAddress labelAddress1 = new LabelAddress(1, "http://you.163.com/xxxx/2");
        LabelAddress labelAddress2 = new LabelAddress(2, "http://you.163.com/xxxx/3");
        labelAddressList.add(labelAddress);
        labelAddressList.add(labelAddress1);
        labelAddressList.add(labelAddress2);
        jsonObject.put("data", labelAddressList);
        System.out.println(jsonObject);
    }
}

class LabelAddress {
    int seqNo;
    String logicalURI;

    public LabelAddress(int seqNo, String logicalURI) {
        this.seqNo = seqNo;
        this.logicalURI = logicalURI;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getLogicalURI() {
        return logicalURI;
    }

    public void setLogicalURI(String logicalURI) {
        this.logicalURI = logicalURI;
    }
}