/**
 *
 * <p>
 * Title: MyMultiThread.java
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
 * @date 2018年2月27日
 *
 * @version 1.0
 *
 */

package com.zyx.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author KEN
 *
 */
public class MyMultiThread {

    /**
     *
     *
     * <p>
     * Title: main
     * </p>
     *
     *
     * <p>
     * Description:
     * </p>
     *
     *
     * @param args
     *
     *
     */

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Runnable target = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " 的i值为：" + i);
            }
        };

        threadPool.submit(target);
        threadPool.submit(target);
        threadPool.submit(target);
        threadPool.submit(target);

        threadPool.shutdown();

    }

}
