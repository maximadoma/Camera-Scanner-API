package com.example.barcodescanner;

import static com.example.barcodescanner.R.layout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);


        Button btn_scanner = findViewById(R.id.scan_btn);
        btn_scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeScan();
            }
        });

        codeScan();


    }

    //method to scan the barcode
    private void codeScan(){
        ScanOptions options = new ScanOptions();
        options.setCameraId(0);
        options.setPrompt(null);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
        options.setOrientationLocked(true);
        options.setBarcodeImageEnabled(true);
        options.setBeepEnabled(true);

        options.setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES);
   }

  

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result ->{
        if (result.getContents() != null){

            //to show the result to another window
            Intent Resultintent = new Intent (this, ResultWindow.class);
            Resultintent.putExtra("",result.getContents());
            startActivity(Resultintent);



//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("Information");
//            builder.setMessage(result.getContents());
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.dismiss();
//                }
//            }).show();
        }
    });




}