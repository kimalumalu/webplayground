package bodymassindex;

import java.util.HashMap;
import java.util.Set;

public class Lexicon {
	
	/**
	 * Minimal age documented in body mass index lexicon
	 * 
	 * @param int
	 */
	public static final int MIN_AGE = 20;
	
	/**
	 * Maximal age documented in body mass index lexicon
	 * 
	 * @param int
	 */
	public static final int MAX_AGE = 60;
	
	/**
	 * Lexicon mapping age ranges to body mass index values grouped by age
	 * 
	 * @param HashMap
	 */
	private static HashMap<Gender, HashMap<Integer[],Integer>> lexicon;
	
	/**
	 * Retrieves body mass index value matching given gender and age
	 * 
	 * @param Gender gender
	 * @param int    age
	 * 
	 * @return
	 */
	public static int getBodyMassIndexValue(Gender gender, int age) {
		
		if(age < Lexicon.MIN_AGE) {
			return 0;
		}
		
		if(age > Lexicon.MAX_AGE) {
			return gender.getIndexValueByMaxAge();
		}
		
		if(Lexicon.lexicon == null) {
			 Lexicon.init();
		}
		
		return Lexicon.getIndexValueFromMap(gender, age);
	}
	
	/**
	 * Initializes body mass index value lexicon with corresponding values grouped by age ranges
	 */
	private static void init() {
		HashMap <Integer[],Integer> maleIndexes = Lexicon.getIndexValuesByGender(Gender.MALE);
		HashMap <Integer[],Integer> femaleIndexes = Lexicon.getIndexValuesByGender(Gender.FEMALE);
		
		Lexicon.lexicon = new HashMap<Gender, HashMap<Integer[],Integer>>();
		Lexicon.lexicon.put(Gender.MALE, maleIndexes);
		Lexicon.lexicon.put(Gender.FEMALE, femaleIndexes);
	}
	
	/**
	 * Retrieves gender specific mapping between age ranges and body mass index value
	 * 
	 * @param Gender gender
	 * 
	 * @return
	 */
	private static HashMap<Integer[],Integer> getIndexValuesByGender(Gender gender){
		HashMap<Integer[], Integer> indexValuesByGender = new HashMap<Integer[], Integer>();
		
		int specialRangeValueOne   = (gender.equals(Gender.MALE)) ? 25 : 26;
		int specialRangeValueTwo   = (gender.equals(Gender.MALE)) ? 29 : 28;
		int specialRangeValueThree = (gender.equals(Gender.MALE)) ? 31 : 28;
		int specialRangeValueFour  = (gender.equals(Gender.MALE)) ? 33 : 29;
		
		indexValuesByGender.put(Lexicon.createAgeRange(20,24), 25);
		indexValuesByGender.put(Lexicon.createAgeRange(25,29), specialRangeValueOne);
		indexValuesByGender.put(Lexicon.createAgeRange(30,34), 26);
		indexValuesByGender.put(Lexicon.createAgeRange(35,39), 27);
		indexValuesByGender.put(Lexicon.createAgeRange(40,44), specialRangeValueTwo);
		indexValuesByGender.put(Lexicon.createAgeRange(45,49), specialRangeValueThree);
		indexValuesByGender.put(Lexicon.createAgeRange(50,59), specialRangeValueFour);
		
		return indexValuesByGender;
	}
	
	/**
	 * Retrieves body mass index value extracted from initialized map
	 * 
	 * @param gender
	 * @param age
	 * 
	 * @return
	 */
	private static int getIndexValueFromMap(Gender gender, int age) {
		int indexValueFromMap = 0;
		
		HashMap<Integer[],Integer> indexes = Lexicon.lexicon.get(gender);
		Set<Integer[]> ageRanges = indexes.keySet();
				
		for (Integer[] ageRange : ageRanges) {
			if(ageRange[0] <= age && age <= ageRange[1]) {
				indexValueFromMap = indexes.get(ageRange);
				break;
			}
		}
		
		return indexValueFromMap;
	}
	
	/**
	 * Creates and retrieves an age range with given minimal and maximal age
	 * 
	 * @param int minAge
	 * @param int maxAge
	 * @return
	 */
	private static Integer[] createAgeRange(int minAge, int maxAge) {
		Integer[] ageRange = {minAge,maxAge};
		return ageRange;
	}
}
