/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.service;

import java.util.List;
import kas.kelompok4.tugasbesar.entity.Pengeluaran;
import kas.kelompok4.tugasbesar.error.MaskasException;

/**
 *
 * @author Star Ramadhan
 */
public interface PengeluaranDao {

    public void insertPengeluaran(Pengeluaran pengeluaran) throws MaskasException;

    public void updatePengeluaran(Pengeluaran pengeluaran) throws MaskasException;

    public void deletePengeluaran(Integer no_pengeluaran) throws MaskasException;

    public Pengeluaran getPengeluaran(Integer no_pengeluaran) throws MaskasException;

    public List<Pengeluaran>selectAllPengeluaran() throws MaskasException;

}
