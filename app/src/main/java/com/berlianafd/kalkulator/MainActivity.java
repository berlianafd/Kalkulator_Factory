package com.berlianafd.kalkulator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    double nilai_oqf=0.249, nilai_ff=0.397, nilai_pcf=0.357;
    EditText wf,wp;
    TextView resultt;
    ImageButton del_input_factor, del_input_param;
    Button ac_input_factor, oqf, ff, pcf;
    Button bdv, water, acid, ift, col, ddf, sed;
    Button h2, ch4, c2h4, c2h6, c2h2;
    Button coco2, fal, age, dp;
    LinearLayout input_factor, input_param_oq, param_faults, param_paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wf = (EditText) findViewById(R.id.wf);
        wp = (EditText) findViewById(R.id.wp);
        resultt = (TextView) findViewById(R.id.result);
        input_factor = (LinearLayout) findViewById(R.id.inputfactor);
        input_param_oq = (LinearLayout) findViewById(R.id.parameter_oil_quality);
        param_faults = (LinearLayout) findViewById(R.id.parameter_faults);
        param_paper = (LinearLayout) findViewById(R.id.parameter_paper);
//        button input factor
        ac_input_factor = (Button) findViewById(R.id.ac_input_factor);
        del_input_factor = (ImageButton) findViewById(R.id.del_input_factor);
        del_input_param = (ImageButton) findViewById(R.id.del_input_param);
        oqf = (Button) findViewById(R.id.oqf);
        ff = (Button) findViewById(R.id.ff);
        pcf = (Button) findViewById(R.id.pcf);

//        button input parameter oil
        bdv = (Button) findViewById(R.id.bdv_param_oq);
        water = (Button) findViewById(R.id.water_param_oq);
        acid = (Button) findViewById(R.id.acid_param_oq);
        ift = (Button) findViewById(R.id.ift_param_oq);
        col = (Button) findViewById(R.id.col_param_oq);
        ddf = (Button) findViewById(R.id.ddf_param_oq);
        sed = (Button) findViewById(R.id.sed_param_oq);

        //button input parameter faults
        h2 = (Button) findViewById(R.id.h2_faults);
        c2h2 = (Button) findViewById(R.id.c2h2_faults);
        c2h4 = (Button) findViewById(R.id.c2h4_faults);
        c2h6 = (Button) findViewById(R.id.c2h6_faults);
        ch4 = (Button) findViewById(R.id.ch4_faults);

//        button input parameter paper
        coco2 = (Button) findViewById(R.id.coco2_paper);
        fal = (Button) findViewById(R.id.fal_paper);
        age = (Button) findViewById(R.id.age_paper);
        dp = (Button) findViewById(R.id.dp_paper);


        wf.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (s.length()>0) {
                    wp.requestFocus();
                    del_input_factor.setVisibility(View.GONE);
                    del_input_param.setVisibility(View.VISIBLE);
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                wf.requestFocus();
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }
        });

//        klik on button input factor
        ac_input_factor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wf.setText("");
                wp.setText("");
                resultt.setText("");
                input_factor.setVisibility(View.VISIBLE);
                input_param_oq.setVisibility(View.GONE);
                param_faults.setVisibility(View.GONE);
                param_paper.setVisibility(View.GONE);
            }
        });

        wf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                del_input_factor.setVisibility(View.VISIBLE);
                del_input_param.setVisibility(View.GONE);
            }
        });

        del_input_factor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wf.setText("");
                resultt.setText("");
                input_factor.setVisibility(View.VISIBLE);
                input_param_oq.setVisibility(View.GONE);
                param_faults.setVisibility(View.GONE);
                param_paper.setVisibility(View.GONE);

                if(!wp.getText().equals("")){
                    wp.setText("");
                    wf.requestFocus();
                }
            }
        });

        wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                del_input_factor.setVisibility(View.GONE);
                del_input_param.setVisibility(View.VISIBLE);

                if (wf.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "Factor can't be blank!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        del_input_param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("");
                resultt.setText("");
            }
        });

        oqf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wf.setText("OQF");
                input_factor.setVisibility(View.GONE);
                input_param_oq.setVisibility(View.VISIBLE);
                param_faults.setVisibility(View.GONE);
                param_paper.setVisibility(View.GONE);
            }
        });

        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wf.setText("FF");
                input_factor.setVisibility(View.GONE);
                input_param_oq.setVisibility(View.GONE);
                param_faults.setVisibility(View.VISIBLE);
                param_paper.setVisibility(View.GONE);
            }
        });

        pcf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wf.setText("PCF");
                input_factor.setVisibility(View.GONE);
                input_param_oq.setVisibility(View.GONE);
                param_faults.setVisibility(View.GONE);
                param_paper.setVisibility(View.VISIBLE);
            }
        });

//        klik on button parameter oil
        bdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("BDV");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.148)));

            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("WATER");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.097)));

            }
        });

        acid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("ACID");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.136)));

            }
        });

        ift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("IFT");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.128)));

            }
        });

        col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("COL");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.126)));

            }
        });

        ddf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("DDF");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.251)));

            }
        });

        sed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("SED");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.115)));

            }
        });

        //klik on button faults
        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("H2");
                resultt.setText(Double.toString(hasil(nilai_ff, 2)));

            }
        });
        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("CH4");
                resultt.setText(Double.toString(hasil(nilai_ff, 3)));

            }
        });
        c2h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("C2H4");
                resultt.setText(Double.toString(hasil(nilai_ff, 3)));

            }
        });
        c2h6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("C2H6");
                resultt.setText(Double.toString(hasil(nilai_ff, 3)));

            }
        });
        c2h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("C2H2");
                resultt.setText(Double.toString(hasil(nilai_ff, 5)));

            }
        });

//        klik on button parameter paper
        coco2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("COCO2");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.203)));

            }
        });
        fal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("2FAL");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.261)));

            }
        });
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("AGE");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.242)));

            }
        });
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("DP");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.294)));

            }
        });
    }

    public double hasil(double wf, double wp){
        return wf*wp;
    }
}
