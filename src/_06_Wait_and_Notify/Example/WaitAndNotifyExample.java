package _06_Wait_and_Notify.Example;

public class WaitAndNotifyExample {
	/*
		 Run the code below. How is the output? You'll most likely notice that 
		 the first thread finishes printing all of its statements before the 
		 second thread prints its first statement.
		 
		 Now, change s1 and s2 to take in new SynchedThreadPrinter objects instead 
		 of ThreadPrinter. How has the output changed?
		 
		 Take a look at the SynchedThreadPrinter class to observe how synchronized, 
		 wait, and notify are all used to control the order of the print statements
		 even though they are run from different threads.
		 
		 Ask your teacher for more clarification if needed.
	 
	 */
	
	
	public static void main(String[] args) {
		Thread s1 = new Thread(new ThreadPrinter());
		Thread s2 = new Thread(new ThreadPrinter());
		
		s1.start();
		s2.start();
		
		try {
			s1.join();
			s2.join();
		} catch (InterruptedException e) {
			System.out.println("Could not join threads");
		}
	}
}
