/**
 * Tianlin Yang
 * 40010303
 * Lab1 for COMP5481
 * 2018/05/13
 * 6 methods
 * 
 */
package lab1numberchecker;
import java.util.Scanner;

public class checker {

	//Main for input window.
	public static void main(String[] args) {
		//Input the credit number
		Scanner creditn = new Scanner(System.in); 
		//Save credit number in long type(64bits).
		System.out.print("Enter a credit card number(less than 20 numbers): ");
		long cnumber = creditn.nextLong();
		//Show the credit number is valid or not. 				----jump to ValidJugement method.
		/**
		 * Check Valid first.
		 */
		if (ValidJugement(cnumber) == true) {
			System.out.println("VALID");
		}else { //Check invalid than
        String cstring = cnumber+"";
		String csub = cstring.substring(0,cstring.length()-1);
		//From 0-9, check each of them to find the solution for the last number of the code.
		for (int i = 0; i < 10; i++) {
			long tempnumber = Long.parseLong(csub + i);//Integer.parseInt(stringnum.charAt(i) + "")
			if (ValidJugement(tempnumber) == true) {  // Guaranteed to execute before the loop ends
				System.out.println("INVALID "+i);
				return;
				}
			}
		}
	}

	//Transfer the input number to here: 'long 'number'' As the input for boolean method.
	public static boolean ValidJugement(long number) {
		//If the number is valid, return true.
		int totalsump = (DoublePositionSum(number) + OriginSum(number)) % 10;
		boolean valid =
				/**Limit the input length less than 20.
				Than check the (total%10) should be 0.
				Now, divided credit number to 'even' and 'odd' for double operation.
				Call 'GetSize' method to calculate the number length.
				**/ 
				//										----jump to DoublePositionSum & OriginSum method
			(GetSize(number) <= 20) && (totalsump == 0);
		
		return valid;
	}
	
	//GetSize method out put the 'long type input' length. Idea is using 'String length'.
	public static int GetSize(long d) {
		//Transfer 'long type' to 'string type'.
		String num = d + "";
		return num.length();
	}
	
//--------------------------------------------------------- Double Size------------------------------------
	//Calculate double number and output the sum value.
	public static int DoublePositionSum(long number) {
		//initialize the integer 'sum' for output calculation in DoublePositionSum method.
		int sum = 0;
		//Create the String 'stringnum'(different one), for calculate divided character sum.(19=1+9)
		String stringnum = number + "";
		//From right to left, each time alternate, which is i-=2.
		for (int i = GetSize(number) - 2; i >= 0; i -= 2) {
			//Call 'parseInt' method to parse the 'String' to 'decimal number'
			//Call 'sumDigit' method to add '19=1+9'.
			sum += sumDigit(Integer.parseInt(stringnum.charAt(i) + "") * 2);//If input 1234,3*2=6.1*2=2, output 2+6=8.
		}
		//System.out.println("sum = "+sum);       use for check sum is good or not.
		return sum;
	}
	
	/**
	 * When double number less than 10, which is 0123456789, return itself.
	 * else, return "n/10 (first positon) + n%10 (second position)"
	 */
	public static int sumDigit(int number) {
		if (number < 9)
			return number;
		else
			return number / 10 + number % 10;
	}
//--------------------------------------------------------- Double Size------------------------------------
	
	
//--------------------------------------------------------- Origin number------------------------------------	
	//Calculate the sum of this origin number.
	public static int OriginSum(long number) {
		int sum = 0;
		String num = number + "";
		for (int i = GetSize(number) - 1; i >= 0; i -= 2) {
			sum += Integer.parseInt(num.charAt(i) + "");
		}
		return sum;
	}
//--------------------------------------------------------- Origin number------------------------------------	
	
}