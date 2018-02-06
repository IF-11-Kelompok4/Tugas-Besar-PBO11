/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kas.kelompok4.tugasbesar.view;

import java.sql.SQLException;
import kas.kelompok4.tugasbesar.error.MaskasException;

/**
 *
 * @author Star Ramadhan
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        
    }

    public void loadTableWarga() throws SQLException, MaskasException {
        wargaPanel1.loadTableWarga();
    }

    public void loadTableIuran() throws SQLException, MaskasException {
        iuranPanel2.loadTableIuran();
    }

    public void loadTablePengeluaran() throws SQLException, MaskasException {
        pengeluaranPanel2.loadTablePengeluaran();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Banner = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        wargaPanel1 = new kas.kelompok4.tugasbesar.view.wargaPanel();
        try {
            iuranPanel2 = new kas.kelompok4.tugasbesar.view.iuranPanel();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        pengeluaranPanel2 = new kas.kelompok4.tugasbesar.view.pengeluaranPanel();
        aboutPanel1 = new kas.kelompok4.tugasbesar.view.aboutPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apps. Managemen Keuangan RT");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Banner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kas/kelompok4/tugasbesar/assets/LogoWhite.png"))); // NOI18N
        Banner.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.setLayout(new java.awt.CardLayout());
        Banner.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 11, -1, 72));

        jPanel4.setLayout(new java.awt.CardLayout());
        Banner.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel3.setText("Maskas V.0.0.1");
        Banner.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 90, -1));

        getContentPane().add(Banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1100, 90));

        jTabbedPane2.addTab("Data Warga", wargaPanel1);
        jTabbedPane2.addTab("Data Iuran", iuranPanel2);
        jTabbedPane2.addTab("Data Pengeluaran", pengeluaranPanel2);
        jTabbedPane2.addTab("About Us", aboutPanel1);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1100, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Banner;
    private kas.kelompok4.tugasbesar.view.aboutPanel aboutPanel1;
    private kas.kelompok4.tugasbesar.view.iuranPanel iuranPanel2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private kas.kelompok4.tugasbesar.view.pengeluaranPanel pengeluaranPanel2;
    private kas.kelompok4.tugasbesar.view.wargaPanel wargaPanel1;
    // End of variables declaration//GEN-END:variables
}
