/**
 * Institution: Bellevue College
 * Course: Fundamentals of Computer Science II
 * Quarter: Summer 2026
 * Student name: Paul Hoang
 * Program description: Skyscraper puzzle
 */


import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;



/**
 * Reads in configurations of potential solutions to Skyscraper puzzles and
 * evaluates their validity before printing out both the grids and their status
 * as an answer to the puzzles.
 *
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Paul Hoang <paul.hoang@bellevuecollege.edu>
 * @version _____1_____
 */
public class Skyscraper
{
	/**
	 * The driver method to process Skyscraper puzzle settings
	 * The task is to check their validity and then print the grids along with the results of those checks.
	 *
	 * @param theArgs is used for command line input.
	 */
	public static void main(final String[] theArgs) throws FileNotFoundException
	{
		if (theArgs.length != 1)
		{
			System.out.println("ERROR: Program must be run using the name of an input file that "
					+ "contains skyscraper information as a command line argument.");
		}
		else
		{
			// START FILLING YOUR CODE HERE
			File file = new File(theArgs[0]);
			Scanner input = new Scanner(file);
			
			while (input.hasNextInt()) {
				
				int[][] grid = getSkyscrapers(input);
				boolean answer = validateSkyscrapers(grid);
				printSkyscrapers(grid, answer);
				
			}
			// END FILLING YOUR CODE HERE
			input.close();

			System.out.println("COMPLETED PROCESSING SKYSCRAPERS");
		}
	}
	
	/** 
	 * Initialized data from the file into a 6x6 array structure with 0 at each corners. 
	 * 
	 * @param input   is the series of integer input from the file 
	 * 
	 * @return A 6x6 array with proper format for validation
	 * 
	 */
	public static int[][] getSkyscrapers(Scanner input) {
		// Make a new 6x6 array
		int[][] grid = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				// print 0 at the corners
				if ((i == 0 || i == 5) && (j == 0 || j == 5)) {
					grid[i][j] = 0;
				} else {
					int number = input.nextInt();
					grid[i][j] = number;
				}
			}
		} return grid;
	}
	
	
	
	/** 
	 * This method validate the entire grid by checking each row and column 
	 * to match the visibility clue given by the grid
	 * 
	 * @param grid	is 6x6 array representing the grid of the skyscraper puzzle
	 * @return true if all of both row and column are valid, else return false
	 * 
	 */
	
	
	public static boolean validateSkyscrapers(int[][] grid) {
		
		// Go through the row
			// Extract a line from each row of the grid
			for (int i = 1; i < 5; i++) {
				int[] rowLine = grid[i];
				// Validate the result
				if (!validateLine(rowLine)) {
					return false;
				}
			}
	
		
		// Go through the column
			// Extract a line from each column of the grid
			for (int j = 1; j < 5; j++)  {
				int[] colLine = new int[6];
				
				for (int i = 0; i < 6; i++) {
					colLine[i] = grid[i][j];
				}
				
				if (!validateLine(colLine)) {
						return false;
				}
			}
		
		
		// Return the result
			return true;
		
	}

	/**
	 * Method is used to expand validateSkyscrapers method. This method check the number of 
	 * buildings that is visible looking at the array of building in two direction. Then 
	 * check whether they match with the clue provided by the grid on both front and end 
	 * of the buildings array. 
	 * 
	 * 
	 * @param line		is the line of a puzzle grid that contains the visibility clue 
	 * 					from two side, and the array of building height in the middle
	 * @return 			return a boolean that tell whether if the visibility clue match 
	 * 					with the actual visibility counted by the method
	 * 
	 */
	
	private static boolean validateLine(int[] line) {
		
		// Checking for duplication	
		boolean[] seen = new boolean[5];

		for (int i = 1; i < 5; i++) {
			if (line[i] < 1 || line [i] > 4) {
				return false;
			}
			if (seen[line[i]]) {
				return false;
			} 
			
			seen[line[i]] = true;

		}
			
		
		// Visibility check
		int front = line[0];
		int back = line[5];
		
			// Front to back
			int visibility = 0;
			int tallest = 0;
			
			for (int j = 1; j < 5; j++) {
				if (line[j] > tallest) {
					visibility++;
					tallest = line[j];
					}
			} 
			if (visibility != front) {
				return false;
			}
			
		
			// Back to front
			visibility = 0;
			tallest = 0;
			
			for (int k = 4; k > 0; k--) {
				if (line[k] > tallest) {
					visibility++;
	 				tallest = line[k];
	 			}
			}
			if (visibility != back) {
				return false;
			}
		
		// Return result if all pass
			return true; 
	}

	
	
	
	
	/**
	 * Prints the Skyscraper puzzle configuration and whether it is valid or not as
	 * a solution.
	 *
	 * @param theGrid     is a 2D integer array representing a configuration of
	 *                    integers as a potential answer to a Skyscraper puzzle.
	 * @param theValidity is a boolean value representing whether the 2D integer
	 *                    array is an acceptable solution or not.
	 */
	public static void printSkyscrapers(final int[][] theGrid, final boolean theValidity)
	{
		final StringBuilder sb = new StringBuilder();
		for (int row = 0; row < theGrid.length; row++)
		{
			for (int col = 0; col < theGrid[0].length; col++)
			{
				if (theGrid[row][col] == 0)
				{
					sb.append(" ");
				}
				else
				{
					sb.append(theGrid[row][col]);
				}
			}
			sb.append("\n");
		}
		if (theValidity)
		{
			sb.append("VALID");
		}
		else
		{
			sb.append("NOT VALID");
		}
		System.out.println(sb.toString());
	}
	
	
	
	
	
	
	
	
}