package com.zi.elmedico;

/**
 * Created by zi on 3/27/2018.
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String age;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age){
        this.age=age;
    }
}
