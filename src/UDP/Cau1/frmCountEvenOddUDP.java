/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UDP.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class frmCountEvenOddUDP extends javax.swing.JFrame {

    /**
     * Creates new form frmcongTruNhanChia
     */
    public frmCountEvenOddUDP() {
        initComponents();
        createOnTextChangeEvent();
    }
     private void createOnTextChangeEvent()
    {
        txtInput.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChanged();    
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChanged();
            }
          });
    }
     public void onTextChanged()
    {   
        String input = txtInput.getText();
        if(input.length()>9)
        {
            JOptionPane.showMessageDialog(null, "Vui long nhap 1 chuoi khong qua 9 ky tu!","Canh bao",JOptionPane.ERROR_MESSAGE);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    txtInput.setText(input.substring(0,9));
                }
            });
            return;
        }
        if(!containsOnlyNumbers(input)&&!input.isEmpty())
        {
            JOptionPane.showMessageDialog(
                null,
                "Chỉ cho phép nhập số!",
                "Cảnh báo",
                JOptionPane.ERROR_MESSAGE
            );
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    txtInput.setText("");
                }
            });
            return;
        }
         try {
            DatagramSocket clientsocket = new DatagramSocket();
            System.out.println("Kết nối server");

            byte out[] = input.getBytes();
            int length = out.length;
            InetAddress address = InetAddress.getByName("localhost");
            int port = 1112;

            DatagramPacket sendData = new DatagramPacket(out, length, address, port);
            clientsocket.send(sendData);

            byte in[] = new byte[256];
            DatagramPacket receiveData = new DatagramPacket(in, in.length);
            clientsocket.receive(receiveData);

            String resultStr = new String(receiveData.getData(), 0, receiveData.getLength()).trim();
             
           
            txtResult.setText(resultStr);

             clientsocket.close();
        } catch (SocketException ex) {
            Logger.getLogger(frmCountEvenOddUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
             System.out.println(e.toString());
        }
    }
    private boolean containsOnlyNumbers(String input) {
        return input.matches("[\\d\\s]+");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtResult = new javax.swing.JTextField();
        txtInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dem chan le UDP");

        txtResult.setEditable(false);

        jLabel1.setText("Nhap 1 so nguyen");

        jLabel3.setText("Ket qua");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCountEvenOddUDP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
