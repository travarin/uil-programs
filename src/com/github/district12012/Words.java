package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/21/2017
 * This program will take a person's Facebook name 
 * and shorten it into their Words with Friends name.
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class Words {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/words.dat"));
			int names = rdIn.nextInt();
			rdIn.nextLine();
			for ( int i = 0; i < names; i++ )
			{
				String name = rdIn.nextLine();
				String[] split = name.split("\\s");
				out.print(split[0]);
				for ( int k = 1; k < split.length; k++ )
				{
					out.print(" " + split[k].charAt(0));
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
