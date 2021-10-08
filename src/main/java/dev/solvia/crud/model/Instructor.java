package dev.solvia.crud.model;


import javax.validation.constraints.Email;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends  AbstractBaseEntity{

	@Column(name = "first_name")
	@ApiModelProperty(example = "Furkan")
	private String firstName;

	@Column(name = "last_name")
	@ApiModelProperty(example = "Gürçay")
	private String lastName;

	@Column(name = "email")
	@ApiModelProperty(example = "patika@dev.com")
	@Email(message = "Email format is wrong")
	private String email;


}
