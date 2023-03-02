package _06_Wait_and_Notify.Example;

public class SynchedThreadPrinter implements Runnable{
	static Object threadLock = new Object();
	static int totalThreads = 0;
	private int thread;
	public SynchedThreadPrinter() {
		totalThreads++;
		thread = totalThreads;
	}
	
	@Override
	public void run() {
		synchronized(threadLock) { //locks this block of code if another thread is using threadLock
			System.out.println("Thread " + thread + " Line 1");
			threadLock.notify(); //let other threads waiting on threadLock know that they can start
			try {
				threadLock.wait(); //pauses execution until another thread calls notify using threadLock
			} catch (InterruptedException e) {
				System.out.println("error!");
			}
			
			System.out.println("Thread " + thread + " Line 2");
			threadLock.notify(); //let other threads waiting on threadLock know that they can start
			try {
				threadLock.wait(); //pauses execution until another thread calls notify using threadLock
			} catch (InterruptedException e) {
				System.out.println("error!");
			}
			
			System.out.println("Thread " + thread + " Line 3");
			threadLock.notify(); //let other threads waiting on threadLock know that they can start
			try {
				threadLock.wait(); //pauses execution until another thread calls notify using threadLock
			} catch (InterruptedException e) {
				System.out.println("error!");
			}
			
			System.out.println("Thread " + thread + " Line 4");
			threadLock.notify(); //let other threads waiting on threadLock know that they can start
		}
	}
}

