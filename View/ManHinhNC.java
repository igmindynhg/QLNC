/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CongViecController;
import Controller.DuAnController;
import Controller.NguoiDungController;
import Controller.QLHDController;
import Molder.CongViecModel;
import Molder.DuAnModel;
import Molder.NguoiDungModel;
import Molder.QLHDModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AD
 */
public class ManHinhNC extends javax.swing.JFrame {

    private static ManHinhNC view;
    /**
     * Creates new form ManHinhNC
     */
    ArrayList<DuAnModel> list1 = new DuAnModel().getDuLieu1();
    final String header[] = {"MaDA", "TenDA", "Linh Vuc", "Han Ngay", "Ngan Sach", "Trang Thai", "Tai Khoan"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);

    ArrayList<DuAnModel> list0 = new DuAnModel().getDuLieu0();
    final String header1[] = {"MaDA", "TenDA", "Linh Vuc", "Han Ngay", "Ngan Sach", "Trang Thai", "Tai Khoan"};
    final DefaultTableModel tb1 = new DefaultTableModel(header1, 0);
    
    ArrayList<CongViecModel> listCV1 = new CongViecModel().getDuLieu1();
    final String headercv1[] = {"Mã Công Việc", "Tên CÔng Việc", "Trạng Thái"};
    final DefaultTableModel tbcv1 = new DefaultTableModel(headercv1, 0);
    
     ArrayList<CongViecModel> listCV0 = new CongViecModel().getDuLieu0();
    final String headercv0[] = {"Mã Công Việc", "Tên CÔng Việc", "Trạng Thái"};
    final DefaultTableModel tbcv0 = new DefaultTableModel(headercv0, 0);
    
    ArrayList<QLHDModel> arr = new QLHDModel().getService1();
    final String headerhd[] = {"Mã hợp đồng ", "lương", "ngày bắt đầu", "ngày kết thúc"};
    final DefaultTableModel df = new DefaultTableModel(headerhd, 0);
// tải bảng ảo lên
    public final void taiTrang(ArrayList<QLHDModel> arr) {
        df.getDataVector().removeAllElements();

        for (int i = 0; i < arr.size(); i++) {
            String luong = String.valueOf(arr.get(i).getLuong());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String Date1 = formatter.format(arr.get(i).getNgaybatdau());
            String Date2 = formatter.format(arr.get(i).getNgayketthuc());
            String nd[] = {arr.get(i).getMaHD(), luong, Date1, Date2};
            df.addRow(nd);
        }
        tbHopDong.setModel(df);
    }
     private void Displaycv1(int i) {
        CongViecModel cv = listCV1.get(i);
        cvMa.setText(cv.getMaCongViec());
        cvTen.setText(cv.getTenCongViec());
        String trangThaiCongViec = cv.getTrangThaiCongViec() ? "1" : "0";
        cvTrangThai.setText(trangThaiCongViec);
     }
      private void Displaycv0(int i) {
        CongViecModel cv = listCV0.get(i);
        cvMa.setText(cv.getMaCongViec());
        cvTen.setText(cv.getTenCongViec());
        String trangThaiCongViec = cv.getTrangThaiCongViec() ? "1" : "0";
        cvTrangThai.setText(trangThaiCongViec);
    }
    public final void TaiTrangCV(ArrayList<CongViecModel> arr) {
        tbcv1.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String trangThaiCongViec = arr.get(i).getTrangThaiCongViec() ? "On" : "Off";
            String cv[] = {arr.get(i).getMaCongViec(), arr.get(i).getTenCongViec(), trangThaiCongViec};
            tbcv1.addRow(cv);
//            jTable1.setModel(tb);
        }
        tbCV1.setModel(tbcv1);
    }
    public final void TaiTrangCV0(ArrayList<CongViecModel> arr) {
        tbcv0.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String trangThaiCongViec = arr.get(i).getTrangThaiCongViec() ? "On" : "Off";
            String cv[] = {arr.get(i).getMaCongViec(), arr.get(i).getTenCongViec(), trangThaiCongViec};
            tbcv0.addRow(cv);
//            jTable1.setModel(tb);
        }
        tbCV0.setModel(tbcv0);
    }



    public final void TaiTrang1(ArrayList<DuAnModel> arr) {
        tb.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String NganSach = Integer.toString(arr.get(i).getNganSach());
            String trangThai = arr.get(i).getTrangThai() ? "On" : "Off";
            String da[] = {arr.get(i).getMaDuAn(), arr.get(i).getTenDuAn(), arr.get(i).getLinhVuc(), arr.get(i).getHanNgay(), NganSach, trangThai, arr.get(i).getTaiKhoan()};
            tb.addRow(da);
//            jTable1.setModel(tb);
        }
        tbDuAn1.setModel(tb);
    }

    public final void TaiTrang0(ArrayList<DuAnModel> arr) {
        tb1.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String NganSach = Integer.toString(arr.get(i).getNganSach());
            String trangThai = arr.get(i).getTrangThai() ? "On" : "Off";
            String da[] = {arr.get(i).getMaDuAn(), arr.get(i).getTenDuAn(), arr.get(i).getLinhVuc(), arr.get(i).getHanNgay(), NganSach, trangThai, arr.get(i).getTaiKhoan()};
            tb1.addRow(da);
//            jTable1.setModel(tb);
        }
        tbDuAn0.setModel(tb1);
    }

    public ManHinhNC() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTT(NguoiDungController.ndOn);
        TaiTrang1(list1);
        TaiTrang0(list0);
        TaiTrangCV(listCV1);
        TaiTrangCV0(listCV0);
        taiTrang(arr);
    }

    public final void setTT(NguoiDungModel nd) {
        txtTen.setText(nd.getHoTen());
        txtEmail.setText(nd.getEmail());
        txtDiaChi.setText(nd.getDiaChi());
        txtCCCD.setText(nd.getCanCuocCongDan());
        txtSDT.setText(nd.getSoDienThoai());
        lbtk.setText(nd.getTaiKhoan());
        MaND.setText(nd.getMaNguoiDung());
    }
 public final void setTT1(QLHDModel hd) {
        hdMa.setText("HD 001");
        hdL.setText(String.valueOf("1000"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        hddate1.setText(formatter.format("2022-12-01"));
        hddate2.setText(formatter.format("2023-12-01"));
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        CaNhan = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        STTuser = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        MaND = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtpw1 = new javax.swing.JPasswordField();
        txtpw2 = new javax.swing.JPasswordField();
        lbtk = new javax.swing.JLabel();
        DuAn = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDuAn1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTimDa = new javax.swing.JTextField();
        timDA = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbDuAn0 = new javax.swing.JTable();
        daMa = new javax.swing.JLabel();
        daTen = new javax.swing.JLabel();
        daLinhVuc = new javax.swing.JLabel();
        daLuong = new javax.swing.JLabel();
        daTrangThai = new javax.swing.JTextField();
        daTaiKhoan = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        daNgay = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        daMaCongViec = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        daDoitac = new javax.swing.JLabel();
        CongViec = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbCV1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCV0 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        cvThem = new javax.swing.JButton();
        cvMa = new javax.swing.JLabel();
        cvTen = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cvTrangThai = new javax.swing.JTextField();
        cvTim = new javax.swing.JTextField();
        Luong = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbHopDong = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        HopDong = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        hdMa = new javax.swing.JTextField();
        hdL = new javax.swing.JTextField();
        hddate1 = new javax.swing.JTextField();
        hddate2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Họ và tên :");

        jLabel4.setText("Email:");

        jLabel5.setText("Địa chỉ:");

        jLabel6.setText("SDT:");

        jLabel7.setText("CCCD:");

        STTuser.setText("Sửa ");
        STTuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STTuserActionPerformed(evt);
            }
        });

        jLabel17.setText("MaND:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MaND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(STTuser)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(txtSDT)
                                .addComponent(txtDiaChi)
                                .addComponent(txtEmail)
                                .addComponent(txtTen)))))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaND, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(STTuser)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thông tin cá nhân", jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tài Khoản:");

        jLabel2.setText("Mật khẩu:");

        jButton2.setText("Đổi mật khẩu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Nhập lại:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                    .addComponent(txtpw1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txtpw2)
                    .addComponent(lbtk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtpw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton2)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Tài Khoản", jPanel11);

        javax.swing.GroupLayout CaNhanLayout = new javax.swing.GroupLayout(CaNhan);
        CaNhan.setLayout(CaNhanLayout);
        CaNhanLayout.setHorizontalGroup(
            CaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        CaNhanLayout.setVerticalGroup(
            CaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Cá Nhân", CaNhan);

        DuAn.setBackground(new java.awt.Color(255, 255, 255));

        tbDuAn1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDuAn1.setPreferredSize(new java.awt.Dimension(200, 80));
        tbDuAn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDuAn1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDuAn1);

        jLabel8.setText("Lĩnh vực:");

        jLabel9.setText("Mức lương:");

        txtTimDa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimDaKeyPressed(evt);
            }
        });

        timDA.setText("Tìm");
        timDA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timDAKeyPressed(evt);
            }
        });

        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel18.setText("MaDA:");

        jLabel19.setText("TenDA:");

        jLabel20.setText("TrangThai:");

        jLabel21.setText("TaiKhoan:");

        tbDuAn0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDuAn0.setPreferredSize(new java.awt.Dimension(200, 80));
        tbDuAn0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDuAn0MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbDuAn0);

        jLabel22.setText("Han ngay:");

        jLabel23.setText("Cong viec:");

        daMaCongViec.setText("jLabel24");

        jLabel24.setText("DoiTac");

        daDoitac.setText("jLabel25");

        javax.swing.GroupLayout DuAnLayout = new javax.swing.GroupLayout(DuAn);
        DuAn.setLayout(DuAnLayout);
        DuAnLayout.setHorizontalGroup(
            DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DuAnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DuAnLayout.createSequentialGroup()
                        .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(daNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(daMaCongViec, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(daDoitac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(DuAnLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(daLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGroup(DuAnLayout.createSequentialGroup()
                            .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(daTen, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(daMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(daLinhVuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DuAnLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(daTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(daTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(DuAnLayout.createSequentialGroup()
                        .addComponent(timDA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimDa, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        DuAnLayout.setVerticalGroup(
            DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DuAnLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DuAnLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(daMa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(daTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(daLinhVuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(daLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(daNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(daMaCongViec))
                .addGap(16, 16, 16)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(daDoitac))
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DuAnLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(daTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(daTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DuAnLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timDA)
                    .addComponent(txtTimDa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dự Án", DuAn);

        CongViec.setBackground(new java.awt.Color(255, 255, 255));

        tbCV1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCV1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbCV1);

        tbCV0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCV0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCV0MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbCV0);

        jLabel14.setText("Mã :");

        jLabel15.setText("Tên :");

        jButton6.setText("Tìm");

        cvThem.setText("Thêm");
        cvThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvThemActionPerformed(evt);
            }
        });

        cvMa.setText("jLabel25");

        cvTen.setText("jLabel26");

        jLabel27.setText("Trang Thai");

        cvTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cvTimKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout CongViecLayout = new javax.swing.GroupLayout(CongViec);
        CongViec.setLayout(CongViecLayout);
        CongViecLayout.setHorizontalGroup(
            CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CongViecLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CongViecLayout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cvTim))
                    .addGroup(CongViecLayout.createSequentialGroup()
                        .addGroup(CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CongViecLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cvTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CongViecLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cvMa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CongViecLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cvTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(CongViecLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cvThem)))))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        CongViecLayout.setVerticalGroup(
            CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CongViecLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CongViecLayout.createSequentialGroup()
                        .addGroup(CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cvMa)
                            .addComponent(jLabel27)
                            .addComponent(cvTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cvTen)
                            .addComponent(cvThem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(cvTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Công Việc ", CongViec);

        Luong.setBackground(new java.awt.Color(255, 255, 255));

        tbHopDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tháng", "Lương"
            }
        ));
        jScrollPane6.setViewportView(tbHopDong);

        jButton8.setText("Tinh");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LuongLayout = new javax.swing.GroupLayout(Luong);
        Luong.setLayout(LuongLayout);
        LuongLayout.setHorizontalGroup(
            LuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LuongLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        LuongLayout.setVerticalGroup(
            LuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lương", Luong);

        HopDong.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Mã Hợp Đồng:");

        jLabel11.setText("Lương");

        jLabel12.setText("Ngày Bắt Đầu :");

        jLabel13.setText("Ngày Kết Thúc:");

        hdMa.setText("HD 001");

        hdL.setText("1000");

        hddate1.setText("2022-12-01");

        hddate2.setText("2023-12-01");

        jButton3.setText("LayHopDong");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HopDongLayout = new javax.swing.GroupLayout(HopDong);
        HopDong.setLayout(HopDongLayout);
        HopDongLayout.setHorizontalGroup(
            HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HopDongLayout.createSequentialGroup()
                .addGroup(HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HopDongLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hdMa)
                            .addComponent(hdL)
                            .addComponent(hddate1)
                            .addComponent(hddate2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                    .addGroup(HopDongLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jButton3)))
                .addContainerGap(467, Short.MAX_VALUE))
        );
        HopDongLayout.setVerticalGroup(
            HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HopDongLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(hdMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(hdL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hddate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HopDongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(hddate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hợp Đồng ", HopDong);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Đăng Xuất");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(69, 69, 69))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public NguoiDungModel getThongTin() {
        String hoTen = txtTen.getText();
        String email = txtEmail.getText();
        String diaChi = txtDiaChi.getText();
        String canCuocCongDan = txtCCCD.getText();
        String soDienThoai = txtSDT.getText();
        return new NguoiDungModel(hoTen, email, diaChi, canCuocCongDan, soDienThoai, NguoiDungController.ndOn.getTaiKhoan(), NguoiDungController.ndOn.getMatKhau());
    }

    public NguoiDungModel getThongTin1() {
        String taiKhoan = lbtk.getText();
        String matKhau = String.valueOf(txtpw1.getPassword());
        return new NguoiDungModel(taiKhoan, matKhau);
    }

    public void Thongbao(String hi) {
        JOptionPane.showMessageDialog(jPanel10, hi, "Thong bao", JOptionPane.ERROR_MESSAGE);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int option = JOptionPane.showConfirmDialog(view, "Bạn muốn đăng xuất ?", "Thông báo", JOptionPane.YES_NO_OPTION, ICONIFIED);
//        JOptionPane.show
//    int p = JOptionPane.YES_NO_OPTION;
        if (option == JOptionPane.YES_OPTION) {
            DangNhapView dn = new DangNhapView();
            dn.setVisible(true);
            this.dispose();
        } else {
            this.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void STTuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STTuserActionPerformed
        new NguoiDungController(this).update(this);
        // TODO add your handling code here:
    }//GEN-LAST:event_STTuserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (String.valueOf(txtpw1.getPassword()).equals(String.valueOf(txtpw2.getPassword())) == true) {
            new NguoiDungController(this).update1(this);
        } else {

            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void timDAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timDAKeyPressed
        TaiTrang1(timDuAnModel());// TODO add your handling code here:
    }//GEN-LAST:event_timDAKeyPressed

    private void txtTimDaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimDaKeyPressed
        TaiTrang1(timDuAnModel());// TODO add your handling code here:
    }//GEN-LAST:event_txtTimDaKeyPressed
    int hienthi = 0;
    private void tbDuAn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDuAn1MouseClicked
        hienthi = tbDuAn1.getSelectedRow();
        Display(hienthi);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDuAn1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new DuAnController(this).update1(this);
        list1 = new DuAnModel().getDuLieu1();
        list0 = new DuAnModel().getDuLieu0();
        tbDuAn1.setModel(tb);
        tbDuAn0.setModel(tb1);
        Display(hienthi);
        Display1(hienthi1);
        TaiTrang1(list1);
        TaiTrang0(list0);
//        Reset();// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
    int hienthi1 = 0;
    private void tbDuAn0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDuAn0MouseClicked
        hienthi1 = tbDuAn0.getSelectedRow();
        Display1(hienthi1); // TODO add your handling code here:
    }//GEN-LAST:event_tbDuAn0MouseClicked
int cv1 =0;
    private void tbCV1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCV1MouseClicked
        cv1 = tbCV1.getSelectedRow();
        Displaycv1(cv1);
// TODO add your handling code here:
    }//GEN-LAST:event_tbCV1MouseClicked
int cv2 =0;
    private void tbCV0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCV0MouseClicked
        cv2=tbCV0.getSelectedRow();
        Displaycv0(cv2);
// TODO add your handling code here:
    }//GEN-LAST:event_tbCV0MouseClicked

    private void cvThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cvThemActionPerformed
new CongViecController(this).update1(this); 
  listCV1 = new CongViecModel().getDuLieu1();
  listCV0 = new CongViecModel().getDuLieu0();
        Displaycv1(cv1);
        TaiTrangCV(listCV1);
        Displaycv0(cv2);
        TaiTrangCV0(listCV0);
        Reset();// TODO add your handling code here:
    }//GEN-LAST:event_cvThemActionPerformed

    private void cvTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cvTimKeyPressed
        TaiTrangCV(timCongViecModel());// TODO add your handling code here:
    }//GEN-LAST:event_cvTimKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        hdMa.setText("HD 001");
        hdL.setText(String.valueOf("1000"));
   
        hddate1.setText("2022-12-01");
        hddate2.setText("2023-12-01");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        QLHDView qlhd = new QLHDView();
        jTextField1.setText(String.valueOf(new QLHDController(qlhd).CountNhanCong()));     // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed
    public final ArrayList<CongViecModel> timCongViecModel() {
        if (cvTim.equals("")) {
            return new CongViecModel().getDuLieu();
        } else {
            return new CongViecModel().timCongViecModels(cvTim.getText());
        }

    }   
    public void Reset(){
        cvMa.setText("");
        cvTen.setText("");
        cvTrangThai.setText("");
    }
    private void Display(int i) {
        DuAnModel da = list1.get(i);
        daMa.setText(da.getMaDuAn());
        daTen.setText(da.getTenDuAn());
        String trangThaiCongViec = da.getTrangThai() ? "1" : "0";
        daTrangThai.setText(trangThaiCongViec);
        daNgay.setText(da.getHanNgay());
        String nganSach = Integer.toString(da.getNganSach());
        daLuong.setText(nganSach);

        daLinhVuc.setText(da.getLinhVuc());
        daTaiKhoan.setText(da.getTaiKhoan());
        daMaCongViec.setText(da.getMaCongViec());
        daDoitac.setText(da.getMaHopDongDoiTac());
    }

    private void Display1(int i) {
        DuAnModel da = list0.get(i);
        daMa.setText(da.getMaDuAn());
        daTen.setText(da.getTenDuAn());
        String trangThaiCongViec = da.getTrangThai() ? "1" : "0";
        daTrangThai.setText(trangThaiCongViec);
        daNgay.setText(da.getHanNgay());
        String nganSach = Integer.toString(da.getNganSach());
        daLuong.setText(nganSach);

        daLinhVuc.setText(da.getLinhVuc());
        daTaiKhoan.setText(da.getTaiKhoan());
        daMaCongViec.setText(da.getMaCongViec());
        daDoitac.setText(da.getMaHopDongDoiTac());
    }

    public final ArrayList<DuAnModel> timDuAnModel() {
        if (txtTimDa.equals("")) {
            return new DuAnModel().getDuLieu1();
        } else {
            return new DuAnModel().timDuAnModels1(txtTimDa.getText());
        }
    }
    public CongViecModel getCongViec() {
        String maCongViec = cvMa.getText();
        String tenCongViec = cvTen.getText();
        boolean b;
        if (cvTrangThai.getText().equals("1")) {
            b = true;
        } else if (cvTrangThai.getText().equals("0")) {
            b = false;
        } else {
            JOptionPane.showMessageDialog(this, "Sai trạng thái!", "Thông báo", JOptionPane.ERROR_MESSAGE);

            return null;
        }
        return new CongViecModel(maCongViec, tenCongViec, b);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManHinhNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinhNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinhNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinhNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhNC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CaNhan;
    private javax.swing.JPanel CongViec;
    private javax.swing.JPanel DuAn;
    private javax.swing.JPanel HopDong;
    private javax.swing.JPanel Luong;
    private javax.swing.JLabel MaND;
    private javax.swing.JButton STTuser;
    private javax.swing.JLabel cvMa;
    private javax.swing.JLabel cvTen;
    private javax.swing.JButton cvThem;
    private javax.swing.JTextField cvTim;
    private javax.swing.JTextField cvTrangThai;
    private javax.swing.JLabel daDoitac;
    private javax.swing.JLabel daLinhVuc;
    private javax.swing.JLabel daLuong;
    private javax.swing.JLabel daMa;
    private javax.swing.JLabel daMaCongViec;
    private javax.swing.JLabel daNgay;
    private javax.swing.JTextField daTaiKhoan;
    private javax.swing.JLabel daTen;
    private javax.swing.JTextField daTrangThai;
    private javax.swing.JTextField hdL;
    private javax.swing.JTextField hdMa;
    private javax.swing.JTextField hddate1;
    private javax.swing.JTextField hddate2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbtk;
    private javax.swing.JTable tbCV0;
    private javax.swing.JTable tbCV1;
    private javax.swing.JTable tbDuAn0;
    private javax.swing.JTable tbDuAn1;
    private javax.swing.JTable tbHopDong;
    private javax.swing.JButton timDA;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimDa;
    private javax.swing.JPasswordField txtpw1;
    private javax.swing.JPasswordField txtpw2;
    // End of variables declaration//GEN-END:variables

    public DuAnModel getDuAn() {
        String maDuAn = daMa.getText();
        String tenDuAn = daTen.getText();
        String linhVuc = daLinhVuc.getText();
        String hanNgay = daNgay.getText();
        String nganSach = daLuong.getText();
        int a = Integer.parseInt(nganSach);
        String taiKhoan = daTaiKhoan.getText();
        String maCongViec = daMaCongViec.getText();
        String maHopDongDoiTac = daDoitac.getText();
        boolean b;
        if (daTrangThai.getText().equals("1")) {
            b = true;
        } else if (daTrangThai.getText().equals("0")) {
            b = false;
        } else {
            JOptionPane.showMessageDialog(this, "Sai trạng thái!", "Thông báo", JOptionPane.ERROR_MESSAGE);

            return null;
        }
        return new DuAnModel(maDuAn, tenDuAn, linhVuc, hanNgay, a, b, taiKhoan, maCongViec, maHopDongDoiTac);
    }
}
