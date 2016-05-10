package com.z3dd.conjugo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

//TODO: implement back button
public class AddVerbActivity extends AppCompatActivity {
    Verb verb;
    EditText[] editTextArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_verb);

        editTextArray = new EditText[8];
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickDone(View view) {
        EditText verbName = (EditText) findViewById(R.id.verb_name_edit_text);
        EditText def = (EditText) findViewById(R.id.definition_edit_text);
        EditText yo = (EditText) findViewById(R.id.yo_edit_text);
        EditText tu = (EditText) findViewById(R.id.tu_edit_text);
        EditText el = (EditText) findViewById(R.id.el_edit_text);
        EditText nos = (EditText) findViewById(R.id.nos_edit_text);
        EditText vos = (EditText) findViewById(R.id.vos_edit_text);
        EditText ellos = (EditText) findViewById(R.id.ellos_edit_text);

        editTextArray[0] = verbName;
        editTextArray[1] = def;
        editTextArray[2] = yo;
        editTextArray[3] = tu;
        editTextArray[4] = el;
        editTextArray[5] = nos;
        editTextArray[6] = vos;
        editTextArray[7] = ellos;


        if (allVerbDetailsEntered(editTextArray)) {
            verb = new Verb(editTextArray);
            VerbSetManager.addVerb(verb);

            Intent intent = new Intent(this, VerbListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
           displayMissingDetailsAlertMessage();
        }

    }

    private boolean allVerbDetailsEntered(EditText[] arr){
        boolean isMissingDetails = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toString() == "") {
                isMissingDetails = true;
                break;
            }
        }
        return isMissingDetails;
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
