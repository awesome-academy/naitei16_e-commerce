package com.javanaitei.phoneshop.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.javanaitei.phoneshop.validator.CorrectPassword;
import com.javanaitei.phoneshop.validator.FieldMatch;
import com.javanaitei.phoneshop.validator.NullOrNotBlank;
import com.javanaitei.phoneshop.validator.Phone;
import com.javanaitei.phoneshop.validator.UniqueField;

@FieldMatch.List({
		@FieldMatch(first = "password", second = "confirmPassword", message = "{user.validation.password.notmatch}") })
@UniqueField.List({
		@UniqueField(field = "email", column = "email", table = "User", message = "{user.validation.email.exist}"),
		@UniqueField(field = "userName", column = "user_name", table = "User", message = "{user.validation.userName.exist}") })
@CorrectPassword(name = "oldPassword", message = "{user.validation.oldPassword.incorrect}")
public class UserModel extends BaseModel {

	private Long id;
	@NotEmpty(message = "{user.validation.email.required}")
	@Email(message = "{pattern.email}")
	private String email;
	@NotEmpty(message = "{user.validation.userName.required}")
	@Size(max = 64, message = "{user.validation.userName.max}")
	private String userName;
	@NullOrNotBlank(message = "{user.validation.password.required}")
	@Size(max = 32, min = 8, message = "{user.validation.password.length}")
	private String password;
	@NullOrNotBlank(message = "{user.validation.confirmPassword.required}")
	private String confirmPassword;
	private String oldPassword;
	@NullOrNotBlank(message = "{user.validation.phone.required}")
	@Phone(message = "{user.validation.phone.length}")
	private String phone;
	private Integer role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
