/**
 * 
 */
package com.gtdtool.control;

import com.gtdtool.data.GtdEventDbProxy;

/**
 * @author Andrew
 *
 */
public class MainControl {
	private AppSetting setting;
	
	protected GtdEventOperator gtdEventsOp;
	
	public boolean isFirstTimeLaunch = true;

	/**
	 * Preferred choice
	 */
	public MainControl() {
		super();
		loadControlObject();
	}

	/**
	 * 
	 */
	private void loadControlObject() {
		//If no setting found, means first time to lauch
		if(true==this.setting.loadAppSetting()){
			isFirstTimeLaunch = false;
		}
		//Load other things
		this.gtdEventsOp = new GtdEventOperator(
				GtdEventDbProxy.loadAllGtdEventItem());
	}

	/**
	 * @param setting
	 * @param gtdEventsOp
	 */
	public MainControl(AppSetting setting, GtdEventOperator gtdEventsOp) {
		super();
		this.setting = setting;
		this.gtdEventsOp = gtdEventsOp;
	}

	/**
	 * @return the setting
	 */
	public AppSetting getSetting() {
		return setting;
	}

	/**
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
