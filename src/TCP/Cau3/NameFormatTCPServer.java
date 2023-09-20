
package TCP.Cau3;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ad
 */
public class NameFormatTCPServer {
    static final int PORT = 3111;
    private ServerSocket server = null;
    public NameFormatTCPServer()
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
                new NameFormatTCPServerTheard(socket, "Client#"+i);
                System.out.printf("Thread for Client#%d generating...%n", i++);
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
       new NameFormatTCPServer().action();
    }
    
}
