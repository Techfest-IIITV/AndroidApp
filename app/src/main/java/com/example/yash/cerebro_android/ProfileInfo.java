package com.example.yash.cerebro_android;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileInfo extends AppCompatActivity {

    private EditText name;
    private EditText number;
    private Button submit;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);

        mContext = getApplicationContext();
        name = findViewById(R.id.et_full_name);
        number = findViewById(R.id.et_number);
        submit = findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = name.getText().toString();
                String phoneNumber = number.getText().toString();

                if (phoneNumber.length() == 0) {
                    Toast.makeText(mContext, "Phone Number is not set.", Toast.LENGTH_SHORT).show();
                }
                if (fullName.trim().length() == 0) {
                    Toast.makeText(mContext, "Please enter valid name.", Toast.LENGTH_SHORT).show();
                }
                if (phoneNumber.length() == 10 && fullName.trim().length() > 4) {
                    fullName = fullName.trim();
                }
            }
        });
    }
}
