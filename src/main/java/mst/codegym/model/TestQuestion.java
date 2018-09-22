package mst.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

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
    @JoinColumn(name = "testId")
    private Test test;

    @Column(nullable = false)
    private String content;

    private String descriptions;

    private String hint;

    @Convert(converter = TestQuestionWeightAttrConverter.class)
    private TestQuestionWeight weight;

    private boolean orderRelevance;

    public String testMarkdown(String msg) {

        Parser parser = Parser.builder().build();
        Node document = parser.parse(msg);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        renderer.render(document);

        return renderer.render(document);
    }
}
