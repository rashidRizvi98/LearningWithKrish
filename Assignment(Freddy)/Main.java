import Frog.Freddy;
import java.util.Scanner;
class Main{

	public static void main(String[] args){

		System.out.print("Enter the distance Freddy should go: ");
		Scanner sc=new Scanner(System.in);
		double distance=sc.nextDouble();

		Freddy freddy=new Freddy();
		freddy.reach(distance);

	}
}