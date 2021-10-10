package com.uvsoftgroup.userregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_registration_profile")
public class UserRegistrationProfile implements Serializable {
        @Id
        @GenericGenerator(name = "seq_urprofile", strategy = "com.uvsoftgroup.userregistration.utils.UserRegistrationProfileIdGenerator")
        @GeneratedValue(generator = "seq_urprofile")
        @Column(name = "urp_id")
        private Long id;
        @Temporal(TemporalType.DATE)
        @Column(name = "urp_dob")
        private Date dateOfBirth;
        @Column(name = "urp_street")
        private String street;
        @Column(name = "urp_city")
        private String city;
        @Column(name = "urp_state")
        private String state;
        @Column(name = "urp_country")
        private String country;
        @Column(name = "urp_zip_code")
        @Size(max = 32)
        private String zipCode;
        @Column(name = "urp_house_nr")
        @Size(max = 11)
        private String houseNumber;
        @OneToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_profile_registration"),
                name = "urp_ur_id", nullable = false)
        private UserRegistration userRegistration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }
}
