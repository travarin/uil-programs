package com.github.district22012;

/**
 * Travis Langston
 *
 * 7/2/2018
 * District 2 2012 Problem 7
 * This program will determine if two strings are both interlocked in the third string:
 * every character in each string appears in order in the third string, but not necessarily consecutively.
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Interlocked
{
    public static void main(String[] args)
    {
        Scanner rdIn;
        try
        {
            rdIn = new Scanner(new File("com/github/district22012/interlocked.dat"));
            int cases = rdIn.nextInt();
            for ( int i = 0; i < cases; i++ )
            {
                String word1, word2, interlocked;
                word1       = rdIn.next();
                word2       = rdIn.next();
                interlocked = rdIn.next();
                if ( checkInterlocked(word1, word2, interlocked))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            rdIn.close();
        }
        catch ( IOException e )
        {
            System.err.println("Error: " + e);
        }
    }

    private static boolean checkInterlocked(String word1, String word2, String interlocked)
    {
        int indx1, indx2;
        indx1 = 0;
        indx2 = 0;
        for ( int i = 0; i < interlocked.length(); i++ )
        {
            if ( indx1 < word1.length() && word1.charAt(indx1) == interlocked.charAt(i))
                indx1++;
            if ( indx2 < word2.length() && word2.charAt(indx2) == interlocked.charAt(i))
                indx2++;
        }
        return indx1 == word1.length() && indx2 == word2.length();
    }
}
