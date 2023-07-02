package Controller;

import Molder.QLHDDTModel;
import View.QLHDView;
import Molder.QLHDModel;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class QLHDController {

    private static QLHDView QLHD;

    public QLHDController(QLHDView view) {
        QLHDController.QLHD = view;
    }

    public void themHD() {
        QLHDModel hd = QLHD.getHd();
// này thêm ở nhan công
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String Date1 = formatter.format(hd.getNgaybatdau());
System.out.println(hd);
//        String Date2 = formatter.format(hd.getNgayketthuc());
        boolean result = new QLHDModel().addhd(hd);
        if (result) {
            JOptionPane.showMessageDialog(QLHD, "Thêm Hợp đồng thành công.");
            QLHD.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLHD, "Thêm Hợp đồng không thành công.");
        }
    }

    public void themHD2() {
        QLHDDTModel hd = QLHD.getHd2();// mé cái ngyaf tháng nó trùng ghét thế, nó không get đc dữ liệu ở text ra giờ còn cách tách cái model ra 2 cái thì may ra feeed đc
        //n khong ra têxt
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String Date1 = formatter.format(hd.getNgaybatdau());
//        String Date2 = formatter.format(hd.getNgayketthuc());
        boolean result = new QLHDDTModel().addhd2(hd);
        if (result) {
            JOptionPane.showMessageDialog(QLHD, "Thêm Hợp đồng thành công.");
//            QLHD.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLHD, "Thêm Hợp đồng không thành công.");
        }
    }

    public void editHD() {
        QLHDModel hd = QLHD.getHd();
        System.out.println(hd);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String Date1 = formatter.format(hd.getNgaybatdau());
//        String Date2 = formatter.format(hd.getNgayketthuc());
        boolean result = new QLHDModel().edithd(hd);
        if (result) {
            JOptionPane.showMessageDialog(QLHD, "Sửa Hợp đồng thành công.");
            QLHD.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLHD, "Sửa Hợp đồng không thành công.");
        }
    }

    public void deleteHD() {
        QLHDModel hd = QLHD.getHd();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String Date1 = formatter.format(hd.getNgaybatdau());
//        String Date2 = formatter.format(hd.getNgayketthuc());
        boolean result = new QLHDModel().deleteDV(hd);
        if (result) {
            JOptionPane.showMessageDialog(QLHD, "Xóa Hợp đồng thành công.");
            QLHD.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLHD, "Xóa Hợp đồng không thành công.");
        }
    }
    public void deleteHDDT() {
        QLHDDTModel hd = QLHD.getHd2();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String Date1 = formatter.format(hd.getNgaybatdau());
//        String Date2 = formatter.format(hd.getNgayketthuc());
        boolean result = new QLHDDTModel().deleteDV(hd);
        if (result) {
            JOptionPane.showMessageDialog(QLHD, "Xóa Hợp đồng thành công.");
            QLHD.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLHD, "Xóa Hợp đồng không thành công.");
        }
    }
    public void editHDDT() {
        QLHDDTModel hd = QLHD.getHd2();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String Date1 = formatter.format(hd.getNgaybatdau());
//        String Date2 = formatter.format(hd.getNgayketthuc());
        boolean result = new QLHDDTModel().edithd(hd);
        if (result) {
            JOptionPane.showMessageDialog(QLHD, "Sửa Hợp đồng thành công.");
            QLHD.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLHD, "Sửa Hợp đồng không thành công.");
        }
    }
     public int CountNhanCong() {
        return new QLHDModel().CountNhanCong();
    }
     public int CountNhanCong1() {
        return new QLHDModel().CountNhanCong1();
    }
     public long CountNhanCong2() {
        return new QLHDDTModel().CountNhanCong();
    }
}