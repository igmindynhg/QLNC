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
//import java.sql.SQLException;
//import java.util.ArrayList;

/**
 *
 * @author AD
 */
public class NguoiDungModel extends BaseModel {

    @Override
    public String toString() {
        return "NguoiDungModel{" + "maNguoiDung=" + maNguoiDung + ", hoTen=" + hoTen + ", email=" + email + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", canCuocCongDan=" + canCuocCongDan + ", soDienThoai=" + soDienThoai + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + ", trangThaiTaiKhoan=" + trangThaiTaiKhoan + ", maHopDong=" + maHopDong + '}';
    }

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

    public NguoiDungModel(String maNguoiDung, String hoTen, String email, String diaChi, Boolean gioiTinh, String canCuocCongDan, String soDienThoai, String taiKhoan, String matKhau, String vaiTro, Boolean trangThaiTaiKhoan, String maHopDong) {
        this.maNguoiDung = maNguoiDung;
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
        this.maHopDong = maHopDong;
    }

    public NguoiDungModel(String hoTen, String taiKhoan, String matKhau) {
        this.hoTen = hoTen;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public NguoiDungModel(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public NguoiDungModel(String hoTen, String email, String diaChi, String canCuocCongDan, String soDienThoai) {
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
    }

    public NguoiDungModel(String taiKhoan, String matKhau, String vaiTro, Boolean trangThaiTaiKhoan) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public NguoiDungModel(String hoTen, String email, String diaChi, String canCuocCongDan, String soDienThoai, String vaiTro) {
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
        this.vaiTro = vaiTro;
    }

    public NguoiDungModel(String hoTen, String email, String diaChi, String canCuocCongDan, String soDienThoai, String taiKhoan, String matKhau, String vaiTro) {
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public NguoiDungModel(String hoTen, String email, String diaChi, String canCuocCongDan, String soDienThoai, String taiKhoan, String matKhau) {
        this.hoTen = hoTen;
        this.email = email;
        this.diaChi = diaChi;
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public NguoiDungModel(String maNguoiDung, String taiKhoan, String matKhau, String vaiTro, Boolean trangThaiTaiKhoan) {
        this.maNguoiDung = maNguoiDung;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public NguoiDungModel() {
        this.maNguoiDung = null;
        this.hoTen = null;
        this.email = null;
        this.diaChi = null;
        this.gioiTinh = null;
        this.canCuocCongDan = null;
        this.soDienThoai = null;
        this.taiKhoan = null;
        this.matKhau = null;
        this.vaiTro = null;
        this.trangThaiTaiKhoan = null;
        this.maHopDong = null;
    }

//    public ArrayList<NguoiDungModel> getNguoiDung(){
//        ArrayList<NguoiDungModel> arr = new ArrayList<>();
//        try (Connection conn = this.getConnBaseModel();) {
//            String sql = "select MaND,HoTen,DiaChi,CanCuocCongDan,SoDienThoai from NguoiDung";
//            PreparedStatement st = conn.prepareStatement(sql);
//            ResultSet rs = st.executeQuery(sql);
//            arr.clear();
//            while (rs.next()) {
//                NguoiDungModel nd = new NguoiDungModel();
//                nd.setMaNguoiDung(rs.getString(1));
//                nd.setHoTen(rs.getString(2));
//                nd.setDiaChi(rs.getString(3));              
//                nd.setCanCuocCongDan(rs.getString(4));
//                nd.setSoDienThoai(rs.getString(5));
//                arr.add(nd);
//            }
//            return arr;
//        }catch (Exception ex) {
//            System.out.println("huhu");
//            System.out.println(nd);
//        }
//        return arr;
//    }
     public ArrayList<NguoiDungModel> getNguoiDung(){
        ArrayList<NguoiDungModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select MaND,HoTen,DiaChi,CanCuocCongDan,SoDienThoai,TaiKhoan from NguoiDung where TrangThaiTaiKhoan ='1'");
            while (rs.next()) {                
                NguoiDungModel nd = new NguoiDungModel();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setHoTen(rs.getString(2));
                nd.setDiaChi(rs.getString(3));              
                nd.setCanCuocCongDan(rs.getString(4));
                nd.setSoDienThoai(rs.getString(5));
                nd.setTaiKhoan(rs.getString(6));
                arr.add(nd);               
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
    // lấy dữ liểuj quản lý tài khoản
       public ArrayList<NguoiDungModel> getDuLieu(){
        ArrayList<NguoiDungModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select MaND,TaiKhoan,MatKhau,VaiTro,TrangThaiTaiKhoan from NguoiDung where TrangThaiTaiKhoan ='0' or TrangThaiTaiKhoan = null");
            while (rs.next()) {                
                NguoiDungModel nd = new NguoiDungModel();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTaiKhoan(rs.getString(2));
                nd.setMatKhau(rs.getString(3));
                nd.setVaiTro(rs.getString(4));
                nd.setTrangThaiTaiKhoan(rs.getBoolean(5));
                arr.add(nd);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
       public ArrayList<NguoiDungModel> getDuLieu1(){
        ArrayList<NguoiDungModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select MaND,TaiKhoan,MatKhau,VaiTro,TrangThaiTaiKhoan from NguoiDung where TrangThaiTaiKhoan='1'");
            while (rs.next()) {                
                NguoiDungModel nd = new NguoiDungModel();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTaiKhoan(rs.getString(2));
                nd.setMatKhau(rs.getString(3));
                nd.setVaiTro(rs.getString(4));
                nd.setTrangThaiTaiKhoan(rs.getBoolean(5));
                arr.add(nd);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }

     //    đăng nhập
    public NguoiDungModel checkLogin(String taiKhoan, String matKhau) {
        NguoiDungModel nd = new NguoiDungModel();
        String sql = "";
        try (Connection conn = this.getConnBaseModel()) {
            sql = "select * from NguoiDung where TaiKhoan = ? and MatKhau = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, taiKhoan);

            statement.setString(2, matKhau);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nd.setMaNguoiDung(rs.getString(1));
                nd.setHoTen(rs.getString(2));
                nd.setEmail(rs.getString(3));
                nd.setDiaChi(rs.getString(4));
                nd.setGioiTinh(rs.getBoolean(5));
                nd.setCanCuocCongDan(rs.getString(6));
                nd.setSoDienThoai(rs.getString(7));
                nd.setTrangThaiTaiKhoan(rs.getBoolean(11));
                //String s = rs.getString(2);
                //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                //Date d = formatter.parse(s);
                //nd.setNgaySinh(d);
                nd.setTaiKhoan(rs.getString(8));
                nd.setMatKhau(rs.getString(9));
                nd.setVaiTro(rs.getString(10));
                nd.setMaHopDong(rs.getString(12));
                return nd;
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy model!");
        }
        return nd;
    }
   //Đăng nhập 
// Đăng ký tài khoản
    public boolean checDangKyModel(NguoiDungModel dk) {
        String sql = "";
        try (Connection conn = this.getConnBaseModel()) {
//            sql = "insert into NguoiDung (HoTen,TaiKhoan,MatKhau) values(?,?,?)";
            sql ="insert into NguoiDung values (null,?,null,null,null,null,null,?,?,null,'0',null)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, dk.getHoTen());
            st.setString(2, dk.getTaiKhoan());
            st.setString(3, dk.getMatKhau());
            st.executeUpdate();
            System.out.println(dk);
            return true;
        } catch (Exception e) {

            System.out.println(sql);

        }
        return false;
    }
// cập nhật thông tin nguoi dùng của tài khoản
    public Boolean updateThongtin(NguoiDungModel nd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            hoTen = nd.getHoTen();
            email = nd.getEmail();
            diaChi = nd.getDiaChi();
            canCuocCongDan = nd.getCanCuocCongDan();
            soDienThoai = nd.getSoDienThoai();
            vaiTro = nd.getVaiTro();
            taiKhoan = nd.getTaiKhoan();
            sql = "update NguoiDung set HoTen='" + hoTen + "',Email='" + email + "', DiaChi='" + diaChi + "', CanCuocCongDan ='" + canCuocCongDan + "', SoDienThoai ='" + soDienThoai + "' where TaiKhoan ='" + taiKhoan + "';";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println(sql);
            return true;

        } catch (SQLException e) {
            System.out.println("cuu!");
//            System.out.println(sql);
        }
        return false;
    }
    
    // cập nhật thông tin user
    public Boolean updateThongtinuser(NguoiDungModel nd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            hoTen = nd.getHoTen();
            email = nd.getEmail();
            diaChi = nd.getDiaChi();
            canCuocCongDan = nd.getCanCuocCongDan();
            soDienThoai = nd.getSoDienThoai();
            taiKhoan = nd.getTaiKhoan();
            sql = "update NguoiDung set HoTen='" + hoTen + "',Email='" + email + "', DiaChi='" + diaChi + "', CanCuocCongDan ='" + canCuocCongDan + "', SoDienThoai ='" + soDienThoai + "' where TaiKhoan ='" + taiKhoan + "';";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println(sql);
            return true;

        } catch (SQLException e) {
            System.out.println("cuu!");
//            System.out.println(sql);
        }
        return false;
    }
        public Boolean updateThongtinuser1(NguoiDungModel nd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            taiKhoan = nd.getTaiKhoan();
            matKhau = nd.getMatKhau();
            sql = "update NguoiDung set MatKhau ='" + matKhau + "' where TaiKhoan ='" + taiKhoan + "';";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            System.out.println(sql);
            return true;

        } catch (SQLException e) {
            System.out.println("cuu!");
//            System.out.println(sql);
        }
        return false;
    }
    //tìm tài khoản
        public ArrayList<NguoiDungModel> timTaiKhoan(String key){
        ArrayList<NguoiDungModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select MaND,TaiKhoan,MatKhau,VaiTro,TrangThaiTaiKhoan from NguoiDung where TrangThaiTaiKhoan ='0' and TaiKhoan like '%"+key+"%' or MaND like '%"+key+"%'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            NguoiDungModel nd = new NguoiDungModel();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setTaiKhoan(rs.getString(2));
                nd.setMatKhau(rs.getString(3));
                nd.setVaiTro(rs.getString(4));
                nd.setTrangThaiTaiKhoan(rs.getBoolean(5));
                arr.add(nd);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Không có");
        }
        return arr;
    }
        // cấp cho tài khoản đăng nhập
         public Boolean updateTK(NguoiDungModel nd){
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "update NguoiDung set MaND= ?,MatKhau = ?,VaiTro =?,TrangThaiTaiKhoan =? where TaiKhoan = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(5,nd.getTaiKhoan());
            st.setString(1, nd.getMaNguoiDung());
            st.setString(2, nd.getMatKhau());
            st.setString(3, nd.getVaiTro());
            st.setBoolean(4,nd.getTrangThaiTaiKhoan());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            
            System.out.println("bug r");
            System.out.println(nd);
//            System.out.println(sql);
        }
    return false;
    }
             public boolean  deleteTK(NguoiDungModel nd){
    String sql ="";
        try {
            Connection conn = this.getConnBaseModel();
            sql ="delete from NguoiDung where TaiKhoan = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,nd.getTaiKhoan());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Xóa bị lỗi");
        }
        return false;
    }
             
        public Boolean addLD(NguoiDungModel ld){
             try {
            Connection conn = this.getConnBaseModel();
            String sql ="select count(*) from NguoiDung where TaiKhoan = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, ld.getTaiKhoan());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count ==0) {
                    sql ="insert into NguoiDung(MaNguoiDung,HoTen,DiaChi,CanCuocCongDan,SoDienThoai) values(?,?,?,?,?)";
                    st = conn.prepareStatement(sql);
                    st.setString(1,ld.getMaNguoiDung());
                    st.setString(2, ld.getHoTen());
                    st.setString(3, ld.getDiaChi());
                    st.setString(5,ld.getSoDienThoai());
                    st.setString(4, ld.getCanCuocCongDan());
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
//            try {   Connection conn = this.getConnBaseModel();
//                    String sql ="insert into NguoiDung(MaNguoiDung,HoTen,DiaChi,CanCuocCongDan,SoDienThoai) values(?,?,?,?,?)";
//                    PreparedStatement st = conn.prepareStatement(sql);
//                    st = conn.prepareStatement(sql);
//                    st.setString(1,ld.getMaNguoiDung());
//                    st.setString(2, ld.getHoTen());
//                    st.setString(3, ld.getDiaChi());
//                    st.setString(5,ld.getSoDienThoai());
//                    st.setString(4, ld.getCanCuocCongDan());
//                    st.executeUpdate();
//            } catch (Exception e) {
//            }
//        return false;
    }
        
        public ArrayList<NguoiDungModel> timLD(String key){
        ArrayList<NguoiDungModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select MaND,HoTen,DiaChi,CanCuocCongDan,SoDienThoai,TaiKhoan from NguoiDung where TrangThaiTaiKhoan ='1'and TaiKhoan like '%"+key+"%' or MaND like '%"+key+"%'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            NguoiDungModel nd = new NguoiDungModel();
                nd.setMaNguoiDung(rs.getString(1));
                nd.setHoTen(rs.getString(2));
                nd.setDiaChi(rs.getString(3));              
                nd.setCanCuocCongDan(rs.getString(4));
                nd.setSoDienThoai(rs.getString(5));
                nd.setTaiKhoan(rs.getString(6));
                arr.add(nd);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Không có");
        }
        return arr;
    }
    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
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

    public Boolean getTrangThaiTaiKhoan() {
        return trangThaiTaiKhoan;
    }

    public void setTrangThaiTaiKhoan(Boolean trangThaiTaiKhoan) {
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }
}
//    public String getHoTen() {
//        return hoTen;
//    }
//
//    public void setHoTen(String hoTen) {
//        this.hoTen = hoTen;
//    }
//
//   // public Date getNgaySinh() {
//     //   return ngaySinh;
//    //}
//
//    //public void setNgaySinh(Date ngaySinh) {
//      //  this.ngaySinh = ngaySinh;
//    //}
//
//    public String getTaiKhoan() {
//        return taiKhoan;
//    }
//
//    public void setTaiKhoan(String taiKhoan) {
//        this.taiKhoan = taiKhoan;
//    }
//
//    public String getMatKhau() {
//        return matKhau;
//    }
//
//    public void setMatKhau(String matKhau) {
//        this.matKhau = matKhau;
//    }
//
//}
