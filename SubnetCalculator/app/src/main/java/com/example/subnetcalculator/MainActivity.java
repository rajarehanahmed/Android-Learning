package com.example.subnetcalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int input = 10;
    EditText txtBox1;
    Button btnCalculate;
    TextView tvSubnetMask;
    TextView tvNetId;
    TextView tvHostId;
    TextView tvNetFirstAdd;
    TextView tvNetLastAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBox1 = findViewById(R.id.txtbox1);
        btnCalculate = findViewById(R.id.btn1);
        tvSubnetMask = findViewById(R.id.tvSubnetMask);
        tvNetId = findViewById(R.id.tvNetworkId);
        tvHostId = findViewById(R.id.tvHostId);
        tvNetFirstAdd = findViewById(R.id.tvNetFirstAdd);
        tvNetLastAdd = findViewById(R.id.tvNetLastAdd);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = Integer.valueOf(txtBox1.getText().toString());
                Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();


                tvSubnetMask.setText(input);
//                calculateSubnet(input);

            }
        });
    }

    public String calculateSubnet(String input){
        String subnet = "";
        Boolean slash = false;
        String m = "";
        for(int i = 0; i < input.length(); i++)
        {
            if(slash)
                m += input.charAt(i);
            if(input.charAt(i) == '/')
                slash = true;
        }

        int token = 128;
        int temp = 0;
        for(int i = 0; i < Integer.getInteger(m); i++)
        {
            temp += token;
            token -= token/2;
            if(token == 0)
            {
                if(i != 7)
                    subnet += '.';
                subnet += Integer.toString(temp);
                token = 128;
                temp = 0;
            }
        }
        Toast.makeText(this, subnet, Toast.LENGTH_LONG).show();

        return subnet;
    }
}