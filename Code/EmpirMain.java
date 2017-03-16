import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
/** Main Class for the Empirical Formula Solver
 * Takes in percents of each element in a compound and
 * return the compound's empirical formula
 * 
 * @author Kanishka Ragula
 * @version 0.1.5
 * @since 03-16-2017
 */
public class EmpirMain {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel, element1, element2;
	private float elemPercFloat1, elemPercFloat2;
	private float[][] elemVals;
	
	public EmpirMain(){
			prepareGui();
	}  
	  
	  
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Wecome to Empircal Formula Solver Beta, sorry, nothing works");
		System.out.println("Enter element symbol for amu");
//		String elem = sc.nextLine();
//		Element e = Element.getBySymbol(elem);
//		System.out.println(e.toString());
		EmpirMain empirSolver = new EmpirMain();
		empirSolver.prepareText();
		
		
		
		
		
	}
	
	
	  private void prepareGui(){
		    
		    mainFrame = new JFrame("Empirical Formula Solver");
		    mainFrame.setSize(500,400);
		    mainFrame.setLayout(new GridLayout(7,1));
		    
		    headerLabel = new JLabel("Empirical Formula Solver", JLabel.CENTER);
		    headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.PLAIN, 30));
		    statusLabel = new JLabel("Test", JLabel.CENTER);
		    statusLabel.setSize(10,20);
		    
		    element1 = new JPanel();
		    element1.setLayout(new FlowLayout());
		    element2 = new JPanel();
		    element2.setLayout(new FlowLayout());
		    
		    controlPanel = new JPanel();
		    controlPanel.setLayout(new FlowLayout());
		    
		    mainFrame.add(headerLabel);
		    mainFrame.add(element1);
		    mainFrame.add(element2);
		    mainFrame.add(controlPanel);
		    mainFrame.add(statusLabel);
		    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    mainFrame.setVisible(true);
		    
		}
	  
	  private void prepareText(){
		  JLabel elemAsk = new JLabel("Element Symbol: ", JLabel.LEFT);
		  JLabel percAsk = new JLabel("Percent Mass: ", JLabel.RIGHT);
		  JLabel elemAsk2 = new JLabel("Element Symbol: ", JLabel.LEFT);
		  JLabel percAsk2 = new JLabel("Percent Mass: ", JLabel.RIGHT);
		  final JTextField elem1 = new JTextField(3);
		  final JTextField elem1Perc = new JTextField(5);
		  final JTextField elem2 = new JTextField(3);
		  final JTextField elem2Perc = new JTextField(5);
		  element1.add(elemAsk);
		  element1.add(elem1);
		  element1.add(percAsk);
		  element1.add(elem1Perc);
		  
		  element2.add(elemAsk2);
		  element2.add(elem2);
		  element2.add(percAsk2);
		  element2.add(elem2Perc);
		  mainFrame.setVisible(true);
		   
		    JButton calcButton = new JButton("Calculate");
		    
		    //Action Listener for Button Click
		    calcButton.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  if(elem1.getText().equals("")){
		    		  System.out.println("Why do you do this to me");
		    		  
		    	  }
		    	  if(elem2.getText().equals("")){
		    		  System.out.println("Seriously");
		    		  
		    	  }
		        String data = "Element: " + Element.toCorrectSymbol(elem1.getText());
		        data += ", Percent: " + elem1Perc.getText();
		        data += ", Element: " + Element.toCorrectSymbol(elem2.getText());
		        data += ", Percent: " + elem2Perc.getText();
		        statusLabel.setText(data);
		        elemPercFloat1 = Float.valueOf(elem1Perc.getText());
		        elemPercFloat2 = Float.valueOf(elem2Perc.getText());
		        
		        elemVals = new float[5][2];
		        elemVals[0][0] = elemPercFloat1;
		        elemVals[0][1] = elemPercFloat2;
		        try{
		        	elemVals[1][0] = FormulaCollect.molarMass(elem1.getText());
		        	elemVals[1][1] = FormulaCollect.molarMass(elem2.getText());
		        } catch (IllegalArgumentException err){
		        	statusLabel.setText("Please enter correct symbols");
		        }
		        
		        elemVals[2][0] = FormulaCollect.calcRatio(elemVals[0][0],elemVals[1][0]);
		        elemVals[2][1] = FormulaCollect.calcRatio(elemVals[0][1],elemVals[1][1]);
		        
		        
		        
		        for(int i=0; i<elemVals[0].length; i++){
		        	elemVals[3][i] = FormulaCollect.findSmallest(elemVals[2]);
		        }
		        
		        for(int i=0; i<elemVals[0].length; i++){
		        	elemVals[4][i] = FormulaCollect.finalWrapup(elemVals[2][i], elemVals[3][i]);
		        }
		        
		        
				  for(int i=0; i<elemVals[0].length; i++){
					  for(int j=0; j<elemVals.length; j++){
						  System.out.print(elemVals[j][i] + " ");
					  }
					  System.out.println();
				  }
				  
				  
				  
		      }
		    });
		  controlPanel.add(calcButton);
		  mainFrame.setVisible(true);

	  }
}