package com.ctrip.study.javaBasic.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer>{
	
	private static final long serialVersionUID = -8565637549686115169L;

	/** 阀值. */
	private static final int THRESHOLD = 10;
	
	private int start;
	
	private int end;
	
	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		if(canCompute){
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		}else{
			//如果大于阀值，就分割成两个子任务
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			//执行子任务
			leftTask.fork();
			rightTask.fork();
			//合并子任务
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			System.out.println("左边计算从" + start + " ~ " + middle + "，结果为：" + leftResult);
			System.out.println("右边计算从" + (middle + 1) + " ~ " + end + "，结果为：" + rightResult);
			sum = leftResult + rightResult;
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		CountTask task = new CountTask(1, 100);
		Future<Integer> result = pool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	

}
