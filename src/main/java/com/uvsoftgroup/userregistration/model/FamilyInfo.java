package com.uvsoftgroup.userregistration.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyInfo implements Serializable {
    private String fatherName;
    private String motherName;
    private List<String> childNames;
    private List<String> childAges;
    private List<String> childSex;
}
