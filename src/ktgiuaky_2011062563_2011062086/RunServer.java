/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ktgiuaky_2011062563_2011062086;

import TCP.Cau1.CountEvenOddTCPServerTCP;
import TCP.Cau2.FindMinTCPServer;
import TCP.Cau3.NameFormatTCPServer;
import TCP.Cau4.MoveArrayTCPServer;
import UDP.Cau1.CountEvenOddUDPServer;
import UDP.Cau2.FindMinUDPServer;
import UDP.Cau3.NameFormatUDPServer;
import UDP.Cau4.MoveArrayUDPServer;
import javax.swing.SwingWorker;


public class RunServer {
    public void runTcpServer1(){
        //SwingWorker là 1 lớp trong java để thực hiện 1 công việc dưới nền để tương tác với giao diện Swing một cách an toàn
        //Điều này làm cho việc thực hiện máy chủ TCP hay UDP không chặn luồng chính của giao diện người dùng (UI)
        
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                CountEvenOddTCPServerTCP server = new CountEvenOddTCPServerTCP();
                server.action();
                return null;
            }
        };
        worker.execute();
    }
    
    public void runTcpServer2(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                FindMinTCPServer server = new FindMinTCPServer();
                server.action();
                return null;
            }
        };
        worker.execute();
    }
    
    public void runTcpServer3(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                NameFormatTCPServer server = new NameFormatTCPServer();
                server.action();
                return null;
            }
        };
        worker.execute();
    }
    
    public void runTcpServer4(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                MoveArrayTCPServer server = new MoveArrayTCPServer();
                server.action();
                return null;
            }
        };
        worker.execute();
    }
    
    public void runUdpServer1(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                CountEvenOddUDPServer.runServer();
                return null;
            }
        };
        worker.execute();
    }
    public void runUdpServer2(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                FindMinUDPServer.runServer();
                return null;
            }
        };
        worker.execute();
    }
    public void runUdpServer3(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                NameFormatUDPServer.runServer();
                return null;
            }
        };
        worker.execute();
    }
    public void runUdpServer4(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                MoveArrayUDPServer.runServer();
                return null;
            }
        };
        worker.execute();
    }
}
