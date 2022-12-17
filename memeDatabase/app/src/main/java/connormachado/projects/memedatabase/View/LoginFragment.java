package connormachado.projects.memedatabase.View;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import connormachado.projects.memedatabase.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment implements ILoginFragment {
    FragmentLoginBinding binding;
    Listener listener;


    public LoginFragment(Listener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentLoginBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.binding.loginButton.setOnClickListener(view1 -> {
            Editable usernameE = LoginFragment.this.binding.usernameInput.getText();
            Editable passwordE = LoginFragment.this.binding.passwordInput.getText();

            LoginFragment.this.listener.checkLogIn(usernameE.toString(), passwordE.toString());
        });
    }
}