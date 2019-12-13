package asdf.zxcv.conversionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.app_menu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       switch (id){
           case R.id.menuitem_feet_to_meter:

           case R.id.menuitem_quit:
               finish();
    }
    return true;
}
