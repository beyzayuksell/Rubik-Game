/**
 * @Author : BEYZA YÜKSEL 
**/
package com.rubik;

import java.awt.Color;

public class Rubik {

	Color[] colors = new Color[5];
	Color[] currentColors = new Color[4];

	public Rubik() {
		StdDraw.setCanvasSize(500, 500);
		colors[0] = Color.MAGENTA;  //  Different colors assign to color array.
		colors[1] = Color.YELLOW;
		colors[2] = Color.CYAN;
		colors[3] = Color.GREEN;
		colors[4] = Color.BLUE;

		// Pick random 4 colors with the method you have written
		for (int i = 0; i < 4; i++) {
			currentColors[i] = randomColor();
		}

		// Change the currentColors array accordingly with these colors
		// Set the colors for filling the squares and call the filledSquare method
		StdDraw.setPenColor(currentColors[0]);
		StdDraw.filledSquare(0.25, 0.75, 0.25); // 1. square, Parameters takes between 0 and 1.

		StdDraw.setPenColor(currentColors[1]);
		StdDraw.filledSquare(0.75, 0.75, 0.25); // 2. square

		StdDraw.setPenColor(currentColors[2]);
		StdDraw.filledSquare(0.25, 0.25, 0.25); // 3. square

		StdDraw.setPenColor(currentColors[3]);
		StdDraw.filledSquare(0.75, 0.25, 0.25); // 4. square

	}
	// Randomly chooses and returns a Color from your colors[] array

	public Color randomColor() {
		return colors[(int) (Math.random() * 5)]; // return color index 0,1,2,3,4.
	}

	/*
	 * Note to me.. Generate random number between 0 to 20 int a = Math.random() *
	 * 20;
	 */
	// Returns true if all 4 squares have the same color, otherwise false
	public boolean match(Color rand1, Color rand2, Color rand3, Color rand4) {
		if (rand2 == rand1 && rand3 == rand1 && rand4 == rand1 || 
			rand1 == rand2 && rand3 == rand2 && rand4 == rand2 || 
			rand1 == rand3 && rand2 == rand3 && rand4 == rand3)
			return true;
		return false;
	}

	// Implements the game mechanism, while all squares do not have the same color
	// lets the user press squares to change their colors.
	// When all the squares have matching colors displays a text that says “You
	// won!”
	public void play() {
		while (match(currentColors[0], currentColors[1], currentColors[2], currentColors[3]) == false) {
			if (StdDraw.isMousePressed()) { 
				changeColor(whichSquare(mouseLocation())); // functions calls...
				StdDraw.pause(50);   // I pause for 50 miliseconds so that the color change is slow when the mouse is clicked.
			}
			
		}
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.5, "You won!");
	}

	// Returns a double array which contains x and y coordinates of the mouse
	// location.
	public double[] mouseLocation() {
		double x = StdDraw.mouseX();
		double y = StdDraw.mouseY();
		double[] mLoc = new double[] { x, y };
		return mLoc;
	}

	// Finds and returns the square which the mouse location resides in
	public int whichSquare(double[] mouseLoc) {
		if (mouseLoc[0] >= 0 && mouseLoc[0] <= 0.5 && mouseLoc[1] >= 0.5 && mouseLoc[1] <= 1) // if the 1st square contains the coordinates (x, y).
			return 1;
		else if (mouseLoc[0] >= 0.5 && mouseLoc[0] <= 1 && mouseLoc[1] >= 0.5 && mouseLoc[1] <= 1) // 2.square
			return 2;
		else if (mouseLoc[0] >= 0 && mouseLoc[0] <= 0.5 && mouseLoc[1] >= 0 && mouseLoc[1] <= 0.5) // 3.square
			return 3;
		return 4;

	}

	// Takes the square which the user has clicked and changes the color of that
	// square randomly
	public void changeColor(int whichSquare) {
		Color rand = randomColor();
		if (whichSquare == 1) {         // 1. square
			StdDraw.setPenColor(rand);
			StdDraw.filledSquare(0.25, 0.75, 0.25);
			currentColors[0] = rand;   // Update my current color.
			
		} else if (whichSquare == 2) {  // 2. square
			StdDraw.setPenColor(rand);
			StdDraw.filledSquare(0.75, 0.75, 0.25);
			currentColors[1] = rand;

		} else if (whichSquare == 3) { // 3. square
			StdDraw.setPenColor(rand);
			StdDraw.filledSquare(0.25, 0.25, 0.25);
			currentColors[2] = rand;
			
		} else if (whichSquare == 4) { // 4. square
			StdDraw.setPenColor(rand);
			StdDraw.filledSquare(0.75, 0.25, 0.25);
			currentColors[3] = rand;
		}
		StdDraw.show();
	}
	
	// Main method should exactly be this
	public static void main(String[] args) {
		Rubik r = new Rubik();
		r.play();
	}
}
