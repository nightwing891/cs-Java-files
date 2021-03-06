package lab2;

import javax.swing.JOptionPane;

public class DrawFigures {
	/**
     * Prints out a diamond, an X, and a rocket.
     */
	public static void topDiamond(){
		System.out.println("   /\\\n" + "  /  \\\n" + " /    \\" );
	}
	
	public static void bottomDiamond() {
		System.out.println(" \\    /\n" + "  \\  /\n" + "   \\/");
	}
	
	public static void square(){
		System.out.println("+------+\n" + "|      |\n" + "|      |\n" + "+------+");
	}
	
	public static void space(){
		System.out.println();
	}
	
	public static void nameOfRocket() {
		String rocketName = JOptionPane.showInputDialog("What do you wanna name the rocket?");
		if(rocketName.length() == 6){
			System.out.println("|"+ rocketName + "|");
		} else {
			nameOfRocket();
		}
	}
	
	public static void main (String[] args)
	{
		topDiamond();
		bottomDiamond();
		space();
		bottomDiamond();
		topDiamond();
		space();
		topDiamond();
		square();
		nameOfRocket();
		square();
		topDiamond();
	}
}
