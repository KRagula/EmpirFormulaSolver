
public abstract class Element {
	protected String symbol;
	protected double amu;
	protected int elementNum;
	protected String name;
	public int getNum() {
		// TODO Auto-generated method stub
		return this.elementNum;
	}
	public double getAmu() {
		// TODO Auto-generated method stub
		return this.amu;
	}
	public boolean testString(String otElm) {
		// TODO Auto-generated method stub
		if(this.symbol.equals(otElm)){
			return true;
		} else {
			return false;
		}
	}
}
