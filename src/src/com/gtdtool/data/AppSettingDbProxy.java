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
	final static String SONG_LIST_TXT_FILENAME = "gtdEvent_list.txt";
	

	/**
	 * @param sil
	 */
	private static void saveAllGtdEventItemViaTxt(List<GtdEvent> sil){
		String mySDFileName = dataPath+"/"+SONG_LIST_TXT_FILENAME;
		try {	
	
			File file;
			if(!(file=new File(mySDFileName)) .exists()){
	    		file.createNewFile(); 
	    	}

			PrintWriter outfile= new PrintWriter( new FileWriter(mySDFileName) );
			for(GtdEvent si : sil){
				outfile.println(si.getId());
				outfile.println(si.getName());
				outfile.println(si.getEventType().toString());
				outfile.println(si.getEventStatus().toString());
				outfile.println(si.getBookmark());
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
	
	private static List<GtdEvent> loadAllGtdEventItemViaTxt(){

		String mySDFileName = dataPath+"/"+SONG_LIST_TXT_FILENAME;	
		String state = Environment.getExternalStorageState();

		//Reset Song list
		List<GtdEvent> songList = new ArrayList<GtdEvent>();
		
		if (Environment.MEDIA_MOUNTED.equals(state)) {
		    // We can read and write the media
			try {
				File file = new File(mySDFileName);
				
				String str1 = "",str2="",str3="",str4="",str5="";	
				InputStream is = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(
						                    new InputStreamReader(is));
				if (is!=null) {							
					while ( null!=(str1=reader.readLine())
							&& null!=(str2=reader.readLine())
							&& null!=(str3=reader.readLine())
							&& null!=(str4=reader.readLine())
							&& null!=(str5=reader.readLine())) {	
						songList.add(new GtdEvent(str1, str2, str3, str4, str5));
					}				
				}		
				is.close();

				Log.d("GtdEventDbProxy", "Read success: " +mySDFileName);
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
		return songList;
	}

	/**
	 * TODO: use database instead of txt
	 * @return
	 */
	public static List<GtdEvent> loadAllGtdEventItem() {
		return loadAllGtdEventItemViaTxt();
	}
	
	
	/**
	 * TODO: use database instead of txt
	 * @return
	 */
	public static void saveAllGtdEventItem(List<GtdEvent> el) {
		saveAllGtdEventItemViaTxt(el);
	}
}
