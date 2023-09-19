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

