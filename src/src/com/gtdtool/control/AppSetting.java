/**
 * 
 */
package com.gtdtool.control;

import com.gtdtool.data.AppSettingDbProxy;

/**
 * @author Andrew
 *
 */
public class AppSetting {
	
	/**
	 * TODO
	 * @return 
	 *     <p>true if application setting found </p>
	 *     <p>false if application setting NOT found </p>
	 */
	public boolean loadAppSetting(){
		if("true".equals( AppSettingDbProxy.loadAll() ) ){
			return true;
		}
		AppSettingDbProxy.saveAll("true");
		return false;
	}
	
	/**
	 * TODO
	 * @deprecated
	 */
	public void saveAppSetting(){
		
	}

}
