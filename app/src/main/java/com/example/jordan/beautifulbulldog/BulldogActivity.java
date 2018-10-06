package com.example.jordan.beautifulbulldog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import io.realm.Realm;

import static com.example.jordan.beautifulbulldog.MainActivity.user;

public class BulldogActivity extends AppCompatActivity {

    private Button button;
    private RatingBar ratingBar;
    private TextView bulldogAge;
    private TextView bulldogName;
    private TextView textView;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulldog);

        textView = findViewById(R.id.textView);
        realm = Realm.getDefaultInstance();

        bulldogAge = findViewById(R.id.bulldogAge);
        bulldogName = findViewById(R.id.bulldogName);
        ratingBar = findViewById(R.id.ratingBar);

        button = findViewById(R.id.button);

        String id = (String) getIntent().getStringExtra("bulldog");
        Bulldog bulldog = realm.where(Bulldog.class).equalTo("id", id).findFirst();

        Realm realm = Realm.getDefaultInstance();
        String username = (String) getIntent().getStringExtra("username");
        user = realm.where(User.class).equalTo("username", username).findFirst();

        textView.setText(bulldog.getName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Realm realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Vote vote = new Vote();
                        vote.setRating(ratingBar.getNumStars());
                        //realm.copyToRealmOrUpdate(vote);
                        finish();
                    }
                });
            }
        });
    }
}
