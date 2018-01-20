package com.galaxy.moon.pp.model;

/**
 * create by zhangjun1 on 2018/1/20
 * 车辆
 */
public class CarAsset {
    private Long id;
    private Long billId; // 相关联的借款单据Id
    private String carModel; // 车型
    private String carNo;
    private String byTime;
    private Integer drivingKm; //行驶公里数
    private Float buyPrice;  //购买价格
    private Float evaluation;  //估计
    private String [] carPhotos; // 车照片
    private  String [] idCardPhoto;
    private String [] driveCardPhotos;
    private String []  licensePhotos; //行驶证照片
    private String  [] contracts; //合同照片

    public CarAsset() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getByTime() {
        return byTime;
    }

    public void setByTime(String byTime) {
        this.byTime = byTime;
    }

    public Integer getDrivingKm() {
        return drivingKm;
    }

    public void setDrivingKm(Integer drivingKm) {
        this.drivingKm = drivingKm;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Float evaluation) {
        this.evaluation = evaluation;
    }

    public String[] getCarPhotos() {
        return carPhotos;
    }

    public void setCarPhotos(String[] carPhotos) {
        this.carPhotos = carPhotos;
    }

    public String[] getIdCardPhoto() {
        return idCardPhoto;
    }

    public void setIdCardPhoto(String[] idCardPhoto) {
        this.idCardPhoto = idCardPhoto;
    }

    public String[] getDriveCardPhotos() {
        return driveCardPhotos;
    }

    public void setDriveCardPhotos(String[] driveCardPhotos) {
        this.driveCardPhotos = driveCardPhotos;
    }

    public String[] getLicensePhotos() {
        return licensePhotos;
    }

    public void setLicensePhotos(String[] licensePhotos) {
        this.licensePhotos = licensePhotos;
    }

    public String[] getContracts() {
        return contracts;
    }

    public void setContracts(String[] contracts) {
        this.contracts = contracts;
    }
}
