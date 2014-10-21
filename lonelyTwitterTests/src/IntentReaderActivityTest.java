import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import static android.test.ViewAsserts.assertOnScreen;


public class IntentReaderActivityTest extends
ActivityInstrumentationTestCase2<IntentReaderActivity>
{

	public IntentReaderActivityTest()
	{

		super(IntentReaderActivity.class);
		// TODO Auto-generated constructor stub
	}

	// Make sure he activity received the text
	public void testSendText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.NORMAL);

		// tells jUnit that were gonna start IntentReaderActivity with the following intent specified
		setActivityIntent(intent);
		// get the Activity, but since it will return a generic activity we must cast it to the activity we want
		IntentReaderActivity activity = (IntentReaderActivity)getActivity();
		assertEquals("some string ", activity.getText());
	}

	public void testDoubleText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);

		// tells jUnit that were gonna start IntentReaderActivity with the following intent specified
		setActivityIntent(intent);
		// get the Activity, but since it will return a generic activity we must cast it to the activity we want
		IntentReaderActivity activity = (IntentReaderActivity)getActivity();
		assertEquals("some string some string ", activity.getText());
	}

	public void testDisplayText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "some string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);

		// tells jUnit that were gonna start IntentReaderActivity with the following intent specified
		setActivityIntent(intent);
		// get the Activity, but since it will return a generic activity we must cast it to the activity we want
		IntentReaderActivity activity = (IntentReaderActivity)getActivity();
		assertEquals("some string some string ", activity.getView().getText());
	}

	public void testDisplayText2() throws Throwable {
		IntentReaderActivity activity = (IntentReaderActivity)getActivity();

		// This is useful for testing UI functionality
		runTestOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				getActivity().getView().setText("some string some string ");
			}
		});
		assertEquals("some string some string ", activity.getView().getText());
	}

	public void testReverseText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "HELLO");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity)getActivity();
		assertEquals("OLLEH", activity.getText());
	}

	public void testDefaultText() {
		Intent intent = new Intent();
		//intent.putExtra(IntentReaderActivity.TEXT_KEY, "");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.NORMAL);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity)getActivity();
		assertEquals("No message found!", activity.getText());
	}

	public void testVisibleView() throws Throwable {
		IntentReaderActivity activity = (IntentReaderActivity)getActivity();
		// This is useful for testing UI functionality
		runTestOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				getActivity().getView().setVisibility(getActivity().getView().INVISIBLE);
			}
		});
		assertOnScreen(activity.getWindow().getDecorView(), activity.getView());
	}

}
