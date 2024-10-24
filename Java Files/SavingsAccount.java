public class SavingsAccount {
	public String name;
	public double balance;
	
	public void deposit(int x){
	balance += x;
	}
	
	public void withdraw(double y){
		if(y <= 0)
		{
			System.out.println("Amount can not be less than Zero ..");
		}
		else if( y > balance)
		{
			System.out.println("Insufficient Funds in Account..");
		}
		else
		{
			balance -= y;
		}
	}

}

