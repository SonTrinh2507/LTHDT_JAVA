/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Graphics;

import CONNECTION.LoadData;
import Model.CT_PhieuDat;
import Model.HoaDon;
import Model.PhieuDat;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Admin
 */
public class GiaoDienXuatHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDienXuatHoaDon
     */
    private String Link;

    public GiaoDienXuatHoaDon(String Link) {
        initComponents();
        this.Link = Link;
        this.txtMHD.setText(Link);

        for (HoaDon hd : Controller.controller.arrayListHoaDon) {

            for (PhieuDat pd : Controller.controller.arrayListPhieuDat) {

                if (txtMHD.getText().equals(hd.getMaHD()) && hd.getMaPD().equals(pd.getMaPD())) {
                    txtMSTHD.setText(hd.getMSTHD());
                    dateBan.setText(hd.getNgayIn().toString());
                    txtMaNV.setText(hd.getMaNV());
                    txtPD.setText(hd.getMaPD());

                    txtMaKH.setText(pd.getMaKH());

                    txtHo.setText(pd.getHoKH());
                    txtTen.setText(pd.getTenKH());
                    txtDiaChi.setText(pd.getDcKH());
                    dateDat.setText(pd.getNgayDat().toString());
                    dateGiao.setText(pd.getNgayGiao().toString());
                }

            }

        }
   
        myTable2 = (DefaultTableModel) jTable2.getModel();

        showCTPD1();  // TODO add your handling code here:
        Tien();
    }
    private DefaultTableModel myTable2;

    private void showCTPD() {
        GiaoDienPhieuDat PD = new GiaoDienPhieuDat();
        new LoadData();

        int dem2 = 0;
        String n = txtPD.getText();
        for (CT_PhieuDat ctpd : Controller.controller.arrayListCT_PhieuDat) {
            dem2++;
            if (ctpd.getMaPD().equals("PD01")) {
                myTable2 = (DefaultTableModel) PD.tblCT_PhieuDat.getModel();
            }
        }
    }

    private GiaoDienXuatHoaDon() {
    }

    private void showCTPD1() {
        GiaoDienPhieuDat PD = new GiaoDienPhieuDat();
        GiaoDienHoaDon HD = new GiaoDienHoaDon();

        new LoadData();

        int dem2 = 0;
        myTable2.setRowCount(0);

        for (CT_PhieuDat ctpd : Controller.controller.arrayListCT_PhieuDat) {
            dem2++;
            if (ctpd.getMaPD().equals(txtPD.getText())) {
                myTable2.addRow(new Object[]{dem2, ctpd.getMaPD(), ctpd.getMaDH(), ctpd.getSoLuong(), ctpd.getGia()});
            }

        }
    }

    public GiaoDienXuatHoaDon(String Link, DefaultTableModel myTable2, JLabel dateBan, JLabel dateDat, JLabel dateGiao, JButton jButton1, JButton jButton2, JButton jButton3, JLabel jLabel1, JLabel jLabel10, JLabel jLabel11, JLabel jLabel12, JLabel jLabel14, JLabel jLabel2, JLabel jLabel20, JLabel jLabel3, JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9, JPanel jPanel1, JScrollPane jScrollPane1, JScrollPane jScrollPane3, JTable jTable1, JTable jTable2, JPanel pnl_TTCT, JLabel sdfs, JLabel txtDiaChi, JLabel txtHo, JLabel txtMHD, JLabel txtMSTHD, JLabel txtMaKH, JLabel txtMaNV, JLabel txtPD, JLabel txtTen, JLabel txtTongTien) throws HeadlessException {
        this.Link = Link;
        this.myTable2 = myTable2;
        this.dateBan = dateBan;
        this.dateDat = dateDat;
        this.dateGiao = dateGiao;
        this.btn_In = jButton2;
        this.jLabel1 = jLabel1;
        this.jLabel10 = jLabel10;
        this.jLabel11 = jLabel11;
        this.jLabel12 = jLabel12;
        this.jLabel14 = jLabel14;
        this.jLabel2 = jLabel2;
        this.jLabel20 = jLabel20;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.jLabel8 = jLabel8;
        this.jLabel9 = jLabel9;
        this.jScrollPane1 = jScrollPane1;
        this.jScrollPane3 = jScrollPane3;
        this.jTable1 = jTable1;
        this.jTable2 = jTable2;
        this.sdfs = sdfs;
        this.txtDiaChi = txtDiaChi;
        this.txtHo = txtHo;
        this.txtMHD = txtMHD;
        this.txtMSTHD = txtMSTHD;
        this.txtMaKH = txtMaKH;
        this.txtMaNV = txtMaNV;
        this.txtPD = txtPD;
        this.txtTen = txtTen;
        this.txtTongTien = txtTongTien;
    }

    private void Tien() {
        String Gia2;
        long Gia0 = 0;
        myTable2 = (DefaultTableModel) jTable2.getModel();
        for (int i = 0; i < myTable2.getRowCount(); i++) {
            BigDecimal Gia = new BigDecimal(myTable2.getValueAt(i, 4).toString());
            Gia = Gia.setScale(0, RoundingMode.HALF_UP);
            long Gia1 = Long.valueOf(Gia.toString());
            Gia0 = Gia0 + Gia1;

        }
        Gia2 = String.valueOf(Gia0);
        txtTongTien.setText(Gia2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sdfs = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JLabel();
        txtMHD = new javax.swing.JLabel();
        txtMSTHD = new javax.swing.JLabel();
        txtPD = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JLabel();
        txtHo = new javax.swing.JLabel();
        txtTen = new javax.swing.JLabel();
        dateDat = new javax.swing.JLabel();
        dateGiao = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JLabel();
        dateBan = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btn_In = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setTitle("XUẤT HÓA ĐƠN");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CỬA HÀNG BÁN ĐỒNG HỒ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, 790, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("HÓA ĐƠN BÁN HÀNG");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 39, 790, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã phiếu đặt:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, 25));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Mã nhân viên:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 104, -1, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Thông tin khách hàng:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 180, -1, -1));

        sdfs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sdfs.setText("Mã khách hàng:");
        jPanel1.add(sdfs, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 210, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MSTHD:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Ngày bán:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Họ :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 247, 105, 25));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Thành tiền:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 100, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Địa chỉ KH:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 282, 92, 25));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Ngày đặt:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 214, 85, 25));

        jTable2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu đặt", "Mã đồng hồ", "Số lượng", "Đơn giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jTable2.setEnabled(false);
        jTable2.setGridColor(new java.awt.Color(255, 102, 102));
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 760, 180));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Thông tin hóa đơn: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 76, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Ngày giao:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 251, 87, 25));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Danh sách mặt hàng trong hóa đơn:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Tên :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 251, 47, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã hóa đơn:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 141, -1, 25));

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 104, 257, 25));

        txtMHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtMHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 138, 260, 25));

        txtMSTHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtMSTHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 200, 28));

        txtPD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 200, 25));

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtMaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 257, 30));

        txtHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 245, 142, 31));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 251, 122, 25));

        dateDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(dateDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 214, 210, 25));

        dateGiao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(dateGiao, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 251, 210, 25));

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 282, 670, 26));

        dateBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(dateBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 299, 30));

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 140, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 167, 760, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 314, 760, -1));

        btn_In.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_In.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Print-icon.png"))); // NOI18N
        btn_In.setText("In");
        btn_In.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_In.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_In, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_In, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//setOrientation: đặt hướng trang
    private void btn_InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InActionPerformed

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.73, 0.75);

                jPanel1.paint(g2);

                return Printable.PAGE_EXISTS;

            }

        });

        boolean ok = job.printDialog();
        if (ok) {
            try {

                job.print();

            } catch (PrinterException ex) {
            }
        }

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_InActionPerformed

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed

    }//GEN-LAST:event_jTable2MousePressed

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
            java.util.logging.Logger.getLogger(GiaoDienXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                GiaoDienXuatHoaDon XHD = new GiaoDienXuatHoaDon();
                XHD.setLocationRelativeTo(null);
                XHD.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_In;
    private javax.swing.JLabel dateBan;
    private javax.swing.JLabel dateDat;
    private javax.swing.JLabel dateGiao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JLabel sdfs;
    private javax.swing.JLabel txtDiaChi;
    private javax.swing.JLabel txtHo;
    private javax.swing.JLabel txtMHD;
    private javax.swing.JLabel txtMSTHD;
    private javax.swing.JLabel txtMaKH;
    private javax.swing.JLabel txtMaNV;
    private javax.swing.JLabel txtPD;
    private javax.swing.JLabel txtTen;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
