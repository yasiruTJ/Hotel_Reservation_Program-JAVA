public class Room{
	private int roomNum;
	private int nuguests;
	
	// Creating Getters And Setters
	
	//getter
    public int getroomNum() 
	{
        return roomNum;
    }
	//setter
    public void setroomNum(int roomNum) 
	{
        this.roomNum = roomNum;
    }

	//getter
	public int getnuguests()
	{
		return nuguests;
	}
	
	//setters
	public void setnuguests(int setnuguests)
	{
		this.nuguests = nuguests;
	}
	
	//constructor
	public Room(int roomNum)
	{
		this.roomNum = roomNum;
	}
	
    public Room(int roomNum, int nuguests) 
	{
        this.roomNum = roomNum;
		this.nuguests = nuguests;
    }
}