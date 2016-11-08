package test4;

import java.security.Principal;
import java.time.temporal.IsoFields;
import java.util.LinkedList;
import java.util.Queue;









//import test.BinarySearchTree.BinaryNode;

//import test.BinarySearchTree.BinaryNode;

//import test.BinarySearchTree.BinaryNode;

//BinarySearchTree class
//
//CONSTRUCTION: with no initializer
//
//******************PUBLIC OPERATIONS*********************
//void insert( x )       --> Insert x
//void remove( x )       --> Remove x
//boolean contains( x )  --> Return true if x is present
//Comparable findMin( )  --> Return smallest item
//Comparable findMax( )  --> Return largest item
//boolean isEmpty( )     --> Return true if empty; else false
//void makeEmpty( )      --> Remove all items
//void printTree( )      --> Print tree in sorted order
//******************ERRORS********************************
//Throws UnderflowException as appropriate

/**
* Implements an unbalanced binary search tree.
* Note that all "matching" is based on the compareTo method.
* @author Mark Allen Weiss
*/
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
 /**
  * Construct the tree.
  */
 public BinarySearchTree( )
 {
     root = null;
 }

 /**
  * Insert into the tree; duplicates are ignored.
  * @param x the item to insert.
  */
 public void insert( AnyType x )
 {
     root = insert( x, root );
 }

 /**
  * Remove from the tree. Nothing is done if x is not found.
  * @param x the item to remove.
  */
 public void remove( AnyType x )
 {
     root = remove( x, root );
 }

 /**
  * Find the smallest item in the tree.
  * @return smallest item or null if empty.
  */
 public AnyType findMin( )
 {
     if( isEmpty( ) )
         throw new UnderflowException( );
     return findMin( root ).element;
 }

 /**
  * Find the largest item in the tree.
  * @return the largest item of null if empty.
  */
 public AnyType findMax( )
 {
     if( isEmpty( ) )
         throw new UnderflowException( );
     return findMax( root ).element;
 }

 /**
  * Find an item in the tree.
  * @param x the item to search for.
  * @return true if not found.
  */
 public boolean contains( AnyType x )
 {
     return contains( x, root );
 }

 /**
  * Make the tree logically empty.
  */
 public void makeEmpty( )
 {
     root = null;
 }

 /**
  * Test if the tree is logically empty.
  * @return true if empty, false otherwise.
  */
 public boolean isEmpty( )
 {
     return root == null;
 }

 /**
  * Print the tree contents in sorted order.
  */
 public void printTree( )
 {
     if( isEmpty( ) )
         System.out.println( "Empty tree" );
     else
         printTree( root );
 }

 /**
  * Internal method to insert into a subtree.
  * @param x the item to insert.
  * @param t the node that roots the subtree.
  * @return the new root of the subtree.
  */
 private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
 {
     if( t == null )
         return new BinaryNode<>( x, null, null );
     
     int compareResult = x.compareTo( t.element );
         
     if( compareResult < 0 )
         t.left = insert( x, t.left );
     else if( compareResult > 0 )
         t.right = insert( x, t.right );
     else
         ;  // Duplicate; do nothing
     return t;
 }

 /**
  * Internal method to remove from a subtree.
  * @param x the item to remove.
  * @param t the node that roots the subtree.
  * @return the new root of the subtree.
  */
 private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
 {
     if( t == null )
         return t;   // Item not found; do nothing
         
     int compareResult = x.compareTo( t.element );
         
     if( compareResult < 0 )
         t.left = remove( x, t.left );
     else if( compareResult > 0 )
         t.right = remove( x, t.right );
     else if( t.left != null && t.right != null ) // Two children
     {
         t.element = findMin( t.right ).element;
         t.right = remove( t.element, t.right );
     }
     else
         t = ( t.left != null ) ? t.left : t.right;
     return t;
 }

 /**
  * Internal method to find the smallest item in a subtree.
  * @param t the node that roots the subtree.
  * @return node containing the smallest item.
  */
 private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
 {
     if( t == null )
         return null;
     else if( t.left == null )
         return t;
     return findMin( t.left );
 }

 /**
  * Internal method to find the largest item in a subtree.
  * @param t the node that roots the subtree.
  * @return node containing the largest item.
  */
 private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
 {
     if( t != null )
         while( t.right != null )
             t = t.right;

     return t;
 }

 /**
  * Internal method to find an item in a subtree.
  * @param x is item to search for.
  * @param t the node that roots the subtree.
  * @return node containing the matched item.
  */
 private boolean contains( AnyType x, BinaryNode<AnyType> t )
 {
     if( t == null )
         return false;
         
     int compareResult = x.compareTo( t.element );
         
     if( compareResult < 0 )
         return contains( x, t.left );
     else if( compareResult > 0 )
         return contains( x, t.right );
     else
         return true;    // Match
 }

 /**
  * Internal method to print a subtree in sorted order.
  * @param t the node that roots the subtree.
  */
 private void printTree( BinaryNode<AnyType> t )
 {
     if( t != null )
     {
    	  
    	
    	 System.out.print( t.element + " ->");
    	   printTree( t.left );
    	 printTree( t.right );
     }
 }

 /**
  * Internal method to compute height of a subtree.
  * @param t the node that roots the subtree.
  */
 private int height( BinaryNode<AnyType> t )
 {
     if( t == null )
         return -1;
     else
         return 1 + Math.max( height( t.left ), height( t.right ) );    
 }
 
 
 
 
 private int nodeCount(BinaryNode<AnyType> root){

	 if(root==null){       // base case where the node is null
		 return 0;
	 }
	 else{
		 return 1 + nodeCount(root.left) + nodeCount(root.right); // adds 1 to the count each time you encounter a new element
	 } 
	  
 }

 
 
 private boolean isFull(BinaryNode<AnyType> rootNode){
		boolean flag;
		if(rootNode==null){
			return true;
		}
		 if(rootNode.left ==null && rootNode.right ==null){
		
			 return true; // for the leave node the condition both the childs are null
		 }
		 
		
		 if( (rootNode.left !=null && rootNode.right !=null))
				 return (isFull(rootNode.left) && isFull(rootNode.right));
		 // Check for both the nodes to be not null and check if there are two childs for the same.
		return false;
	 }

 
 

 private boolean compareStructure(BinaryNode<AnyType>firstNode,BinaryNode<AnyType>secondNode){
	 
	 if(firstNode == null && secondNode == null){
		 return true;
	 }
	 
	 if(firstNode!= null && secondNode !=null){
		 return (compareStructure(firstNode.left, secondNode.left) && compareStructure(firstNode.right, secondNode.right)); // Just comparing if the elements exist in the desired fashion. 
	 }
	 else{
		 return false;
	 }
	 
	 
	 
	 
 }
 
 
 
 
 private boolean equals(BinaryNode<AnyType>firstNode,BinaryNode<AnyType>secondNode){
	 
	 if(firstNode == null && secondNode == null){
		 return true;
	 }
	 
	 if((firstNode != null && secondNode != null) && (firstNode.element ==secondNode.element)){
		 
		 
		 return (equals(firstNode.left, secondNode.left) && equals(firstNode.right, secondNode.right));
	 }
	 else{
		 return false;
	 }
	 
 }
 
 
 
 boolean isMirror(BinaryNode<AnyType> treeNode1, BinaryNode<AnyType> treeNode2) 
 {
     
     if (treeNode1 == null && treeNode2 == null)
         return true;

     
     if (treeNode1 == null || treeNode2 == null) 
         return false;

    
     return( (treeNode1.element == treeNode2.element)
             && isMirror(treeNode1.left, treeNode2.right)
             && isMirror(treeNode1.right, treeNode2.left));
 }
 

 
 public BinarySearchTree copy()
 {
   BinarySearchTree nodetree= new BinarySearchTree(); 
   nodetree.root=copy(nodetree.root,this.root);
   return nodetree; 
 }
 
 private BinaryNode<AnyType> copy(BinaryNode<AnyType> node1, BinaryNode<AnyType> node2)
 {
   if (node2!=null)
   {
      node1=new BinaryNode<>(node2.element,node2.left,node2.right);
      node1.left=copy(node1.left,node2.left);
      node1.right=copy(node1.right,node2.right);
   }
   return node1;
 }
 
 
 
 public BinaryNode<AnyType> mirror(BinaryNode<AnyType> test) {
		
     BinaryNode<AnyType> dummynode = test;
     
 
	 
	 if (test != null) {
			mirror(test.left);
			mirror(test.right);
			
			if (test.left != null && test.right != null) {
				BinaryNode<AnyType> temp = test.left;
				dummynode.left = test.right;
				dummynode.right = temp;
			}

			else if (test.left != null && test.right == null) {
				dummynode.right = test.left;
				dummynode.left = null;
			}

			else if (test.right != null && test.left == null) {
				dummynode.left = test.right;
				dummynode.right = null;
			}
			
		}
	return dummynode;

	}

 
 
 public void RotateLeft(AnyType element) {
		
	 if(contains(element)){
		 root = RL(root, element);}
      
	 else{
		 System.out.println("RotateLeft Exception: The element "+element+" isn't found in the tree");

	 }
 }
	 
	public BinaryNode<AnyType> RL(BinaryNode<AnyType> t, AnyType ele) throws NullPointerException{
		try
		{
		if (t == null) {
			return t;
		}
		if (t.element.equals(ele)) {
			BinaryNode<AnyType> piv = t.right;
			t.right = piv.left; 
			piv.left = t; 
			t = piv; 
		} else {
			t.left = RL(t.left, ele);
			t.right = RL(t.right, ele);
		}
		}catch(NullPointerException e){
			System.out.println("The Rotate Left operation is not possible for the element "+ele);
		}
		return t;
		
	}
 
 
 

	 public void rotateRight(AnyType element){
		 if(contains(element)){
			 root = RR(root, element);}
	      
		 else{
			 System.out.println("RotateRight Exception: The element "+element+" isn't found in the tree");

		 }
	 
	 }
	 
	 
	 
	 private void printLevels() 
	 {
	     Queue<BinaryNode<AnyType>> queuenode = new LinkedList<BinaryNode<AnyType>>();
	     queuenode.add(root);
	     while (!queuenode.isEmpty()) 
	     {
	
	         
	         BinaryNode<AnyType> tempNode = queuenode.poll();
	         System.out.print(tempNode.element + " ");
                     	
	        
	         if (tempNode.left != null) {
	             queuenode.add(tempNode.left);
	         }
	
	       
	         if (tempNode.right != null) {
	             queuenode.add(tempNode.right);
	         }
	         System.out.println();
	     }
	 }
	 
 
	 
	 
	 private BinaryNode<AnyType> RR(BinaryNode<AnyType> root2, AnyType element) {
		// TODO Auto-generated method stub
		
		 
		 try{
				if (root2 == null) {
					return root2;
				}
				if (root2.element.equals(element)) {
					BinaryNode<AnyType> piv = root2.left; 
					root2.left = piv.right; 
					piv.right = root2; 
					root2 = piv; 
				} else {
					root2.left = RR(root2.left, element); //recursion steps
					root2.right = RR(root2.right, element); 
				}
				}catch(NullPointerException e)
				{
					
					System.out.println("The Rotate Right operation is not possible for the element "+element);
				}
		
		 	return root2;
				

		 
		 
		 
		 
		 
		
	}
	 
 
 // Basic node stored in unbalanced binary search trees
 private static class BinaryNode<AnyType>
 {
         // Constructors
     BinaryNode( AnyType theElement )
     {
         this( theElement, null, null );
     }

     BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
     {
         element  = theElement;
         left     = lt;
         right    = rt;
     }

     AnyType element;            // The data in the node
     BinaryNode<AnyType> left;   // Left child
     BinaryNode<AnyType> right;  // Right child
 }


   /** The tree root. */
 private BinaryNode<AnyType> root;


     // Test program
 public static void main( String [ ] args )
 {
     BinarySearchTree<Integer> testBinaryTree = new BinarySearchTree<>( );
     BinarySearchTree<Integer> testBinaryTree2 = new BinarySearchTree<>( );
     BinarySearchTree<Integer> testBinaryTree3 = new BinarySearchTree<>( );
     BinarySearchTree<Integer> testBinaryTree4 = new BinarySearchTree<>( );
     final int NUMS = 4000;
     final int GAP  =   37;
     int nodeCount;
     boolean compareStructure, compareEqual;
     
     BinaryNode<Integer> mirrorTest,rightRotateTest,leftRotateTest;
     
     testBinaryTree.insert(10);
     testBinaryTree.insert(8);
     testBinaryTree.insert(12);
     testBinaryTree.insert(7);
     testBinaryTree.insert(9);
     testBinaryTree.insert(11);
     testBinaryTree.insert(13);
     
     
     
     testBinaryTree2.insert(11);
     testBinaryTree2.insert(9);
     testBinaryTree2.insert(13);
     testBinaryTree2.insert(8);
     testBinaryTree2.insert(10);
     testBinaryTree2.insert(12);
     testBinaryTree2.insert(14);
     

     testBinaryTree3.insert(10);
     testBinaryTree3.insert(8);
     testBinaryTree3.insert(12);
     testBinaryTree3.insert(7);
     testBinaryTree3.insert(9);
     testBinaryTree3.insert(11);
     testBinaryTree3.insert(13);
     
     
    // System.out.println( "Checking... (no more output means success)" );

    System.out.println("Printing  the tree of the testBinaryTree");
      testBinaryTree.printTree();
      System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
      
     nodeCount = testBinaryTree.nodeCount(testBinaryTree.root);
     System.out.println();
     System.out.println("Node Count of the testBinaryTree: is " + nodeCount);     
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     System.out.println("The given tree (testBinaryTree) is full:" +  testBinaryTree.isFull(testBinaryTree.root));
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     compareStructure = testBinaryTree.compareStructure(testBinaryTree.root, testBinaryTree2.root);
     System.out.println("The two trees testBinaryTree and testBinaryTree2 structure is same:" + compareStructure);
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     
     compareEqual = testBinaryTree.equals(testBinaryTree.root, testBinaryTree3.root);
     System.out.println("The two trees testBinaryTree and testBinaryTree3 are equal:" + compareEqual);
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     compareEqual = testBinaryTree.equals(testBinaryTree.root, testBinaryTree2.root);
     System.out.println("The two trees testBinaryTree and testBinaryTree2 are equal:" + compareEqual);
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     System.out.println("Printing the newly COPIED testBinaryTree4 from TestBinarytree");
     testBinaryTree.printTree((testBinaryTree.copy(testBinaryTree4.root, testBinaryTree.root )));
     System.out.println();
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     System.out.println("The pre-order printing of the testBinaryTree before mirror:");
     testBinaryTree.printTree();
     System.out.println();
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     System.out.println("The pre-order printing of the testBinaryTree after the  mirror method is applied:");
     mirrorTest = testBinaryTree.mirror(testBinaryTree.root);
     testBinaryTree.printTree(mirrorTest);
     System.out.println();
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     
     System.out.println("ismirror");
    System.out.println( "TestBinaryTree3 and its mirror image tree are checked if they are mirrors to each other:"+testBinaryTree3.isMirror(testBinaryTree3.root, mirrorTest));
    System.out.println();
    System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
    
    
    System.out.println("The pre-order printing of the testBinaryTree3 after the  right rotation:");
     System.out.println();
     System.out.println("Rotate right at node with value 8 ");
     testBinaryTree3.rotateRight(8);
     testBinaryTree3.printTree();
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------");  
     
     
     System.out.println("The pre-order printing of the testBinaryTree3 after the  right rotation:");
     System.out.println(); 
     System.out.println("Rotate right at node with value 10 ");
     testBinaryTree3.rotateRight(10);
     testBinaryTree3.printTree();
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     
     System.out.println("The pre-order printing of the testBinaryTree3 after the  left rotation:");
     System.out.println();
     System.out.println("Rotate left at node with value 10 ");
     testBinaryTree3.RotateLeft(10);
     testBinaryTree3.printTree();
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     System.out.println("The pre-order printing of the testBinaryTree3 after the  left rotation:");
     System.out.println();
     System.out.println("Rotate left at node with value 7 ");
     testBinaryTree3.RotateLeft(7);
     testBinaryTree3.printTree();
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     System.out.println();
     System.out.println("The print levelsof testBinarytree3 ");
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     
     testBinaryTree3.printLevels();
     
     
     System.out.println();
     System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
     
     
     
     
     
     
     /*for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
         t.insert( i );

     for( int i = 1; i < NUMS; i+= 2 )
         t.remove( i );

     if( NUMS < 40 )
         t.printTree( );*/
     if( testBinaryTree.findMin( ) != 2 || testBinaryTree.findMax( ) != NUMS - 2 )
      //   System.out.println( "FindMin or FindMax error!" );

     for( int i = 2; i < NUMS; i+=2 )
          if( !testBinaryTree.contains( i ) ){}
       //       System.out.println( "Find error1!" );

     for( int i = 1; i < NUMS; i+=2 )
     {
         if( testBinaryTree.contains( i ) ){}
          //   System.out.println( "Find error2!" );
     }
 }
}