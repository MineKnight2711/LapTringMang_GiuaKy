/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.Cau2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/*
 *
 * @author WitherDragon
 */
public class FindMinTCPServerTheard implements Runnable{
     private Scanner in=null;
    private PrintWriter out =null;
    private Socket socket;
    private String name;
    public FindMinTCPServerTheard (Socket socket,String name) 
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
                String chuoimang= input[1];
                String[] numberTokens =chuoimang.split(" ");

                int[] numbersArray = new int[numberTokens.length];
                for (int i = 0; i < numberTokens.length; i++) {
                    numbersArray[i] = Integer.parseInt(numberTokens[i]);
                }
                System.out.println(Arrays.toString(numbersArray));
                
                out.println(findMinAndSecondMin(numbersArray));
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
