import java.util.Scanner;


public class Prog09{

	/*=============================================================================
	 |   Assignment:  Program #[9]:  [A-Maized]
	 |       Author:  [Spencer Klinge (sklinge)]
	 | Sect. Leader:  [L1zzi3]
	 |
	 |       Course:  [CSC227]
	 |   Instructor:  L. McCann
	 |     Due Date:  [April 15th, 2014 9:00PM]
	 |
	 |  Description:  This main method is the control unit for maze.java, the class
	 				  that handles all maze operations. Taking args arguments from the user,
	 				  this program randomly generates a 2 d array determined by the user, then
	 				  proceedes to cut out a completley random maze path. Each step of this random
	 				  pathing has to be maintained and manipulated in the order it was recieved, which
	 				  is the main reason myStack.java is a major part of this project
	 |                
	 | Deficiencies:N/A
	 *===========================================================================*/
	public static void main(String args[]){
		args= new String[2];
		Scanner keyboard;
		keyboard= new Scanner(System.in);
		System.out.println("Enter Height");
		args[0]= keyboard.nextInt() + "";
		System.out.println("Enter Width:");
		args[1]= keyboard.nextInt() + "";
	    try {
	    	if(args.length <=1 || args.length > 2 || Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) < 1){
	    		System.out.println("propper arguments were not given");
	    	System.exit(0);
	    	}
	    	else{
	       int a = Integer.parseInt(args[0]);
	        int b= Integer.parseInt(args[1]);
	    	maze temp= new maze(a,b);
			temp.createMaze();
			temp.printMaze();
	        
	    }
	    }catch (ArrayIndexOutOfBoundsException e) {
	        System.err.println("Argument" + args[0] + " must be an integer.");
	        System.exit(1);
	    }
	
	}
	
}
