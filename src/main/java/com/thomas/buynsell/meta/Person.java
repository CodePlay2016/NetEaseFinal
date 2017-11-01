package com.thomas.buynsell.meta;

public class Person {
    private long userId;
    private String userName;
    private String password;
    private String nickName;
    private int usertype; //类型，买家0，卖家1

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUserType(int usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;

    }

    public String getNickName() {
        return nickName;
    }

    public int getUserType() {
        return usertype;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}
