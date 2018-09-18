package mst.codegym.model;

import javax.persistence.AttributeConverter;

public class TestQuestionWeightAttrConverter implements AttributeConverter<TestQuestionWeight, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TestQuestionWeight attribute) {
        if (attribute == null) {
            return TestQuestionWeight.NONE.getValue();
        }
        return attribute.getValue();
    }

    @Override
    public TestQuestionWeight convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return TestQuestionWeight.NONE;
        }
        return TestQuestionWeight.fromValue(dbData);
    }
}
