package bodymassindex;

import javax.persistence.*;

@Entity
@Table(name="bmi_report")
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int currentBodyMassIndex;
	private double currentWeight;
	private int idealBodyMassIndex;
	private int idealWeight;
	private int weightToLose;
	
	public Report() {
		
	}
	
	public Report(int currentBodyMassIndex, double currentWeight, int idealBodyMassIndex, int idealWeight, int weightToLose) {
		this.currentBodyMassIndex = currentBodyMassIndex;
		this.currentWeight        = currentWeight;
		this.idealBodyMassIndex   = idealBodyMassIndex;
		this.idealWeight          = idealWeight;
		this.weightToLose         = weightToLose;
	}

	public int getCurrentBodyMassIndex() {
		return currentBodyMassIndex;
	}

	public void setCurrentBodyMassIndex(int currentBodyMassIndex) {
		this.currentBodyMassIndex = currentBodyMassIndex;
	}

	public double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public int getIdealBodyMassIndex() {
		return idealBodyMassIndex;
	}

	public void setIdealBodyMassIndex(int idealBodyMassIndex) {
		this.idealBodyMassIndex = idealBodyMassIndex;
	}

	public int getIdealWeight() {
		return idealWeight;
	}

	public void setIdealWeight(int idealWeight) {
		this.idealWeight = idealWeight;
	}

	public int getWeightToLose() {
		return weightToLose;
	}

	public void setWeightToLose(int weightToLose) {
		this.weightToLose = weightToLose;
	}
}
