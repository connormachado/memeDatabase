package connormachado.projects.memedatabase.Model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    String name;
    List<Meme> memes = new ArrayList<>();


    public Playlist(String name){
        this.name = name;
        addMeme( new Meme("fair_enough", "video") );
    }

    public List<Meme> getMemes() { return memes; }

    public String getName() { return name; }

    public void addMeme(Meme m){ memes.add(m); }
}
