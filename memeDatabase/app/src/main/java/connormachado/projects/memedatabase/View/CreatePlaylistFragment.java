package connormachado.projects.memedatabase.View;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import connormachado.projects.memedatabase.R;
import connormachado.projects.memedatabase.databinding.FragmentCreatePlaylistBinding;
import connormachado.projects.memedatabase.databinding.FragmentHomeBinding;

public class CreatePlaylistFragment extends Fragment implements ICreatePlaylistFragment{
    FragmentCreatePlaylistBinding binding;
    Listener listener;

    public CreatePlaylistFragment(Listener listener){ this.listener = listener; }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentCreatePlaylistBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //Listener for cancel create playlist button
        this.binding.cancelPlaylistCreate.setOnClickListener(view1 -> {
            CreatePlaylistFragment.this.listener.displayHomeFragmentFCP("null");
        });


        //Listener for create playlist button
        this.binding.createPlaylistWithName.setOnClickListener(view1 -> {
            Editable playlistName = this.binding.createPlaylistNameInput.getText();

            if(! (playlistName.toString().length() < 1)){
                CreatePlaylistFragment.this.listener.displayHomeFragmentFCP(playlistName.toString());
            } else{
                this.binding.createPlaylistOutput.setText(String.format("%s", "Enter in a playlist name"));
            }

        });
    }
}