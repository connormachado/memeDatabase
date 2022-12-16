package connormachado.projects.memedatabase;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import connormachado.projects.memedatabase.databinding.FragmentSearchBinding;


public class SearchFragment extends Fragment implements ISearchFragment {
    FragmentSearchBinding binding;
    Listener listener;

    public SearchFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentSearchBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        this.binding.searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //extract searchText
//                Editable searchTextE = SearchFragment.this.binding.searchText.getText();
//                String searchText = searchTextE.toString();
//
//                //extract radio buttons checked
//                boolean songChoiceBool = SearchFragment.this.binding.songChoiceButtonId.isChecked();
//                boolean artistChoiceBool = SearchFragment.this.binding.artistChoiceButtonId.isChecked();
//
//                //delegate this to controller
//                SearchFragment.this.listener.searchSongDatabase(searchText, songChoiceBool, artistChoiceBool, SearchFragment.this);
//
//                //clears search
//                searchTextE.clear();
//
//            }
//        });
    }

    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }
}