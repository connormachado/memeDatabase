package connormachado.projects.memedatabase.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.List;
import java.util.Objects;

import connormachado.projects.memedatabase.Model.Meme;
import connormachado.projects.memedatabase.Model.Playlist;
import connormachado.projects.memedatabase.Model.Profile;
import connormachado.projects.memedatabase.Model.ProfileDatabase;
import connormachado.projects.memedatabase.View.CreatePlaylistFragment;
import connormachado.projects.memedatabase.View.HomeFragment;
import connormachado.projects.memedatabase.View.ICreatePlaylistFragment;
import connormachado.projects.memedatabase.View.IHomeFragment;
import connormachado.projects.memedatabase.View.ILoginFragment;
import connormachado.projects.memedatabase.View.IMainView;
import connormachado.projects.memedatabase.View.ISearchFragment;
import connormachado.projects.memedatabase.View.IViewPlaylistFragment;
import connormachado.projects.memedatabase.View.LoginFragment;
import connormachado.projects.memedatabase.View.MainView;
import connormachado.projects.memedatabase.View.SearchFragment;
import connormachado.projects.memedatabase.View.ViewPlaylistFragment;

public class MainActivity extends AppCompatActivity implements IMainView.Listener, ISearchFragment.Listener, ILoginFragment.Listener, IHomeFragment.Listener, ICreatePlaylistFragment.Listener, IViewPlaylistFragment.Listener {
    private MainView mainView;
    ProfileDatabase profileDatabase = new ProfileDatabase();
    Profile currUser;

    /**
     * Start Code for MainActivity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView = new MainView(this, this);

        mainView.displayFragment(new LoginFragment(this), false, "login");
//        mainView.displayFragment(new SearchFragment(this), false, "login");

        mainView.ignoreButtons();

        setContentView(mainView.getRootView());
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { super.onSaveInstanceState(outState); }

    /** End Code for MainActivity*/

    /*** Start code for changing screens*/
    @Override
    public void displaySearchFragment() {
        mainView.displayFragment(new SearchFragment(this), false, "search");
    }

    @Override
    public void displayHomeFragment(){
        mainView.displayFragment(new HomeFragment(this), false, "home");
    }

//    @Override
//    public void displayPlayFragment(){
//        mainView.displayFragment(new PlayFragment(this), false, "play");
//    }

    @Override
    public void displayCreatePlaylistFragment(){
        mainView.displayFragment(new CreatePlaylistFragment(this), false, "playlist_creation");
    }

    @Override
    public void displayHomeFragmentFCP(String playlistName){
        if (!Objects.equals(playlistName, "null")) {
            currUser.addPlaylist( new Playlist(playlistName) );
        }
        mainView.displayFragment(new HomeFragment(this), false, "playlist_creation");
    }


    /*** Start Code for LogIn Fragment*/

    //Collapses keyboard view
    public void getRidOfKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    //Checks user login when login button is pressed
    public boolean checkLogIn(String username, String password) {
        for (Profile p : profileDatabase.getProfiles()) {
            if (p.toString().equalsIgnoreCase(username)) {
                if (p.checkLogin(username, password)) {
                    mainView.showButtons();
                    currUser = new Profile(username, password);

                    getRidOfKeyBoard();

                    this.mainView.displayFragment(new SearchFragment(this), true, "search");
                    return true;
                }
            }
        }
        return false;
    }


    //Creates an account
    public boolean createUser(String username, String password){
        for (Profile p : profileDatabase.getProfiles()) {
            if (p.toString().equalsIgnoreCase(username)) {
                if (p.checkLogin(username, password)) {
                    return false;
                }
            }
        }

        Profile tempProf = new Profile(username, password);
        currUser = tempProf;
        mainView.showButtons();
        profileDatabase.addProfile( tempProf );

        getRidOfKeyBoard();

        this.mainView.displayFragment(new SearchFragment(this), true, "search");
        return true;
    }

    /*** End Code for LogIn Fragment*/

    /*** Start Code for HomeScreen Fragment*/
    //Get username
    public String getUsersName(){ return currUser.getUsername(); }

    //Get playlists
    public List<Playlist> getUsersPlaylists(){ return currUser.getPlaylists(); }

    //Display a single playlist in a new fragment
    public void displaySinglePlaylist(List<Meme> playlist){
        this.mainView.displayFragment(new ViewPlaylistFragment(this, playlist), true, "search");
    }

}