package connormachado.projects.memedatabase;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView {
    View getRootView();

    void displayFragment(Fragment fragment, boolean allowBack, String name);
    interface Listener{
        void displaySearchFragment();
    }
}
