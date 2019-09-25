package com.hjy.LearnStudy.JavaStudy.Piped;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-09-01 15:03
 */
public class Piped {
    public static void main(String[] args) {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        try {
            out.connect(in);
            Thread printThread = new Thread(new Print(in), "PrintThread");
            printThread.start();
            int receive = 0;
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    static class Print implements Runnable {
        private PipedReader in;
        public Print(PipedReader in) {
            this.in = in;
        }
        @Override
        public void run() {
            int receive;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException ex) {

            }
        }
    }
}
