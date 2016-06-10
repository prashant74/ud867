package com.example.prashant.myandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke);
    Intent intent = getIntent();
    String joke = null;
    if (intent != null) {
      joke = intent.getStringExtra("JOKE");
    }
    TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);
    jokeTextView.setText(joke);
  }
}
