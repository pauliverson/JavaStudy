package com.hjy.LearnStudy.JavaStudy.IOStudy.BIO.ThreadPoolBIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-21 12:13
 */
public class BIOClient {
    public static void main(String[] args) {
        int port = 2222;
        if (null != args && args.length == 1) {
            port = Integer.parseInt(args[0]);
        }

        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;

        try {
            socket = new Socket("127.0.0.1",port);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(),true);
            while (true) {
                printWriter.println("current time");
                System.out.println("send current time");
                String responseBody = bufferedReader.readLine();
                System.out.println("response body is " + responseBody);
                Thread.sleep(2000);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedReader)
                    bufferedReader.close();
                if (null != printWriter)
                    printWriter.close();
                if (null != socket)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
