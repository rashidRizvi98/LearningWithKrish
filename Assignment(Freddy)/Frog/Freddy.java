package Frog;
public class Freddy{

	private double timeSpent=0;
	private double travelledDistance=0;

	public void reach(double distance){

		while(travelledDistance<distance){
		
			travelledDistance+=5;
			if(travelledDistance>=distance)
				break;
			timeSpent++;
	
	
			travelledDistance+=3;
			if(travelledDistance>=distance)
				break;
			timeSpent+=2;


			travelledDistance++;
			if(travelledDistance>=distance)
				break;
			timeSpent+=3.5;


		}

				
	System.out.println("Time taken: "+timeSpent+"seconds");

	}

}