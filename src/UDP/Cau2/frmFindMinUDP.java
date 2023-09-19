/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UDP.Cau2;

import UDP.Cau1.*;
import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class frmFindMinUDP extends javax.swing.JFrame {

    /**
     * Creates new form frmcongTruNhanChia
     */
    public frmFindMinUDP() {
        initComponents();
        createElementCountOnTextChangeEvent();
        createArrayOnTextChangeEvent();
    }
     private void createElementCountOnTextChangeEvent()
    {
        txtElementCount.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                elementCountOnTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                elementCountOnTextChanged();    
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                elementCountOnTextChanged();
            }
          });
    }
    
    private void createArrayOnTextChangeEvent()
    {
        txtArray.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                arrayOnTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                arrayOnTextChanged();    
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                arrayOnTextChanged();
            }
          });
    }
     public void elementCountOnTextChanged()
    {   
        if(!txtElementCount.getText().isEmpty())
        {
            int phantu=Integer.parseInt(txtElementCount.getText());
            if(phantu<2 || phantu>100)
            {
                lbError.setText("So phan tu cua mang phai nam trong khoang 2<n<100");
                lbError.setForeground(Color.red);
            }
            else
            {
                lbError.setText("");
            }
        }
    }
     
    public String loaiBoPhanTuTrung() {
        if(!txtArray.getText().isEmpty())
        {
            String[] numberTokens = txtArray.getText().split(" ");

            Set<Integer> numberSet = new LinkedHashSet<>();
            for (String token : numberTokens) {
                numberSet.add(Integer.parseInt(token));
            }

            int[] numbersArray = new int[numberSet.size()];
            int index = 0;
            for (int number : numberSet) {
                numbersArray[index] = number;
                index++;
            }

            return Arrays.toString(numbersArray);
        }
        return "";
    } 
     
     public void arrayOnTextChanged()
    {   
        String[] stringArray = loaiBoPhanTuTrung().split(" ");
        if(stringArray.length!=Integer.parseInt(txtElementCount.getText()))
        {
            lbError.setText("Ban chua nhap dung so phan tu \n Cac phan tu cua mang ko duoc trung nhao");
            lbError.setForeground(Color.red);
            return;
        }
        else
        {
             lbError.setText("");
        }
        String mangInput= txtElementCount.getText()+"@"+txtArray.getText();
        try {
           DatagramSocket clientsocket = new DatagramSocket();
           System.out.println("Kết nối server");

           byte out[] = mangInput.getBytes();
           int length = out.length;
           InetAddress address = InetAddress.getByName("localhost");
           int port = 1113;

           DatagramPacket sendData = new DatagramPacket(out, length, address, port);
           clientsocket.send(sendData);

           byte in[] = new byte[256];
           DatagramPacket receiveData = new DatagramPacket(in, in.length);
           clientsocket.receive(receiveData);

           String resultStr = new String(receiveData.getData(), 0, receiveData.getLength()).trim();


           txtKetQua.setText(resultStr);

            clientsocket.close();
        } catch (SocketException ex) {
            Logger.getLogger(frmFindMinUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
             System.out.println(e.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtResult = new javax.swing.JTextField();
        txtElementCount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtArray = new javax.swing.JTextField();
        txtKetQua = new javax.swing.JTextField();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArray, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtElementCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtElementCount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArray, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(lbError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
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
    //Gui so va tuy chon phep tinh
    
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
            java.util.logging.Logger.getLogger(frmFindMinUDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFindMinUDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFindMinUDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFindMinUDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFindMinUDP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbError;
    private javax.swing.JTextField txtArray;
    private javax.swing.JTextField txtElementCount;
    private javax.swing.JTextField txtKetQua;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
