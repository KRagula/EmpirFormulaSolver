package Default;
import java.util.Scanner;
import periodicTable.*;

/** Main Class for the Empirical Formula Solver
 * Takes in percents of each element in a compound and
 * return the compound's empirical formula
 * 
 * @author Kanishka Ragula
 * @version 0.0.1
 * @since 12/7/16
 */
public class EmpirMain {
	public static void main(String[] args){
		PeriodicTable pTable = new PeriodicTable();
		Scanner sc = new Scanner(System.in);
		System.out.println("Wecome to Empircal Formula Sover Beta, sorry, nothing works");
		System.out.println("Enter element symbol for amu");
		String elem = sc.nextLine();
		System.out.println(pTable.amu(elem));
	}
}
