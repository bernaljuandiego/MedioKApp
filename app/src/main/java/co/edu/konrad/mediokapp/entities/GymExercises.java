package co.edu.konrad.mediokapp.entities;

public class GymExercises {

    private int exerciseImg;
    private String exerciseName;
    private String exerciseDescription;

    public GymExercises(int exerciseImg, String exerciseName, String exerciseDescription) {
        this.exerciseImg = exerciseImg;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
    }

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
}
