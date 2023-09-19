/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UDP.Cau4;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class frmMoveArrayUDP extends javax.swing.JFrame {

    /**
     * Creates new form frmcongTruNhanChia
     */
    public frmMoveArrayUDP() {
        initComponents();
        
    }
    
     public void arrayOnTextChanged()
    {   
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtResult = new javax.swing.JTextField();
        txtElementCount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtArray = new javax.swing.JTextField();
        txtKetQua = new javax.swing.JTextField();
        txtMoveCount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnMoveArray = new javax.swing.JButton();

        txtResult.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtElementCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtElementCountActionPerformed(evt);
            }
        });

        jLabel1.setText("Nhap so phan tu");

        jLabel3.setText("Ket qua");

        jLabel2.setText("Nhap mang");

        txtArray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArrayActionPerformed(evt);
            }
        });

        txtKetQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKetQuaActionPerformed(evt);
            }
        });

        txtMoveCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoveCountActionPerformed(evt);
            }
        });

        jLabel4.setText("Nhap so phan tu di chuyen");

        btnMoveArray.setText("Di chuyen");
        btnMoveArray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveArrayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(25, 25, 25))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(54, 54, 54)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoveArray, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMoveCount, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtArray, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtElementCount, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtElementCount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArray, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMoveCount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addComponent(btnMoveArray, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtElementCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtElementCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtElementCountActionPerformed

    private void txtArrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArrayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArrayActionPerformed

    private void txtKetQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKetQuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKetQuaActionPerformed

    private void txtMoveCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoveCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoveCountActionPerformed

    private void btnMoveArrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveArrayActionPerformed
        String[] mang=txtArray.getText().split(" ");
        if(Integer.parseInt(txtElementCount.getText())>1000)
        {
            JOptionPane.showMessageDialog(null, "So uong phan tu ko duoc vuot qua 1000!","Canh bao",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(mang.length!=Integer.parseInt(txtElementCount.getText()))
        {
            JOptionPane.showMessageDialog(null, "Vui long kiem tra mang nhap vao","So luong phan tu khong du!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String input= txtArray.getText()+"@"+txtMoveCount.getText();

        try {
           DatagramSocket clientsocket = new DatagramSocket();
           System.out.println("Kết nối server");

           byte out[] = input.getBytes();
           int length = out.length;
           InetAddress address = InetAddress.getByName("localhost");
           int port = 1114;

           DatagramPacket sendData = new DatagramPacket(out, length, address, port);
           clientsocket.send(sendData);

           byte in[] = new byte[256];
           DatagramPacket receiveData = new DatagramPacket(in, in.length);
           clientsocket.receive(receiveData);

           String resultStr = new String(receiveData.getData(), 0, receiveData.getLength()).trim();


           txtKetQua.setText(resultStr);

            clientsocket.close();
        } catch (SocketException ex) {
            Logger.getLogger(frmMoveArrayUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
             System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnMoveArrayActionPerformed
    //Gui so va tuy chon phep tinh
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMoveArrayUDP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoveArray;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtArray;
    private javax.swing.JTextField txtElementCount;
    private javax.swing.JTextField txtKetQua;
    private javax.swing.JTextField txtMoveCount;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
