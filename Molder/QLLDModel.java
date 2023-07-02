/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AD
 */
public class QLLDModel extends BaseModel{
     private String maNguoiDung;
    private String hoTen;
    private String email;
    private String diaChi;
    private Boolean gioiTinh;
    private String canCuocCongDan;
    private String soDienThoai;
    private String taiKhoan;
    private String matKhau;
    private String vaiTro;
    private Boolean trangThaiTaiKhoan;
    private String maHopDong;

    public QLLDModel(String maNguoiDung, String hoTen, String diaChi, String canCuocCongDan, String soDienThoai, String taiKhoan) {
        this.maNguoiDung = maNguoiDung;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
    }

    

    @Override
    public String toString() {
        return "QLLDModel{" + "maNguoiDung=" + maNguoiDung + ", hoTen=" + hoTen + ", email=" + email + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", canCuocCongDan=" + canCuocCongDan + ", soDienThoai=" + soDienThoai + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + ", trangThaiTaiKhoan=" + trangThaiTaiKhoan + ", maHopDong=" + maHopDong + '}';
    }

    public QLLDModel() {
    }
       public Boolean addLD(QLLDModel ld){
             try {
            Connection conn = this.getConnBaseModel();
            String sql ="select count(*) from NguoiDung where TaiKhoan = ? or MaND = ?";
            
            PreparedStatement st = conn.prepareStatement(sql);
                 
            st.setString(1, ld.getTaiKhoan());
            st.setString(2, ld.getMaNguoiDung());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println(count);
                if (count ==0) {
                     sql ="insert into NguoiDung values (?,?,null,?,null,?,?,?,null,null,'1',null)";
                    
                    st = conn.prepareStatement(sql);
                    
                    st.setString(1,ld.getMaNguoiDung());
                    
                    st.setString(2, ld.getHoTen());
                    st.setString(3, ld.getDiaChi());
                    st.setString(5,ld.getSoDienThoai());
                    st.setString(4, ld.getCanCuocCongDan());
                    st.setString(6, ld.getTaiKhoan());
                    
                    st.executeUpdate();
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
        }
        
        return false;
       }
           public boolean  deleteLD(QLLDModel ld){
    String sql ="";
        try {
            Connection conn = this.getConnBaseModel();
            sql ="delete from NguoiDung where TaiKhoan = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ld.getTaiKhoan());
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Xóa bị lỗi");
        }
        return false;
    }
        public Boolean updateLD(QLLDModel ld){
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "update NguoiDung set MaND= ?, HoTen = ?,DiaChi = ?, SoDienThoai =?,CanCuocCongDan =? where TaiKhoan = ?";
            PreparedStatement st = conn.prepareStatement(sql);
           st.setString(1,ld.getMaNguoiDung());
                    
                    st.setString(2, ld.getHoTen());
                    st.setString(3, ld.getDiaChi());
                    st.setString(5,ld.getSoDienThoai());
                    st.setString(4, ld.getCanCuocCongDan());
                    st.setString(6, ld.getTaiKhoan());
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            
            System.out.println("cuu!");
//            System.out.println(sql);
        }
    return false;
    }
        
        public int CountNhanCong() {
        int i = 1;
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select count(MaND) from NguoiDung";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                i = rs.getInt(i);
                System.out.println(i);
            }
            return i;
        } catch (Exception ex) {
            System.out.println("Không thống kê được ");

        }
        return i;
    }
        
       
       
    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        this.canCuocCongDan = canCuocCongDan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Boolean getTrangThaiTaiKhoan() {
        return trangThaiTaiKhoan;
    }

    public void setTrangThaiTaiKhoan(Boolean trangThaiTaiKhoan) {
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }
    
}
