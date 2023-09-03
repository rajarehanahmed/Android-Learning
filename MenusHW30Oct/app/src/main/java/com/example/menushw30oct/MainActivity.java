package com.example.menushw30oct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvClickable;
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvClickable = findViewById(R.id.tvClickable);
        btnPopup = findViewById(R.id.btnPopup);
        registerForContextMenu(tvClickable);

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this,btnPopup);
                MenuInflater popupMenuInflater = getMenuInflater();
                popupMenuInflater.inflate(R.menu.pop_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mainMenuInflater = getMenuInflater();
        mainMenuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menu1:
                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submenu1:
                Toast.makeText(this, "Sms", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submenu2:
                Toast.makeText(this, "Whatsapp", Toast.LENGTH_SHORT).show();
            case R.id.menuSwap:
                Toast.makeText(this, "Swap", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater contextMenuInflater = getMenuInflater();
        contextMenuInflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select Action");
        menu.setHeaderIcon(R.drawable.ic_baseline_swap_horiz_24);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.delete:
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rename:
                Toast.makeText(this, "Renamed", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}