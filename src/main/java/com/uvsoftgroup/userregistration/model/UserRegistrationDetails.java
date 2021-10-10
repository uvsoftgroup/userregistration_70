package com.uvsoftgroup.userregistration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_registration_details")
public class UserRegistrationDetails extends AuditModel implements Serializable {

    @Id
    @GenericGenerator(name = "seq_useregistration", strategy = "com.uvsoftgroup.userregistration.utils.UserRegistrationIdGenerator")
    @GeneratedValue(generator = "seq_useregistration")
    @Column(name = "urd_id")
    private Long id;
    @Column(name = "urd_pass_doc")
    private byte [] passportDoc;
    @Column(name = "urd_nid_doc")
    private byte [] nationalIdDoc;
    @Column(name = "urd_vt_doc")
    private byte [] nationalVatTextDoc;
    @Column(name = "urd_bc_doc")
    private byte [] birthCertificateDoc;
    @Column(name = "urd_hc_doc")
    private byte [] heathCertificateDoc;
    @Column(name = "urd_oc_doc")
    private byte [] othersCertificateDoc;


    // @Convert(converter = FamilyInfoConverter.class)
    /*
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb", name = "urd_family_info")
    private List<FamilyInfo> familyInfo;
    */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_details_registration"),
            name = "urd_ur_id")
    @JsonIgnore
    private UserRegistration userRegistration;


}
