package ca.ualberta.cs.lonelytwitter.test;
import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;



public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	
	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}

		
	public void testFiveIsFive() {
		assertEquals(5, 5);
	}
	
	public void testAddTweets() {
		TweetListModel tlm = new TweetListModel();
		tlm.add(new LonelyTweetModel("Test"));
		assertEquals(tlm.getCount(),1);
	}
	
	public void testGetItem() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel firstTweet = new LonelyTweetModel("test");
		tlm.add(firstTweet);
		assertSame(firstTweet, tlm.getItem(1));
	}
	
	public void testDuplicateArgument() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel firstTweet = new LonelyTweetModel("test");
		LonelyTweetModel secondTweet = new LonelyTweetModel("test");
		Boolean thrown = false;
		try {
			tlm.add(firstTweet);
			tlm.add(secondTweet);
		} catch(IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue("Exception was not Thrown", thrown.equals(true));
		//assertFalse("The tweets are duplicated", tlm.getItem(1).getText().equals(tlm.getItem(2).getText()));
	}
	
	public void testGetTweets() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel firstTweet = new LonelyTweetModel("test1");
		LonelyTweetModel secondTweet = new LonelyTweetModel("test2");
		tlm.add(firstTweet);
		tlm.add(secondTweet);
		
		assertTrue("Tweet count not equal", tlm.getTweets().size()==2);
		assertTrue("First Tweet is not equal from tlm's first tweet", tlm.getItem(1).equals(tlm.getTweets().get(0)));
		System.out.println("tlm tweet 1 : " + tlm.getItem(1) + ", getTweets() tweet : " + tlm.getTweets().get(0));
		assertTrue("Second Tweet is not equal from tlm's first tweet", tlm.getItem(2).equals(tlm.getTweets().get(1)));
		System.out.println("tlm tweet 2 : " + tlm.getItem(2) + ", getTweets() tweet : " + tlm.getTweets().get(1));
	}
	
	public void testHasTweet() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel firstTweet = new LonelyTweetModel("test1");
		LonelyTweetModel secondTweet = new LonelyTweetModel("test2");
		tlm.add(firstTweet);
		tlm.add(secondTweet);
		assertTrue("Tweet not found", tlm.hasTweet(firstTweet));
	}
	
	public void testGetCount() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel firstTweet = new LonelyTweetModel("test1");
		LonelyTweetModel secondTweet = new LonelyTweetModel("test2");
		tlm.add(firstTweet);
		tlm.add(secondTweet);
		assertTrue("There are 2 tweets in total", tlm.getCount() == 2);
	}
	
}
