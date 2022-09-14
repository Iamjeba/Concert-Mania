package concertmanagementsystem;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Wasi
 */
public class AdminPage extends javax.swing.JFrame {

    private void search(String str1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter((javax.swing.RowFilter.regexFilter("(?i)" + str1)));
    }

    public AdminPage() {
        initComponents();
        Connect();
        show_users();
    }

    class JPanelGradient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(0, 153, 153);
            Color color2 = new Color(230, 190, 138);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);

        }

    }

    public ArrayList<ConcertInfo> userList() {
        ArrayList<ConcertInfo> userList = new ArrayList<>();

        try {
            String query = "select * from Concert_Registration";
            stm = conn.createStatement();
            rs = stm.executeQuery(query);
            ConcertInfo concert_info;

            while (rs.next()) {
                concert_info = new ConcertInfo(rs.getInt("id"), rs.getString("name"), rs.getString("location"),
                        rs.getString("category"), rs.getInt("ticket_price"), rs.getInt("ticket_quantity"),
                        rs.getString("C_Date"), rs.getString("ArtistNames"),
                        rs.getInt("S_id"), rs.getInt("M_id"));

                userList.add(concert_info);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTable_ConcertInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;

    }

    public void show_users() {
        ArrayList<ConcertInfo> list = userList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getCategory();
            row[4] = list.get(i).getTicket_Price();
            row[5] = list.get(i).getTicket_Quantity();
            row[6] = list.get(i).getC_date();
            row[7] = list.get(i).getArtistNames();
            row[8] = list.get(i).getS_id();
            row[9] = list.get(i).getM_id();

            model.addRow(row);
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
            Logger.getLogger(Admin_Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dBConnect1 = new concertmanagementsystem.DBConnect();
        jPanel1 = new JPanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SponsorInfo_Button = new javax.swing.JButton();
        AdminInfo_Button = new javax.swing.JButton();
        UserInfo_Button = new javax.swing.JButton();
        Admin_UserBuyHistory_Button = new javax.swing.JButton();
        Logout_Button = new javax.swing.JButton();
        ConcertInfo_Button = new concertmanagementsystem.DesignedButton();
        Admin_Registration_Button1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        search_field = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Welcome to admin page");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Concert_logo_resized.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 170, 130));

        SponsorInfo_Button.setBackground(new java.awt.Color(0, 153, 255));
        SponsorInfo_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SponsorInfo_Button.setText("Show Sponsor Info");
        SponsorInfo_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SponsorInfo_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(SponsorInfo_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 170, -1));

        AdminInfo_Button.setBackground(new java.awt.Color(0, 153, 255));
        AdminInfo_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AdminInfo_Button.setText("Show Admin Info");
        AdminInfo_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminInfo_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(AdminInfo_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, -1));

        UserInfo_Button.setBackground(new java.awt.Color(0, 153, 255));
        UserInfo_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserInfo_Button.setText("Show User Info");
        UserInfo_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserInfo_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(UserInfo_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 170, -1));

        Admin_UserBuyHistory_Button.setBackground(new java.awt.Color(0, 153, 255));
        Admin_UserBuyHistory_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Admin_UserBuyHistory_Button.setText("Users' Buy History");
        Admin_UserBuyHistory_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admin_UserBuyHistory_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(Admin_UserBuyHistory_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 170, -1));

        Logout_Button.setBackground(new java.awt.Color(230, 190, 138));
        Logout_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Logout_Button.setText("Log Out");
        Logout_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(Logout_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 170, -1));

        ConcertInfo_Button.setBackground(new java.awt.Color(153, 153, 255));
        ConcertInfo_Button.setText("Concert Registration");
        ConcertInfo_Button.setRadius(500);
        ConcertInfo_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConcertInfo_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(ConcertInfo_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, 60));

        Admin_Registration_Button1.setBackground(new java.awt.Color(0, 153, 255));
        Admin_Registration_Button1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Admin_Registration_Button1.setText("Registration");
        Admin_Registration_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Admin_Registration_Button1ActionPerformed(evt);
            }
        });
        jPanel2.add(Admin_Registration_Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Location", "Category", "Ticket Price", "Ticket Quantity", "Concert Date", "Sponsor ID", "Manager ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search for Concert");

        search_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_fieldActionPerformed(evt);
            }
        });
        search_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_fieldKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_field)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UserInfo_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserInfo_ButtonActionPerformed
        dispose();
        DBTable_User st = new DBTable_User();
        st.setVisible(true);
    }//GEN-LAST:event_UserInfo_ButtonActionPerformed

    private void Admin_UserBuyHistory_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admin_UserBuyHistory_ButtonActionPerformed
        dispose();
        DBTable_BuyingHistory po = new DBTable_BuyingHistory();
        po.setVisible(true);
    }//GEN-LAST:event_Admin_UserBuyHistory_ButtonActionPerformed

    private void Logout_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout_ButtonActionPerformed
        dispose();
        Log_In st = new Log_In();
        st.setVisible(true);
    }//GEN-LAST:event_Logout_ButtonActionPerformed

    private void AdminInfo_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminInfo_ButtonActionPerformed
        dispose();
        DBTable_Admin st = new DBTable_Admin();
        st.setVisible(true);
    }//GEN-LAST:event_AdminInfo_ButtonActionPerformed

    private void SponsorInfo_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SponsorInfo_ButtonActionPerformed
        dispose();
        DBTable_SponsorInfo st = new DBTable_SponsorInfo();
        st.setVisible(true);
    }//GEN-LAST:event_SponsorInfo_ButtonActionPerformed

    private void search_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_fieldActionPerformed

    private void search_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_fieldKeyReleased
        String searchString = search_field.getText();
        searchString.toUpperCase().equals(searchString.toLowerCase());
        search(searchString);
    }//GEN-LAST:event_search_fieldKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        search_field.setText("");
        search("");
        show_users();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ConcertInfo_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConcertInfo_ButtonActionPerformed
        dispose();
        ConcertInfo_Registration st = new ConcertInfo_Registration();
        st.setVisible(true);
    }//GEN-LAST:event_ConcertInfo_ButtonActionPerformed

    private void Admin_Registration_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Admin_Registration_Button1ActionPerformed
        dispose();
        Admin_Registration st = new Admin_Registration();
        st.setVisible(true);
    }//GEN-LAST:event_Admin_Registration_Button1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminInfo_Button;
    private javax.swing.JButton Admin_Registration_Button1;
    private javax.swing.JButton Admin_UserBuyHistory_Button;
    private concertmanagementsystem.DesignedButton ConcertInfo_Button;
    private javax.swing.JButton Logout_Button;
    private javax.swing.JButton SponsorInfo_Button;
    private javax.swing.JButton UserInfo_Button;
    private concertmanagementsystem.DBConnect dBConnect1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search_field;
    // End of variables declaration//GEN-END:variables
}
