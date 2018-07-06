package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/21/2017
 * This program will print out the sub-products and final product from a multiplication problem.
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
public class Multiplication {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/multiplication.dat"));
			int problems = rdIn.nextInt();
			for ( int i = 0; i < problems; i++ )
			{
				int    r       = rdIn.nextInt();
				long   product = 0;
				String s       = rdIn.next();
				for ( int k = 1; k <= s.length(); k++ )
				{
					long temp, sub;
					temp = Integer.parseInt(s.substring(s.length()-k, s.length()-k+1));
					sub  = r * temp;
					out.print(sub + " ");
					product += sub * (int) Math.pow(10, k-1);
				}
				out.print(product + "\n");
			}
			rdIn.close();
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}

	}

}
