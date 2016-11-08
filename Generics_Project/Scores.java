package com.firstassignment;

import java.util.Scanner;

public class Scores {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] studentName = new String[10];
		int[][] marksArray = new int[10][5];
		for(int i = 0; i < 10; i ++ ){
			studentName[i] = scan.next();
			for(int j = 0; j < 5; j ++ ){
				marksArray[i][j] = scan.nextInt();
			}
		}
		
		for(int k = 0; k < 10; k ++ ){
		int sumk = marksArray[k][0] + marksArray[k][1] + marksArray[k][2] + marksArray[k][3] + marksArray[k][4];
		float avgk = sumk /5 ;	
			System.out.println("student name is :" + studentName[k] + "  average score is :  " +avgk );
			
		}
		
		
	
	}

}
