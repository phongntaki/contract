package com.example.enzi_mac1.contract2;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.provider.MediaStore;
import java.util.UUID;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private static final String TAG = "MainActivity";

    private TextView txtDisplayDate, txtDisplayDate_start, txtDisplayDate_confirm;
    private DatePickerDialog.OnDateSetListener dtSetListener, dtSetListener_start, dtSetListener_confirm;

    private DrawingView drawView;
    private ImageButton currPaint, drawBtn, newBtn, saveBtn;
    private float smallBrush, mediumBrush, largeBrush;

    // insert image from gallery
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplayDate = (TextView) findViewById(R.id.txtpickDate);

        txtDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                    MainActivity.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dtSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dtSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = year + "/" + month + "/" + day;
                txtDisplayDate.setText(date);
            }
        };

        txtDisplayDate_start = (TextView) findViewById(R.id.txtpickDate_start);

        txtDisplayDate_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dtSetListener_start,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dtSetListener_start = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = year + "/" + month + "/" + day;
                txtDisplayDate_start.setText(date);
            }
        };

        txtDisplayDate_confirm = (TextView) findViewById(R.id.txtpickDate_confirm);

        txtDisplayDate_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dtSetListener_confirm,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dtSetListener_confirm = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = year + "/" + month + "/" + day;
                txtDisplayDate_confirm.setText(date);
            }
        };

        drawView = (DrawingView) findViewById(R.id.drawing);

        mediumBrush = getResources().getInteger(R.integer.medium_size);

        drawView.setBrushSize(mediumBrush);

        newBtn = (ImageButton)findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);

        saveBtn = (ImageButton)findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(this);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cb_eco:
                if (checked)
                System.out.print("cb_eco");
            else
                // Remove the meat
                break;
            case R.id.cb_sun_power:
                if (checked)
                    System.out.print("cb_sun_power");
            else
                // I'm lactose intolerant
                break;
            case R.id.cb_ih:
                if (checked)
                    System.out.print("cb_ih");
            else
                // Remove the meat
                break;
            case R.id.cb_elec_device:
                if (checked)
                    System.out.print("cb_elec_device");
            else
                // Remove the meat
                break;
            case R.id.cb_air_con:
                if (checked)
                    System.out.print("cb_air_con");
            else
                // Remove the meat
                break;
            case R.id.cb_gas:
                if (checked)
                    System.out.print("cb_gas");
            else
                // Remove the meat
                break;
            case R.id.cb_light:
                if (checked)
                    System.out.print("cb_light");
            else
                // Remove the meat
                break;
            case R.id.cb_other:
                if (checked)
                    System.out.print("cb_other");
            else
                // Remove the meat
                break;
        }
    }

    public void onCheckboxClicked2(View view) {
        // Is the view now checked?
        boolean checked2 = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cb_content1:
                if (checked2)
                    System.out.print("cb_content1");
                else
                    // Remove the meat
                    break;
            case R.id.cb_content2:
                if (checked2)
                    System.out.print("cb_content2");
                else
                    // I'm lactose intolerant
                    break;
            case R.id.cb_content3:
                if (checked2)
                    System.out.print("cb_content3");
                else
                    // Remove the meat
                    break;
            case R.id.cb_content4:
                if (checked2)
                    System.out.print("cb_content4");
                else
                    // Remove the meat
                    break;
        }
    }

    public void onClick(View view) {
         if(view.getId()==R.id.new_btn){
            //new button
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("New drawing");
            newDialog.setMessage("Start new drawing (you will lose the current drawing)?");
            newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    drawView.startNew(null);
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            newDialog.show();
        }

        else if(view.getId()==R.id.save_btn){
            //save drawing
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Save drawing");
            saveDialog.setMessage("Save drawing to device Gallery?");
            saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){

                    //save drawing
                    drawView.setDrawingCacheEnabled(true);
                    String imgSaved = MediaStore.Images.Media.insertImage(
                            MainActivity.this.getContentResolver(), drawView.getDrawingCache(),
                            UUID.randomUUID().toString()+".png", "drawing");

                    if(imgSaved!=null){
                        Toast savedToast = Toast.makeText(getApplicationContext(),
                                "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
                        savedToast.show();
                    }
                    else{
                        for (int i = 0; i < 3; i++) { // tried to increase the duration
                            Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                    "Oops! Image could not be saved. " +
                                            "Explicit write permission to storage device may required." +
                                            "Check Settings->" +
                                            "Application Manager->" +
                                            "contract2->" +
                                            "Permissions.", Toast.LENGTH_LONG);
                            unsavedToast.show();
                        }
                    }

                    drawView.destroyDrawingCache();
                }
            });
            saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            saveDialog.show();
        }

    }
}
