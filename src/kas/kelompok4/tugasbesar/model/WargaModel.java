/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.model;

import java.sql.SQLException;
import kas.kelompok4.tugasbesar.database.maskasDatabase;
import kas.kelompok4.tugasbesar.entity.Warga;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.event.WargaListener;
import kas.kelompok4.tugasbesar.service.WargaDao;

/**
 *
 * @author Star Ramadhan
 */
public class WargaModel {

    private String no_rumah;
    private String nama;
    private String pendapatan;
    private String status;

    private WargaListener listener;

    public WargaListener getListener() {
        return listener;
    }

    public void setListener(WargaListener listener) {
        this.listener = listener;
    }

    public String getNo_Rumah() {
        return no_rumah;
    }

    public void setNo_Rumah(String no_rumah) {
        this.no_rumah = no_rumah;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(String pendapatan) {
        this.pendapatan = pendapatan;
        fireOnChange();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Warga warga) {
        if (listener != null) {
            listener.onInsert(warga);
        }
    }

    protected void fireOnUpdate(Warga warga) {
        if (listener != null) {
            listener.onUpdate(warga);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertWarga() throws SQLException, MaskasException {
        WargaDao dao = maskasDatabase.getWargaDao();
        Warga warga = new Warga();
        warga.setId_warga(no_rumah);
        warga.setNama(nama);
        warga.setPendapatan(pendapatan);
        warga.setStatus(status);

        dao.insertWarga(warga);
        fireOnInsert(warga);
    }

    public void updateWarga() throws SQLException, MaskasException {
        WargaDao dao = maskasDatabase.getWargaDao();
        Warga warga = new Warga();
        warga.setNama(nama);
        warga.setPendapatan(pendapatan);
        warga.setStatus(status);
        warga.setId_warga(no_rumah);

        dao.updateWarga(warga);
        fireOnUpdate(warga);
    }

    public void deleteWarga() throws SQLException, MaskasException {
        WargaDao dao = maskasDatabase.getWargaDao();
        dao.deleteWarga(no_rumah);
        fireOnDelete();
    }

    public void resetWarga(){
        setNo_Rumah("");
        setNama("");
        setPendapatan("~ Pilih ~");
        setStatus("");
        
    }
}
