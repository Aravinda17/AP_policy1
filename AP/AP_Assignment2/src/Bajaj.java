import java.util.Random;

public class Bajaj extends TwoWheelerEngine{
	ThirdParty policy1 = new ThirdParty();
	Random rand = new Random();
	public void set()
	{
		noOfWheels=2;
		model="Bajaj";
		ownerName="John";
		policy1.setPolicy(2018,1111);
		pol.percentOncoming=policy1.percentOncoming;
		pol.percentSelf=policy1.percentSelf;
		pol.expiry=policy1.expiry;
		pol.policyNo=policy1.policyNo;
		setIt();
	}
	public String getOwnerName()
	{
		return ownerName;
	}
	public String getModel()
	{
		return model;
	}
}
