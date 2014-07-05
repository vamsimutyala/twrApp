package com.twoodr.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {
	EditText fname , lname , phneNo , email, password , dob;
	Button SendEmail;
	String UrFname , UrLname , UrPhne , UrEmail , UrPassword , UrDob;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		SendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		fname = (EditText) findViewById(R.id.etFname);
		lname = (EditText) findViewById(R.id.etLname);
		phneNo = (EditText) findViewById(R.id.etPhn);
		email = (EditText) findViewById(R.id.etEmail);
		password = (EditText) findViewById(R.id.etPassword);
		dob = (EditText) findViewById(R.id.etDob);
		SendEmail = (Button) findViewById(R.id.bSendMail);
		
	}

	@Override 
	public void onClick(View view) {
		// TODO Auto-generated method stub
		convertIntoStrings();
		String emailAddress[] = {UrEmail};
		String message = "Your First Name is"+UrFname
				+"Your last name is "+UrLname
				+"Your Phone number is "+UrPhne
				+"you are born by mistake on"+UrDob;
		Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);
		sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
		sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, "I Hate You");
		sendEmail.setType("plain/text");
		sendEmail.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(sendEmail);
		
	}

	private void convertIntoStrings() {
		// TODO Auto-generated method stub
		UrFname = fname.getText().toString();
		UrLname = lname.getText().toString();
		UrPhne = phneNo.getText().toString();
		UrPassword = password.getText().toString();
		UrEmail = email.getText().toString();
		UrDob = dob.getText().toString();
	}
	
		

}
