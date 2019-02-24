/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.ui;

import inventory.Controller.InvoiceController;
import inventory.Controller.ItemController;
import inventory.Controller.PurchaseOrderController;
import inventory.models.Invoice;
import static inventory.ui.LoyaltyCards.CURRENTTOTAL;
import static inventory.ui.LoyaltyCards.CUSTOMERID;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sithara
 */
public class InvoiceFrame extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceFrame
     */
    private double total = 0.0;
    public String netTotal = "";
    public String invId = "";

    public InvoiceFrame() throws SQLException, ClassNotFoundException, Exception {
        initComponents();
        init();
        
    }

    public void init() throws SQLException, ClassNotFoundException, Exception {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        tableStyle(ItemTable);
        tableStyle(OrderTable);
        updateOrderTableInfoTable();
        updateItemTableInfoTable();
        getValesToComboBox(CategoryCombo, ItemController.getAllCategories());
        getDate();
        invoiceId();
    }

    public void close() {
        WindowEvent windowClosingEvnt = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvnt);
    }
    
    public void getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        DateTxt.setText(dateFormat.format(cal.getTime()));     
    }
    
    public void invoiceId() throws SQLException, ClassNotFoundException{
        String invceId = InvoiceController.getInvoiceId();
        this.invId = invceId;
        InoviceNumber.setText(invceId);
        jTextField7.setText(invceId);
    }

    public void tableStyle(JTable table) {
        JTableHeader tableheader = table.getTableHeader();
        Color headerBlue = new Color(0, 102, 153);
        tableheader.setBackground(headerBlue);
        tableheader.setForeground(Color.WHITE);
        tableheader.setFont(new Font("Tahoma", Font.BOLD, 14));
        ((DefaultTableCellRenderer) tableheader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    public void updateItemTableInfoTable() throws Exception {

        ResultSet resultSet = PurchaseOrderController.getInfoForItemTable();
        ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        setColumnHeaderItemtable();

    }

    public void setColumnHeaderItemtable() {
        TableColumn col = ItemTable.getColumnModel().getColumn(0);
        col.setHeaderValue("Item");
        col.setPreferredWidth(150);
        TableColumn col2 = ItemTable.getColumnModel().getColumn(1);
        col2.setHeaderValue("Item ID");
        col2.setPreferredWidth(50);
        TableColumn col4 = ItemTable.getColumnModel().getColumn(2);
        col4.setHeaderValue("Quantity");
        col4.setPreferredWidth(30);
        TableColumn col3 = ItemTable.getColumnModel().getColumn(3);
        col3.setHeaderValue("Selling Price");
        col3.setPreferredWidth(40);
    }

    public void updateOrderTableInfoTable() {
        //  try {
        //    ResultSet resultSet = PurchaseOrderController.getInfoForItemTable();
        //    ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        TableColumn col = OrderTable.getColumnModel().getColumn(0);
        col.setHeaderValue("Item Name");
        col.setPreferredWidth(150);
        TableColumn col1 = OrderTable.getColumnModel().getColumn(1);
        col1.setHeaderValue("ItemId");
        col1.setPreferredWidth(25);
        TableColumn col2 = OrderTable.getColumnModel().getColumn(2);
        col2.setHeaderValue("Quantitiy");
        col2.setPreferredWidth(25);
        TableColumn col4 = OrderTable.getColumnModel().getColumn(3);
        col4.setHeaderValue("Unit Type");
        col4.setPreferredWidth(25);
        TableColumn col3 = OrderTable.getColumnModel().getColumn(4);
        col3.setHeaderValue("Price");
        col3.setPreferredWidth(50);
        TableColumn col5 = OrderTable.getColumnModel().getColumn(5);
        col5.setHeaderValue("Line Total");
        col5.setPreferredWidth(50);
//        } catch (ClassNotFoundException | SQLException e) {
//            JOptionPane.showMessageDialog(rootPane, e);
//        }
    }

    private void getValesToComboBox(JComboBox combo, ArrayList<String> list) throws SQLException, ClassNotFoundException {
        // ArrayList<String> list = UserController.getAllEmployee();
        for (String val : list) {
            combo.addItem(val);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LogOutBtn = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        CatMenuBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        CatMenuLbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        DateTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        InoviceNumber = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        SubCategoryCombo = new javax.swing.JComboBox<>();
        CategoryCombo = new javax.swing.JComboBox<>();
        ResetBtn1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        itemSearchTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        AddOrderBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        QuantitiyTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        OrderDeleteBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        SubTotalTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DiscountTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        NetTotalTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        noDiscount = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        PercentRadio = new javax.swing.JRadioButton();
        LKRRadio = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        rcvdTxt = new javax.swing.JTextField();
        NetAmountTxt = new javax.swing.JTextField();
        blncTxt = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        CashCheck = new javax.swing.JCheckBox();
        CardCheck = new javax.swing.JCheckBox();
        ClearBtn1 = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        loyaltyCardBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory Management");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Invoice Number");

        DateTxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Date");

        InoviceNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InoviceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InoviceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("ItemCode");

        SubCategoryCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubCategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Sub Category" }));
        SubCategoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategoryComboActionPerformed(evt);
            }
        });

        CategoryCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        CategoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryComboActionPerformed(evt);
            }
        });

        ResetBtn1.setBackground(new java.awt.Color(0, 51, 102));
        ResetBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResetBtn1.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn1.setText("Reset");
        ResetBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtn1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("IT");

        itemSearchTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemSearchTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(itemSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(CategoryCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56)
                        .addComponent(SubCategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addComponent(ResetBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel22)
                    .addComponent(itemSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubCategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ItemTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ItemTable.setShowHorizontalLines(false);
        ItemTable.setShowVerticalLines(false);
        ItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ItemTable);

        AddOrderBtn.setBackground(new java.awt.Color(0, 51, 102));
        AddOrderBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddOrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddOrderBtn.setText("Add");
        AddOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrderBtnActionPerformed(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(0, 51, 102));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        QuantitiyTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Quantitiy");

        OrderDeleteBtn.setBackground(new java.awt.Color(0, 51, 102));
        OrderDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OrderDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderDeleteBtn.setText("Delete");
        OrderDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderDeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(QuantitiyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OrderDeleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantitiyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ClearBtn)
                    .addComponent(AddOrderBtn)
                    .addComponent(OrderDeleteBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Discount", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Sub Total");

        SubTotalTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Discount ");

        DiscountTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DiscountTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DiscountTxtKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Net Total");

        NetTotalTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("LKR");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("LKR");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        noDiscount.setBackground(new java.awt.Color(0, 102, 153));
        noDiscount.setForeground(new java.awt.Color(255, 255, 255));
        noDiscount.setText("NODsicount");
        noDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noDiscountActionPerformed(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(0, 102, 153));
        ResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn.setText("ReSet");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(PercentRadio);
        PercentRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PercentRadio.setText("%");
        PercentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PercentRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(LKRRadio);
        LKRRadio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LKRRadio.setText("LKR");
        LKRRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LKRRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel7)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SubTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiscountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NetTotalTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ResetBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(PercentRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LKRRadio))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12)
                    .addComponent(noDiscount)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PercentRadio)
                                    .addComponent(LKRRadio))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(DiscountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NetTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ResetBtn)
                            .addComponent(noDiscount))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 153));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Invoice Payment");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Invoice No.");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Net Amount");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Recieved Amount");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Cash Amount");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Balance Amount");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Bank");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Card No.");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Credit Amount");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        rcvdTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rcvdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcvdTxtActionPerformed(evt);
            }
        });
        rcvdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rcvdTxtKeyReleased(evt);
            }
        });

        NetAmountTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NetAmountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NetAmountTxtActionPerformed(evt);
            }
        });

        blncTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        blncTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blncTxtActionPerformed(evt);
            }
        });

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        CashCheck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CashCheck.setText("Cash");
        CashCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashCheckActionPerformed(evt);
            }
        });

        CardCheck.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CardCheck.setText("Credit Card");
        CardCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardCheckActionPerformed(evt);
            }
        });

        ClearBtn1.setBackground(new java.awt.Color(0, 102, 153));
        ClearBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearBtn1.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn1.setText("Clear");
        ClearBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtn1ActionPerformed(evt);
            }
        });

        SaveBtn.setBackground(new java.awt.Color(0, 102, 153));
        SaveBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PeoplesBank", "BOC", "Sampath", "Commercial.Seylan" }));

        loyaltyCardBtn.setBackground(new java.awt.Color(0, 102, 153));
        loyaltyCardBtn.setForeground(new java.awt.Color(255, 255, 255));
        loyaltyCardBtn.setText("Loyalty Cards");
        loyaltyCardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loyaltyCardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NetAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CashCheck)
                            .addComponent(CardCheck))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox1, 0, 154, Short.MAX_VALUE)
                                        .addComponent(jTextField12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ClearBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(41, 41, 41))))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel16))
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(rcvdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(loyaltyCardBtn))
                                        .addComponent(blncTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap()))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CashCheck)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NetAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(CardCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rcvdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loyaltyCardBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blncTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ClearBtn1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveBtn))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        OrderTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane2.setViewportView(OrderTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void SubCategoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategoryComboActionPerformed
        // TODO add your handling code here
        String subCat = (String) SubCategoryCombo.getSelectedItem();
        if (CategoryCombo.getSelectedIndex() == 0) {
            try {
                updateItemTableInfoTable();
            } catch (Exception ex) {
                Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                ResultSet resultSet = ItemController.getInfoForInfoTableOFInvoiceSubCategories(subCat);
                ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                setColumnHeaderItemtable();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SubCategoryComboActionPerformed

    private void AddOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOrderBtnActionPerformed
        try {
            // TODO add your handling code here:
            if (!QuantitiyTxt.getText().equals("")) {
                int row = ItemTable.getSelectedRow();
                String itemId = ItemTable.getModel().getValueAt(row, 1).toString();
                String itemName = ItemTable.getModel().getValueAt(row, 0).toString();
                //  String itemNum = itemId.replaceAll("\\D+", "");
                String quantitiy;
                if (!QuantitiyTxt.getText().equals("")) {
                    quantitiy = QuantitiyTxt.getText().replaceAll("\\D+", "");
                } else {
                    quantitiy = "0";
                }

                String purchasePrice = (String) ItemController.getPurchasePrice(itemId);
                String unitSize = (String) ItemController.getUnitSize(itemId);
                String amount = ItemController.getStockAmount(itemId);
                
                int isEnough = Integer.parseInt(amount) - Integer.parseInt(quantitiy);
                
                

                int intQuantitiy = Integer.parseInt(quantitiy);
                double numPrice = Double.parseDouble(purchasePrice);
                double lineTotal = numPrice * intQuantitiy;
                String tot = Double.toString(lineTotal);
                // Set Sub Total 
                this.total = total + lineTotal;
                SubTotalTxt.setText(Double.toString(total));
                 NetTotalTxt.setText(Double.toString(total));
                 String twoDecimalTotal = String.format("%.2f", Float.parseFloat(SubTotalTxt.getText()));
                 SubTotalTxt.setText(twoDecimalTotal);
                 NetAmountTxt.setText(twoDecimalTotal);
                 NetTotalTxt.setText(twoDecimalTotal);
                 //NetAmountTxt.setText(SubTotalTxt.getText());
                 netTotal = Double.toString(total);
                Object[] row2 = {itemName, itemId, quantitiy, unitSize, purchasePrice, tot}; 

                DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
                if(isEnough <= 0 ){
                    JOptionPane.showMessageDialog(null, "Item No "+itemId+" is out of stock.");
                }else{
                      model.addRow(row2);
                 }       
            } else {
                JOptionPane.showMessageDialog(rootPane, "No quantitiy value");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddOrderBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Clear the Table ? ", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            QuantitiyTxt.setText(null);
            ((DefaultTableModel) OrderTable.getModel()).setNumRows(0);
            SubTotalTxt.setText(null);
            NetTotalTxt.setText(null);
            CURRENTTOTAL = Integer.toString(0);
        }
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void CategoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryComboActionPerformed
        String catName = (String) CategoryCombo.getSelectedItem();
        try {
            SubCategoryCombo.removeAllItems();
            for (String cat : ItemController.getRelatedSubCategories(catName)) {
                SubCategoryCombo.addItem(cat);
            }
            //         getValuesToBrandCombo(BrandCombo, CategoryCombo);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CategoryComboActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void rcvdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcvdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rcvdTxtActionPerformed

    private void NetAmountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NetAmountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NetAmountTxtActionPerformed

    private void blncTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blncTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blncTxtActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void CashCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CashCheckActionPerformed

    private void CardCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CardCheckActionPerformed

    private void ClearBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtn1ActionPerformed
        // TODO add your handling code here:
        CURRENTTOTAL = Integer.toString(0);
    }//GEN-LAST:event_ClearBtn1ActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        // TODO add your handling code here:
         try {
            
            ArrayList<Invoice> invoice = new ArrayList<>();
            HashMap<String,String> itemMap = new HashMap<>();
            String invoiceId = InvoiceController.getInvoiceId();
            for(int i = 0;i < OrderTable.getRowCount();i++){
                
                String currentQty = ItemController.getStockAmount(OrderTable.getModel().getValueAt(i, 1).toString());
                int current = Integer.parseInt(currentQty);
                String qty = OrderTable.getModel().getValueAt(i, 2).toString();
                int qunt = Integer.parseInt(qty);
                int remainqty = current - qunt;
                String remain = Integer.toString(remainqty);
                ItemController.updateItemQuantity(OrderTable.getModel().getValueAt(i, 0).toString(),remain);
                
                invoice.add(new Invoice(invoiceId, OrderTable.getModel().getValueAt(i, 1).toString(),
                        OrderTable.getModel().getValueAt(i, 2).toString(), 
                        OrderTable.getModel().getValueAt(i, 3).toString(),
                        OrderTable.getModel().getValueAt(i, 4).toString(),
                        OrderTable.getModel().getValueAt(i, 5).toString(),
                        DateTxt.getText(),CURRENTTOTAL,CUSTOMERID));
                
                itemMap.put(OrderTable.getModel().getValueAt(i, 1).toString(),
                        OrderTable.getModel().getValueAt(i, 2).toString());
            }
           InvoiceController.addInvoice(invoice);
           InvoiceController.updateItem(itemMap);
           updateItemTableInfoTable();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void ResetBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtn1ActionPerformed
        try {
            // TODO add your handling code here:
            updateItemTableInfoTable();
            CategoryCombo.setSelectedIndex(0);
            SubCategoryCombo.setSelectedIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ResetBtn1ActionPerformed

    private void itemSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemSearchTxtKeyReleased
        try {
            // TODO add your handling code here:
            String itemSearch = itemSearchTxt.getText();

            ResultSet resultSet = ItemController.getItemById(itemSearch);
            ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setColumnHeaderItemtable();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_itemSearchTxtKeyReleased

    private void OrderDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderDeleteBtnActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Remove from the table? ", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            ((DefaultTableModel) OrderTable.getModel()).removeRow(OrderTable.getSelectedRow());
        }
    }//GEN-LAST:event_OrderDeleteBtnActionPerformed

    private void DiscountTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiscountTxtKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_DiscountTxtKeyReleased

    private void PercentRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PercentRadioActionPerformed
        // TODO add your handling code here:
        Float netTot = Float.parseFloat(SubTotalTxt.getText());
        Float percentage = Float.parseFloat(DiscountTxt.getText());
        Float lastVal = netTot * (100 -percentage)/100;
        String twoDecimalTotal = String.format("%.2f", lastVal);
        
        NetTotalTxt.setText(twoDecimalTotal);
         NetAmountTxt.setText(twoDecimalTotal);
         netTotal = Double.toString(lastVal);
    }//GEN-LAST:event_PercentRadioActionPerformed

    private void LKRRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LKRRadioActionPerformed
        // TODO add your handling code here:
        Double netTot = Double.parseDouble(SubTotalTxt.getText());
        Double percentage = Double.parseDouble(DiscountTxt.getText());
        Double lastVal = netTot - percentage;
        String twoDecimalTotal = String.format("%.2f", lastVal);
        
       NetTotalTxt.setText(twoDecimalTotal);
         NetAmountTxt.setText(twoDecimalTotal);
         netTotal = Double.toString(lastVal);
    }//GEN-LAST:event_LKRRadioActionPerformed

    private void noDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noDiscountActionPerformed
        // TODO add your handling code here:
        DiscountTxt.setText(null);
        NetTotalTxt.setText(SubTotalTxt.getText());
        NetAmountTxt.setText(SubTotalTxt.getText());
    }//GEN-LAST:event_noDiscountActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        NetTotalTxt.setText(null);
        SubTotalTxt.setText(null);
        DiscountTxt.setText(null);
        CURRENTTOTAL = Integer.toString(0);
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void ItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTableMouseClicked

    private void loyaltyCardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loyaltyCardBtnActionPerformed
        // TODO add your handling code here:
        
         try {
         //   close();
            new LoyaltyCards(netTotal,invId).setVisible(true);
            
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
    }//GEN-LAST:event_loyaltyCardBtnActionPerformed

    private void rcvdTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rcvdTxtKeyReleased
        // TODO add your handling code here:
        Double rcvamount = Double.parseDouble(rcvdTxt.getText());
        Double netTot = Double.parseDouble(NetAmountTxt.getText());
        Double balanceAmount = rcvamount - netTot;
        String twoDecimalBalance = String.format("%.2f", balanceAmount);
        blncTxt.setText(twoDecimalBalance);
    }//GEN-LAST:event_rcvdTxtKeyReleased

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
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InvoiceFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(InvoiceFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddOrderBtn;
    private javax.swing.JCheckBox CardCheck;
    private javax.swing.JCheckBox CashCheck;
    private javax.swing.JButton CatMenuBtn;
    private javax.swing.JLabel CatMenuLbl;
    private javax.swing.JComboBox<String> CategoryCombo;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton ClearBtn1;
    private javax.swing.JTextField DateTxt;
    private javax.swing.JTextField DiscountTxt;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTextField InoviceNumber;
    private javax.swing.JTable ItemTable;
    private javax.swing.JRadioButton LKRRadio;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JTextField NetAmountTxt;
    private javax.swing.JTextField NetTotalTxt;
    private javax.swing.JButton OrderDeleteBtn;
    private javax.swing.JTable OrderTable;
    private javax.swing.JRadioButton PercentRadio;
    private javax.swing.JTextField QuantitiyTxt;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton ResetBtn1;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JComboBox<String> SubCategoryCombo;
    private javax.swing.JTextField SubTotalTxt;
    private javax.swing.JTextField blncTxt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField itemSearchTxt;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton loyaltyCardBtn;
    private javax.swing.JButton noDiscount;
    private javax.swing.JTextField rcvdTxt;
    // End of variables declaration//GEN-END:variables
}
