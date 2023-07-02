/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Molder.CongViecModel;
import View.ManHinhNC;
import View.QLCVView;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AD
 */
public class CongViecController {

    private static QLCVView QLCV;
    private static ManHinhNC mhc;

    public CongViecController(QLCVView view) {
        CongViecController.QLCV = view;
    }
    public CongViecController(ManHinhNC view) {
        CongViecController.mhc = view;
    }
    public String regexMaCV ="[CV]{2} [0-9]{3}$";
    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public void addCV() {
        CongViecModel cv = QLCV.getCongViec();
        if (cv.getMaCongViec().equals("")) {
            JOptionPane.showMessageDialog(QLCV, "Mã không được bỏ trống!","Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cv.getTenCongViec().equals("")) {
            JOptionPane.showMessageDialog(QLCV, "Tên không được bỏ rỗng!","Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Regex(cv.getMaCongViec(), regexMaCV)) {
            JOptionPane.showMessageDialog(QLCV, "Sai định dạng mã công việc!\n EX:CV 000","Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean rs = new CongViecModel().addCongViec(cv);
        if (rs) {
            JOptionPane.showMessageDialog(QLCV, "Thêm thành công");
            QLCV.TaiTrang(new CongViecModel().getDuLieu());
        } else {
            JOptionPane.showMessageDialog(QLCV, "Thêm thất bại","Thong bao",JOptionPane.ERROR_MESSAGE);
        }
    
}

public void update(QLCVView QLCV) {
        CongViecModel cv = QLCV.getCongViec();
        if (cv.getMaCongViec().equals("") || cv.getTenCongViec().equals("")) {
            JOptionPane.showMessageDialog(QLCV, "Không được để trống","Thông báo",JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new CongViecModel().updateCV(cv);
            if (rs) {
                JOptionPane.showMessageDialog(QLCV, "Update thành công");
                QLCV.TaiTrang(new CongViecModel().getDuLieu());

            } else {
                JOptionPane.showMessageDialog(QLCV, "Update thất bại","Thong bao",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
public void update1(ManHinhNC view) {
        CongViecModel cv = view.getCongViec();
        if (cv.getMaCongViec().equals("") || cv.getTenCongViec().equals("")) {
            JOptionPane.showMessageDialog(view, "Không được để trống","Thông báo",JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new CongViecModel().updateCV(cv);
            if (rs) {
                JOptionPane.showMessageDialog(QLCV, "Update thành công");
                view.TaiTrangCV(new CongViecModel().getDuLieu1());
                view.TaiTrangCV0(new CongViecModel().getDuLieu0());

            } else {
                JOptionPane.showMessageDialog(QLCV, "Update thất bại","Thong bao",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

public void delete(QLCVView view){
        CongViecModel cv = QLCV.getCongViec();
//        JOptionPane.showConfirmDialog(view, "Xóa thành công","Thong bao",JOptionPane.YES_NO_OPTION);
        int option =  JOptionPane.showConfirmDialog(view, "Bạn có muốn xóa ?","Thong bao",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            boolean ts = new CongViecModel().deleteCV(cv);
        if (ts) {
        QLCV.TaiTrang(new CongViecModel().getDuLieu());
        QLCV.Reset();
    }else{
        JOptionPane.showMessageDialog(view, "Xóa thất bại");
        }
            System.out.println("ok");
       
        }else if(option == JOptionPane.NO_OPTION){
            return;
        }
//        boolean ts = new CongViecModel().deleteCV(cv);
//        if (ts) {
//        QLCV.TaiTrang(new CongViecModel().getDuLieu());
//    }else{
//        JOptionPane.showMessageDialog(view, "Xóa thất bại");
//        }
        
    }

}
