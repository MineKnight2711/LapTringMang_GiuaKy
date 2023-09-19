/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.Cau2;

import static TCP.Cau2.FindMinTCPServerTheard.findMinAndSecondMin;
import UDP.Cau1.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class FindMinUDPServer {
   public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket serverSocket = new DatagramSocket(1113);
        System.out.println("Server đã sẵn sàng");

        while (true) {
            byte infromclient[] = new byte[256];
            DatagramPacket fromclient = new DatagramPacket(infromclient, infromclient.length);

            serverSocket.receive(fromclient);
            String data = new String(fromclient.getData(), 0, fromclient.getLength()).trim();
            String[] input=data.split("@");
            int sophantu=Integer.parseInt(input[0]);
           
            String chuoimang= input[1];
            System.out.println(chuoimang);
            String[] numberTokens =chuoimang.split(" ");

            int[] numbersArray = new int[numberTokens.length];
            for (int i = 0; i < numberTokens.length; i++) {
                numbersArray[i] = Integer.parseInt(numberTokens[i]);
            }

            String resultStr = findMinAndSecondMin(numbersArray);
            byte outtoclient[] = resultStr.getBytes();
            int length = outtoclient.length;
            InetAddress add = fromclient.getAddress();
            int port = fromclient.getPort();
            DatagramPacket toclient = new DatagramPacket(outtoclient, length, add, port);
            serverSocket.send(toclient);
        }
        
    }
    public static String findMinAndSecondMin(int[] arr) {
        if(arr.length>1)
        {
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;

            for (int num : arr) {
                if (num < min) {
                    secondMin = min;
                    min = num;
                } else if (num < secondMin && num != min) {
                    secondMin = num;
                }
            }
            String result=min+" "+secondMin;
            return result;
        }
        return "";
    }
   
}
