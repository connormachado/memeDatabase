package connormachado.projects.memedatabase.View;

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

import connormachado.projects.memedatabase.Model.Meme;
import connormachado.projects.memedatabase.Model.Playlist;
import connormachado.projects.memedatabase.databinding.FragmentViewPlaylistBinding;


public class ViewPlaylistFragment extends Fragment implements IViewPlaylistFragment{
    FragmentViewPlaylistBinding binding;
    Listener listener;
    List<Meme> playlist;


    public ViewPlaylistFragment(Listener listener, List<Meme> playlist){
        this.listener = listener;
        this.playlist = playlist;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentViewPlaylistBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateSinglePlaylistDisplay();
    }

    public void updateSinglePlaylistDisplay() {
        TableLayout tl = ViewPlaylistFragment.this.binding.singlePlaylistViewTableLayout;
        tl.removeAllViews();

        for (Meme x : playlist) {
            TableRow row = new TableRow(ViewPlaylistFragment.this.getContext());
            Button play = new Button(ViewPlaylistFragment.this.getContext());
            Button queue = new Button(ViewPlaylistFragment.this.getContext());
            Button view = new Button(ViewPlaylistFragment.this.getContext());


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
//            //Adds listener to view button
//            view.setOnClickListener(v -> HomeFragment.this.listener.displaySinglePlaylist(x));
        }
    }

}