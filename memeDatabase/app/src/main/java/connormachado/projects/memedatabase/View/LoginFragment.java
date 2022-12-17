package connormachado.projects.memedatabase.View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Listener for login button
        this.binding.loginButton.setOnClickListener(view1 -> {
            Editable usernameE = LoginFragment.this.binding.usernameInput.getText();
            Editable passwordE = LoginFragment.this.binding.passwordInput.getText();

            if (usernameE != null && passwordE != null) {
                if (! LoginFragment.this.listener.checkLogIn(usernameE.toString(), passwordE.toString())) {
                    LoginFragment.this.binding.logInGate.setText("Incorrect username or password");
                }
            }
        });


        //Listener for create account button
        this.binding.createAccountButton.setOnClickListener(view2 -> {
            Editable usernameE = LoginFragment.this.binding.usernameInput.getText();
            Editable passwordE = LoginFragment.this.binding.passwordInput.getText();
            TextView logInGate = LoginFragment.this.binding.logInGate;

            //Min Username Length: 7
            //Min Password Length: 8
            if (usernameE != null && passwordE != null) {
                if (!(usernameE.length() < 6)) {
                    if(!(passwordE.length() < 7)){
                        if (! LoginFragment.this.listener.createUser(usernameE.toString(), passwordE.toString())){
                            logInGate.setText("Username already taken");
                        }
                    }else{
                        logInGate.setText("Password too short");
                    }
                }else{
                    logInGate.setText("Username too short");
                }
            }else{
                logInGate.setText("Shawty put somthin in damn");
            }
        });
    }
}