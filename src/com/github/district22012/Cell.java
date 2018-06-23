package com.github.district22012;
/**
 * Travis Langston
 * 
 * 11/30/2017
 * District 2 2012 Problem 2
 * This program will read in the number of minutes and seconds from phone calls over the past month,
 * and calculate how many minutes you will be charged for under two different plans. 
 */
import java.util.*;
import java.io.*;
public class Cell {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("UIL Programs/src/com/github/district22012/cell.dat"));
			int planA = 0;
			int planB = 0;
			while ( rdIn.hasNext() )
			{
				String line = rdIn.next();
				double minutes = Double.parseDouble(line);
				planA += (int) Math.floor(minutes);
				planB += (int) Math.ceil(minutes);
			}
			System.out.println("PLAN A: " + planA );
			System.out.println("PLAN B: " + planB );
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}

	}

}
