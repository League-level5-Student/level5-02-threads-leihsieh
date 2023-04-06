package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable{
	int val;
	
	public ThreadedGreeter(int v) {
		val = v;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: " + val);
		if (val<50) {
			Thread n = new Thread(new ThreadedGreeter(val+1));
			n.start();
			try {
				n.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
