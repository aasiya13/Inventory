/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.ui;

import inventory.Controller.CustomerController;
import inventory.Controller.InvoiceController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sithara
 */
public class ViewInventoryFrame extends javax.swing.JFrame {

    /**
     * Creates new form ViewInventoryFrame
     */
    public ViewInventoryFrame() {
        initComponents();
        init();
    }

    public void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        tableStyle(InvoiceTable);
        tableStyle(InventoryDetailTable);
        updateInvoiceTable();
        inventoryDetailTable();
    }

    public void close() {
        WindowEvent windowClosingEvnt = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvnt);
    }

    public void setInoviceTableHeader() {
        TableColumn col = InvoiceTable.getColumnModel().getColumn(0);
        col.setHeaderValue("Invoice ID");
        col.setPreferredWidth(100);
        TableColumn col2 = InvoiceTable.getColumnModel().getColumn(1);
        col2.setHeaderValue("Date");
        col2.setPreferredWidth(100);
        TableColumn col3 = InvoiceTable.getColumnModel().getColumn(2);
        col3.setHeaderValue("Total");
        col3.setPreferredWidth(100);
    }

    public void updateInvoiceTable() {
        try {
            ResultSet resultSet = InvoiceController.getInvoiceForInvoiceTable();
            InvoiceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setInoviceTableHeader();

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    public void inventoryDetailTable() {
        TableColumn col = InventoryDetailTable.getColumnModel().getColumn(0);
        col.setHeaderValue("Item ID");
        col.setPreferredWidth(30);
        TableColumn col2 = InventoryDetailTable.getColumnModel().getColumn(1);
        col2.setHeaderValue("Item Name");
        col2.setPreferredWidth(140);
        TableColumn col3 = InventoryDetailTable.getColumnModel().getColumn(2);
        col3.setHeaderValue("Qunatity");
        col3.setPreferredWidth(20);
        TableColumn col4 = InventoryDetailTable.getColumnModel().getColumn(3);
        col4.setHeaderValue("Unit Type");
        col4.setPreferredWidth(30);
        TableColumn col5 = InventoryDetailTable.getColumnModel().getColumn(4);
        col5.setHeaderValue("Price");
        col5.setPreferredWidth(40);
        TableColumn col6 = InventoryDetailTable.getColumnModel().getColumn(5);
        col6.setHeaderValue("Line Total");
        col6.setPreferredWidth(40);
    }

    public void tableStyle(JTable table) {
        JTableHeader tableheader = table.getTableHeader();
        Color headerBlue = new Color(0, 102, 153);
        tableheader.setBackground(headerBlue);
        tableheader.setForeground(Color.WHITE);
        tableheader.setFont(new Font("Tahoma", Font.BOLD, 14));
        ((DefaultTableCellRenderer) tableheader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LogOutBtn = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        CatMenuBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        CatMenuLbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InventoryDetailTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        invoiceIDTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FromTxt = new javax.swing.JFormattedTextField();
        ToTxt = new javax.swing.JFormattedTextField();
        SearchBtn = new javax.swing.JButton();
        ResetBtn1 = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View Invoice");

        LogOutBtn.setBackground(new java.awt.Color(0, 102, 153));
        LogOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/ui/img/logout.png"))); // NOI18N
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        HomeBtn.setBackground(new java.awt.Color(0, 102, 153));
        HomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/ui/img/Home.png"))); // NOI18N
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        CatMenuBtn.setBackground(new java.awt.Color(0, 102, 153));
        CatMenuBtn.setIcon(new javax.swing.ImageIcon("D:\\Mine\\Java\\Inventory\\Inventory\\src\\inventory\\ui\\img\\back32.png")); // NOI18N
        CatMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CatMenuBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CatMenuBtnMouseExited(evt);
            }
        });
        CatMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatMenuBtnActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));

        CatMenuLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CatMenuLbl.setForeground(new java.awt.Color(0, 51, 102));
        CatMenuLbl.setText("cc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(CatMenuLbl)
                        .addGap(49, 49, 49)))
                .addComponent(CatMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogOutBtn)
                    .addComponent(HomeBtn)
                    .addComponent(CatMenuBtn)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel19)
                        .addComponent(CatMenuLbl)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        InventoryDetailTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InventoryDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(InventoryDetailTable);

        InvoiceTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        InvoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InvoiceTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(InvoiceTable);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("INV");

        invoiceIDTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        invoiceIDTxt.setToolTipText("XXX");
        invoiceIDTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invoiceIDTxtKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("From");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("To");

        try {
            FromTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        FromTxt.setToolTipText("YYYY-MM-DD");
        FromTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        try {
            ToTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ToTxt.setToolTipText("YYYY-MM-DD");
        ToTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        SearchBtn.setBackground(new java.awt.Color(0, 102, 153));
        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/ui/img/search24.png"))); // NOI18N
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        ResetBtn1.setBackground(new java.awt.Color(0, 102, 153));
        ResetBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResetBtn1.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn1.setText("Clear");
        ResetBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invoiceIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(FromTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ToTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ResetBtn1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(invoiceIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(ToTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FromTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ResetBtn1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ResetBtn.setBackground(new java.awt.Color(0, 102, 153));
        ResetBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResetBtn))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ResetBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        // TODO add your handling code here:
        try {
            close();
            new LogInForm().setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            //            try {
            //              //  resultSet.close();
            //              //  pst.close();
            //              //Connection connection = DbConnection.getInstance().getConnection();
            //              //connection.close();
            //            } catch (ClassNotFoundException | SQLException e) {
            //                JOptionPane.showMessageDialog(rootPane, e);
            //            }
        }
    }//GEN-LAST:event_LogOutBtnActionPerformed

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        // TODO add your handling code here:
        try {
            close();
            new MainFrame().setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                //  resultSet.close();
                //  pst.close();
                //  connection.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void CatMenuBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CatMenuBtnMouseEntered
        // TODO add your handling code here:
        CatMenuLbl.setText("Category Menu");
        CatMenuLbl.setForeground(Color.WHITE);
    }//GEN-LAST:event_CatMenuBtnMouseEntered

    private void CatMenuBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CatMenuBtnMouseExited
        // TODO add your handling code here:
        CatMenuLbl.setText(null);
    }//GEN-LAST:event_CatMenuBtnMouseExited

    private void CatMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatMenuBtnActionPerformed
        // TODO add your handling code here:
        try {
            close();
            new CategoryMenu().setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } finally {
            try {
                //  resultSet.close();
                //  pst.close();
                //  connection.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_CatMenuBtnActionPerformed

    private void InvoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvoiceTableMouseClicked
        try {
            // TODO add your handling code here:
            int row = InvoiceTable.getSelectedRow();
            String invoiceId = InvoiceTable.getModel().getValueAt(row, 0).toString();

            ResultSet resultSet = InvoiceController.getInvoiceDetailsByInvoiceId(invoiceId);
            InventoryDetailTable.setModel(DbUtils.resultSetToTableModel(resultSet));

            inventoryDetailTable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewInventoryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_InvoiceTableMouseClicked

    private void invoiceIDTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceIDTxtKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String itemSearch = "INV" + invoiceIDTxt.getText();

            ResultSet resultSet = InvoiceController.getInvoiceByInvoiceId(itemSearch);
            InvoiceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setInoviceTableHeader();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_invoiceIDTxtKeyReleased

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        updateInvoiceTable();
        setInoviceTableHeader();
        invoiceIDTxt.setText(null);
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        try {
            // TODO add your handling code here:
            String fromDate = FromTxt.getText();
            String toDate = ToTxt.getText();

            ResultSet resultSet = InvoiceController.getInvoiceByDateRange(fromDate, toDate);

            System.out.println("from : " + fromDate + "toDate : " + toDate);
            InvoiceTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setInoviceTableHeader();
            if(InvoiceTable.getRowCount() == 0){
                JOptionPane.showMessageDialog(rootPane, "No Records Found..");
            }
            

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewInventoryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void ResetBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtn1ActionPerformed
        // TODO add your handling code here:
        FromTxt.setText(null);
        ToTxt.setText(null);
    }//GEN-LAST:event_ResetBtn1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewInventoryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CatMenuBtn;
    private javax.swing.JLabel CatMenuLbl;
    private javax.swing.JFormattedTextField FromTxt;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTable InventoryDetailTable;
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton ResetBtn1;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JFormattedTextField ToTxt;
    private javax.swing.JTextField invoiceIDTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}