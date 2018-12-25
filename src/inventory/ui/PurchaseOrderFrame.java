/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.ui;

import inventory.Controller.ItemController;
import inventory.Controller.PurchaseOrderController;
import inventory.models.PurchaseItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.swing.text.TableView.TableRow;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sithara
 */
public class PurchaseOrderFrame extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseOrderFrame
     */
    private double total = 0.0;

    public PurchaseOrderFrame(){
        initComponents();
        init();
    }

    public void init()  {
        try {
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setResizable(false);
            tableStyle(ItemTable);
            UpdatePurcahseOrderTbl();
            tableStyle(PurcahseOrderTbl);
            updateItemTableInfoTable();
            tableStyle(OrderTable);
            updateOrderTableInfoTable();
            getValesToComboBox(CategoryCombo, ItemController.getAllCategories());
            getValesToComboBox(SupplierCombo, ItemController.getAllSuppliers());
            getDate();
            updatePurcahseOrderTblTable();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        WindowEvent windowClosingEvnt = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvnt);
    }

    public void getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        DateLbl.setText(dateFormat.format(cal.getTime()));     
    }

    public void tableStyle(JTable table) {
        JTableHeader tableheader = table.getTableHeader();
        Color headerBlue = new Color(0, 102, 153);
        tableheader.setBackground(headerBlue);
        tableheader.setForeground(Color.WHITE);
        tableheader.setFont(new Font("Tahoma", Font.BOLD, 14));
        ((DefaultTableCellRenderer) tableheader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    public void setColumnHeaderItemtable(){
         TableColumn col = ItemTable.getColumnModel().getColumn(0);
            col.setHeaderValue("Item");
            col.setPreferredWidth(150);
            TableColumn col2 = ItemTable.getColumnModel().getColumn(1);
            col2.setHeaderValue("Item ID");
            col2.setPreferredWidth(50);
            TableColumn col4 = ItemTable.getColumnModel().getColumn(2);
            col4.setHeaderValue("Remain Quantity");
            col4.setPreferredWidth(50);
            TableColumn col3 = ItemTable.getColumnModel().getColumn(3);
            col3.setHeaderValue("Selling Price");
            col3.setPreferredWidth(50);
    }
    public void updateItemTableInfoTable() {
        try {
            ResultSet resultSet = PurchaseOrderController.getInfoForItemTable();
            ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setColumnHeaderItemtable();
           
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ItemFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void updatePurcahseOrderTblTable() throws ClassNotFoundException, SQLException {
        ResultSet resultSet = PurchaseOrderController.getInfoForPurcahseOrderTblTable();
        PurcahseOrderTbl.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    public void updateOrderTableInfoTable() {
        //  try {
        //    ResultSet resultSet = PurchaseOrderController.getInfoForItemTable();
        //    ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));

        TableColumn col = OrderTable.getColumnModel().getColumn(0);
        col.setHeaderValue("Item Name");
        col.setPreferredWidth(150);
        TableColumn col1 = OrderTable.getColumnModel().getColumn(1);
        col1.setHeaderValue("Item ID");
        col1.setPreferredWidth(25);
        TableColumn col2 = OrderTable.getColumnModel().getColumn(2);
        col2.setHeaderValue("Quantitiy");
        col2.setPreferredWidth(25);
        TableColumn col4 = OrderTable.getColumnModel().getColumn(3);
        col4.setHeaderValue("Unit Type");
        col4.setPreferredWidth(25);
        TableColumn col3 = OrderTable.getColumnModel().getColumn(4);
        col3.setHeaderValue("Unit Price");
        col3.setPreferredWidth(25);
        TableColumn col5 = OrderTable.getColumnModel().getColumn(5);
        col5.setHeaderValue("Line Total");
        col5.setPreferredWidth(50);
//        } catch (ClassNotFoundException | SQLException e) {
//            JOptionPane.showMessageDialog(rootPane, e);
//        }
    }
    
    public void UpdatePurcahseOrderTbl(){
        TableColumn col = PurcahseOrderTbl.getColumnModel().getColumn(0);
        col.setHeaderValue("Purchase NO");
        col.setPreferredWidth(120);
        TableColumn col2 = PurcahseOrderTbl.getColumnModel().getColumn(1);
        col2.setHeaderValue("Date");
        col2.setPreferredWidth(60);
        TableColumn col4 = PurcahseOrderTbl.getColumnModel().getColumn(2);
        col4.setHeaderValue("Supplier");
        col4.setPreferredWidth(60);
        TableColumn col3 = PurcahseOrderTbl.getColumnModel().getColumn(3);
        col3.setHeaderValue("Status");
        col3.setPreferredWidth(60);
        
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SupplierCombo = new javax.swing.JComboBox<>();
        itemSearchTxt = new javax.swing.JTextField();
        ResetBtn = new javax.swing.JButton();
        CategoryCombo = new javax.swing.JComboBox<>();
        SubCategoryCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        QuantitiyTxt = new javax.swing.JTextField();
        ClearBtn = new javax.swing.JButton();
        AddOrderBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TotalLbl = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PurchaseIdLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DateLbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SearchPurIdTxt = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PurcahseOrderTbl = new javax.swing.JTable();
        OrderDeleteBtn = new javax.swing.JButton();
        OrderClearBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        statusCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase Order Management");

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
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(CatMenuLbl)
                        .addGap(55, 55, 55)))
                .addComponent(CatMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogOutBtn)
                    .addComponent(HomeBtn)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(CatMenuLbl))
                        .addComponent(CatMenuBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel1))
                .addGap(12, 12, 12))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Supplier");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Search");

        SupplierCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SupplierCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier" }));

        itemSearchTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemSearchTxtKeyReleased(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(0, 51, 102));
        ResetBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        CategoryCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        CategoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryComboActionPerformed(evt);
            }
        });

        SubCategoryCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubCategoryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Sub Category" }));
        SubCategoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubCategoryComboActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("IT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ResetBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SupplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(itemSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubCategoryCombo, 0, 188, Short.MAX_VALUE)
                            .addComponent(CategoryCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SupplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubCategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Quantitiy");

        QuantitiyTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ClearBtn.setBackground(new java.awt.Color(0, 51, 102));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        AddOrderBtn.setBackground(new java.awt.Color(0, 51, 102));
        AddOrderBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddOrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddOrderBtn.setText("Add");
        AddOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrderBtnActionPerformed(evt);
            }
        });

        OrderTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane2.setViewportView(OrderTable);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Total      Rs. ");

        TotalLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalLbl.setText("0.00");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Order ID :");

        PurchaseIdLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PurchaseIdLbl.setText("PUR00000");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Date :");

        DateLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DateLbl.setText("2018/10/2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(PurchaseIdLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(DateLbl)
                .addGap(52, 52, 52))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PurchaseIdLbl)
                    .addComponent(jLabel9)
                    .addComponent(DateLbl))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Purchase Order ID ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Search by Status");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Search by Supplier");

        SearchPurIdTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchPurIdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchPurIdTxtKeyReleased(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton6.setBackground(new java.awt.Color(0, 51, 102));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Clear");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("PUR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchPurIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(SearchPurIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(25, 25, 25))
        );

        PurcahseOrderTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        PurcahseOrderTbl.setShowHorizontalLines(false);
        PurcahseOrderTbl.setShowVerticalLines(false);
        PurcahseOrderTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PurcahseOrderTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(PurcahseOrderTbl);

        OrderDeleteBtn.setBackground(new java.awt.Color(0, 51, 102));
        OrderDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OrderDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderDeleteBtn.setText("Delete");
        OrderDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderDeleteBtnActionPerformed(evt);
            }
        });

        OrderClearBtn.setBackground(new java.awt.Color(0, 51, 102));
        OrderClearBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        OrderClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderClearBtn.setText("Clear");
        OrderClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderClearBtnActionPerformed(evt);
            }
        });

        SaveBtn.setBackground(new java.awt.Color(0, 51, 102));
        SaveBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        ItemTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
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

        statusCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Recieved" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(QuantitiyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(127, 127, 127)
                                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AddOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(56, 56, 56))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(TotalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(OrderDeleteBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(OrderClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(84, 84, 84)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClearBtn)
                            .addComponent(AddOrderBtn)
                            .addComponent(QuantitiyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBtn)
                    .addComponent(OrderClearBtn)
                    .addComponent(OrderDeleteBtn)
                    .addComponent(TotalLbl)
                    .addComponent(jLabel5)
                    .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void SubCategoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubCategoryComboActionPerformed
        // TODO add your handling code here
        String subCat = (String) SubCategoryCombo.getSelectedItem();
        if (CategoryCombo.getSelectedIndex() == 0) {
            updateItemTableInfoTable();
        } else {
            try {
                ResultSet resultSet = PurchaseOrderController.getInfoForItemTableSubCategories(subCat);
                ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
                setColumnHeaderItemtable();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_SubCategoryComboActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        updateItemTableInfoTable();
        CategoryCombo.setSelectedIndex(0);
        SubCategoryCombo.setSelectedIndex(0);

    }//GEN-LAST:event_ResetBtnActionPerformed

    private void ItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_ItemTableMouseClicked

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

                int intQuantitiy = Integer.parseInt(quantitiy);
                double numPrice = Double.parseDouble(purchasePrice);
                double lineTotal = numPrice * intQuantitiy;
                String tot = Double.toString(lineTotal);

                this.total = total + lineTotal;
                TotalLbl.setText(Double.toString(total));
                Object[] row2 = {itemName, itemId, quantitiy, unitSize, purchasePrice, tot};

                DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();

                model.addRow(row2);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No quantitiy value");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_AddOrderBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        QuantitiyTxt.setText(null);
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void OrderClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderClearBtnActionPerformed
        // TODO add your handling code here:
        ((DefaultTableModel) OrderTable.getModel()).setNumRows(0);
        TotalLbl.setText("0.00");
        this.total = 0.0;
    }//GEN-LAST:event_OrderClearBtnActionPerformed

    private void OrderDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderDeleteBtnActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Remove Data from the table? ", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            ((DefaultTableModel) OrderTable.getModel()).removeRow(OrderTable.getSelectedRow());
        }
    }//GEN-LAST:event_OrderDeleteBtnActionPerformed

    private void itemSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemSearchTxtKeyReleased
        try {
            // TODO add your handling code here:
            String itemSearch = itemSearchTxt.getText();

            ResultSet resultSet = ItemController.getItemById(itemSearch);
            ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setColumnHeaderItemtable();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_itemSearchTxtKeyReleased

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        try {
            // TODO add your handling code here:
        //    ArrayList<String> itemIds = new ArrayList<>();
            ArrayList<PurchaseItem> purchase = new ArrayList<>();
            String purchaseId = PurchaseOrderController.getPurchaseId();
            System.out.println(OrderTable.getRowCount());
            for(int i = 0;i < OrderTable.getRowCount();i++){
             purchase.add(new PurchaseItem(purchaseId, OrderTable.getModel().getValueAt(i, 1).toString() ,DateLbl.getText(), (String)statusCombo.getSelectedItem(),"SUP001", OrderTable.getModel().getValueAt(i, 2).toString(), OrderTable.getModel().getValueAt(i, 3).toString(), OrderTable.getModel().getValueAt(i, 4).toString(), OrderTable.getModel().getValueAt(i, 5).toString() ));
            }
            
            PurchaseOrderController.addPurchase(purchase);
            updatePurcahseOrderTblTable();
            //    PurchaseItem purchase = new PurchaseItem();
            PurchaseIdLbl.setText(purchaseId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void PurcahseOrderTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurcahseOrderTblMouseClicked
        try {
            // TODO add your handling code here:
            int row = PurcahseOrderTbl.getSelectedRow();
            String purchId = PurcahseOrderTbl.getModel().getValueAt(row, 0).toString();
            PurchaseIdLbl.setText(purchId);
          ResultSet resultSet = PurchaseOrderController.getInfoForOrderTblByPurchase(purchId);
          OrderTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PurcahseOrderTblMouseClicked

    private void SearchPurIdTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPurIdTxtKeyReleased
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String purSearch = "PUR" + SearchPurIdTxt.getText();

            ResultSet resultSet = PurchaseOrderController.getInfoForPurcahseOrderTblTable(purSearch);
            PurcahseOrderTbl.setModel(DbUtils.resultSetToTableModel(resultSet));
            setColumnHeaderItemtable();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_SearchPurIdTxtKeyReleased

    private void getValesToComboBox(JComboBox combo, ArrayList<String> list) throws SQLException, ClassNotFoundException {
        // ArrayList<String> list = UserController.getAllEmployee();
        for (String val : list) {
            combo.addItem(val);
        }
    }

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
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PurchaseOrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddOrderBtn;
    private javax.swing.JButton CatMenuBtn;
    private javax.swing.JLabel CatMenuLbl;
    private javax.swing.JComboBox<String> CategoryCombo;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JLabel DateLbl;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton OrderClearBtn;
    private javax.swing.JButton OrderDeleteBtn;
    private javax.swing.JTable OrderTable;
    private javax.swing.JTable PurcahseOrderTbl;
    private javax.swing.JLabel PurchaseIdLbl;
    private javax.swing.JTextField QuantitiyTxt;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField SearchPurIdTxt;
    private javax.swing.JComboBox<String> SubCategoryCombo;
    private javax.swing.JComboBox<String> SupplierCombo;
    private javax.swing.JLabel TotalLbl;
    private javax.swing.JTextField itemSearchTxt;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> statusCombo;
    // End of variables declaration//GEN-END:variables
}
