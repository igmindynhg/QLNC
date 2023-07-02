package Molder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class QLHDDTModel extends BaseModel {
    private String maHHDT;   
    private int ngansach;
    private Date ngaybatdau;
    private Date ngayketthuc;

    public QLHDDTModel(String maHHDT, int ngansach, Date ngaybatdau, Date ngayketthuc) {
        this.maHHDT = maHHDT;
        this.ngansach = ngansach;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }
 public ArrayList<QLHDDTModel> getService2() {
        ArrayList<QLHDDTModel> arr2 = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select MaHDDT, NganSach,NgayBatDau,NgayKetThuc from HopDongDoiTac ";/// 
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                QLHDDTModel ql = new QLHDDTModel();
                ql.setMaHHDT(rs.getString(1));
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
 public boolean addhd2(QLHDDTModel hd) {
        try {
            Connection conn = this.getConnBaseModel();
            System.out.println(hd);
            String sql = "SELECT COUNT(*) FROM HopDongDoiTac WHERE MaHDDT = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            System.out.println(hd);
            stm.setString(1, hd.getMaHHDT());
            System.out.println(hd.getMaHHDT());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) { // vl sai trong đây :)))
                int count = rs.getInt(1);
                System.out.println(count);
                if (count == 0) { // vẫn đúng ở đây =))
                    // Nếu count == 0 nghĩa là mã dịch vụ chưa tồn tại hạ chạy thử đi van dung tu
                    sql = "INSERT INTO HopDongDoiTac VALUES (?,?,?,?,null)";
                    System.out.println("1");
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println("1");
                    String date11 = format.format(hd.getNgaybatdau());
                    String date22 = format.format(hd.getNgayketthuc());
                    System.out.println("1");
//                    System.out.println("sql");
                    stm = conn.prepareStatement(sql);
                    System.out.println("1");
                    stm.setString(1, hd.getMaHHDT());
                    stm.setInt(2, hd.getNgansach());
                    stm.setString(3, date11);
                    stm.setString(4, date22);
                    System.out.println("1");
                    stm.executeUpdate();
//                    stm.executeUp
// đây lỗi đây r đm dòng này không chạy, xong r đấy
                    System.out.println("loi day à");
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
  public int CountNhanCong() {
        int i = 1;
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select count(NganSach) from HopDongDoiTac";
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

    @Override
    public String toString() {
        return "QLHDDTModel{" + "maHHDT=" + maHHDT + ", ngansach=" + ngansach + ", ngaybatdau=" + ngaybatdau + ", ngayketthuc=" + ngayketthuc + '}';
    }
 
    public QLHDDTModel() {
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

    public boolean deleteDV(QLHDDTModel hd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "delete from HopDongDoiTac where MaHDDT=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st = conn.prepareStatement(sql);
            st.setString(1, hd.maHHDT);
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("ao that day");
        }
        return false;
    }
public ArrayList<QLHDDTModel> timkiem(String key) {
        ArrayList<QLHDDTModel> arr2 = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "SELECT * FROM  HopDongDoiTac WHERE MaHDDT LIKE '%" + key + "%' ";
//            System.out.println(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                QLHDDTModel foundhd = new QLHDDTModel();
                foundhd.setMaHHDT(rs.getString(1));
                foundhd.setNgansach(rs.getInt(2));
                foundhd.setNgaybatdau(rs.getDate(3));
                foundhd.setNgayketthuc(rs.getDate(4));
                arr2.add(foundhd);
            }
            return arr2;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arr2;
    }
  public boolean edithd(QLHDDTModel hd) {
        try {
            Connection conn = this.getConnBaseModel();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format.format(hd.getNgaybatdau());
            String date2 = format.format(hd.getNgayketthuc());
            String sql = "UPDATE HopDongDoiTac SET NganSach=?,Ngaybatdau=?,Ngayketthuc=? WHERE maHDDT=? ";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setInt(1, hd.getNgansach());
            stm.setString(2, date1);
            stm.setString(3, date2);
            stm.setString(4, hd.getMaHHDT());
            stm.executeUpdate();
            return true;

        } catch (SQLException ex) {

            System.out.println("huhu");

        }
        return false;
    }  
}