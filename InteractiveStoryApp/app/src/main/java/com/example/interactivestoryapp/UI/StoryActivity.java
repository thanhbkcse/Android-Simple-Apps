package com.example.interactivestoryapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interactivestoryapp.Model.Page;
import com.example.interactivestoryapp.Model.Story;
import com.example.interactivestoryapp.R;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private   String name;
    private Button Choice1Buttonl;
    private Button Choice1Button2;
    private Stack<Integer> stackPage = new Stack<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        if (name == null || name.isEmpty()){
            name = "Friend";
        }
        Log.d(TAG,name);
        storyTextView = (TextView)findViewById(R.id.storyTextView);
        Choice1Buttonl = (Button)findViewById(R.id.choice1Button);
        Choice1Button2 = (Button)findViewById(R.id.choice2Button);
        storyImageView = (ImageView)findViewById(R.id.storyImageView);
        story = new Story();
        LoadPage(0);
    }

    private void LoadPage(int PageNumber) {
        stackPage.push(PageNumber);
        final Page page = story.getPage(PageNumber);
        Drawable image = ContextCompat.getDrawable(this,page.getImgaeId());
        storyImageView.setImageDrawable(image);
        String PageText = getString(page.getTextId());
        PageText = String.format(PageText,name);
        storyTextView.setText(PageText);
        if (page.isFinalPage()){
            Choice1Buttonl.setVisibility(View.INVISIBLE);
            Choice1Button2.setText("PLAY AGAIN");
            Choice1Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LoadPage(0);
                }
            });
        }
        else{
            LoadButton(page);
        }

    }

    private void LoadButton(Page page) {
        Choice1Buttonl.setVisibility(View.VISIBLE);
        Choice1Buttonl.setText(page.getChoice1().
                getTextId());
        Choice1Button2.setText(page.getChoice2().getTextId());
        Choice1Buttonl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadPage(page.getChoice1().getNextPage());
            }
        });
        Choice1Button2.setVisibility(View.VISIBLE);
        Choice1Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadPage(page.getChoice2().getNextPage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        stackPage.pop();
        if (stackPage.isEmpty()){
            super.onBackPressed();
        }
        else{
            LoadPage(stackPage.pop());
        }
    }
}