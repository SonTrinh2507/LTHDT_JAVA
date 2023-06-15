/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */

public class TaiKhoan {

    private String MaNV;
    private String MatKhau;
    private int TrangThaiXoa;
    private  String MaCV;
    private ChucVu chucVu;
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getTrangThaiXoa() {
        return TrangThaiXoa;
    }

   

    public void setTrangThaiXoa(int TrangThaiXoa) {
        this.TrangThaiXoa = TrangThaiXoa;
    }

    
    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public TaiKhoan(String MaNV, String MatKhau, int TrangThaiXoa,ChucVu chucVu,String MaCV) {
        this.MaNV = MaNV;
        this.MatKhau = MatKhau;
        this.TrangThaiXoa = TrangThaiXoa;
        this.MaCV = MaCV;
        this.chucVu = chucVu;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public TaiKhoan() {

    }
}
