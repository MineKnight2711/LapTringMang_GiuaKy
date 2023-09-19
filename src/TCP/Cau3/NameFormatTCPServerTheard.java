/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.Cau3;

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
public class NameFormatTCPServerTheard implements Runnable{
     private Scanner in=null;
    private PrintWriter out =null;
    private Socket socket;
    private String name;
    public NameFormatTCPServerTheard (Socket socket,String name) 
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
                
                
                out.println(formatName(chuoi));
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
