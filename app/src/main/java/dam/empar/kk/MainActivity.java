package dam.empar.kk;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//public class MainActivity extends ActionBarActivity {
public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: remove logs
        Log.i("LOG KK", "PROVA DE LOGGING");

    }


    // menús
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView tvAction = (TextView)findViewById(R.id.tvAction);
        String action="Selected: ";

        switch (item.getItemId()){
            case R.id.action_bar_add: action+="ADD"; break;
            case R.id.action_bar_delete: action+="DELETE"; break;
            case R.id.action_bar_search: action+="SEARCH"; break;
            default: action+="SETTINGS"; break;
        }
       tvAction.setText(action);

       return true;
    }

    public void showPopUpMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);

        // set PopupMenu.OnMenuItemClickListener to this activity
        popup.setOnMenuItemClickListener(this);
        //inflate popup menu
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
        popup.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        try {
            Button button = (Button)findViewById(R.id.myButton);
            int color = 0;
            switch (item.getItemId()){
                case R.id.menu_red:
                    color = Color.parseColor("#ff0000");break;
                case R.id.menu_blue:
                   // getApplicationContext().getTheme() ---> throws error always because does not have all as activiy does
                    color = getResources().getColor(R.color.blue, this.getTheme()); break;
                    //color = Color.BLUE; break;
            }
            button.setTextColor(color);
        } catch (Resources.NotFoundException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


        return true;
    }
}
