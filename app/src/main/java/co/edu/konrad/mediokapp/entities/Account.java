package co.edu.konrad.mediokapp.entities;

import android.media.Image;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class Account {
    private GoogleSignInAccount account;
    private Uri photoGoogleLogin;
    private String nameGoogleLogin;
    private String emailGoogleLogin;
    private String idTextView;
    private static final Account ACCOUNTACTIVE = new Account();

    public Account(GoogleSignInAccount account) {
        ACCOUNTACTIVE.setAccount(account);
        ACCOUNTACTIVE.setNameGoogleLogin(account.getDisplayName());
        ACCOUNTACTIVE.setEmailGoogleLogin(account.getEmail());
        ACCOUNTACTIVE.setIdTextView(account.getId());
        ACCOUNTACTIVE.setPhotoGoogleLogin(account.getPhotoUrl());
    }

    public Account() {
    }

    public static Account getCuentaActiva() {
        return ACCOUNTACTIVE;
    }

    public GoogleSignInAccount getAccount() {
        return account;
    }

    public void setAccount(GoogleSignInAccount account) {
        this.account = account;
    }

    public Uri getPhotoGoogleLogin() {
        return photoGoogleLogin;
    }

    public void setPhotoGoogleLogin(Uri photoGoogleLogin) {
        this.photoGoogleLogin = photoGoogleLogin;
    }

    public String getNameGoogleLogin() {
        return nameGoogleLogin;
    }

    public void setNameGoogleLogin(String nameGoogleLogin) {
        this.nameGoogleLogin = nameGoogleLogin;
    }

    public String getEmailGoogleLogin() {
        return emailGoogleLogin;
    }

    public void setEmailGoogleLogin(String emailGoogleLogin) {
        this.emailGoogleLogin = emailGoogleLogin;
    }

    public String getIdTextView() {
        return idTextView;
    }

    public void setIdTextView(String idTextView) {
        this.idTextView = idTextView;
    }

    @Override
    public String toString() {
        return "{" +
                "account=" + account +
                ", photoGoogleLogin=" + photoGoogleLogin +
                ", nameGoogleLogin='" + nameGoogleLogin + '\'' +
                ", emailGoogleLogin='" + emailGoogleLogin + '\'' +
                ", idTextView='" + idTextView + '\'' +
                '}';
    }
}
