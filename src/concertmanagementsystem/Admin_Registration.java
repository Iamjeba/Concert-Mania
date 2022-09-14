package concertmanagementsystem;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import static com.microsoft.sqlserver.jdbc.StringUtils.isNumeric;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Admin_Registration extends javax.swing.JFrame {

    public int lastID = 0;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;

    public Admin_Registration() {
        initComponents();
        Connect();
        getLastid();
    }

    private void getLastid() {
        try {
            DBConnect dbc = new DBConnect();
            try {
                conn = dbc.connectToDB();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(User_Registration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(User_Registration.class.getName()).log(Level.SEVERE, null, ex);
            }

            String query = "select id from signup";
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            String ID = "";
            while (rs.next()) {
                System.out.println(lastID);
                ID = rs.getString("id");
                lastID = Integer.parseInt(ID);
                lastID++;
            }
//            System.out.println(ID);
//            System.out.println(lastID);
            txtid.setText(Integer.toString(lastID));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Problem in ID");
        }
    }

    class JPanelGradient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(230, 190, 138);
            Color color2 = new Color(0, 153, 153);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);

        }

    }
//    Connection conn = null;
//    PreparedStatement pst = null;
//    ResultSet rs = null;
//    Statement stm = null;

    @SuppressWarnings("unchecked")
    public void Connect() {
        DBConnect dbc = new DBConnect();
        try {
            conn = dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin_Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanelGradient();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        NIDno = new javax.swing.JLabel();
        txtNIDno = new javax.swing.JTextField();
        NIDno1 = new javax.swing.JLabel();
        txtPhnNo = new javax.swing.JTextField();
        NIDno2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        button_insert = new javax.swing.JButton();
        button_remove = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        ComboBoxGender = new javax.swing.JComboBox<>();
        ComboBoxHealth = new javax.swing.JComboBox<>();
        ComboBoxUserType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtDateDob = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Admin Registration");

        txtid.setEditable(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel4.setText("Username");

        jLabel3.setText("Gender");

        jLabel6.setText("Email");

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabel5.setText("Password");

        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        NIDno.setText("NID No");

        txtNIDno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIDnoActionPerformed(evt);
            }
        });

        NIDno1.setText("Phone No");

        txtPhnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhnNoActionPerformed(evt);
            }
        });

        NIDno2.setText("Date Of Birth");

        jLabel7.setText("Health Condition");

        button_insert.setBackground(new java.awt.Color(0, 153, 255));
        button_insert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_insert.setText("Insert");
        button_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_insertActionPerformed(evt);
            }
        });

        button_remove.setBackground(new java.awt.Color(0, 153, 255));
        button_remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_remove.setText("Remove");
        button_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_removeActionPerformed(evt);
            }
        });

        button_update.setBackground(new java.awt.Color(0, 153, 255));
        button_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_update.setText("Update");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        ComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        ComboBoxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxGenderActionPerformed(evt);
            }
        });

        ComboBoxHealth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Sickness", "Fever", "Fever and cough", "Other sickness" }));

        ComboBoxUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "General User" }));
        ComboBoxUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxUserTypeActionPerformed(evt);
            }
        });

        jLabel1.setText("User Type");

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back to Admin Page");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(button_insert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_update))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(NIDno)
                                    .addComponent(NIDno1)
                                    .addComponent(NIDno2)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhnNo)
                                    .addComponent(txtNIDno)
                                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtpassword)
                                    .addComponent(ComboBoxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBoxHealth, 0, 321, Short.MAX_VALUE)
                                    .addComponent(txtDateDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(txtid)
                                    .addComponent(ComboBoxUserType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno)
                    .addComponent(txtNIDno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhnNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NIDno2, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_remove)
                            .addComponent(button_update))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDateDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_insertActionPerformed

        try {                                                               //getText() -> may show error but it will work
            String UserType = String.valueOf(ComboBoxUserType.getSelectedItem());
            String id = txtid.getText();
            String name = txtname.getText();
            String gender = String.valueOf(ComboBoxGender.getSelectedItem());
            String email = txtemail.getText();
            String pin = new String(txtpassword.getPassword());
            String nid = txtNIDno.getText();
            String phn = txtPhnNo.getText();
            String health = String.valueOf(ComboBoxHealth.getSelectedItem());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dob = null;
            dob = sdf.format(txtDateDob.getDate());

            /* sequece -> UserType,id, name, ,email, gender, pin, nid, phone number  */
            String query = "Insert into signup(UserType,id,name,gender,email,pin,nid,phn,dob,health) values(?,?,?,?,?,?,?,?,?,?)";

            pst = (PreparedStatement) conn.prepareStatement(query);

            pst.setString(1, UserType);
            pst.setString(2, id);
            pst.setString(3, name);
            pst.setString(4, gender);
            pst.setString(5, email);
            pst.setString(6, pin);
            pst.setString(7, nid);
            pst.setString(8, phn);
            pst.setString(9, dob);
            pst.setString(10, health);

            //checking phone number isValid
            Pattern pattern = Pattern.compile("^\\d{11}$");
            Matcher matcher = pattern.matcher(phn);
            //checking NID number isValid
            Pattern NID_pattern = Pattern.compile("^\\d{10}$");
            Matcher NID_matcher = NID_pattern.matcher(nid);

            String emailvalid1 = "@gmail.com";
            String emailvalid2 = "@aust.edu";
            //checking password len
            int validPW = pin.length();
            //check valid age
            //String dateofbirth = ((txtDateDob)JDateChooser. getDateEditor().getUiComponent()).getText();
            String DOB[] = dob.split("-");
            int year = Integer.parseInt(DOB[0]);
            int month = Integer.parseInt(DOB[1]);
            int day = Integer.parseInt(DOB[2]);
            LocalDate selectedDate = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now();
            int resultYear = Period.between(selectedDate, currentDate).getYears();
            System.out.println(resultYear);

            if (!email.contains(emailvalid1) && !email.contains(emailvalid2)) {
                JOptionPane.showMessageDialog(this, "Please enter valid email");
            } else if (!matcher.matches()) {
                JOptionPane.showMessageDialog(this, "Please enter valid phone number");
                txtPhnNo.setText("");
            } else if (!NID_matcher.matches()) {
                JOptionPane.showMessageDialog(this, "Please enter valid NID number");
                txtNIDno.setText("");
            } else if (validPW < 6) {
                JOptionPane.showMessageDialog(this, "Password must be atleast 6 characters");
                txtpassword.setText("");
            } else if (resultYear < 18) {
                JOptionPane.showMessageDialog(this, "You need to be atleast 18 year old to register");

            } else if (!isNumeric(id) || !isNumeric(nid) || !isNumeric(phn)) {
                JOptionPane.showMessageDialog(this, "Please insert numeric values");
            } else if (id.isEmpty() || name.isEmpty() || gender.isEmpty() || email.isEmpty() || pin.isEmpty() || nid.isEmpty() || dob == null
                    || health.isEmpty() || phn.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide all informations");
            } else {
                JOptionPane.showMessageDialog(this, "Admin's information is added");
                pst.executeUpdate();
            }

        } catch (SQLServerException e) {
            JOptionPane.showMessageDialog(this, "Email already registered");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please provide all informations");
        }

    }//GEN-LAST:event_button_insertActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed

        try {                                                       //getText() -> may show error but it will work
            String UserType = String.valueOf(ComboBoxUserType.getSelectedItem());
            String id = txtid.getText();
            String name = txtname.getText();
            String gender = String.valueOf(ComboBoxGender.getSelectedItem());
            String email = txtemail.getText();
            String pin = new String(txtpassword.getPassword());
            String nid = txtNIDno.getText();
            String phn = txtPhnNo.getText();
            String health = String.valueOf(ComboBoxHealth.getSelectedItem());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dob = sdf.format(txtDateDob.getDate());

//            String dob = jDateDoB.getDateFormatString();

            /* sequece -> UserType,id, name, ,email, gender, pin, nid, phone number, dob  */
            String uquery = "update signup set  UserType=? , name=?, gender=?, email=?, pin=?, nid=?, phn=?, dob=?, health=?  where id=? ";
            pst = (PreparedStatement) conn.prepareStatement(uquery);

            pst.setString(1, UserType);
            pst.setString(2, name);
            pst.setString(3, gender);
            pst.setString(4, email);
            pst.setString(5, pin);
            pst.setString(6, nid);
            pst.setString(7, phn);
            pst.setString(8, dob);
            pst.setString(9, health);
            pst.setString(10, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "User's information is updated");

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void button_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_removeActionPerformed
        // TODO add your handling code here:
        try {
            /*Class.forName(driver);
            Connection con=DriverManager.getConnection(url, user, pass);*/
            String pin = new String(txtpassword.getPassword());
            String sql = "Delete from signup  where pin=? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, pin);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data is Deleted");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_button_removeActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtNIDnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIDnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIDnoActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtPhnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhnNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhnNoActionPerformed

    private void ComboBoxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxGenderActionPerformed

    private void ComboBoxUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxUserTypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        AdminPage st = new AdminPage();
        st.setVisible(true);
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
            java.util.logging.Logger.getLogger(Admin_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.ORANGE);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxGender;
    private javax.swing.JComboBox<String> ComboBoxHealth;
    private javax.swing.JComboBox<String> ComboBoxUserType;
    private javax.swing.JLabel NIDno;
    private javax.swing.JLabel NIDno1;
    private javax.swing.JLabel NIDno2;
    private javax.swing.JButton button_insert;
    private javax.swing.JButton button_remove;
    private javax.swing.JButton button_update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtDateDob;
    private javax.swing.JTextField txtNIDno;
    private javax.swing.JTextField txtPhnNo;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
