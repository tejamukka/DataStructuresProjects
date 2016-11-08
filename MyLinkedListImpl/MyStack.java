package secondassignment;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.xml.internal.stream.Entity.ScannedEntity;

public class MyStack {

	ArrayList<Character>   list1 = new ArrayList<>();
	
		boolean flag = true;
		boolean stackfull = false;
	
		public void push(char i){
			list1.add(i);
		}
		
		
		public void pop(){
			list1.remove(list1.size()-1);
		}
		
		public boolean IsStackEmpty(){
			if(list1.isEmpty())
				stackfull = true;
			else
				stackfull = false;
			
				return stackfull;
		
		}
		
		public char top(){
			return list1.get(list1.size()-1);
		}
		
		
		
		public void MyStack(String input){
			
			//ArrayList<Character>   list1 = new ArrayList<>();
			
			
			
			for(int i = 0; i < input.length();i++){
				
		
				//String input1 =  "[}";
				if(input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(')
				
					push(input.charAt(i));
				//	list1.add(input.charAt(i));
				
				else if (input.charAt(i) == '}')
				{
					if(list1.isEmpty()){
						flag = false;
						System.out.println("The input given is not balanced  symbol ");
					}
					//else if(list1.get(list1.size()-1) == '{'){
					else if(top() == '{'){
						pop();
						//list1.remove(list1.size()-1);
					}
					else{
						System.out.println("The input given is not balanced  symbol ");
						flag = false;
					}
				}
				
				else if (input.charAt(i) == ')')
				{
					if(list1.isEmpty()){
						flag = false;
						System.out.println("The input given is not balanced  symbol ");
					}
					
					//else if(list1.get(list1.size()-1) == '('){
					else if(top() == '('){	
					//list1.remove(list1.size()-1);
						pop();
					}
					else{
						flag = false;
						System.out.println("The input given is not balanced  symbol ");

					}
				}
				else if (input.charAt(i) == ']')
				{
					
					if(list1.isEmpty()){
						flag = false;
						System.out.println("The input given is not balanced  symbol ");
					}
					
					//else if(list1.get(list1.size()-1) == '['){
						//list1.remove(list1.size()-1);
					else if(top() == '['){	
					pop();
					}
					else{
						flag = false;
						System.out.println("The input given is not balanced  symbol ");

					}
				}
				else{
					if(!IsStackEmpty()){
						System.out.println("The input given is not balanced  symbol ");
					}
						
				
					}
				
				
			}
			if(list1.size() == 0 && flag == true){
				System.out.println("The list is balanced ");
			}
			else if(!IsStackEmpty()){
					System.out.println("The input given is not balanced  symbol ");
				}
		
			
		}
		
					
				
		
		
		
		public static void main(String[] args) {
		
			MyStack my = new MyStack();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the symbol to check if it is balanced.");
			String input = sc.nextLine();
			my.MyStack(input);
					
		}

}
