package co.edu.konrad.mediokapp.entities;

public class gymExercises {

    private int exerciseImg;
    private String exerciseName;
    private String exerciseDescription;
    private String exerciseTime;

    public int getExerciseImg() {
        return exerciseImg;
    }

    public void setExerciseImg(int exerciseImg) {
        this.exerciseImg = exerciseImg;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(String exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    public gymExercises(int exerciseImg, String exerciseName, String exerciseDescription, String exerciseTime) {
        this.exerciseImg = exerciseImg;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseTime = exerciseTime;
    }
}
