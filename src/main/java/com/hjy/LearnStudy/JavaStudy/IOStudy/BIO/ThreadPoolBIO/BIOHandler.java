package com.hjy.LearnStudy.JavaStudy.IOStudy.BIO.ThreadPoolBIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-21 12:01
 */
public class BIOHandler implements Runnable {

    private Socket socket;

    public BIOHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            printWriter = new PrintWriter(this.socket.getOutputStream(),true);
            while (true) {
                String line = bufferedReader.readLine();
                if (null == line)
                    break;
                System.out.println("server receive " + line);
                if ("current time".equalsIgnoreCase(line)) {
                    printWriter.println(new Date(System.currentTimeMillis()));
                }else {
                    printWriter.println("content is " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedReader)
                    bufferedReader.close();
                if (null != printWriter)
                    printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
