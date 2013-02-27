package net.epsilonlabs.datamanagementefficient.test;

import net.epsilonlabs.datamanagementefficient.library.DataManager;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		DataManager dm = DataManager.getInstance(this);
		dm.open();
		
		WhiteList whitelist = new WhiteList();
		whitelist.getWhitelist().add(new Contact("1234567890"));
		int id = dm.add(whitelist);
		WhiteList wl2 = dm.get(WhiteList.class, id);
		
		dm.close();
		setContentView(tv);
	}
}