import java.util.*;
import java.util.stream.Collectors;

public class Experiment {

    public static Result runExperiment(int selectionNumber, int sampleSize, float luckWeightage){
        SampleGenerator sampleGenerator = new SampleGenerator(luckWeightage);

        List<Person> sample = sampleGenerator.generateSamples(sampleSize);

        Collections.sort(sample, Comparator.comparing(Person::getTotalScore).reversed());
        List<Person> selectedPeople = getSelection(sample, selectionNumber);

        // Calculating average luck and skill score for selected people
        Float averageLuckScore = 0f;
        Float averageSkillScore = 0f;
        for(Person person: selectedPeople){
            averageLuckScore += person.getLuckScore();
            averageSkillScore += person.getSkillScore();
        }
        averageLuckScore = averageLuckScore/selectionNumber;
        averageSkillScore = averageSkillScore/selectionNumber;

        // Calculating number of people that will not change out of selected people
        // if luck did not play any role in selection and selection was purely based on skills.
        Set<Double> noLuckSelection = getSelectionOnSkillsAlone(sample, selectionNumber)
                .stream().map(person -> person.getId())
                .collect(Collectors.toSet());
        float ifNoLuck = 0;
        for(Person selectedPerson: selectedPeople){
            if (noLuckSelection.contains(selectedPerson.getId())) ++ifNoLuck;
        }

        return new Result(averageLuckScore, averageSkillScore, ifNoLuck);
    }

    private static List<Person> getSelectionOnSkillsAlone(List<Person> sample, int selectionNumber){
        Collections.sort(sample, Comparator.comparing(Person::getWeightedSkillScore).reversed());
        List<Person> selected= new ArrayList<>();
        for(int i =0;i<selectionNumber; ++i){
            Person person = sample.get(i);
            selected.add(person);
        }
        return selected;
    }

    private static List<Person> getSelection(List<Person> sample, int selectionNumber){
        Collections.sort(sample, Comparator.comparing(Person::getTotalScore).reversed());
        List<Person> selected= new ArrayList<>();
        for(int i =0;i<selectionNumber; ++i){
            Person person = sample.get(i);
            selected.add(person);
        }
        return selected;
    }
}
class Result{
    private Float averageLuckScore;
    private Float averageSkillScore;
    private Float ifNoLuck;

    public Result(Float averageLuckScore, Float averageSkillScore, Float ifNoLuck) {
        this.averageLuckScore = averageLuckScore;
        this.averageSkillScore = averageSkillScore;
        this.ifNoLuck = ifNoLuck;
    }

    public Float getIfNoLuck() {
        return ifNoLuck;
    }

    public Float getAverageLuckScore() {
        return averageLuckScore;
    }

    public Float getAverageSkillScore() {
        return averageSkillScore;
    }
}
