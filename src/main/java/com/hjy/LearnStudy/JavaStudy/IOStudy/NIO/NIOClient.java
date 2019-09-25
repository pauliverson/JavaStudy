package com.hjy.LearnStudy.JavaStudy.IOStudy.NIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author huangjunyan
 * @program test
 * @description Client
 * @date 2019-08-21 11:04
 */
public class NIOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1",3333);
                while (true) {
                    socket.getOutputStream().write((new Date() + " : hello! I'm client").getBytes());
                    Thread.sleep(2000);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
