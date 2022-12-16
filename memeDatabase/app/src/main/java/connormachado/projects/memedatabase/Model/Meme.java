package connormachado.projects.memedatabase.Model;

import java.util.List;

public class Meme {
    String name;
    String type;
    List<String> tags;

    public Meme(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<String> getTags() {
        return tags;
    }
}