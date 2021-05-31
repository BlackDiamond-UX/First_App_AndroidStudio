package com.example.marathon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    EditText nom,prenom,ville,email;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        ville = findViewById(R.id.ville);
        email = findViewById(R.id.mail);

        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),congrat.class );
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("prenom",prenom.getText().toString());
                i.putExtra("ville",ville.getText().toString());
//                validateEmailAdress(email);

                if(nom.getText().toString().trim().equalsIgnoreCase("")) {
                    if (nom.getText().toString().trim().equalsIgnoreCase("")) {
                        nom.setError("This field can not be blank");
                    } else {
                        nom.setError(null);
//                    startActivity(i);
                    }
                    if (prenom.getText().toString().trim().equalsIgnoreCase("")) {
                        prenom.setError("This field can not be blank");
                    } else {
//                    startActivity(i);
                    }
                    if (ville.getText().toString().trim().equalsIgnoreCase("")) {
                        ville.setError("This field can not be blank");
                    } else {
//                    startActivity(i);
                    }
                    if (email.getText().toString().trim().equalsIgnoreCase("")) {
                        email.setError("This field can not be blank");
                        validateEmailAdress(email);
                    } else {
//                    startActivity(i);
                    }
                }else {
                    startActivity(i);
                }



            }
        });


    }
    private boolean validateEmailAdress(EditText email){
        String emailInput = email.getText().toString();
        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(this,"Email Validates Succefully !", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(this, "Invalid Email Adress ! ",Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}