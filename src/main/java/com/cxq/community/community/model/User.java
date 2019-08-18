package com.cxq.community.community.model;

public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gmtcreate;
    private Long gmtmodified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtcreate() {
        return gmtcreate;
    }

    public void setGmtcreate(Long gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    public Long getGmtmodified() {
        return gmtmodified;
    }

    public void setGmtmodified(Long gmtmodified) {
        this.gmtmodified = gmtmodified;
    }
}
