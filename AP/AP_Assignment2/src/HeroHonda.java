import java.util.Random;

public class HeroHonda extends TwoWheelerEngine{
    ThirdParty policy1 = new ThirdParty();
    Random rand = new Random();
	public void set()
	{
		noOfWheels=2;
		model="HeroHonda";
        policy1.setPolicy(2014,1001);
        ownerName="Venkat";
        pol.percentOncoming=policy1.percentOncoming;
		pol.percentSelf=policy1.percentSelf;
		pol.expiry=policy1.expiry;
		pol.policyNo=policy1.policyNo;
		setIt();
	}
}