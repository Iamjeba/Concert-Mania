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

public class ConcertInfo_Registration extends javax.swing.JFrame {

    public ConcertInfo_Registration() {
        initComponents();
        Connect();
        updateComboBox_SID();
        updateComboBox_MID();
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
            Logger.getLogger(ConcertInfo_Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConcertInfo_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateComboBox_SID() {
        String query = "select * from Sponsor_Registration";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ComboBox_SID.addItem(rs.getString("S_Id"));
            }
        } catch (Exception e) {

        }
    }

    public void updateComboBox_MID() {
        String query = "select * from signup where UserType='Admin'";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ComboBox_MID.addItem(rs.getString("id"));
            }
        } catch (Exception e) {

        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanelGradient();
        jLabel8 = new javax.swing.JLabel();
        txt_CID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_CName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_CLocation = new javax.swing.JTextField();
        NIDno = new javax.swing.JLabel();
        txt_CCategory = new javax.swing.JTextField();
        NIDno1 = new javax.swing.JLabel();
        button_insert = new javax.swing.JButton();
        BackToAdmin = new javax.swing.JButton();
        NIDno3 = new javax.swing.JLabel();
        txt_CDate = new com.toedter.calendar.JDateChooser();
        NIDno2 = new javax.swing.JLabel();
        button_remove = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        NIDno4 = new javax.swing.JLabel();
        txt_TPrice = new javax.swing.JTextField();
        txt_CQuantity = new javax.swing.JTextField();
        NIDno5 = new javax.swing.JLabel();
        ComboBox_SID = new javax.swing.JComboBox<>();
        ComboBox_MID = new javax.swing.JComboBox<>();
        ArtistNames = new javax.swing.JLabel();
        txt_ArtistNames = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Concert Entry Form ");

        txt_CID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Concert ID");

        jLabel4.setText("Concert name");

        txt_CName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CNameActionPerformed(evt);
            }
        });

        jLabel6.setText("Location");

        txt_CLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CLocationActionPerformed(evt);
            }
        });

        NIDno.setText("Category");

        txt_CCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CCategoryActionPerformed(evt);
            }
        });

        NIDno1.setText("Sponsor ID");

        button_insert.setBackground(new java.awt.Color(0, 153, 255));
        button_insert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_insert.setText("Insert");
        button_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_insertActionPerformed(evt);
            }
        });

        BackToAdmin.setBackground(new java.awt.Color(230, 190, 138));
        BackToAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BackToAdmin.setText("Back to Admin");
        BackToAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToAdminActionPerformed(evt);
            }
        });

        NIDno3.setText("Admin ID");

        NIDno2.setText("Concert Date");

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

        NIDno4.setText("Ticket Price");

        txt_TPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TPriceActionPerformed(evt);
            }
        });

        txt_CQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CQuantityActionPerformed(evt);
            }
        });

        NIDno5.setText("Ticket Quantity");

        ComboBox_SID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_SIDActionPerformed(evt);
            }
        });

        ComboBox_MID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_MIDActionPerformed(evt);
            }
        });

        ArtistNames.setText("Artist Names");

        txt_ArtistNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ArtistNamesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_CID, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(txt_CName)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(NIDno)
                            .addComponent(NIDno1)
                            .addComponent(NIDno3)
                            .addComponent(NIDno2)
                            .addComponent(NIDno4)
                            .addComponent(NIDno5)
                            .addComponent(ArtistNames))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_CDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(txt_CCategory, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_TPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_CQuantity, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_CLocation, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ComboBox_SID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBox_MID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ArtistNames, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BackToAdmin)
                        .addGap(52, 52, 52)
                        .addComponent(button_insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_remove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_update)
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_CID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_CName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_CLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno)
                    .addComponent(txt_CCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno4)
                    .addComponent(txt_TPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno5)
                    .addComponent(txt_CQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_CDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NIDno2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArtistNames)
                    .addComponent(txt_ArtistNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_SID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIDno3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_MID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackToAdmin)
                    .addComponent(button_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            String id = txt_CID.getText();
            String name = txt_CName.getText();
            String location = txt_CLocation.getText();
            String category = txt_CCategory.getText();
            String ticket_price = txt_TPrice.getText();
            String ticket_quantity = txt_CQuantity.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String C_Date = null;
            C_Date = sdf.format(txt_CDate.getDate());
            String ArtistNames = txt_ArtistNames.getText();
            String S_id = String.valueOf(ComboBox_SID.getSelectedItem());
            String M_id = String.valueOf(ComboBox_MID.getSelectedItem());

            /* sequece -> UserType,id, name, location, gender, pin, category, phone number  */
            String query = "Insert into Concert_Registration(id,name,location,category,ticket_price,ticket_quantity,C_Date,ArtistNames,S_id,M_id) values(?,?,?,?,?,?,?,?,?,?)";

            pst = (PreparedStatement) conn.prepareStatement(query);

            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, location);
            pst.setString(4, category);
            pst.setString(5, ticket_price);
            pst.setString(6, ticket_quantity);
            pst.setString(7, C_Date);
            pst.setString(8, ArtistNames);
            pst.setString(9, S_id);
            pst.setString(10, M_id);

            if (!isNumeric(id) || !isNumeric(S_id) || !isNumeric(M_id) || !isNumeric(ticket_price) || !isNumeric(ticket_quantity)) {
                JOptionPane.showMessageDialog(this, "Please insert numeric values");
            } else if (id.isEmpty() || name.isEmpty() || location.isEmpty() || category.isEmpty() || ticket_price.isEmpty()
                    || ticket_quantity.isEmpty() || C_Date == null || ArtistNames.isEmpty() || S_id.isEmpty() || M_id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide all informations");
            } else {
                JOptionPane.showMessageDialog(this, "User's information is added");
                pst.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Please provide all informations");
        }

    }//GEN-LAST:event_button_insertActionPerformed

    private void txt_CIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CIDActionPerformed

    private void txt_CCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CCategoryActionPerformed

    private void txt_CLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CLocationActionPerformed

    private void BackToAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToAdminActionPerformed
        dispose();
        AdminPage st = new AdminPage();
        st.setVisible(true);
    }//GEN-LAST:event_BackToAdminActionPerformed

    private void button_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_removeActionPerformed

        try {
            String id = txt_CID.getText();
            String sql = "Delete from Concert_Registration where id=? ";

            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data is Deleted");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_button_removeActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed

        try {                                                       //getText() -> may show error but it will work
            String id = txt_CID.getText();
            String name = txt_CName.getText();
            String location = txt_CLocation.getText();
            String category = txt_CCategory.getText();
            String ticket_price = txt_TPrice.getText();
            String ticket_quantity = txt_CQuantity.getText();
            String ArtistNames = txt_ArtistNames.getText();
            String S_id = String.valueOf(ComboBox_SID.getSelectedItem());
            String M_id = String.valueOf(ComboBox_MID.getSelectedItem());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String C_Date = sdf.format(txt_CDate.getDate());

            /* sequece -> id, name, ,email, gender, pin, nid, phone number, dob  */
            String uquery = "update Concert_Registration set name=?,location=?,category=?,ticket_price=?,ticket_quantity=?,"
                    + "ArtistNames=?,C_Date=?,S_id=?,M_id=? where id=? ";
            pst = (PreparedStatement) conn.prepareStatement(uquery);
            pst.setString(1, name);
            pst.setString(2, location);
            pst.setString(3, category);
            pst.setString(4, ticket_price);
            pst.setString(5, ticket_quantity);
            pst.setString(6, ArtistNames);
            pst.setString(7, C_Date);
            pst.setString(8, S_id);
            pst.setString(9, M_id);

            pst.setString(10, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "User's information is updated");

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_updateActionPerformed

    private void txt_CNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CNameActionPerformed

    private void txt_TPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TPriceActionPerformed

    private void txt_CQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CQuantityActionPerformed

    private void ComboBox_SIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_SIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_SIDActionPerformed

    private void ComboBox_MIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_MIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_MIDActionPerformed

    private void txt_ArtistNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ArtistNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ArtistNamesActionPerformed

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
            java.util.logging.Logger.getLogger(ConcertInfo_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConcertInfo_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConcertInfo_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConcertInfo_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.ORANGE);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConcertInfo_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArtistNames;
    private javax.swing.JButton BackToAdmin;
    private javax.swing.JComboBox<String> ComboBox_MID;
    private javax.swing.JComboBox<String> ComboBox_SID;
    private javax.swing.JLabel NIDno;
    private javax.swing.JLabel NIDno1;
    private javax.swing.JLabel NIDno2;
    private javax.swing.JLabel NIDno3;
    private javax.swing.JLabel NIDno4;
    private javax.swing.JLabel NIDno5;
    private javax.swing.JButton button_insert;
    private javax.swing.JButton button_remove;
    private javax.swing.JButton button_update;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_ArtistNames;
    private javax.swing.JTextField txt_CCategory;
    private com.toedter.calendar.JDateChooser txt_CDate;
    private javax.swing.JTextField txt_CID;
    private javax.swing.JTextField txt_CLocation;
    private javax.swing.JTextField txt_CName;
    private javax.swing.JTextField txt_CQuantity;
    private javax.swing.JTextField txt_TPrice;
    // End of variables declaration//GEN-END:variables
}
