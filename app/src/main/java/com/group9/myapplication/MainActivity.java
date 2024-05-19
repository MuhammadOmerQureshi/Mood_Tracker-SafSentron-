package com.group9.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();


        Button happyButton = findViewById(R.id.button4);
        happyButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                saveResponseToFirebase("HAPPY");
                displayPopupMessage("HAPPY, YAY!");

            }
        });


        Button neutralButton = findViewById(R.id.button);
        neutralButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                saveResponseToFirebase("Neutral");
                displayPopupMessage("Neutral ");

            }
        });

        Button crazyButton = findViewById(R.id.button3);
<<<<<<<<< Temporary merge branch 1
=========
        crazyButton.setText("\uD83E\uDD2A");
>>>>>>>>> Temporary merge branch 2
        crazyButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                saveResponseToFirebase("Excited");
                displayPopupMessage("Lets Exercise ");
            }
        });

        Button sadButton = findViewById(R.id.button2);
        sadButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                saveResponseToFirebase("Sad");
<<<<<<<<< Temporary merge branch 1
                displayPopupMessage("Grandma :heart_eyes: you, Call Grandma! ");
=========
                displayPopupMessage("Grandma \u2764\uFE0F you, Call Grandma! ");
>>>>>>>>> Temporary merge branch 2

            }
        });


        Button angryButton = findViewById(R.id.button5);
<<<<<<<<< Temporary merge branch 1
=========
        angryButton.setText("\uD83D\uDE21");
>>>>>>>>> Temporary merge branch 2
        angryButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                saveResponseToFirebase("Angry");
                displayPopupMessage("Do you want to drink MILK or Water ");

            }
        });
    }
    private void saveResponseToFirebase(String response) {
        // Save response to Firebase database
        String key = mDatabase.child("responses").push().getKey();
        mDatabase.child("responses").child(key).setValue(response);
    }
    private void displayPopupMessage(String message) {
        // Display popup message using Toast
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}