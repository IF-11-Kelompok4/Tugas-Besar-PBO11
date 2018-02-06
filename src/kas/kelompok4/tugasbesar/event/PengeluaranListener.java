/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.event;

import kas.kelompok4.tugasbesar.entity.Pengeluaran;
import kas.kelompok4.tugasbesar.model.PengeluaranModel;

/**
 *
 * @author Star Ramadhan
 */
public interface PengeluaranListener {

    public void onChange(PengeluaranModel model);

    public void onInsert(Pengeluaran pengeluaran);

    public void onUpdate(Pengeluaran pengeluaran);

    public void onDelete();

}
