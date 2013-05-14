/**
 * 
 */
package com.gtdtool.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.gtdtool.object.GtdEvent;

import android.os.Environment;
import android.util.Log;

/**
 * @author Andrew
 *
 */
public class AppSettingDbProxy {
	static String dataPath = Environment.getExternalStorageDirectory().getAbsolutePath();
	final static String SONG_LIST_TXT_FILENAME = "appsetting.txt";
	

	/**
	 * @param sil
	 */
	private static void saveAllViaTxt(String si){
		String mySDFileName = dataPath+"/"+SONG_LIST_TXT_FILENAME;
		try {	
	
			File file;
			if(!(file=new File(mySDFileName)) .exists()){
	    		file.createNewFile(); 
	    	}

			PrintWriter outfile= new PrintWriter( new FileWriter(mySDFileName) );
			if(true){
				outfile.println(si);
			}
			outfile.flush();
			outfile.close();
			Log.d("GtdEventDbProxy", "Write success: " +mySDFileName);
		} catch (FileNotFoundException e) {
			Log.w("GtdEventDbProxy", mySDFileName+ "Error: FileNotFoundException " + e.getMessage());
		} catch (IOException e) {			
			Log.w("GtdEventDbProxy", mySDFileName+" Error: " + e.getMessage());
		}
	}
	
	private static String loadAllViaTxt(){

		String mySDFileName = dataPath+"/"+SONG_LIST_TXT_FILENAME;	
		String state = Environment.getExternalStorageState();

		//Reset Song list
		List<GtdEvent> songList = new ArrayList<GtdEvent>();
		String res = "", str1 = "";	
		
		if (Environment.MEDIA_MOUNTED.equals(state)) {
		    // We can read and write the media
			try {
				File file = new File(mySDFileName);
				
				InputStream is = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(
						                    new InputStreamReader(is));
				if (is!=null) {							
					while ( null!=(str1=reader.readLine())) {
						res=str1;
					}				
				}		
				is.close();

				Log.d("GtdEventDbProxy", "Read success: " +mySDFileName+" => "+res);
			} catch (FileNotFoundException e) {
				Log.e("GtdEventDbProxy"
						, Environment.getExternalStorageDirectory().toString());
				e.printStackTrace();
			} catch (IOException e) {
				Log.e("GtdEventDbProxy"
						, Environment.getExternalStorageDirectory().toString());
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * TODO: use database instead of txt
	 * @return
	 */
	public static String loadAll() {
		return loadAllViaTxt();
	}
	
	
	/**
	 * TODO: use database instead of txt
	 * @return
	 */
	public static void saveAll(String s) {
		saveAllViaTxt(s);
	}
}
