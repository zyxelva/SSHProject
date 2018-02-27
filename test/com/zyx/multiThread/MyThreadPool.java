package com.zyx.multiThread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class MyThreadPool extends RecursiveAction {
    /**
     *
     */
    private static final long serialVersionUID = -3331203791103875666L;
    private int start;
    private int end;
    final int THREASHOLD = 50;

    /**
     *
     */
    public MyThreadPool(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end-start<THREASHOLD){
            for(int i=start;i<=end;i++){
                System.out.println(Thread.currentThread().getName()+" 的i值为："+i);
            }
        }
        else{
            int mid=start+(end-start)/2;
            MyThreadPool left=new MyThreadPool(start, mid);
            MyThreadPool right=new MyThreadPool(mid+1, end);
            left.fork();
            right.fork();
        }

    }

    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();
        pool.submit(new MyThreadPool(0, 100));
        try {
            pool.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();

    }

}
