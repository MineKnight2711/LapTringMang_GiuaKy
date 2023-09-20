/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.Cau1;


import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ad
 */
public class CountEvenOddTCPServerTCP {
    static final int PORT = 1111;
    private ServerSocket server = null;
    public CountEvenOddTCPServerTCP()
    {
        try{
            server = new ServerSocket(PORT);
        }catch(Exception e){e.printStackTrace();}
    }
    public void action()
    {
        Socket socket = null;
        int i=0;
        System.out.println("Server dang lang nghe...");
        try{
            while((socket= server.accept())!=null)
            {
                new CountEvenOddServerThreadTCP(socket, "Client#"+i);
                System.out.printf("Thread for Client#%d generating...%n", i++);
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
       new CountEvenOddTCPServerTCP().action();
    }
    
}
