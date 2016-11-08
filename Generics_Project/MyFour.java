package com.firstassignment;

	 
	public class MyFour<T> implements Comparable<MyFour>{
		  
		 T param1;
		private T param2;
		private T param3;
		private T param4;
		
		
		MyFour(T t1, T t2, T t3, T t4){ 
			  param1 = t1;
			  param2 = t2;
			  param3=  t3;
			  param4=  t4;
			  
		}

		public boolean allEqual(MyFour<T> t){
			if(t.equals(param1, param2, param3, param4) == 1){
				return true;
			}
			else{
				return false;
			}
		}
		
		public int equals(T test1,T test2,T test3, T test4){
			if(test1.equals(test2) & test2.equals(test3)& test3.equals(test4) & test4.equals(test1) ){
				return 1;
			}
			else{
				return 0;
			}
		}
		public void shiftLeft(MyFour<T> shiftleft){
		
				param1 = shiftleft.param2;
			  param2 = shiftleft.param3;
			  param3=  shiftleft.param4;
			  param4=  shiftleft.param1;
		}		
		public int compareTo(MyFour arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public String toString(){
			String s = "Value of input1 is "  + param1 +  " and Value of input2 is " + param2 + " and Value of input3 is " + param3 + " and Value of input4 is " + param4 + "value of ";
			System.out.println(s);
			//return null;
			return null;
			
		}
		
		public static void main(String []args){
		MyFour<String> fS = new MyFour<String>("teja", "teja", "teja", "teja") ;
		System.out.println(fS.allEqual(fS));
		fS.toString();
		MyFour<Integer> fI = new MyFour<Integer>(1,2,3,4) ;
		System.out.println(fI.allEqual(fI));
		}
	}
