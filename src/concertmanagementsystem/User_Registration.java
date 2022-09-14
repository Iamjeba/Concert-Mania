package concertmanagementsystem;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import static com.microsoft.sqlserver.jdbc.StringUtils.isNumeric;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class User_Registration extends javax.swing.JFrame {

    String filename = null;
    byte[] person_image = null;

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;
    public int lastID = 0;

    public User_Registration() {
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
            Logger.getLogger(User_Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new JPanelGradient();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
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
        txtDateDob = new com.toedter.calendar.JDateChooser();
        BackToLogin = new javax.swing.JButton();
        ComboBoxGender = new javax.swing.JComboBox<>();
        ComboBoxHealth = new javax.swing.JComboBox<>();
        ComboBoxUserType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ChoosePic = new javax.swing.JButton();
        image_label = new javax.swing.JLabel();
        button_signup = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel7.setText("Health Condition");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Users' Registration");

        jLabel2.setText("ID");

        jLabel4.setText("Username");

        txtid.setEditable(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

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

        BackToLogin.setBackground(new java.awt.Color(230, 190, 138));
        BackToLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BackToLogin.setText("Back to LogIn");
        BackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToLoginActionPerformed(evt);
            }
        });

        ComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        ComboBoxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxGenderActionPerformed(evt);
            }
        });

        ComboBoxHealth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Sickness", "Fever", "Fever and cough", "Other sickness" }));
        ComboBoxHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxHealthActionPerformed(evt);
            }
        });

        ComboBoxUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General User" }));
        ComboBoxUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxUserTypeActionPerformed(evt);
            }
        });

        jLabel1.setText("User Type");

        jLabel9.setText("Upload profile Picture");

        ChoosePic.setBackground(new java.awt.Color(0, 255, 153));
        ChoosePic.setText("Choose");
        ChoosePic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChoosePicActionPerformed(evt);
            }
        });

        image_label.setBackground(new java.awt.Color(255, 255, 0));
        image_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        image_label.setText("        DP");

        button_signup.setBackground(new java.awt.Color(0, 153, 255));
        button_signup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_signup.setText("Sign Up");
        button_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_signupActionPerformed(evt);
            }
        });

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("(Size 150*150 pixel preferable)");

        jLabel11.setText("Health Condition");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BackToLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addComponent(button_signup))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ComboBoxGender, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboBoxUserType, 0, 286, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(NIDno2)
                                                    .addComponent(NIDno1)
                                                    .addComponent(NIDno)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel6))
                                                .addGap(34, 34, 34))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboBoxHealth, 0, 288, Short.MAX_VALUE)
                                            .addComponent(txtPhnNo)
                                            .addComponent(txtDateDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtNIDno, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtemail))
                                                .addGap(2, 2, 2))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(ChoosePic)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ComboBoxUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno)
                    .addComponent(txtNIDno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhnNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NIDno2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChoosePic)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackToLogin)
                    .addComponent(button_signup))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        image_label.getAccessibleContext().setAccessibleDescription("Person Image");

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

    //SignUp Button
    private void button_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_signupActionPerformed

        try {

            String UserType = String.valueOf(ComboBoxUserType.getSelectedItem());
            String id = txtid.getText();
            System.out.println("ID in table: " + id);
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
            String emailvalid1 = "@gmail.com";
            String emailvalid2 = "@aust.edu";
//            String emailvalid3 = ".edu";

            String query = "Insert into signup(UserType,id,name,gender,email,pin,nid,phn,dob,health,images) values(?,?,?,?,?,?,?,?,?,?,?)";

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
            pst.setString(11, filename);

            //checking phone number isValid
            Pattern pattern = Pattern.compile("^\\d{11}$");
            Matcher matcher = pattern.matcher(phn);
            //checking NID number isValid
            Pattern NID_pattern1 = Pattern.compile("^\\d{10}$");
            Matcher NID_matcher1 = NID_pattern1.matcher(nid);

            //checking password length
            int validPW = pin.length();
            //check valid age
            //String dateofbirth = ((txtDateDob)JDateChooser. getDateEditor().getUiComponent()).getText();
            String DOB[] = dob.split("-");
            int year = Integer.parseInt(DOB[0]);
            int month = Integer.parseInt(DOB[1]);
            int day = Integer.parseInt(DOB[2]);
            LocalDate selectedDate = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now();
//            int resultYear = Period.between(currentDate, selectedDate).getYears();
            int resultYear = Period.between(selectedDate, currentDate).getYears();

            if (!email.contains(emailvalid1) && !email.contains(emailvalid2)) {
                JOptionPane.showMessageDialog(this, "Please enter valid email");
            } else if (!matcher.matches()) {
                JOptionPane.showMessageDialog(this, "Please enter valid phone number");
                txtPhnNo.setText("");
            } else if (!(NID_matcher1.matches())) {
                JOptionPane.showMessageDialog(this, "Please enter valid NID number");
                txtNIDno.setText("");
            } 
            else if (validPW < 6) {
                JOptionPane.showMessageDialog(this, "Password must be atleast 6 characters");
                txtpassword.setText("");
            } else if (resultYear < 18) {
                JOptionPane.showMessageDialog(this, "You need to be atleast 18 year old to register");

            } else if (!isNumeric(nid) || !isNumeric(phn)) {
                JOptionPane.showMessageDialog(this, "Please insert numeric values");
            } else if (name.isEmpty() || gender.isEmpty() || email.isEmpty() || pin.isEmpty() || nid.isEmpty() || dob == null
                    || health.isEmpty() || phn.isEmpty() || filename == null) {
                JOptionPane.showMessageDialog(this, "Please provide all informations");
            } else {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "User's information is added");
            }

        } catch (SQLServerException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Email already registered");
        } catch (Exception e) {
//            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Error in Registration Table");
        }

    }//GEN-LAST:event_button_signupActionPerformed

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

    private void BackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToLoginActionPerformed
        dispose();
        Log_In st = new Log_In();
        st.setVisible(true);
    }//GEN-LAST:event_BackToLoginActionPerformed

    private void ComboBoxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxGenderActionPerformed

    private void ComboBoxUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxUserTypeActionPerformed

    @SuppressWarnings("empty-statement")
    private void ChoosePicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChoosePicActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        //ImageIcon imageIcon= new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(image_label.getWidth(),image_label.getHeight(),Image.SCALE_SMOOTH));
//      pic_path.setText(filename);
        try {
            filename = f.getAbsolutePath();
            Image getAbsolutePath = null;
            ImageIcon icon = new ImageIcon(filename);
            Image image = icon.getImage().getScaledInstance(image_label.getWidth(), image_label.getHeight(), Image.SCALE_SMOOTH);

            image_label.setIcon(icon);

            File image1 = new File(filename);
            FileInputStream fis = new FileInputStream(image1);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[124];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);

            }

            person_image = bos.toByteArray();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please provide all informations");

        }
    }//GEN-LAST:event_ChoosePicActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void ComboBoxHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxHealthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxHealthActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.ORANGE);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new User_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToLogin;
    private javax.swing.JButton ChoosePic;
    private javax.swing.JComboBox<String> ComboBoxGender;
    private javax.swing.JComboBox<String> ComboBoxHealth;
    private javax.swing.JComboBox<String> ComboBoxUserType;
    private javax.swing.JLabel NIDno;
    private javax.swing.JLabel NIDno1;
    private javax.swing.JLabel NIDno2;
    private javax.swing.JButton button_signup;
    private javax.swing.JLabel image_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtDateDob;
    private javax.swing.JTextField txtNIDno;
    private javax.swing.JTextField txtPhnNo;
    private javax.swing.JTextField txtemail;
    public static javax.swing.JTextField txtid;
    public static javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
