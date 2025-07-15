package com.noob.dangvanchuong;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.app.AlertDialog;
import android.view.View;
import android.content.Context;

import com.noob.dangvanchuong.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AlertDialog.Builder dialog;

    // Lớp tiện ích
    public static class Chuong {
        public static void showMessage(Context _context, String _s) {
            Toast.makeText(_context, _s, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialog = new AlertDialog.Builder(this);

        binding.button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Chuong.showMessage(MainActivity.this, getString(R.string.noobpro));
                    }
                });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.exit_title))
                .setMessage(getString(R.string.exit_confirm_message))
                .setIcon(R.drawable.ic_exit)
                .setPositiveButton(getString(R.string.exit_ok), (dialog, which) -> finish())
                .setNegativeButton(getString(R.string.exit_cancel), null)
                .show();
    }
}