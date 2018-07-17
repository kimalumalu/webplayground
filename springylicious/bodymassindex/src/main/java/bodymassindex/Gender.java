package bodymassindex;

/**
 * Class defining gender of user for body mass index calculation
 * 
 * @author Zolana Nsakala
 */
public enum Gender {
	MALE(34), FEMALE(30);
	
	/**
	 * Body mass index value for maximal gender age 
	 * 
	 * @param int
	 */
	private int indexValueByMaxAge;

	private Gender(int indexValueByMaxAge) {
		this.indexValueByMaxAge = indexValueByMaxAge;
	}
	
	public int getIndexValueByMaxAge() {
		return this.indexValueByMaxAge;
	}
}
