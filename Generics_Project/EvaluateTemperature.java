package com.firstassignment;

import java.util.Scanner;

public class EvaluateTemperature {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		String tempType = scan.nextLine();
		int tempF ;
		if(tempType.indexOf("F") > 0){
			tempF = temp;
		}
		else{
			tempF = (9* temp)/5 + 32;	
			System.out.println(tempF);
		}
		
	    if(tempF < 0){
			System.out.println("Extremely cold");
			
		}
	    if(tempF >=0 & tempF <= 32){
			System.out.println("Very cold");
			
		}
	    if(tempF >=33 & tempF <=50){
			System.out.println("Cold");
			
		}
	    if(tempF >=51 & tempF <= 70){
			System.out.println("Mild");
			
		}
	    if(tempF >=71 & tempF <=90){
			System.out.println("Warm");
			
		}
	    if(tempF >=91 & tempF <=100){
			System.out.println("Hot");
			
		}if(tempF > 100){
			System.out.println("Very hot");
			
		}
	    
	    
	    
	}

}
