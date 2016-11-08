package com.firstassignment;

public class Square {

	/**
	 * @param args
	 */

	private int length;
	public Square(){
		this.length = 1;
	}
	
	public Square(int sideLength){
		this.length = sideLength;
	}


	public int getArea(){
		return(length * length);
	}
	
}