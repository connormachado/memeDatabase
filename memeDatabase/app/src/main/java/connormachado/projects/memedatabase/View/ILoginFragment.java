package connormachado.projects.memedatabase.View;

public interface ILoginFragment {
    interface Listener{
        boolean checkLogIn(String username, String password);
        boolean createUser(String username, String password);
    }
}