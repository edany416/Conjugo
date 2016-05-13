package com.z3dd.conjugo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.z3dd.conjugo.R;
import com.z3dd.conjugo.Verb;
import com.z3dd.conjugo.VerbListActivity;
import com.z3dd.conjugo.VerbSetManager;

import java.util.ArrayList;
import java.util.List;

public class EditVerbActivity extends FullVerbDetailActivity {
    List<String> verbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_verb);
        verbList = new ArrayList<>(VerbSetManager.getSelectedVerb().verbDetailSet());
        populateEditTextAttribuite(verbList);
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

    public void onClickActionButton(View view) {
        Intent intent = new Intent(this, VerbListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        VerbSetManager.deleteVerb(new Verb(verbList.toArray(new String[8])));

        startActivity(intent);
    }

}
