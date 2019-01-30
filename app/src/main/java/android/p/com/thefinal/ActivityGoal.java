package android.p.com.thefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ActivityGoal extends AppCompatActivity {
    String switchCheck = "Once";
    private Switch mMonthlyS;
    private EditText mAmount;
    private EditText mDescription;
    private Button mSaveBtn;
    private Button mCancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        getDescription();
        getAmount();
        onSaveBtn();
        onCancelBtn();

    }


    public void onCancelBtn() {
        mCancelBtn = (Button) findViewById(R.id.cancel_btn);
        mCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnActivityMain();
            }
        });
    }


    public void onSaveBtn() {
        mSaveBtn = (Button) findViewById(R.id.save_btn);
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open questions and save in list
                getSwitch();

                Toast toast = Toast.makeText(getApplicationContext(),
                        "" + mDescription.getText().toString()
                                + " $ "
                                + mAmount.getText().toString()
                                + switchCheck,
                        Toast.LENGTH_SHORT);

                toast.show();

                returnActivityMain();
            }
        });
    }


    public void returnActivityMain() {
        final Intent intent = new Intent(this, MainActivity.class);
        setResult(ActivityAdd.RESULT_OK, intent);
        finish();
    }

    public void getDescription() {
        mDescription = (EditText) findViewById(R.id.description_input);
    }

    public void getAmount() {
        mAmount = (EditText) findViewById(R.id.amount_input);
    }

    public void getSwitch() {
        mMonthlyS = (Switch) findViewById(R.id.switchM);

        if (mMonthlyS.isChecked()) {
            switchCheck = " Monthly ";
        } else {
            switchCheck = " Once ";
        }
    }
}
