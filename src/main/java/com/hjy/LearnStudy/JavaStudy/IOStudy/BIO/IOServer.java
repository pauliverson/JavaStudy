package com.hjy.LearnStudy.JavaStudy.IOStudy.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pauljy
 * @program test
 * @description Server
 * @date 2019-08-21 11:13
 */
public class IOServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3333);
            new Thread(() -> {
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();
                        new Thread(() -> {
                            try {
                                int len;
                                byte[] data = new byte[1024];
                                InputStream inputStream = socket.getInputStream();
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
