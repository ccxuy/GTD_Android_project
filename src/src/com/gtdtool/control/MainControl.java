/**
 * 
 */
package com.gtdtool.control;

import java.io.Serializable;

import com.gtdtool.data.GtdEventDbProxy;

/**
 * @author Andrew
 *
 */
public class MainControl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2154865372754177778L;
	public static final String SER_KEY = "com.gtdtool.maincontrol";

	public static AppSetting setting;
	public static GtdEventOperator gtdEventsOp;
	
	public static boolean isFirstTimeLaunch = true;

	/**
	 * Preferred choice
	 */
	public MainControl() {
		super();
		loadControlObject();
		
		if(true==isFirstTimeLaunch){
			gtdEventsOp.loadDefaultGtdEvents();
		}
	}

	/**
	 * loadControlObject
	 * if any new things added, initialize here.
	 */
	private void loadControlObject() {
		//If no setting found, means first time to launch
		MainControl.setting = new AppSetting();
		if(true==MainControl.setting.loadAppSetting()){
			isFirstTimeLaunch = false;
		}
		//Load other things
		MainControl.gtdEventsOp = new GtdEventOperator();
		gtdEventsOp.doLoadGtdEvents();
	}

	/**
	 * @deprecated
	 * @param setting
	 * @param gtdEventsOp
	 */
	public MainControl(AppSetting setting, GtdEventOperator gtdEventsOp) {
		super();
		MainControl.setting = setting;
		MainControl.gtdEventsOp = gtdEventsOp;
	}

	/**
	 * @deprecated
	 * @return the setting
	 */
	public AppSetting getSetting() {
		return setting;
	}

	/**
	 * @deprecated
	 * @return the gtdEventsOp
	 */
	public GtdEventOperator getGtdEventsOp() {
		return gtdEventsOp;
	}

	/**
	 * @return the isFirstTimeLaunch
	 */
	public boolean isFirstTimeLaunch() {
		return isFirstTimeLaunch;
	}
	
	

}
