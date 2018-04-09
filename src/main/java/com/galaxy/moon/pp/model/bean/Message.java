package com.galaxy.moon.pp.model.bean;

public class Message {
    private Long id;

    private String messgaeName;

    private Integer messgaeType;

    private String messgaeContent;

    private Integer messgaeStatus;

    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessgaeName() {
        return messgaeName;
    }

    public void setMessgaeName(String messgaeName) {
        this.messgaeName = messgaeName == null ? null : messgaeName.trim();
    }

    public Integer getMessgaeType() {
        return messgaeType;
    }

    public void setMessgaeType(Integer messgaeType) {
        this.messgaeType = messgaeType;
    }

    public String getMessgaeContent() {
        return messgaeContent;
    }

    public void setMessgaeContent(String messgaeContent) {
        this.messgaeContent = messgaeContent == null ? null : messgaeContent.trim();
    }

    public Integer getMessgaeStatus() {
        return messgaeStatus;
    }

    public void setMessgaeStatus(Integer messgaeStatus) {
        this.messgaeStatus = messgaeStatus;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}