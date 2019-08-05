package com.example.mymorningfirebaseproject;

public class item {
    String mname,memail,mpass,mid;

    public item(String mname, String memail, String mpass, String mid) {
        this.mname = mname;
        this.memail = memail;
        this.mpass = mpass;
        this.mid = mid;
    }

    public item() {

    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getMpass() {
        return mpass;
    }

    public void setMpass(String mpass) {
        this.mpass = mpass;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
