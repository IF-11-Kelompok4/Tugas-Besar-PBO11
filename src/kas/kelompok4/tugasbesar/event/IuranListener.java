/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.event;

import kas.kelompok4.tugasbesar.entity.Iuran;
import kas.kelompok4.tugasbesar.model.IuranModel;

/**
 *
 * @author Star Ramadhan
 */
public interface IuranListener {

    public void onChangeIuran(IuranModel model);

    public void onInsertIuran(Iuran iuran);

    public void onDeleteIuran();
    
    public void onUpdateIuran(Iuran iuran);

}
