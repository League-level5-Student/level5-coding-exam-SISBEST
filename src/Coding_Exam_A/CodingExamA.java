package Coding_Exam_A;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		 String num = JOptionPane.showInputDialog("How many robots?");
		 String color = JOptionPane.showInputDialog("What color - Red, Blue, or Greeeeeeeeeeeeeeeeeeeeeeen?");
		 String sides = JOptionPane.showInputDialog("How many sides?");
		 int nums = Integer.parseInt(num);
		 Thread t = new Thread(()->{
			 Robot r = new Robot();
			 r.setWindowColor(Color.CYAN);
			 r.setWindowSize(1300, 900);
			 Color c;
			 switch(color.toUpperCase()) {
			 case "RED":
				 c = Color.RED;
				 break;
			 case "GREEN":
				 c = Color.GREEN;
				 break;
			 case "BLUE":
				 c = Color.BLUE;
				 break;
			 default:
				 c = Color.BLUE;
			 }
			 r.setPenColor(c);
			 r.penDown();
			 r.sparkle();
			 for(int i=0; i<Integer.parseInt(sides);i++) {
				r.setSpeed(62);
			 	r.move(40);
			 	r.turn(20);
			 }
			 r.penUp();
			 r.unSparkle();
		 }); 
		 for(int i=0;i<nums;i++) {
			 t.start();
			 t = new Thread(()->{
				 Robot r = new Robot();
				 Color c;
				 switch(color.toUpperCase()) {
				 case "RED":
					 c = Color.RED;
					 break;
				 case "GREEN":
					 c = Color.GREEN;
					 break;
				 case "BLUE":
					 c = Color.BLUE;
					 break;
				 default:
					 c = Color.CYAN;
				 }
				 r.setPenColor(c);
				 r.setSpeed(900);
				 r.turn(90);
				 Random rand = new Random();
				 boolean posneg = rand.nextBoolean();
				 if(posneg) {
					 r.move(rand.nextInt(900));
				 }
				 else {
					 r.move(-rand.nextInt(400));
				 }
				 r.penDown();
				 r.sparkle();
				 for(int j=0; j<Integer.parseInt(sides);j++) {
					r.setSpeed(1);
				 	r.move(40);
				 	r.turn(20);
				 }
				 r.penUp();
				 r.unSparkle();
			 });
			 
		 }
	}
}
