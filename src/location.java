/*+----------------------------------------------------------------------
 ||
 ||  Class location.java 
 ||
 ||         Author:	Spencer Klinge
 ||
 ||        Purpose:	hanles all coordinate reitrival methods for each of the location objects
 					stored in myStack. each location object represents a Y and X on the 2d array.
 					For this classes constructor, the Y variable was set to the first argument in order
 					to be consistant with ArrayList's arguement orientation.
 ||
 ||  Inherits From: N/A
 ||
 ||     Interfaces:  N/A
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants: N/A
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  public location(int,int)
 
 ||  Class Methods:	N/A
 ||
 ||  Inst. Methods: int getX(), int getY(), void setX(int), void setY(int)
 ++-----------------------------------------------------------------------*/

public class location {
		int x;
		int y;
		
	       /*---------------------------------------------------------------------
        |  Method:	location(int,int)
        |
        |  Purpose:  sets the x and y variables for a new initialized location object.
        |
        |  Pre-condition:N/a
        |
        |  Post-condition:N/A
        |
        |  Parameters: int a- y variable, int b- x variable
        |
        |  Returns: N/A Constructor.
        *-------------------------------------------------------------------*/


		public location(int a, int b){
		y=a;
		x=b;
		}
		
		public int getX(){
		return x;
		}
		
		public int getY(){
		return y;
		}
		public void setX(int p){
		x=p;
		}
		
		public void setY(int q){
		y=q;
		}
		
		
	
}
