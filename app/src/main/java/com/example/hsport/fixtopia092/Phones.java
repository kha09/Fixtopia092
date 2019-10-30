package com.example.hsport.fixtopia092;

public class Phones {
    public String mobile;
    public String company;
    public String image;

    public Phones() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

//    public Phones(String mobile) {
//        this.mobile = mobile;
//    }

//    public Phones(String mobile, String company) {
//        this.mobile = mobile;
//        this.company = company;
//    }

    public Phones(String mobile, String company, String image) {
        this.mobile = mobile;
        this.company = company;
        this.image = image;
    }
}
