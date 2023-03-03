package library;

import dbconnect.dbconnect;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Nipun Senarath
 */
public class register extends javax.swing.JFrame {

    Connection sos = null;
    PreparedStatement sss = null;
    ResultSet rs = null;
    
    public register() {
        
        initComponents();
        scaleImage();
        setExtendedState(MAXIMIZED_BOTH);
        sos = dbconnect.connect();
        
    }

    public void scaleImage()
    
    {
        ImageIcon icon = new ImageIcon("D:\\New Volume\\NetBeansProjects\\library\\images\\register.jpg");
        Image img = icon .getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        namebox = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        passbox = new javax.swing.JPasswordField();
        repassbox = new javax.swing.JPasswordField();
        label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namebox.setBorder(null);
        jPanel1.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 190, 20));

        username.setBorder(null);
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 190, 20));

        passbox.setBorder(null);
        jPanel1.add(passbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 200, -1));

        repassbox.setBorder(null);
        jPanel1.add(repassbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 120, -1));
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 1370, 710));

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, 150, 40));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        {
            login sy = new login ();
            sy.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String name;
        String uname ;
        String pass;
        String repass;

        name = namebox.getText();
        uname = username.getText();
        pass = passbox.getText();
        repass = repassbox.getText();

        if(pass.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Add A Password");
        }
        else if(!pass.equals(repass))
        {
            JOptionPane.showMessageDialog(null, "Retype The Password Again");
        }

        try
        {
            String sen = "INSERT INTO regis (rname,ruser,rpass,rrepass) VALUES ('"+name+"','"+uname+"','"+pass+"','"+repass+"')";
            sss = sos.prepareStatement(sen);
            sss.execute();
            JOptionPane.showMessageDialog(null,"New user added");

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField namebox;
    private javax.swing.JPasswordField passbox;
    private javax.swing.JPasswordField repassbox;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
