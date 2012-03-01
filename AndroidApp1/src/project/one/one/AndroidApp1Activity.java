package project.one.one;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AndroidApp1Activity extends Activity {
	private EditText text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.editText1);

	}

	// "On Click property" of the button
	public void myClickHandler(View view) {
		switch (view.getId()) {
		case R.id.button1:
			RadioButton radianButton = (RadioButton) findViewById(R.id.radio0);
			RadioButton degreeButton = (RadioButton) findViewById(R.id.radio1);
			if (text.getText().length() == 0) {
				Toast.makeText(this, "Please enter a valid number",
						Toast.LENGTH_LONG).show();
				return;
			}

			float inputValue = Float.parseFloat(text.getText().toString());
			if (radianButton.isChecked()) {
				text.setText(String
						.valueOf(convertDegreetoRadian(inputValue)));
				radianButton.setChecked(false); //reverse for checking formula, for the user
				degreeButton.setChecked(true);
			} else {
				text.setText(String
						.valueOf(convertRadiantoDegree(inputValue)));
				degreeButton.setChecked(false);//reverse for checking formula, for the user
				radianButton.setChecked(true);
			}
			break;
		}
	}

	// Converts to radians
	private float convertDegreetoRadian(float degree) {
		return (float) (degree * (3.1415 / 180));
	}

	// Converts to degrees
	private float convertRadiantoDegree(float radian) {
		return (float) (radian * (180 / 3.1415));
	}
}
	