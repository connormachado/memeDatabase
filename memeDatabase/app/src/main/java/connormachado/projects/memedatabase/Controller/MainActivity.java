package connormachado.projects.memedatabase.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import connormachado.projects.memedatabase.View.IMainView;
import connormachado.projects.memedatabase.View.ISearchFragment;
import connormachado.projects.memedatabase.View.MainView;
import connormachado.projects.memedatabase.View.SearchFragment;

public class MainActivity extends AppCompatActivity implements IMainView.Listener, ISearchFragment.Listener {
    private MainView mainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView = new MainView(this, this);

        mainView.displayFragment(new SearchFragment(this), false, "login");

        setContentView(mainView.getRootView());
    }

    @Override
    public void displaySearchFragment() {
        mainView.displayFragment(new SearchFragment(this), false, "search");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { super.onSaveInstanceState(outState); }
}