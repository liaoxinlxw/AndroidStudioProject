package com.example.lx.imageutils;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lx.imageutils.utils.MyLog;
import com.example.lx.imageutils.utils.Utils;

import java.io.FileNotFoundException;

public class ResizeImageActivity extends AppCompatActivity implements View.OnClickListener{
    //for test
    private TextView infoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize_image);
        infoText = (TextView) findViewById(R.id.info);
        findViewById(R.id.resize_image_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.resize_image_btn:
                Utils.choseImage(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            MyLog.e("uri", uri.toString());
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                String text = "原图尺寸：" + Utils.getFileSizeString(this, uri) + " "+ Utils.getDataSize(Utils.getBitmapSize(bitmap));

                bitmap = Utils.comp(bitmap);
                ImageView imageView = (ImageView) findViewById(R.id.image_preview);
                /* 将Bitmap设定到ImageView */
                imageView.setImageBitmap(bitmap);
                text += "\n压缩后大小：" + Utils.getDataSize(Utils.getBitmapSize(bitmap));
                infoText.setText(text);
            } catch (FileNotFoundException e) {
                MyLog.e("Exception", e.toString());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
