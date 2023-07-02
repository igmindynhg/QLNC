/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author AD
 */
public class CongViecModel extends BaseModel{
    private String maCongViec;
    private String tenCongViec;
    private boolean trangThaiCongViec;

    public CongViecModel(String maCongViec, String tenCongViec, boolean trangThaiCongViec) {
        this.maCongViec = maCongViec;
        this.tenCongViec = tenCongViec;
        this.trangThaiCongViec = trangThaiCongViec;
    }
// lấy
    public ArrayList<CongViecModel> getDuLieu(){
        ArrayList<CongViecModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from CongViec");
            while (rs.next()) {                
                CongViecModel cv = new CongViecModel();
                cv.setMaCongViec(rs.getString(1));
                cv.setTenCongViec(rs.getString(2));
                cv.setTrangThaiCongViec(rs.getBoolean(3));
                arr.add(cv);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
    public ArrayList<CongViecModel> getDuLieu1(){
        ArrayList<CongViecModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from CongViec where TrangThai ='1'");
            while (rs.next()) {                
                CongViecModel cv = new CongViecModel();
                cv.setMaCongViec(rs.getString(1));
                cv.setTenCongViec(rs.getString(2));
                cv.setTrangThaiCongViec(rs.getBoolean(3));
                arr.add(cv);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
    public ArrayList<CongViecModel> getDuLieu0(){
        ArrayList<CongViecModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select*from CongViec where TrangThai ='0'");
            while (rs.next()) {                
                CongViecModel cv = new CongViecModel();
                cv.setMaCongViec(rs.getString(1));
                cv.setTenCongViec(rs.getString(2));
                cv.setTrangThaiCongViec(rs.getBoolean(3));
                arr.add(cv);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
    // thêm 
    public Boolean addCongViec(CongViecModel cv){
        try {
            Connection conn = this.getConnBaseModel();
            String sql ="select count(*) from CongViec where MaCV = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cv.getMaCongViec());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count ==0) {
                    sql ="insert into CongViec values(?,?,?)";
                    st = conn.prepareStatement(sql);
                    st.setString(1,cv.getMaCongViec());
                    st.setString(2, cv.getTenCongViec());
                    st.setBoolean(3, cv.getTrangThaiCongViec());
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
    // cập nhật
    public Boolean updateCV(CongViecModel cv){
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "update CongViec set TenCV= ?, TrangThai = ? where MaCV = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(3,cv.getMaCongViec());
            st.setString(1, cv.getTenCongViec());
            st.setBoolean(2,cv.getTrangThaiCongViec());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            
            System.out.println("cuu!");
//            System.out.println(sql);
        }
    return false;
    }
//        public Boolean updateCV1(CongViecModel cv){
//        String sql = "";
//        try {
//            Connection conn = this.getConnBaseModel();
//            sql = "update CongViec set TenCV= ?, TrangThai = ? where MaCV = ?";
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(3,cv.getMaCongViec());
//            st.setString(1, cv.getTenCongViec());
//            st.setBoolean(2,cv.getTrangThaiCongViec());
//            st.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            
//            System.out.println("cuu!");
////            System.out.println(sql);
//        }
//    return false;
//    }
    // xóa CV chưa có khóa phụ
    public boolean  deleteCV(CongViecModel cv){
    String sql ="";
        try {
            Connection conn = this.getConnBaseModel();
            sql ="delete from CongViec where MaCV = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cv.getMaCongViec());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Xóa bị lỗi");
        }
        return false;
    }
    // tìm theo Mã
    public ArrayList<CongViecModel> timCongViecModels(String key){
        ArrayList<CongViecModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select*from CongViec where MaCV like '%"+key+"%'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            CongViecModel cv = new CongViecModel();
            cv.setMaCongViec(rs.getString(1));
            cv.setTenCongViec(rs.getString(2));
            cv.setTrangThaiCongViec(rs.getBoolean(3));
            arr.add(cv);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Không có");
        }
        return arr;
    }
    
    public CongViecModel() {
    }

    public String getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public boolean getTrangThaiCongViec() {
        return trangThaiCongViec;
    }

    public void setTrangThaiCongViec(boolean trangThaiCongViec) {
        this.trangThaiCongViec = trangThaiCongViec;
    }
    
}
