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
        //Khởi tạo 1 StringBuilder để xây dựng chuỗi kết quả
        StringBuilder rotatedString = new StringBuilder();
        //Vòng lặp for sẽ duyệt qua từng phần tử trong mảng tokens
        for (int i = 0; i < length; i++) {
            //Dòng này tính toán chỉ số mới của phần tử sau khi di chuyển bằng cách thêm movecount vào chỉ số hiện tại 
            //và sau đó sử dụng toán tử % để đảm bảo rằng chỉ số mới nằm trong khoảng từ 0 đến length - 1
            //nghĩa là  chỉ số này không vượt quá giới hạn của mảng ban đầu,đảm bảo rằng chỉ số này phải nằm trong khoảng từ 0 đến length - 1
            int newIndex = (i + movecount + length) % length;
            //Phần tử có chỉ số mới được thêm vào chuỗi kết quả bằng phương thức append
            rotatedString.append(tokens[newIndex]);
            //Nếu vòng lặp chưa đến phần tử cuối cùng của mảng, thì một khoảng trắng sẽ được thêm vào sau phần tử cuối cùng hiện tại của rotatedString. 
            //Điều này giúp giữ c khoảng trắng giữa các từ trong chuỗi kết quả.
            if (i < length - 1) {
                rotatedString.append(" ");
            }
        }

        return rotatedString.toString();
    }
}
