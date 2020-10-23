package com.revature;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Timepiece {

	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//spam endpoint
				URL url;
				try {
					url = new URL("http://localhost:8081/alert/run");
					long time = System.currentTimeMillis();				
					
					try {
						HttpURLConnection con;
						con = (HttpURLConnection) url.openConnection();
						System.out.println(time);
						try {
							con.setRequestMethod("GET");
							System.out.println(con.getResponseCode());
						} catch (ProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Timer timer = new Timer();
		long delay = 0;
		long intervalPeriod = 45 * 1000;
		while(System.currentTimeMillis() % 100 != 0) {}
		timer.scheduleAtFixedRate(task, delay, intervalPeriod);
	}

}