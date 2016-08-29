
public class Package extends Policy{

	public void setPolicy(int date, int number)
	{
		percentSelf=50;
		percentOncoming=80;
		expiry = date;
		policyNo=number;
	}
}
