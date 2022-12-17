package connormachado.projects.memedatabase.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import connormachado.projects.memedatabase.Model.Profile;
import connormachado.projects.memedatabase.Model.ProfileDatabase;
import connormachado.projects.memedatabase.View.ILoginFragment;
import connormachado.projects.memedatabase.View.IMainView;
import connormachado.projects.memedatabase.View.ISearchFragment;
import connormachado.projects.memedatabase.View.LoginFragment;
import connormachado.projects.memedatabase.View.MainView;
import connormachado.projects.memedatabase.View.SearchFragment;

public class MainActivity extends AppCompatActivity implements IMainView.Listener, ISearchFragment.Listener, ILoginFragment.Listener {
    private MainView mainView;
    ProfileDatabase profileDatabase = new ProfileDatabase();

    /**
     * Start Code for MainActivity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView = new MainView(this, this);

        mainView.displayFragment(new LoginFragment(this), false, "login");

        setContentView(mainView.getRootView());
    }

    @Override
    public void displaySearchFragment() {
        mainView.displayFragment(new SearchFragment(this), false, "search");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { super.onSaveInstanceState(outState); }

    /** End Code for MainActivity*/

    /*** Start Code for LogIn Fragment*/
    public boolean checkLogIn(String username, String password) {
        for (Profile p : profileDatabase.getProfiles()) {
            if (p.toString().equalsIgnoreCase(username)) {
                if (p.checkLogin(username, password)) {
                    this.mainView.displayFragment(new SearchFragment(this), true, "search");
                    return true;
                }
            }
        }
        return false;
    }

}