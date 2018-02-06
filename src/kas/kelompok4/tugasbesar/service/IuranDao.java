/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.service;

import java.util.List;
import kas.kelompok4.tugasbesar.entity.Iuran;
import kas.kelompok4.tugasbesar.error.MaskasException;

/**
 *
 * @author Star Ramadhan
 */
public interface IuranDao {

    public void insertIuran(Iuran iuran) throws MaskasException;
    
    public void updateIuran(Iuran iuran) throws MaskasException;
//    public void updateJan(Iuran iuran) throws MaskasException;
//    public void updateFeb(Iuran iuran) throws MaskasException;
//    public void updateMar(Iuran iuran) throws MaskasException;
//    public void updateApr(Iuran iuran) throws MaskasException;
//    public void updateMei(Iuran iuran) throws MaskasException;
//    public void updateJun(Iuran iuran) throws MaskasException;
//    public void updateJul(Iuran iuran) throws MaskasException;
//    public void updateAgs(Iuran iuran) throws MaskasException;
//    public void updateSept(Iuran iuran) throws MaskasException;
//    public void updateOkt(Iuran iuran) throws MaskasException;
//    public void updateNov(Iuran iuran) throws MaskasException;
//    public void updateDes(Iuran iuran) throws MaskasException;

    
    
    public void deleteIuran(Integer no_iuran) throws MaskasException;
    
    public Iuran getIuran(Integer no_iuran) throws MaskasException;

    public List<Iuran> selecAllIuran() throws MaskasException;
}
