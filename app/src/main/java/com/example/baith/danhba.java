package com.example.baith;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.baith.model.contact;

import java.net.URL;
import java.util.ArrayList;

public class danhba extends AppCompatActivity {
    private static final int  REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    ListView lv1;
    ArrayList<contact> dt;
    ArrayAdapter<contact> arrayadap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danhba);
         addcontrol();
        showall();
    }

    private void showall() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cur = getContentResolver().query(uri,null,null,null,null);
        dt.clear();
        while(cur.moveToNext()){
            String tencotName = ContactsContract.Contacts.DISPLAY_NAME;
            String tencotphone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            // lấy vij trí du lieu
            int vitricotname = cur.getColumnIndex(tencotName);
            int vitricotphone = cur.getColumnIndex(tencotphone);
            // lấy dữ liệu
            String name = cur.getString(vitricotname);
            String phone= cur.getString(vitricotphone);
            contact con = new contact(name,phone);
            dt.add(con);
            arrayadap.notifyDataSetChanged();

        }
    }

    private void addcontrol() {
        lv1 = findViewById(R.id.listview);
        dt = new ArrayList<>();
        arrayadap = new ArrayAdapter<>(danhba.this, android.R.layout.simple_list_item_1,dt);
        lv1.setAdapter(arrayadap);
    }

}