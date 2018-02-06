 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.model;

import java.sql.SQLException;
import kas.kelompok4.tugasbesar.database.maskasDatabase;
import kas.kelompok4.tugasbesar.entity.Iuran;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.event.IuranListener;
import kas.kelompok4.tugasbesar.service.IuranDao;

/**
 *
 * @author Star Ramadhan
 */
public class IuranModel {

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
    private int nominal;
    private int tahun;
    private int jml;

    private IuranListener listener;

    public IuranListener getListener() {
        return listener;
    }

    public void setListener(IuranListener listener) {
        this.listener = listener;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getNo_iuran() {
        return no_iuran;
    }

    public void setNo_iuran(int no_iuran) {
        this.no_iuran = no_iuran;
        fireOnChange();
    }

    public String getNo_rumah() {
        return no_rumah;
    }

    public void setNo_rumah(String no_rumah) {
        this.no_rumah = no_rumah;
        fireOnChange();
    }

    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
        fireOnChange();
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
        fireOnChange();
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
        fireOnChange();
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
        fireOnChange();
    }

    public int getMei() {
        return mei;
    }

    public void setMei(int mei) {
        this.mei = mei;
        fireOnChange();
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
        fireOnChange();
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
        fireOnChange();
    }

    public int getAgs() {
        return ags;
    }

    public void setAgs(int ags) {
        this.ags = ags;
        fireOnChange();
    }

    public int getSept() {
        return sept;
    }

    public void setSept(int sept) {
        this.sept = sept;
        fireOnChange();
    }

    public int getOkt() {
        return okt;
    }

    public void setOkt(int okt) {
        this.okt = okt;
        fireOnChange();
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
        fireOnChange();
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
        fireOnChange();
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
        fireOnChange();
    }

    public int getJml() {
        return jml;
    }

    public void setJml(int jml) {
        this.jml = jml;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChangeIuran(this);
        }
    }

    protected void fireOnInsert(Iuran iuran) {
        if (listener != null) {
            listener.onInsertIuran(iuran);
        }
    }

    protected void fireOnUpdate(Iuran iuran) {
        if (listener != null) {
            listener.onUpdateIuran(iuran);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDeleteIuran();
        }
    }

    public void insertIuran() throws SQLException, MaskasException {
        IuranDao dao = maskasDatabase.getIuranDao();
        Iuran iuran = new Iuran();
        iuran.setNo_rumah(no_rumah);
        iuran.setTahun(tahun);
        iuran.setJan(jan);
        iuran.setFeb(feb);
        iuran.setMar(mar);
        iuran.setApr(apr);
        iuran.setMei(mei);
        iuran.setJun(jun);
        iuran.setJul(jul);
        iuran.setAgs(ags);
        iuran.setSept(sept);
        iuran.setOkt(okt);
        iuran.setNov(nov);
        iuran.setDes(des);
        iuran.setJml(jml);

        dao.insertIuran(iuran);
        fireOnInsert(iuran);
    }

    public void updateIuran() throws SQLException, MaskasException {
        IuranDao dao = maskasDatabase.getIuranDao();
        Iuran iuran = new Iuran();
        iuran.setNo_rumah(no_rumah);
        iuran.setTahun(tahun);
        iuran.setJan(jan);
        iuran.setFeb(feb);
        iuran.setMar(mar);
        iuran.setApr(apr);
        iuran.setMei(mei);
        iuran.setJun(jun);
        iuran.setJul(jul);
        iuran.setAgs(ags);
        iuran.setSept(sept);
        iuran.setOkt(okt);
        iuran.setNov(nov);
        iuran.setDes(des);
        iuran.setJml(jml);
        iuran.setNo_iuran(no_iuran);

        dao.updateIuran(iuran);
        fireOnUpdate(iuran);
    }

//    public void updateJan() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setJan(jan);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateJan(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateFeb() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setFeb(jan);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateFeb(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateMar() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setMar(mar);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateMar(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateApr() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setApr(apr);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateApr(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateMei() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setMei(mei);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateMei(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateJun() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setJun(jun);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateJun(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateJul() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setJul(jul);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateJul(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateAgs() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setAgs(ags);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateJan(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateSept() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setSept(sept);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateSept(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateOkt() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setOkt(okt);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateOkt(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateNov() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setNov(nov);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateNov(iuran);
//        fireOnUpdate(iuran);
//    }
//
//    public void updateDes() throws SQLException, MaskasException {
//        IuranDao dao = maskasDatabase.getIuranDao();
//        Iuran iuran = new Iuran();
//        iuran.setDes(des);
//        iuran.setNo_iuran(no_iuran);
//        dao.updateDes(iuran);
//        fireOnUpdate(iuran);
//    }

    public void deleteIuran() throws SQLException, MaskasException {
        IuranDao dao = maskasDatabase.getIuranDao();
        dao.deleteIuran(no_iuran);
        fireOnDelete();
    }

    public void resetIuran() {
        setNo_iuran(0);
        setNo_rumah("~ Pilih ~");
        setTahun(0);
        setJan(0);
        setFeb(0);
        setMar(0);
        setApr(0);
        setMei(0);
        setJun(0);
        setJul(0);
        setAgs(0);
        setSept(0);
        setOkt(0);
        setNov(0);
        setDes(0);

    }

}
