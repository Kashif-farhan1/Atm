package Atm;
import java.io.IOException;
public class ATM {

	public static void main (String[] args) throws IOException {
		// TODO Auto-generated method stub
		OptionMenu op=new OptionMenu();
		introduction();
		op.mainMenu();
		

	}
	
	public static void introduction()
	{
		System.out.println("welcome toATM project");
	}

}
