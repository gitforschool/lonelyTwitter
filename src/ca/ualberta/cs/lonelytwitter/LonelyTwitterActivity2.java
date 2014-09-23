package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class LonelyTwitterActivity2 extends LonelyTwitterActivity
{
	
	private static String FILENAME = "file.sav";
	private ArrayList<LonelyTweetModel> tweets;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lonely_twitter_activity2);
		
		tweets = new ArrayList<LonelyTweetModel>(super.tweets); 
		
		System.out.println("Size : " + tweets.size());
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lonely_twitter_activity2, menu);
		return true;
	}


}
