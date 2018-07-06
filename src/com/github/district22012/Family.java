package com.github.district22012;
/*
 * Travis Langston
 * 
 * 12/2/2017
 * District 2 2012 Problem 5
 * This program will read in a picture in portrait layout, and rotate it 90 degrees to landscape.
 */
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class Family {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district22012/family.dat"));
			int pictures = rdIn.nextInt();
			for ( int i = 0; i < pictures; i++ )
			{
				char[][] pixels = new char[18][12];
				for ( int r = 0; r < 18; r++ )
				{
					String line = rdIn.next();
					for ( int c = 0; c < 12; c++ )
					{
						pixels[r][c] = line.charAt(c);
					}
				}
				
				for ( int c = 0; c < 12; c++ )
				{
					for ( int r = 17; r > -1; r-- )
					{
						System.out.print(pixels[r][c]);
					}
					System.out.println();
				}
				System.out.println();
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}

	}

}
