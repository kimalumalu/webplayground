import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import bodymassindex.Gender;
import bodymassindex.Lexicon;

@RunWith(Parameterized.class)
public class LexiconTest {
	@Parameters
	public static Collection<Object[]> data(){
		//gender,age, bmiValue
		return Arrays.asList(new Object[][] {
			{Gender.MALE,0,0},{Gender.MALE,100,34},{Gender.FEMALE,0,0},{Gender.FEMALE,100,30},
			{Gender.MALE,20,25},{Gender.MALE,21,25},{Gender.MALE,23,25},{Gender.MALE,24,25},
			{Gender.MALE,25,25},{Gender.MALE,26,25},{Gender.MALE,28,25},{Gender.MALE,29,25},
			{Gender.MALE,30,26},{Gender.MALE,31,26},{Gender.MALE,33,26},{Gender.MALE,34,26},
			{Gender.MALE,35,27},{Gender.MALE,36,27},{Gender.MALE,38,27},{Gender.MALE,39,27},
			{Gender.MALE,40,29},{Gender.MALE,41,29},{Gender.MALE,43,29},{Gender.MALE,44,29},
			{Gender.MALE,45,31},{Gender.MALE,46,31},{Gender.MALE,48,31},{Gender.MALE,49,31},
			{Gender.MALE,50,33},{Gender.MALE,51,33},{Gender.MALE,58,33},{Gender.MALE,59,33},
			{Gender.FEMALE,20,25},{Gender.FEMALE,21,25},{Gender.FEMALE,23,25},{Gender.FEMALE,24,25},
			{Gender.FEMALE,25,26},{Gender.FEMALE,26,26},{Gender.FEMALE,28,26},{Gender.FEMALE,29,26},
			{Gender.FEMALE,30,26},{Gender.FEMALE,31,26},{Gender.FEMALE,33,26},{Gender.FEMALE,34,26},
			{Gender.FEMALE,35,27},{Gender.FEMALE,36,27},{Gender.FEMALE,38,27},{Gender.FEMALE,39,27},
			{Gender.FEMALE,40,28},{Gender.FEMALE,41,28},{Gender.FEMALE,43,28},{Gender.FEMALE,44,28},
			{Gender.FEMALE,45,28},{Gender.FEMALE,46,28},{Gender.FEMALE,48,28},{Gender.FEMALE,49,28},
			{Gender.FEMALE,50,29},{Gender.FEMALE,51,29},{Gender.FEMALE,58,29},{Gender.FEMALE,59,29}
		});
	}

    @Parameter
    public Gender gender;

    @Parameter(1)
    public int age;
    
    @Parameter(2)
    public int bmiValue;

    @Test
    public void testGetBodyMassIndexValue() {
    	assertEquals(bmiValue, Lexicon.getBodyMassIndexValue(gender,age));
    }
}
