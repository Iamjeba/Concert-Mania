package concertmanagementsystem;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Artist_Registration extends javax.swing.JFrame {

    public Artist_Registration() {
        initComponents();
        Connect();
        updateComboBox_CID();
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
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement stm = null;

    @SuppressWarnings("unchecked")
    public void Connect() {
        DBConnect dbc = new DBConnect();
        try {
            conn = dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Artist_Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Artist_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateComboBox_CID() {
        String query = "select * from Concert_Registration";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ComboBox_CID.addItem(rs.getString("id"));
            }
        } catch (Exception e) {

        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanelGradient();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NIDno = new javax.swing.JLabel();
        button_insert = new javax.swing.JButton();
        button_remove = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        AdminPage_Button = new javax.swing.JButton();
        ArtistTable_Button = new javax.swing.JButton();
        txt_A_ID = new javax.swing.JTextField();
        txt_A_Name = new javax.swing.JTextField();
        txt_A_PhoneNumber = new javax.swing.JTextField();
        ComboBox_CID = new javax.swing.JComboBox<>();
        Email = new javax.swing.JLabel();
        txt_A_Email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setEnabled(false);
        jPanel1.setOpaque(false);
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Artist Registration");

        jLabel2.setText("ID");

        jLabel4.setText("Artist name");

        jLabel6.setText("Concert ID");

        NIDno.setText("Phone Number");

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

        AdminPage_Button.setBackground(new java.awt.Color(0, 51, 102));
        AdminPage_Button.setForeground(new java.awt.Color(255, 255, 255));
        AdminPage_Button.setText("Back to Admin Page");
        AdminPage_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminPage_ButtonActionPerformed(evt);
            }
        });

        ArtistTable_Button.setBackground(new java.awt.Color(0, 51, 102));
        ArtistTable_Button.setForeground(new java.awt.Color(255, 255, 255));
        ArtistTable_Button.setText("Show Artist Table");
        ArtistTable_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistTable_ButtonActionPerformed(evt);
            }
        });

        txt_A_ID.setForeground(new java.awt.Color(102, 102, 102));
        txt_A_ID.setText("Enter Id");

        txt_A_Name.setForeground(new java.awt.Color(102, 102, 102));
        txt_A_Name.setText("Enter Name");

        txt_A_PhoneNumber.setForeground(new java.awt.Color(102, 102, 102));
        txt_A_PhoneNumber.setText("Enter Phone Number");

        ComboBox_CID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        ComboBox_CID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_CIDActionPerformed(evt);
            }
        });

        Email.setText("Email");

        txt_A_Email.setForeground(new java.awt.Color(102, 102, 102));
        txt_A_Email.setText("Enter Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AdminPage_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(ArtistTable_Button))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(button_insert)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button_update))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(NIDno)
                                .addComponent(jLabel6)
                                .addComponent(Email))
                            .addGap(19, 19, 19)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_A_Name, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_A_PhoneNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ComboBox_CID, javax.swing.GroupLayout.Alignment.LEADING, 0, 352, Short.MAX_VALUE)
                                .addComponent(txt_A_ID)
                                .addComponent(txt_A_Email, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminPage_Button)
                    .addComponent(ArtistTable_Button))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_A_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_A_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno)
                    .addComponent(txt_A_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Email)
                    .addComponent(txt_A_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBox_CID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_remove)
                    .addComponent(button_update))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_insertActionPerformed

        try {                                                              

            String A_ID = txt_A_ID.getText();
            String A_Name = txt_A_Name.getText();
            String A_PhoneNumber = txt_A_PhoneNumber.getText();
            String A_Email = txt_A_Email.getText();
            String C_ID = String.valueOf(ComboBox_CID.getSelectedItem());

            String query = "Insert into Artist_Registration(A_ID,A_Name,A_PhoneNumber,A_Email,C_ID) "
                    + "values(?,?,?,?,?)";

            pst = (PreparedStatement) conn.prepareStatement(query);

            pst.setString(1, A_ID);
            pst.setString(2, A_Name);
            pst.setString(3, A_PhoneNumber);
            pst.setString(4, A_Email);
            pst.setString(5, C_ID);

            if (!isNumeric(A_ID) || !isNumeric(A_PhoneNumber) || !isNumeric(C_ID)) {
                JOptionPane.showMessageDialog(this, "Please insert numeric values");
            } else if (A_ID.isEmpty() || A_Name.isEmpty()
                    || A_PhoneNumber.isEmpty() || A_Email.isEmpty() || C_ID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide all informations");
            } else {
                JOptionPane.showMessageDialog(this, "Artist's information is added");
                pst.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Artist's information is not added");
        }

    }//GEN-LAST:event_button_insertActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed

        try {                                                       //getText() -> may show error but it will work
            String A_Id = txt_A_ID.getText();
            String A_Name = txt_A_Name.getText();
            String A_PhoneNumber = txt_A_PhoneNumber.getText();
            String A_Email = txt_A_Email.getText();
            String C_Id = String.valueOf(ComboBox_CID.getSelectedItem());

            /* sequece -> UserType,id, name, ,email, gender, pin, nid, phone number, dob  */
            String uquery = "update Artist_Registration set A_Name=?, A_PhoneNumber=?, A_Email=?, C_Id=? where A_Id=? ";
            pst = (PreparedStatement) conn.prepareStatement(uquery);

            pst.setString(1, A_Name);
            pst.setString(2, A_PhoneNumber );
            pst.setString(3, A_Email);
            pst.setString(4, C_Id);

            pst.setString(5, A_Id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Artist's information is updated");

        } catch (SQLException ex) {
            Logger.getLogger(Artist_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_removeActionPerformed
        // TODO add your handling code here:
        try {
            /*Class.forName(driver);
            Connection con=DriverManager.getConnection(url, user, pass);*/
            String A_ID = txt_A_ID.getText();
            String sql = "Delete from Artist_Registration where A_ID=? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, A_ID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data is Deleted");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_button_removeActionPerformed

    private void AdminPage_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminPage_ButtonActionPerformed
        dispose();
        AdminPage st = new AdminPage();
        st.setVisible(true);
    }//GEN-LAST:event_AdminPage_ButtonActionPerformed

    private void ArtistTable_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistTable_ButtonActionPerformed
        dispose();
        DBTable_ArtistInfo ArtistTable = new DBTable_ArtistInfo();
        ArtistTable.setVisible(true);
    }//GEN-LAST:event_ArtistTable_ButtonActionPerformed

    private void ComboBox_CIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_CIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_CIDActionPerformed

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
            java.util.logging.Logger.getLogger(Artist_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Artist_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Artist_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Artist_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.ORANGE);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Artist_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminPage_Button;
    private javax.swing.JButton ArtistTable_Button;
    private javax.swing.JComboBox<String> ComboBox_CID;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel NIDno;
    private javax.swing.JButton button_insert;
    private javax.swing.JButton button_remove;
    private javax.swing.JButton button_update;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_A_Email;
    private javax.swing.JTextField txt_A_ID;
    private javax.swing.JTextField txt_A_Name;
    private javax.swing.JTextField txt_A_PhoneNumber;
    // End of variables declaration//GEN-END:variables
}
