package com.example.exam2;

import java.io.Serializable;

public class Ticket implements Serializable {
    private int ma;
    private String gadi;
    private String gaden;
    private int dongia;
    private int khuhoi;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getGadi() {
        return gadi;
    }

    public void setGadi(String gadi) {
        this.gadi = gadi;
    }

    public String getGaden() {
        return gaden;
    }

    public void setGaden(String gaden) {
        this.gaden = gaden;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getKhuhoi() {
        return khuhoi;
    }

    public void setKhuhoi(int khuhoi) {
        this.khuhoi = khuhoi;
    }

    public Ticket() {
    }

    public Ticket( String gadi, String gaden, int dongia, int khuhoi) {

        this.gadi = gadi;
        this.gaden = gaden;
        this.dongia = dongia;
        this.khuhoi = khuhoi;
    }
    public double tinhtien(){
        if(this.khuhoi == 1){
            return this.dongia * 2 * 9/10;
        }else{
            return this.dongia * 2;
        }
    }
}
