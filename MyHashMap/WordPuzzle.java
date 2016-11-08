package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class WordPuzzle {
    
	
	static PrintWriter outFile1,outFile2,outFile3,outFile4;

	char[][] grid; 
	
	FileWriter writer;
	
	void	WordPuzzle(int m, int n ) throws IOException{
		
		
		try 
		{
			 outFile1 = new PrintWriter("words_LL.txt");
			 outFile2 = new PrintWriter("words_trees.txt");
			 outFile3 = new PrintWriter("words_myHash.txt");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		grid = new char[m][n]; 
					for (int i=0;i <m;i++){
				for (int j=0;j <n;j++){
				Random r = new Random();
				
				
				 grid[i][j] = (char) (r.nextInt(26) + 'a');
			
			}
			
			}
		}
			
	
	 public void printGrid(char input[][]){
		 for (int i=0;i < input.length;i++){
				for (int j=0;j <input[i].length;j++){
					System.out.print((grid[i][j]));
				}
				System.out.println();
			
				
		 }
	 }
	 
	 
	 public void searchGridUsingObject(String searchinput, Object ds){
		 if(ds instanceof LinkedList<?>){
			    searchLinkedListImpl(searchinput,(LinkedList<String>)ds);
			
		 }
		 else if (ds instanceof AvlTree<?>){
				searchTreeImpl(searchinput,(AvlTree<String>)ds);
		
		 }
		 else if (ds instanceof MyHashTable){
				searchMyHashImpl(searchinput,(MyHashTable)ds);
		
		 }
		
	 }
	 
	 
	 public void searchInAllDirections(char[][] gridinput, Object object){

		 	for (int i=0;i <gridinput.length;i++){
				for (int j=0;j <gridinput[i].length;j++){
							StringBuilder sbhorizontalforward = new StringBuilder("");
							StringBuilder sbhorizontalbackward = new StringBuilder();
							StringBuilder sbverticalupward = new StringBuilder();
							StringBuilder sbverticaldownward = new StringBuilder();
							StringBuilder sb45 = new StringBuilder();
							StringBuilder sb135 = new StringBuilder();
							StringBuilder sb215 = new StringBuilder();
							StringBuilder sb315 = new StringBuilder();
						
							
							
								for (int l=j;l <gridinput[i].length;l++){
									
									sbhorizontalforward = sbhorizontalforward.append(grid[i][l]);
									searchGridUsingObject(sbhorizontalforward.toString(),object);
									
								}
							
								for (int l=j;l >=0;l--){
									sbhorizontalbackward = sbhorizontalbackward.append(grid[i][l]);
									searchGridUsingObject(sbhorizontalbackward.toString(),object);
								}
							
							
					
							
							for (int k=i;k <gridinput.length;k++){
								sbverticaldownward = sbverticaldownward.append(grid[k][j]);
								searchGridUsingObject(sbverticaldownward.toString(),object);
								
								}
							
							
						
								for (int k=i;k >=0;k--){
										sbverticalupward = sbverticalupward.append(grid[k][j]);
										searchGridUsingObject(sbverticalupward.toString(),object);
								}
							
							
							
							for (int k=i-1,l=j+1; k>=0 && l<grid[i].length ;k--,l++){
										sb45 = sb45.append(grid[k][l]);
										searchGridUsingObject(sb45.toString(),object);
										
								
								}
							
							for (int k=i+1,l=j+1; k< grid.length && l< grid[i].length ;k++,l++){
										sb315 = sb315.append(grid[k][l]);	
										searchGridUsingObject(sb315.toString(),object);
							}
							
							for (int k=i-1,l=j-1; k>=0 && l>=0 ;k--,l--){
									sb135 = sb135.append(grid[k][l]);
									searchGridUsingObject(sb135.toString(),object);
							}
		
							for (int k=i+1,l=j-1; k < grid.length && l >=0  ;k++,l--){
								sb215 = sb215.append(grid[k][l]);
								searchGridUsingObject(sb215.toString(),object);
								
							}
				}
			}
	}
	 
	 
	private void searchLinkedListImpl(String searchinput, LinkedList<String> ds) {
		
		if(ds.contains(searchinput)){
			outFile1.println(searchinput);
		}
		
	}
	
	
	private void searchTreeImpl(String searchinput, AvlTree<String> ds) {
		if(ds.contains(searchinput)){
			
			outFile2.println(searchinput);
		}
	}


	private void searchMyHashImpl(String searchinput, MyHashTable ds) {
		if(ds.contains(searchinput)){
			outFile3.println(searchinput);
		}
	}
	
	

	
	

	public static void main(String[] args) throws IOException{
		System.out.println("Enter the number of rows:");
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		System.out.println("Enter the number of columns:");
		int n = s. nextInt();
		WordPuzzle wz = new WordPuzzle();
		wz.WordPuzzle(m,n);
		
	
		MyLinkedList<String> list = new MyLinkedList<>();
		LinkedList<String> linkedlist = new LinkedList<>();
		AvlTree<String> avl = new AvlTree<>();
	 	MyHashTable myhs = new MyHashTable();
		
		
		String word=null;
		BufferedReader f = new BufferedReader(new FileReader("dictionary.txt"));

		while((word=f.readLine())!=null){
			myhs.put(word);
		
			avl.insert(word);

			linkedlist.add(word);
	
		}
		
		System.out.println("Avl starting...");	
		
		long startavl = System.currentTimeMillis();
		wz.searchInAllDirections(wz.grid,avl);
		long endavl = System.currentTimeMillis();
		System.out.println("Time taken for the avl tree to run is :" + (endavl - startavl));
	
		long starthmap = System.currentTimeMillis();
		wz.searchInAllDirections(wz.grid,myhs);
		long endhmap = System.currentTimeMillis();
		System.out.println("Time taken for the hashmap to run is :" + (endhmap - starthmap));
		
		System.out.println("Linkedlist starting...");	
		long startll = System.currentTimeMillis();
		wz.searchInAllDirections(wz.grid,linkedlist);
		long endll = System.currentTimeMillis();
		System.out.println("Time taken for linkedlist tree to run is :" + (endll - startll));
		
		outFile1.close();
		outFile2.close();
		outFile3.close();
	
	}
	}




































