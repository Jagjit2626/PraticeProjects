package easy.tuto.easycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button dot;
    private Button equals;
    private Button clear;
    private Button clear1;
    private Button percentage1;
    private Button dzero;
    private TextView solution;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char PERCENTAGE = '%';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUIViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "9");
            }
        });

        dzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "00");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + ".");
            }
        });

        percentage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(solution.getText().toString() + "%");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText("");
                solution.setText(null);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText("");
                solution.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLY;
                result.setText("");
                solution.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVIDE;
                result.setText("");
                solution.setText(null);
            }
        });

        percentage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = PERCENTAGE;
                result.setText("");
                solution.setText(null);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                result.setText(String.valueOf(val1));
                // 5 + 4 = 9
                solution.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                result.setText(null);
                solution.setText(null);
            }
        });


        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (solution.getText().length() > 0) {
                    CharSequence name = solution.getText().toString();
                    solution.setText(name.subSequence(0, name.length() - 1));
                }
            }
        });



    }


    private void setUIViews() {

        zero = (Button) findViewById(R.id.button_0);
        one = (Button) findViewById(R.id.button_1);
        two = (Button) findViewById(R.id.button_2);
        three = (Button) findViewById(R.id.button_3);
        four = (Button) findViewById(R.id.button_4);
        five = (Button) findViewById(R.id.button_5);
        six = (Button) findViewById(R.id.button_6);
        seven = (Button) findViewById(R.id.button_7);
        eight = (Button) findViewById(R.id.button_8);
        nine = (Button) findViewById(R.id.button_9);
        add = (Button) findViewById(R.id.button_plus);
        sub = (Button) findViewById(R.id.button_minus);
        mul = (Button) findViewById(R.id.button_multiply);
        div = (Button) findViewById(R.id.button_divide);
        clear = (Button) findViewById(R.id.button_C);
        dzero = (Button) findViewById(R.id.button_00);
        dot = (Button) findViewById(R.id.button_dot);
        clear1 = (Button) findViewById(R.id.clearone);
        percentage1 = (Button) findViewById(R.id.percentage);
        equals = (Button) findViewById(R.id.button_equals);
        solution = (TextView) findViewById(R.id.solutiontv);
        result = (TextView) findViewById(R.id.resulttv);


    }



    private void compute() {
        if (!Double.isNaN(val1)) {
            val2 = Double.parseDouble(solution.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLY:
                    val1 = val1 * val2;
                    break;
                case DIVIDE:
                    if (val2 != 0) {
                        val1 = val1 / val2;
                    } else {
                        // Handle division by zero
                        solution.setText("Can't divide by zero");
                        val1 = Double.NaN; // Reset val1
                    }
                    break;
                case PERCENTAGE:
                    val1 = val1 % val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(solution.getText().toString());
        }
    }
}