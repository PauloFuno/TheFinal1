package android.p.com.thefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityAdd extends AppCompatActivity {
    private Button mSaveBtn;
    private Button mCancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        onDoneBtn();
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



    public void onDoneBtn() {
        mSaveBtn = (Button) findViewById(R.id.save_btn);
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open questions and save in list

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Saved",
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


}



