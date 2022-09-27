package com.april2nd.happyhouse_3.dto;

public class UserDto {
    private String 	id;
    private String 	pw;
    private String	email;
    private String 	name;
    private int		age;


    public UserDto() {
        super();
    }

    public UserDto(String id, String pw, String email, String name, int age) {
        super();
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDto [id=" + id + ", pw=" + pw + ", email=" + email + ", name=" + name + ", age=" + age + "]";
    }

}
