package krunal.com.example.settingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String Tab = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.text1);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean social = preferences.getBoolean("example_switch",true);
        Log.i(Tab,String.valueOf(social));

        String list = preferences.getString("example_list","");
        Log.i("example_list",String.valueOf(list));

        String name = preferences.getString("example_text", "");
        Log.i("Name: ",name);

        String sync_frequency = preferences.getString("sync_frequency","");
        Log.i("sync_frequency",String.valueOf(sync_frequency));

        String notifications_new_message_ringtone = preferences.getString("notifications_new_message_ringtone","");
        Log.i("notifications",String.valueOf(notifications_new_message_ringtone));
        mTextView.setText(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
