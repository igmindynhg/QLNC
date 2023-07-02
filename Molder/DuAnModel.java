/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AD
 */
public class DuAnModel extends BaseModel {

    private String maDuAn;
    private String tenDuAn;
    private String linhVuc;
    private String HanNgay;
    private int NganSach;
    private boolean TrangThai;
    private String TaiKhoan;
    private String maCongViec;
    private String maHopDongDoiTac;

    public DuAnModel(String maDuAn, String tenDuAn, String linhVuc, String HanNgay, int NganSach, boolean TrangThai, String TaiKhoan, String maCongViec, String maHopDongDoiTac) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.linhVuc = linhVuc;
        this.HanNgay = HanNgay;
        this.NganSach = NganSach;
        this.TrangThai = TrangThai;
        this.TaiKhoan = TaiKhoan;
        this.maCongViec = maCongViec;
        this.maHopDongDoiTac = maHopDongDoiTac;
    }

    public DuAnModel(String maDuAn, String tenDuAn, String linhVuc, String HanNgay, int NganSach, boolean TrangThai, String TaiKhoan) {
        this.maDuAn = maDuAn;
        this.tenDuAn = tenDuAn;
        this.linhVuc = linhVuc;
        this.HanNgay = HanNgay;
        this.NganSach = NganSach;
        this.TrangThai = TrangThai;
        this.TaiKhoan = TaiKhoan;
    }

    @Override
    public String toString() {
        return "DuAnModel{" + "maDuAn=" + maDuAn + ", tenDuAn=" + tenDuAn + ", linhVuc=" + linhVuc + ", HanNgay=" + HanNgay + ", NganSach=" + NganSach + ", TrangThai=" + TrangThai + ", TaiKhoan=" + TaiKhoan + ", maCongViec=" + maCongViec + ", maHopDongDoiTac=" + maHopDongDoiTac + '}';
    }

    public DuAnModel() {
    }

    public ArrayList<DuAnModel> getDuLieu() {
        ArrayList<DuAnModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from DuAn");
            while (rs.next()) {
                DuAnModel da = new DuAnModel();
                da.setMaDuAn(rs.getString(1));
                da.setTenDuAn(rs.getString(2));
                da.setLinhVuc(rs.getString(3));
                da.setHanNgay(rs.getString(4));
                da.setNganSach(rs.getInt(5));
                da.setTrangThai(rs.getBoolean(6));
                da.setTaiKhoan(rs.getString(7));
                da.setMaCongViec(rs.getString(8));
                da.setMaHopDongDoiTac(rs.getString(9));

                arr.add(da);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
public ArrayList<DuAnModel> getDuLieu1() {
        ArrayList<DuAnModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from DuAn where TrangThai ='0'");
            while (rs.next()) {
                DuAnModel da = new DuAnModel();
                da.setMaDuAn(rs.getString(1));
                da.setTenDuAn(rs.getString(2));
                da.setLinhVuc(rs.getString(3));
                da.setHanNgay(rs.getString(4));
                da.setNganSach(rs.getInt(5));
                da.setTrangThai(rs.getBoolean(6));
                da.setTaiKhoan(rs.getString(7));
                da.setMaCongViec(rs.getString(8));
                da.setMaHopDongDoiTac(rs.getString(9));

                arr.add(da);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
public ArrayList<DuAnModel> getDuLieu0() {
        ArrayList<DuAnModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from DuAn where  TrangThai ='1'");
            while (rs.next()) {
                DuAnModel da = new DuAnModel();
                da.setMaDuAn(rs.getString(1));
                da.setTenDuAn(rs.getString(2));
                da.setLinhVuc(rs.getString(3));
                da.setHanNgay(rs.getString(4));
                da.setNganSach(rs.getInt(5));
                da.setTrangThai(rs.getBoolean(6));
                da.setTaiKhoan(rs.getString(7));
                da.setMaCongViec(rs.getString(8));
                da.setMaHopDongDoiTac(rs.getString(9));

                arr.add(da);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
    public Boolean addDuAn(DuAnModel da) {
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select count(*) from DuAn where MaDA = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, da.getMaDuAn());
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);

                if (count == 0) {
                    sql = "insert into DuAn values(?,?,?,?,?,?,?,?,?)";
                    st = conn.prepareStatement(sql);
                    st.setString(1, da.getMaDuAn());
                    st.setString(2, da.getTenDuAn());
                    st.setString(3, da.getLinhVuc());
                    st.setString(4, da.getHanNgay());
                    st.setInt(5, da.getNganSach());
                    st.setBoolean(6, da.getTrangThai());
                    st.setString(7, da.getTaiKhoan());
                    st.setString(8, da.getMaCongViec());
                    st.setString(9, da.getMaHopDongDoiTac());

                    st.executeUpdate();

                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
        }

        return false;
    }

    public boolean deleteDA(DuAnModel da) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "delete from DuAn where MaDA = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, da.getMaDuAn());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Xóa bị lỗi");
        }
        return false;
    }
        public Boolean updateda(DuAnModel da){
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "  update DuAn set TenDA =?, LinhVuc =?,HanNgay=?,NganSach=?,TrangThai =?,TaiKhoan=?,MaCV =?, MaHDDT =? where MaDA =?";
            PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(9, da.getMaDuAn());
                    st.setString(1, da.getTenDuAn());
                    st.setString(2, da.getLinhVuc());
                    st.setString(3, da.getHanNgay());
                    st.setInt(4, da.getNganSach());
                    st.setBoolean(5, da.getTrangThai());
                    st.setString(6, da.getTaiKhoan());
                    st.setString(7, da.getMaCongViec());
                    st.setString(8, da.getMaHopDongDoiTac());
                    System.out.println("/");
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            
            System.out.println("cuu!");
//            System.out.println(sql);
        }
    return false;
    }
        public Boolean updateda1(DuAnModel da){
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "  update DuAn set TrangThai =?,TaiKhoan=? where MaDA =?";
            PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(3, da.getMaDuAn());
                    st.setBoolean(1, da.getTrangThai());
                    st.setString(2, da.getTaiKhoan());
                    System.out.println("/");
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            
            System.out.println("cuu!");
//            System.out.println(sql);
        }
    return false;
    }
        public int CountNhanCong() {
        int i = 1;
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select count(MaDA) from DuAn";
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
    public boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getHanNgay() {
        return HanNgay;
    }

    public void setHanNgay(String HanNgay) {
        this.HanNgay = HanNgay;
    }

    public int getNganSach() {
        return NganSach;
    }

    public void setNganSach(int NganSach) {
        this.NganSach = NganSach;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }

    public String getMaHopDongDoiTac() {
        return maHopDongDoiTac;
    }

    public void setMaHopDongDoiTac(String maHopDongDoiTac) {
        this.maHopDongDoiTac = maHopDongDoiTac;
    }

    public ArrayList<DuAnModel> timDuAnModels(String key) {
                ArrayList<DuAnModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select*from DuAn where NganSach like '%"+key+"%' or LinhVuc like '%"+key+"%'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            DuAnModel da = new DuAnModel();
            da.setMaDuAn(rs.getString(1));
            da.setTenDuAn(rs.getString(2));
            da.setLinhVuc(rs.getString(3));
            da.setHanNgay(rs.getString(4));
            da.setNganSach(rs.getInt(5));
            da.setTrangThai(rs.getBoolean(6));
            da.setTaiKhoan(rs.getString(7));
            da.setMaCongViec(rs.getString(8));
            da.setMaHopDongDoiTac(rs.getString(9));
            
            arr.add(da);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Không có");
        }
        return arr;
    }
        public ArrayList<DuAnModel> timDuAnModels1(String key) {
                ArrayList<DuAnModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select MaDA,TenDA,LinhVuc,HanNgay,NganSach,TrangThai,TaiKhoan from DuAn where NganSach like '%"+key+"%' or LinhVuc like '%"+key+"%'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            DuAnModel da = new DuAnModel();
            da.setMaDuAn(rs.getString(1));
            da.setTenDuAn(rs.getString(2));
            da.setLinhVuc(rs.getString(3));
            da.setHanNgay(rs.getString(4));
            da.setNganSach(rs.getInt(5));
            da.setTrangThai(rs.getBoolean(6));
            da.setTaiKhoan(rs.getString(7));
            
            arr.add(da);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Không có");
        }
        return arr;
    }

}
