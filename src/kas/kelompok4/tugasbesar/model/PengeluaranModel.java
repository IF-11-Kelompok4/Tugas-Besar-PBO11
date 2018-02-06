/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.model;

import java.sql.SQLException;
import java.util.Date;
import kas.kelompok4.tugasbesar.database.maskasDatabase;
import kas.kelompok4.tugasbesar.entity.Pengeluaran;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.event.PengeluaranListener;
import kas.kelompok4.tugasbesar.service.PengeluaranDao;

/**
 *
 * @author Star Ramadhan
 */
public class PengeluaranModel {

    private Integer no_pengeluaran;
    private Integer tahun;
    private String tanggal;
    private String keperluan;
    private Integer biaya;

    private PengeluaranListener listener;

    public PengeluaranListener getListener() {
        return listener;
    }

    public void setListener(PengeluaranListener listener) {
        this.listener = listener;
    }

    public Integer getNo_pengeluaran() {
        return no_pengeluaran;
    }

    public void setNo_pengeluaran(Integer no_pengeluaran) {
        this.no_pengeluaran = no_pengeluaran;
        fireOnChange();

    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
        fireOnChange();

    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
        fireOnChange();
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
        fireOnChange();
    }

    public Integer getBiaya() {
        return biaya;
    }

    public void setBiaya(Integer biaya) {
        this.biaya = biaya;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Pengeluaran pengeluaran) {
        if (listener != null) {
            listener.onInsert(pengeluaran);
        }
    }

    protected void fireOnUpdate(Pengeluaran pengeluaran) {
        if (listener != null) {
            listener.onUpdate(pengeluaran);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertPengeluaran() throws SQLException, MaskasException {
        PengeluaranDao dao = maskasDatabase.getPengeluaranDao();
        Pengeluaran pengeluaran = new Pengeluaran();
        pengeluaran.setNo_pengeluaran(no_pengeluaran);
        pengeluaran.setTahun(tahun);
        pengeluaran.setTanggal(tanggal);
        pengeluaran.setKeperluan(keperluan);
        pengeluaran.setBiaya(biaya);

        dao.insertPengeluaran(pengeluaran);
        fireOnInsert(pengeluaran);
    }

    public void updatePengeluaran() throws SQLException, MaskasException {
        PengeluaranDao dao = maskasDatabase.getPengeluaranDao();
        Pengeluaran pengeluaran = new Pengeluaran();
        pengeluaran.setNo_pengeluaran(no_pengeluaran);
        pengeluaran.setTahun(tahun);
        pengeluaran.setTanggal(tanggal);
        pengeluaran.setKeperluan(keperluan);
        pengeluaran.setBiaya(biaya);

        dao.updatePengeluaran(pengeluaran);
        fireOnUpdate(pengeluaran);
    }

    public void deletePengeluaran() throws SQLException, MaskasException {
        PengeluaranDao dao = maskasDatabase.getPengeluaranDao();
        dao.deletePengeluaran(no_pengeluaran);
        fireOnDelete();
    }

    public void resetPengeluaran() {
        setNo_pengeluaran(0);
        setTanggal(null);
        setBiaya(0);
        setKeperluan("");
    }
}
