/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.Cau1;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author witherdragon
 */
public class CountEvenOddTCPServerTCP {
    static final int PORT = 1111;
    private ServerSocket server = null;
//    private boolean isRunning = false;
    public CountEvenOddTCPServerTCP()
    {
        try{
            server = new ServerSocket(PORT);
        }catch(Exception e){e.printStackTrace();}
    }
    public void action()
    {
//        isRunning=true;
        Socket socket = null;
        int i=0;
        System.out.println("Server cau 1 dang lang nghe...");
        try{
            while((socket= server.accept())!=null)
            {
                new CountEvenOddServerThreadTCP(socket, "Client#"+i);
                System.out.printf("Thread for Client#%d generating...%n", i++);
            }
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
//    public void stopServer() {
//        if (isRunning) {
//            isRunning = false;
//            try {
//                if (server != null && !server.isClosed()) {
//                    server.close();
//                    System.out.println("Server stopped.");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    
    public static void main(String[] args) {
       new CountEvenOddTCPServerTCP().action();
    }
    
}
