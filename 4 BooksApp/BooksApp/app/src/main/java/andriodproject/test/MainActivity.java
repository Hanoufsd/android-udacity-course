package andriodproject.test;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        TextView empty_view = (TextView) findViewById(R.id.empty_txt);
        empty_view.setText("please enter book title then click search to list all the books from Googel API");

        listView.setEmptyView(findViewById(R.id.empty_txt));

    }


    public void search_Clicked(View view) {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        ListView listView = (ListView) findViewById(R.id.listView);

        if (networkInfo != null && networkInfo.isConnected()) {

            EditText search_txt = (EditText) findViewById(R.id.search_txt);
            String searchQuery = search_txt.getText().toString().replaceAll(" ", "+");

            BookAsyncTask task = new BookAsyncTask();
            AsyncTask<String, Void, ArrayList<Result>> JSONData = task.execute(searchQuery);

            try {
                listView.setEmptyView(findViewById(R.id.empty_txt));
                String[] books = new String[JSONData.get().size()];

                String title, author;
                for (int i = 0; i < JSONData.get().size(); i++) {
                    title = "Title: " + String.valueOf(JSONData.get().get(i).getTitle());
                    author = "Author: " + String.valueOf(JSONData.get().get(i).getAuthor());
                    books[i] = title + "\n" + author;
                    title = "";
                    author = "";
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item, R.id.txt, books);
                listView.setAdapter(adapter);

            } catch (InterruptedException e) {
                Log.e(LOG_TAG, e.getMessage(), e);
                e.printStackTrace();
            } catch (ExecutionException e) {
                Log.e(LOG_TAG, e.getMessage(), e);
                e.printStackTrace();
            }
        }
        else
        {
            TextView No_activeNetwork = (TextView) findViewById(R.id.empty_txt);
            No_activeNetwork.setText("No Internet");
            listView.setEmptyView(findViewById(R.id.empty_txt));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item, R.id.txt);
            listView.setAdapter(adapter);
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}



