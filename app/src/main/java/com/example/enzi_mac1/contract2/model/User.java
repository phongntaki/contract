package com.example.enzi_mac1.contract2.model;

public class User {
    private int user_id;
    private String user_name;
    private String account;
    private String pass;
    private int role_id;
    public User(){
        super();
    }

    public User(int user_id, String user_name, String account, String pass, int role_id){
        this.user_id = user_id;
        this.user_name = user_name;
        this.account = account;
        this.pass = pass;
        this.role_id = role_id;
    }

    public int getUser_id(){
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = this.user_id;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name = this.user_name;
    }

    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account = this.account;
    }

    public String getPass(){
        return pass;
    }

    public void setPass(String pass){
        this.pass = this.pass;
    }

    public int getRole_id(){
        return role_id;
    }

    public void setRole_id(String role_id){
        this.role_id = this.role_id;
    }
}
