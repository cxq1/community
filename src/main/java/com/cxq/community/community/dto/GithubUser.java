package com.cxq.community.community.dto;

public class GithubUser {
    private String name;
    private String login;

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private Long id;
    private String bio;

}
