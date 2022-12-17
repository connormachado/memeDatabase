package connormachado.projects.memedatabase.Model;

import androidx.annotation.NonNull;

/**
 * Provides a way to represent a user through a profile
 * Each profile will be constructed with a username and password
 */
public class Profile {
    String username;
    String password;

    /**
     * Provides a way to make a profile with all contained information
     * @param username The name the user wants the profile to have
     * @param password The password the user wants the profile to have
     */
    public Profile (String username, String password){
        this.username = username;
        this.password = password;
    }


    /**
     * Constructor of Profile
     */
    public  Profile (){}


    /**
     * Provides a method to get the username of the current profile
     * @return String Returns the string representation of the username
     */
    public String getUsernameText(){
        return this.username;
    }


    /**
     * Provides a method to get the password of the current profile
     * @return String Returns the string representation of the password
     */
    public String getPassword(){
        return this.password;
    }


    /**
     * Provides a method of checking if the username and password matches profiles username and password
     * @param username The usernames' name to be checked against the profiles username
     * @param password The usernames' password to be checked against the profiles password
     * @return boolean
     */
    public boolean checkLogin(String username, String password){
        return this.username.equalsIgnoreCase(username) && this.password.equals(password) ;
    }


    /**
     * Provides a way to get the string representation of the username
     * @return String Returns the username as a string
     */
    @NonNull
    public String toString(){
        return "" + this.username;
    }
}