

public class Giant extends TwoWheelerNonEngine{
    Policy policy1 = new Policy();
	public void set()
	{
		noOfWheels=2;
		model="Giant";
        ownerName="Alex";
        //pol.percentOncoming=policy1.percentOncoming;
		//pol.percentSelf=policy1.percentSelf;
		//pol.expiry=policy1.expiry;
		//pol.policyNo=policy1.policyNo;
        setNonEngine();
        setIt();
	}
}