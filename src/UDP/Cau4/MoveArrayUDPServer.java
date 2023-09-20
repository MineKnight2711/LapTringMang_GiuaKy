/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.Cau4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MoveArrayUDPServer {
   public static void main(String[] args) throws SocketException, IOException {
        runServer();
   }
   public static void runServer() throws SocketException, IOException{
       DatagramSocket serverSocket = new DatagramSocket(1115);
        System.out.println("Server đã sẵn sàng");

        while (true) {
            byte infromclient[] = new byte[256];
            DatagramPacket fromclient = new DatagramPacket(infromclient, infromclient.length);

            serverSocket.receive(fromclient);
            String data = new String(fromclient.getData(), 0, fromclient.getLength()).trim();
            String[] input=data.split("@");
            String chuoimang= input[0];
            int movecount=Integer.parseInt(input[1]);
            
            String resultStr = rotateLeft(chuoimang, movecount);
            byte outtoclient[] = resultStr.getBytes();
            int length = outtoclient.length;
            InetAddress add = fromclient.getAddress();
            int port = fromclient.getPort();
            DatagramPacket toclient = new DatagramPacket(outtoclient, length, add, port);
            serverSocket.send(toclient);
        }
    }
    public static String rotateLeft(String input, int movecount) {
        String[] tokens = input.split(" ");
        int length = tokens.length;

        StringBuilder rotatedString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int newIndex = (i + movecount + length) % length;
            rotatedString.append(tokens[newIndex]);

            if (i < length - 1) {
                rotatedString.append(" ");
            }
        }

        return rotatedString.toString();
    }
}
