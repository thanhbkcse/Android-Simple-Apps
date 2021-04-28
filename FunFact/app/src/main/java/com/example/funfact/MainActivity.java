package com.example.funfact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Declare
    private TextView factTextView;
    private Button showButton;
    private FactorBook factorBook = new FactorBook();
    private RelativeLayout relativeLayout ;
    private ColorWheel colorWheel = new ColorWheel();
    public static final String TAG = MainActivity.class.getSimpleName();
    private boolean check = false;
    private boolean red = false;
    private boolean blue = false;
    private boolean green = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        factTextView = (TextView) findViewById(R.id.factTextView);
        showButton = (Button) findViewById(R.id.showFactButton);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String fact = factorBook.getFacts();
//                factTextView.setText(fact);
//                int color = colorWheel.getColor();
//                relativeLayout.setBackgroundColor(color);
//                showButton.setTextColor(color);
                Intent intent = new Intent(MainActivity.this,TestRecyclerView.class);
                startActivity(intent);
            }
        };
        showButton.setOnClickListener(listener);
        Toast.makeText(this, "Hello, Welcome to my channel!", Toast.LENGTH_SHORT).show();
        //Log.d(TAG,"We are logging in mainactivity");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionm_menu,menu);
        Drawable nextImgae = menu.findItem(R.id.nextImage).getIcon();
        nextImgae.setColorFilter(Color.WHITE,PorterDuff.Mode.SRC_ATOP);
        menu.findItem(R.id.red).setChecked(red);
        menu.findItem(R.id.blue).setChecked(blue);
        menu.findItem(R.id.green).setChecked(green);
        menu.setGroupVisible(R.id.groupColor,check);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nextImage){
            check =!check;
            invalidateOptionsMenu();
        }
        if (item.getItemId() == R.id.red){
            operate();
            red=!red;
            item.setChecked(red);
        }
        if (item.getItemId() == R.id.blue){
            blue=!blue;
            operate();
            item.setChecked(blue);
        }
        if (item.getItemId() == R.id.green){
            green=!green;
            operate();
            item.setChecked(green);
        }

        if (item.getItemId()==R.id.reset){
            red = blue = green = check = true;
            invalidateOptionsMenu();
        }
        return super.onOptionsItemSelected(item);
    }

    private void operate(){
        String fact = factorBook.getFacts();
        factTextView.setText(fact);
        int color = colorWheel.getColor();
        relativeLayout.setBackgroundColor(color);
        showButton.setTextColor(color);
    }
}