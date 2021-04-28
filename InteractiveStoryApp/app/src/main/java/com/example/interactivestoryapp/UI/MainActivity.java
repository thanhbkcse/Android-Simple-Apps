package com.example.interactivestoryapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.interactivestoryapp.R;

public class MainActivity extends AppCompatActivity {
    private EditText startName;
    private Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            startName  = (EditText)findViewById(R.id.getNameText);
            startButton = (Button)findViewById(R.id.startButton);
            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = startName.getText().toString();
                    //Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                    startStory(name);
                }
            });

    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startName.setText("");
    }
}