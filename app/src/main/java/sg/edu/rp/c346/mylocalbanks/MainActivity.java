package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv1;
TextView tv2;
TextView tv3;
String selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.tvfir);
        tv2=findViewById(R.id.tvSec);
        tv3=findViewById(R.id.tvThir);
        registerForContextMenu(tv1);
        registerForContextMenu(tv2);
        registerForContextMenu(tv3);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.tvfir)
        {selected="dbs";}
        else if(v.getId() == R.id.tvSec)
        {selected="ocbc";}

        else if(v.getId() == R.id.tvThir)
        {selected="uob";}

        menu.add(0,0,0,getResources().getString(R.string.cont1));
        menu.add(0,1,1,getResources().getString(R.string.cont2));
        // …

    }
    public boolean onContextItemSelected(MenuItem item) {
        // …

        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            if(selected.equalsIgnoreCase("dbs")){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getResources().getString(R.string.bank1P)));
                startActivity(intentCall);


            }else if(selected.equalsIgnoreCase("ocbc")){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getResources().getString(R.string.bank2P)));
                startActivity(intentCall);

            }else if(selected.equalsIgnoreCase("uob")){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getResources().getString(R.string.bank3P)));
                startActivity(intentCall);

            }
            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            if(selected.equalsIgnoreCase("dbs")){
                Intent intentCall=new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.bank1E)));
                startActivity(intentCall);


            }else if(selected.equalsIgnoreCase("ocbc")){
                Intent intentCall=new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.bank2E)));
                startActivity(intentCall);

            }else if(selected.equalsIgnoreCase("uob")){
                Intent intentCall=new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.bank3E)));
                startActivity(intentCall);

            }
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tv1.setText(getResources().getString(R.string.bank1));
            tv2.setText(getResources().getString(R.string.bank2));
            tv3.setText(getResources().getString(R.string.bank3));
            return true;
        }else if (id == R.id.ChineseSelection) {

            tv1.setText(getResources().getString(R.string.bank1C));
            tv2.setText(getResources().getString(R.string.bank2C));
            tv3.setText(getResources().getString(R.string.bank3C));
            return true;
        }else  {
            tv1.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}
