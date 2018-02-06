/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.entity;

import java.util.Objects;

/**
 *
 * @author Star Ramadhan
 */
public class Iuran {

    private int no_iuran;
    private String no_rumah;
    private int jan;
    private int feb;
    private int mar;
    private int apr;
    private int mei;
    private int jun;
    private int jul;
    private int ags;
    private int sept;
    private int okt;
    private int nov;
    private int des;
    private int tahun;
    private int jml;

    public Iuran() {

    }

    public int getNo_iuran() {
        return no_iuran;
    }

    public void setNo_iuran(int no_iuran) {
        this.no_iuran = no_iuran;
    }

    public String getNo_rumah() {
        return no_rumah;
    }

    public void setNo_rumah(String no_rumah) {
        this.no_rumah = no_rumah;
    }

    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public int getMei() {
        return mei;
    }

    public void setMei(int mei) {
        this.mei = mei;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getAgs() {
        return ags;
    }

    public void setAgs(int ags) {
        this.ags = ags;
    }

    public int getSept() {
        return sept;
    }

    public void setSept(int sept) {
        this.sept = sept;
    }

    public int getOkt() {
        return okt;
    }

    public void setOkt(int okt) {
        this.okt = okt;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getJml() {
        return jml;
    }

    public void setJml(int jml) {
        this.jml = jml;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.no_iuran;
        hash = 41 * hash + Objects.hashCode(this.no_rumah);
        hash = 41 * hash + this.jan;
        hash = 41 * hash + this.feb;
        hash = 41 * hash + this.mar;
        hash = 41 * hash + this.apr;
        hash = 41 * hash + this.mei;
        hash = 41 * hash + this.jun;
        hash = 41 * hash + this.jul;
        hash = 41 * hash + this.ags;
        hash = 41 * hash + this.sept;
        hash = 41 * hash + this.okt;
        hash = 41 * hash + this.nov;
        hash = 41 * hash + this.des;
        hash = 41 * hash + this.tahun;
        hash = 41 * hash + this.jml;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Iuran other = (Iuran) obj;
        if (this.no_iuran != other.no_iuran) {
            return false;
        }
        if (!Objects.equals(this.no_rumah, other.no_rumah)) {
            return false;
        }
        if (this.jan != other.jan) {
            return false;
        }
        if (this.feb != other.feb) {
            return false;
        }
        if (this.mar != other.mar) {
            return false;
        }
        if (this.apr != other.apr) {
            return false;
        }
        if (this.mei != other.mei) {
            return false;
        }
        if (this.jun != other.jun) {
            return false;
        }
        if (this.jul != other.jul) {
            return false;
        }
        if (this.ags != other.ags) {
            return false;
        }
        if (this.sept != other.sept) {
            return false;
        }
        if (this.okt != other.okt) {
            return false;
        }
        if (this.nov != other.nov) {
            return false;
        }
        if (this.des != other.des) {
            return false;
        }
        if (this.tahun != other.tahun) {
            return false;
        }
        if (this.jml != other.jml) {
            return false;
        }
        return true;
    }
    
}
