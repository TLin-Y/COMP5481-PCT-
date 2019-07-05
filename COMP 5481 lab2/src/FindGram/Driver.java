package FindGram;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public  static void main(String[] args) {
		Scanner input = new Scanner( System.in);
		System.out.print("Enter input strings: ");
		int num = input.nextInt();
		List<String> Lines = new ArrayList<String>();
		for (int i = 0; i <= num; i++) {
			Lines.add(input.nextLine());
		}
		int endNum = input.nextInt();
		//System.out.print("Lines: "+Lines);
		lineToWord finder = new lineToWord();
		finder.getNgram(Lines,endNum);

	}
}
