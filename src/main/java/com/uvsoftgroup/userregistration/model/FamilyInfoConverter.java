package com.uvsoftgroup.userregistration.model;
import com.google.gson.Gson;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class FamilyInfoConverter implements AttributeConverter<FamilyInfo, String> {

    private final static Gson GSON = new Gson();

    @Override
    public String convertToDatabaseColumn(FamilyInfo familyInfo) {
        return GSON.toJson(familyInfo);
    }

    @Override
    public FamilyInfo convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, FamilyInfo.class);
    }
}
