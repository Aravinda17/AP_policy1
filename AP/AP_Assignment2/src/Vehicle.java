import java.util.Scanner;
import java.util.Random;

public class Vehicle {
	int noOfWheels;
	String ownerName = new String();
	String model= new String();
	int damage;
	Policy pol = new Policy();
	Random rand = new Random();
	public void setIt()
	{
		damage=(rand.nextInt(100)+1)*100;
	}
	public void setOwnerName()
	{
		System.out.println("Enter the name of the owner: ");
		Scanner scan = new Scanner(System.in);
		ownerName=scan.nextLine();
	}
	public String getOwnerName()
	{
		return ownerName;
	}
	public String getModel()
	{
		return model;
	}
	public int getNoOfWheels()
	{
		return noOfWheels;
	}
	public String getPolicyClass()
	{
		String str = new String();
		if(pol.percentOncoming==0)
			str="None";
		else if(pol.percentOncoming==80 && pol.percentSelf==0)
			str="ThirdParty";
		else
			str="Package";
		return str;
	}
	public String getPolicyExpiry()
	{
		String str = new String();
		if(pol.percentOncoming==0)
			str="NoPolicy";
		else
			if(pol.expiry>=2016)
				str="NotExpired";
			else
				str="Expired";
		return str;
	}
}