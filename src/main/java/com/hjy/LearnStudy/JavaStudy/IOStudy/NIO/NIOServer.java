package com.hjy.LearnStudy.JavaStudy.IOStudy.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author pauljy
 * @program test
 * @description
 * @date 2019-08-21 14:32
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        Selector serverSelector = Selector.open();

        Selector clientSelector = Selector.open();
        new Thread(() -> {
            try {
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.bind(new InetSocketAddress(3333));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                while (true) {
                    if (serverSelector.select(1) > 0) {
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while (keyIterator.hasNext()) {
                            SelectionKey selectionKey = keyIterator.next();

                            if (selectionKey.isAcceptable()) {
                                SocketChannel clientChannel = ((ServerSocketChannel)selectionKey.channel()).accept();
                                clientChannel.configureBlocking(false);
                                clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                keyIterator.remove();
                            }
                        }

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {

            try {
                while (true) {
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while (keyIterator.hasNext()) {
                            SelectionKey selectionKey = keyIterator.next();

                            if (selectionKey.isReadable()) {
                                SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                clientChannel.read(byteBuffer);
                                byteBuffer.flip();
                                System.out.println(
                                        Charset.defaultCharset().newDecoder().decode(byteBuffer).toString()
                                );
                                keyIterator.remove();
                                selectionKey.interestOps(SelectionKey.OP_READ);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
