/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Molder.DuAnModel;
import Molder.QLHDModel;
import View.ManHinhNC;
import View.QLDAView;
import View.QLLDView;
import javax.swing.JOptionPane;

/**
 *
 * @author AD
 */
public class DuAnController {

    private static QLDAView view;
    public static DuAnModel duAnModel;
    private static ManHinhNC mhview;

    public DuAnController(QLDAView view) {
        DuAnController.view = view;
    }
public DuAnController(ManHinhNC view) {
        DuAnController.mhview = view;
    }

    public DuAnController(DuAnModel view) {
        DuAnController.duAnModel = view;
    }

    public void addDA() {
        DuAnModel da = view.getDuAn();
        System.out.println(da);
        if (da.getMaDuAn().equals("")) {
            JOptionPane.showMessageDialog(view, "Mã không được bỏ trống!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (da.getTenDuAn().equals("")) {
            JOptionPane.showMessageDialog(view, "Tên không được bỏ rỗng!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean rs = new DuAnModel().addDuAn(da);
        System.out.println("spso");
        if (rs) {
            JOptionPane.showMessageDialog(view, "Thêm thành công");
            view.TaiTrang(new DuAnModel().getDuLieu());
        } else {
            JOptionPane.showMessageDialog(view, "Thêm thất bại", "Thong bao", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void delete(QLDAView view) {
        DuAnModel da = view.getDuAn();
        int option = JOptionPane.showConfirmDialog(view, "Bạn có muốn xóa ?", "Thong bao", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            boolean ts = new DuAnModel().deleteDA(da);
            if (ts) {
                view.TaiTrang(new DuAnModel().getDuLieu());
                view.Reset();
            } else {
                JOptionPane.showMessageDialog(view, "Xóa thất bại");
            }
        } else if (option == JOptionPane.NO_OPTION) {
            return;
        }

    }
    public void update(QLDAView view) {
        DuAnModel da = view.getDuAn();
        System.out.println(da);
        if (da.getMaCongViec().equals("") || da.getTaiKhoan().equals("") || da.getMaHopDongDoiTac().equals("")) {
            JOptionPane.showMessageDialog(view, "Không được để trống","Thông báo",JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new DuAnModel().updateda(da);
            if (rs) {
                JOptionPane.showMessageDialog(view, "Update thành công");
                view.TaiTrang(new DuAnModel().getDuLieu());

            } else {
                JOptionPane.showMessageDialog(view, "Update thất bại","Thong bao",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void update1(ManHinhNC view) {
        DuAnModel da = view.getDuAn();
        System.out.println(da);
        if (da.getMaCongViec().equals("") || da.getTaiKhoan().equals("") || da.getMaHopDongDoiTac().equals("")) {
            JOptionPane.showMessageDialog(view, "Không được để trống","Thông báo",JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new DuAnModel().updateda1(da);
            if (rs) {
                JOptionPane.showMessageDialog(view, "Update thành công");
                view.TaiTrang0(new DuAnModel().getDuLieu0());
                view.TaiTrang1(new DuAnModel().getDuLieu1());

            } else {
                JOptionPane.showMessageDialog(view, "Update thất bại","Thong bao",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public int CountNhanCong2() {
        return new DuAnModel().CountNhanCong();
    }


}
