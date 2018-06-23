package com.github.district22012;

/**
 * Travis Langston
 *
 * 6/22/2018
 * This program will determine the number of possiblle collisions given a hashcode and the number of letters in each word.
 * Implements the solution to Problem 6: Hash Codes of the UIL District 2 2012 Programming Competition.
 */
import java.io.*;
import java.util.*;
public class HashCodes
{
    public static void main(String[] args)
    {
        Scanner rdIn;
        try
        {
            rdIn = new Scanner(new File("com/github/district22012/hashcodes.dat"));
            int cases = rdIn.nextInt();
            for ( int i = 0; i < cases; i++ )
            {
                int wordSize, hashCode;
                wordSize = rdIn.nextInt();
                hashCode = rdIn.nextInt();
                System.out.println(findCollisions(wordSize, hashCode, 0));
            }
        }
        catch ( IOException e )
        {
            System.err.println("Error: " + e);
        }
    }

    private static int findCollisions(int wordSize, int hashCode, int prevLetter)
    {
        if ( wordSize == 0 )
            return hashCode == 0 ? 1 : 0;
        int collisions = 0;
        for ( int letter = prevLetter + 1; letter <= 26; letter++ )
        {
            collisions += findCollisions(wordSize - 1, hashCode - letter, letter);
        }
        return collisions;
    }
}
