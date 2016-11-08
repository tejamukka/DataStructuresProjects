package secondassignment;

/**
 * LinkedList class implements a doubly-linked list.
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType>
{
    /**
     * Construct an empty LinkedList.
     */
    public MyLinkedList( )
    {
        doClear( );
    }
    
    private void clear( )
    {
        doClear( );
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void doClear( )
    {
        beginMarker = new Node<>( null, null, null );
        endMarker = new Node<>( null, beginMarker, null );
        beginMarker.next = endMarker;
        
        theSize = 0;
        modCount++;
    }
    
    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize;
    }
    
    public boolean isEmpty( )
    {
        return size( ) == 0;
    }
    
    /**
     * Adds an item to this collection, at the end.
     * @param x any object.
     * @return true.
     */
    public boolean add( AnyType x )
    {
        add( size( ), x );   
        return true;         
    }
    
    /**
     * Adds an item to this collection, at specified position.
     * Items at or after that position are slid one position higher.
     * @param x any object.
     * @param idx position to add at.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */
    public void add( int idx, AnyType x )
    {
        addBefore( getNode( idx, 0, size( ) ), x );
    }
    
    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     * @param p Node to add before.
     * @param x any object.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size(), inclusive.
     */    
    private void addBefore( Node<AnyType> p, AnyType x )
    {
        Node<AnyType> newNode = new Node<>( x, p.prev, p );
        newNode.prev.next = newNode;
        p.prev = newNode;         
        theSize++;
        modCount++;
    }   
    
    
    /**
     * Returns the item at position idx.
     * @param idx the index to search in.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType get( int idx )
    {
        return getNode( idx ).data;
    }
        
    /**
     * Changes the item at position idx.
     * @param idx the index to change.
     * @param newVal the new value.
     * @return the old value.
     * @throws IndexOutOfBoundsException if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal )
    {
        Node<AnyType> p = getNode( idx );
        AnyType oldVal = p.data;
        
        p.data = newVal;   
        return oldVal;
    }
    
    /**
     * Gets the Node at position idx, which must range from 0 to size( ) - 1.
     * @param idx index to search at.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size( ) - 1, inclusive.
     */
    private Node<AnyType> getNode( int idx )
    {
        return getNode( idx, 0, size( ) - 1 );
    }

    /**
     * Gets the Node at position idx, which must range from lower to upper.
     * @param idx index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between lower and upper, inclusive.
     */    
    private Node<AnyType> getNode( int idx, int lower, int upper )
    {
        Node<AnyType> p;
        
        if( idx < lower || idx > upper )
            throw new IndexOutOfBoundsException( "getNode index: " + idx + "; size: " + size( ) );
            
        if( idx < size( ) / 2 )
        {
            p = beginMarker.next;
            for( int i = 0; i < idx; i++ )
                p = p.next;            
        }
        else
        {
            p = endMarker;
            for( int i = size( ); i > idx; i-- )
                p = p.prev;
        } 
        
        return p;
    }
    
    /**
     * Removes an item from this collection.
     * @param idx the index of the object.
     * @return the item was removed from the collection.
     */
    public AnyType remove( int idx )
    {
        return remove( getNode( idx ) );
    }
    
    /**
     * Removes the object contained in Node p.
     * @param p the Node containing the object.
     * @return the item was removed from the collection.
     */
    private AnyType remove( Node<AnyType> p )
    {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        
        return p.data;
    }
    
    /**
     * Returns a String representation of this collection.
     */
    public String toString( )
    {
        StringBuilder sb = new StringBuilder( "[ " );

        for( AnyType x : this )
            sb.append( x + " " );
        sb.append( "]" );

        return new String( sb );
    }

    /**
     * Obtains an Iterator object used to traverse the collection.
     * @return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator( )
    {
        return new LinkedListIterator( );
    }

    /**
     * This is the implementation of the LinkedListIterator.
     * It maintains a notion of a current position and of
     * course the implicit reference to the MyLinkedList.
     */
    private class LinkedListIterator implements java.util.Iterator<AnyType>
    {
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        
        public boolean hasNext( )
        {
            return current != endMarker;
        }
        
        public AnyType next( )
        {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            if( !hasNext( ) )
                throw new java.util.NoSuchElementException( ); 
                   
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }
        
        public void remove( )
        {
            if( modCount != expectedModCount )
                throw new java.util.ConcurrentModificationException( );
            if( !okToRemove )
                throw new IllegalStateException( );
                
            MyLinkedList.this.remove( current.prev );
            expectedModCount++;
            okToRemove = false;       
        }
    }
	

	
	public void insertList(MyLinkedList<AnyType> list2,int startNode){
	   	if(startNode < size()){
	   	
	   	for(int i =0; i < list2.size();i++){
	   	add(startNode +i, list2.get(i));
	   
	   	}
	   	}
	   	}
	   
	   public void swap(int index1,int index2){
		   	
		   	Node<AnyType> node1 = getNode(index1);
		   	Node<AnyType> node2 = getNode(index2);
		   	Node<AnyType> temp1,temp2,temp3,temp4;
		   	
		   	
		   	if(index1-index2 == -1 ){
		   	
		   	 temp3 = node2.next;
		   	 node1.prev.next = node1.next;
		   	 node2.prev = node1.prev;
		   	 node2.next = node1;
		   	 node1.prev = node2;
		   	 node1.next = temp3;
		   	 temp3.prev = node1;
		   	
		   	}
		   	else if (index1 == index2){
		   		System.out.println("These cannot be swapper as both are pointing to the same node");
		   	}
		   	
		   	else if (index1-index2 ==1 ){
		   		swap(index2,index1);
		   	}
		   	
		   		else{
		   	temp1 = node1.prev;
		 
		   	temp4 = node1.next;
		   	

		   	node2.prev.next = node1;
		   	node2.next.prev = node1;
		   	node1.prev = node2.prev;
		   	node1.next = node2.next;
		   	
		   	
		   	node2.prev = temp1;
		   	node2.next = temp4;
			temp1.next = node2;
		   	temp4.prev = node2;
		
		   		}
		   	 }
		   

	   
	    public void shift(int n)
	    {
	    if(n>0)
	    {
	    	for(int i = 1;i<=n;i++){
	    
	    		Node<AnyType> bmleftshift , emleftshift ;
	        bmleftshift = beginMarker.next;
		   	emleftshift = endMarker.prev;
		   	
		   	bmleftshift.next.prev = beginMarker;
		   	beginMarker.next = bmleftshift.next;
		   	emleftshift.next = bmleftshift;
		   	bmleftshift.prev = emleftshift;
		   	bmleftshift.next = endMarker;
		   	endMarker.prev=bmleftshift;
	    	}
	    }
	    else  {
	    	
	    	for(int i = n; i<0; i++)
	    
	    		{
				Node<AnyType> bmrightshift , emrightshift ;   

				bmrightshift = beginMarker.next;
				emrightshift = endMarker.prev;
				endMarker.prev = emrightshift.prev;
				emrightshift.prev.next = endMarker;
				emrightshift.prev = beginMarker;
				emrightshift.next = bmrightshift;
				beginMarker.next = emrightshift;
				bmrightshift.prev = emrightshift;
	    }
	    }
	    }
	    
		   
		public void erase(int startnode, int num_of_nodesdel){
		   	
			int lastnodetodel = startnode + num_of_nodesdel;
			
			if(startnode < 0 || startnode >=size() || lastnodetodel > size() || lastnodetodel <0){
				throw new IndexOutOfBoundsException( "getNode index: " + lastnodetodel + "; size: " + size( ) );
			}
			
		   	 Node start = getNode(startnode);
		   	 Node end = getNode((startnode + num_of_nodesdel) -1);
		   	 
		   	 start.prev.next = end.next;
		   	 end.next.prev = start.prev;
		   	
		   	
		   }
	   
	   
	   
	  private static class Node<AnyType>
    {
        public Node( AnyType d, Node<AnyType> p, Node<AnyType> n )
        {
            data = d; prev = p; next = n;
        }
        
        public AnyType data;
        public Node<AnyType>   prev;
        public Node<AnyType>   next;
    }
    
	    private int theSize;
	    private int modCount = 0;
	    private Node<AnyType> beginMarker;
	    private Node<AnyType> endMarker;
		}



class TestLinkedList
{
    public static void main( String [ ] args)
    {
        MyLinkedList<Integer> lst = new MyLinkedList<>( );

        for( int i = 0; i < 10; i++ )
                lst.add( i );

        MyLinkedList<Integer> lst2 = new MyLinkedList<>( );

        for( int i = 1; i < 10; i++ )
                lst2.add( 200*i );
        System.out.println(lst);
        lst.swap(2, 8);
        System.out.println(lst + "swapped elem 2 and 8");
        
        lst.swap(6, 9);
        System.out.println(lst + "swapped elem 6 and 9");
       
        lst.shift(2);
        System.out.println(lst +"shifted +2 times");
        

        lst.shift(-4);
        System.out.println(lst + "shifted -4 times");
        
        lst.insertList(lst2,3);
        System.out.println(lst +"inserted lst2 starting from index = 3");
        
        lst.insertList(lst2,7);
        System.out.println(lst + "inserted lst2 starting from index = 7");
        
        lst.erase(5,3);
        System.out.println(lst+"erased elements from index =5 and 3 elem from that index");
        
        lst.erase(2,9);
        System.out.println(lst +"erased elements from index =2 and 9 elems from that index");


    }
}

