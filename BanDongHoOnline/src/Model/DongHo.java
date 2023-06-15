package Model;

import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class DongHo {

    private String MaDH, TenDH, MoTa, MaLoai, MaHang;
    private BigDecimal Gia;
    private int SLTon;
    private String HinhAnh;
    public DongHo(String MaDH, String TenDH, String MoTa, String MaLoai, String MaHang, BigDecimal Gia, int SLTon, String HinhAnh) {
        this.MaDH = MaDH;
        this.TenDH = TenDH;
        this.Gia = Gia;
        this.MoTa = MoTa;
        this.MaLoai = MaLoai;
        this.MaHang = MaHang;
        this.SLTon = SLTon;
        this.HinhAnh = HinhAnh;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getMaDH() {
        return MaDH;
    }

    public String getTenDH() {
        return TenDH;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public BigDecimal getGia() {
        return Gia;
    }

    public int getSLTon() {
        return SLTon;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public void setTenDH(String TenDH) {
        this.TenDH = TenDH;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public void setGia(BigDecimal Gia) {
        this.Gia = Gia;
    }

    public void setSLTon(int SLTon) {
        this.SLTon = SLTon;
    }
}