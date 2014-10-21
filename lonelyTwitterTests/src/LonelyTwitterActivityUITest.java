import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.R;



public class LonelyTwitterActivityUITest extends
ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{
	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest()
	{

		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}

	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
	
	public void testMakeTweet() throws Throwable {
		makeTweet("ola!");
		//IntentReaderActivity activity = (IntentReaderActivity)getActivity();

		// This is useful for testing UI functionality
		runTestOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
			}
		});
	}
}
