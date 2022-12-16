package connormachado.projects.memedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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