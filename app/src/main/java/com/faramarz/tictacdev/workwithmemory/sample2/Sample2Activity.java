package com.faramarz.tictacdev.workwithmemory.sample2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.faramarz.tictacdev.workwithmemory.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static com.faramarz.tictacdev.workwithmemory.sample1.Sample1Activity.isExternalStorageAvailable;
import static com.faramarz.tictacdev.workwithmemory.sample1.Sample1Activity.isExternalStorageReadOnly;

public class Sample2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText txtData;
    Button btnWriteSDFile, btnReadSDFile;
    TextView txtSDStatus;

    Boolean isSDPresent;
    Boolean isSDSupportedDevice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample2);
        bind();
        checkSDCard();
    }

    private void bind() {
        txtData = findViewById(R.id.txtData);
        btnWriteSDFile = findViewById(R.id.btnWriteSDFile);
        btnReadSDFile = findViewById(R.id.btnReadSDFile);
        txtSDStatus = findViewById(R.id.txtSDStatus);
        btnWriteSDFile.setOnClickListener(this);
        btnReadSDFile.setOnClickListener(this);
    }

    private void checkSDCard() {

        isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        isSDSupportedDevice = Environment.isExternalStorageRemovable();
        if (isSDSupportedDevice && isSDPresent) {
            txtSDStatus.setText("SD card is available");
            txtSDStatus.setTextColor(Color.GREEN);

        } else {
            txtSDStatus.setText("SD card is NOT available");
            txtSDStatus.setTextColor(Color.RED);
            btnWriteSDFile.setEnabled(false);
            btnReadSDFile.setEnabled(false);
        }


    }

    public void writeFileToSD(String fileName, String body) {
        FileOutputStream fos = null;
        try {
            final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/folderName/");
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    Log.i("ALERT", "could not create the directories");
                }
            }
            final File myFile = new File(dir, fileName + ".txt");
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            fos = new FileOutputStream(myFile);
            fos.write(body.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWriteSDFile:
                if (isSDSupportedDevice && isSDPresent) {
                    writeFileToSD("myTXT", "Bodyyyyyyyyyyy");
                } else {
                    Log.i("ALERT", "no sdcard");
                }
                break;

            case R.id.btnReadSDFile:
                if (isSDSupportedDevice && isSDPresent) {
                } else {
                    Log.i("ALERT", "no sdcard");
                }
                break;
        }

    }

}
