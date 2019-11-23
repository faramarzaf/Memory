package com.faramarz.tictacdev.workwithmemory.sample2;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class HintClass {

    FileOutputStream outputStream;
    File file;
    String content = "hello world";
    BufferedReader input;
    StringBuffer buffer;
    Context context;

    public void makeInternalFile() {
        // Create a file in the Internal Storage
        String fileName = "MyFile";
        String content = "hello world";
        outputStream = null;
        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            // Context.MODE_PRIVATE makes the file inaccessible to other apps. If you want other apps to access your files then it might be better to save them on External storage
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void makeFileCache() {
        try {
            // file = File.createTempFile("MyCache", null, getCacheDir());
            file = new File(context.getCacheDir(), "MyCache");
            // If we use getFilesDir() instead of getCacheDir() then it’ll store files in the files
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        input = null;
        file = null;
        try {
            file = new File(context.getCacheDir(), "MyCache"); // Pass getFilesDir() and "MyFile" to read file
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            buffer = new StringBuffer();
            while ((line = input.readLine()) != null) {
                buffer.append(line);
            }
            Log.d("TAG", buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFileToExternalStorage() {
        String content = "hello world";
        File file;
        FileOutputStream outputStream;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "MyCache");

            /* Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            to save the file in the Downloads directory of your external storage.
             */

            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteMyFile() {
        file.delete();
        context.deleteFile("Your File Name"); // in activity
    }


}
