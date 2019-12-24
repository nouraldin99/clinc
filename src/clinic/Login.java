package clinic;

import classes.Patient;
import database.DBServices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends javax.swing.JFrame {

    static String name;
    public static ViewFactory view = ViewFactory.getViewFactory();
    public Login() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setLocationRelativeTo(null);
             
      

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        Login_button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinic Maneger System");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 50, 50));
        jLabel1.setText("User name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 100, 90, 21);

        UserField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(UserField);
        UserField.setBounds(130, 100, 130, 23);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 140, 90, 21);

        Password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(Password);
        Password.setBounds(130, 140, 130, 23);

        Login_button.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Login_button.setText("Login");
        Login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(Login_button);
        Login_button.setBounds(100, 190, 80, 25);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 190, 80, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pass.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 40, 60, 160);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clinic.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 20, 160, 50);

        setSize(new java.awt.Dimension(415, 293));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_buttonActionPerformed
        try {
            DBServices abserver = DBServices.getInstance();
//            UserField.setText("hadi");
//            Password.setText("123456");
            PreparedStatement statment = abserver.getConnection().prepareStatement(
                    "SELECT * FROM login where [Username] = '" + UserField.getText()
                    + "' and pass = '" + Password.getText() + "'");

            ResultSet result = statment.executeQuery();
            boolean state_pass = false;
            if (result.next()) {
                state_pass = true;
                name = UserField.getText();
            }
            if (UserField.getText().equals("") || Password.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Please fill user and password fields");
            } else if (state_pass) {
                view.getView("homePage");

            } else {
                JOptionPane.showMessageDialog(rootPane, "The user name / password wrong"
                        + "\nTry again", "Erorr", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Login_buttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UserField.setText("");
        Password.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.getView("login");
//                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login_button;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField UserField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
