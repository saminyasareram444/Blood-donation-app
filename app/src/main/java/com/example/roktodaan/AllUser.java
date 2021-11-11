package com.example.roktodaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllUser extends AppCompatActivity {

    ListView ListViewUsers;
    UserList userList;
    private List<User> arrayList;
    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);


        databaseUser = FirebaseDatabase.getInstance().getReference("User");
        ListViewUsers = findViewById(R.id.listViewUsers);
        arrayList=new ArrayList<>();
        userList = new UserList(AllUser.this,arrayList);


    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);

                    arrayList.add(user);

                }

                ListViewUsers.setAdapter(userList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
