package ht.bernst.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static ht.bernst.simpletodo.MainActivity.ITEM_POSITION;
import static ht.bernst.simpletodo.MainActivity.ITEM_TEXT;

public class EdditItemActivity extends AppCompatActivity {

    // track edit text
    EditText etItemText;
    // position of edited item in list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eddit_item);
        // resolve edit text from layout
        etItemText = this.findViewById(R.id.etItemText);
        // set edit text value from intent extra
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        // update position from intent extra
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        // update the title bar of the activity
        getSupportActionBar().setTitle("Edit Item");
    }

    // handler for save button
    public void onsaveItem(View v) {
        //prepare new intent for result
        Intent i = new Intent();
        // pass update item text as extra
        i.putExtra(ITEM_TEXT, etItemText.getText().toString());
        // pass original position as extra
        i.putExtra(ITEM_POSITION, position);
        setResult(RESULT_OK, i);
        // close the activity
        finish();


    }

}


