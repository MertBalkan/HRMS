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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="foreign_languages")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="foreign_languages_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class ForeignLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "language_name")
	private String languageName;
	
	@Column(name="resume_id", insertable = false, updatable = false)
	private int resumeId;
	
	@Min(1)
	@Max(5)
	@Column(name="language_level")
	private int languageLevel;
	
	@JoinColumn(name="resume_id", nullable = false, updatable = false)
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.EAGER)
	@JsonIgnore
	private Resume resume;
	
	
}