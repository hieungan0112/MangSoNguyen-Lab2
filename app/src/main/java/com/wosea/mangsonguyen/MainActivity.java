package com.wosea.mangsonguyen;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et_day;
    TextView tv_kq;
    Button taoday,xuatxuoi,xuatnguoc,minmax,tangdan,giamdan,tongchan,tongle;
    int myArray[] =new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_day=(EditText)findViewById(R.id.editText); 
        tv_kq=(TextView)findViewById(R.id.textView2); //textView1 ta sửa thuộc tính Text trong giao diện là "Dãy ngẫu nhiên"
        taoday=(Button)findViewById(R.id.button);
        xuatxuoi=(Button)findViewById(R.id.button3);
        xuatnguoc=(Button)findViewById(R.id.button4);
        minmax=(Button)findViewById(R.id.button5);
        tangdan=(Button)findViewById(R.id.button6);
        giamdan=(Button)findViewById(R.id.button7);
        tongchan=(Button)findViewById(R.id.button8);
        tongle=(Button)findViewById(R.id.button9);

        taoday.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Random rd=new Random();
                String chuoi="";
                for(int i=0;i<10;i++)
                {
                    //mang[i]=rd.nextInt(10); //từ 0 đến 9
                    myArray[i]=rd.nextInt(50-10+1)+10; //từ 10->50 // (b-a+1)+a
                }
                ArraytoEditText();
            }

        });
        xuatxuoi.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ArraytoEditText();
            }
        });
        xuatnguoc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String chuoi="";
                for(int i=9;i>=0;i--)
                {
                    chuoi+= myArray[i]+ " ";
                }
                et_day.setText(chuoi);
            }
        });
        minmax.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int min=myArray[0];
                int max=myArray[0];
                for(int i=0;i<10;i++)
                {
                    if(myArray[i]<min) min=myArray[i];
                    if(myArray[i]>max) max=myArray[i];
                }
                tv_kq.setText("Min: "+min + " max: "+max);
            }
        });
        tangdan.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int temp;
                for (int i = 0 ; i < myArray.length - 1; i++) {
                    for (int j = i + 1; j < myArray.length; j++) {
                        if (myArray[i] > myArray[j]) {
                            temp = myArray[j];
                            myArray[j] = myArray[i];
                            myArray[i] = temp;
                        }
                    }
                }
                ArraytoEditText();
            }
        });
        giamdan.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int temp;
                for (int i = 0 ; i < myArray.length - 1; i++) {
                    for (int j = i + 1; j < myArray.length; j++) {
                        if (myArray[i] < myArray[j]) {
                            temp = myArray[j];
                            myArray[j] = myArray[i];
                            myArray[i] = temp;
                        }
                    }
                }
                ArraytoEditText();
            }

        });
        tongchan.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int sumeven=0;
                for(int i=0;i<10;i++) {
                    if (myArray[i] % 2 == 0)
                        sumeven += myArray[i];
                }
                tv_kq.setText("Tong cac so chan: "+sumeven);
            }
        });
        tongle.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                int sumodd=0;
                for(int i=0;i<10;i++)
                    if(myArray[i]%2 !=0)
                        sumodd += myArray[i];
                tv_kq.setText("Tong cac so le: "+sumodd);
            }
        });

    }
    public void ArraytoEditText()
    {
        String chuoi="";
        for(int i=0;i<10; i++)
        {
            chuoi +=myArray[i]+ " ";
        }
        et_day.setText(chuoi);
    }
}