package com.besheger.note.ui.new_note;

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

import com.besheger.note.R;
import com.besheger.note.data.view_model.NoteViewModel;
import com.besheger.note.databinding.NewNoteFragmentBinding;
import com.besheger.note.model.NoteResponse;
import com.besheger.note.model.UserNote;
import com.besheger.note.utils.NoteDetailUsers;
import com.thebluealliance.spectrum.SpectrumDialog;

import jp.wasabeef.richeditor.RichEditor;
import top.defaults.colorpicker.ColorPickerPopup;

public class NewNoteFragment extends Fragment {

    private NewNoteViewModel mViewModel;
    private RichEditor mEditor;
    private TextView mPreview;
    private View mColorPreview;
    private int mDefaultColor;
    private NewNoteFragmentBinding binding;
    public static NewNoteFragment newInstance() {
        return new NewNoteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= NewNoteFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mEditor = (RichEditor) root.findViewById(R.id.editor);
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(22);
        mEditor.setEditorFontColor(Color.BLACK);
        mEditor.setBackgroundResource(R.drawable.bg);
        mEditor.setPadding(10, 10, 10, 10);
        mEditor.setPlaceholder("Insert text here...");
        try {

            root.findViewById(R.id.action_undo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mEditor.undo();
                }
            });

            root.findViewById(R.id.action_redo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mEditor.redo();
                }
            });
            root.findViewById(R.id.action_insert_numbers).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mEditor.setNumbers();
                    //  mEditor.setTextColor(0xFFEEAAFF);
                }
            });
            root.findViewById(R.id.action_insert_bullets).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mEditor.setBullets();
                    //  mEditor.setTextColor(0xFFEEAAFF);
                }
            });


//            root.findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setBold();
//                }
//            });
//
//
//            root.findViewById(R.id.action_italic).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setItalic();
//                }
//            });
//
//            root.findViewById(R.id.action_subscript).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setSubscript();
//                }
//            });
//            root.findViewById(R.id.action_strikethrough).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setStrikeThrough();
//                }
//            });
//
//            root.findViewById(R.id.action_superscript).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setSuperscript();
//                }
//            });
//
//            root.findViewById(R.id.action_underline).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setUnderline();
//                }
//            });
//            root.findViewById(R.id.action_heading1).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setHeading(1);
//                    mEditor.setTextColor(0xFFEEAAFF);
//                }
//            });
//
//            root.findViewById(R.id.action_heading2).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setHeading(2);
//                }
//            });
//            root.findViewById(R.id.action_heading3).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setHeading(3);
//                }
//            });
//            root.findViewById(R.id.action_heading4).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setHeading(4);
//                }
//            });
//            root.findViewById(R.id.action_heading5).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setHeading(5);
//                }
//            });
//            root.findViewById(R.id.action_heading6).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mEditor.setHeading(6);
//                }
//            });

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
                            .show(v, new ColorPickerPopup.ColorPickerObserver() {
                                @Override
                                public void
                                onColorPicked(int color) {
                                    mDefaultColor = color;
                                    mEditor.setTextColor(mDefaultColor);
                                }
                            });


                }
            });


            root.findViewById(R.id.action_save).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    try {
                        NoteViewModel noteViewModel = new ViewModelProvider
                                .AndroidViewModelFactory(getActivity().getApplication())
                                .create(NoteViewModel.class);

                        UserNote userNote = new UserNote();
                        userNote.setNoteId(1);
                        userNote.setNoteCat(1);
                        userNote.setNoteType(1);
                        userNote.setUserId(1);
                        userNote.setNoteSubject("Maths");

                        userNote.setNoteTitle("From Mobile");
                        userNote.setNoteSection("Bulding LayOut");
                        userNote.setNoteBody(mEditor.getHtml());
                        userNote.setDateCreated("2020/12/21");


                        noteViewModel.newNote(userNote);

                        noteViewModel.getNoteResponse().observe(getActivity(), new Observer<NoteResponse>() {
                            @Override
                            public void onChanged(NoteResponse noteResponse) {
                                Toast.makeText(getActivity(), "Response" + noteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                    } catch (Exception e) {
                        Toast.makeText(root.getContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();


                    }


                }
            });

        }catch (Exception e){

        }

        return root;
    }




}