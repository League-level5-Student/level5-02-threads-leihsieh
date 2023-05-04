package _05_Synchronized_Swimming;

/*
 * Synchronization is a mechanism which ensures that two concurrent processes (threads)
 * do not simultaneously execute some particular program segment. When one thread wants
 * to execute the synchronized code, a lock (also known as a "mutex") must be acquired.
 * If another thread wishes to acquire the same lock, it must wait for the other thread
 * to release the lock first. This is most commonly used to make sure two threads can't
 * read from or write to the same variables/objects at the same time.
 *
 * Challenge: Two swimmers want to swim in the same pool at the same time. However, the
 * pool is not big enough for both of them. These are world-class swimmers, and it only
 * takes them 2 seconds to complete a lap! They have agreed to each take turns swimming
 * one lap at a time. Your job is to make sure they follow the rules.
 */
public class SynchronizedSwimming {
	private static final Object swimmingPool = new Object();

	public static void main(String[] args) {
		Swimmer a = new Swimmer("John");
		Swimmer b = new Swimmer("Sally");
		a.start();
		b.start();
	}

	/*
	 * Refactor this method using a synchronized block to ensure a lock must be held on
	 * the swimmingPool object until the swimmer has finished their lap.
	 */
	private static void swimLap(Swimmer swimmer) throws InterruptedException {
		synchronized(swimmingPool) {
			System.out.println(swimmer.name + " started a lap!");
			Thread.sleep(2000);
			System.out.println(swimmer.name + " finished!");
		}
	}

	public static void takeTurn(Swimmer swimmer) {
		try {
			swimLap(swimmer);
			Thread.sleep(100);
		} catch (InterruptedException ignore) {
		}
	}
}
