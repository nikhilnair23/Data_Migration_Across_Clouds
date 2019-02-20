package com.user;

import java.math.BigInteger;
import java.util.Random;

public class RandomValue {
	
	               /*Random Value Generation*/
	
		

	public static String  AESKeyValue()
	{
		
		String values[] = new String[] { "123abc45222aes55","678abc91123abc45","222aes55999sea77","999sea77888lll55","888lll55222aes55","444ccc45449jjj45","333kkk45999sea77","449jjj45444ccc45"};
		
		Random random = new Random();
		
		int num=random.nextInt(values.length);
		//int n=random(values);
		//int m=random(values);
		//System.out.println("Ramdom Position Of Array :" +num +" Ramdom Array Value Of prime  : "+values[num]);
		return values[num];
		
	}
	
}
