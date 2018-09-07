package co.edu.konrad.mediokapp.entities;

public class musicGender {

    private int imgMusicGender;
    private String musicGenderName;
    private int numberOfSongs;

    public musicGender(int imgMusicGender, String musicGenderName, int numberOfSongs) {
        this.imgMusicGender = imgMusicGender;
        this.musicGenderName = musicGenderName;
        this.numberOfSongs = numberOfSongs;
    }

    public int getImgMusicGender() {
        return imgMusicGender;
    }

    public void setImgMusicGender(int imgMusicGender) {
        this.imgMusicGender = imgMusicGender;
    }

    public String getMusicGenderName() {
        return musicGenderName;
    }

    public void setMusicGenderName(String musicGenderName) {
        this.musicGenderName = musicGenderName;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }
}
