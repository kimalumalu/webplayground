package bodymassindex;

import javax.persistence.*;

@Entity
@Table(name="bmi_report")
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="current_body_mass_index")
	private int currentBodyMassIndex;
	
	@Column(name="current_weight")
	private double currentWeight;
	
	@Column(name="ideal_body_mass_index")
	private int idealBodyMassIndex;
	
	@Column(name="ideal_weight")
	private int idealWeight;
	
	@Column(name="weight_to_lose")
	private int weightToLose;
	
	protected Report() {
		
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
