package Molder;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class QLHDModel extends BaseModel {

    private String maHD;
    private String maHHDT;
    private int luong;
    private int ngansach;
    private Date ngaybatdau;
    private Date ngayketthuc;
    private Date ngaybatdau1;
    private Date ngayketthuc1;

    public Date getNgaybatdau1() {
        return ngaybatdau1;
    }

    public void setNgaybatdau1(Date ngaybatdau1) {
        this.ngaybatdau1 = ngaybatdau1;
    }

    public Date getNgayketthuc1() {
        return ngayketthuc1;
    }

    public void setNgayketthuc1(Date ngayketthuc1) {
        this.ngayketthuc1 = ngayketthuc1;
    }
    

    public String getMaHHDT() {
        return maHHDT;
    }

    public void setMaHHDT(String maHHDT) {
        this.maHHDT = maHHDT;
    }
    
    public int getNgansach() {
        return ngansach;
    }

    public void setNgansach(int ngansach) {
        this.ngansach = ngansach;
    }

    public QLHDModel(String maHD,  int luong, Date ngaybatdau, Date ngayketthuc) {
        this.maHD = maHD;    
        this.luong = luong;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }

   
    
    

    



    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public QLHDModel() {
    }

    @Override
    public String toString() {
        return "QLHDModel{" + "maHD=" + maHD + ", luong=" + luong + ", ngaybatdau=" + ngaybatdau + ", ngayketthuc=" + ngayketthuc + '}';
    }

    public ArrayList<QLHDModel> getService1() {
        ArrayList<QLHDModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select*from HopDongNhanCong ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                QLHDModel ql = new QLHDModel();
                ql.setMaHD(rs.getString(1));
                ql.setLuong(rs.getInt(2));
                ql.setNgaybatdau(rs.getDate(3));
                ql.setNgayketthuc(rs.getDate(4));
                arr.add(ql);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("noop");
        }
        return arr;
    }

    public ArrayList<QLHDModel> getService2() {
        ArrayList<QLHDModel> arr2 = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select MaHDDT, NganSach,NgayBatDau,NgayKetThuc from HopDongDoiTac ";/// 
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                QLHDModel ql = new QLHDModel();
                ql.setMaHD(rs.getString(1));
                ql.setNgansach(rs.getInt(2));
                ql.setNgaybatdau(rs.getDate(3));
                ql.setNgayketthuc(rs.getDate(4));
                arr2.add(ql);
            }
            return arr2;
        } catch (SQLException ex) {
            System.out.println("noop");
            System.out.println(arr2);
        }
        return arr2;
    }

    public boolean addhd(QLHDModel hd) {
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "SELECT COUNT(*) FROM HopDongNhanCong WHERE maHD = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hd.getMaHD());
            System.out.println(hd);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count == 0) {
                    // Nếu count == 0 nghĩa là mã dịch vụ chưa tồn tại
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String date1 = format.format(hd.getNgaybatdau());
                    String date2 = format.format(hd.getNgayketthuc());
                    sql = "INSERT INTO HopDongNhanCong VALUES (?, ?, ?,?)";
//                    System.out.println("sql");
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, hd.getMaHD());
                    stm.setInt(2, hd.getLuong());
                    stm.setString(3, date1);
                    stm.setString(4, date2);
                    stm.executeUpdate();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("huhu");
        }
        return false;
    }
    /* public boolean addhd2(QLHDModel hd) {
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "SELECT COUNT(*) FROM HopDongDoiTac WHERE MaHDDT = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hd.getMaHHDT());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count == 0) {
                    // Nếu count == 0 nghĩa là mã dịch vụ chưa tồn tại hạ chạy thử đi
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String date11 = format.format(hd.getNgaybatdau());
                    String date22 = format.format(hd.getNgayketthuc());
                    System.out.println("1");
                    sql = "INSERT INTO HopDongDoiTac VALUES (?, ?, ?,?)";
//                    System.out.println("sql");
System.out.println("2");
                    stm = conn.prepareStatement(sql);
                     System.out.println("1");
                    
                    stm.setString(1, hd.getMaHHDT());
                    stm.setInt(2, hd.getNgansach());
                    stm.setString(3, date11);
                    stm.setString(4, date22);
                    stm.executeUpdate();
                    System.out.println(hd);
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("huhu");
        }
        return false;
    }
*/
    public boolean edithd(QLHDModel hd) {
        try {
            Connection conn = this.getConnBaseModel();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format.format(hd.getNgaybatdau());
            String date2 = format.format(hd.getNgayketthuc());
            String sql = "UPDATE HopDongNhanCong SET Luong=?,Ngaybatdau=?,Ngayketthuc=? WHERE maHD=? ";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, hd.getLuong());
            stm.setString(2, date1);
            stm.setString(3, date2);
            stm.setString(4, hd.getMaHD());
            stm.executeUpdate();
            return true;

        } catch (SQLException ex) {

            System.out.println("huhu");

        }
        return false;
    }

    public boolean deleteDV(QLHDModel hd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "delete from HopDongNhanCong where maHD=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st = conn.prepareStatement(sql);
            st.setString(1, hd.maHD);
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("ao that day");
        }
        return false;
    }
// 2có 2 đoạn này thôi
    public ArrayList<QLHDModel> timkiem(String key) {
        ArrayList<QLHDModel> arr1 = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "SELECT * FROM  HopDongNhanCong WHERE maHD LIKE '%" + key + "%' or Luong LIKE '%" + key + "%' ";
//            System.out.println(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                QLHDModel foundhd = new QLHDModel();
                foundhd.setMaHD(rs.getString(1));
                foundhd.setLuong(rs.getInt(2));
                foundhd.setNgaybatdau(rs.getDate(3));
                foundhd.setNgayketthuc(rs.getDate(4));
                arr1.add(foundhd);
            }
            return arr1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arr1;
    }
            public int CountNhanCong() {
        int i = 1;
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select sum(Luong) from HopDongNhanCong";
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
            public int CountNhanCong1() {
        int i = 1;
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select count(MaHD) from HopDongNhanCong";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                i = rs.getInt(i);
                System.out.println(i);
            }
            return i;
        } catch (Exception ex) {
            System.out.println("bug af ");

        }
        return i;
    }
}