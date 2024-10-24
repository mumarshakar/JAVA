import java.util.Scanner;
public class AccountTest {
	public static void main(String[] args){
//		SavingsAccount sa0001 = new SavingsAccount();
//		sa0001.name = "Damien";
//		sa0001.deposit(1000);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Terms :\t");
//		double wid = sc.nextDouble();
//		sa0001.withdraw(wid);
//		System.out.println("Dear! '" + sa0001.name + "' you have withdrawn $"  + wid + " and your current balance is : $" + sa0001.balance);
		
		int terms = sc.nextInt();
		Bond bnd = new Bond();
		bnd.balance = 1000;
		bnd.setTermAndRate(terms);
		bnd.earnInterest();
		
		//sc.close();
	}
}