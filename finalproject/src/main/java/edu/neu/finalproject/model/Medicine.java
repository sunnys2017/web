package edu.neu.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="medicine")
public class Medicine {
	
    @Id
    @Column(name="medicineID")
    @NotEmpty
	private String medicineID;
    
    @Column(name="medicineName")
	@Size(min=1, max=255)
	private String medicineName;
    
    @Column(name="medicineProperty")
	private String medicineProperty;


	public String getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineProperty() {
		return medicineProperty;
	}

	public void setMedicineProperty(String medicineProperty) {
		this.medicineProperty = medicineProperty;
	}
    

}
