
import java.util.*;
import java.io.*;


public class Hotel {
	
	public static void main(String[] args) 
	{
		initialise();
		inputs();
	}

private static Room[] objectarrayroom = new Room[8];
private static Person[] objectarrayperson = new Person[8];
public static String[] waitinglistfname = new String[5];
public static String[] waitinglistsname = new String[5];
public static String[] waitinglistccard = new String[5];
public static int[] waitinglistnuguests = new int[5];
	
	// Menu 
	public static void inputs()
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
			addrooms();
		}
		else if (choice.equals("V"))
		{
			viewrooms();
		}
		else if (choice.equals("E"))
		{
			emptyrooms();
		}
		else if (choice.equals("D"))
		{
			deletecustomer();
		}
		else if (choice.equals("F"))
		{
			findroom();
		}
		else if (choice.equals("S"))
		{
			storefile();
		}
		else if (choice.equals("L"))
		{
			loadfile();
		}		
		else if (choice.equals("O"))
		{
			alphabetical();
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
			inputs();
		}	
	}
	
	// Adding Customer Into A Room
	public static void addrooms()
	{
		int y = 0;
		int roomNum = 0;
		System.out.println("---------------------------");
		System.out.println("     Adding A Customer...  ");
		System.out.println("---------------------------");
		System.out.println();
		Scanner input = new Scanner (System.in);

		//Making Sure that the customer information entered to a particular room does not get overwritten when another customer chooses the same room
		for (int x = 0; x < objectarrayperson.length; x++)
		{
			//Checking whether there are any rooms free before adding a customer to a room
			if(objectarrayperson[1].getfname() != "e" && objectarrayperson[2].getfname() != "e" && objectarrayperson[3].getfname() != "e" && objectarrayperson[4].getfname() != "e" && objectarrayperson[5].getfname() != "e" && objectarrayperson[6].getfname() != "e" && objectarrayperson[7].getfname() != "e" )
			{
				System.out.println("There Are No Empty Rooms At The Moment. You Will Be Added To The Waiting List");
				for (int i = 0; i < 5; i++)
				{
					if (waitinglistfname[i] == null)
					{
						y = i;
						break;
					}	
				}
				System.out.println("------------------------------------------------------");
				System.out.println("   Enter Your Information For The Waiting List... ");
				System.out.println("------------------------------------------------------");
				System.out.println();
				System.out.println("Enter your first name : " ) ;
				String fname = input.next();
				waitinglistfname[y] = fname;
				System.out.println("Enter your surname : " ) ;
				String sname = input.next();
				waitinglistsname[y] = sname;
				System.out.println("Enter your credit card number : " ) ;
				String ccard = input.next();
				waitinglistccard[y] = ccard;
				System.out.println("Enter number of guests in a room : " ) ;
				int nuguests = input.nextInt();
				waitinglistnuguests[y] = nuguests;
				System.out.println();
				System.out.println(fname + sname + " Is Added To The Waiting List..." ) ;
				System.out.println();
				inputs();// Show the menu to the user again
				break;
			}
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
					addrooms();// run the addrooms method again if wrong data type is enetered as input
				}
			// Showing the menu when the users give 8 as the input
			if (roomNum == 8)
			{
				inputs();// stop if 8 was given by user
				break;
			}
			//Making Sure that the customer information entered to a particular room does not get overwritten when another customer chooses the same room
			else if (objectarrayperson[roomNum].getfname() == "e")
			{
				System.out.println("Enter your first name for room : " ) ;
				String fname = input.next();
				objectarrayperson[roomNum].setfname(fname);
				System.out.println("Enter your surname : " ) ;
				String sname = input.next();
				objectarrayperson[roomNum].setsname(sname);
				System.out.println("Enter your credit card number : " ) ;
				String ccard = input.next();
				objectarrayperson[roomNum].setccard(ccard);
				System.out.println("Enter number of guests in a room : " ) ;
				int nuguests = input.nextInt();
				objectarrayroom[roomNum].setnuguests(nuguests);
				
				System.out.println(); 
				System.out.println(fname +" "+ sname + " Was Added To Room Number -> " + roomNum);// Displaying to the user that the customer was added successfully
				System.out.println();
				inputs();// Show the menu to the user again
				break;
			}
			// Displaying a message to the users saying that the room they selected is already occupied
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
	public static void viewrooms()
	{
		System.out.println("---------------------------");
		System.out.println("    Viewing All Rooms... ");
		System.out.println("---------------------------");
		System.out.println();
		for (int x = 0; x < objectarrayperson.length ; x++ )
		{
			if (objectarrayperson[x].getsname() == null)// Converting the indexes that are null, so that the program won't display null
			{
				objectarrayperson[x].setsname("");
			}
			System.out.println("Room Number " + x + " Occupied By " + objectarrayperson[x].getfname()+ " " +objectarrayperson[x].getsname());
		}
		inputs();
	}

	// Displaying Empty Rooms
	public static void emptyrooms()
	{
		System.out.println("-------------------------------");
		System.out.println("    Displaying Empty Rooms... ");
		System.out.println("-------------------------------");
		System.out.println();		
		for (int x = 0; x < objectarrayperson.length ; x++ )
		{
			if (objectarrayperson[x].getfname().equals("e"))// All rooms were named as e in initialise method. Here, if e is the name that means a customer was not added
			{
				System.out.println("Room Number " + x + " Is Empty ");
			}
		}
		inputs();
	}
	
	// Deleting Customer Froom A room
	public static void deletecustomer()
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
		catch (InputMismatchException e){
			System.out.println();
			System.out.println("Invalid Input");
			System.out.println();
			deletecustomer();// run the deletecustomer method again if wrong data type is enetered as input
		}
		for (int x = 0; x < objectarrayperson.length ; x++ )
		{
			if ( x == roomdel)
			{
				System.out.println();
				System.out.println( "Customer From Room Number " + roomdel + " Removed Successfully ");
				objectarrayperson[roomdel].setfname(waitinglistfname[0]);
				objectarrayperson[roomdel].setsname(waitinglistsname[0]);
				objectarrayperson[roomdel].setccard(waitinglistccard[0]);
				objectarrayroom[roomdel].setnuguests(waitinglistnuguests[0]);
				// Removing the first element of the waitinglistfname array so that the next person in the waitinglist can be added to the room after another person get deleted
				int delindexf = 0;
				for (int i = delindexf; i < waitinglistfname.length -1; i++)
				{
					waitinglistfname[i] = waitinglistfname[i + 1];
				}
				int delindexs = 0;
				for (int i = delindexs; i < waitinglistsname.length -1; i++)
				{
					waitinglistsname[i] = waitinglistsname[i + 1];
				}
				int delindexc = 0;
				for (int i = delindexc; i < waitinglistccard.length -1; i++)
				{
					waitinglistccard[i] = waitinglistccard[i + 1];
				}
				int delindexn = 0;
				for (int i = delindexn; i < waitinglistnuguests.length -1; i++)
				{
					waitinglistnuguests[i] = waitinglistnuguests[i + 1];
				}
			}
		}
		inputs();
	}
	
	// Finding room number
	public static void findroom()
	{
		System.out.println("-------------------------------------");
		System.out.println("  Finding Room From Customer Name... ");
		System.out.println("-------------------------------------");
		System.out.println();
        Scanner input = new Scanner(System.in);
		System.out.println("Enter Customer Name To Find The Room Number : ");// Taking the customer name as an input from the user
		String cusname = input.next();
		for (int x = 0; x < objectarrayperson.length; x++)// using a for loop to traverse through the array
		{
			if (objectarrayperson[x].getsname() == null)// Converting the indexes that are null, so that the program won't throw the NullPointerException error
			{
				objectarrayperson[x].setsname("");
			}
			if (objectarrayperson[x].getfname().equals(cusname) || objectarrayperson[x].getsname().equals(cusname))// Checking whether the value in the index(name) is equal to the userinput
			{
				System.out.println();
				System.out.println(cusname + " Is In Room Number " + x);
			}
		}
		inputs();		
	}
	
	public static void storefile()
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
			for (int x = 0; x < objectarrayroom.length ; x++ )// Reading the array that stores customer info index after index
			{
				if (objectarrayperson[x].getsname() == null)// Converting the indexes that are null, to empty strings so that they won't display null
				{
					objectarrayperson[x].setsname("");
				}
				if (objectarrayperson[x].getccard() == null)// Converting the indexes that are null, to empty strings so that they won't display null
				{
					objectarrayperson[x].setccard("");
				}
				output.write("Room Number " + x + " Is Occupied By " + objectarrayperson[x].getfname() +" "+ objectarrayperson[x].getsname() + "\n" + "No.of Guests: " + objectarrayroom[x].getnuguests() + "\n" + "Credit Card Number Of Paying Guest: " + objectarrayperson[x].getccard() + "\n" + "\n");// Printing the customer info in the text file
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
		inputs();
	}
	
	// Loading Information from the stored file
	public static void loadfile()
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
		inputs();
	}
	
	// Displaying the customer names in alphabetical order
	public static void alphabetical ()
	{
		System.out.println("-------------------------------------------");
		System.out.println("  Viewing Guests In Alphabetical Order... ");
		System.out.println("-------------------------------------------");
		String temp;
		for (int x = 0; x < objectarrayperson.length-1; x++)
		{
			for(int y = x + 1; y < objectarrayperson.length-1; y++)
			{
				if(objectarrayperson[x].getfname().toUpperCase().compareTo(objectarrayperson[y].getfname().toUpperCase()) > 0 )
				{
					temp = objectarrayperson[x].getfname();
					objectarrayperson[x].setfname(objectarrayperson[y].getfname());
					objectarrayperson[y].setfname(temp);
				}
			}
		}
		for (int i = 0; i < objectarrayperson.length ; i++)
		{
			System.out.println();
			System.out.println(objectarrayperson[i].getfname());
		}
		inputs();
	}
	
	private static void initialise() 
	{
		for (int x = 0; x < objectarrayperson.length  ; x++ )
		{
			objectarrayroom[x] = new Room(x);
			objectarrayperson[x] = new Person();
			objectarrayperson[x].setfname("e");
		}
	}
	
}