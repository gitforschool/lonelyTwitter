package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetListModel
{
	private ArrayList<LonelyTweetModel> tweets;
	
	public TweetListModel() {
		super();
		tweets = new ArrayList<LonelyTweetModel>();
	}
	
	public void add(LonelyTweetModel lonelyTweetModel)
	{
		if (tweets.contains(lonelyTweetModel)) {
			throw new IllegalArgumentException();
		} else {
			tweets.add(lonelyTweetModel);
		}
	}

	public int getCount()
	{
		return tweets.size();
	}

	public LonelyTweetModel getItem(int i)
	{
		return tweets.get(i-1);
	}

	public ArrayList<LonelyTweetModel> getTweets()
	{
		ArrayList<LonelyTweetModel> moreTweets = new ArrayList<LonelyTweetModel>(tweets);
		return moreTweets;
	}

	public boolean hasTweet(LonelyTweetModel tweet)
	{
		if (tweets.contains(tweet)) {
			return true;
		} else {
			return false;
		}
	}

	
}
