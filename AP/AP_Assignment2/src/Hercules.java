
public class Hercules extends TwoWheelerNonEngine{
    ThirdParty policy1 = new ThirdParty();
	public void set()
	{
		noOfWheels=2;
		model="Hercules";
        policy1.setPolicy(2018,1002);
        ownerName="PK";
        //pol.percentOncoming=policy1.percentOncoming;
		//pol.percentSelf=policy1.percentSelf;
		//pol.expiry=policy1.expiry;
		//pol.policyNo=policy1.policyNo;
        setNonEngine();
        setIt();
	}
}
