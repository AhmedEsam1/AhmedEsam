package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



    public class MainActivity extends AppCompatActivity {

        int score = 0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        /**
         * This method is called when getScore button is clicked
         */
        public void showScore (View view) {

            // Find the user's name
            EditText NameTextView = (EditText) findViewById(R.id.name_view);
            String name = NameTextView.getText().toString();

            // To know if the user checked box 1 or not
            CheckBox CheckBox1 = (CheckBox) findViewById(R.id.checkbox1);
            boolean hasChecked1 = CheckBox1.isChecked();

            // To know if the user had checked box 2 or not
            CheckBox CheckBox2 = (CheckBox) findViewById(R.id.checkbox2);
            boolean hasChecked2 = CheckBox2.isChecked();

            // To know if the user had checked box 3 or not
            CheckBox CheckBox3 = (CheckBox) findViewById(R.id.checkbox3);
            boolean hasChecked3 = CheckBox3.isChecked();

            // To know if the user had choose first "yes" or not
            RadioButton clicked1 = (RadioButton) findViewById(R.id.yes_radio_button);

            // To know if the user had choose second "yes" or not
            RadioButton clicked2 = (RadioButton) findViewById(R.id.yes_radio_button2);

            // To know if the user had choose third "no" or not
            RadioButton clicked3 = (RadioButton) findViewById(R.id.no_radio_button3);

            /**
             * To store the result in editText
             * @param Integer.parseInt to convert the text from string to integer
              */
            EditText editTextQ = (EditText) findViewById(R.id.edit_text_q);
            int q = Integer.parseInt(editTextQ.getText().toString());

            // calculate the score
            int scoreFinal = calcuateScoreCheckBox(hasChecked1,hasChecked2,hasChecked3)
                    + onRadioButtonClicked(clicked1,clicked2,clicked3) + calculateEditText(q);

            // display the score
            displayScore(scoreFinal);

            // diplay the score and thank you message with the user name :)
            Toast.makeText(this , "You got " + scoreFinal +
                    "\nThank you " + name + " :)", + Toast.LENGTH_LONG).show();
        }

        /**
         * This method is calculate the score on the checkBox "onCheckboxButtonClicked or not"
         */
        public int calcuateScoreCheckBox(boolean checkBox1 ,boolean checkBox2 ,boolean checkBox3){
            int scoreCheckBox = 0;

            // if the user had checked the right boxes will add 1 point to the score
            // if he/she had choose box1 and not choose box2 and choose box3
            if (checkBox1 && !checkBox2 && checkBox3){
                scoreCheckBox = score + 1;
            }
            // return score for checkedBox
            return scoreCheckBox;
        }

        /**
         * This method is calculate the score on the right radioButton "onRadioButtonClicked or not"
         */
        public int onRadioButtonClicked(View view, View view2, View view3) {
            int scoreRadioButton1 = 0;
            int scoreRadioButton2 = 0;
            int scoreRadioButton3 = 0;

            // Is the button now checked "ye button"?
            // To know if it checked or not
            boolean checked = ((RadioButton) view).isChecked();

            // Is the button now checked "yes button2"?
            // To know if it checked or not
            boolean checked1 = ((RadioButton) view2).isChecked();

            // Is the button now checked "no button3"?
            // To know if it checked or not
            boolean checked2 = ((RadioButton) view3).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.yes_radio_button:
                    // "Yes button"
                    if (checked)
                        // the rule
                        scoreRadioButton1 = score + 1;

                case R.id.yes_radio_button2:
                    // "Yes button2"
                    if (checked1)
                        // the rule
                        scoreRadioButton2 = score + 1;

                case R.id.no_radio_button3:
                    // "no button3"
                    if (checked2)
                        // the rule
                        scoreRadioButton3 = score + 1;
            }

            // Calculate the score
            int scoreRadio = scoreRadioButton1 + scoreRadioButton2 + scoreRadioButton3;

            // Return the score
            return scoreRadio;

            }

        /**
         * This method is calculate the score on the EditText
         */
        public int calculateEditText (int q1) {
            int scoreEditText = 0;

            if (q1 == 144) {
                scoreEditText = score +1;
            }
            return scoreEditText;
            }

// Action methods
        /**
         * his method displays the score on the screen.
         */
        private void displayScore(int score) {
            TextView scoreTextView = (TextView) findViewById(R.id.scoreTextView);
            scoreTextView.setText("" + score);
        }
    }