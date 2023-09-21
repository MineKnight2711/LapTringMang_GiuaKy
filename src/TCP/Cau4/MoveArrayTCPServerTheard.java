/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.Cau4;

import TCP.Cau2.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/*
 *
 * @author WitherDragon
 */
public class MoveArrayTCPServerTheard implements Runnable{
     private Scanner in=null;
    private PrintWriter out =null;
    private Socket socket;
    private String name;
    public MoveArrayTCPServerTheard (Socket socket,String name) 
            throws IOException  
    {   
           this.socket =socket;
           this.name= name;
           this.in = new Scanner(this.socket.getInputStream());
           this.out = new PrintWriter(this.socket.getOutputStream(),true);
           new Thread(this).start();
    }
    public void run()
    {
        try
        {
            while (true)
            {
                String chuoi = in.nextLine().trim();
                String[] input=chuoi.split("@");
                String chuoimang= input[0];
                int movecount=Integer.parseInt(input[1]);

                String rotatedString = rotateLeft(chuoimang, movecount);
                
                out.println(rotatedString);
            }
        }
        catch (Exception e)
        {
            System.out.println(name+" has departed");
        }
        finally
        {
            try{socket.close();} catch(IOException e){}
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

