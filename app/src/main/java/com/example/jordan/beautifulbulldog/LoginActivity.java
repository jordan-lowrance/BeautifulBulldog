package com.example.jordan.beautifulbulldog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText passField;
    private EditText emailField;

    public void populateBulldogs() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm) {
                Bulldog dog1 = new Bulldog();
                dog1.setId("1");
                dog1.setName("Spots");
                dog1.setAge("2");
                realm.copyToRealmOrUpdate(dog1);

                Bulldog dog2 = new Bulldog();
                dog2.setId("2");
                dog2.setName("Spike");
                dog2.setAge("12");
                realm.copyToRealmOrUpdate(dog2);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.login_button);
        passField = (EditText) findViewById(R.id.pass_field);
        emailField = (EditText) findViewById(R.id.email_field);

        Realm realm = Realm.getDefaultInstance();
        final RealmResults<Bulldog> dogs = realm.where(Bulldog.class).findAll();
        if(dogs.size() == 0){
            populateBulldogs();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Realm realm = Realm.getDefaultInstance();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User user = new User();
                        user.setUsername(emailField.getText().toString());
                        realm.copyToRealmOrUpdate(user);

                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        intent.putExtra("username", user.getUsername());
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
