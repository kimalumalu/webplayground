import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import bodymassindex.Calculator;
import bodymassindex.Gender;
import bodymassindex.InvalidUserDataException;
import bodymassindex.Report;
import bodymassindex.User;

@RunWith(Parameterized.class)
public class CalculatorTest {
	@Parameters
	public static Collection<Object[]> data(){
		//gender,age,height(m),weight(kg),index value, rounded ideal weight, weight to lose
		return Arrays.asList(new Object[][] {
			{Gender.MALE,0,0.5,0.5,0,0,0},
			{Gender.MALE,100,1.70,60.0,34,98,0},
			{Gender.FEMALE,0,0.50,0.4,0,0,0},
			{Gender.FEMALE,100,1.65,55.3,30,81,0},
			{Gender.MALE,38,1.80,94.3,29,87,7}
		});
	}
	
    private Calculator calculator;    
    private int currentBmiValue;
    private int idealWeight;
    private int weightToLose;
    
    public CalculatorTest(
    		Gender gender, 
    		   int age, 
    		double height, 
    		double weight, 
    		   int currentBmiValue, 
    		   int idealWeight,
    		   int weightToLose
    ) throws InvalidUserDataException {
    	User user = new User(gender,age,height,weight);
    	
		this.currentBmiValue = currentBmiValue;
		this.idealWeight     = idealWeight;
		this.weightToLose    = weightToLose; 
		this.calculator      = new Calculator(user);
	}  
    
    @Test(expected = InvalidUserDataException.class) 
    public void testUserwithInvalidHeight() throws InvalidUserDataException {
    	User user = new User();
    	user.setWeight(0.5);
    	Calculator calculator = new Calculator(user);
    	assertNull(calculator);
    }    
    
    @Test(expected = InvalidUserDataException.class) 
    public void testUserwithInvalidWeight() throws InvalidUserDataException {
    	User user = new User();
    	user.setHeight(0.5);
    	Calculator calculator = new Calculator(user);
    	assertNull(calculator);
    } 
	
	@Test
	public void testGetCurrentBodyMassIndex() {			
		assertEquals(this.currentBmiValue, this.calculator.getCurrentBodyMassIndex());
	}
	
	@Test
	public void testGetIdealWeight() {			
		assertEquals(this.idealWeight, this.calculator.getIdealWeight());
	}
	
	@Test
	public void testGetWeightToLose() {			
		assertEquals(this.weightToLose, this.calculator.getWeightToLose());
	}
	
	@Test
	public void testGetReport() throws InvalidUserDataException {
		User user             = new User(Gender.MALE,38,1.80,94.3);
		Report report         = new Report(29,94.3,27,87,7);
		Calculator calculator = new Calculator(user);	
		
		assertEquals(report.getCurrentBodyMassIndex(), calculator.getReport().getCurrentBodyMassIndex());
		assertEquals(report.getCurrentWeight(), calculator.getReport().getCurrentWeight(),0);
		assertEquals(report.getIdealBodyMassIndex(), calculator.getReport().getIdealBodyMassIndex());
		assertEquals(report.getIdealWeight(), calculator.getReport().getIdealWeight());
		assertEquals(report.getWeightToLose(), calculator.getReport().getWeightToLose());
	}
}
