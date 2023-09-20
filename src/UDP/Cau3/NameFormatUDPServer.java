/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.Cau3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class NameFormatUDPServer {
   public static void main(String[] args) throws SocketException, IOException {
        runServer();

    }
   public static void runServer() throws SocketException, IOException {
        DatagramSocket serverSocket = new DatagramSocket(1114);
        System.out.println("Server đã sẵn sàng");

        while (true) {
            byte infromclient[] = new byte[256];
            DatagramPacket fromclient = new DatagramPacket(infromclient, infromclient.length);

            serverSocket.receive(fromclient);
            String data = new String(fromclient.getData(), 0, fromclient.getLength()).trim();
            
            String resultStr = formatName(data);
            byte outtoclient[] = resultStr.getBytes();
            int length = outtoclient.length;
            InetAddress add = fromclient.getAddress();
            int port = fromclient.getPort();
            DatagramPacket toclient = new DatagramPacket(outtoclient, length, add, port);
            serverSocket.send(toclient);
        }
    }
    public static String formatName(String name) {
        // Cat chuoi ten thanh tung tu
        String[] words = name.split("\\s+");

        
        StringBuilder formattedName = new StringBuilder();

        for (String word : words) {
            //Ghi hoa chu cai dau cua moi tu
            String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();

            //Noi chuoi voi mot khoang trang duy nhat
            formattedName.append(capitalizedWord).append(" ");
        }

        return formattedName.toString().trim();
    
    }

    
   
}
