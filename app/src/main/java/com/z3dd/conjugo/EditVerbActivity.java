package com.z3dd.conjugo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class EditVerbActivity extends FullVerbDetailActivity {
    List<String> verbList;
    static EditText[] editTextArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verbList = new ArrayList<>(VerbSet.getSelectedVerb().verbDetailSet());
        setActionButtonText("DELETE");
        setUpButton(true, "Save");
    }

    @Override
    public void onStart() {
        super.onStart();
        populateEditTextAttribuite(verbList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (updateVerb()) {
            Intent intent = new Intent(this, VerbListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            return super.onOptionsItemSelected(item);
        } else {
            displayMissingDetailsAlertMessage();
        }
        return true;
    }

    //Action button deletes selected verb
    public void onClickActionButton(View view) {
        Intent intent = new Intent(this, VerbListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        VerbSet.delete(new Verb(verbList.toArray(new String[8])));

        startActivity(intent);
    }

    private boolean updateVerb() {
        boolean successFullUpdate = false;
        editTextArray = new EditText[]{(EditText) findViewById(getVerbNameEditTextId()),
                (EditText) findViewById(R.id.definition_edit_text),
                (EditText) findViewById(R.id.yo_edit_text),
                (EditText) findViewById(R.id.tu_edit_text),
                (EditText) findViewById(R.id.el_edit_text),
                (EditText) findViewById(R.id.nos_edit_text),
                (EditText) findViewById(R.id.vos_edit_text),
                (EditText) findViewById(R.id.ellos_edit_text)};
        if (allVerbDetailsEntered(editTextArray)) {
            Verb updatedVeb = new Verb(editTextArray);
            VerbSet.delete(VerbSet.getSelectedVerb());
            VerbSet.add(updatedVeb);
            successFullUpdate = true;
        }
        return successFullUpdate;
    }

    private boolean allVerbDetailsEntered(EditText[] arr) {
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

    private void populateEditTextAttribuite(List<String> verbDetails) {
        EditText[] editTextArray = new EditText[8];

        editTextArray[0] = (EditText) findViewById(getVerbNameEditTextId());
        editTextArray[1] = (EditText) findViewById(R.id.definition_edit_text);
        editTextArray[2] = (EditText) findViewById(R.id.yo_edit_text);
        editTextArray[3] = (EditText) findViewById(R.id.tu_edit_text);
        editTextArray[4] = (EditText) findViewById(R.id.el_edit_text);
        editTextArray[5] = (EditText) findViewById(R.id.nos_edit_text);
        editTextArray[6] = (EditText) findViewById(R.id.vos_edit_text);
        editTextArray[7] = (EditText) findViewById(R.id.ellos_edit_text);

        for (int i = 0; i < verbDetails.size(); i++) {
            editTextArray[i].setText(verbDetails.get(i));
        }
    }

}
