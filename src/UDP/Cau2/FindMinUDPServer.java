/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.Cau2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class FindMinUDPServer {
   public static void main(String[] args) throws SocketException, IOException {
              runServer();
   }
   
   public static void runServer()throws SocketException, IOException{
        DatagramSocket serverSocket = new DatagramSocket(1113);
        System.out.println("Server đã sẵn sàng");

        while (true) {
            byte infromclient[] = new byte[256];
            DatagramPacket fromclient = new DatagramPacket(infromclient, infromclient.length);

            serverSocket.receive(fromclient);
            
            String data = new String(fromclient.getData(), 0, fromclient.getLength()).trim();
            String[] input=data.split("@");
            String chuoimang= input[1];
            System.out.println(chuoimang);
            String[] numberTokens =chuoimang.split(" ");
            //Tạo 1 mảng số nguyên có độ dài bằng mảng numberTokens 
            int[] numbersArray = new int[numberTokens.length];
            //Duyệt từng phần tử của mảng numberTokens và đưa vào mảng numbersArray
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
            //Khởi tạo 2 số nguyên nhỏ nhất trong mảng với giá trị số nguyên lớn nhất
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            //Duyệt từng phần tử của mảng arr được truyền vào
            for (int num : arr) {
                //Nếu num nhỏ hơn min, nó sẽ cập nhật secondMin thành giá trị hiện tại của min và cập nhật min thành giá trị của num. 
                //Nó đảm bảo rằng min luôn chứa giá trị tối thiểu được tìm thấy, và secondMin chứa giá trị nho được tìm thấy.
                if (num < min) {
                    secondMin = min;
                    min = num;
                }
                //Nếu num lớn hơn hoặc bằng min nhưng nhỏ hơn secondMin (và không bằng min), nó sẽ cập nhật secondMin thành giá trị của num.
                else if (num < secondMin && num != min) {
                    secondMin = num;
                }
            }
            String result = "Ket qua:"+"số nhỏ nhất "+min+" "+" số nhỏ thứ hai"+ secondMin ;
            return result;
        }
        return "";
    }
   
}
