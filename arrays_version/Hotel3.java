
import java.util.*;
import java.io.*;


public class Hotel3 {
	
	public static void main(String[] args) 
	{
		int roomNum = 0;
		String[] hotel = new String[8];
		String[] firstnames = new String[8];
		String[] surnames = new String[8];
		String[] ccardnumbers = new String[8];
		int[] guests = new int[8];
		initialise(firstnames);
		inputs(firstnames,surnames,ccardnumbers,guests);
	}
	
	// Menu 
	public static void inputs(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		System.out.println("+--------------------------------------------------------+");
		System.out.println("                      Welcome !!");
		System.out.println("+--------------------------------------------------------+");
		System.out.println(" Enter 'A' : Add New Customer To A Room ");
		System.out.println(" Enter 'V' : View All Rooms ");
		System.out.println(" Enter 'E' : Display Empty Rooms ");
		System.out.println(" Enter 'D' : Delete Customer From Room");
		System.out.println(" Enter 'F' : Find Room From Customer Name ");
		System.out.println(" Enter 'S' : Store Program Data Into A File ");
		System.out.println(" Enter 'L' : Load Program Data From File ");
		System.out.println(" Enter 'O' : View Guests Ordered Alphabetically By Name ");
		System.out.println(" Enter 'Q' : Exit From The Program ");
		System.out.println("+--------------------------------------------------------+");
		Scanner input = new Scanner (System.in);
		System.out.println("");
		System.out.println("Enter Your Choice : ");// Getting the choice of the user as an input
		String choice = input.next();
		// Calling each method according to the user input
		if (choice.equals("A"))
		{
			addrooms(firstnames,surnames,ccardnumbers,guests);
		}
		else if (choice.equals("V"))
		{
			viewrooms(firstnames,surnames,ccardnumbers,guests);
		}
		else if (choice.equals("E"))
		{
			emptyrooms(firstnames,surnames,ccardnumbers,guests);
		}
		else if (choice.equals("D"))
		{
			deletecustomer(firstnames,surnames,ccardnumbers,guests);
		}
		else if (choice.equals("F"))
		{
			findroom(firstnames,surnames,ccardnumbers,guests);
		}
		else if (choice.equals("S"))
		{
			storefile(firstnames,surnames,ccardnumbers,guests);
		}
		else if (choice.equals("L"))
		{
			loadfile(firstnames,surnames,ccardnumbers,guests);
		}		
		else if (choice.equals("O"))
		{
			alphabetical(firstnames,surnames,ccardnumbers,guests);
		}
		else if (choice.equals("Q"))
		{
			System.out.println("---------------------------");
			System.out.println("        Exiting...");
			System.out.println("---------------------------");

		}	
		else
		{
			System.out.println(" Please Enter A Valid Choice !! ");
			inputs(firstnames,surnames,ccardnumbers,guests);
		}	
	}
	
	// Adding Customer Into A Room
	public static void addrooms(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		int roomNum = 0;
		System.out.println("---------------------------");
		System.out.println("     Adding A Customer...  ");
		System.out.println("---------------------------");
		System.out.println();
		Scanner input = new Scanner (System.in);
		for (int x = 0; x < firstnames.length ; x++)
		{
			System.out.println("Enter room number (0-7) or 8 to stop:" );
			//validaation for roomNumber
				try
				{
					roomNum = input.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println();
					System.out.println("Invalid Input");
					System.out.println();
					addrooms(firstnames,surnames,ccardnumbers,guests); // run the addrooms method again if wrong data type is enetered as input
				}
			// Showing the menu when the users give 8 as the input
			if (roomNum == 8)
			{
				inputs(firstnames,surnames,ccardnumbers,guests);// stop if 8 was given by user
				break;
			}
			//Making Sure that the customer information entered to a particular room does not get overwritten when another customer chooses the same room
			else if (firstnames[roomNum] == "e")
			{
			System.out.println("Enter your first name for room " + roomNum +" : " ) ;
			String fname = input.next();
			firstnames[roomNum] = fname;
			System.out.println("Enter your surname for room " + roomNum +" : " ) ;
			String sname = input.next();
			surnames[roomNum] = sname;
			System.out.println("Enter your credit card number : " ) ;
			String ccard = input.next();
			ccardnumbers[roomNum] = ccard;
			System.out.println("Enter number of guests in a room : " ) ;
			int nuguests = input.nextInt();
			guests[roomNum] = nuguests;
			System.out.println();
			System.out.println(fname +" "+ sname + " Was Added To Room Number -> " + roomNum);// Displaying to the user that the customer was added successfully
			System.out.println();
			inputs(firstnames,surnames,ccardnumbers,guests);// Show the menu to the user again
			break;
			}
			else
			{
				System.out.println();
				System.out.println("Room Number " + roomNum + " is already occupied ! Please Select A Different Room...");
				System.out.println();
				System.out.println("------------------------------------------------------------------------------------");
			}	
		}
	}
	
	// Viewing all the hotel rooms
	public static void viewrooms(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		System.out.println("---------------------------");
		System.out.println("    Viewing All Rooms... ");
		System.out.println("---------------------------");
		System.out.println();
		for (int x = 0; x < firstnames.length; x++ )
		{
			if (surnames[x] == null)// Converting the indexes that are null, to empty strings so that they won't display null
			{
				surnames[x] = "";
			}
			System.out.println("Room Number " + x + " Occupied By " + firstnames[x] +" "+ surnames[x]);
		}
		inputs(firstnames,surnames,ccardnumbers,guests);
	}

	// Displaying Empty Rooms
	public static void emptyrooms(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		System.out.println("-------------------------------");
		System.out.println("    Displaying Empty Rooms... ");
		System.out.println("-------------------------------");
		System.out.println();		
		for (int x = 0; x < firstnames.length-1; x++ )
		{
			if (firstnames[x].equals("e"))// All rooms were named as e in initialise method. Here, if e is the name that means a customer was not added
			{
				System.out.println("Room Number " + x + " Is Empty ");
			}
		}
		inputs(firstnames,surnames,ccardnumbers,guests);
	}
	
	// Deleting Customer Froom A room
	public static void deletecustomer(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		int roomdel = 0;
		System.out.println("-------------------------------------");
		System.out.println("    Deleting Customer From Room... ");
		System.out.println("-------------------------------------");
		System.out.println();
		Scanner input = new Scanner (System.in);
		System.out.println("Enter The Room Number That You Want TO Clear : ");// Asking user to insert the room number where the customer lives in
		try{
			roomdel = input.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println();
			System.out.println("Invalid Input");
			System.out.println();
			deletecustomer(firstnames,surnames,ccardnumbers,guests);// run the deletecustomer method again if wrong data type is enetered as input
		}
		for (int x = 0; x < firstnames.length; x++ )
		{
			if ( x == roomdel)
			{
				firstnames[x] = "e";// Removing the name that was added before and changing the value of index back to empty(e)
				surnames[x] = "";
				System.out.println();
				System.out.println( "Customer From Room Number " + roomdel + " Removed Successfully ");
			}
		}
		inputs(firstnames,surnames,ccardnumbers,guests);
	}
	
	// Finding room number
	public static void findroom(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		System.out.println("-------------------------------------");
		System.out.println("  Finding Room From Customer Name... ");
		System.out.println("-------------------------------------");
		System.out.println();
        Scanner input = new Scanner(System.in);
		System.out.println("Enter Customer Name To Find The Room Number : ");// Taking the customer name as an input from the user
		String cusname = input.next();
		for (int x = 0; x < firstnames.length; x++)// using a for loop to traverse through the array
		{
			if (surnames[x] == null)// Converting the indexes that are null, so that the program won't throw the NullPointerException error
			{
				surnames[x] = "";
			}
			if (firstnames[x].equals(cusname) || surnames[x].equals(cusname))// Checking whether the value in the index(name) is equal to the userinput. Here, surname is also added incase the user searches using the customer's surname
			{
				System.out.println();
				System.out.println(cusname + " Is In Room Number " + x);
			}
		}
		inputs(firstnames,surnames,ccardnumbers,guests);		
	}
	
	public static void storefile(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		// creating the text file that will store the customer information
		File filename = new File ("customerinfo.txt");
		System.out.println("-------------------------------------");
		System.out.println("  Storing program Data In a File... ");
		System.out.println("-------------------------------------");
		System.out.println();
		try
		{
			FileWriter fw = new FileWriter (filename);
			Writer output = new BufferedWriter(fw);
			for (int x = 0; x < firstnames.length; x++ )// Reading the array that stores customer info index after index
			{
				if (surnames[x] == null)// Converting the indexes that are null, to empty strings so that they won't display null
				{
					surnames[x] = "";
				}
				if (ccardnumbers[x] == null)// Converting the indexes that are null, to empty strings so that they won't display null
				{
					ccardnumbers[x] = "";
				}
				output.write("Room Number " + x + " Is Occupied By " + firstnames[x] +" "+ surnames[x] + "\n" + "No.of Guests: " + guests[x] + "\n" + "Credit Card Number Of Paying Guest: " + ccardnumbers[x] + "\n" + "\n");// Printing the customer info in the text file
			}
			output.close();
			System.out.println("Customer Data Was Stored Successfully In " + filename + " file");
			System.out.println();
		}
		catch (Exception e)// If the file cannot be read showing an error
		{
			System.out.println( " The Data Cannot Be Stored In The File !! ");
			System.out.println();
		}
		inputs(firstnames,surnames,ccardnumbers,guests);
	}
	
	// Loading Information from the stored file
	public static void loadfile(String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		System.out.println("---------------------------------------");
		System.out.println("  Loading Program Data From A File... ");
		System.out.println("---------------------------------------");
		System.out.println();
		try
		{
			File myObj = new File("customerinfo.txt");// taking the file that needs to be read
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();//Reading the content in the file line by line
				System.out.println(data);//Displaying the content that was read from the file
			}	
			myReader.close();
		}
		catch(FileNotFoundException e)// If the file cannot be read showing an error
		{
			System.out.println("An error Occurred !!");
			e.printStackTrace();
		}	
		inputs(firstnames,surnames,ccardnumbers,guests);
	}
	
	// Displaying the customer names in alphabetical order
	public static void alphabetical (String[] firstnames, String[] surnames, String[] ccardnumbers, int[] guests)
	{
		System.out.println("-------------------------------------------");
		System.out.println("  Viewing Guests In Alphabetical Order... ");
		System.out.println("-------------------------------------------");
		String temp;
		for (int x = 0; x < firstnames.length-1; x++)
		{
			for(int y = x + 1; y < firstnames.length-1 ; y++)
			{
				if(firstnames[x].toUpperCase().compareTo(firstnames[y].toUpperCase()) > 0 )
				{
					temp = firstnames[x];
					firstnames[x] = firstnames[y];
					firstnames[y] = temp;
				}
			}
		}
		for (int i = 0; i < firstnames.length ; i++)
		{
			System.out.println();
			System.out.println(firstnames[i]);
		}
		inputs(firstnames,surnames,ccardnumbers,guests);
	}
	
	private static void initialise( String firstnames[] ) 
	{
		for (int x = 0; x < firstnames.length ; x++ ) firstnames[x] = "e";
	}
	
}