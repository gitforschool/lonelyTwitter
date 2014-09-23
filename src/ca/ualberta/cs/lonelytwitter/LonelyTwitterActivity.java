package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private HashSet<String> values;
	private TextView oldTweetsCount;
	public ArrayList<LonelyTweetModel> tweets;
	private ArrayAdapter<LonelyTweetModel> adapter;
	public static String EXTRA_DATA = "tweets";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		values = new HashSet<String>();

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		oldTweetsCount = (TextView) findViewById(R.id.oldTweetsTitle);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				tweets.add(new LonelyTweetModel(text));
				adapter.notifyDataSetChanged();
				saveInFile();

			}
		});
	}

	public ArrayList<LonelyTweetModel> getTweets() {
		return tweets;
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		if ( tweets == null ) {
			tweets = new ArrayList<LonelyTweetModel>();
		}
		adapter = new ArrayAdapter<LonelyTweetModel>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	public void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader irs = new InputStreamReader(fis);
			// From http://www.javacreed.com/simple-gson-example/ - Sept. 22,2014
			Gson gson = new Gson();
			tweets = gson.fromJson(irs, new TypeToken<ArrayList<LonelyTweetModel>>() {}.getType());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showSecondActivity(View view) {
		Toast.makeText(getApplicationContext(), "Go To Second Activity", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(getApplicationContext(), LonelyTwitterActivity2.class);
		startActivity(intent);
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			Gson gson =  new Gson();
			gson.toJson(tweets, osw);
			osw.flush();
			osw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}