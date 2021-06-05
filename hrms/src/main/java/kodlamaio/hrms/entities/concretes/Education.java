package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="educations")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="education_id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="university_name", nullable = false)
	private String universityName;
	
	@Column(name="university_department", nullable = false)
	private String universityDepartment;
	
	@Column(name="start_date", nullable = true)
	private Date startDate;

	@Column(name="finish_date")
	private Date finishDate;
	
	@JoinColumn(name="resume_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.EAGER)
	@JsonIgnore
	private Resume resume;
}