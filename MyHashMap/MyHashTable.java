package test;

import java.lang.reflect.GenericArrayType;

public class MyHashTable
{
    String[] hasharray;
	static final int INIT_TABLE_SIZE = 101;
	public int hashcollisions=0;
	private int currentSizeOfElements; 
	
	MyHashTable()
	{
		hasharray=new String[INIT_TABLE_SIZE];
		currentSizeOfElements=0;
	}	
	
	public void put(String x)
	{
		if(currentSizeOfElements++> hasharray.length / 2 )
			rehash();
		int idx=myhashFunction(x);
		if (hasharray[idx]!=null && hasharray[idx].equals(x))
		{
			currentSizeOfElements--;
			System.out.println("The element is already there and need not be  inserted: "+x);
		}	
		hasharray[idx]=x;
    }
	
	private int myhashFunction(String x )
	 {
		 int hashVal = hashFunction(x);			
	     int i=1;
	     
	     while (hasharray[hashVal] != null && !hasharray[hashVal].equals(x))
	     {    		
	    	 hashcollisions++; 
	    	 
	    	
	    	 i*=3;
	    	 hashVal+=i;
	    	 hashVal%=hasharray.length;	 
	     }		     

	     return hashVal;
	 }
	
	public boolean contains (String x )
	{
			if (hasharray[myhashFunction(x)]!=null)
				return true;
			else 
				return false;
	}

	public void rehash()
	{
		String [] oldarray=hasharray;
		int oldcurrentSize=currentSizeOfElements;
		
		hasharray=new String[nextPrime(2*hasharray.length)];
		for (String s: oldarray)
		{
			if (s!=null)
				put(s);
		}
		currentSizeOfElements=oldcurrentSize;
	}
	
	public int hashFunction(String input)
	{
		int n=7;
		StringBuilder sb= new StringBuilder(input);
		for(int i=0;i< sb.length();i++)
			n=37*n+(int)sb.charAt(i);
		
		n%=hasharray.length;
		if (n<0)
			n+=hasharray.length;

		return n;
	}
	
	
	 private static int nextPrime( int n )
	 {
	     if( n % 2 == 0 )
	         n++;

	     for( ; !checkforPrime( n ); n += 2 )
	         ;

	     return n;
	 }
	 
	 
	
	private static boolean checkforPrime( int number )
	 {
	     if( number == 2 || number == 3 )
	         return true;

	     if( number == 1 || number % 2 == 0 )
	         return false;

	     for( int i = 3; i * i <= number; i += 2 )
	         if( number % i == 0 )
	             return false;

	     return true;
	 }
	 


	 


	
	public String valueAt(int index)
	{
		return hasharray[index];
	}
	
	public int getCurrentSize()
	{
		return currentSizeOfElements;	
	}
}
