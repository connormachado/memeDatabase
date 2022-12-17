package connormachado.projects.memedatabase.View;

import java.util.List;

import connormachado.projects.memedatabase.Model.Meme;
import connormachado.projects.memedatabase.Model.Playlist;

public interface IHomeFragment {
    interface Listener{
        String getUsersName();
        void displayHomeFragment();
        void displayCreatePlaylistFragment();
        List<Playlist> getUsersPlaylists();
        void displaySinglePlaylist(List<Meme> x);
    }
}