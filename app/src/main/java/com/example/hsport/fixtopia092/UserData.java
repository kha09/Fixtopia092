package com.example.hsport.fixtopia092;

public class UserData {
    public String userName;
    public String userNumber;
    public String latUser;
    public String lanUser;

    public UserData() {
    }

    public UserData(String userName, String userNumber, String latUser, String lanUser) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.latUser = latUser;
        this.lanUser = lanUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getLatUser() {
        return latUser;
    }

    public void setLatUser(String latUser) {
        this.latUser = latUser;
    }

    public String getLanUser() {
        return lanUser;
    }

    public void setLanUser(String lanUser) {
        this.lanUser = lanUser;
    }
}
