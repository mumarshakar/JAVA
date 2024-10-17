public class CalcBondInterest{
	public static void main(String[] args){
		Bond bnd = new Bond();
		bnd.bondName = "Starter Pakistan";
		bnd.bondBalance = 1000;
		bnd.interestRate(10);
		bnd.interest();

		System.out.println("Bond Balance:\t" + bnd.interest());
	}
}