/**<h1>FormulaCollect<h1>
 * Stores the data and methods for the steps needed in order to find the Empirical Formula
 * 
 * @author Kanishka Ragula
 * @version 0.3.1
 * @since 16-03-2017
 *
 */
public class FormulaCollect {
	
	/**Return the molar mass of the element entered
	 *  
	 * @param elem Element to find the molar mass of
	 * @return Molar mass of element if exists or throws IllegalArgumentException it does not exist.
	 */
	public static float molarMass(String elem){
		elem = Element.toCorrectSymbol(elem);
		if(Element.exists(elem)){
			return Element.getBySymbol(elem).getAtomicMass();
			
		} else {
			throw new IllegalArgumentException("Please enter the correct symbol!!!!!!!");
			
		}
		
	}
	
	public static float calcRatio(float perc, float mm){
		return perc/mm;
	}
	
	public static float findSmallest(float[] array){
		float lowest = array[0];
		for(float a: array){
			if(a<lowest){
				lowest = a;
			}
		}
		return lowest;
	}
	
	public static float finalWrapup(float origin, float dividBy){
		
		return Math.round(origin/dividBy);
	}
	
	
	
	
}
