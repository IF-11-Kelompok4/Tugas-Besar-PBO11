/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.controller;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import kas.kelompok4.tugasbesar.database.maskasDatabase;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.model.IuranModel;
import kas.kelompok4.tugasbesar.view.iuranPanel;

/**
 *
 * @author Star Ramadhan
 */
public class IuranController {

    private IuranModel model;

    public void comboNoRumah() {
        try {
            String sql = "Select No_Rumah From tablewarga";
        } catch (Exception e) {
        }
    }

    public void setModel(IuranModel model) {
        this.model = model;
    }

    public void resetIuran(iuranPanel view) {
        model.resetIuran();
    }

    public void export(iuranPanel view) {

        FileWriter fileWriter;

        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File("/excel"));

        int retrival = chooser.showSaveDialog(null);

        if (retrival == JFileChooser.APPROVE_OPTION) {

            try {

                TableModel tModel = view.getTableIuran().getModel();

                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".xlsx"));

            // write header
                for (int i = 0; i < tModel.getColumnCount(); i++) {

                    fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");

                }

                fileWriter.write("\n");

            // write record
                for (int i = 0; i < tModel.getRowCount(); i++) {

                    for (int j = 0; j < tModel.getColumnCount(); j++) {

                        fileWriter.write(tModel.getValueAt(i, j).toString() + "\t");

                    }

                    fileWriter.write("\n");

                }

                fileWriter.close();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);

            }

        }

    }

    public void insertIuran(iuranPanel view) throws SQLException, MaskasException {
        String no_rumah = view.getCmbNoRumah().getSelectedItem().toString();
        int nominal = Integer.parseInt(view.getTxtNominal().getText());
        int year = Calendar.getInstance().get(Calendar.YEAR);

        if (no_rumah.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Pilih Dahulu Alamatnya!!!");
        } else {
            if (view.getCbJan().isSelected() == true) {
                model.setJan(nominal);
            }
            if (view.getCbFeb().isSelected() == true) {
                model.setFeb(nominal);
            }
            if (view.getCbMar().isSelected() == true) {
                model.setMar(nominal);
            }
            if (view.getCbApr().isSelected() == true) {
                model.setApr(nominal);
            }
            if (view.getCbMei().isSelected() == true) {
                model.setMei(nominal);
            }
            if (view.getCbJun().isSelected() == true) {
                model.setJun(nominal);
            }
            if (view.getCbJul().isSelected() == true) {
                model.setJul(nominal);
            }
            if (view.getCbAgs().isSelected() == true) {
                model.setAgs(nominal);
            }
            if (view.getCbSept().isSelected() == true) {
                model.setSept(nominal);
            }
            if (view.getCbOkt().isSelected() == true) {
                model.setOkt(nominal);
            }
            if (view.getCbNov().isSelected() == true) {
                model.setNov(nominal);
            }
            if (view.getCbDes().isSelected() == true) {
                model.setDes(nominal);
            }
            model.setNo_rumah(no_rumah);
            model.setTahun(year);

            Connection conn = maskasDatabase.getConnection();
            String sql = "select jumlah from tableiuran where no_rumah='" + no_rumah + "' AND tahun=" + year;
            try {
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);
                while (rs.next()) {
                    model.setJml(rs.getInt("jumlah"));
                }
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan :", throwable.getMessage()});
            }
            try {
                model.insertIuran();
                JOptionPane.showMessageDialog(view, "Data Iuran Berhasil Tersimpan");
                model.resetIuran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan :", throwable.getMessage()});
            }
        }
    }

    public void updateIuran(iuranPanel view) throws SQLException, MaskasException {
        if (view.getTableIuran().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Pilih Data Yang Akan Diubah");
            return;
        }

        int no_iuran = Integer.parseInt(view.getTxtNoIuran().getText());
        String no_rumah = view.getCmbNoRumah().getSelectedItem().toString();
        int nominal = Integer.parseInt(view.getTxtNominal().getText());
        int year = Calendar.getInstance().get(Calendar.YEAR);

        if (no_rumah.trim().equals("~ Pilih ~")) {
            JOptionPane.showMessageDialog(view, "Pilih Dahulu Alamatnya!!!");
        } else if (nominal == 0) {
            JOptionPane.showMessageDialog(view, "Setel Nominalnya!!!");

        } else {
            if (!((view.getCbJan().isSelected() == true) || (view.getCbFeb().isSelected() == true)
                    || (view.getCbMar().isSelected() == true) || (view.getCbApr().isSelected() == true)
                    || (view.getCbMei().isSelected() == true) || (view.getCbJun().isSelected() == true)
                    || (view.getCbJul().isSelected() == true) || (view.getCbAgs().isSelected() == true)
                    || (view.getCbSept().isSelected() == true) || (view.getCbOkt().isSelected() == true)
                    || (view.getCbNov().isSelected() == true) || (view.getCbDes().isSelected() == true))) {
                JOptionPane.showMessageDialog(view, "Pilih Bulannya Juga!");
                return;
            } else {

                if (view.getCbJan().isSelected() == true) {
                    model.setJan(nominal);
                }
                if (view.getCbFeb().isSelected() == true) {
                    model.setFeb(nominal);
                }
                if (view.getCbMar().isSelected() == true) {
                    model.setMar(nominal);
                }
                if (view.getCbApr().isSelected() == true) {
                    model.setApr(nominal);
                }
                if (view.getCbMei().isSelected() == true) {
                    model.setMei(nominal);
                }
                if (view.getCbJun().isSelected() == true) {
                    model.setJun(nominal);
                }
                if (view.getCbJul().isSelected() == true) {
                    model.setJul(nominal);
                }
                if (view.getCbAgs().isSelected() == true) {
                    model.setAgs(nominal);
                }
                if (view.getCbSept().isSelected() == true) {
                    model.setSept(nominal);
                }
                if (view.getCbOkt().isSelected() == true) {
                    model.setOkt(nominal);
                }
                if (view.getCbNov().isSelected() == true) {
                    model.setNov(nominal);
                }
                if (view.getCbDes().isSelected() == true) {
                    model.setDes(nominal);
                }
            }
            model.setNo_iuran(no_iuran);
            model.setNo_rumah(no_rumah);
            model.setTahun(year);
            Connection conn = maskasDatabase.getConnection();
            String sql = "select jumlah from tableiuran where no_rumah='" + no_rumah + "' AND tahun=" + year;
            try {
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);
                while (rs.next()) {
                    model.setJml(rs.getInt("jumlah"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan :", e.getMessage()});
            }

            try {
                model.updateIuran();
                JOptionPane.showMessageDialog(view, "Data Iuran Berhasil Diubah");
                model.resetIuran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan :", throwable.getMessage()});
            }
        }
    }

    public void deleteIuran(iuranPanel view) {
        if (view.getTableIuran().getSelectedRow() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Pilih Data Yang Akan Dihapus!");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus Data Ini?") == JOptionPane.OK_OPTION) {
            Integer no_iuran = Integer.parseInt(view.getTxtNoIuran().getText());
            model.setNo_iuran(no_iuran);

            try {
                model.deleteIuran();
                JOptionPane.showMessageDialog(view, "Data Iuran Berhasil Tersimpan");
                model.resetIuran();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan :", throwable.getMessage()});
            }
        }
    }
}
