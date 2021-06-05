package kodlamaio.hrms.entities.concretes;

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
@Table(name="cover_letters")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "cover_letter_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class CoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="letter")
	private String letter;
	
	@Column(name="resume_id")
	private int resumeId;
	
	@JoinColumn(name="resume_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.EAGER)
	@JsonIgnore
	private Resume resume;
	
}