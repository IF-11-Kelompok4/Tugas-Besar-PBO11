/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kas.kelompok4.tugasbesar.entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Star Ramadhan
 */
public class Pengeluaran {
    private Integer no_pengeluaran;
    private Integer tahun;
    private String tanggal;
    private String keperluan;
    private Integer biaya;
    
    public Pengeluaran(){
    
    }

    public Pengeluaran(Integer tahun, String tanggal, String keperluan, Integer biaya, double saldoAwal, double saldoAkhir) {
        this.tahun = tahun;
        this.tanggal = tanggal;
        this.keperluan = keperluan;
        this.biaya = biaya;
    }
    
    
    public Integer getNo_pengeluaran() {
        return no_pengeluaran;
    }

    public void setNo_pengeluaran(Integer no_pengeluaran) {
        this.no_pengeluaran = no_pengeluaran;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    public Integer getBiaya() {
        return biaya;
    }

    public void setBiaya(Integer biaya) {
        this.biaya = biaya;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.no_pengeluaran);
        hash = 17 * hash + Objects.hashCode(this.tahun);
        hash = 17 * hash + Objects.hashCode(this.tanggal);
        hash = 17 * hash + Objects.hashCode(this.keperluan);
        hash = 17 * hash + Objects.hashCode(this.biaya);
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
        final Pengeluaran other = (Pengeluaran) obj;
        if (!Objects.equals(this.no_pengeluaran, other.no_pengeluaran)) {
            return false;
        }
        if (!Objects.equals(this.tahun, other.tahun)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        if (!Objects.equals(this.keperluan, other.keperluan)) {
            return false;
        }
        if (!Objects.equals(this.biaya, other.biaya)) {
            return false;
        }
        return true;
    }

    
    
    
}
