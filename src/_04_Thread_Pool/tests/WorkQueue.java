package _04_Thread_Pool.tests;

import java.lang.Thread.State;
import java.util.ArrayDeque;
import java.util.Iterator;

public class WorkQueue implements Runnable{
	private ArrayDeque<Job> jobQueue = new ArrayDeque<Job>();
	private Thread[] threads;
	private volatile boolean isRunning = true;
	
	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors()-1;
		threads = new Thread[totalThreads];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(this);
			threads[i].start();
		}
	}
	
	public void addJob(Job j) {
		synchronized(jobQueue) {
			jobQueue.add(j);
			jobQueue.notify();
		}

	}
	
	public int getThreadCount() {
		return threads.length;
	}
	
	public void run() {
		while(isRunning) {
			if(!performJob()) {
				synchronized(jobQueue) {
					try {
						jobQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void shutdown() {
		completeAllJobs();
		isRunning = false;
		synchronized(jobQueue) {
			jobQueue.notifyAll();
		}
	}
	
	public boolean performJob() {
		Job j = null;
		synchronized(jobQueue) {
			if(!jobQueue.isEmpty()) {
				j = jobQueue.remove();
			}
		}
		if(j != null) {
			j.perform();
			return true;
		}
		else {
			return false;
		}
	}
	
	public void completeAllJobs() {
		while (!jobQueue.isEmpty()) {
			performJob();
		}
		for (int i = 0; i < threads.length; i++) {
			if(threads[i].getState() != State.WAITING) {
				i = -1;
			}
		}
	}
	
	public static void main(String[] args) {
		WorkQueue wq = new WorkQueue();
		for (int i = 0; i < 1000; i++) {
			int x = i;
			Job j = ()->{
				System.out.println("Printing " + x + " from thread #" + Thread.currentThread().getId());
			};
			wq.addJob(j);
		}
		wq.shutdown();
	}
}
