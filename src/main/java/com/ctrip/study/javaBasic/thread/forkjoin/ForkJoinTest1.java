package com.ctrip.study.javaBasic.thread.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinTest1 {

	public static void main(String[] args) {
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> products = generator.generate(30);
		Task task = new Task(products, 0, products.size(), 0.20);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		while (!task.isDone()) {
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
		if (task.isCompletedNormally()) {
			System.out.println("Main: The process has completed normally");
		}

		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getPrice() != 12) {
				System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
			}
		}
		
		System.out.println("Main: End of the program.\n");


	}
}
