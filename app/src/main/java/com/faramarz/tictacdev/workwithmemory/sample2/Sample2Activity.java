package com.faramarz.tictacdev.workwithmemory.sample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.faramarz.tictacdev.workwithmemory.R;


public class Sample2Activity extends AppCompatActivity implements View.OnClickListener {
    EditText edtInput;
    Button btnSave, btnDelete, btnShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample2);
        bind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                break;

            case R.id.btnDelete:
                break;
            case R.id.btnShow:

                break;
        }
    }

    private void bind() {
        edtInput = findViewById(R.id.edtInput);
        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnShow = findViewById(R.id.btnShow);
        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }


}
