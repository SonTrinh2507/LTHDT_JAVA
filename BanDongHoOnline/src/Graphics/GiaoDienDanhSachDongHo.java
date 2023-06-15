/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Graphics;

import CONNECTION.LoadData;
import Function.DigitsDocument;
import Function.createQR;
import Model.HangDH;
import Model.LoaiDH;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;
import Model.DongHo;
import java.awt.Image;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class GiaoDienDanhSachDongHo extends javax.swing.JFrame {

//    private int link;
    /**
     * Creates new form DanhSachDongHo
     */
    private DefaultTableModel myTable;
    private DefaultTableModel myTable2;
    private static Timer formatTimer;
    private String selectedImageUrl;
    private Map<String, String> cbbLoai; // Thuộc tính để lưu trữ comboBoxItems
    private Map<String, String> cbbHang; // Thuộc tính để lưu trữ comboBoxItems

    public GiaoDienDanhSachDongHo() {

        initComponents();

        myTable = (DefaultTableModel) jTable1.getModel();
        myTable2 = (DefaultTableModel) jTable1.getModel();

        showData();
        txtSLTon.setDocument(new DigitsDocument());

        // txtGia.setDocument(new DigitsDocument());
//        showData();
        jTable1.setDefaultEditor(Object.class, null);;
        //jTable1.setSelectionBackground(Color.RED);
        jTable1.setSelectionMode(0);
        insertCBBoxMaLoai();
        insertCBBoxMaHang();
        txtMH.setSelectedItem(null);
        txtML.setSelectedItem(null);
        showSL();
        if (Controller.controller.tk.getChucVu().getMaCV().equals("1")) {
            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
            btnThem.setEnabled(true);

        } else {
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
            btnThem.setEnabled(false);
            String x = "";
            txtGia.setEnabled(false);
            txtMH.setEnabled(false);
            txtML.setEnabled(false);
            txtMaDH.setEnabled(false);
            txtSLTon.setEnabled(false);
            txtTT.setEnabled(false);
            txtTenDH.setEnabled(false);

            txtMaDH.setEnabled(false);

        }

    }

    private void showSL() {
        int sum = 0;
        for (DongHo dh : Controller.controller.arrayListDongHo) {
            if (dh.getSLTon() > 0) {
                sum += dh.getSLTon();
            }
        }
        String s = String.valueOf(sum);
        txtTOngSL.setText(s);

    }

    private void showData() {
        new LoadData();
        myTable.setRowCount(0);
        int dem = 0;
        for (DongHo dh : Controller.controller.arrayListDongHo) {
            dem++;
            BigDecimal Gia = new BigDecimal(dh.getGia().toString());
            Gia = Gia.setScale(0, RoundingMode.HALF_UP);
            myTable.addRow(new Object[]{dem, dh.getMaDH(), dh.getMaHang(), dh.getMaLoai(), dh.getTenDH(), Gia, dh.getSLTon(), dh.getMoTa(), new ImageIcon(dh.getHinhAnh())});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        txtMaDH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMH = new javax.swing.JComboBox<>();
        txtTenDH = new javax.swing.JTextField();
        txtML = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lableAnh = new javax.swing.JLabel();
        txtSLTon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTT = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        btnHA = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtTK = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        baoloi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTOngSL = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DANH SÁCH ĐỒNG HỒ");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(47, 149, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH ĐỒNG HỒ");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mã loại:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Giá:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã đồng hồ:");

        txtGia.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtGiaInputMethodTextChanged(evt);
            }
        });
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });
        txtGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiaKeyPressed(evt);
            }
        });

        txtMaDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDHActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên đồng hồ:");

        txtMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMHActionPerformed(evt);
            }
        });

        txtML.setMaximumRowCount(5);
        txtML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMLActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mã hãng:");

        lableAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtSLTon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLTonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Trạng thái:");

        txtTT.setColumns(20);
        txtTT.setRows(5);
        jScrollPane3.setViewportView(txtTT);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Thông tin chi tiết");

        btnHA.setText("Hình ảnh:");
        btnHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Số lượng:");

        jButton2.setText("Tạo QR:");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(704, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTenDH))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(20, 20, 20)
                                            .addComponent(txtMaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHA)
                                .addGap(18, 18, 18)
                                .addComponent(lableAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel13)
                    .addContainerGap(747, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHA)
                            .addComponent(jButton2))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(138, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(67, 67, 67)))
        );

        txtML.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(51, 51, 51));

        txtTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKActionPerformed(evt);
            }
        });
        txtTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTKKeyReleased(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/funnel-icon.png"))); // NOI18N
        jButton5.setText("Lọc");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.darkGray, null, null));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Bộ lọc thông tin");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Vui lòng nhập thông tin cần lọc vào ô trống");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                            .addComponent(txtTK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel10)
                .addGap(10, 10, 10))
        );

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Home-icon.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBackground(new java.awt.Color(242, 220, 104));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã đồng hồ", "Mã hãng", "Mã loại", "Tên đồng hồ", "Giá", "Số lượng tồn", "Trạng Thái", "Hình Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Button-Add-icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Button-Close-icon.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Pen-Red-icon.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Reset-icon.png"))); // NOI18N
        jButton1.setText("Reset");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        baoloi.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        baoloi.setForeground(new java.awt.Color(244, 108, 63));
        baoloi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        baoloi.setText("Thông báo:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Danh sách đồng hồ");

        txtTOngSL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Tổng số lượng khả dụng:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(baoloi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(444, 444, 444))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(67, 67, 67)))
                        .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12)
                        .addComponent(txtTOngSL, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtTOngSL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baoloi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDHActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (txtMaDH.getText().equals("") || txtTenDH.getText().equals("") || txtTT.getText().equals("") || txtSLTon.getText().equals("") || txtGia.getText().equals("")) {
            baoloi.setText("Vui lòng nhập đầy đủ thông tin đồng hồ!");
        } else {
            int row = jTable1.getSelectedRow();
            BigDecimal Gia = new BigDecimal(txtGia.getText().replaceAll(",", ""));

            int SL = Integer.parseInt(txtSLTon.getText().replaceAll(" ", ""));
            HangDH hdd;
            String HinhAnh = selectedImageUrl;
            String selectedItemLoai = (String) txtML.getSelectedItem();
            String ML = cbbLoai.get(selectedItemLoai);
            String selectedItemHang = (String) txtMH.getSelectedItem();
            String MH = cbbHang.get(selectedItemHang);
            DongHo dh = new DongHo(txtMaDH.getText(), txtTenDH.getText(), txtTT.getText(), ML, MH, Gia, SL, HinhAnh);
            if (jTable1.getSelectedRow() == -1) {

                for (DongHo dhh : Controller.controller.arrayListDongHo) {
                    if (dhh.getMaDH().equals(txtMaDH.getText())) {
                        baoloi.setText("Đồng hồ đã tồn tại");
                        return;
                    }
                }
                boolean check = false;

                check = CONNECTION.InsertData.insertDongHo(dh);
                if (check == true) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                }
                jTable1.getSelectionModel().setSelectionInterval(jTable1.getRowCount() - 1, jTable1.getRowCount() - 1);

            } else {

                CONNECTION.UpdateData.updateDongHo(dh);

            }
            showData();
            jTable1.getSelectionModel().setSelectionInterval(row, row);
        }
        txtMaDH.setEnabled(true);
        lableAnh.setIcon(null);

        showSL();
// TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed

        txtMaDH.setEnabled(false);
        btnThem.setEnabled(false);
        baoloi.setText("");// TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        txtMaDH.setText((String) jTable1.getValueAt(row, 1));
        //txtMH.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 2));
        //txtML.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3));
        txtTenDH.setText((String) jTable1.getValueAt(row, 4));
        txtGia.setText(startFormatTimer(jTable1.getValueAt(row, 5).toString()));
        txtSLTon.setText(jTable1.getValueAt(row, 6).toString());
        txtTT.setText((String) jTable1.getValueAt(row, 7));
        ImageIcon imageIcon = new ImageIcon(jTable1.getValueAt(row, 8).toString());
        Image image = imageIcon.getImage().getScaledInstance(lableAnh.getWidth(), lableAnh.getHeight(), Image.SCALE_SMOOTH);
        lableAnh.setIcon(new ImageIcon(image));
        selectedImageUrl = jTable1.getValueAt(row, 8).toString();
        Object value = jTable1.getValueAt(row, 3);
        if (value != null) {
            String selectedValue = value.toString().trim();
            for (Map.Entry<String, String> entry : cbbLoai.entrySet()) {
                if (entry.getValue().equals(selectedValue)) {
                    txtML.setSelectedItem(entry.getKey());
                    break;
                }
            }
        }
        Object value1 = jTable1.getValueAt(row, 2);
        if (value1 != null) {
            String selectedValue = value1.toString().trim();
            for (Map.Entry<String, String> entry : cbbHang.entrySet()) {
                if (entry.getValue().equals(selectedValue)) {
                    txtMH.setSelectedItem(entry.getKey());
                    break;
                }
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            baoloi.setText("Vui lòng chọn đồng hồ!");
        } else if (txtMaDH.getText().equals("") || txtTenDH.getText().equals("") || txtTT.getText().equals("") || txtSLTon.getText().equals("") || txtGia.getText().equals("")) {
            baoloi.setText("Vui lòng nhập đầy đủ thông tin đồng hồ!");
        } else {
            int row = jTable1.getSelectedRow();
            BigDecimal Gia = new BigDecimal(txtGia.getText().replaceAll(",", ""));
            int SL = Integer.parseInt(txtSLTon.getText().replaceAll(" ", ""));
            HangDH hdd;
            String HinhAnh = selectedImageUrl;
            String selectedItemLoai = (String) txtML.getSelectedItem();
            String ML = cbbLoai.get(selectedItemLoai);
            String selectedItemHang = (String) txtMH.getSelectedItem();
            String MH = cbbHang.get(selectedItemHang);
            DongHo dh = new DongHo(txtMaDH.getText(), txtTenDH.getText(), txtTT.getText(), ML, MH, Gia, SL, HinhAnh);
            boolean check = false;
            check = CONNECTION.UpdateData.updateDongHo(dh);
            if (check == true) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            }

            showData();
            jTable1.getSelectionModel().setSelectionInterval(row, row);
        }
        showSL();
        lableAnh.setIcon(null);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            baoloi.setText("Vui lòng chọn chi tiết bảo hành");
        } else {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Xác Nhận Xóa Chi Tiết Bảo Hành?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 1));
                CONNECTION.DeleteData.deleteDongHo((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
                showData();
            }
        }
        showSL();
        String x = "";
        txtGia.setText(x);
        txtMH.setSelectedItem(null);
        txtML.setSelectedItem(null);
        txtMaDH.setText(x);
        txtSLTon.setText(x);
        txtTT.setText(x);
        txtTenDH.setText(x);
        txtMaDH.setEnabled(true);
        btnThem.setEnabled(true);
        lableAnh.setIcon(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMLActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed

    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMHActionPerformed

    private void txtTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKActionPerformed

    private void txtTKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Home home = new Home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String dh = txtTK.getText();
        TimKiem(dh);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (Controller.controller.tk.getChucVu().getMaCV().equals("1")) {
            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
            btnThem.setEnabled(true);

            String x = "";
            txtGia.setText(x);
            txtMH.setSelectedItem(null);
            txtML.setSelectedItem(null);
            txtMaDH.setText(x);
            txtSLTon.setText(x);
            txtTT.setText(x);
            txtTenDH.setText(x);

            txtMaDH.setEnabled(true);

        } else {
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
            btnThem.setEnabled(false);

        }
        lableAnh.setIcon(null);

        showData();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSLTonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLTonActionPerformed

    }//GEN-LAST:event_txtSLTonActionPerformed

    private String startFormatTimer(String Gia) {
        if (formatTimer != null && formatTimer.isRunning()) {
            formatTimer.restart();
        } else {
            formatTimer = new Timer(100, e -> formatTextField(Gia));
            formatTimer.setRepeats(false);
            formatTimer.start();
        }

        return Gia;
    }

    private String formatTextField(String Gia) {
        Gia = txtGia.getText();
        String formattedNumber = formatNumber(Gia);
        SwingUtilities.invokeLater(() -> txtGia.setText(formattedNumber));
        return formattedNumber;
    }

    private static String formatNumber(String number) {
        try {
            if (number.isEmpty()) {
                return "";
            } else {
                long amount = Long.parseLong(number);
                DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                symbols.setGroupingSeparator(',');

                DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
                return decimalFormat.format(amount);
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    private void txtGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaKeyPressed
        String input = txtGia.getText().replaceAll(",", "");
        String format = startFormatTimer(input);
        txtGia.setText(format);
    }//GEN-LAST:event_txtGiaKeyPressed

    private void txtGiaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtGiaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaInputMethodTextChanged

    private void btnHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("E:\\LTHDT\\BanDongHo\\BanDongHoOnline\\src"));

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Hiển thị ảnh đã chọn
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            Image image = imageIcon.getImage().getScaledInstance(lableAnh.getWidth(), lableAnh.getHeight(), Image.SCALE_SMOOTH);
            lableAnh.setIcon(new ImageIcon(image));
            System.err.print(lableAnh.getIcon());
            selectedImageUrl = selectedFile.getAbsolutePath();
        }
    }//GEN-LAST:event_btnHAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String filePath = "E:\\LTHDT\\BanDongHo\\BanDongHoOnline\\src\\MaQR\\" + txtMaDH.getText() + ".png"; // Đường dẫn tới file ảnh QR
        Function.createQR.createQRNew(txtMaDH.getText(), filePath);
        JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    private DefaultTableModel model;

    private void TimKiem(String Str) {
        model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        jTable1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(Str));
    }

    private void insertCBBoxMaLoai() {
        cbbLoai = new HashMap<>();
        for (LoaiDH dh : Controller.controller.arrayListLoaiDH) {

            cbbLoai.put(dh.getTenLoai(), dh.getMaLoai());

        }
        for (String item : cbbLoai.keySet()) {
            txtML.addItem(item);
        }
    }

    private void insertCBBoxMaHang() {
        cbbHang = new HashMap<>();
        for (HangDH dh : Controller.controller.arrayListHangDH) {

            cbbHang.put(dh.getTenHang(), dh.getMaHang());
        }
        for (String item : cbbHang.keySet()) {
            txtMH.addItem(item);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienDanhSachDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienDanhSachDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienDanhSachDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienDanhSachDongHo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GiaoDienDanhSachDongHo DH = new GiaoDienDanhSachDongHo();
                DH.setLocationRelativeTo(null);
                DH.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel baoloi;
    private javax.swing.JButton btnHA;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lableAnh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JComboBox<String> txtMH;
    private javax.swing.JComboBox<String> txtML;
    private javax.swing.JTextField txtMaDH;
    private javax.swing.JTextField txtSLTon;
    private javax.swing.JTextField txtTK;
    private javax.swing.JLabel txtTOngSL;
    private javax.swing.JTextArea txtTT;
    private javax.swing.JTextField txtTenDH;
    // End of variables declaration//GEN-END:variables
}
