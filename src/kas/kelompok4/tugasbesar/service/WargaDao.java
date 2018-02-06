/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.service;

import java.util.List;
import kas.kelompok4.tugasbesar.entity.Warga;
import kas.kelompok4.tugasbesar.error.MaskasException;

/**
 *
 * @author Star Ramadhan
 */
public interface WargaDao {

    public void insertWarga(Warga warga) throws MaskasException;

    public void updateWarga(Warga warga) throws MaskasException;

    public void deleteWarga(String id_warga) throws MaskasException;

    public Warga getWarga(String id_warga) throws MaskasException;

    public List<Warga> SelectAllWarga() throws MaskasException;

}
