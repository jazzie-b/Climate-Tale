package com.example.climatetale.ViewModels;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.climatetale.MainActivity;

public class MainActivityViewModel extends ViewModel {

    private String usersName;

    public void init(Context c){
        if(usersName.equals(null)){
            addNameDialog(c);
        }

    }

    public String getUsersName() {
        return usersName;
    }

    public void addNameDialog(Context c) {
        final EditText editText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Welcome")
                .setMessage("What is your name?")
                .setView(editText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        usersName = String.valueOf(editText.getText());
                    }
                })
                .create();
        dialog.show();
    }
}
