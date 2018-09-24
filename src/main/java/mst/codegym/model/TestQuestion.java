package mst.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Quiz quiz;

    @Column(nullable = false)
    private String content;

    private String descriptions;

    private String hint;

    @Convert(converter = TestQuestionWeightAttrConverter.class)
    private TestQuestionWeight weight;

    private boolean orderRelevance;
}
