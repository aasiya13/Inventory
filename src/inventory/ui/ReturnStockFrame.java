/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.ui;

import inventory.Controller.ItemController;
import inventory.Controller.PurchaseOrderController;
import inventory.Controller.ReturnStockController;
import inventory.models.PurchaseItem;
import inventory.models.ReturnStock;
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
public class ReturnStockFrame extends javax.swing.JFrame {

    /**
     * Creates new form ReturnStockFrame
     */
    private float total = 0;

    public ReturnStockFrame() throws SQLException, ClassNotFoundException {
        initComponents();
        init();
    }

    public void init() throws SQLException, ClassNotFoundException {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        updateItemTableInfoTable();
        updateReturnTable();
        setColumnHeaderItemtable();
        setColumnHeaderSelectItemtable();
        setColumnHeaderReturnStocktable();
        tableStyle(ItemTable);
        tableStyle(SelectItemTable);
        tableStyle(ReturnTable);
        getValesToComboBox(CategoryCombo, ItemController.getAllCategories());
        getValesToComboBox(SupplierCombo, ItemController.getAllSuppliers());
        DateLbl.setText(getDate());
    }

    public void close() {
        WindowEvent windowClosingEvnt = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosingEvnt);
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    private void getValesToComboBox(JComboBox combo, ArrayList<String> list) throws SQLException, ClassNotFoundException {
        // ArrayList<String> list = UserController.getAllEmployee();
        for (String val : list) {
            combo.addItem(val);
        }
    }

    public void tableStyle(JTable table) {
        JTableHeader tableheader = table.getTableHeader();
        Color headerBlue = new Color(0, 102, 153);
        tableheader.setBackground(headerBlue);
        tableheader.setForeground(Color.WHITE);
        tableheader.setFont(new Font("Tahoma", Font.BOLD, 14));
        ((DefaultTableCellRenderer) tableheader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    public void setColumnHeaderItemtable() {
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
        col3.setHeaderValue("Purchase Price");
        col3.setPreferredWidth(50);
    }

    public void setColumnHeaderSelectItemtable() {
        TableColumn col = SelectItemTable.getColumnModel().getColumn(0);
        col.setHeaderValue("Item Id");
        col.setPreferredWidth(50);
        TableColumn col2 = SelectItemTable.getColumnModel().getColumn(1);
        col2.setHeaderValue("Item Name");
        col2.setPreferredWidth(150);
        TableColumn col3 = SelectItemTable.getColumnModel().getColumn(2);
        col3.setHeaderValue("Qunatity");
        col3.setPreferredWidth(30);
        TableColumn col4 = SelectItemTable.getColumnModel().getColumn(3);
        col4.setHeaderValue("Reason");
        col4.setPreferredWidth(100);

    }

    public void setColumnHeaderReturnStocktable() {
        TableColumn col = ReturnTable.getColumnModel().getColumn(0);
        col.setHeaderValue("Return Sotck ID");
        col.setPreferredWidth(50);
        TableColumn col4 = ReturnTable.getColumnModel().getColumn(1);
        col4.setHeaderValue("Date");
        col4.setPreferredWidth(50);
        TableColumn col6 = ReturnTable.getColumnModel().getColumn(2);
        col6.setHeaderValue("Line Total");
        col6.setPreferredWidth(50);
    }

    public void updateItemTableInfoTable() {
        try {
            ResultSet resultSet = PurchaseOrderController.getInfoForItemTableReturnStock();
            ItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setColumnHeaderItemtable();

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ItemFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void updateReturnTable() throws ClassNotFoundException, SQLException {
        ResultSet resultSet = ReturnStockController.getInfoForReturnTable();
        ReturnTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        setColumnHeaderReturnStocktable();
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
        ItemTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SupplierCombo = new javax.swing.JComboBox<>();
        itemSearchTxt = new javax.swing.JTextField();
        ResetBtn = new javax.swing.JButton();
        CategoryCombo = new javax.swing.JComboBox<>();
        SubCategoryCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        QuantityTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reasonTxt = new javax.swing.JTextArea();
        ClearBtn = new javax.swing.JButton();
        AddItem = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        DateLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ReturnTotalTbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReturnTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        SelectItemTable = new javax.swing.JTable();
        DeleteItemBtn = new javax.swing.JButton();
        ClearItemBtn = new javax.swing.JButton();
        itemSearchTxt1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        AddReturnStockBtn = new javax.swing.JButton();
        ResetSearchBtn = new javax.swing.JButton();
        ResetBtn3 = new javax.swing.JButton();
        DeleteGrn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Return Stock Management");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
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
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Quantity");

        QuantityTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        QuantityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QuantityTxtKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Status");

        statusCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Returned" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Reason");

        reasonTxt.setColumns(20);
        reasonTxt.setRows(5);
        jScrollPane2.setViewportView(reasonTxt);

        ClearBtn.setBackground(new java.awt.Color(0, 51, 102));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        AddItem.setBackground(new java.awt.Color(0, 51, 102));
        AddItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddItem.setForeground(new java.awt.Color(255, 255, 255));
        AddItem.setText("Add");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(QuantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(AddItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(QuantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(ClearBtn)
                        .addGap(18, 18, 18)
                        .addComponent(AddItem))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Date :");

        DateLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DateLbl.setText("2018/10/2");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Return Total ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Rs.");

        ReturnTotalTbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReturnTotalTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(DateLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(DateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(ReturnTotalTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ReturnTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        ReturnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ReturnTable.setShowHorizontalLines(false);
        ReturnTable.setShowVerticalLines(false);
        ReturnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReturnTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ReturnTable);

        SelectItemTable.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        SelectItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        SelectItemTable.setShowHorizontalLines(false);
        SelectItemTable.setShowVerticalLines(false);
        SelectItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectItemTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(SelectItemTable);

        DeleteItemBtn.setBackground(new java.awt.Color(0, 51, 102));
        DeleteItemBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DeleteItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteItemBtn.setText("Delete");
        DeleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemBtnActionPerformed(evt);
            }
        });

        ClearItemBtn.setBackground(new java.awt.Color(0, 51, 102));
        ClearItemBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearItemBtn.setText("Clear");
        ClearItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearItemBtnActionPerformed(evt);
            }
        });

        itemSearchTxt1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemSearchTxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                itemSearchTxt1KeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("GRN");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Search");

        AddReturnStockBtn.setBackground(new java.awt.Color(0, 51, 102));
        AddReturnStockBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddReturnStockBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddReturnStockBtn.setText("Add");
        AddReturnStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddReturnStockBtnActionPerformed(evt);
            }
        });

        ResetSearchBtn.setBackground(new java.awt.Color(0, 51, 102));
        ResetSearchBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResetSearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetSearchBtn.setText("Reset");
        ResetSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetSearchBtnActionPerformed(evt);
            }
        });

        ResetBtn3.setBackground(new java.awt.Color(0, 51, 102));
        ResetBtn3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResetBtn3.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn3.setText("Update");
        ResetBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtn3ActionPerformed(evt);
            }
        });

        DeleteGrn.setBackground(new java.awt.Color(0, 51, 102));
        DeleteGrn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DeleteGrn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteGrn.setText("Delete");
        DeleteGrn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGrnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(ResetBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ClearItemBtn)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteItemBtn)
                        .addGap(18, 18, 18)
                        .addComponent(AddReturnStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemSearchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ResetSearchBtn)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteGrn)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteItemBtn)
                            .addComponent(ClearItemBtn)
                            .addComponent(AddReturnStockBtn)
                            .addComponent(ResetBtn3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(itemSearchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(ResetSearchBtn)
                            .addComponent(DeleteGrn)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void ItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemTableMouseClicked

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

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        // TODO add your handling code here:
        updateItemTableInfoTable();
        CategoryCombo.setSelectedIndex(0);
        SubCategoryCombo.setSelectedIndex(0);
    }//GEN-LAST:event_ResetBtnActionPerformed

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

    private void QuantityTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuantityTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityTxtKeyReleased

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
        QuantityTxt.setText(null);
        reasonTxt.setText(null);
        statusCombo.setSelectedIndex(0);
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        // TODO add your handling code here:

        if (!QuantityTxt.getText().equals("")) {
            int row = ItemTable.getSelectedRow();
            String quantity = ItemTable.getModel().getValueAt(row, 2).toString();
            int quant = Integer.parseInt(quantity);
            if (quant > 0) {
                String itemId = ItemTable.getModel().getValueAt(row, 1).toString();
                String itemName = ItemTable.getModel().getValueAt(row, 0).toString();

                String reason = reasonTxt.getText();
                //  String itemNum = itemId.replaceAll("\\D+", "");
                String quantitiy;
                if (!QuantityTxt.getText().equals("")) {
                    quantitiy = QuantityTxt.getText().replaceAll("\\D+", "");
                } else {
                    quantitiy = "0";
                }
                //   Object[] row2 = {returnNo, quantitiy, reason, date, status, lineTotal};

                Object[] row3 = {itemId, itemName, quantitiy, reason};
                DefaultTableModel model = (DefaultTableModel) SelectItemTable.getModel();
                model.addRow(row3);
                total = 0;
                for (int i = 0; i < SelectItemTable.getRowCount(); i++) {
                    String qty = SelectItemTable.getModel().getValueAt(i, 2).toString();
                    String itemPrice;
                    try {
                        itemPrice = ItemController.getPurchasePrice(SelectItemTable.getModel().getValueAt(i, 0).toString());
                        float tot = Integer.parseInt(itemPrice) * Integer.parseInt(qty);
                        //   System.out.print(tot);
                        total = total + tot;
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ReturnTotalTbl.setText(Float.toString(total));
            } else {
                JOptionPane.showMessageDialog(rootPane, "No Quantitiy to return");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Not enough remaining item");
        }
    }//GEN-LAST:event_AddItemActionPerformed

    private void AddReturnStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddReturnStockBtnActionPerformed
        try {
            // TODO add your handling code here:
            ArrayList<ReturnStock> returnStock = new ArrayList<>();
            int row = ItemTable.getSelectedRow();
            total = 0;
            String reason = reasonTxt.getText();
            String date = getDate();
            String status = (String) statusCombo.getSelectedItem();

            String returnNo = ReturnStockController.getReturnStockId();
            for (int i = 0; i < SelectItemTable.getRowCount(); i++) {
                String itemPrice = ItemController.getPurchasePrice(SelectItemTable.getModel().getValueAt(i, 0).toString());
             
                String currentQty = ItemController.getStockAmount(SelectItemTable.getModel().getValueAt(i, 0).toString());
                int current = Integer.parseInt(currentQty);
                String qty = SelectItemTable.getModel().getValueAt(i, 2).toString();
                int qunt = Integer.parseInt(qty);
                int remainqty = current - qunt;
                String remain = Integer.toString(remainqty);
                ItemController.updateItemQuantity(SelectItemTable.getModel().getValueAt(i, 0).toString(),remain);
               
                reason = SelectItemTable.getModel().getValueAt(i, 3).toString();
                float tot = Integer.parseInt(itemPrice) * Integer.parseInt(qty);
                String lineTotal = Float.toString(tot);
                returnStock.add(new ReturnStock(returnNo, SelectItemTable.getModel().getValueAt(i, 0).toString(), SelectItemTable.getModel().getValueAt(i, 2).toString(), reason, date, status, lineTotal));
            }
            ReturnStockController.addReturnStock(returnStock);
            updateReturnTable();
            updateItemTableInfoTable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddReturnStockBtnActionPerformed

    private void DeleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemBtnActionPerformed
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Remove Data from the table? ", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            if (SelectItemTable.getSelectedRow() > 0) {
                try {
                    int row = SelectItemTable.getSelectedRow();
                    String itemPrice = ItemController.getPurchasePrice(SelectItemTable.getModel().getValueAt(row, 0).toString());
                    String qty = SelectItemTable.getModel().getValueAt(row, 2).toString();
                    ((DefaultTableModel) SelectItemTable.getModel()).removeRow(SelectItemTable.getSelectedRow());
                    float tot = Integer.parseInt(itemPrice) * Integer.parseInt(qty);
                    total = total - tot;
                    ReturnTotalTbl.setText(Float.toString(total));
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Item is not selected");
            }
        }
    }//GEN-LAST:event_DeleteItemBtnActionPerformed

    private void ClearItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearItemBtnActionPerformed
        // TODO add your handling code here:
        ((DefaultTableModel) SelectItemTable.getModel()).setNumRows(0);
        total = 0;
        ReturnTotalTbl.setText(Float.toString(total));
        itemSearchTxt1.setText(null);
    }//GEN-LAST:event_ClearItemBtnActionPerformed

    private void itemSearchTxt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemSearchTxt1KeyReleased
        try {
            String grnSearch = "GRN" + itemSearchTxt1.getText();
            ResultSet resultSet = ReturnStockController.getInfoForReturnTable(grnSearch);
            ReturnTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setColumnHeaderReturnStocktable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemSearchTxt1KeyReleased

    private void ReturnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnTableMouseClicked
        // TODO add your handling code here:
        try {
            int row = ReturnTable.getSelectedRow();
            String grnId = ReturnTable.getModel().getValueAt(row, 0).toString();
            itemSearchTxt1.setText(grnId.replaceAll("\\D+", ""));
            ResultSet resultSet = ReturnStockController.getInfoForReturnTableClick(grnId);
            SelectItemTable.setModel(DbUtils.resultSetToTableModel(resultSet));
            setColumnHeaderSelectItemtable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PurchaseOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReturnTableMouseClicked

    private void ResetSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetSearchBtnActionPerformed
        try {
            // TODO add your handling code here:
            itemSearchTxt1.setText(null);
            updateReturnTable();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ResetSearchBtnActionPerformed

    private void ResetBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetBtn3ActionPerformed

    private void SelectItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectItemTableMouseClicked
        try {
            // TODO add your handling code here:
            int row = SelectItemTable.getSelectedRow();
            int row1 = ReturnTable.getSelectedRow();
            String reason = SelectItemTable.getModel().getValueAt(row, 3).toString();
            String itemId = SelectItemTable.getModel().getValueAt(row, 0).toString();
            String grnId = ReturnTable.getModel().getValueAt(row1, 0).toString();
            String qty = SelectItemTable.getModel().getValueAt(row, 2).toString();

            String status = ReturnStockController.getStatusById(itemId, grnId);
            reasonTxt.setText(reason);
            QuantityTxt.setText(qty);
            statusCombo.setSelectedItem(status);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SelectItemTableMouseClicked

    private void DeleteGrnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGrnActionPerformed

        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(rootPane, "Remove Data from the table? ", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {
                int row1 = ReturnTable.getSelectedRow();
                String grnId = ReturnTable.getModel().getValueAt(row1, 0).toString();

                ReturnStockController.deleteGrnById(grnId);
                updateReturnTable();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DeleteGrnActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReturnStockFrame().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ReturnStockFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItem;
    private javax.swing.JButton AddReturnStockBtn;
    private javax.swing.JButton CatMenuBtn;
    private javax.swing.JLabel CatMenuLbl;
    private javax.swing.JComboBox<String> CategoryCombo;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton ClearItemBtn;
    private javax.swing.JLabel DateLbl;
    private javax.swing.JButton DeleteGrn;
    private javax.swing.JButton DeleteItemBtn;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JTextField QuantityTxt;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton ResetBtn3;
    private javax.swing.JButton ResetSearchBtn;
    private javax.swing.JTable ReturnTable;
    private javax.swing.JLabel ReturnTotalTbl;
    private javax.swing.JTable SelectItemTable;
    private javax.swing.JComboBox<String> SubCategoryCombo;
    private javax.swing.JComboBox<String> SupplierCombo;
    private javax.swing.JTextField itemSearchTxt;
    private javax.swing.JTextField itemSearchTxt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea reasonTxt;
    private javax.swing.JComboBox<String> statusCombo;
    // End of variables declaration//GEN-END:variables
}
