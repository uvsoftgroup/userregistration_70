/**
 * 
 */
package com.uvsoftgroup.userregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_registration")
public class UserRegistration extends AuditModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "seq_useregistration", strategy = "com.uvsoftgroup.userregistration.utils.UserRegistrationIdGenerator")
	@GeneratedValue(generator = "seq_useregistration")
	@Column(name = "ur_id")
	private Long id;
	@Column(name = "ur_address_id")
	private Long userAddressId;
	@Column(name = "ur_first_name")
	private String userRegistrationFName;
	@Column(name = "ur_middle_name")
	private String userRegistrationMName;
	@Column(name = "ur_last_name")
	private String userRegistrationLName;
	@Column(name = "ur_full_name")
	private String userRegistrationFullName;
	@Column(name = "ur_login_name")
	private String userRegistrationName;
	@Column(name = "ur_login_pass")
	private String userRegistrationPassword;
	@Column(name = "ur_mail")
	private String userMail;
	@Column(name = "ur_phone_nr")
	@Size(max = 15)
	private String userPhoneNr;
	@Column(name = "ur_mobile_nr")
	private String userMobileNr;
	@Column(name = "ur_web_www")
	private String userWww;

	@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL,
			mappedBy = "userRegistration")
	private UserRegistrationProfile userRegistrationProfile;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(Long userAddressId) {
		this.userAddressId = userAddressId;
	}

	public String getUserRegistrationFName() {
		return userRegistrationFName;
	}

	public void setUserRegistrationFName(String userRegistrationFName) {
		this.userRegistrationFName = userRegistrationFName;
	}

	public String getUserRegistrationMName() {
		return userRegistrationMName;
	}

	public void setUserRegistrationMName(String userRegistrationMName) {
		this.userRegistrationMName = userRegistrationMName;
	}

	public String getUserRegistrationLName() {
		return userRegistrationLName;
	}

	public void setUserRegistrationLName(String userRegistrationLName) {
		this.userRegistrationLName = userRegistrationLName;
	}

	public String getUserRegistrationName() {
		return userRegistrationName;
	}

	public void setUserRegistrationName(String userRegistrationName) {
		this.userRegistrationName = userRegistrationName;
	}

	public String getUserRegistrationPassword() {
		return userRegistrationPassword;
	}

	public void setUserRegistrationPassword(String userRegistrationPassword) {
		this.userRegistrationPassword = userRegistrationPassword;
	}

	public String getUserRegistrationFullName() {
		return userRegistrationFullName;
	}

	public void setUserRegistrationFullName(String userRegistrationFullName) {
		this.userRegistrationFullName = userRegistrationFullName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPhoneNr() {
		return userPhoneNr;
	}

	public void setUserPhoneNr(String userPhoneNr) {
		this.userPhoneNr = userPhoneNr;
	}

	public String getUserMobileNr() {
		return userMobileNr;
	}

	public void setUserMobileNr(String userMobileNr) {
		this.userMobileNr = userMobileNr;
	}

	public String getUserWww() {
		return userWww;
	}

	public void setUserWww(String userWww) {
		this.userWww = userWww;
	}

	public UserRegistrationProfile getUserRegistrationProfile() {
		return userRegistrationProfile;
	}

	public void setUserRegistrationProfile(UserRegistrationProfile userRegistrationProfile) {
		this.userRegistrationProfile = userRegistrationProfile;
	}
}
