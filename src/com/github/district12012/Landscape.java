package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/21/2017
 * This program will rotate pictures from landscape to portrait mode.
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Landscape {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/landscape.dat"));
			int pictures = rdIn.nextInt();
			for ( int i = 0; i < pictures; i++ )
			{
				rdIn.nextLine();
				String[][] picture = new String[10][15];
				for ( int k = 0; k < 10; k++ )
				{
					String row = rdIn.nextLine();
					for ( int j = 0; j < 15; j++ )
					{
						picture[k][j] = row.substring(j,j+1);
					}
				}
				
				for ( int k = 14; k > -1; k-- )
				{
					for ( int j = 0; j < 10; j++ )
					{
						out.print(picture[j][k]);
					}
					out.println();
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

}
