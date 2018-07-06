package com.github.district12012;
/*
 * Travis Langston
 * 
 * 9/3/2017
 * This program will print out how many acres are available in each unfilled lot. 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;
public class Prospectors {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/prospectors.dat"));
			int sets = rdIn.nextInt();
			for ( int i = 0; i < sets; i++ )
			{
				char[][]   		   grid    = new char[8][16];
				boolean[][]        counted = new boolean[8][16];
				ArrayList<Integer> lots    = new ArrayList<Integer>();
				
				rdIn.nextLine();
				for ( int k = 0; k < 8; k++ )
				{
					String row = rdIn.nextLine();
					for ( int j = 0; j < 16; j++ )
					{
						grid[k][j] = row.charAt(j);
					}
				}
				
				for ( int k = 0; k < 8; k++ )
				{
					for ( int j = 0; j < 16; j++ )
					{
						if ( grid[k][j] == '*' && !counted[k][j])
						{
							lots.add(count(grid,counted, k, j));
						}
					}
				}
				
				Collections.sort(lots);
				for ( int k = lots.size()-1; k >= 0; k-- )
				{
					out.print(lots.get(k) + " ");
				}
				out.println();
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}
	}
	
	public static int count(char[][] grid, boolean[][] counted, int row, int col)
	{
		counted[row][col] = true;
		if ( grid[row][col] != '*' )
		{
			return 0;
		}
		else
		{
			int result = 0; 
			if ( row - 1 > -1 && !counted[row-1][col] )
			{
				result += count(grid, counted, row-1, col);
			}
			if ( row + 1 < 8 && !counted[row+1][col] )
			{
				result += count(grid, counted, row+1, col);
			}
			if ( col - 1 > -1 && !counted[row][col-1] )
			{
				result += count(grid, counted, row, col-1);
			}
			if ( col + 1 < 16 && !counted[row][col+1] )
			{
				result += count(grid, counted, row, col+1);
			}
			return result + 5;
		}
	}

}
