package com.twoodr.app;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener {
	Button submit;
	ToggleButton pass;
	EditText text;
	TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		initializeButtons();
		pass.setOnClickListener(this);
		submit.setOnClickListener(this);
	}

	private void initializeButtons() {
		// TODO Auto-generated method stub
		submit = (Button) findViewById(R.id.bSubmit);
		 pass = (ToggleButton)findViewById(R.id.tbPassword);
		 text = (EditText) findViewById(R.id.edCommand);
		 display = (TextView) findViewById(R.id.tInvalid);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.tbPassword:
			if(pass.isChecked()){
				text.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}else{
				text.setInputType(InputType.TYPE_CLASS_TEXT);
			}
			break;
		case R.id.bSubmit:
			String check = text.getText().toString();
			if(check.contentEquals("left")){
				display.setGravity(Gravity.LEFT);
			}else if(check.contentEquals("center")){
				display.setGravity(Gravity.CENTER);
			}else if(check.contentEquals("right")){
				display.setGravity(Gravity.RIGHT);
			}else if(check.contentEquals("blue")){
				display.setTextColor(Color.BLUE);
			}else if(check.contentEquals("wtf")){
				Random crazy = new Random();
				display.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
				display.setTextSize(crazy.nextInt(75));
			}
			break;
		}
	}
			
}
