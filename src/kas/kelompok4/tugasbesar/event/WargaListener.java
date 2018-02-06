/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.event;

import kas.kelompok4.tugasbesar.entity.Warga;
import kas.kelompok4.tugasbesar.model.WargaModel;

/**
 *
 * @author Star Ramadhan
 */
public interface WargaListener {

    public void onChange(WargaModel model);

    public void onInsert(Warga warga);

    public void onDelete();

    public void onUpdate(Warga warga);
}
