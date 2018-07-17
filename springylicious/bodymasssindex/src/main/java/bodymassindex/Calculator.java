package bodymassindex;

/**
 * Class handling calculation of body mass index value based on age and gender
 *
 * @author zolana
 */
public class Calculator {
	protected User user;	
	
	/**
	 * Constructor for user body mass index calculation
	 * 
	 * @param User user
	 * 
	 * @throws InvalidUserDataException
	 */
	public Calculator(User user) throws InvalidUserDataException {
		this.validateUser(user);
		this.user = user;
	}
	
	/**
	 * Retrieves current body mass index calculated out of user data
	 *  
	 * @return
	 */
	public int getCurrentBodyMassIndex() {
		int age = this.user.getAge();
		if(age < Lexicon.MIN_AGE || age > Lexicon.MAX_AGE) {
			return this.getIdealBodyMassIndex();
		}		
		
		return this.getCalulatedBodyMassIndex();
	}
	
	/**
	 * Retrieves calculated ideal weight of current user
	 * 
	 * @return
	 */
	public int getIdealWeight() {
		double currentHeight = this.user.getHeight();
		double idealweight   = this.getIdealBodyMassIndex() * Math.pow(currentHeight, 2); 
		
		return (int)idealweight;
	}	
	
	/**
	 * Retrieves weight to lose for current user
	 * 
	 * @return
	 */
	public int getWeightToLose() {
		int currentweight = (int)this.user.getWeight();
		int idealWeight   = this.getIdealWeight();
		
		return Math.max(0, currentweight - idealWeight);
	}	
	
	/**
	 * Retrieves body mass index calculation report for current user
	 * 
	 * @return
	 */
	public Report getReport() {
		return new Report(
			this.getCurrentBodyMassIndex(),
			this.user.getWeight(),
			this.getIdealBodyMassIndex(),
			this.getIdealWeight(),
			this.getWeightToLose()
		);
	}
	
	/**
	 * Retrieves ideal body mass index of current user
	 * 
	 * @return
	 */
	private int getIdealBodyMassIndex() {
		return Lexicon.getBodyMassIndexValue(this.user.getGender(), this.user.getAge());
	}
	
	/**
	 * Retrieves body mass index calculated out of user data
	 * 
	 * @return
	 */
	private int getCalulatedBodyMassIndex() {
		double numerator    = this.user.getWeight();
		double denominator  = Math.pow(this.user.getHeight(), 2);
		int calculatedIndex = (int)(numerator/denominator); 
		
		return calculatedIndex;
	}
	
	/**
	 * Validates if user data to be used for calculation are valid
	 * 
	 * @param User user
	 * 
	 * @throws InvalidUserDataException
	 */
	private void validateUser(User user) throws InvalidUserDataException {
		if(user.getHeight() <= 0.0 || user.getWeight() <= 0.0) {
			throw new InvalidUserDataException();
		}
	}
}
