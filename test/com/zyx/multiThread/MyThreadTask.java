package com.zyx.multiThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class MyThreadTask extends RecursiveTask<Integer> {
    /**
     *
     */
    private static final long serialVersionUID = -3331203791103875666L;
    private int start;
    private int end;
    final int THREASHOLD = 50;
    int[] array;

    /**
     *
     */

    public MyThreadTask(int[] arr, int start, int end) {
        this.start = start;
        this.end = end;
        this.array = arr;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start < THREASHOLD) {
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = start + (end - start) / 2;
            MyThreadTask left = new MyThreadTask(array, start, mid);
            MyThreadTask right = new MyThreadTask(array, mid, end);
            left.fork();
            right.fork();
            System.out.println("+++++++++++++++++++华丽的分割线+++++++++++++++++++++++++");
            System.out.println("start= " + start + "\t" + "mid=  " + mid + "\t" + "left.join()= " + left.join());
            System.out.println("mid=  " + mid + "\t" + "end= " + end + "\t" + "right.join()= " + right.join());
            System.out.println("+++++++++++++++++++华丽的分割线+++++++++++++++++++++++++");
            return left.join() + right.join();
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int total = 0;
        int[] array = new int[100];
        for (int i = 1; i <= 100; i++) {
            array[i - 1] = i;
            total += array[i - 1];
        }
        System.out.println("++++++++++++++++for循环相加后的结果：++++++++++++++++++++++");
        System.out.println("total= " + total);
        System.out.println("+++++++++++++++++++华丽的分割线+++++++++++++++++++++++++");
        Future<Integer> future = pool.submit(new MyThreadTask(array, 0, array.length));
        System.out.println("+++++++++++++++++分治后的计算结果：+++++++++++++++++++++++");
        System.out.println("total= " + future.get());

        pool.shutdown();

    }

}
