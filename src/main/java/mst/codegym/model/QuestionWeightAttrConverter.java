package mst.codegym.model;

import javax.persistence.AttributeConverter;

public class QuestionWeightAttrConverter implements AttributeConverter<QuestionWeight, Integer> {
  @Override
  public Integer convertToDatabaseColumn(QuestionWeight attribute) {
    if (attribute == null) {
      return QuestionWeight.NONE.getValue();
    }
    return attribute.getValue();
  }

  @Override
  public QuestionWeight convertToEntityAttribute(Integer dbData) {
    if (dbData == null) {
      return QuestionWeight.NONE;
    }
    return QuestionWeight.fromValue(dbData);
  }
}
