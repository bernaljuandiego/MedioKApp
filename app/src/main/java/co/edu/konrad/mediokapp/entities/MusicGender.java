package co.edu.konrad.mediokapp.entities;

public class MusicGender {

    private int imgMusicGender;
    private String musicGenderDescription;
    private int numberOfSongs;

    public MusicGender(int imgMusicGender, String musicGenderDescription, int numberOfSongs) {
        this.imgMusicGender = imgMusicGender;
        this.musicGenderDescription = musicGenderDescription;
        this.numberOfSongs = numberOfSongs;
    }

    public int getImgMusicGender() {
        return imgMusicGender;
    }

    public String getMusicGenderDescription() {
        return musicGenderDescription;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setImgMusicGender(int imgMusicGender) {
        this.imgMusicGender = imgMusicGender;
    }

    public void setMusicGenderDescription(String musicGenderDescription) {
        this.musicGenderDescription = musicGenderDescription;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }
}
