package com.example.examfinish;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private int ma;
    private String ten;
    private String dc;
    private int sophieu;
    private double diemtb;

    public Restaurant() {
    }

    public Restaurant(String ten, String dc, int sophieu, double diemtb) {
        this.ten = ten;
        this.dc = dc;
        this.sophieu = sophieu;
        this.diemtb = diemtb;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public int getSophieu() {
        return sophieu;
    }

    public void setSophieu(int sophieu) {
        this.sophieu = sophieu;
    }

    public double getDiemtb() {
        return diemtb;
    }

    public void setDiemtb(double diemtb) {
        this.diemtb = diemtb;
    }
    public double tinhdiemtb (){


          return    (diemtb * sophieu ) / (sophieu + 1);

    }
}
