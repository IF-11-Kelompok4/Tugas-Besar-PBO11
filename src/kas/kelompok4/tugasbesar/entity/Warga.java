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
public class Warga {

    private String id_warga;
    private String nama;
    private String pendapatan;
    private String status;

    public Warga() {

    }
        
    public Warga(String id_warga, String nama, String pendapatan, String status) {
        this.id_warga = id_warga;
        this.nama = nama;
        this.pendapatan = pendapatan;
        this.status = status;
    }
    public String getId_warga() {
        return id_warga;
    }

    public void setId_warga(String id_warga) {
        this.id_warga = id_warga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id_warga);
        hash = 37 * hash + Objects.hashCode(this.nama);
        hash = 37 * hash + Objects.hashCode(this.pendapatan);
        hash = 37 * hash + Objects.hashCode(this.status);
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
        final Warga other = (Warga) obj;
        if (!Objects.equals(this.id_warga, other.id_warga)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.pendapatan, other.pendapatan)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

}
