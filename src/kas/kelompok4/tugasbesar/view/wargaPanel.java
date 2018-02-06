/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.view;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import kas.kelompok4.tugasbesar.controller.WargaController;
import kas.kelompok4.tugasbesar.database.maskasDatabase;
import kas.kelompok4.tugasbesar.entity.Warga;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.event.IuranListener;
import kas.kelompok4.tugasbesar.event.WargaListener;
import kas.kelompok4.tugasbesar.model.TableWargaModel;
import kas.kelompok4.tugasbesar.model.WargaModel;
import kas.kelompok4.tugasbesar.service.WargaDao;

/**
 *
 * @author Star Ramadhan
 */
public class wargaPanel extends javax.swing.JPanel implements WargaListener, ListSelectionListener {

    private TableWargaModel tabelModel;
    private WargaModel model;
    private WargaController controller;

    /**
     * Creates new form wargaPanel
     */
    public wargaPanel() {
        tabelModel = new TableWargaModel();
        model = new WargaModel();
        model.setListener(this);

        controller = new WargaController();
        controller.setModel(model);

        initComponents();
        tableWarga.getSelectionModel().addListSelectionListener(this);
        tableWarga.setModel(tabelModel);
    }

    public JTable getTableWarga() {
        return tableWarga;
    }

    public JComboBox getCmbPendapatan() {
        return cmbPendapatan;
    }

    public JTextField getTxtNama() {
        return txtNama;
    }

    public JTextField getTxtNoRumah() {
        return txtNoRumah;
    }

    public JTextField getTxtStatus() {
        return txtStatus;
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNoRumah = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableWarga = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnUlang = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        cmbPendapatan = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1000, 380));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setText("Data Warga");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel7.setText("Blok/No. Rumah");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel8.setText("Nama");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel9.setText("Pendapatan/Bulan");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel10.setText("Status");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        txtNoRumah.setBorder(null);
        txtNoRumah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoRumahActionPerformed(evt);
            }
        });
        jPanel3.add(txtNoRumah, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 165, -1));

        txtNama.setBorder(null);
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        jPanel3.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 165, -1));

        txtStatus.setEditable(false);
        txtStatus.setBorder(null);
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        jPanel3.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 165, -1));

        tableWarga.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableWarga);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 550, 230));

        btnSimpan.setText("Tambah");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 70, -1));

        btnUbah.setText("Simpan");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel3.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 70, -1));

        btnUlang.setText("Ulang");
        btnUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangActionPerformed(evt);
            }
        });
        jPanel3.add(btnUlang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 70, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 70, -1));

        cmbPendapatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "~ Pilih ~", "> 15 Juta Rupiah", "6 - 14 Juta Rupiah", "2 - 5 Juta Rupiah", "< 2 Juta Rupiah" }));
        cmbPendapatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbPendapatanMouseClicked(evt);
            }
        });
        cmbPendapatan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPendapatanItemStateChanged(evt);
            }
        });
        cmbPendapatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPendapatanActionPerformed(evt);
            }
        });
        jPanel3.add(cmbPendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 165, -1));

        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        add(jPanel3, "card2");

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoRumahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoRumahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoRumahActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtStatusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        controller.insertWarga(this);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        controller.updateWarga(this);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangActionPerformed
        
        controller.resetWarga(this);
    }//GEN-LAST:event_btnUlangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        controller.deleteWarga(this);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cmbPendapatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPendapatanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbPendapatanActionPerformed

    private void cmbPendapatanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPendapatanItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPendapatanItemStateChanged

    private void cmbPendapatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPendapatanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPendapatanMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        controller.export(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btnUlang;
    private javax.swing.JComboBox cmbPendapatan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableWarga;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoRumah;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(WargaModel model) {
        txtNoRumah.setText(model.getNo_Rumah() + "");
        txtNama.setText(model.getNama());
        cmbPendapatan.setSelectedItem(model.getPendapatan());
        txtStatus.setText(model.getStatus());
    }

    @Override
    public void onInsert(Warga warga) {
        tabelModel.add(warga);
    }

    @Override
    public void onDelete() {
        int index = tableWarga.getSelectedRow();
        tabelModel.remove(index);
    }

    @Override
    public void onUpdate(Warga warga) {
        int index = tableWarga.getSelectedRow();
        tabelModel.set(index, warga);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            Warga model = tabelModel.get(tableWarga.getSelectedRow());
            txtNoRumah.setText(model.getId_warga() + "");
            txtNama.setText(model.getNama());
            cmbPendapatan.setSelectedItem(model.getPendapatan());
            txtStatus.setText(model.getStatus());
        } catch (IndexOutOfBoundsException exception) {
        }
    }

    public void loadTableWarga() throws SQLException, MaskasException {
        WargaDao dao = maskasDatabase.getWargaDao();
        tabelModel.setList(dao.SelectAllWarga());
    }
}