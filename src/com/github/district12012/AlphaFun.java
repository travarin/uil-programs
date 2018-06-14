package com.github.district12012;
/*
 * Travis Langston
 * 
 * 8/23/2017
 * This program will sort a list of words in AlphaFun order. 
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class AlphaFun {

	public static void main(String[] args) {
		Scanner rdIn;
		try
		{
			rdIn = new Scanner(new File("com/github/district12012/alphafun.dat"));
			TreeMap<String, ArrayList<String>> words = new TreeMap<String, ArrayList<String>>();
			while ( rdIn.hasNext() )
			{
				String word     = rdIn.next();
				String alphaFun = word.substring(1,2);
				if ( word.length() > 3 )
				{
					alphaFun += word.substring(3,4);
				}
				else
				{
					alphaFun += " ";
				}
				alphaFun += (word.substring(word.length()-1) + word.substring(0,1));
				if ( !words.containsKey(alphaFun) )
				{
					words.put(alphaFun, new ArrayList<String>());
					words.get(alphaFun).add(word);
				}
				else
				{
					ArrayList<String> temp = words.get(alphaFun);
					temp.add(word);
					Collections.sort(temp);					
				}
			}
			
			Set<String>       keys = words.keySet();
			Iterator<String>  it   = keys.iterator();
			ArrayList<String> temp;
			while ( it.hasNext() )
			{
				temp = words.get(it.next());
				for ( int i = 0; i < temp.size(); i++ )
				{
					out.println(temp.get(i));
				}
			}
		}
		catch ( IOException e )
		{
			System.err.println("Error: " + e );
		}

	}

}
