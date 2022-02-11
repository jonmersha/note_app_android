package com.besheger.note.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.besheger.note.R;

import com.besheger.note.model.UserNote;
import com.besheger.note.utils.NoteDetailUsers;

import org.jetbrains.annotations.NotNull;
import java.util.List;
import jp.wasabeef.richeditor.RichEditor;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
private List<UserNote> noteList;

    public NoteAdapter(List<UserNote> noteList) {
        this.noteList = noteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull NoteAdapter.ViewHolder holder, int position) {
        holder.note=noteList.get(position);
        holder.title.setHtml("<h3>"+noteList.get(position).getNoteTitle()+"</h3>");
        holder.detail.setText(holder.note.getNoteBody().replaceAll("\\<.*?\\>", "").substring(0,60)+"  .   .  .  . \n Tap for More");

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteDetailUsers.userDetail=holder.note;
               Navigation.findNavController(v).navigate(R.id.note_detail,null,null,null);

            }
        });

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private UserNote note;
        private  RichEditor title;
        private TextView detail;
        private Button button;
        private CardView cardView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.note_card);
           // cardView.setBackgroundResource(R.drawable.bg);
            title=itemView.findViewById(R.id.title);
            title.setInputEnabled(false);
            detail=itemView.findViewById(R.id.detail);
            //detail.setBackgroundColor(0x00ffffff);
            title.setBackgroundColor(0x00ffffff);
           // detail.setInputEnabled(false);

           // button=itemView.findViewById(R.id.okb);
           // detail.setPadding(5,0,5,5);
        }
    }
}
