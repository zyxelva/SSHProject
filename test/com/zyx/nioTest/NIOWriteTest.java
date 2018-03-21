/**
 *
 * <p>
 * Title: ddd.java
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 *
 * <p>
 * Company: zyx@taeyeon.cn
 * </p>
 *
 * @author KEN
 *
 * @date 2018年3月8日
 *
 * @version 1.0
 *
 */

package com.zyx.nioTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * @author KEN
 *
 */

public class NIOWriteTest {
    private static final byte message[] = { 83, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46 };

    /*
     * 使用NIO写入数据
     *
     * 使用NIO写入数据与读取数据的过程类似，同样数据不是直接写入通道，而是写入缓冲区，可以分为下面三个步骤：
     * 1.从FileOutputStream获取Channel
     * 2. 创建Buffer
     * 3. 将数据从Channel写入到Buffer中
     */
    @Test
    public void writeNIO() throws Exception {
        FileOutputStream fout = new FileOutputStream("d:\\test.txt");
        FileChannel fc = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(message);
        buffer.flip();
        fc.write(buffer);
        fout.close();
    }

    /*
     * 使用NIO读取数据
     *
     * 在前面我们说过，任何时候读取数据，都不是直接从通道读取，而是从通道读取到缓冲区。所以使用NIO读取数据可以分为下面三个步骤：
     * 1.从FileInputStream获取Channel
     * 2. 创建Buffer
     * 3. 将数据从Channel读取到Buffer中
     */

    @Test
    public void readNIO() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileInputStream fin = null;
        // 读取数据到缓冲区
        try {
            fin = new FileInputStream("d:\\test.txt");
            // 获取通道
            FileChannel fc = fin.getChannel();
            // 创建缓冲区
            fc.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer.flip();

        while (buffer.remaining() > 0) {
            byte b = buffer.get();
            System.out.print(((char) b));
        }

        try {
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}