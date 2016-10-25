package com.qmetry.pm.utiles;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sun.org.apache.regexp.internal.recompile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

 
public class BLEUtils {

 
 
	public static String  BLEStartChar(String uuid,String value,RemoteWebDriver d) {
		
 		
		Map<String, String> params = new HashMap<String, String>();
		params.put("uuid", uuid);
		params.put("type", "changeable");
		params.put("valueType", "int");
		params.put("value", value);
		params.put("property", "notify");
		params.put("Action", "GEN_CHAR");
		 
		String charID =	(String) d.executeScript("mobile:BLE:GenerateChar", params);
		return charID;
	}
	
	public static void BLESetValue(String uuid,String charID,String value,RemoteWebDriver d) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("uuid", uuid);
		params.put("value", value);
		params.put("BLEdevice", charID);
		params.put("Action", "SET_VAL");
		
		 
		d.executeScript("mobile:BLE:SetValue", params);
	}
	public static void BLEstop(String BLEID,RemoteWebDriver d) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("BLEID", BLEID);
	 	params.put("Action", "STOP");
		
		 
		d.executeScript("mobile:BLE:SetValue", params);
	}
 
	 ///  ** PMTL *** //
	public static void PMTLStart(RemoteWebDriver d) {
		Map<String, String> params = new HashMap<String, String>();
 	 	params.put("Action", "START");
			 
		d.executeScript("mobile:PMTL:start", params);
	}
	public static Object PMTLStop(RemoteWebDriver d) {
		Map<String, String> params = new HashMap<String, String>();
 	 	params.put("Action", "STOP");
			 
		return d.executeScript("mobile:PMTL:stop", params);
	}
	
 	public static void downloadAttachment(RemoteWebDriver driver, String fileName, String suffix) throws IOException {
		try {
			String command = "mobile:report:attachment";
			boolean done = false;
			int index = 0;

			while (!done) {
				Map<String, Object> params = new HashMap<>();	

				params.put("type", "network");
				params.put("index", Integer.toString(index));

				String attachment = (String)driver.executeScript(command, params);

				if (attachment == null) { 
					done = true; 
				}
				else { 
					File file = new File(fileName + index + "." + suffix); 
					BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file)); 
					byte[] bytes = OutputType.BYTES.convertFromBase64Png(attachment);	
					output.write(bytes); 
					output.close(); 
					index++; }
			}
		} catch (Exception ex) { 
			System.out.println("Got exception " + ex); 
		}
	}
}
