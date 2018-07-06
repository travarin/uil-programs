package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/23/2017
 * This program will determine which sections of the bus route have the fewest passengers on board. 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
public class Bus {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/bus.dat"));
			int sets = rdIn.nextInt();
			rdIn.nextLine();
			for ( int i = 0; i < sets; i++ )
			{
				String   moves    = rdIn.nextLine();
				String[] split    = moves.split("\\s");
				int[]	 sections = new int[split.length/2+1];
				int 	 indx     = 1;
				
				sections[0] = Integer.parseInt(split[0]);
				for ( int k = 1; k < split.length; k += 2 )
				{
					sections[indx] = sections[indx-1] + Integer.parseInt(split[k]) + Integer.parseInt(split[k+1]);
					indx++;
				}
				int min = Integer.MAX_VALUE;
				for ( int k = 0; k < sections.length; k++ )
				{
					if ( sections[k] < min )
					{
						min = sections[k];
					}
				}
				for ( int k = 0; k < sections.length; k++ )
				{
					if ( sections[k] == min )
					{
						out.print((char) (65 + k) + " ");
					}
				}
				out.print(min + "\n");
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}

	}

}
