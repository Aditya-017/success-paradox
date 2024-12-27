public class Main {
    public static void main(String[] args) {
        System.out.println("Program running");
        int selectionNumber = 11;
        int sampleSize = 18300;
        int experimentIteration = 1000;
        float luckWeightage = 5;
        Float averageLuckScore = 0f;
        Float averageSkillScore = 0f;
        Float averageIfNoLuck = 0f;

        for(int i =0;i<experimentIteration; ++i){
            Result result = Experiment.runExperiment(selectionNumber,sampleSize,luckWeightage);
            averageLuckScore += result.getAverageLuckScore();
            averageSkillScore += result.getAverageSkillScore();
            averageIfNoLuck += result.getIfNoLuck();

        }
        System.out.println("Average Experiment Luck score= "+ averageLuckScore/experimentIteration);
        System.out.println("Average Experiment Skill score= "+ averageSkillScore/experimentIteration);
        System.out.println("No. of people selected based on skill alone= "+ averageIfNoLuck/experimentIteration);

    }
}
