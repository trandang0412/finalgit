package com.example.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ewasteHelper {
    String DATABASE_NAME = "EwasteDB.sqlite";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase db = null;

    Context context;


    public ewasteHelper(Context context) {
        this.context = context;

        processSQLite();
    }

    private void processSQLite() {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try{
                CopyDatabaseFromAsset();
                Toast.makeText(context, "Copy successful !!!", Toast.LENGTH_SHORT).show();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private void CopyDatabaseFromAsset() {
        try{
            InputStream databaseInputStream = context.getAssets().open(DATABASE_NAME);

            String outputStream = getPathDatabaseSystem();

            File file = new File(context.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!file.exists()){
                file.mkdir();
            }

            OutputStream databaseOutputStream = new FileOutputStream(outputStream);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = databaseInputStream.read(buffer)) > 0){
                databaseOutputStream.write(buffer,0,length);
            }


            databaseOutputStream.flush();
            databaseOutputStream.close();
            databaseInputStream.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private String getPathDatabaseSystem() {
        return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
    }

    public ArrayList<Ewaste> getAllEwaste(){
        ArrayList<Ewaste> arrayList = new ArrayList<>();

        db = context.openOrCreateDatabase(DATABASE_NAME,context.MODE_PRIVATE,null);

        String sql = "SELECT * FROM ewaste";

        Cursor cursor  = db.rawQuery(sql ,null);
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String value = cursor.getString(2);
            arrayList.add(new Ewaste(id, name, value));
        }
        return arrayList;
    }

   public ArrayList<Ewaste> getdata1(){
        ArrayList<Ewaste> arrayList = new ArrayList<>();
       db = context.openOrCreateDatabase(DATABASE_NAME,context.MODE_PRIVATE,null);
       String sql = "SELECT Value FROM ewaste where Id = '1'";

       Cursor cursor  = db.rawQuery(sql ,null);

       while (cursor.moveToNext()){
           String id = cursor.getString(0);
           String name = cursor.getString(1);
           String value = cursor.getString(2);
           arrayList.add(new Ewaste(id, name, value));

       }
        return arrayList;
   }
}
