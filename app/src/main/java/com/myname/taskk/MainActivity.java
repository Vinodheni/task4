package com.myname.taskk;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {

    EditText textIn,name;
    Button buttonAdd,change;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textIn = (EditText) findViewById(R.id.textin);
        buttonAdd = (Button) findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);
        name = (EditText) findViewById(R.id.name);
        change = (Button) findViewById(R.id.change);
        buttonAdd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);
               final TextView textOut = (TextView) addView.findViewById(R.id.textout);
                textOut.setText(textIn.getText().toString());
                ImageView image = (ImageView) addView.findViewById(R.id.img);
                Drawable drawable = getResources().getDrawable(R.drawable.file);
                image.setImageDrawable(drawable);
                Button buttonRemove = (Button) addView.findViewById(R.id.remove);
                buttonRemove.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                });

                container.addView(addView);
                Button edit = (Button) addView.findViewById(R.id.edit);
                edit.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        change.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String t=name.getText().toString();
                                textOut.setText(t);


                            }
                        });


                    }
                });



            }

                });



    }



}



