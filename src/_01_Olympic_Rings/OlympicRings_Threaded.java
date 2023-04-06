package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;
public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot timmy = new Robot(400, 300);
		Robot tammy = new Robot(500, 300);
		Robot sammy = new Robot(600, 300);
		Robot r = new Robot(450,400);
		Robot b = new Robot(550,400);
		
		timmy.setSpeed(10);
		tammy.setSpeed(10);
		sammy.setSpeed(10);
		r.setSpeed(10);
		b.setSpeed(10);
		timmy.penDown();
		tammy.penDown();
		sammy.penDown();
		r.penDown();
		b.penDown();
		
		Thread r1 = new Thread(()->run(timmy));
		Thread r2 = new Thread(()->run(tammy));
		Thread r3 = new Thread(()->run(sammy));
		Thread r4 = new Thread(()->run(r));
		Thread r5 = new Thread(()->run(b));
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		
		
		
		/*timmy.move(400);
		tammy.move(400);
		sammy.move(400);
		
		timmy.moveTo(400, 700);
		tammy.moveTo(800, 700);
		sammy.moveTo(1200, 700);
		
		Thread r1 = new Thread(()->timmy.move(400));
		Thread r2 = new Thread(()->tammy.move(400));
		Thread r3 = new Thread(()->sammy.move(400));
		
		r1.start();
		r2.start();
		r3.start();*/
	}
	public static void run(Robot r) {
		for(int i = 0; i < 72; i++) {
			r.move(8);
			r.turn(5);
		}
		r.hide();
	}
}

