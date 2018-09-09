package com.example.jordan.beautifulbulldog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BulldogListActivity extends AppCompatActivity {

    private TextView textViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulldog_list);

        textViewer = (TextView) findViewById(R.id.textView);

        String email = getIntent().getStringExtra("email");
        textViewer.setText(email);
    }
}
