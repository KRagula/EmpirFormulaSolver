package periodicTable;

/** Superclass for the Periodic Table Elements
 * 
 * @author Kanishka Ragula
 * @version 0.0.1
 * @since 12/7/16
 */
public abstract class Element {
	protected String symbol;
	protected double amu;
	protected int elementNum;
	protected String name;
	public int getNum() {
		// TODO Auto-generated method stub
		return this.elementNum;
	}
	
	/** 
	 * Returns the amu of the element
	 * @return Atomic Mass of the Element
	 */
	public double getAmu() {
		// TODO Auto-generated method stub
		return this.amu;
	}
	
	/**
	 * Tests to see if a Symbol is the atomic symbol of 
	 * this element
	 * @param otElm Name of other element to be tested
	 * @return If they are the same or different symbol
	 */
	public boolean testString(String otElm) {
		// TODO Auto-generated method stub
		if(symbol.equals(otElm)){
			return true;
		} else {
			return false;
		}
	}
}
