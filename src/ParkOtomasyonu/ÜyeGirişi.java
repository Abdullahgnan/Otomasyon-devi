
package ParkOtomasyonu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class �yeGiri�i extends javax.swing.JFrame {

    /*
     * Creates new form uye_giris
     */
    public �yeGiri�i() {
        
        super("�ye Giri�i");
        
        initComponents();
        
        getContentPane().setLayout(new BorderLayout());
        JLabel degisken = new JLabel(new ImageIcon(this.getClass().getResource("/resimler/uye_giris.jpg")));
        getContentPane().add(degisken);
        degisken.setLayout(new FlowLayout());
        
        
        txt_kadi.setBackground(new Color(0,0,0,0));
        txt_kadi.setBorder(null);
        
        txt_parola.setBackground(new Color(0,0,0,0));
        txt_parola.setBorder(null);
        
        btn_giris.setBackground(new Color(0,0,0,0));
        btn_giris.setBorder(null);
        
        btn_cikis.setBackground(Color.RED);
        btn_cikis.setBorder(null);
        
        txt_kadi.setOpaque(false);
        txt_parola.setOpaque(false);
        
        btn_giris.setContentAreaFilled(false);
        
        //btn_giris.setOpaque(false);
        btn_cikis.setFocusable(false);
         
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_giris = new javax.swing.JButton();
        txt_kadi = new javax.swing.JTextField();
        txt_parola = new javax.swing.JPasswordField();
        btn_cikis = new javax.swing.JButton();
        resim = new javax.swing.JLabel();
        resim.setBackground(Color.YELLOW);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));
        setForeground(new java.awt.Color(255, 153, 51));
        setMaximumSize(new java.awt.Dimension(600, 450));
        setMinimumSize(new java.awt.Dimension(600, 450));
        setPreferredSize(new java.awt.Dimension(600, 450));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("�ye ol");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 330, 70, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("�ifremi Unuttum!");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 330, 130, 17);

        btn_giris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_giris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_girisMouseEntered(evt);
            }
        });
        btn_giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_girisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_giris);
        btn_giris.setBounds(110, 210, 360, 50);

        txt_kadi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txt_kadi);
        txt_kadi.setBounds(120, 90, 310, 50);
        getContentPane().add(txt_parola);
        txt_parola.setBounds(120, 150, 310, 50);

        btn_cikis.setText("�IKI�");
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cikis);
        btn_cikis.setBounds(520, 10, 59, 23);

        resim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(resim);
        resim.setBounds(0, -10, 580, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_girisActionPerformed
        
        try{
                                 
            String kadi=txt_kadi.getText();
            String parola=txt_parola.getText();
            
            if (kadi.equals("") || parola.equals("")) {
                JOptionPane.showMessageDialog(this, "Bo� Alanlar� Doldurunuz.");
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = null;
                Statement st = null;
                ResultSet rs = null;
                
                con = DriverManager.getConnection("jdbc:mysql://localhost/otopark?useUnicode=true&characterEncoding=UTF-8", "root", "");
                st = con.createStatement();
                
                rs = st.executeQuery("select * from uyeler where kadi='"+kadi+"' and parola='"+parola+"'");
                rs.next();
                
                String unvan = rs.getString("unvan");
                
                if(unvan.equals("�al��an")){
                    ParkEkrani ac = new ParkEkrani();
                    ac.setVisible(true);
                }
                else if(unvan.equals("M�d�r")){
                    Raporlama ac = new Raporlama();
                    ac.setVisible(true);
                }
                else if(unvan.equals("")){
                    Musteri ac = new Musteri();
                    ac.setVisible(true);
                }
                
            }
            
        } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Hata: " + ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Veritaban�na ba�lant� sa�lanamad�! " + ex.toString());    
        }        
        
    }//GEN-LAST:event_btn_girisActionPerformed

    private void btn_cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cikisActionPerformed
        �yeGiri�i ac = new �yeGiri�i();
        ac.setVisible(false);
        dispose();
    }//GEN-LAST:event_btn_cikisActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        String musteri = "M��teri";
        �yeEkle ac = new �yeEkle(musteri);
        ac.setVisible(true);
       
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_girisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_girisMouseEntered
        
        
    }//GEN-LAST:event_btn_girisMouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Unutulanlar ac = new Unutulanlar();
        ac.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(�yeGiri�i.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(�yeGiri�i.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(�yeGiri�i.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(�yeGiri�i.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new �yeGiri�i().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton btn_giris;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel resim;
    private javax.swing.JTextField txt_kadi;
    private javax.swing.JPasswordField txt_parola;
    // End of variables declaration//GEN-END:variables
}

