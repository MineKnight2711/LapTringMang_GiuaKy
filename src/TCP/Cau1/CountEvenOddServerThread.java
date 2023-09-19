/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.Cau1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *
 * @author WitherDragon
 */
public class CountEvenOddServerThread implements Runnable{
     private Scanner in=null;
    private PrintWriter out =null;
    private Socket socket;
    private String name;
    public CountEvenOddServerThread (Socket socket,String name) 
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
                 
                out.println(countOddEven(chuoi));
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
    public String countOddEven(String numberString) {
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
