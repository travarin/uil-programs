package com.github.district22012;
/*
 * Travis Langston
 * 
 * 12/1/2017
 * District 2 2012 Problem 3
 * This program will determine how many different ways an amount of money can be paid 
 * using pennies, nickels, dimes, quarters, and half-dollars.
 */
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class Change {

	private static int[] coins  = {50, 25, 10, 5, 1};
	
	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district22012/change.dat"));
			int sets = rdIn.nextInt();
			for ( int i = 0; i < sets; i++ )
			{
				int amount = rdIn.nextInt();
				System.out.println(findChange(amount, 0));
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}
	}
	
	private static int findChange(int tgt, int index)
	{
		if ( tgt == 0 )
			return 1;
		else if ( tgt < 0 )
			return 0;
		else 
		{
			int result = 0;
			for ( int i = index; i < coins.length; i++ )
			{
				result += findChange(tgt - coins[i], i);
			}
			return result;
		}
	}

}
