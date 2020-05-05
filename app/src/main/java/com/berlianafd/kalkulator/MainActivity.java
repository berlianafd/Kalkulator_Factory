package com.berlianafd.kalkulator;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends Activity {
    double nilai_oqf=0.249, nilai_ff=0.397, nilai_pcf=0.357;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    RelativeLayout button_trafoId, button_dc, button_dg, button_furan, button_dpk;
    ImageView arrow_trafoId, arrow_dc, arrow_dg, arrow_furan, arrow_dpk;
    LinearLayout konten_trafoId, konten_dg, konten_dc, konten_furan, konten_dpk;

    EditText meaDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        button_trafoId = (RelativeLayout) findViewById(R.id.button_trafoId);
        button_dc = (RelativeLayout) findViewById(R.id.button_dc);
        button_dg = (RelativeLayout) findViewById(R.id.button_dg);
        button_furan = (RelativeLayout) findViewById(R.id.button_furan);
        button_dpk = (RelativeLayout) findViewById(R.id.button_dpk);

        arrow_trafoId = (ImageView) findViewById(R.id.arrow_trafoId);
        arrow_dc = (ImageView) findViewById(R.id.arrow_dc);
        arrow_dg = (ImageView) findViewById(R.id.arrow_dg);
        arrow_furan = (ImageView) findViewById(R.id.arrow_furan);
        arrow_dpk = (ImageView) findViewById(R.id.arrow_dpk);

        konten_trafoId = (LinearLayout) findViewById(R.id.konten_trafoId);
        konten_dc = (LinearLayout) findViewById(R.id.konten_dc);
        konten_dg = (LinearLayout) findViewById(R.id.konten_dg);
        konten_furan = (LinearLayout) findViewById(R.id.konten_furan);
        konten_dpk = (LinearLayout) findViewById(R.id.konten_dpk);

        button_trafoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(konten_trafoId.getVisibility() == View.VISIBLE){
                    konten_trafoId.setVisibility(View.GONE);
                    arrow_trafoId.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_bottom, null));
                } else{
                    konten_trafoId.setVisibility(View.VISIBLE);
                    arrow_trafoId.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_up, null));
                }
            }
        });
        button_dg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(konten_dg.getVisibility() == View.VISIBLE){
                    konten_dg.setVisibility(View.GONE);
                    arrow_dg.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_bottom, null));
                } else{
                    konten_dg.setVisibility(View.VISIBLE);
                    arrow_dg.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_up, null));
                }
            }
        });
        button_dc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(konten_dc.getVisibility() == View.VISIBLE){
                    konten_dc.setVisibility(View.GONE);
                    arrow_dc.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_bottom, null));
                } else{
                    konten_dc.setVisibility(View.VISIBLE);
                    arrow_dc.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_up, null));
                }
            }
        });
        button_furan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(konten_furan.getVisibility() == View.VISIBLE){
                    konten_furan.setVisibility(View.GONE);
                    arrow_furan.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_bottom, null));
                } else{
                    konten_furan.setVisibility(View.VISIBLE);
                    arrow_furan.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_up, null));
                }
            }
        });
        button_dpk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(konten_dpk.getVisibility() == View.VISIBLE){
                    konten_dpk.setVisibility(View.GONE);
                    arrow_dpk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_bottom, null));
                } else{
                    konten_dpk.setVisibility(View.VISIBLE);
                    arrow_dpk.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.arrow_up, null));
                }
            }
        });

        meaDate = (EditText) findViewById(R.id.input_meaDate);

        meaDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        double a = ((1.0/200)-(1.0/1057.13))/(0.67*Math.pow(10,8)*24*365);
        double b = Math.exp((111000.0/(8.314*(30+68+273))));
        double ab = a*b;


//        wf.addTextChangedListener(new TextWatcher() {
//            public void afterTextChanged(Editable s) {
//
//                if (s.length()>0) {
//                    wp.requestFocus();
//                    del_input_factor.setVisibility(View.GONE);
//                    del_input_param.setVisibility(View.VISIBLE);
//                }
//
//            }
//
//            public void beforeTextChanged(CharSequence s, int start, int count,
//                                          int after) {
//                wf.requestFocus();
//            }
//
//            public void onTextChanged(CharSequence s, int start, int before,
//                                      int count) {
//
//            }
//        });


    }

    private void showDateDialog(){
        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                meaDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }

    public double hasil(double wf, double wp){
        return wf*wp;
    }
}
