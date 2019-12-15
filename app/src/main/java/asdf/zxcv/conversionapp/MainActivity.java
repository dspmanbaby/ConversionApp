package asdf.zxcv.conversionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Conversion conversion;
    private TextView inputLabel;
    private TextView outputLabel;
    private EditText inputValue;
    private TextView outputValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conversion = new Conversion();
        inputLabel = findViewById(R.id.textView);
        inputLabel.setText(conversion.inputLabel);
        outputLabel = findViewById(R.id.textView2);
        outputLabel.setText(conversion.outputLabel);
        outputValue = findViewById(R.id.textView3);
        outputValue.setText(conversion.output.toString());
        inputValue = findViewById(R.id.editText);
        inputValue.setText(conversion.input.toString());
        inputValue.addTextChangedListener(inputTextWatcher);
    }
    private TextWatcher inputTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                conversion.input = Double.parseDouble(s.toString());
            } catch (NumberFormatException e) {
                conversion.input = 0.0;
            }
            conversion.convert();
            outputValue.setText(conversion.output.toString());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            toggleActionBar();
        }
         return true;
    }

    public void toggleActionBar() {
        ActionBar actionBar = getActionBar();

        if(actionBar !=null) {
            if(actionBar.isShowing()){
                actionBar.hide();
            }
        }
        else{
            actionBar.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuitem_feet_to_meters:
                conversion.switchToMeters();
            case R.id.menuitem_inches_to_centimeters:
                conversion.switchToCentimeters();
            case R.id.menuitem_pounds_to_grams:
                conversion.switchToGrams();
            case R.id.menuitem_quit:
                finish();
        }
        return true;
    }
}