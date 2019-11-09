package com.example.firsttwo;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.Collections;

public class Main8Activity extends AppCompatActivity {

    Button btn_sign_out;
    Button choisData;
    TextView settext;
    int year;
    int month;
    int dayOfmonth;
    Calendar calendar;
    DatePickerDialog datePickerDialog;



    private static final int RC_SIGN_IN = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);


        choisData=findViewById(R.id.choisData);
        settext=findViewById(R.id.settext);

        choisData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar=Calendar.getInstance();
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                dayOfmonth=calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(Main8Activity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                settext.setText(day + "." + (month + 1) + "." + year);
                            }
                        }, year,month,dayOfmonth);
                datePickerDialog.show();
            }
        });









        doPhoneLogin();



    }

    public void Exit(View view){
        Intent e = new Intent(this,MainActivity.class);
        startActivity(e);
    }



    private void doPhoneLogin() {
        Intent intent = AuthUI.getInstance().createSignInIntentBuilder()
                .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                .setAvailableProviders(Collections.singletonList(
                        new AuthUI.IdpConfig.PhoneBuilder().build()))
                .setLogo(R.mipmap.ic_launcher)
                .build();

        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        btn_sign_out =(Button)findViewById(R.id.btn_sign_out);
        choisData=(Button)findViewById(R.id.choisData);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse idpResponse = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(

                );
                showAlertDialog(user);
                btn_sign_out.setEnabled(true);
                choisData.setEnabled(true);




            } else {
                /**
                 *   Sign in failed. If response is null the user canceled the
                 *   sign-in flow using the back button. Otherwise check
                 *   response.getError().getErrorCode() and handle the error.
                 */
                Toast.makeText(getBaseContext(), "Ошибка Автоирзации", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void showAlertDialog(FirebaseUser user) {
        AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(
                Main8Activity.this);

        // Set Title
        mAlertDialog.setTitle("Авторизация успешна");

        // Set Message
        mAlertDialog.setMessage(" Номер телефона " + user.getPhoneNumber());

        mAlertDialog.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        mAlertDialog.create();

        // Showing Alert Message
        mAlertDialog.show();
    }
}