package com.tes;

public class Test {
	
	public static void main(String[] args)
	{
		
		int i = 1, j = 10; 
		do 
		{
		    if(i > j) 
		    {
		        break; 
		    } 
		    j--; 
		} while (++i < 5); 
		System.out.println("i = " + i + " and j = " + j);
		
		int i1 = 1, j1 = -1; 
		
		switch (i1) 
		{
		    case 0: j1 = 1;  
		    case 1: j1 = 1; 
		    case 2: j1 = 2; 
		    default: j1 = 0; 
		} 
		System.out.println("j = " + j); 
		//System.out.println( "Hello" + args[0] ); 
	}

}
