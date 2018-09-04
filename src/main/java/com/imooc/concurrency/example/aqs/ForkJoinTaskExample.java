package com.imooc.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author peterlee
 * @Date 2018/9/4 下午2:23
 * @Describtion : 使用fork/join 拆分聚合。递归调用计算总和
 */
@Slf4j
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

    public static final int threshoud = 2 ; //任务粒度
    private int start;
    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum =0;
        //如果任务足够小就计算任务
        boolean canCompute = (end-start) <= threshoud;
        if(canCompute){
            for (int i =start;i<=end;i++){
                sum+=i;
            }
        }else{
            //如果任务足够大超过阈值，就分裂成两个子任务计算
            int middle = (end+start)/2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, middle);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle+1, end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            sum =leftTask.join()+rightTask.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算 1+2+3+4+5+.....
        ForkJoinTaskExample task = new ForkJoinTaskExample(1, 100);
        //执行任务
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try {
            log.info("result:{}",result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
