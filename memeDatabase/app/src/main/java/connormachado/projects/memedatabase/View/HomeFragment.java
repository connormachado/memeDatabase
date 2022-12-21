package connormachado.projects.memedatabase.View;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.List;

import connormachado.projects.memedatabase.Model.Playlist;
import connormachado.projects.memedatabase.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment implements IHomeFragment{
    FragmentHomeBinding binding;
    Listener listener;

    public HomeFragment(Listener listener){ this.listener = listener; }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentHomeBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void updatePlaylistDisplay() {
        TableLayout tl = HomeFragment.this.binding.dynamicPlaylistLayout;
        tl.removeAllViews();

        //Gets all the playlist data from current user
        List<Playlist> newPlaylists = HomeFragment.this.listener.getUsersPlaylists();

        for (Playlist x : newPlaylists) {
            TableRow row = new TableRow(HomeFragment.this.getContext());
            Button play = new Button(HomeFragment.this.getContext());
            Button queue = new Button(HomeFragment.this.getContext());
            Button view = new Button(HomeFragment.this.getContext());


            play.setText(String.format("%s", x.getName()));
            queue.setText(String.format("%s", "Add to Queue"));
            view.setText(String.format("%s", "View"));

            row.addView(play);
            row.addView(queue);
            row.addView(view);

            tl.addView(row);

            //Effectively Centers the table row
            tl.setStretchAllColumns(true);

//            //Adds listener to Play button
//            play.setOnClickListener(v -> HomeFragment.this.listener.displayPlayFromSearch(x));
//
//            //Adds listener to Queue button
//            queue.setOnClickListener(v -> HomeFragment.this.listener.addSongToQueue(x));
//
            //Adds listener to view button
            view.setOnClickListener(v -> HomeFragment.this.listener.displaySinglePlaylist(x.getMemes()));
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String newTitleText = "Welcome fellow MemeLord " + HomeFragment.this.listener.getUsersName() + "!";
//        String newTitleText = "Welcome Connor!";
        this.binding.homeScreenTitle.setText( newTitleText );


        //Listener for create playlist button
        this.binding.toCreatePlaylistScreen.setOnClickListener(view1 -> {
            HomeFragment.this.listener.displayCreatePlaylistFragment();
        });

        updatePlaylistDisplay();
    }
}