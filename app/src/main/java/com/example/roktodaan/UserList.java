package com.example.roktodaan;

import android.app.Activity;
import android.icu.text.Transliterator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserList extends ArrayAdapter<User> {

    private Activity context;
    private List<User>userList;

    public UserList(Activity context,List<User>userList)
    {
        super(context,R.layout.list_layout,userList);
        this.context=context;
        this.userList=userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewN = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewC = (TextView) listViewItem.findViewById(R.id.textViewContact);
        TextView textViewB = (TextView) listViewItem.findViewById(R.id.textViewbloodgroup);

        User user = userList.get(position);

        textViewN.setText(user.getName());
        textViewC.setText(user.getContact());
        textViewB.setText(user.getBloodgroup());

        return listViewItem;

    }
}
