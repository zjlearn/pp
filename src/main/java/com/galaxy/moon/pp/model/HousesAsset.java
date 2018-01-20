package com.galaxy.moon.pp.model;

/**
 * create by zhangjun1 on 2018/1/20
 */
public class HousesAsset {
    private Long id;
    private Long billId; // 相关联的借款单据Id
    private String position;
    private Float  area;
    private String attributes;  // 属性
    private String purpose;     // 用途
    private float evaluation; // 单位万元
    private String [] deedPhotos; //房产证照片
    private String [] rightCardsPhotos; //房权证
    private String  [] contracts; //合同照片

    public HousesAsset() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    public String[] getDeedPhotos() {
        return deedPhotos;
    }

    public void setDeedPhotos(String[] deedPhotos) {
        this.deedPhotos = deedPhotos;
    }

    public String[] getRightCardsPhotos() {
        return rightCardsPhotos;
    }

    public void setRightCardsPhotos(String[] rightCardsPhotos) {
        this.rightCardsPhotos = rightCardsPhotos;
    }

    public String[] getContracts() {
        return contracts;
    }

    public void setContracts(String[] contracts) {
        this.contracts = contracts;
    }
}
