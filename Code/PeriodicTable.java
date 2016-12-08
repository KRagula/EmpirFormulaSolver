package periodicTable;

/** Periodic Table
 * Creates an array of all the elements and allows
 * the user to search for elements and their features
 * 
 * @author Kanishka Ragula
 * @version 0.0.1
 * @since 12/7/16
 */
public class PeriodicTable {
	private Element[] elements = new Element[3];
	public PeriodicTable(){
		H h = new H();
		He he = new He();
		Li li = new Li();
		elements[0] = h;
		elements[1] = he;
		elements[2] = li;
	}
	
	/**
	 * By giving the element's name, the user can
	 * have the atomic mass of the element returned
	 * @param elementName Symbol of the element
	 * @return Atomic mass of the element
	 */
	public double amu(String elementName){
		double amu = 0;
		boolean keepGoing = true;
		for(Element elem:elements){
			if(keepGoing){
				if(elem.testString(elementName)){
					System.out.println(elem.symbol);
					amu = elem.amu;
					keepGoing = false;
				}
			}
			
		}
		return amu;
	}
}
