package mst.codegym.model;

import javax.persistence.AttributeConverter;

public class TestQuestionWeightAttrConverter implements AttributeConverter<TestQuestionWeight, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TestQuestionWeight attribute) {
        return attribute.getValue();
    }

    @Override
    public TestQuestionWeight convertToEntityAttribute(Integer dbData) {
        return TestQuestionWeight.fromValue(dbData);
    }
}
