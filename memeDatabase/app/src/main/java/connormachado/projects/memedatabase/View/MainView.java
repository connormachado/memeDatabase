package connormachado.projects.memedatabase.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import connormachado.projects.memedatabase.Controller.MainActivity;
import connormachado.projects.memedatabase.databinding.ActivityMainBinding;

public class MainView extends Fragment implements IMainView {
    FragmentManager fmanager;
    ActivityMainBinding binding;
    MainActivity mainActivity;

    public MainView(FragmentActivity activity, MainActivity mainActivity) {
        this.fmanager = activity.getSupportFragmentManager();
        this.binding = ActivityMainBinding.inflate(activity.getLayoutInflater());
        this.mainActivity = mainActivity;

        this.binding.toSearchButton.setOnClickListener(view -> MainView.this.mainActivity.displaySearchFragment());

        this.binding.toHomeButton.setOnClickListener(view -> MainView.this.mainActivity.displayHomeFragment());

//        this.binding.toPlayButton.setOnClickListener(view -> MainView.this.mainActivity.displayPlayFragment());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ActivityMainBinding.inflate(inflater);
        return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public View getRootView() { return this.binding.getRoot(); }


    @Override
    public void displayFragment(Fragment fragment, boolean allowBack, String name) {
        FragmentTransaction ft = this.fmanager.beginTransaction();

        ft.replace(this.binding.fragmentContainerView.getId(), fragment);
        if (allowBack) {
            ft.addToBackStack(name);
        }
        ft.commit();
    }

    public void ignoreButtons(){
        this.binding.toSearchButton.setVisibility(View.INVISIBLE);
        this.binding.toHomeButton.setVisibility(View.INVISIBLE);
        this.binding.toPlayButton.setVisibility(View.INVISIBLE);
    }

    public void showButtons(){
        this.binding.toSearchButton.setVisibility(View.VISIBLE);
        this.binding.toHomeButton.setVisibility(View.VISIBLE);
        this.binding.toPlayButton.setVisibility(View.VISIBLE);
    }
}



