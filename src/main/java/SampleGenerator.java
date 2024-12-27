import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SampleGenerator {
    static float min = 0.0f;
    static float max = 100.0f;
    static Random rand = new Random();

    private float luckWeight;
    private float skillWeight;

    public SampleGenerator(float luckWeight) {
        this.luckWeight = luckWeight;
        this.skillWeight = 100 - this.luckWeight;
    }

    public List<Person> generateSamples(int count){
        List<Person> sample = new ArrayList<>();
        for(double i=0;i< count;++i){
            float luckScore = getRandomScore();
            float skillScore = getRandomScore();
            float luckValue = (luckScore * luckWeight) / 100f;
            float skillValue = (skillScore * skillWeight) / 100f;
            Person person = new Person(i,luckScore, skillScore, luckValue, skillValue);
            sample.add(person);
        }
        return sample;
    }
    private static float getRandomScore(){

        float num = rand.nextFloat() * (max - min) + min;
        return num;
    }
}
