public class Bond{
	public String bondName;
	public double bondBalance;
	public double rate, interest;
	public int terms, monthsRemaining;

	public void interestRate(int t){
		if(t <= 0){
			System.out.println("Terms cann't be less than 1..");
		}
		else if(t > 0 && t < 12)
		{
			rate = 0.05;
		}
		else if(t>12 && t < 24)
		{
			rate = 0.1;
		}
		else
		{
			rate = 0;
		}
		terms = t;
		monthsRemaining = t;
	}
	public double interest(){
		return bondBalance += bondBalance * rate;
	}
}