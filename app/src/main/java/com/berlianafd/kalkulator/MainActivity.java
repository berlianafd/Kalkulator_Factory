package com.berlianafd.kalkulator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    double nilai_oqf=0.249, nilai_ff=0.397, nilai_pcf=0.357;
    EditText wf,wp,resultt;
    ImageButton del_input_factor, del_param_oq, del_faults,del_paper;
    Button ac_input_factor, oqf, ff, pcf;
    Button ac_param_oq,  result_param_oq, bdv, water, acid, ift, col, ddf, sed;
    Button ac_faults, result_faults, h2, ch4, c2h4, c2h6, c2h2;
    Button ac_paper, result_paper, coco2, fal, age, dp;
    LinearLayout input_factor, input_param_oq, param_faults, param_paper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wf = (EditText) findViewById(R.id.wf);
        wp = (EditText) findViewById(R.id.wp);
        resultt = (EditText) findViewById(R.id.result);
        input_factor = (LinearLayout) findViewById(R.id.inputfactor);
        input_param_oq = (LinearLayout) findViewById(R.id.parameter_oil_quality);
        param_faults = (LinearLayout) findViewById(R.id.parameter_faults);
        param_paper = (LinearLayout) findViewById(R.id.parameter_paper);
//        button input factor
        ac_input_factor = (Button) findViewById(R.id.ac_input_factor);
        del_input_factor = (ImageButton) findViewById(R.id.del_input_factor);
        oqf = (Button) findViewById(R.id.oqf);
        ff = (Button) findViewById(R.id.ff);
        pcf = (Button) findViewById(R.id.pcf);

//        button input parameter oil
        ac_param_oq = (Button) findViewById(R.id.ac_param_oq);
        del_param_oq = (ImageButton) findViewById(R.id.del_param_oq);
        result_param_oq = (Button) findViewById(R.id.result_param_oq);
        bdv = (Button) findViewById(R.id.bdv_param_oq);
        water = (Button) findViewById(R.id.water_param_oq);
        acid = (Button) findViewById(R.id.acid_param_oq);
        ift = (Button) findViewById(R.id.ift_param_oq);
        col = (Button) findViewById(R.id.col_param_oq);
        ddf = (Button) findViewById(R.id.ddf_param_oq);
        sed = (Button) findViewById(R.id.sed_param_oq);

        //button input parameter faults
        ac_faults = (Button) findViewById(R.id.ac_faults);
        del_faults = (ImageButton) findViewById(R.id.del_faults);
        result_faults = (Button) findViewById(R.id.result_faults);
        h2 = (Button) findViewById(R.id.h2_faults);
        c2h2 = (Button) findViewById(R.id.c2h2_faults);
        c2h4 = (Button) findViewById(R.id.c2h4_faults);
        c2h6 = (Button) findViewById(R.id.c2h6_faults);
        ch4 = (Button) findViewById(R.id.ch4_faults);

//        button input parameter paper
        ac_paper = (Button) findViewById(R.id.ac_paper);
        del_paper = (ImageButton) findViewById(R.id.del_paper);
        result_paper = (Button) findViewById(R.id.result_paper);
        coco2 = (Button) findViewById(R.id.coco2_paper);
        fal = (Button) findViewById(R.id.fal_paper);
        age = (Button) findViewById(R.id.age_paper);
        dp = (Button) findViewById(R.id.dp_paper);

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

        del_input_factor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wf.setText("");
                input_factor.setVisibility(View.VISIBLE);
                input_param_oq.setVisibility(View.GONE);
                param_faults.setVisibility(View.GONE);
                param_paper.setVisibility(View.GONE);
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
        ac_param_oq.setOnClickListener(new View.OnClickListener() {
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

        del_param_oq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("");
                resultt.setText("");
            }
        });

        bdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("BDV");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.148)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("WATER");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.097)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

        acid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("ACID");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.136)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

        ift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("IFT");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.128)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

        col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("COL");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.126)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

        ddf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("DDF");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.251)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

        sed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("SED");
                resultt.setText(Double.toString(hasil(nilai_oqf, 0.115)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

        result_param_oq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultt.setTextColor(Color.GREEN);
            }
        });

        //klik on button faults
        ac_faults.setOnClickListener(new View.OnClickListener() {
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

        del_faults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("");
                resultt.setText("");
            }
        });

        result_faults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultt.setTextColor(Color.GREEN);
            }
        });

        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("H2");
                resultt.setText(Double.toString(hasil(nilai_ff, 2)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("CH4");
                resultt.setText(Double.toString(hasil(nilai_ff, 3)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
        c2h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("C2H4");
                resultt.setText(Double.toString(hasil(nilai_ff, 3)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
        c2h6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("C2H6");
                resultt.setText(Double.toString(hasil(nilai_ff, 3)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
        c2h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("C2H2");
                resultt.setText(Double.toString(hasil(nilai_ff, 5)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });

//        klik on button parameter paper
        ac_paper.setOnClickListener(new View.OnClickListener() {
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

        del_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("");
                resultt.setText("");
            }
        });

        result_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultt.setTextColor(Color.GREEN);
            }
        });

        coco2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("COCO2");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.203)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
        fal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("2FAL");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.261)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("AGE");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.242)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wp.setText("DP");
                resultt.setText(Double.toString(hasil(nilai_pcf, 0.294)));
                resultt.setTextColor(Color.parseColor("#4C4C4C"));
            }
        });
    }

    public double hasil(double wf, double wp){
        return wf*wp;
    }
}
