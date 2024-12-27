import java.util.Objects;

public class Person {
    private double id;
    private Float weightedLuckScore;
    private Float weightedSkillScore;
    private Float luckScore;
    private Float skillScore;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.id, id) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "weightedLuckScore=" + weightedLuckScore +
                ", weightedSkillScore=" + weightedSkillScore +
                ", luckScore=" + luckScore +
                ", skillScore=" + skillScore +
                '}';
    }

    public Person(Double id,Float luckScore, Float skillScore, Float luckValue, Float skillValue) {
        this.id = id;
        this.luckScore = luckScore;
        this.skillScore = skillScore;
        this.weightedLuckScore = luckValue;
        this.weightedSkillScore = skillValue;
    }

    public double getId() {
        return id;
    }

    public Float getWeightedLuckScore() {
        return this.weightedLuckScore;
    }


    public Float getLuckScore() {
        return this.luckScore;
    }

    public Float getSkillScore() {
        return this.skillScore;
    }

    public Float getWeightedSkillScore() {
        return this.weightedSkillScore;
    }

    public Float getTotalScore() {
        return this.getWeightedLuckScore() + this.getWeightedSkillScore();
    }

}
