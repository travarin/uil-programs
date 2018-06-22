package com.github.district22012;
/*
 * Travis Langston
 * 
 * 11/20/2017
 * District 2 2012 Problem 1
 * This program will convert a binary clock to ordinary digital clock form. 
 */
import java.io.*;
import java.util.*;
public class Binary {

	public static void main(String[] args) {
		Scanner rdIn;
		try 
		{
			rdIn = new Scanner(new File("com/github/district22012/binary.dat"));
			int clocks = rdIn.nextInt();
			rdIn.nextLine();
			for ( int i = 0; i < clocks; i++ )
			{
				int[][] clock = new int[4][6];
				for ( int r = 0; r < 4; r++ )
				{
					String line  = rdIn.nextLine();
					for ( int c = 0; c < line.length(); c++ )
					{
						clock[r][c] = line.charAt(c) == '*' ? 1 : 0;
					}
				}
				String result = "";
				for ( int c = 0; c < 6; c++ )
				{
					String value = "";
					for ( int r = 0; r < 4; r++ )
					{
						value += String.valueOf(clock[r][c]);
					}
					result += binToDec(value);
				}
				System.out.println(result.substring(0,2) + ":" + result.substring(2,4) + ":" + result.substring(4));
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}
	}
	
	private static int binToDec(String value)
	{
		int result = 0; 
		int indx   = 0;
		int power  = 8;
		while ( indx < value.length() )
		{
			if ( value.charAt(indx) == '1' )
			{
				result += power;
			}
			power /= 2;
			indx++;
		}
		return result;
	}
	

}
