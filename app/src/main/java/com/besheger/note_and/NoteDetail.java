package com.besheger.note_and;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.besheger.note_and.data.view_model.NoteViewModel;
import com.besheger.note_and.databinding.NewNoteFragmentBinding;
import com.besheger.note_and.databinding.NoteDetailFragmentBinding;
import com.besheger.note_and.model.NoteResponse;
import com.besheger.note_and.model.UserNote;
import com.besheger.note_and.ui.new_note.NewNoteViewModel;
import com.besheger.note_and.utils.NoteDetailUsers;

import jp.wasabeef.richeditor.RichEditor;
import top.defaults.colorpicker.ColorPickerPopup;

public class NoteDetail extends Fragment {

    private NewNoteViewModel mViewModel;
    private RichEditor mEditor;
    private TextView mPreview;
    private View mColorPreview;
    private int mDefaultColor;
    private NoteDetailFragmentBinding binding;

   // TextView textView;
    public static NoteDetail newInstance() {
        return new NoteDetail();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= NoteDetailFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mEditor = (RichEditor) root.findViewById(R.id.editor);
        //mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(22);
        mEditor.setEditorFontColor(Color.BLACK);
        mEditor.setBackgroundResource(R.drawable.bg);
        mEditor.setPadding(10, 10, 10, 10);
        mEditor.setInputEnabled(false);
        mEditor.setHtml(NoteDetailUsers.userDetail.getNoteBody());

        root.findViewById(R.id.action_undo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.undo();
            }
        });
        root. findViewById(R.id.action_redo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.redo();
            }
        });
        root.findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setBold();
            }
        });
        root.findViewById(R.id.action_italic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setItalic();
            }
        });
        root.findViewById(R.id.action_subscript).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setSubscript();
            }
        });
        root.findViewById(R.id.action_superscript).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setSuperscript();
            }
        });
        root.findViewById(R.id.action_strikethrough).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setStrikeThrough();
            }
        });
        root.findViewById(R.id.action_underline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setUnderline();
            }
        });
        root.findViewById(R.id.action_heading1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(1);
                mEditor.setTextColor(0xFFEEAAFF);
            }
        });
        root. findViewById(R.id.action_heading2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(2);
            }
        });
        root.findViewById(R.id.action_heading3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(3);
            }
        });
        root.findViewById(R.id.action_heading4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(4);
            }
        });
        root.findViewById(R.id.action_heading5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(5);
            }
        });
        root.findViewById(R.id.action_heading6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(6);
            }
        });
        root.findViewById(R.id.action_txt_color).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new ColorPickerPopup.Builder(getContext())
                        .initialColor(Color.BLACK)
                        .enableBrightness(false)
                        .enableAlpha(false) // enable color alpha
                        .okTitle("Choose").
                        onlyUpdateOnTouchEventUp(true) // this is top right
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v,new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void
                            onColorPicked(int color) {
                                mDefaultColor = color;
                                mEditor.setTextColor(mDefaultColor);
                            }
                        });
            }
        });
        root.findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Editing Mode Enabled", Toast.LENGTH_SHORT).show();
                mEditor.setInputEnabled(true);
            }
        });
        root.findViewById(R.id.action_update).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 NoteViewModel  noteViewModel=new ViewModelProvider
                        .AndroidViewModelFactory(getActivity().getApplication())
                        .create(NoteViewModel.class);
                UserNote userNote=NoteDetailUsers.userDetail;
                userNote.setNoteBody(mEditor.getHtml());
                noteViewModel.updateNote(userNote);
                noteViewModel.getNoteResponse().observe(getActivity(), new Observer<NoteResponse>() {
                    @Override
                    public void onChanged(NoteResponse noteResponse) {
                        Toast.makeText(getActivity(), noteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        return root;
    }



}