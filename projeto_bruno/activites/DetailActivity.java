package com.example.projeto_bruno.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projeto_bruno.Domain.ItemsDomain;
import com.example.projeto_bruno.R;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {
private TextView titleTxt, addressTxt,bedTxt,bathTxt,wifiTxt,descriptionTxt,priceTxt;
private ItemsDomain item;
private ImageView pic;

DecimalFormat formatter=new DecimalFormat("###,###,###,##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        initView();
        setVariable();
    }

    private void setVariable() {
        item= (ItemsDomain) getIntent().getSerializableExtra("object");
        titleTxt.setText(item.getTitle());
        addressTxt.setText(item.getAddress());
        bedTxt.setText(item.getBed()+ "Bed");
        bathTxt.setText(item.getBath()+ "Bath");
        descriptionTxt.setText(item.getDescription());
        priceTxt.setText("$"+formatter.format(item.getPrice()));

        if(item.isWifi()){
            wifiTxt.setText("Wifi");
    }else{
            wifiTxt.setText("Sem Wifi");
        }
        int drawableResourceId=getResources().getIdentifier(item.getPic(),"drawable", getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(pic);
    }



    private void initView() {
        titleTxt=findViewById(R.id.titleTxt);
        addressTxt=findViewById(R.id.addressTxt);
        bedTxt=findViewById(R.id.bedTxt);
        bathTxt=findViewById(R.id.bathTxt);
        wifiTxt=findViewById(R.id.wifiTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        pic=findViewById(R.id.pic);
        priceTxt=findViewById(R.id.priceTxt);
    }
}