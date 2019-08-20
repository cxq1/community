package com.cxq.community.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gmtcreate;
    private Long gmtmodified;
    private String avatarUrl;


}
