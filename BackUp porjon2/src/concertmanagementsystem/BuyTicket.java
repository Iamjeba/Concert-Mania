package concertmanagementsystem;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BuyTicket extends javax.swing.JFrame {

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

    public BuyTicket() {
        initComponents();
        Connect();
        updateComboCname();
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
            Logger.getLogger(Log_In.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Log_In.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    
    public void updateComboCname() {
        String query = "select * from Concert_Registration";
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                jComboBox_CName.addItem(rs.getString("name"));
            }
        } catch (Exception e) {

        }
    }

    //private void initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanelGradient();
        txt_TotAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        AddToCart_Button = new javax.swing.JButton();
        Delete_Button = new javax.swing.JButton();
        GenerateBill_Button = new javax.swing.JButton();
        Confirm_Button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinner_TQuantity = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txt_Tktprice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_Amnt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBill = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Print_Button = new javax.swing.JButton();
        jComboBox_CName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txt_TotAmount.setEditable(false);
        txt_TotAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TotAmountActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Total Amount to pay");

        AddToCart_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddToCart_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add to cart.png"))); // NOI18N
        AddToCart_Button.setText("Add to Cart");
        AddToCart_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToCart_ButtonActionPerformed(evt);
            }
        });

        Delete_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Delete_Button.setText("Delete");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });

        GenerateBill_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GenerateBill_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/generate bill & print.png"))); // NOI18N
        GenerateBill_Button.setText("Generate Bill");
        GenerateBill_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBill_ButtonActionPerformed(evt);
            }
        });

        Confirm_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Confirm_Button.setText("Confirm");
        Confirm_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirm_ButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Concert Name");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Quantity");

        jSpinner_TQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));
        jSpinner_TQuantity.setRequestFocusEnabled(false);
        jSpinner_TQuantity.setValue(0);
        jSpinner_TQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_TQuantityStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ticket Price");

        txt_Tktprice.setEditable(false);
        txt_Tktprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TktpriceActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Amount");

        txt_Amnt.setEditable(false);
        txt_Amnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AmntActionPerformed(evt);
            }
        });

        txtBill.setEditable(false);
        txtBill.setColumns(6);
        txtBill.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtBill.setRows(5);
        txtBill.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBill.setMinimumSize(new java.awt.Dimension(200, 400));
        txtBill.setPreferredSize(new java.awt.Dimension(500, 500));
        jScrollPane1.setViewportView(txtBill);

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Concert Name", "Quantity", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(BillTable);
        if (BillTable.getColumnModel().getColumnCount() > 0) {
            BillTable.getColumnModel().getColumn(0).setResizable(false);
            BillTable.getColumnModel().getColumn(1).setResizable(false);
            BillTable.getColumnModel().getColumn(2).setResizable(false);
            BillTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/place order.png"))); // NOI18N
        jLabel1.setText("Buy Ticket");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close.png"))); // NOI18N
        jButton4.setText("Back to Home Page");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Print_Button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Print_Button.setText("Print");
        Print_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_ButtonActionPerformed(evt);
            }
        });

        jComboBox_CName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Selected" }));
        jComboBox_CName.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox_CNamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Tktprice)
                    .addComponent(jSpinner_TQuantity)
                    .addComponent(txt_Amnt, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_CName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_TotAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(AddToCart_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Delete_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GenerateBill_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Confirm_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Print_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_CName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner_TQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Tktprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Amnt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddToCart_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerateBill_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Confirm_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_TotAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Print_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: - Back to HomePage Button
        dispose();
        UserHomePage uhp = new UserHomePage();
        uhp.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_AmntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AmntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AmntActionPerformed

    //amount button select
    private void jSpinner_TQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_TQuantityStateChanged
        // TODO add your handling code here:
        //txtAmnt.setText("");

        int qty = Integer.parseInt(jSpinner_TQuantity.getValue().toString());
        int price = Integer.parseInt(txt_Tktprice.getText());

        int tot = qty * price;
        txt_Amnt.setText(String.valueOf(tot));

    }//GEN-LAST:event_jSpinner_TQuantityStateChanged

    /*public void Balance(){
         int TOTAL = Integer.parseInt(txtTot.getText());
        int PAY = Integer.parseInt(txtPay.getText());
        
        int bal = PAY - TOTAL;
        
        txtBal.setText(String.valueOf(bal));
    }*/
    //AddToCart Button Pressed: 
    private void AddToCart_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToCart_ButtonActionPerformed

        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) BillTable.getModel();

        try {
            if (jComboBox_CName.getSelectedItem().equals("") || jSpinner_TQuantity.getValue().toString().equals("0")
                    || txt_Tktprice.getText().equals("") || txt_Amnt.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All informations is not given");
            } else {
                model.addRow(new Object[]{
                    jComboBox_CName.getSelectedItem(),
                    jSpinner_TQuantity.getValue().toString(),
                    txt_Tktprice.getText(),
                    txt_Amnt.getText(),});

                int sum = 0;
                for (int i = 0; i < BillTable.getRowCount(); i++) {
                    sum = sum + Integer.parseInt(BillTable.getValueAt(i, 3).toString());
                }
                txt_TotAmount.setText(Integer.toString(sum));
            }

        } catch (Exception e) {
        }

        int defaultvalue = 0;
        jSpinner_TQuantity.setValue(Integer.valueOf(defaultvalue));

//        txt_CID.setText("");
//        txt_CName.setText("");
//        txt_Tktprice.setText("");
//        txt_Amnt.setText("");

    }//GEN-LAST:event_AddToCart_ButtonActionPerformed

    public void bill() {
        int TotalAmountToPay = Integer.parseInt(txt_TotAmount.getText());
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) BillTable.getModel();

        txtBill.setText(txtBill.getText() + "\n");
        txtBill.setText(txtBill.getText() + "**********************************************************\n");
        txtBill.setText(txtBill.getText() + "*                    Concert Mania                        *\n");
        txtBill.setText(txtBill.getText() + "*                      Bill Info                          *\n");
        txtBill.setText(txtBill.getText() + "**********************************************************\n");
        txtBill.setText(txtBill.getText() + "\n");
        txtBill.setText(txtBill.getText() + "Item\t" + "Concert Name\t" + "Quantity   " + "Price     " + "Total Price\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            int ItemNo = (i + 1);
            String Cname = (String) model.getValueAt(i, 0);
            String Cquantity = (String) model.getValueAt(i, 1);
            String Cprice = (String) model.getValueAt(i, 2);
            String Camt = (String) model.getValueAt(i, 3);

            txtBill.setText(txtBill.getText() + " " + ItemNo + "\t" + Cname + "\t  "
                    + Cquantity + "\t   " + Cprice + ".00      " + Camt + ".00\n");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        txtBill.setText(txtBill.getText() + "\n\n" + "Total Ticket Price: " + TotalAmountToPay + ".00 tk"
                + "\nDate: " + formatter.format(date)
                + "\n\nN.B.:"
                + "\n1. You will get 50% money back if you want to return"
                + "\n2. Press 'Confirm' to confirm your purchase."
        );

        int defaultvalue = 0;
        jSpinner_TQuantity.setValue(Integer.valueOf(defaultvalue));

        jComboBox_CName.setSelectedItem("");
        txt_Tktprice.setText("");
    }

    //Generate bill
    private void GenerateBill_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBill_ButtonActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) BillTable.getModel();

        if (BillTable.getRowCount() > 0) {
            txtBill.setText("");
            bill();
        } else {
            JOptionPane.showMessageDialog(this, "All informations is not given");
        }
    }//GEN-LAST:event_GenerateBill_ButtonActionPerformed

    private void txt_TotAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TotAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TotAmountActionPerformed

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) BillTable.getModel();

        if (BillTable.getSelectedRowCount() == 1) {
            model.removeRow(BillTable.getSelectedRow());
        } else {
            if (BillTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");//if table is empty (no data) than display message
            } else {
                JOptionPane.showMessageDialog(this, "Please select any row for delete"); //if table is not empty or multiple row is selected
            }
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void Confirm_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirm_ButtonActionPerformed
        //Confirm Button -> Values into DB with User Id and name

        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) BillTable.getModel();
        int New_UserID, New_Ticket_Quantity, Prev_Ticket_Quantity, haveTickets, updatedTicketQuantity;
        New_UserID = New_Ticket_Quantity = Prev_Ticket_Quantity = haveTickets = updatedTicketQuantity = 0;
        String User_id, User_name, query, Log_In_Email, Log_In_pin, New_UserName, HaveTickets;                                        //Info that will be saved in Database -> User_id, User_name
        User_id = User_name = New_UserName = "";
        String Concert_ticket_quantity, ticket_quantity;
        String CID, Cname, Tquantity, Tprice, Tamt, BuyingTime, Method;
        Log_In_Email = Log_In_pin = CID = Cname = Tquantity = Tprice = Tamt = BuyingTime
                = Method = ticket_quantity = Concert_ticket_quantity = HaveTickets = "";

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Table is Empty");
        } else {
            try {
                //Display Data from DB
                try {
                    Log_In_Email = Log_In.txtEmail.getText();
                    Log_In_pin = String.valueOf(Log_In.txtPass.getPassword());
                    System.out.println("\nUser Email: " + Log_In_Email + "\nUser Password: " + Log_In_pin);
                    query = "select * from signup where email='" + Log_In_Email + "'AND pin='" + Log_In_pin + "'";
                    System.out.println(query);                                                      //Check -> printing query
                    stm = conn.createStatement();
                    rs = stm.executeQuery(query);

                    while (rs.next()) {
                        User_id = rs.getString("id");
                        User_name = rs.getString("name");
                        System.out.println("\nAfter Sign In   " + "User ID: " + User_id + " User Name: " + User_name);
                    }
                    stm.close();
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(this, "Please log in first");//if table is empty (no data) than display message
                }

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                formatter.format(date);

                for (int i = 0; i < model.getRowCount(); i++) {
                    Cname = (String) model.getValueAt(i, 0);
                    Tquantity = (String) model.getValueAt(i, 1);
                    Tprice = (String) model.getValueAt(i, 2);
                    Tamt = (String) model.getValueAt(i, 3);
                    BuyingTime = formatter.format(date);

                    //select CID From concert name(Cname)
                    query = "select * from Concert_Registration where name='" + Cname + "'";
                    System.out.println(query);                                                      //Check -> printing query
                    stm = conn.createStatement();
                    rs = stm.executeQuery(query);
                    System.out.println(stm + " and " + rs);
                    while (rs.next()) {
                        CID = rs.getString("id");
                        Cname = rs.getString("name");
                        System.out.println("\nGetting Concert ID \n" + "Concert ID: " + CID + " User Name: " + Cname);
                    }

                    if (User_id == "" || User_name == "" || CID == "" || Cname == "" || Tquantity == "" || Tprice == "" || Tamt == "" || BuyingTime == "") {
                        JOptionPane.showMessageDialog(this, "User's ticket information is not added");
                    } else {

                        System.out.println("check if less than 10 or not");
//                        query = "SELECT User_id FROM Concert_Registration_User where User_id='"+User_id+"' AND Tquantity <= 10";
                        query = "SELECT * FROM Concert_Registration_User where User_id='" + User_id + "'";

                        System.out.println(query);
                        stm = conn.createStatement();
                        rs = stm.executeQuery(query);
                        int Prev_User_ID = Integer.parseInt(User_id);               //logged in UserID
                        System.out.println("Logged In User ID : " + Prev_User_ID);

                        if (rs.next()) {

                            //For old user -> Buying ticket
                            New_UserID = Integer.parseInt(rs.getString("User_id"));
                            System.out.println("New_UserID : " + New_UserID);

                            query = "SELECT * FROM Concert_Registration_User where User_id='" + User_id + "' AND Cname ='" + Cname + "'";

                            System.out.println(query);
                            stm = conn.createStatement();
                            rs = stm.executeQuery(query);

                            while (rs.next()) {
                                Prev_Ticket_Quantity = Prev_Ticket_Quantity + Integer.parseInt(rs.getString("Tquantity"));

//                                while (rs.next()) {
//                                    HaveTickets = rs.getString("HaveTickets");
//                                }
                            }
                            
                            New_Ticket_Quantity = Integer.parseInt(Tquantity);
                            System.out.println("Prev_Ticket_Quantity: " + Prev_Ticket_Quantity);
                            System.out.println("New_Ticket_Quantity: " + New_Ticket_Quantity);
                            updatedTicketQuantity = New_Ticket_Quantity + Prev_Ticket_Quantity;
//                            haveTickets = Integer.parseInt(HaveTickets);
                                    
                            if (updatedTicketQuantity > 10) {
                                JOptionPane.showMessageDialog(this, "User can't buy more than 10 tickets from " + Cname);
                            } else {
//                                updatedTicketQuantity = New_Ticket_Quantity + Prev_Ticket_Quantity;
                                Method = "Buy";
                                haveTickets = updatedTicketQuantity;            //updating haveTickets
                                HaveTickets = Integer.toString(haveTickets);

                                System.out.println("User have " + HaveTickets + " from " + Cname);
                                System.out.println("User have " + haveTickets + " from " + Cname);

                                query = "Insert into Concert_Registration_User(User_id,User_name,CID,Cname,Tquantity,Tprice,Tamt,BuyingTime,Method,HaveTickets) values(?,?,?,?,?,?,?,?,?,?)";

                                pst = (PreparedStatement) conn.prepareStatement(query);

                                pst.setString(1, User_id);
                                pst.setString(2, User_name);
                                pst.setString(3, CID);
                                pst.setString(4, Cname);
                                pst.setString(5, Tquantity);
                                pst.setString(6, Tprice);
                                pst.setString(7, Tamt);
                                pst.setString(8, BuyingTime);
                                pst.setString(9, Method);
                                pst.setString(10, HaveTickets);

                                System.out.println("\nInserting Into Concert_Registration_User -> ");
                                System.out.print(User_id + " " + User_name + " " + CID + " " + Cname + " " + Tquantity + " " + Tprice + " " + Tamt + " " + BuyingTime + "\n");
                                JOptionPane.showMessageDialog(this, "User's ticket information is added");
                                pst.execute();

                                //Update Concert Table
                                query = "select * from Concert_Registration where id='" + CID + "'AND name='" + Cname + "'";
                                System.out.println(query);                                                      //Check -> printing query
                                stm = conn.createStatement();
                                rs = stm.executeQuery(query);

                                System.out.println(stm + " and " + rs);

                                while (rs.next()) {
                                    Concert_ticket_quantity = rs.getString("ticket_quantity");
//                    User_name = rs.getString("name");
                                    int quantity = Integer.parseInt(Concert_ticket_quantity) - Integer.parseInt(Tquantity);
//                    Concert_ticket_quantity = Integer.toString(quantity);
                                    ticket_quantity = Integer.toString(quantity);

                                    System.out.println("\nAfter Ticket Registration Tickets Remaining: " + Concert_ticket_quantity);
                                }
//                stm.close();
                                query = "update Concert_Registration set ticket_quantity=? where id=?";
                                try {
                                    System.out.println(query);

                                    if (User_id == "" || User_name == "") {
                                        JOptionPane.showMessageDialog(this, "Concert Registration Table is not updated");
                                    } else {
                                        pst = (PreparedStatement) conn.prepareStatement(query);
                                        pst.setString(1, ticket_quantity);
                                        pst.setString(2, CID);
                                        pst.executeUpdate();
                                        JOptionPane.showMessageDialog(this, "Concert Registration Table is updated");
                                    }
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(this, "Concert Registration Table is not updated");
                                }
                            }
                        } else {
                            //For new user -> Buying ticket
                            System.out.println("User ID do not exist");

                            Method = "Buy";
                            haveTickets = updatedTicketQuantity;            //updating haveTickets
                            HaveTickets = Integer.toString(haveTickets);

                            System.out.println("User have " + HaveTickets + " from " + Cname);
                            System.out.println("User have " + haveTickets + " from " + Cname);

                            query = "Insert into Concert_Registration_User(User_id,User_name,CID,Cname,Tquantity,Tprice,Tamt,BuyingTime,Method,HaveTickets) values(?,?,?,?,?,?,?,?,?,?)";

                            pst = (PreparedStatement) conn.prepareStatement(query);

                            pst.setString(1, User_id);
                            pst.setString(2, User_name);
                            pst.setString(3, CID);
                            pst.setString(4, Cname);
                            pst.setString(5, Tquantity);
                            pst.setString(6, Tprice);
                            pst.setString(7, Tamt);
                            pst.setString(8, BuyingTime);
                            pst.setString(9, Method);
                            pst.setString(10, HaveTickets);

                            System.out.println("\nInserting Into Concert_Registration_User -> ");
                            System.out.print(User_id + " " + User_name + " " + CID + " " + Cname + " " + Tquantity + " " + Tprice + " " + Tamt + " " + BuyingTime + "\n");
                            JOptionPane.showMessageDialog(this, "User's ticket information is added");
                            pst.execute();

                            //Update Concert Table
                            query = "select * from Concert_Registration where id='" + CID + "'AND name='" + Cname + "'";
                            System.out.println(query);                                                      //Check -> printing query
                            stm = conn.createStatement();
                            rs = stm.executeQuery(query);

                            System.out.println(stm + " and " + rs);

                            while (rs.next()) {
                                Concert_ticket_quantity = rs.getString("ticket_quantity");
//                    User_name = rs.getString("name");
                                int quantity = Integer.parseInt(Concert_ticket_quantity) - Integer.parseInt(Tquantity);
//                    Concert_ticket_quantity = Integer.toString(quantity);
                                ticket_quantity = Integer.toString(quantity);

                                System.out.println("\nAfter Ticket Registration Tickets Remaining: " + Concert_ticket_quantity);
                            }
//                stm.close();
                            query = "update Concert_Registration set ticket_quantity=? where id=?";
                            try {
                                System.out.println(query);

                                if (User_id == "" || User_name == "") {
                                    JOptionPane.showMessageDialog(this, "Concert Registration Table is not updated");
                                } else {
                                    pst = (PreparedStatement) conn.prepareStatement(query);
                                    pst.setString(1, ticket_quantity);
                                    pst.setString(2, CID);
                                    pst.executeUpdate();
                                    JOptionPane.showMessageDialog(this, "Concert Registration Table is updated");
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(this, "Concert Registration Table is not updated");
                            }

                            JOptionPane.showMessageDialog(this, "Thank you for purchasing from us. Be with Concert Mania!!");
                        }

                    }
                    New_UserID = New_Ticket_Quantity = Prev_Ticket_Quantity = haveTickets = updatedTicketQuantity = 0;
                }
                model.setRowCount(0);                                           //Clear all the rows in table

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error in the table");
            }
        }
    }//GEN-LAST:event_Confirm_ButtonActionPerformed

    private void Print_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_ButtonActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.PORTRAIT);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(1.2, 1.2);

                txtBill.print(g2);

                return Printable.PAGE_EXISTS;

            }

        });
        boolean ok = job.printDialog();
        if (ok) {
            try {

                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_Print_ButtonActionPerformed

    private void txt_TktpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TktpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TktpriceActionPerformed

    private void jComboBox_CNamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox_CNamePopupMenuWillBecomeInvisible

        String SelectedName = jComboBox_CName.getSelectedItem().toString();
        if (SelectedName == "Not Selected") {
            txt_Tktprice.setText(" ");
        } else {
            String query = "select * from Concert_Registration where name = ?";
            try {
                pst = conn.prepareStatement(query);
                pst.setString(1, SelectedName);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String Price = rs.getString("ticket_price");
//                System.out.println("Price of ticket: " + Price);
                    txt_Tktprice.setText(Price);
                }
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Can not find concert name");
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_CNamePopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(BuyTicket.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyTicket.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyTicket.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyTicket.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToCart_Button;
    private javax.swing.JTable BillTable;
    private javax.swing.JButton Confirm_Button;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JButton GenerateBill_Button;
    private javax.swing.JButton Print_Button;
    private javax.swing.JButton jButton4;
    public static javax.swing.JComboBox<String> jComboBox_CName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner_TQuantity;
    private javax.swing.JTextArea txtBill;
    private javax.swing.JTextField txt_Amnt;
    public static javax.swing.JTextField txt_Tktprice;
    private javax.swing.JTextField txt_TotAmount;
    // End of variables declaration//GEN-END:variables

}
