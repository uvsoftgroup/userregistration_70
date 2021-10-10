/**
 * 
 */
package com.uvsoftgroup.userregistration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_registration_role")
public class UserRole extends AuditModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "seq_userrole", strategy = "com.uvsoftgroup.userregistration.utils.UserRoleIdGenerator")
	@GeneratedValue(generator = "seq_userrole")
	@Column(name = "urr_id")
	private Long id;
	@Column(name = "urr_ref_nr_id")
	private Long userRefNrId;
	@Column(name = "urr_name")
	private String userRoleName;
	@Column(name = "urr_type")
	private String userRoleType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "urr_cr_date")
	private Date userRoleDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "urr_mo_date")
	private Date userRoleMDate;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_role_registration"),
			name = "urr_ur_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private UserRegistration userRegistration;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserRefNrId() {
		return userRefNrId;
	}

	public void setUserRefNrId(Long userRefNrId) {
		this.userRefNrId = userRefNrId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public String getUserRoleType() {
		return userRoleType;
	}

	public void setUserRoleType(String userRoleType) {
		this.userRoleType = userRoleType;
	}

	public Date getUserRoleDate() {
		return userRoleDate;
	}

	public void setUserRoleDate(Date userRoleDate) {
		this.userRoleDate = userRoleDate;
	}

	public Date getUserRoleMDate() {
		return userRoleMDate;
	}

	public void setUserRoleMDate(Date userRoleMDate) {
		this.userRoleMDate = userRoleMDate;
	}

	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}
}
