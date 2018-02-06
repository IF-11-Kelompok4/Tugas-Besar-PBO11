/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.main;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import kas.kelompok4.tugasbesar.database.maskasDatabase;
import kas.kelompok4.tugasbesar.entity.Iuran;
import kas.kelompok4.tugasbesar.entity.Pengeluaran;
import kas.kelompok4.tugasbesar.entity.Warga;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.service.IuranDao;
import kas.kelompok4.tugasbesar.service.PengeluaranDao;
import kas.kelompok4.tugasbesar.service.WargaDao;
import kas.kelompok4.tugasbesar.view.MainView;

/**
 *
 * @author Star Ramadhan
 */
public class Maskas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, MaskasException {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    MainView tampil = new MainView();
                    tampil.loadTableWarga();
                    tampil.loadTableIuran();
                    tampil.loadTablePengeluaran();
                    tampil.setVisible(true);

                } catch (SQLException e) {
                } catch (MaskasException ex) {
                    Logger.getLogger(Maskas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
