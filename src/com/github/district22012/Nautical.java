package com.github.district22012;

/**
 * Travis Langston
 *
 * 7/5/2018
 * District 2 2012 Problem 9
 * This program will read in a list of distances a ship has traveled in nautical miles,
 * and convert them to English miles. (1 nautical mile = 1.15 English miles)
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Nautical
{
    public static void main(String[] args)
    {
        Scanner rdIn;
        try
        {
            rdIn = new Scanner(new File("com/github/district22012/nautical.dat"));
            int distances = rdIn.nextInt();
            for ( int i = 0; i < distances; i++ )
            {
                double distance, english;
                distance = rdIn.nextInt();
                english  = distance * 1.15;
                System.out.printf("%.1f\n", english);
            }
            rdIn.close();
        }
        catch ( IOException e )
        {
            System.err.println("Error: " + e);
        }
    }
}
