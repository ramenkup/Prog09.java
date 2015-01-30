import java.util.ArrayList;
import java.util.Stack;
/*+----------------------------------------------------------------------
||
||  Class:	myStack.java	
||
||  Author:	Spencer Klinge
||
||        Purpose: the functional characteristics of a Stack ADT are emulated by this
					class all while importing ArrayList. ArrayList has all the necessary methods
					to make writing a Stack ADT fairly easy.
||
||  Inherits From: N/A
||
||     Interfaces: N/A
|+-----------------------------------------------------------------------
||
||      Constants: N/A
|+-----------------------------------------------------------------------
||
||   Constructors:  public myStack()- constructs the global arraylist(list) variable
					representitive of the stack.
					
||  Class Methods: public void pushLocation(location)
					public location popLocation(location)
					public location peek()
					public boolean isEmpty()
||
||  Inst. Methods:  ArrayList <location> list- the list representation of the stack
||
++-----------------------------------------------------------------------*/

class myStack{
	ArrayList <location> list;
    /*---------------------------------------------------------------------
    |  Method: myStack()
    |
    |  Purpose:  Constructs a myStack() object which intializes its own local arrayList
    |
    |  Pre-condition: N/A
    |
    |  Post-condition: N/A
    |
    |  Parameters: N/A
    |
    |  Returns:  N/A
    *-------------------------------------------------------------------*/


	public myStack(){
	list= new ArrayList<location>();
	}
    /*---------------------------------------------------------------------
    |  Method: pushLocation(location)
    |
    |  Purpose: Using the ArrayList method .add, this method emulates the behavior
    			of a stack by only allowing elements to be "added" to the very top of
    			the stack, thus pushing down all other elements
    			
    |  Pre-condition: location temp is a valid location.
    |
    |  Post-condition: list.length() will be +1 and temp will be found at list.get(0)
    |
    |  Parameters: location temp- the object to be pushed onto the stack.
    |
    |  Returns: void
    *-------------------------------------------------------------------*/


	public void pushLocation(location temp){
		list.add(0,temp);
	}
    /*---------------------------------------------------------------------
    |  Method: popLocation()
    |
    |  Purpose: Another stack method emulated by ArrayList. the method always
    			calls .remove at the 0th element, in order to be properly "popped"
    			off.
    |  Pre-condition: location temp is a valid location object
    |
    |  Post-condition: myStack.length() will be  minus 1
    |
    |  Parameters: N/A
    |
    |  Returns:  void
    *-------------------------------------------------------------------*/


	public location popLocation(){
		return (location) list.remove(0);
	}
    /*---------------------------------------------------------------------
    |  Method: public location Peek()
    |
    |  Purpose: Looks at the top of the stack, and returns the object at the top
    			by calling list.get(0)
    |			
    |  Pre-condition: stack is not empty.
    |
    |  Post-condition: N/A
    |
    |  Parameters: N/A
    |
    |  Returns: Returns the location object at the top of the stack
    *-------------------------------------------------------------------*/


	public location peek(){
		return (location) list.get(0);
	}
    /*---------------------------------------------------------------------
    |  Method: isEmpty()
    |
    |  Purpose: calls the isEmpty() method of ArrayList. this method acts exactly the same as
    	ArrayLists isEmpty().
    |
    |  Pre-condition:	N/A
    |
    |  Post-condition:	N/A
    |
    |  Parameters:
    |
    |  Returns:  returns the location at the top of the stack.
    *-------------------------------------------------------------------*/


	public boolean isEmpty(){
		return list.isEmpty();
	}
	

	
	
	
	

}//myStack Class
