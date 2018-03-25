package com.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPool {

	public static void main(String[] args) {
		//executor();
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return (int) (Math.random() * 100);
			}
		};
		FutureTask<Integer> future = new FutureTask<>(callable);
		new Thread(future).start();
		
		try {
			Thread.sleep(111);
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static void executor() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<>(threadPool);
		List<Future<Integer>> futures = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			final int taskId = i;
			Future<Integer> future = cs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					return taskId;
				}
			});
			futures.add(future);
		}
		
		for (Future<Integer> future : futures) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
