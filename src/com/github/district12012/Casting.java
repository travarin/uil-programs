package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/28/2017
 * This program will cast out the nines in an integer and report the degree of that cast. 
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
public class Casting {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/casting.dat"));
			int sets = rdIn.nextInt();
			for ( int i = 0; i < sets; i++ )
			{
				String num = rdIn.next();
				out.println(cast(num, true));
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}
		
	}
	
	public static int cast(String num, boolean first)
	{
		int result = 0;
		for ( int i = 0; i < num.length(); i++ )
		{
			result += Integer.parseInt(num.substring(i,i+1));
		}
		if ( result < 10 )
		{
			return first ? 0 : 1;
		}
		else
		{
			return cast(String.valueOf(result), false) + 1;
		}
	}

}
