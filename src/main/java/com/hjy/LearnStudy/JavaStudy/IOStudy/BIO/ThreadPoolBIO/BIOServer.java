package com.hjy.LearnStudy.JavaStudy.IOStudy.BIO.ThreadPoolBIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-21 11:58
 */
public class BIOServer {
    public static void main(String[] args) {
        int port = 2222;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            BIOServerHandlerPool bioServerHandlerPool = new BIOServerHandlerPool(50, 100);
            while (true) {
                Socket socket = serverSocket.accept();
                bioServerHandlerPool.execute(new BIOHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != serverSocket)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
