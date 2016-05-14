package com.z3dd.conjugo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

public class AddAVerbActivity extends FullVerbDetailActivity {
    private EditText[] editTextArray;
    private Verb newVerb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionButtonText("SAVE");
    }

    @Override
    public void onClickActionButton(View view) {
        collectVerbInfo();
        if (allVerbDetailsEntered(editTextArray)) {
            VerbSetManager.addVerb(newVerb);
            Intent intent = new Intent(this, VerbListActivity.class);
            startActivity(intent);
        } else {
            displayMissingDetailsAlertMessage();
        }
    }

    private void collectVerbInfo(){

        editTextArray = new EditText[]{(EditText) findViewById(getVerbNameEditTextId()),
                (EditText) findViewById(R.id.definition_edit_text),
                (EditText) findViewById(R.id.yo_edit_text),
                (EditText) findViewById(R.id.tu_edit_text),
                (EditText) findViewById(R.id.el_edit_text),
                (EditText) findViewById(R.id.nos_edit_text),
                (EditText) findViewById(R.id.vos_edit_text),
                (EditText) findViewById(R.id.ellos_edit_text)};
        newVerb = new Verb(editTextArray);
    }

    private boolean allVerbDetailsEntered(EditText[] arr){
        boolean allDetailsEntered = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getText().toString().equals("")) {
                allDetailsEntered = false;
                break;
            }
        }
        return allDetailsEntered;
    }

    private void displayMissingDetailsAlertMessage() {
        AlertDialog.Builder missingDetailDialog = new AlertDialog.Builder(this);
        missingDetailDialog.setMessage("Verb details missing");

        missingDetailDialog.setPositiveButton(
                "Continue",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = missingDetailDialog.create();
        alert.show();
    }
}
