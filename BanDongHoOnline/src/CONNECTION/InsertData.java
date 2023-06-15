package CONNECTION;

import Model.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author conghau
 */
public class InsertData {

    public static void insertTaiKhoan(TaiKhoan taiKhoan) {
        String sqlCommand = "insert into dbo.TaiKhoan values(?,?,?,?)";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, taiKhoan.getMaNV());
            ps.setString(2, taiKhoan.getMatKhau());
            ps.setInt(3, taiKhoan.getTrangThaiXoa());
            ps.setString(4, taiKhoan.getMaCV());

            ps.executeUpdate();

            System.out.println("thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean insertNhanVien(NhanVien nv) {
        String sqlCommand = "EXEC [dbo].[insert_NhanVien] ?,?,?,?,?,?,?,? ";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, nv.getHoNV());
            ps.setString(2, nv.getTenNV());
            ps.setString(3, nv.getGtNV());
            ps.setDate(4, new Date(nv.getNsNV().getTime()));
            ps.setString(5, nv.getDcNV());
            ps.setString(6, nv.getStdNV());
            ps.setInt(7, nv.getTrangThai());
            ps.setString(8, nv.getHinhAnh());

            if (ps.executeUpdate() > 0) {
                System.out.println("thêm nhân viên thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm nhân viên thất bại");
        return false;
    }

    public static boolean insertKhachHang(KhachHang kh) {
        String sqlCommand = "EXEC [dbo].[insert_KhachHang] ?,?,?,?,?,?,?,?,?";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, kh.getCMND());
            ps.setString(2, kh.getMSTKH());
            ps.setString(3, kh.getHoKH());
            ps.setString(4, kh.getTenKH());
            ps.setString(5, kh.getGtKH());
            ps.setDate(6, new Date(kh.getNsKH().getTime()));
            ps.setString(7, kh.getDcKH());
            ps.setString(8, kh.getStdKH());
            ps.setString(9, kh.getEmailKH());
            if (ps.executeUpdate() > 0) {
                System.out.println("thêm khách hàng thành công");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm khách hàng thất bại");
        return false;
    }

    public static boolean insertDongHo(DongHo dh) {
        String sqlCommand = "insert into dbo.DongHo(MaDH,TenDH,MoTa,MaLoai,MaHang,Gia,SLTon,HinhAnh) values(?,?,?,?,?,?,?,?)";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, dh.getMaDH());
            ps.setString(2, dh.getTenDH());
            ps.setString(3, dh.getMoTa());
            ps.setString(4, dh.getMaLoai());
            ps.setString(5, dh.getMaHang());
            ps.setBigDecimal(6, dh.getGia());
            ps.setInt(7, dh.getSLTon());
            ps.setString(8, dh.getHinhAnh());
            if (ps.executeUpdate() > 0) {
                System.out.println("thêm đồng hồ thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm đồng hồ thất bại");
        return false;
    }

    public static boolean insertPhieuDat(PhieuDat pd,CT_PhieuDat ctpd) {
        String sqlCommand = "EXEC [dbo].[insert_PhieuDat] ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, pd.getMaKH());
            ps.setString(2, pd.getHoKH());
            ps.setString(3, pd.getTenKH());
            ps.setString(4, pd.getDcKH());
            ps.setString(5, pd.getSdtKH());
            ps.setDate(6, new Date(pd.getNgayDat().getTime()));
            ps.setDate(7, new Date(pd.getNgayGiao().getTime()));
            ps.setString(8,ctpd.getMaDH());
            ps.setInt(9, ctpd.getSoLuong());
            ps.setBigDecimal(10, ctpd.getGia());
            if (ps.executeUpdate() > 0) {
                System.out.println("thêm phiếu đặt thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm phiếu đặt thất bại");
        return false;
    }

    public static boolean insertHoaDon(HoaDon hd) {
        String sqlCommand = "EXEC [dbo].[insert_HoaDon] ?,?,?,?,?";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, hd.getMaPD());
            ps.setString(2, hd.getMaNV());
            ps.setString(3, hd.getMSTHD());
            ps.setDate(4, new Date(hd.getNgayIn().getTime()));
            ps.setBigDecimal(5, hd.getThanhTien());
            if (ps.executeUpdate() > 0) {
                System.out.println("thêm hóa đơn thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm hóa đơn thất bại");
        return false;
    }

    public static boolean insertCT_BaoHanh(CT_PhieuBaoHanh ctbh) {
        String sqlCommand = "insert into dbo.CT_PhieuBaoHanh values(?,?,?)";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, ctbh.getMaPBH());
            ps.setString(2, ctbh.getMaNV());
            ps.setString(3, ctbh.getTrangThai());

            if (ps.executeUpdate() > 0) {
                System.out.println("thêm chi tiết phiếu bảo hành thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm chi tiết phiếu bảo hành thất bại");
        return false;
    }

    public static boolean insertKhuyenMai(KhuyenMai km,CT_KhuyenMai ctkm) {

        String sqlCommand = "EXEC [dbo].[insert_KhuyenMai] ?,?,?,?,?,?";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, km.getLyDoKM());
            ps.setDate(2, new Date(km.getNgayBD().getTime()));
            ps.setDate(3, new Date(km.getNgayKT().getTime()));
            ps.setString(4, km.getMaNV());
            ps.setString(5, ctkm.getMaDH());
            ps.setFloat(6, ctkm.getPTKM());

            if (ps.executeUpdate() > 0) {
                System.out.println("thêm khuyến mãi thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm khuyến mãi thất bại");
        return false;
    }

    public static boolean insertCT_KhuyenMai(CT_KhuyenMai ctkm) {
        String sqlCommand = "insert into dbo.CT_KhuyenMai values(?,?,?)";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);

            ps.setString(1, ctkm.getMaKM());
            ps.setString(2, ctkm.getMaDH());
            ps.setInt(3, ctkm.getPTKM());
            if (ps.executeUpdate() > 0) {
                System.out.println("thêm chi tiết khuyến mãi thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm chi tiết khuyến mãi thất bại");
        return false;
    }

    public static boolean insertPhieuBaoHanh(PhieuBaoHanh bh) {
        String sqlCommand = "EXEC [dbo].[insert_BaoHanh] ?,?,?";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, bh.getMaDH());
            ps.setDate(2, new Date(bh.getNgayBD().getTime()));
            ps.setDate(3, new Date(bh.getNgayKT().getTime()));

            if (ps.executeUpdate() > 0) {
                System.out.println("thêm bảo hành thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm bảo hành thất bại");
        return false;
    }

    public static boolean insertCT_PhieuDat(CT_PhieuDat ctpd) {
        String sqlCommand = "insert into dbo.CT_PhieuDat values(?,?,?,?)";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, ctpd.getMaPD());
            ps.setString(2, ctpd.getMaDH());
            ps.setInt(3, ctpd.getSoLuong());
            ps.setBigDecimal(4, ctpd.getGia());

            if (ps.executeUpdate() > 0) {
                System.out.println("thêm chi tiết phiếu đặt thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm chi tiết phiếu đặt thất bại");
        return false;
    }

    public static boolean insertLoaiDH(LoaiDH ldh) {
        String sqlCommand = "insert into dbo.LoaiDH values(?,?)";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, ldh.getMaLoai());
            ps.setString(2, ldh.getTenLoai());
            if (ps.executeUpdate() > 0) {
                System.out.println("thêm loại đồng hồ thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm loại đồng hồ thất bại");
        return false;
    }

    public static boolean insertHangDH(HangDH hdh) {
        String sqlCommand = "insert into dbo.HangDH values(?,?)";
        try {
            DataConnection.createStatement();
            PreparedStatement ps = DataConnection.connection.prepareStatement(sqlCommand);
            ps.setString(1, hdh.getMaHang());
            ps.setString(2, hdh.getTenHang());
            if (ps.executeUpdate() > 0) {
                System.out.println("thêm hãng đồng hồ thành công");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("thêm hãng đồng hồ thất bại");
        return false;
    }

}
