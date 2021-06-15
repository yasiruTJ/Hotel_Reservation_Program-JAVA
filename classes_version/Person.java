public class Person{
	private String fname;
	private String sname;
	private String ccard;
	
	
	
	// getters
	public String getfname()
	{
		return fname;
	}
	
	//setters
	public void setfname(String fname)
	{
		this.fname = fname;
	}

	//getters
	public String getsname()
	{
		return sname;
	}
	
	//setters
	public void setsname(String sname)
	{
		this.sname = sname;
	}

	//getters
	public String getccard()
	{
		return ccard;
	}
	
	//setters
	public void setccard(String ccard)
	{
		this.ccard = ccard;
	}
	
	//constructors
	
	public Person() {

    }
	
	public Person(String fname, String sname, String ccard)
	{
		this.fname = fname;
		this.sname = sname;
		this.ccard = ccard;
	}

}