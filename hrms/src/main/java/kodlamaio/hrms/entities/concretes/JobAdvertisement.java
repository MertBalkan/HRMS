package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_position_count")
	private int openPositions;
	
	@Column(name="min_salary")
	private double minSalary;

	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="deadline")
	private Date deadline;

	@Column(name="is_active")
	private boolean isActive = true;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "position_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name= "work_type_id")
	private WorkType workType;
	
	@ManyToOne()
	@JoinColumn(name= "work_time_id")
	private WorkTime workTime;
}
