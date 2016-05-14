package com.z3dd.conjugo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ConjugationPracticeActivity extends CompactVerbDetailActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionButtonText("CHECK");
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayNextVerb();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.verb_list:
                Intent intent = new Intent(this, VerbListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClickActionButton(View view) {
        if (GameManager.currentVerbMatches(userInput())){
            clearEditTextFields();
            displayNextVerb();
        } else {
            displayWrongAnswerAlertMessage();
        }
    }


    public void displayNextVerb() {

        if (VerbSetManager.setHasVerb()) {
            setVerbNameTextView(GameManager.nextVerb());
        } else {
            hideVerbNameTextView();
        }
    }

    private Verb userInput() {
        EditText[] editTextArray = new EditText[]{(EditText) findViewById(R.id.definition_edit_text), (EditText) findViewById(R.id.yo_edit_text),
                (EditText) findViewById(R.id.tu_edit_text), (EditText) findViewById(R.id.el_edit_text),(EditText) findViewById(R.id.nos_edit_text),
                (EditText) findViewById(R.id.vos_edit_text), (EditText) findViewById(R.id.ellos_edit_text)};
        Verb userInput = new Verb(editTextArray);
        return userInput;
    }

    private void clearEditTextFields() {
        EditText[] editTextArray = new EditText[]{(EditText) findViewById(R.id.definition_edit_text), (EditText) findViewById(R.id.yo_edit_text),
                (EditText) findViewById(R.id.tu_edit_text), (EditText) findViewById(R.id.el_edit_text),(EditText) findViewById(R.id.nos_edit_text),
                (EditText) findViewById(R.id.vos_edit_text), (EditText) findViewById(R.id.ellos_edit_text)};

        for (EditText et: editTextArray){
            et.setText("");
        }
    }

    private void displayWrongAnswerAlertMessage() {
        AlertDialog.Builder incorrectAnswerDialog = new AlertDialog.Builder(this);
        incorrectAnswerDialog.setMessage("Incorrect answer");
        incorrectAnswerDialog.setPositiveButton(
                "Try again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = incorrectAnswerDialog.create();
        alert.show();
    }
}
