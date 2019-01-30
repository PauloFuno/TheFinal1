package android.p.com.thefinal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Boolean isFABOpen = false;
    private FloatingActionButton mFloatingActionButton;
    private FloatingActionButton mFloatingTransaction;
    private FloatingActionButton mFloatingIncomes;
    private FloatingActionButton mFloatingGoals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floatab);

        onFab();

    }

    public void openActivityAdd() {
        Intent intent = new Intent(this, ActivityAdd.class);
        startActivity(intent);
    }

    public void openActivityIncome() {
        Intent intent = new Intent(this, ActivityIncome.class);
        startActivity(intent);
    }

    public void openActivityGoal() {
        Intent intent = new Intent(this, ActivityGoal.class);
        startActivity(intent);
    }

    public void onFab() {
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingTransaction = (FloatingActionButton) findViewById(R.id.fab_transaction);
        mFloatingIncomes = (FloatingActionButton) findViewById(R.id.fab_incomes);
        mFloatingGoals = (FloatingActionButton) findViewById(R.id.fab_goals);


        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFABOpen = (isFABOpen == true) ? false : true;

                if (isFABOpen) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }

            }
        });

    }


    private void showFABMenu() {
        isFABOpen = true;
        mFloatingTransaction.animate().translationY(-getResources().getDimension(R.dimen.standard_180));
        mFloatingTransaction.setEnabled(true);
        mFloatingIncomes.animate().translationY(-getResources().getDimension(R.dimen.standard_120));
        mFloatingIncomes.setEnabled(true);
        mFloatingGoals.animate().translationY(-getResources().getDimension(R.dimen.standard_60));
        mFloatingGoals.setEnabled(true);

        mFloatingTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAdd();
            }
        });

        mFloatingIncomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityIncome();
            }
        });

        mFloatingGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityGoal();
            }
        });


    }

    private void closeFABMenu() {
        isFABOpen = false;
        mFloatingTransaction.animate().translationY(0);
        mFloatingIncomes.animate().translationY(0);
        mFloatingGoals.animate().translationY(0);

        mFloatingTransaction.setOnClickListener(null);
        mFloatingTransaction.setEnabled(false);

        mFloatingIncomes.setOnClickListener(null);
        mFloatingIncomes.setEnabled(false);

        mFloatingGoals.setOnClickListener(null);
        mFloatingGoals.setEnabled(false);
    }


}
