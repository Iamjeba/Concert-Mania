package concertmanagementsystem;

import com.sun.imageio.plugins.png.RowFilter;
import static concertmanagementsystem.Log_In.txtPass;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class UserHomePage extends javax.swing.JFrame {

    //SearchQuery
    private void search(String str1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter((javax.swing.RowFilter.regexFilter("(?i)" + str1)));
    }

    public UserHomePage() {
        initComponents();
        Connect();
        show_users();
    }

    private void UserProfile(String email, String pin) {
        DBConnect dbc = new DBConnect();
        Connection conn = null;

        try {
            conn = dbc.connectToDB();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserHomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserHomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "Select * from signup where email=? AND pin=?";
        try {
            pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pin);
            ResultSet res = pst.executeQuery();

            // ImageIcon icon = new ImageIcon(filename);
            while (res.next()) {

                String img = res.getString("images");
                ImageIcon icon = new ImageIcon(img);
                UserProfile.profilePic_Lebel.setIcon(icon);

                UserProfile.jTextField3.setText(res.getString("id"));
                UserProfile.jTextField4.setText(res.getString("name"));
                UserProfile.jTextField5.setText(res.getString("gender"));
                UserProfile.jTextField6.setText(res.getString("nid"));
                UserProfile.jTextField7.setText(res.getString("phn"));
                UserProfile.jTextField8.setText(res.getString("dob"));
                UserProfile.jTextField9.setText(res.getString("health"));

            }
            //Image img1 = Toolkit.getDefaultToolkit().createImage(img);
            //ImageIcon icon = new ImageIcon(img1);
            // JLabel lPhoto = new JLabel();
            // UserProfile.profilePic_Lebel.setIcon(icon);
            //add(UserProfile.profilePic_Lebel);

        } catch (SQLException ex) {
            Logger.getLogger(Log_In.class.getName()).log(Level.SEVERE, null, ex);
        }
        // setVisible(true);
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
                        rs.getString("C_Date"), rs.getString("ArtistNames"),rs.getInt("S_id"), rs.getInt("M_id"));

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
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getLocation();
            row[3] = list.get(i).getCategory();
            row[4] = list.get(i).getTicket_Price();
            row[5] = list.get(i).getTicket_Quantity();
            row[6] = list.get(i).getC_date();

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

        jPanel1 = new JPanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LogOutButton = new javax.swing.JButton();
        profile_btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        search_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Welcome to Home page of Concert Mania");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 460, 50));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Concert_logo_resized.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 170, 130));

        LogOutButton.setBackground(new java.awt.Color(230, 190, 138));
        LogOutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LogOutButton.setText("Log Out");
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });
        jPanel2.add(LogOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 170, 30));

        profile_btn.setBackground(new java.awt.Color(0, 153, 255));
        profile_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profile_btn.setText("Profile");
        profile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_btnActionPerformed(evt);
            }
        });
        jPanel2.add(profile_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 170, 30));

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Buy Ticket");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 170, 30));

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Helpline");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 520));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search for Concert");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 130, 30));

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
        jPanel1.add(search_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 270, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Location", "Category", "Ticket Price", " Remaining Tickets", "Concert Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 870, 360));

        reset.setBackground(new java.awt.Color(0, 102, 102));
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
        dispose();
        Log_In st = new Log_In();
        st.setVisible(true);
    }//GEN-LAST:event_LogOutButtonActionPerformed

    private void search_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_fieldActionPerformed

    }//GEN-LAST:event_search_fieldActionPerformed

    private void search_fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_fieldKeyReleased
        String searchString = search_field.getText();
        searchString.toUpperCase().equals(searchString.toLowerCase());
        search(searchString);
    }//GEN-LAST:event_search_fieldKeyReleased

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        search_field.setText("");
        search("");
        show_users();

    }//GEN-LAST:event_resetActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        BuyTicket po = new BuyTicket();
        po.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    public UserHomePage(String msg) throws SQLException {
        initComponents();
        jLabel1.setText(msg);
    }

    private void profile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_btnActionPerformed

        dispose();
        UserProfile up = new UserProfile();
        String email = Log_In.txtEmail.getText();
        UserProfile.jTextField1.setText(email);
        String pin = String.valueOf(txtPass.getPassword());
        UserProfile.jTextField2.setText(pin);
        UserProfile(email, pin);
        up.setVisible(true);
    }//GEN-LAST:event_profile_btnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
        User_Helpline hp = new User_Helpline();
        hp.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    BuyTicket jtRowData=new BuyTicket();
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        int i=jTable1.getSelectedRow();
        TableModel model= jTable1.getModel();
//        jtRowData.txt_CID.setText(model.getValueAt(i,0).toString());
//        jtRowData.txt_CName.setText(model.getValueAt(i,1).toString());
        jtRowData.jComboBox_CName.setSelectedItem(model.getValueAt(i,1).toString());
        jtRowData.txt_Tktprice.setText(model.getValueAt(i,4).toString());
        
        dispose();
        jtRowData.setVisible(true);

    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(UserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOutButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JButton profile_btn;
    private javax.swing.JButton reset;
    private javax.swing.JTextField search_field;
    // End of variables declaration//GEN-END:variables
}
