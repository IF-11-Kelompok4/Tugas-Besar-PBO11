/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.view;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import kas.kelompok4.tugasbesar.controller.PengeluaranController;
import kas.kelompok4.tugasbesar.database.maskasDatabase;
import kas.kelompok4.tugasbesar.entity.Pengeluaran;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.event.PengeluaranListener;
import kas.kelompok4.tugasbesar.model.PengeluaranModel;
import kas.kelompok4.tugasbesar.model.TablePengeluaranModel;
import kas.kelompok4.tugasbesar.service.PengeluaranDao;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Star Ramadhan
 */
public class pengeluaranPanel extends javax.swing.JPanel implements PengeluaranListener, ListSelectionListener {

    /**
     * Creates new form pengeluaranPanel
     */
    private TablePengeluaranModel tabelmodel;
    private PengeluaranModel model;
    private PengeluaranController controller;

    public pengeluaranPanel() {
        tabelmodel = new TablePengeluaranModel();
        model = new PengeluaranModel();
        model.setListener(this);

        controller = new PengeluaranController();
        controller.setModel(model);

        initComponents();
        tablePegeluaran.getSelectionModel().addListSelectionListener(this);
        tablePegeluaran.setModel(tabelmodel);
        txtNoPengeluaran.setText(0+"");
        txtBiaya.setText(0+"");
        txtKeperluan.setText("");
        txtTanggal.setText("");
    }

    public JTable getTablePengeluaran() {
        return tablePegeluaran;
    }

    public JTextField getTxtBiaya() {
        return txtBiaya;
    }

    public JTextArea getTxtKeperluan() {
        return txtKeperluan;
    }

    public JTextField getTxtTanggal() {
        return txtTanggal;
    }

    public JTextField getTxtNoPengeluaran() {
        return txtNoPengeluaran;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePegeluaran = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUlang = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeperluan = new javax.swing.JTextArea();
        txtBiaya = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNoPengeluaran = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 380));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setText("Data Pengeluaran");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel7.setText("Nomor");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel8.setText("Keperluan");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel10.setText("Biaya");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        tablePegeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePegeluaran);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 550, 230));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel3.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 70, -1));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 70, -1));

        btnUlang.setText("Ulang");
        btnUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangActionPerformed(evt);
            }
        });
        jPanel3.add(btnUlang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 70, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 70, -1));

        txtKeperluan.setColumns(20);
        txtKeperluan.setRows(5);
        jScrollPane2.setViewportView(txtKeperluan);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 230, 100));
        jPanel3.add(txtBiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 90, 20));

        jLabel9.setText("Tanggal");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        txtNoPengeluaran.setEnabled(false);
        jPanel3.add(txtNoPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, -1));
        jPanel3.add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 100, -1));

        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        add(jPanel3, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        controller.insertPengeluaran(this);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        controller.updatePengeluaran(this);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangActionPerformed
        controller.resetPengeluaran(this);
    }//GEN-LAST:event_btnUlangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        controller.deleteWarga(this);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controller.export(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUlang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePegeluaran;
    private javax.swing.JTextField txtBiaya;
    private javax.swing.JTextArea txtKeperluan;
    private javax.swing.JTextField txtNoPengeluaran;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(PengeluaranModel model) {
        txtNoPengeluaran.setText(model.getNo_pengeluaran() + "");
        txtTanggal.setText(model.getTanggal());
        txtKeperluan.setText(model.getKeperluan());
        txtBiaya.setText(model.getBiaya() + "");
    }

    @Override
    public void onInsert(Pengeluaran pengeluaran) {
        tabelmodel.add(pengeluaran);
    }

    @Override
    public void onUpdate(Pengeluaran pengeluaran) {
        int index = tablePegeluaran.getSelectedRow();
        tabelmodel.set(index, pengeluaran);
    }

    @Override
    public void onDelete() {
        int index = tablePegeluaran.getSelectedRow();
        tabelmodel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            Pengeluaran model = tabelmodel.get(tablePegeluaran.getSelectedRow());
            txtNoPengeluaran.setText(model.getNo_pengeluaran() + "");
            txtTanggal.setText(model.getTanggal());
            txtKeperluan.setText(model.getKeperluan());
            txtBiaya.setText(model.getBiaya() + "");
        } catch (IndexOutOfBoundsException exception) {
        }
    }
 public void loadTablePengeluaran() throws SQLException, MaskasException {
        PengeluaranDao dao = maskasDatabase.getPengeluaranDao();
        tabelmodel.setList(dao.selectAllPengeluaran());
    }
}
