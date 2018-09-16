package mst.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "TestQuestion")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "testId")
    private Test test;

    @Column(nullable = false)
    private String content;

    private String descriptions;

    private String hint;

    private int weight;

    private boolean orderRelevance;

    public TestQuestion() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isOrderRelevance() {
        return orderRelevance;
    }

    public void setOrderRelevance(boolean orderRelevance) {
        this.orderRelevance = orderRelevance;
    }

    @Override
    public String toString() {
        return "TestQuestion{" +
                "id=" + id +
                ", test=" + test +
                ", content='" + content + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", hint='" + hint + '\'' +
                ", weight=" + weight +
                ", orderRelevance=" + orderRelevance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestQuestion that = (TestQuestion) o;

        if (id != that.id) return false;
        if (weight != that.weight) return false;
        if (orderRelevance != that.orderRelevance) return false;
        if (test != null ? !test.equals(that.test) : that.test != null) return false;
        if (!content.equals(that.content)) return false;
        if (descriptions != null ? !descriptions.equals(that.descriptions) : that.descriptions != null) return false;
        return hint != null ? hint.equals(that.hint) : that.hint == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + content.hashCode();
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        result = 31 * result + (hint != null ? hint.hashCode() : 0);
        result = 31 * result + weight;
        result = 31 * result + (orderRelevance ? 1 : 0);
        return result;
    }
}
