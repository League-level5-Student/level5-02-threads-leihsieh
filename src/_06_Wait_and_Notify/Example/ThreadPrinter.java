package _06_Wait_and_Notify.Example;

public class ThreadPrinter implements Runnable{
	static int totalThreads = 0;
	private int thread;
	public ThreadPrinter() {
		totalThreads++;
		thread = totalThreads;
	}
	
	@Override
	public void run() {
		System.out.println("Thread " + thread + " Line 1");
		System.out.println("Thread " + thread + " Line 2");
		System.out.println("Thread " + thread + " Line 3");
		System.out.println("Thread " + thread + " Line 4");
	}
}
