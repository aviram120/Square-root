package com.example.mathavi;
import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Multiplay extends Activity {

	String stA,stB,stC;
	double a=0,b=0,c=0;
	double x1,x2;
	Button cul;
	TextView dis_x1,dis_x2,dis_erro;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiplay);

		cul=(Button) findViewById(R.id.bottCalc);
		cul.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View arg0) 
			{
				double sq;

				EditText inputA=(EditText) findViewById(R.id.editTextA);
				EditText inputB=(EditText) findViewById(R.id.editTextB);
				EditText inputC=(EditText) findViewById(R.id.editTextC);

				dis_x1=(TextView) findViewById(R.id.tvX1);
				dis_x2=(TextView) findViewById(R.id.tvX2);
				dis_erro=(TextView) findViewById(R.id.tvErro);
				
				stA=inputA.getText().toString();
				stB=inputB.getText().toString();
				stC=inputC.getText().toString();

				try
				{		
					a=Double.parseDouble(stA);
					b=Double.parseDouble(stB);
					c=Double.parseDouble(stC);
				} 
				catch(NumberFormatException ex)
				{
					a=0;
					b=0;
					c=0;
		 		}
				
				if(stA.isEmpty()) a=0;
				if(stB.isEmpty()) b=0;
				if(stC.isEmpty()) c=0;
				
				sq=(-4*a*c);
				sq=(b*b)+sq;
				
				if (sq<0)
					{
						dis_erro.setTextColor(Color.RED);
						dis_erro.setText("There is no solution to the equation");	
					}
				else
					dis_erro.setText("");
				
				sq=Math.sqrt(sq);

				x1=((-b)+sq)/(2*a);
				x2=((-b)-sq)/(2*a);
				
				dis_x1.setText("x1=:"+ x1);
				dis_x2.setText("x2=:"+ x2);
			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multiplay, menu);
		return true;
	}
}
