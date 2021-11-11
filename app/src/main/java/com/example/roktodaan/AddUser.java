package com.example.roktodaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddUser extends AppCompatActivity {
    EditText Name,Contact;
    Button addUser;
    Spinner bloodgroup;

    DatabaseReference databaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Name = findViewById(R.id.editTextName);
        Contact=findViewById(R.id.editTextContact);
        bloodgroup=findViewById(R.id.spinnerBloodgroup);
        addUser = findViewById(R.id.AddUser);
        databaseUser = FirebaseDatabase.getInstance().getReference("User");

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsers();
            }
        });


    }
    private void addUsers(){
        String name = Name.getText().toString().trim();
        String contact = Contact.getText().toString().trim();
        String spinner = bloodgroup.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(contact))
        {
            String key = databaseUser.push().getKey();
            User user = new User(key , name, contact, spinner);

            databaseUser.child(key).setValue(user);
            Toast.makeText(this,"Added User",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Invalid input",Toast.LENGTH_LONG).show();
        }
        Name.setText("");
        Contact.setText("");


    }
}
