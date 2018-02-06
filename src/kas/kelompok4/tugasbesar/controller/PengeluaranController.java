/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.controller;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import kas.kelompok4.tugasbesar.model.PengeluaranModel;
import kas.kelompok4.tugasbesar.view.pengeluaranPanel;

/**
 *
 * @author Star Ramadhan
 */
public class PengeluaranController {

    private PengeluaranModel model;

    public void setModel(PengeluaranModel model) {
        this.model = model;
    }

    public void resetPengeluaran(pengeluaranPanel view) {
        model.resetPengeluaran();
    }

    public void export(pengeluaranPanel view){

        FileWriter fileWriter;

        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File("/excel"));

        int retrival = chooser.showSaveDialog(null);

        if (retrival == JFileChooser.APPROVE_OPTION) {

            try{

                TableModel tModel = view.getTablePengeluaran().getModel();

                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".xlsx"));           

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
    public void insertPengeluaran(pengeluaranPanel view) {
        String tanggal = view.getTxtTanggal().getText();
        String keperluan = view.getTxtKeperluan().getText();
        int biaya = Integer.parseInt(view.getTxtBiaya().getText());
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (tanggal.trim().equals("") ||(biaya==0) || (keperluan.trim().equals(""))) {
            JOptionPane.showMessageDialog(view, "Isi Tanggal Terlebih Dahulu");
        } else if (keperluan.length() > 100) {
            JOptionPane.showMessageDialog(view, "Teks Terlalu Panjang");
        } else {
            model.setTanggal(tanggal);
            model.setTahun(year);
            model.setKeperluan(keperluan);
            model.setBiaya(biaya);

            try {
                model.insertPengeluaran();
                JOptionPane.showMessageDialog(view, "Data Pengeluaran Berhasil Ditambah");
                model.resetPengeluaran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi ERROR di database dengan pesan ", throwable.getMessage()});
            }
        }
    }

    public void updatePengeluaran(pengeluaranPanel view) {

        if (view.getTablePengeluaran().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dulu data yang akan diubah");
            return;
        }
        int no_pengeluaran = Integer.parseInt(view.getTxtNoPengeluaran().getText());
        String tanggal = view.getTxtTanggal().getText();
        String keperluan = view.getTxtKeperluan().getText();
        int biaya = Integer.parseInt(view.getTxtBiaya().getText());
        int year = Calendar.getInstance().get(Calendar.YEAR);

        if (tanggal == null) {
            JOptionPane.showMessageDialog(view, "Isi Tanggal Terlebih Dahulu");
        } else if (keperluan.length() > 100) {
            JOptionPane.showMessageDialog(view, "Teks Terlalu Panjang");
        } else {
            model.setNo_pengeluaran(no_pengeluaran);
            model.setTanggal(tanggal);
            model.setTahun(year);
            model.setKeperluan(keperluan);
            model.setBiaya(biaya);

            try {
                model.updatePengeluaran();
                JOptionPane.showMessageDialog(view, "Data Warga Berhasil Diubah");
                model.resetPengeluaran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi ERROR di database dengan pesan ", throwable.getMessage()});
            }
        }
    }

    public void deleteWarga(pengeluaranPanel view) {

        if (view.getTablePengeluaran().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dulu data yang akan dihapus");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus Data ini?") == JOptionPane.OK_OPTION) {
            int no_pengeluaran = Integer.parseInt(view.getTxtNoPengeluaran().getText());
            model.setNo_pengeluaran(no_pengeluaran);

            try {
                model.deletePengeluaran();
                JOptionPane.showMessageDialog(view, "Data Warga Berhasil Dihapus");
                model.resetPengeluaran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi ERROR di database dengan pesan ", throwable.getMessage()});
            }
        }
    }
}
