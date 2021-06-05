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
@Table(name="work_experiences")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="work_experience_id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class WorkExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="resume_id")
	private int resumeId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="work_position")
	private String workPosition;
	
	@Column(name="work_start_date")
	private Date workStartDate;
	
	@Column(name="work_finish_date")
	private Date workFinishDate;
	
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.EAGER)
	@JsonIgnore
	private Resume resume;	
	
}