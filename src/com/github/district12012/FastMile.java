package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/23/2017
 * This program will find each swimmer's fastest time. 
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class FastMile {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/fastmile.dat"));
			int sets = rdIn.nextInt();
			rdIn.nextLine();
			for ( int i = 0; i < sets; i++ )
			{
				String   times = rdIn.nextLine();
				String[] split = times.split("\\s");
				int      indx  = 1;
				for ( int k = 2; k < split.length; k++ )
				{
					int m1, m2, s1, s2, h1, h2;
					m1 = Integer.parseInt(split[indx].substring(0,2));
					m2 = Integer.parseInt(split[k].substring(0,2));
					s1 = Integer.parseInt(split[indx].substring(3,5));
					s2 = Integer.parseInt(split[k].substring(3,5));
					h1 = Integer.parseInt(split[indx].substring(6));
					h2 = Integer.parseInt(split[k].substring(6));
					if ( m1 > m2 || m1 == m2 && s1 > s2 || m1 == m2 && s1 == s2 && h1 > h2 )
					{
						indx = k;
					}
				}
				out.println(split[0] + " " + split[indx]);
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}

	}

}
