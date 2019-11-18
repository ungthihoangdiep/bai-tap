package com.example.myfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        handleBntLogin();
    }

    private void handleBntLogin() {
        Mapping();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((edtUsername.getText().toString().equals("diep")&&edtPassword.getText().toString().equals("0803"))||(edtUsername.getText().toString().equals("hoangdiep")&&edtPassword.getText().toString().equals("1998"))){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username", edtUsername.getText().toString());
                    MainActivity.this.startActivity(intent);
                    edtPassword.setText("");
                    edtUsername.setText("");

                }
                else Toast.makeText(MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void Mapping() {
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }
}
