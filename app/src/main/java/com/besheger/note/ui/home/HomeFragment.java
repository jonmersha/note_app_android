package com.besheger.note.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.besheger.note.data.repository.local.Note;
import com.besheger.note.data.view_model.NoteViewModel;
import com.besheger.note.data.view_model.NoteViewModelLocal;
import com.besheger.note.ui.adapter.NoteAdapter;
import com.besheger.note.R;
import com.besheger.note.databinding.FragmentHomeBinding;
import com.besheger.note.model.UserNote;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;

    private NoteViewModelLocal noteViewModel;

    NoteAdapter noteAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView=root.findViewById(R.id.note_list);
        layoutManager = new LinearLayoutManager(getActivity());
        noteViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getActivity().getApplication())
                .create(NoteViewModelLocal.class);

        noteViewModel.getAllNote().observe(getActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> Notes) {
                noteAdapter=new NoteAdapter(Notes);
                recyclerView.setAdapter(noteAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}