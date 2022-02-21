package com.besheger.note.ui.new_note;

import androidx.annotation.ColorInt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.besheger.note.R;
import com.besheger.note.data.repository.local.Note;
import com.besheger.note.data.view_model.NoteViewModel;
import com.besheger.note.data.view_model.NoteViewModelLocal;
import com.besheger.note.databinding.NewNoteFragmentBinding;
import com.besheger.note.model.NoteResponse;
import com.besheger.note.model.UserNote;
import com.besheger.note.utils.NoteDetailUsers;

import com.thebluealliance.spectrum.SpectrumDialog;

import jp.wasabeef.richeditor.RichEditor;
import top.defaults.colorpicker.ColorPickerPopup;

public class NewNoteFragment extends Fragment {

    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    private NewNoteViewModel mViewModel;
    private RichEditor mEditor;
    private TextView mPreview;
    private View mColorPreview;
    private int mDefaultColor;
    private NewNoteFragmentBinding binding;
    private ImageButton bold;
    private boolean isbold=false;
    public static NewNoteFragment newInstance() {
        return new NewNoteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= NewNoteFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bold=root.findViewById(R.id.action_bold);

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


            root.findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mEditor.setBold();
                    if(isbold)
                        bold.setBackgroundColor(Color.BLACK);
                    else
                    bold.setBackgroundColor(Color.BLUE);
                    isbold=!isbold;
                    
                }
            });

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


            root.findViewById(R.id.action_insert_image).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);

                    startActivityForResult(gallery, PICK_IMAGE);

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
                        NoteViewModelLocal noteViewModel = new ViewModelProvider
                                .AndroidViewModelFactory(getActivity().getApplication())
                                .create(NoteViewModelLocal.class);

                        Note note=new Note();
                        note.setCreatorID(1);
                        note.setNoteCategory("My note Cat");
                        note.setNoteBody(mEditor.getHtml());
                        note.setNoteTitle("MyNote Title");
                        note.setDateCreated("2020/12/21");
                        note.setCreatorID(1);

                        noteViewModel.registerNote(note);

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