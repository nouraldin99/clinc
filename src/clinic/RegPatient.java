package clinic;

import classes.Facad;
import classes.Patient;
import java.sql.PreparedStatement;
import database.DBServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegPatient extends javax.swing.JFrame {

    private static DBServices obj = DBServices.getInstance();
    Facad facde = Facad.getFacadObject();
    public RegPatient() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        try {
            PreparedStatement statment = obj.getConnection().prepareStatement("SELECT COUNT(*) FROM Patient");
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                int tmp = result.getInt(1) + 1;
                reg_pid.setText(tmp + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reg_pid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        padd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pphone = new javax.swing.JTextField();
        pemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pstate = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        save = new javax.swing.JButton();
        canel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        page = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration of patients");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Registration of patients");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(31, 23, 148, 15);

        jLabel2.setText("Registration Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(31, 90, 98, 14);

        reg_pid.setEditable(false);
        getContentPane().add(reg_pid);
        reg_pid.setBounds(147, 87, 94, 20);

        jLabel3.setText("patient Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(31, 116, 64, 14);
        getContentPane().add(pname);
        pname.setBounds(147, 113, 94, 20);

        jLabel4.setText("patient Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(31, 169, 76, 14);
        getContentPane().add(padd);
        padd.setBounds(147, 166, 94, 20);

        jLabel5.setText("patient Phone");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(31, 205, 67, 14);

        jLabel6.setText("patient E-mail");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(31, 236, 65, 14);
        getContentPane().add(pphone);
        pphone.setBounds(147, 202, 94, 20);
        getContentPane().add(pemail);
        pemail.setBounds(147, 233, 94, 20);

        jLabel7.setText("Marital_Status");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(31, 267, 69, 14);

        pstate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-chose-", "Married", "Singlur" }));
        getContentPane().add(pstate);
        pstate.setBounds(147, 264, 94, 20);

        jLabel9.setText("Gender");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(31, 306, 35, 14);

        buttonGroup1.add(male);
        male.setText("Male");
        getContentPane().add(male);
        male.setBounds(147, 302, 47, 23);

        buttonGroup1.add(female);
        female.setText("Female");
        getContentPane().add(female);
        female.setBounds(196, 302, 59, 23);

        save.setText("Save Patient");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(31, 343, 93, 23);

        canel.setText("Cancel");
        canel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canelActionPerformed(evt);
            }
        });
        getContentPane().add(canel);
        canel.setBounds(147, 343, 65, 23);

        jLabel8.setText("patient Age");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(31, 142, 56, 14);
        getContentPane().add(page);
        page.setBounds(147, 139, 94, 20);

        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Please fill all fields");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(31, 67, 85, 14);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clinic.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(240, 10, 160, 50);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reg.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(270, 120, 101, 134);

        jLabel13.setText("jLabel13");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(300, 170, 40, 14);

        setSize(new java.awt.Dimension(420, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (!(pname.getText().equals("") || page.getText().equals("")
                || padd.getText().equals("") || pemail.getText().equals("")
                || pphone.getText().equals(""))
                && pstate.getSelectedIndex() != 0
                && !(male.isSelected() == false && female.isSelected() == false)) {

            Patient x = Patient.getInstance();

            try {
                facde.setName(pname.getText());
                if (Integer.parseInt(page.getText()) >= 1 && Integer.parseInt(page.getText()) <= 100) {
                    facde.setAge(Integer.parseInt(page.getText()));
                } else {
                    JOptionPane.showMessageDialog(this, "You must fill age correctly", "Erorr", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                facde.setAddress(padd.getText());
                facde.setPhone(Integer.parseInt(pphone.getText()));
                if (male.isSelected()) {
                    facde.setGinder(male.getText());

                } else {
                    facde.setGinder(female.getText());
                }
                facde.setState(pstate.getSelectedItem().toString());
                if (isValidEmailAddress(pemail.getText())) {
                    facde.setMail(pemail.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "You must fill email correctly", "Erorr", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String sql = "INSERT INTO Patient "
                        + "(Name, Age, Address, Phone, Ginder, State, Mail)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement prepStat = obj.getConnection().prepareStatement(sql);

                prepStat.setString(1, x.getName());
                prepStat.setInt(2, x.getAge());
                prepStat.setString(3, x.getAddress());
                prepStat.setInt(4, x.getPhone());
                prepStat.setString(5, x.getGinder());
                prepStat.setString(6, x.getState());
                prepStat.setString(7, x.getMail());
                prepStat.execute();
                JOptionPane.showMessageDialog(null, "Done!");
                setVisible(false);
                new HomePage();
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(RegPatient.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error, Try again");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "You must fill fields correctly", "Erorr", JOptionPane.ERROR_MESSAGE);
            } catch (InputMismatchException ex) {
                JOptionPane.showMessageDialog(this, "You must fill fields correctly", "Erorr", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must fill all fields", "Reg. Patient", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void canelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canelActionPerformed
        setVisible(false);
        new HomePage();
        dispose();
    }//GEN-LAST:event_canelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton canel;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField padd;
    private javax.swing.JTextField page;
    private javax.swing.JTextField pemail;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField pphone;
    private javax.swing.JComboBox pstate;
    private javax.swing.JTextField reg_pid;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
