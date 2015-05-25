/**
 * 
 */
package com.example.weatherserviceapp.services;



import vandy.mooc.aidl.WeatherRequest;
import vandy.mooc.aidl.WeatherResults;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * @author bwoo
 *
 */
public class WeatherServiceAsync extends LifecycleLoggingService
{
	
	
    /**
     * Factory method that makes an Intent used to start the
     * WeatherServiceAsync when passed to bindService().
     * 
     * @param context
     *            The context of the calling component.
     */
    public static Intent makeIntent(Context context) {
        return new Intent(context,
        		WeatherServiceAsync.class);
    }
    
    
    /**
     * Called when a client (e.g., MyActivity) calls
     * bindService() with the proper Intent.  Returns the
     * implementation of WeatherRequest, which is implicitly cast as
     * an IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mWeatherRequestImpl;
    }
    
    
    /**
     * The concrete implementation of the AIDL Interface
     * WeatherRequest, which extends the Stub class that implements
     * WeatherRequest, thereby allowing Android to handle calls across
     * process boundaries.  This method runs in a separate Thread as
     * part of the Android Binder framework.
     * 
     * This implementation plays the role of Invoker in the Broker
     * Pattern.
     */
    WeatherRequest.Stub mWeatherRequestImpl = new WeatherRequest.Stub() 
    {
            /**
             * Implement the AIDL WeatherRequest expandWeather()
             * method, which forwards to DownloadUtils getResults() to
             * obtain the results from the Weather Web service and
             * then sends the results back to the Activity via a
             * callback.
             */
    	/*
            @Override
            public void expandWeather(String Weather,
                                      WeatherResults callback)
                throws RemoteException {

                // Call the Weather Web service to get the list of
                // possible expansions of the designated Weather.
                List<WeatherData> WeatherResults = 
                    Utils.getResults(Weather);

                // Invoke a one-way callback to send list of Weather
                // expansions back to the WeatherActivity.
                if (WeatherResults != null) {
                    Log.d(TAG, "" 
                          + WeatherResults.size() 
                          + " results for Weather: " 
                          + Weather);
                    callback.sendResults(WeatherResults);
                } else
                    callback.sendError("No expansions for " 
                                       + Weather
                                       + " found");
            }
            */

			@Override
			public void getCurrentWeather(String Weather, WeatherResults results)
					throws RemoteException
			{
				// TODO Auto-generated method stub
				Log.d(TAG, "----- WeatherServiceAsync.getCurrentWeather() -----");
				
				results.sendResults(null);
				
			}
	};
}
