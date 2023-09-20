/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class CountEvenOddUDPServer {
   public static void main(String[] args) throws IOException {
        runServer();
   }
   public static void runServer()throws SocketException, IOException {
       DatagramSocket serverSocket = new DatagramSocket(1112);
        System.out.println("Server đã sẵn sàng");
        while (true) {
            byte infromclient[] = new byte[256];
            DatagramPacket fromclient = new DatagramPacket(infromclient, infromclient.length);

            serverSocket.receive(fromclient);
            String data = new String(fromclient.getData(), 0, fromclient.getLength()).trim();
            
            String resultStr = countOddEven(data);
            byte outtoclient[] = resultStr.getBytes();
            int length = outtoclient.length;
            InetAddress add = fromclient.getAddress();
            int port = fromclient.getPort();
            DatagramPacket toclient = new DatagramPacket(outtoclient, length, add, port);
            serverSocket.send(toclient);
        }
   }
    public static String countOddEven(String numberString) {
        int oddCount = 0;
        int evenCount = 0;
        
        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            
            //Kiem tra chuoi nhap vao co phai so nguyen 
            if (Character.isDigit(digitChar)) {
                int digit = Character.getNumericValue(digitChar);
                
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            } else {
                
                System.out.println("Co ky tu khong phai so nghuyen: " + digitChar);
            }
        }
        
        String result = oddCount+" "+ evenCount ;
        return result;
    }
   
}
