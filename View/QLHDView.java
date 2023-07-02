/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import Molder.QLHDModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import Controller.QLHDController;
import Molder.QLHDDTModel;
/**
 *
 * @author AD
 */
public class QLHDView extends javax.swing.JPanel {



    ArrayList<QLHDDTModel> arr2 = new QLHDDTModel().getService2();

    /**S
     * Creates new form QLHDView
     */
    public QLHDView() {
        initComponents();
        taiTrang(arr);
        taiTrang2(arr2);
    }
     ArrayList<QLHDModel> arr = new QLHDModel().getService1();
    final String header[] = {"Mã hợp đồng ", "lương", "ngày bắt đầu", "ngày kết thúc"};
    final DefaultTableModel df = new DefaultTableModel(header, 0);
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
        table1.setModel(df);
    }
    final String header2[] = {"Mã hợp đồng ", "ngân sách", "ngày bắt đầu", "ngày kết thúc"};// nên thêm mã công ty nữa để xem 
    // m để như này làm sao biết hợp đồng nào có công ty đang giữ chuaw gây bug đấy
    // thêm cả nếu để như này lại bị sai logic :)) mệt ẻ
    // + 10 điểm kiên trì//
   // gặp t bỏ lâu rồi
    // ngồi xem fix loạn cả mắt
    
    final DefaultTableModel df2 = new DefaultTableModel(header2, 0);

    public final void taiTrang2(ArrayList<QLHDDTModel> arr2) {
        df2.getDataVector().removeAllElements();

        for (int i = 0; i < arr2.size(); i++) {
            String ngansach = String.valueOf(arr2.get(i).getNgansach());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String Date1 = formatter.format(arr2.get(i).getNgaybatdau());
            String Date2 = formatter.format(arr2.get(i).getNgayketthuc());
            String nd2[] = {arr2.get(i).getMaHHDT(), ngansach, Date1, Date2};
            df2.addRow(nd2);
        }
        table2.setModel(df2);
    }

    public void Display2(int i) {
        QLHDDTModel hd = arr2.get(i);
        txt_id2.setText(hd.getMaHHDT());
        txt_ns.setText(String.valueOf(hd.getNgansach()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        txt_date11.setText(formatter.format(hd.getNgaybatdau()));
        txt_date22.setText(formatter.format(hd.getNgayketthuc()));
    }

    public void Display(int i) {
        QLHDModel hd = arr.get(i);
        txt_id1.setText(hd.getMaHD());
        txt_wage.setText(String.valueOf(hd.getLuong()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        txt_date1.setText(formatter.format(hd.getNgaybatdau()));
        txt_date2.setText(formatter.format(hd.getNgayketthuc()));

    }

    public QLHDModel getHd() {
        String maHD = txt_id1.getText();
        int luong = 0;
        if (txt_wage.getText().equals("")) {
            luong = 0;
        } else {
            luong = Integer.parseInt(txt_wage.getText());
        }
//         int luong = 1000;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        try {
            date1 = format.parse(txt_date1.getText());
        } catch (ParseException ex) {
            try {
                date1 = format.parse("2222-11-11");
            } catch (ParseException ex1) {
                System.out.println("Error ");
            }
        }
        Date date2 = new Date();
        try {
            date2 = format.parse(txt_date2.getText());
        } catch (ParseException ex) {
            try {
                date2 = format.parse("2222-11-11");
            } catch (ParseException ex1) {
                System.out.println("Error ");

            }
        }
        return new QLHDModel(maHD, luong, date1, date2);
    }
    public QLHDDTModel getHd2() {
        String maHDDT = txt_id2.getText();/// ô kia id 2 m để đây id 1 đm
        int ns = 0;
        if (txt_ns.getText().equals("")) {
            ns = 0;
        } else {
            ns = Integer.parseInt(txt_ns.getText());
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        try {
            date1 = format.parse(txt_date11.getText());
        } catch (ParseException ex) {
            System.out.println("loi hả");
            try {
                date1 = format.parse("2222-11-11");
            } catch (ParseException ex1) {
                System.out.println("Error ");
            }
        }
        Date date2 = new Date();
        try {
            date2 = format.parse(txt_date22.getText());
        } catch (ParseException ex) {
            try {
                date2 = format.parse("2222-11-11");
            } catch (ParseException ex1) {
                System.out.println("Error ");

            }
        }
        return new QLHDDTModel(maHDDT, ns, date1, date2);
      
       
    }

    public void resetForm() {
        
        txt_id1.setText("");
        txt_date1.setText("");
        txt_date2.setText("");
        txt_wage.setText("");

    }
      public void resetForm1() {
        
        txt_id2.setText("");
        txt_date11.setText("");
        txt_date22.setText("");
        txt_ns.setText("");

    }
// 1
    ArrayList<QLHDModel> layDVtheoYeuCau() {
        if (txt_s.getText().equals("")) {
            return new QLHDModel().getService1();
        }
        return new QLHDModel().timkiem(txt_s.getText());
    }
     ArrayList<QLHDDTModel> layDVtheoYeuCau2() {
        if (txt_id2.getText().equals("")) {
            return new QLHDDTModel().getService2();
        }
        return new QLHDDTModel().timkiem(txt_id2.getText());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id1 = new javax.swing.JTextField();
        txt_wage = new javax.swing.JTextField();
        txt_date1 = new javax.swing.JTextField();
        txt_date2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btn_search1 = new javax.swing.JButton();
        btn_add1 = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        txt_s = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        txt_id2 = new javax.swing.JTextField();
        txt_ns = new javax.swing.JTextField();
        txt_date11 = new javax.swing.JTextField();
        txt_date22 = new javax.swing.JTextField();
        btn_add2 = new javax.swing.JButton();
        btn_addd = new javax.swing.JButton();
        btn_editt = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Constantia", 3, 14)); // NOI18N
        jLabel6.setText("Quản lý hợp đồng");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã hợp đồng :");

        jLabel2.setText("Lương:");

        jLabel3.setText("Ngày bắt đầu :");

        jLabel4.setText("Ngày kết thúc :");

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        btn_search1.setText("Tìm");

        btn_add1.setText("Thêm");
        btn_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add1ActionPerformed(evt);
            }
        });

        btn_edit1.setText("Sửa ");
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });

        btn_delete1.setText("Xóa");
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        txt_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_sKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_date2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_date1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id1)
                                    .addComponent(txt_wage, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_add1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_search1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_s, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_wage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete1))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search1)
                    .addComponent(txt_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hợp đồng nhân công ", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Mã hợp đồng:");

        jLabel7.setText("Ngân Sách :");

        jLabel8.setText("Ngày bắt đầu :");

        jLabel9.setText("Ngày kết thúc :");

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        table2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        txt_id2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id2KeyPressed(evt);
            }
        });

        btn_add2.setText("Tìm");
        btn_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add2ActionPerformed(evt);
            }
        });

        btn_addd.setText("Thêm");
        btn_addd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adddActionPerformed(evt);
            }
        });

        btn_editt.setText("Sửa");
        btn_editt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edittActionPerformed(evt);
            }
        });

        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id2)
                            .addComponent(txt_ns)
                            .addComponent(txt_date11)
                            .addComponent(txt_date22, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_add2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_addd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_editt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_ns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_date11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_date22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hợp đồng đối tác", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(556, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
      new QLHDController(this).themHD();
        arr = new QLHDModel().getService1();
        taiTrang(arr);
        resetForm();
  // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1ActionPerformed
 int hienthi =0;
    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
       hienthi = table1.getSelectedRow();
        Display(hienthi);
        // TODO add your handling code here:
    }//GEN-LAST:event_table1MouseClicked

    private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed
       new QLHDController(this).editHD();
        arr = new QLHDModel().getService1();
        taiTrang(arr);
        resetForm(); // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit1ActionPerformed

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
         new QLHDController(this).deleteHD();
        arr = new QLHDModel().getService1();
        taiTrang(arr);
        resetForm();// TODO add your handling code here:
    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void txt_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sKeyPressed
       taiTrang(layDVtheoYeuCau());
    }//GEN-LAST:event_txt_sKeyPressed

    private void btn_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add2ActionPerformed

    private void btn_adddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adddActionPerformed
       new QLHDController(this).themHD2();
        arr2 = new QLHDDTModel().getService2();
        taiTrang2(arr2);
        resetForm1();// TODO add your handling code here:
    }//GEN-LAST:event_btn_adddActionPerformed

    private void btn_edittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edittActionPerformed
       new QLHDController(this).editHDDT();
        arr2 = new QLHDDTModel().getService2();
        taiTrang2(arr2);
        resetForm1(); // TODO add your handling code here:
    }//GEN-LAST:event_btn_edittActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
           new QLHDController(this).deleteHDDT();
        arr2 = new QLHDDTModel().getService2();
        taiTrang2(arr2);
        resetForm1(); // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteActionPerformed
int load = 0;
    private void table2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table2KeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_table2KeyPressed

    private void txt_id2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id2KeyPressed
        taiTrang2(layDVtheoYeuCau2()); // TODO add your handling code here:
    }//GEN-LAST:event_txt_id2KeyPressed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
       load = table2.getSelectedRow();
        Display2(load); // TODO add your handling code here:
    }//GEN-LAST:event_table2MouseClicked
                                                                              
                            

                                         


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add1;
    private javax.swing.JButton btn_add2;
    private javax.swing.JButton btn_addd;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_editt;
    private javax.swing.JButton btn_search1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTextField txt_date1;
    private javax.swing.JTextField txt_date11;
    private javax.swing.JTextField txt_date2;
    private javax.swing.JTextField txt_date22;
    private javax.swing.JTextField txt_id1;
    private javax.swing.JTextField txt_id2;
    private javax.swing.JTextField txt_ns;
    private javax.swing.JTextField txt_s;
    private javax.swing.JTextField txt_wage;
    // End of variables declaration//GEN-END:variables
}
