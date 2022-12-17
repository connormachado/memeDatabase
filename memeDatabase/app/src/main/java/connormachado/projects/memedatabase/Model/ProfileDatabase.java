package connormachado.projects.memedatabase.Model;

import java.util.ArrayList;
import java.util.List;

public class ProfileDatabase {
    List<Profile> profiles = new <Profile>ArrayList<Profile>();

    public ProfileDatabase(){
        profiles.add(new Profile("connor", "123456789"));
        profiles.add(new Profile("e","e"));
    }


    public void addProfile (Profile p){
        profiles.add(p);
    }

    public List<Profile> getProfiles (){
        return profiles;
    }
}