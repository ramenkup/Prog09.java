import java.util.ArrayList;
import java.util.Stack;
/*+----------------------------------------------------------------------
||
||  Class:	maze.java
||
||         Author:  Spencer Klinge
||
||        Purpose:  Handles the operations of the corn array along with is visual represention.
					it handles algorithm that transfers the r by c stack into the 2*r+1, 2*c+1
					graphic representaion
||  Inherits From:  N/A
||
||     Interfaces:  N/A
|+-----------------------------------------------------------------------
||
||      Constants:  N/A
|+-----------------------------------------------------------------------
||
||   Constructors:  maze(int,int)
||
||  Class Methods:	N/A
||
||  Inst. Methods:	public location createStart(),	public void createMaze(),
					public void selectStart(),	public void selectEnd(),
					public void printMaze()
||
++-----------------------------------------------------------------------*/

public class maze {
boolean[][] corn;
myStack path;
boolean[][] twoDee;

/*---------------------------------------------------------------------
|  Method: Maze(int,int)
|
|  Purpose: this method initializes the stack along with the cornfield, the internal
			representation of the path, and the graphicall representaion of r and c 
			by the formulate 2r+1 and 2c+1 in array twoDee. this method then iterates through all the spaces
			and sets them all to true
			
|  Pre-condition: N/A
|
|  Post-condition: a new Maze object will take up a place in memory.
|
|  Parameters: int r= number of rows, int c= number of columns
|
|  Returns: constructor, does not return
*-------------------------------------------------------------------*/


public maze(int r, int c){
	path= new myStack();
	corn= new boolean[r][c];
	for(int i=0; i< corn.length;i++){
		for(int n=0; n<corn[0].length;n++){
			corn[i][n]=true;
		}
	}
	twoDee= new boolean[2*r+1][2*c+1];
	for(int i=0; i< twoDee.length;i++){
		for(int n=0; n<twoDee[0].length;n++){
		//corn[i][n]=true;	
			twoDee[i][n]=true;
		}
	}
	
}
/*---------------------------------------------------------------------
|  Method:	createStart()
|
|  Purpose:  randomly goes through corn using Math.random()
|
|  Pre-condition: corn has been initalized.
|
|  Post-condition: the found location on the corn becomes false.
|
|  Parameters: N/A
|
|  Returns: the Starting location(not the entrance)
*-------------------------------------------------------------------*/


public location createStart(){
	int n= (int)(Math.random()* corn.length);
	int i= (int) (Math.random()* corn[0].length);//any random point
	corn[n][i]=false;
	return new location(n,i);
}

/*---------------------------------------------------------------------
|  Method: void createMaze()
|
|  Purpose: this method begins its maze creation by by first calling the
			create start method. next, all possible moves from this location
			are loaded into the arrayList randoList, and this an element from this
			array is randomly selected to be the next move on the path stack. once the
			path has been completly plotted and all locations have been set to false, the barrirs
			between each location that are found in the twoDee array are also set to false.
|  Pre-condition: path has been initailized
|
|  Post-condition: Both twoDee with be pathed to represent the mase.
|  Parameters: N/A
|  Returns:  void
*-------------------------------------------------------------------*/


public void createMaze(){
	path.pushLocation(createStart());
	ArrayList <location> randoList= new  ArrayList<location>();
	location rando;
	while(!path.isEmpty()){
		location temp= path.peek();
		if(temp.getY()-1 >= 0 && corn[temp.getY()-1][temp.getX()] == true){
			rando= new location(temp.getY()-1, temp.getX());
			randoList.add(rando);
			
		}//up if
		if(temp.getX()+1 < corn[0].length && corn[temp.getY()][temp.getX()+1] == true){
			rando= new location(temp.getY(), temp.getX()+1);
			randoList.add(rando);
		}//right if
		
		if(temp.getY()+1 < corn.length && corn[temp.getY()+1][temp.getX()] == true){
			rando= new location(temp.getY()+1, temp.getX());
			randoList.add(rando);
		}//down in
		
		if(temp.getX()-1 >= 0 && corn[temp.getY()][temp.getX()-1] == true){
			rando= new location(temp.getY(), temp.getX()-1);
			randoList.add(rando);
		}
		if(!(randoList.size() > 0)){
			path.popLocation();
		}//pop if
		else{
			int randoInt= (int)(Math.random() * randoList.size());
			location selection= randoList.get(randoInt);
			path.pushLocation(selection);
			corn[selection.getY()][selection.getX()]=false;
			twoDee[(selection.getY()*2)+1][(selection.getX()*2)+1]=false;
			if(temp.getX() == selection.getX() && temp.getY()== selection.getY()+1){
				twoDee[((2*selection.getY())+2)][(2*selection.getX())+1]=false;//SWITCHED Y AND X FOR ALL OF THESE RE CHECK LOGIC
			}
			if(temp.getX() == selection.getX()-1 && temp.getY()== selection.getY()){
				twoDee[(2*selection.getY())+1][(2*selection.getX())]=false;//SWITCHED Y AND X FOR ALL OF THESE RE CHECK LOGIC

			}
			if(temp.getX()== selection.getX() && temp.getY()== selection.getY()-1){
				twoDee[(2*selection.getY())][(2*selection.getX())+1]=false;//SWITCHED Y AND X FOR ALL OF THESE RE CHECK LOGIC

			}
			if(temp.getX()== selection.getX()+1 && temp.getY() == selection.getY()){
				twoDee[(2*selection.getY())+1][(2*selection.getX()+2)]=false;//SWITCHED Y AND X FOR ALL OF THESE RE CHECK LOGIC

			}

		}
		randoList= new  ArrayList<location>();
	}//while
	selectStart();
	selectEnd();
}
/*---------------------------------------------------------------------
|  Method: public void selectStart
|
|  Purpose: This method is very different from createStart(). while createStart
			falsifys the start on the corn array, selectStart picks randomly one location
			on the twoDee array. it also makes sure that the selected location is linked to another
			empty space.
|  Pre-condition:  createMaze has been called because thats where selectStart is called.
|
|  Post-condition: a location in twoDee[y][0] will be false
|  Parameters: N/A
|  Returns:  void.
*-------------------------------------------------------------------*/


	public void selectStart(){
		boolean done= false;
		ArrayList<Integer> tried = new ArrayList<Integer>();
		while(!done){
			//randomY changed to twoDEE.length instead of corn
		int randomY= (int) (Math.random() * twoDee.length);
		if(twoDee[randomY][0] != false && twoDee[randomY][1] == false && !tried.contains(new Integer(randomY))){
		//corn[randomY][0]= false;
		twoDee[randomY][0]=false;
		done=true;
		}
		else{
			tried.add(randomY);
		}
		}
		
	}
    /*---------------------------------------------------------------------
    |  Method: selectEnd()
    |
    |  Purpose: This method does the same exact thing as selectStart, the exact same way.
    			The only discrepincy is that this method picks from the right side of the array
    			and checks to see a space in the column adjacent to it is also false, linking
    			it to the rest of the maze.
    |  Pre-condition: twoDee and corn have been intitalized and createMaze has been called in main.
    |
    |  Post-condition: a location in twoDee[y][twoDee.length()-1] will be false.
    |  Parameters: N/A
    |  Returns: void.
    *-------------------------------------------------------------------*/


	public void selectEnd(){
		boolean done= false;
		ArrayList<Integer> tried = new ArrayList<Integer>();
		while(!done){
		int randomY= (int) (Math.random() * twoDee.length);
		if(twoDee[randomY][twoDee[0].length-1] != false && twoDee[randomY][twoDee[0].length-2]== false && !tried.contains(new Integer(randomY))){
		twoDee[randomY][twoDee[0].length-1]= false;
		//twoDee[(2*randomY)+1][twoDee.length-1]=false;
		done=true;
		}
		else{
			tried.add(randomY);
		}
		}
		}
    /*---------------------------------------------------------------------
    |  Method: printMaze()
    |
    |  Purpose: prints the contents of corn (boolean) along with twoDee. using
    	nested for loops, empty spaces are represented with a space and filled spaces
    	are represented with '#'
    |
    |  Pre-condition: createMaze has been called.
    |  Post-condition: user will recieve output of the ArrayList 
    |  Parameters:N/A
    |  Returns: N/A
    *-------------------------------------------------------------------*/

	
	public void printMaze(){
		for(int i= 0; i < twoDee.length;i++){
			System.out.println();
			for(int n= 0; n < twoDee[0].length; n++){
				if(twoDee[i][n]==false){
					System.out.print(" ");
					
				}
				else{System.out.print("#");
				}
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("CORN");
		for(int i=0; i < corn.length;i++){
			System.out.println();
			for(int n=0; n< corn[0].length;n++){
					System.out.print(corn[i][n]);
				
			}
		}
		System.out.println("");
	}




	
	
	
}
