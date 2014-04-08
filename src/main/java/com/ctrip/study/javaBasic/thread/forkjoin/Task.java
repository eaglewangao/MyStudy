package com.ctrip.study.javaBasic.thread.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {

	private static final long serialVersionUID = 4787107748259869173L;

	private List<Product> products;

	// 决定这个任务产品的阻塞过程。
	private int first, last;

	// 存储产品价格的增长
	private double increment;

	public Task(List<Product> products, int first, int last, double increment) {
		this.products = products;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}

	@Override
	protected void compute() {
		/**
		 * 如果last和first的差小于10（任务只能更新价格小于10的产品）， 使用updatePrices()方法递增的设置产品的价格
		 */
		if (last - first < 10) {
			updatePrices();
		}
		/**
		 * 如果last和first的差大于或等于10， 则创建两个新的Task对象， 一个处理产品的前半部分， 另一个处理产品的后半部分，
		 * 然后在ForkJoinPool中，使用invokeAll()方法执行它们
		 */
		else {
			int middle = (last + first) / 2;
			System.out.println("Task: Pending tasks:" + getQueuedTaskCount());
			Task t1 = new Task(products, first, middle + 1, increment);
			Task t2 = new Task(products, middle + 1, last, increment);
			invokeAll(t1, t2);
		}

	}

	private void updatePrices() {
		for (Product product : products) {
			System.out.println(product.getPrice());
			product.setPrice(product.getPrice() * (1 + increment));
		}
	}
	
	
}
