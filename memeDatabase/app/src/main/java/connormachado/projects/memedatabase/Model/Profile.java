package connormachado.projects.memedatabase.Model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


public class Profile {
    String username;
    String password;
    List<Playlist> playlists = new ArrayList<Playlist>();


    public Profile (String username, String password){
        this.username = username;
        this.password = password;
        addPlaylist(new Playlist("Liked Memes"));
    }


    public String getUsername(){ return this.username; }


    public String getPassword(){ return this.password; }


    public boolean checkLogin(String username, String password){
        return this.username.equalsIgnoreCase(username) && this.password.equals(password) ;
    }

    public void addPlaylist(Playlist pl){ playlists.add(pl); }


    @NonNull
    public String toString(){ return "" + this.username; }

    public List<Playlist> getPlaylists(){ return this.playlists; }
}