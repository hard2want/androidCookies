package com.example.persistence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText number01, number02, operator;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create an outlet from your view's text field input to the controller
        number01 = (EditText) findViewById(R.id.number01);
        number02 = (EditText) findViewById(R.id.number02);
        operator = (EditText) findViewById(R.id.operator);

        // create an outlet from your view's button to the controller
        button = (Button) findViewById(R.id.inputButton);

        // how we push and pull cookies
        final SharedPreferences sharePreference = PreferenceManager.getDefaultSharedPreferences(this);

        // create a listener for the button click within onCreate
        button.setOnClickListener(new View.OnClickListener()
          {
              @Override
              public void onClick(View view){
                  // this captures the user input and stores the value in a cookie using a key/value pair
                  String inputNumber01 = number01.getText().toString();
                  String inputNumber02 = number02.getText().toString();
                  String operation = operator.getText().toString();
                  SharedPreferences.Editor editor = sharePreference.edit();
                  editor.putString("number01", inputNumber01);
                  editor.putString("number02", inputNumber02);
                  editor.putString("operation", operation);
                  editor.commit();

                  // after you commit the cookie, start the next activity to load your next view
                  startActivity(new Intent(MainActivity.this, ResultActivity.class));
              } // end onClick()
          } // end @Override
        ); // end buton.setOnClickListener()
    } // end onCreate()
} // end MainActivity {}
