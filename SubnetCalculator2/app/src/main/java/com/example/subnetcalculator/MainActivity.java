package com.example.subnetcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtBox1;
    EditText txtBox2;
    EditText txtBox3;
    EditText txtBox4;
    EditText txtBox5;
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

        //Binding Views
        txtBox1 = findViewById(R.id.txtbox1);
        txtBox2 = findViewById(R.id.txtbox2);
        txtBox3 = findViewById(R.id.txtbox3);
        txtBox4 = findViewById(R.id.txtbox4);
        txtBox5 = findViewById(R.id.txtbox5);
        btnCalculate = findViewById(R.id.btn1);
        tvSubnetMask = findViewById(R.id.tvSubnetMask);
        tvNetId = findViewById(R.id.tvNetworkId);
        tvHostId = findViewById(R.id.tvHostId);
        tvNetFirstAdd = findViewById(R.id.tvNetFirstAdd);
        tvNetLastAdd = findViewById(R.id.tvNetLastAdd);

        //Fetching the saved values of text boxes
        SharedPreferences fetchSp = getSharedPreferences("ip address", MODE_PRIVATE);
        txtBox1.setText(fetchSp.getString("oct1", null));
        txtBox2.setText(fetchSp.getString("oct2", null));
        txtBox3.setText(fetchSp.getString("oct3", null));
        txtBox4.setText(fetchSp.getString("oct4", null));
        txtBox5.setText(fetchSp.getString("oct5", null));


        //Doing Action on Button Click
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtBox1.getText().toString().length() == 0 || txtBox2.getText().toString().length() == 0 || txtBox3.getText().toString().length() == 0 || txtBox4.getText().toString().length() == 0 || txtBox5.getText().toString().length() == 0)
                    Toast.makeText(MainActivity.this, "Some Octet(s) are/is empty", Toast.LENGTH_SHORT).show();
                else {
                    String temp;
                    temp = txtBox1.getText().toString();
                    int octet1 = Integer.parseInt(temp);
                    temp = txtBox2.getText().toString();
                    int octet2 = Integer.parseInt(temp);
                    temp = txtBox3.getText().toString();
                    int octet3 = Integer.parseInt(temp);
                    temp = txtBox4.getText().toString();
                    int octet4 = Integer.parseInt(temp);
                    temp = txtBox5.getText().toString();
                    int octet5 = Integer.parseInt(temp);
                    if((octet1 < 0 || octet1 > 255) || (octet2 < 0 || octet2 > 255) || (octet3 < 0 || octet3 > 255) || (octet4 < 0 || octet4 > 255) || (octet5 < 1 || octet5 > 31))
                        Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    else{
                        tvSubnetMask.setText(calculateSubnet(octet5));
                        tvNetId.setText(calculateNetworkId(octet1, octet2, octet3, octet4, octet5));
                        tvHostId.setText(calculateHostId(octet1, octet2, octet3, octet4, octet5));
                        tvNetFirstAdd.setText(calculateNetFirstAddress(octet1, octet2, octet3, octet4, octet5));
                        tvNetLastAdd.setText(calculateNetLastAddress(octet1, octet2, octet3, octet4, octet5));
                    }
                }
            }
        });
    }

    public String calculateSubnet(int num){
        String subnet = "";//Initially subnet string is empty
        int token = 128;
        int temp = 0;
        for(int i = 0; i < num; i++)
        {
            temp += token;
            if(token == 1 || i == num - 1)
            {
                if(i > 7)
                    subnet += '.';
                subnet += Integer.toString(temp);
                token = 256;
                temp = 0;
            }
            token -= token/2;
        }
        //Here the dot(.) occurrences in the subnet are calculated
        int dotCount = 0;
        for(int i = 0; i < subnet.length(); i++)
        {
            if(subnet.charAt(i) == '.')
                dotCount++;
        }
        //if subnet wasn't completely constructed, then here it'll be completed
        for(int i = 0; i < 3 - dotCount; i++)
        {
            subnet += '.';
            subnet += '0';
        }
        return subnet; //Return the constructed subnet in string
    }
    public String calculateNetworkId(int oct1, int oct2, int oct3, int oct4, int mask){

        String netId = "";
        int octet1 = oct1, octet2 = oct2, octet3 = oct3, octet4 = oct4;
        if(mask % 8 == 0)
        {
            if(mask == 8)
            {
                netId += Integer.toString(octet1);
            }
            else if(mask == 16)
            {
                netId += Integer.toString(octet1) + '.' + Integer.toString(octet2);
            }
            else if(mask == 24)
            {
                netId += Integer.toString(octet1) + '.' + Integer.toString(octet2) + '.' + Integer.toString(octet3);
            }
        }
        else if(mask % 8 != 0)
        {
            int remainder = mask / 8;
            if(remainder == 0)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct1);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < mask; i++)
                {
                    if(compltStrBin.charAt(i) == '1')
                        tmp += token;
                    token -= token / 2;
                }
                netId += Integer.toString(tmp);
            }
            else if(remainder == 1)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct2);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < mask % 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1')
                        tmp += token;
                    token -= token / 2;
                }
                netId += Integer.toString(octet1) + '.' + Integer.toString(tmp);
            }
            else if(remainder == 2)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct3);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < mask % 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1')
                        tmp += token;
                    token -= token / 2;
                }
                netId += Integer.toString(octet1) + '.' + Integer.toString(octet2) + '.' + Integer.toString(tmp);
            }
            else if(remainder == 3)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct4);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < mask % 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1')
                        tmp += token;
                    token -= token / 2;
                }
                netId += Integer.toString(octet1) + '.' + Integer.toString(octet2) + '.' + Integer.toString(octet3) + '.' + Integer.toString(tmp);
            }
        }
        return netId;
    }
    public String calculateHostId(int oct1, int oct2, int oct3, int oct4, int mask){
        String hostId = "";

        int octet1 = oct1, octet2 = oct2, octet3 = oct3, octet4 = oct4;
        if(mask % 8 == 0)
        {
            if(mask == 8)
            {
                hostId += Integer.toString(octet2) + '.' + Integer.toString(octet3) + '.' + Integer.toString(octet4);
            }
            else if(mask == 16)
            {
                hostId += Integer.toString(octet3) + '.' + Integer.toString(octet4);
            }
            else if(mask == 24)
            {
                hostId += Integer.toString(octet4);
            }
        }
        else if(mask % 8 != 0)
        {
            int remainder = mask / 8;
            if(remainder == 0)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct1);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' && i >= mask)
                        tmp += token;
                    token -= token / 2;
                }
                hostId += Integer.toString(tmp) + Integer.toString(octet2) + Integer.toString(octet3) + Integer.toString(octet4);
            }
            else if(remainder == 1)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct2);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' && i >= mask)
                        tmp += token;
                    token -= token / 2;
                }
                hostId += Integer.toString(tmp) + '.' + Integer.toString(octet3) + '.' + Integer.toString(octet4);
            }
            else if(remainder == 2)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct3);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' && i >= mask)
                        tmp += token;
                    token -= token / 2;
                }
                hostId += Integer.toString(tmp) + '.' + Integer.toString(octet4);
            }
            else if(remainder == 3)
            {
                String strBin;
                String compltStrBin = "";
                strBin = Integer.toBinaryString(oct4);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' && i >= mask)
                        tmp += token;
                    token -= token / 2;
                }
                hostId += Integer.toString(tmp);
            }
        }



//        if(oct1 >= 1 && oct1 <= 126)
//            hostId += Integer.toString(oct2) + '.' + Integer.toString(oct3) + '.' + Integer.toString(oct4);
//        else if (oct1 >= 128 && oct1 <= 191)
//            hostId += Integer.toString(oct3) + '.' + Integer.toString(oct4);
//        else if(oct1 >= 192 && oct1 <= 223)
//            hostId += Integer.toString(oct4);
//        else
//            hostId += "Class D,E are not divided into Network/Host ID";
        return hostId;
    }
    public String calculateNetFirstAddress(int oct1, int oct2, int oct3, int oct4, int mask){
        String firstAddress = "";
        int octet1 = oct1, octet2 = oct2, octet3 = oct3, octet4 = oct4;
        String strBin;
        String compltStrBin;
        if(mask % 8 != 0)
        {
            int remainder = mask / 8;
            if(remainder == 0) {
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct1);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < mask; i++)
                {
                    if(compltStrBin.charAt(i) == '1')
                         tmp += token;
                    token -= token / 2;
                }
                octet1 = tmp;
                octet2 = 0;
                octet3 = 0;
                octet4 = 1;
            }
            else if(remainder == 1){
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct2);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < mask % 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1')
                        tmp += token;
                    token -= token / 2;
                }
                octet2 = tmp;
                octet3 = 0;
                octet4 = 1;
            }
            else if (remainder == 2){
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct3);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < mask % 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1')
                        tmp += token;
                    token -= token / 2;
                }
                octet3 = tmp;
                octet4 = 1;
            }
            else if(remainder == 3) {
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct4);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for (int i = 0; i < mask % 8; i++) {
                    if (compltStrBin.charAt(i) == '1')
                        tmp += token;
                    token -= token / 2;
                }
                octet4 = tmp + 1; //Adding the last bit of first address
            }
        }
        else if(mask % 8 == 0)
        {
            if(mask == 8)
            {
                octet2 = 0;
                octet3 = 0;
                octet4 = 1;
            }
            else if(mask == 16)
            {
                octet3 = 0;
                octet4 = 1;
            }
            else if(mask == 24)
            {
                octet4 = 1;
            }
        }
        firstAddress += Integer.toString(octet1) + '.' + Integer.toString(octet2) + '.' + Integer.toString(octet3) + '.' + Integer.toString(octet4);

        return firstAddress;
    }
    public String calculateNetLastAddress(int oct1, int oct2, int oct3, int oct4, int mask) {
        String lastAdd = "";
        int octet1 = oct1, octet2 = oct2, octet3 = oct3, octet4 = oct4;
        String strBin;
        String compltStrBin;
        if(mask % 8 == 0)
        {
            if(mask == 8)
            {
                octet2 = 255;
                octet3 = 255;
                octet4 = 255;
            }
            else if(mask == 16)
            {
                octet3 = 255;
                octet4 = 255;
            }
            else if(mask == 24)
            {
                octet4 = 255;
            }
        }
        else if(mask % 8 != 0)
        {

            int remainder = mask / 8;
            if(remainder == 0)
            {
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct1);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' || i >= mask)
                        tmp += token;
                    token -= token / 2;
                }
                octet1 = tmp;
                octet2 = 255;
                octet3 = 255;
                octet4 = 255;
            }
            else if(remainder == 1)
            {
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct2);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' || i >= mask % 8)
                        tmp += token;
                    token -= token / 2;
                }
                octet2 = tmp;
                octet3 = 255;
                octet4 = 255;
            }
            else if(remainder == 2)
            {
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct3);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' || i >= mask % 8)
                        tmp += token;
                    token -= token / 2;
                }
                octet3 = tmp;
                octet4 = 255;
            }
            else if(remainder == 3)
            {
                compltStrBin = "";
                strBin = Integer.toBinaryString(oct4);
                for(int i = 0; i < 8 - strBin.length(); i++)
                    compltStrBin += '0';
                compltStrBin += strBin;
                int token = 128;
                int tmp = 0;
                for(int i = 0; i < 8; i++)
                {
                    if(compltStrBin.charAt(i) == '1' || i >= mask % 8)
                        tmp += token;
                    token -= token / 2;
                }
                octet4 = tmp;
            }
        }
        lastAdd += Integer.toString(octet1) + '.' + Integer.toString(octet2) + '.' + Integer.toString(octet3) + '.' + Integer.toString(octet4);

        return lastAdd;
    }

    @Override
    protected void onStop() {
        super.onStop();
        txtBox1 = findViewById(R.id.txtbox1);
        txtBox2 = findViewById(R.id.txtbox2);
        txtBox3 = findViewById(R.id.txtbox3);
        txtBox4 = findViewById(R.id.txtbox4);
        txtBox5 = findViewById(R.id.txtbox5);
        SharedPreferences saveSp = getSharedPreferences("ip address", MODE_PRIVATE);
        SharedPreferences.Editor editorSave = saveSp.edit();
        editorSave.putString("oct1", txtBox1.getText().toString());
        editorSave.putString("oct2", txtBox2.getText().toString());
        editorSave.putString("oct3", txtBox3.getText().toString());
        editorSave.putString("oct4", txtBox4.getText().toString());
        editorSave.putString("oct5", txtBox5.getText().toString());
        editorSave.apply();
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuRateUs:
                Intent intentSendRating = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intentSendRating);
                break;
            case R.id.menuAboutUs:
                Intent intentSendAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intentSendAbout);
        }
        return true;
    }
}
