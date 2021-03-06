import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	static Bajaj obj1= new Bajaj();
	static HeroHonda obj2 = new HeroHonda();
	static Honda obj3 = new Honda();
	static Nissan obj4 = new Nissan();
	static Giant obj5 = new Giant();
	static Hercules obj6 = new Hercules();
	
	static Object[] array = new Object[6];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello");
		obj1.set();
		obj2.set();
		obj3.set();
		obj4.set();
		obj5.set();
		obj6.set();
		
		int i;
		int j;
		
		Vehicle[] array = {obj1,obj2,obj3,obj4,obj5,obj6};
		
		System.out.println("	Model	|	OwnerName	|	NumberOfWheels	|	PolicyClass	|	PolicyExpiry	");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		for(i=0;i<6;i++)
		{
		System.out.println("	"+array[i].getModel()+"		"+array[i].getOwnerName()+"			"+array[i].getNoOfWheels()+"			"+array[i].getPolicyClass()+"		"+array[i].getPolicyExpiry());	
		}
		
		System.out.println("Collisions Begin!");
		
		//System.out.println(array[5].pol.expiry);
		
		for(i=0;i<6;i++)
		{
			for(j=0;j<6;j++)
			{
				System.out.println("\n");
				if(i!=j)
				{
					//System.out.println(array[0].pol.percentOncoming);
					System.out.println("I am "+array[i].getModel()+"-"+array[i].getOwnerName()+", collided with "+array[j].getModel()+"-"+array[j].getOwnerName());
					//System.out.println(obj1.policy1.percentSelf);
					System.out.println("Damages self: "+array[i].damage);
					System.out.println("Damages oncoming: "+array[j].damage);
					System.out.println("Settlement details");
					if(array[i].getPolicyExpiry()=="NoPolicy")
					{
						System.out.println("Exception: Self has not been insured");
					}
					else if(array[i].getPolicyExpiry()=="Expired")
					{
						System.out.println("Exception: Policy of self has expired");
					}
					else
					{
						System.out.println("    oncoming damage status: "+(array[j].damage-((float)array[i].pol.percentOncoming/100)*array[j].damage));
						System.out.println("    self damage status: "+(array[i].damage-((float)array[i].pol.percentSelf/100)*array[i].damage));
					}
				}
			}
		}
		
	}

}
