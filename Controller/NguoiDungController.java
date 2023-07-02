/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Molder.NguoiDungModel;
import Molder.QLLDModel;
import View.DangKyView;
import View.DangNhapView;
import View.ManHinhChinh;
import View.ManHinhNC;
import View.NguoiDungView;
import View.QLLDView;
import View.TaiKhoanView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author AD
 */
public class NguoiDungController {

    private static DangKyView dkview;
    private static DangNhapView dnview;
    private static NguoiDungView ndview;
    private static ManHinhNC userview;
    private static TaiKhoanView tkView;
    private static QLLDView qlView;
    public static NguoiDungModel ndOn;
    
    public NguoiDungController(QLLDView view) {
        NguoiDungController.qlView = view;
    }

    public NguoiDungController(DangKyView view) {
        NguoiDungController.dkview = view;
    }

    public NguoiDungController(DangNhapView view) {
        NguoiDungController.dnview = view;
    }
    public NguoiDungController(TaiKhoanView view) {
        NguoiDungController.tkView = view;
    }
    public NguoiDungController(NguoiDungView view) {
        NguoiDungController.ndview = view;
    }
    public NguoiDungController(ManHinhNC view){
        NguoiDungController.userview = view;
    }
    public NguoiDungController(NguoiDungModel view) {

        NguoiDungController.ndOn = view;
    }
// dang nhap 

    public NguoiDungController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void doLogin() {
        NguoiDungModel nd = dnview.LayDangNhap();
        if (nd.getTaiKhoan().equals("") || nd.getMatKhau().equals("")) {
            dnview.Thongbao("Vui lòng nhập đầy đủ thông tin\n");
        } else {
            NguoiDungModel ndc = new NguoiDungModel().checkLogin(nd.getTaiKhoan(), nd.getMatKhau());
            if ("Quan ly".equals(ndc.getVaiTro())) {
                ndOn = ndc;
                dnview.Thongbao1("Đăng nhập thành công");
                ManHinhChinh mhc = new ManHinhChinh();
                mhc.setVisible(true);
                dnview.dispose();
            } else if ("Nhan Cong".equals(ndc.getVaiTro())) {
                ndOn = ndc;
                dnview.Thongbao1("Đăng nhập thành công");
                ManHinhNC mhc = new ManHinhNC();
                mhc.setVisible(true);
                dnview.dispose();
            } else {
                dnview.Thongbao("Đăng nhập thất bại");
            }
        }
    }
    // dang ky
//    ^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$
//    ^([a-zA-Z0-9._%-]+@nhom7\.[vn]{2,4})*$
    public String regexTaiKhoan = "^([a-zA-Z0-9._%-]+@nhom7\\.[vn]{2,4})*$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
// them 
    public void add() {
        NguoiDungModel nd = dkview.checkDangKy();
        if (nd.getTaiKhoan().equals("") || nd.getHoTen().equals("") || nd.getMatKhau().equals("")) {
            dkview.Thongbao("Vui lòng nhập đầy đủ thông tin");
        } else if (!Regex(nd.getTaiKhoan(), regexTaiKhoan)) {
            dkview.Thongbao("Sai định dạng tài khoản @nhom7.vn");
        } else if (nd.getMatKhau().length() < 6) {
            dkview.Thongbao("Mật khẩu đủ 6 ký tự");
            
        } else {
            boolean dkm = new NguoiDungModel().checDangKyModel(nd);
            if (dkm == true) {
                dkview.Thongbao("Tạo thành công tài khoản\n Vui lòng đợi quản lý duyệt !");
            } else {
                dkview.Thongbao("bai bai");
            }
        }

    }
    
    public String regexSoDienThoai = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    public String regexEmail ="^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$";
    public String regexCCCD ="^[0-9]{12}$";
// cap nhap thong tin
    public void update(NguoiDungView nguoiDungView){
        NguoiDungModel nd = ndview.getThongTin();
        if (nd.getHoTen().equals("") || nd.getDiaChi().equals("") || nd.getEmail().equals("") || nd.getCanCuocCongDan().equals("")|| nd.getSoDienThoai().equals("") || nd.getVaiTro().equals("")) {
            ndview.Thongbao("Không được để rỗng");
        }else if(!Regex(nd.getEmail(), regexEmail)){
            ndview.Thongbao("Sai định rạng email");
        }else if (!Regex(nd.getSoDienThoai(), regexSoDienThoai)) {
            ndview.Thongbao("Không tồn tại số điện thoại");
        }else if(!Regex(nd.getCanCuocCongDan(),regexCCCD)){
            ndview.Thongbao("Không đúng định dạng số căn cước");
        }
        else{
        boolean test = new NguoiDungModel().updateThongtin(nd);
        if(test){
            ndOn = nd;
            ndview.Thongbao1("Update thành công!");
            ndview.setTT(nd);
        }else{
            ndview.Thongbao("Lỗi");
            System.out.println(nd);
        }
        }
        
    }
    // cap nhat thong tin
        public void update(ManHinhNC manHinhNC){
        NguoiDungModel nd = userview.getThongTin();
        if (nd.getHoTen().equals("") || nd.getDiaChi().equals("") || nd.getEmail().equals("") || nd.getCanCuocCongDan().equals("")|| nd.getSoDienThoai().equals("")) {
            userview.Thongbao("Không được để rỗng");
        }else if(!Regex(nd.getEmail(), regexEmail)){
            userview.Thongbao("Sai định dạng email");
        }else if (!Regex(nd.getSoDienThoai(), regexSoDienThoai)) {
            userview.Thongbao("Không tồn tại số điện thoại");
        }else{
        boolean test = new NguoiDungModel().updateThongtinuser(nd);
        if(test){
            ndOn = nd;
            userview.Thongbao("Update thành công!");
            userview.setTT(nd);
        }else{
            userview.Thongbao("loi");
            System.out.println(nd);
        }
        }
        
    }
                public void update1(ManHinhNC manHinhNC){
        NguoiDungModel nd = userview.getThongTin1();
        if (nd.getTaiKhoan().equals("") || nd.getMatKhau().equals("")) {
            userview.Thongbao("Không được để rỗng");
            return;
        }
       
        boolean test = new NguoiDungModel().updateThongtinuser1(nd);
        if(test){
            ndOn = nd;
            userview.Thongbao("Update thành công!");
            
        }else{
            userview.Thongbao("loi");
            System.out.println(nd);
        }
        
        
    }
        // caap quyen
        public void update(TaiKhoanView taiKhoanV) {
        NguoiDungModel tk = taiKhoanV.getTaiKhoan();
        if (tk.getTaiKhoan().equals("") || tk.getMatKhau().equals("")||tk.getMaNguoiDung().equals("")) {
            JOptionPane.showMessageDialog(taiKhoanV, "Không được để trống","Thông báo",JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new NguoiDungModel().updateTK(tk);
            if (rs) {
                JOptionPane.showMessageDialog(taiKhoanV, "Update thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                taiKhoanV.TaiTrang(new NguoiDungModel().getDuLieu());

            } else {
                JOptionPane.showMessageDialog(taiKhoanV, "Update thất bại","Thong bao",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        // xoas tai khoan
        public void deleteTk(TaiKhoanView view){
        NguoiDungModel nd = view.getTaiKhoan();
        boolean ts = new NguoiDungModel().deleteTK(nd);
        if (ts) {
        JOptionPane.showMessageDialog(dnview, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        view.TaiTrang(new NguoiDungModel().getDuLieu());
    }else{
        JOptionPane.showMessageDialog(view, "Xóa thất bại");
        }
        
    }
        public void addld(QLLDView view){
            QLLDModel ld = view.getLaoDong();
        if (ld.getMaNguoiDung().equals("")) {
            JOptionPane.showMessageDialog(view, "Mã không được bỏ trống!","Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (ld.getHoTen().equals("")) {
            JOptionPane.showMessageDialog(view, "Tên không được bỏ rỗng!","Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (ld.getDiaChi().equals("")) {
            JOptionPane.showMessageDialog(view, "Khong dc rong","Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Regex(ld.getSoDienThoai(), regexSoDienThoai)) {
            view.Thongbao("Không tồn tại số điện thoại");
            return;
        }
        if(!Regex(ld.getCanCuocCongDan(),regexCCCD)){
            view.Thongbao("Không đúng định dạng số căn cước");
            return;
        }
        if(!Regex(ld.getTaiKhoan(), regexTaiKhoan)){
            view.Thongbao("Sai định dạng email");
            return;
        }
        boolean rs = new QLLDModel().addLD(ld);
            System.out.println(rs);
        if (rs) {
            JOptionPane.showMessageDialog(view, "Thêm thành công");
            view.TaiTrang(new NguoiDungModel().getNguoiDung());
        } else {
            JOptionPane.showMessageDialog(view, "Thêm thất bại\n Trùng mã người dùng hoặc tài khoản! ","Lỗi!",JOptionPane.ERROR_MESSAGE);
        }
        }
        public void deleteld(QLLDView view){
        QLLDModel ld = view.getLaoDong();
        boolean ts = new QLLDModel().deleteLD(ld);
        if (ts) {
        JOptionPane.showConfirmDialog(view, "Xóa thành công","Thong bao",JOptionPane.YES_NO_OPTION);
        int option = 0;
        if(option == JOptionPane.YES_OPTION){
        view.TaiTrang(new NguoiDungModel().getNguoiDung());
        }
        
    }else{
        JOptionPane.showMessageDialog(view, "Xóa thất bại");
        }
        
    }
        public void update(QLLDView view) {
        QLLDModel ld = view.getLaoDong();
        if (ld.getMaNguoiDung().equals("") || ld.getHoTen().equals("") || ld.getDiaChi().equals("")|| ld.getCanCuocCongDan().equals("")|| ld.getSoDienThoai().equals("") || ld.getTaiKhoan().equals("")) {
            JOptionPane.showMessageDialog(view, "Không được để trống","Thông báo",JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new QLLDModel().updateLD(ld);
            if (rs) {
                JOptionPane.showMessageDialog(view, "Update thành công");
                view.TaiTrang(new NguoiDungModel().getNguoiDung());

            } else {
                JOptionPane.showMessageDialog(view, "Update thất bại","Thong bao",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
          public int CountNhanCong() {
        return new QLLDModel().CountNhanCong();
    }
        
}




