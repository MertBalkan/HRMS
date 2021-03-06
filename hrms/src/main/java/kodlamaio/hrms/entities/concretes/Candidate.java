package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
public class Candidate extends User{

	@NotBlank(message = "First Name Can not Empty!")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Last Name Can not Empty!")
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String nationalityId;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "email_verify")
	private boolean emailVerify;
	
	@OneToMany(mappedBy = "candidate")
	private List<Resume> resumes;
}