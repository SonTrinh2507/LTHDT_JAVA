package CONNECTION;

import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.TaiKhoan;
import Controller.controller;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PC
 */
public class LoadData {

    public static void loadTableTaiKhoan() {
    ResultSet rs = DataConnection.retrieveData("select * from dbo.TaiKhoan");
    try {
        while (rs.next()) {
            String maNV = rs.getString("MaNV").trim();
            String matKhau = rs.getString("MatKhau").trim();
            int trangThaiXoa = rs.getInt("TrangThaiXoa");
            String maCV = rs.getString("MaCV");

            ChucVu chucVu = getChucVuByMaCV(maCV); // Lấy đối tượng ChucVu từ MaCV

            TaiKhoan taiKhoan = new TaiKhoan(maNV, matKhau, trangThaiXoa, chucVu,maCV);

            controller.arrayListTaiKhoan.add(taiKhoan);
        }
    } catch (SQLException ex) {
        Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
    }
}
private static ChucVu getChucVuByMaCV(String maCV) {
    // Thực hiện truy vấn hoặc tìm đối tượng ChucVu dựa trên MaCV
    // và trả về đối tượng ChucVu tương ứng.
    // Lưu ý: Đây chỉ là một ví dụ, bạn cần tùy chỉnh theo cách bạn truy xuất dữ liệu.

    // Ví dụ:
    ResultSet rs = DataConnection.retrieveData("select * from dbo.ChucVu where MaCV = '" + maCV + "'");
    ChucVu chucVu = null;
    try {
        if (rs.next()) {
            String tenCV = rs.getString("tenCV").trim();
            chucVu = new ChucVu(maCV, tenCV);
        }
    } catch (SQLException ex) {
        Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return chucVu;
}

    public static void loadTableNhanVien() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.NhanVien");
        try {
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString("MaNV").trim(),
                        rs.getString("HoNV").trim(),
                        rs.getString("TenNV").trim(),
                        rs.getString("GTNV").trim(),
                        rs.getString("DCNV"),
                        rs.getString("SDTNV").trim(),
                        rs.getInt("TrangThaiXoa"),
                        rs.getDate("NSNV"),
                        rs.getString("HinhAnh").trim());
                

                controller.arrayListNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableKhachHang() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.KhachHang");
        try {
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getString("MaKH").trim(),
                        rs.getString("CMND").trim(),
                        rs.getString("MSTKH").trim(),
                        rs.getString("HoKH").trim(),
                        rs.getString("TenKH").trim(),
                        rs.getString("GTKH").trim(),
                        rs.getDate("NSKH"),
                        rs.getString("DCKH").trim(),
                        rs.getString("SDTKH").trim(),
                        rs.getString("EMAIL").trim());
                controller.arrayListKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTablePhieuDat() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.PhieuDat");
        try {
            while (rs.next()) {
                PhieuDat pd = new PhieuDat(
                        rs.getString("MaPD").trim(),
                        rs.getString("HoKH").trim(),
                        rs.getString("TenKH").trim(),
                        rs.getString("DCKH").trim(),
                        rs.getString("MaKH").trim(),
                        rs.getString("SDTKH").trim(),
                        rs.getDate("NgayDat"),
                        rs.getDate("NgayGiao"));

                controller.arrayListPhieuDat.add(pd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableCT_PhieuDat() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.CT_PhieuDat");
        try {
            while (rs.next()) {
                CT_PhieuDat ctpd = new CT_PhieuDat(
                        rs.getString("MaPD").trim(),
                        rs.getInt("SLDat"),
                        rs.getBigDecimal("Gia"),
                        rs.getString("MaDH").trim());
                controller.arrayListCT_PhieuDat.add(ctpd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableCT_PhieuBaoHanh() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.CT_PhieuBaoHanh");
        try {
            while (rs.next()) {
                CT_PhieuBaoHanh ctpbh = new CT_PhieuBaoHanh(
                        rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim());
                controller.arrayListCT_PhieuBaoHanh.add(ctpbh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void loadTablePhieuBaoHanh() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.BaoHanh");

        Date datenow = Calendar.getInstance().getTime();
        try {
            while (rs.next()) {
                PhieuBaoHanh pbh = new PhieuBaoHanh(
                        rs.getString("MaPBH").trim(),
                        rs.getString("MaDH").trim(),
                        rs.getDate("NgayBD"),
                        rs.getDate("NgayKT"));
                controller.arrayListPhieuBaoHanh.add(pbh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableKhuyenMai() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.KhuyenMai");

        try {
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(
                        rs.getString("MaKM").trim(),
                        rs.getString("MaNV").trim(),
                        rs.getString("LyDoKM").trim(),
                        rs.getDate("NgayBD"),
                        rs.getDate("NgayKT"));
                controller.arrayListKhuyenMai.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableCT_KhuyenMai() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.CT_KhuyenMai");

        Date datenow = Calendar.getInstance().getTime();
        try {
            while (rs.next()) {
                CT_KhuyenMai ctkm = new CT_KhuyenMai(
                        rs.getString("MaKM").trim(),
                        rs.getString("MaDH").trim(),
                        rs.getInt("PTKM"));
                controller.arrayListCT_KhuyenMai.add(ctkm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableHoaDon() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.HoaDon");

        Date datenow = Calendar.getInstance().getTime();
        try {
            while (rs.next()) {
                HoaDon hd = new HoaDon(
                        rs.getString("MaHD").trim(),
                        rs.getString("MaNV").trim(),
                        rs.getString("MaPD").trim(),
                        rs.getString("MSTHD").trim(),
                        rs.getBigDecimal("ThanhTien"),
                        rs.getDate("NgayIn"));
                controller.arrayListHoaDon.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableDongHo() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.DongHo");

        Date datenow = Calendar.getInstance().getTime();
        try {

            while (rs.next()) {
                DongHo dh = new DongHo(
                        rs.getString("MaDH").trim(),
                        rs.getString("TenDH").trim(),
                        //rs.getBytes(8),
                        rs.getString("MoTa").trim(),
                        rs.getString("MaLoai").trim(),
                        rs.getString("MaHang").trim(),
                        rs.getBigDecimal("Gia"),
                        rs.getInt("SLTon"),
                        rs.getString("HinhAnh").trim());
                        
                // Gán giá trị cho thuộc tính loaiDH
                controller.arrayListDongHo.add(dh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableLoaiDH() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.LoaiDH");

        Date datenow = Calendar.getInstance().getTime();
        try {
            while (rs.next()) {
                LoaiDH ldh = new LoaiDH(
                        rs.getString("MaLoai").trim(),
                        rs.getString("TenLoai").trim());
                controller.arrayListLoaiDH.add(ldh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadTableHangDH() {
        ResultSet rs = DataConnection.retrieveData("select * from dbo.HangDH");

        Date datenow = Calendar.getInstance().getTime();
        try {
            while (rs.next()) {
                HangDH hdh = new HangDH(
                        rs.getString("MaHang").trim(),
                        rs.getString("TenHang").trim());
                controller.arrayListHangDH.add(hdh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public LoadData() {
        Controller.controller.arrayListTaiKhoan.removeAll(Controller.controller.arrayListTaiKhoan);
        Controller.controller.arrayListNhanVien.removeAll(Controller.controller.arrayListNhanVien);
        Controller.controller.arrayListKhachHang.removeAll(Controller.controller.arrayListKhachHang);
        Controller.controller.arrayListPhieuDat.removeAll(Controller.controller.arrayListPhieuDat);
        Controller.controller.arrayListCT_PhieuDat.removeAll(Controller.controller.arrayListCT_PhieuDat);
        Controller.controller.arrayListPhieuBaoHanh.removeAll(Controller.controller.arrayListPhieuBaoHanh);
        Controller.controller.arrayListCT_PhieuBaoHanh.removeAll(Controller.controller.arrayListCT_PhieuBaoHanh);
        Controller.controller.arrayListKhuyenMai.removeAll(Controller.controller.arrayListKhuyenMai);
        Controller.controller.arrayListChucVu.removeAll(Controller.controller.arrayListChucVu);
        Controller.controller.arrayListHoaDon.removeAll(Controller.controller.arrayListHoaDon);
        Controller.controller.arrayListDongHo.removeAll(Controller.controller.arrayListDongHo);
        Controller.controller.arrayListLoaiDH.removeAll(Controller.controller.arrayListLoaiDH);
        Controller.controller.arrayListHangDH.removeAll(Controller.controller.arrayListHangDH);
        Controller.controller.arrayListCT_KhuyenMai.removeAll(Controller.controller.arrayListCT_KhuyenMai);

        loadTableCT_PhieuDat();
        loadTableCT_KhuyenMai();
        loadTableCT_PhieuBaoHanh();
        loadTableDongHo();
        loadTableHoaDon();
        loadTableKhachHang();
        loadTableKhuyenMai();
        loadTableNhanVien();
        loadTablePhieuBaoHanh();
        loadTablePhieuDat();
        loadTableTaiKhoan();
        loadTableHangDH();
        loadTableLoaiDH();

    }

}
