package connormachado.projects.memedatabase.View;

import android.view.View;

import androidx.fragment.app.Fragment;

public interface IMainView {
    View getRootView();

    void ignoreButtons();
    void showButtons();

    void displayFragment(Fragment fragment, boolean allowBack, String name);
    interface Listener{
        void displaySearchFragment();
        void displayHomeFragment();
        void displayCreatePlaylistFragment();
//        void displayPlayFragment();
    }
}
