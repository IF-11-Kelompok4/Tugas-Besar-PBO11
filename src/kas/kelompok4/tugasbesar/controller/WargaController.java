/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.controller;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import kas.kelompok4.tugasbesar.model.WargaModel;
import kas.kelompok4.tugasbesar.view.wargaPanel;

/**
 *
 * @author Star Ramadhan
 */
public class WargaController {

    private WargaModel model;

    public void setModel(WargaModel model) {
        this.model = model;
    }

    public void resetWarga(wargaPanel view) {
        model.resetWarga();
    }

//    public void StatusWarga(wargaPanel view){
//        String pendapatan = view.getCmbPendapatan().toString();
//        String status = view.getTxtStatus().getText();
//        if (pendapatan.equals("> 15 Juta Rupiah")) {
//            status="Sangat Mampu";
//        } else if (pendapatan.equals("6 - 14 Juta Rupiah")) {
//            status="Mampu";
//        } else if (pendapatan.equals("2 - 5 Juta Rupiah")) {
//            status="Cukup";
//        } else if (pendapatan.equals("< 2 Juta Rupiah")) {
//            status="Kurang Mampu";
//        } else {
//            status="";
//        };
//        model.setPendapatan(pendapatan);
//        model.setStatus(status);
//        
//    }
    public void export(wargaPanel view){

        FileWriter fileWriter;

        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File("/excel"));

        int retrival = chooser.showSaveDialog(null);

        if (retrival == JFileChooser.APPROVE_OPTION) {

            try{

                TableModel tModel = view.getTableWarga().getModel();

                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".xls"));           

            // write header

                for(int i = 0; i < tModel.getColumnCount(); i++){

                fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");

            }

                fileWriter.write("\n");

            // write record

                for(int i=0; i < tModel.getRowCount(); i++) {

                for(int j=0; j < tModel.getColumnCount(); j++) {

                fileWriter.write(tModel.getValueAt(i,j).toString() + "\t");

            }

                fileWriter.write("\n");

            }

                fileWriter.close();

            }catch(Exception e){

                JOptionPane.showMessageDialog(null, e);

            }

        }

   }
    public void insertWarga(wargaPanel view) {

        String no_rumah = view.getTxtNoRumah().getText();
        String nama = view.getTxtNama().getText();
        String pendapatan = view.getCmbPendapatan().getSelectedItem().toString();
        String status = view.getTxtStatus().getText();

        if (no_rumah.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nomor Rumah Tidak Boleh Kosong");
        } else if (nama.length() > 20) {
            JOptionPane.showMessageDialog(view, "Nama Terlalu Panjang");
        } else {
            if (pendapatan.trim().equals("> 15 Juta Rupiah")) {
                status = "Sangat Mampu";
            } else if (pendapatan.trim().equals("6 - 14 Juta Rupiah")) {
                status = "Mampu";
            } else if (pendapatan.trim().equals("2 - 5 Juta Rupiah")) {
                status = "Cukup";
            } else if (pendapatan.trim().equals("< 2 Juta Rupiah")) {
                status = "Kurang Mampu";
            } else if(pendapatan.trim().equals("~ Pilih ~")){
                pendapatan = "Dibawah Rata-Rata";
                status = "Tidak Mampu";
            }
            model.setNo_Rumah(no_rumah);
            model.setNama(nama);
            model.setPendapatan(pendapatan);
            model.setStatus(status);

            try {
                model.insertWarga();
                JOptionPane.showMessageDialog(view, "Data Warga Berhasil Ditambah");
                model.resetWarga();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi ERROR di database dengan pesan ", throwable.getMessage()});
            }
        }
    }

    public void updateWarga(wargaPanel view) {

        if (view.getTableWarga().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dulu data yang akan diubah");
            return;
        }

        String no_rumah = view.getTxtNoRumah().getText();

        String nama = view.getTxtNama().getText();
        String pendapatan = view.getCmbPendapatan().getSelectedItem().toString();
        String status = view.getTxtStatus().getText();

        if (no_rumah.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nomor Rumah Tidak Boleh Kosong");
        } else if (nama.length() > 20) {
            JOptionPane.showMessageDialog(view, "Nama Terlalu Panjang");
        } else {
            if (pendapatan.trim().equals("> 15 Juta Rupiah")) {
                status = "Sangat Mampu";
            } else if (pendapatan.trim().equals("6 - 14 Juta Rupiah")) {
                status = "Mampu";
            } else if (pendapatan.trim().equals("2 - 5 Juta Rupiah")) {
                status = "Cukup";
            } else if (pendapatan.trim().equals("< 2 Juta Rupiah")) {
                status = "Kurang Mampu";
            } else {
                status = "Tidak Mampu";
            }
            model.setNo_Rumah(no_rumah);
            model.setNama(nama);
            model.setPendapatan(pendapatan);
            model.setStatus(status);

            try {
                model.updateWarga();
                JOptionPane.showMessageDialog(view, "Data Warga Berhasil Diubah");
                model.resetWarga();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi ERROR di database dengan pesan ", throwable.getMessage()});
            }
        }
    }

    public void deleteWarga(wargaPanel view) {

        if (view.getTableWarga().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dulu data yang akan dihapus");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus Data ini?") == JOptionPane.OK_OPTION) {
            String no_rumah = view.getTxtNoRumah().getText();
            model.setNo_Rumah(no_rumah);

            try {
                model.deleteWarga();
                JOptionPane.showMessageDialog(view, "Data Warga Berhasil Dihapus");
                model.resetWarga();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi ERROR di database dengan pesan ", throwable.getMessage()});
            }
        }
    }
}
