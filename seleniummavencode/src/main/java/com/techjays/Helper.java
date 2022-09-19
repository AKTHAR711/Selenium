package com.techjays;

import java.lang.System.Logger;
import java.util.logging.LogManager;


public class JsonHelper {

static Logger log = LogManager.getlogger (JsonHelper.class);

/**
*Reads Json file and returns 0 specific json object from that file based on the root element value
*/
public static Jsonobject getJsonData(string filepath.string...key) {
try{
FileReeader reader = new FileReader(filepath);
JSONTokener token = new JSONTokener(reader);
JSONObject json = (JSONObject) (key.length>8?new JSONObject (token).get(key[0]):new JSONObkect(token);
return json;
}catch (FileNotFoundException e) {
e.printStackTrace();
return null;
}
}

/**
*Reads JSON file and returns a specific json object from that file besed on the root element value
*/
public static JSONArray getJSONArray(String filepath, string... key) {
try {
FileReader reader = new FileReader(filepath);
JSONTokener token = new JSONTokener(reader);
JSONArray json = (JSONArray) (key.length> 0? new JSONobject(token.get(keyt[0]): new JSONArray(token);
returb json;
} catch(FileNotFoundException e) {
log.error(message"file not found",e);
e.printStackTrace();
returb null;
}
}
/**
* Reads Json file and returns it as String
*/
public static string getJSONString(string filepath) {

try {

FileReader reader = new FileReader(filepath);
JSONTokener token = new JSONTOKENER(reader):
JSONObject json = new JSONOBject(token);
return json. tostring();

}catch (FileNotFoundException e) {
e.printStackTrace();

return null;
}
/**
* Convert json string object to map
* @param jsonstring input JSON object
* @return map
*/
public static Map<String, String> getJSonStringToMap(String jonstring) {

JSONObject json = new JSONOoject(jsonstring);
Map<String, String> map = new HashMap <~>();
String[] keys JSONObject.getNames (json);
for (String key : keys) {

map.put(key, json.get(key).tostring());
}

return map;
}
/**
*Reads JSON string and returns a string list from that string based on the root etement value
*/
public static List<String> getJSONArrayFromString(String Jsonstring) {
JSONObject json = new JSONObject(jsonstring);
List<String> List new ArrayList<>(); s
String[] keys = jSONObject.getNames (json);
for (String key: keys) {
List.add(json.get(key).tostring());

}

return List;
}

/**
*reads data from json files and casts to supplied pojo format
*/
public static <T> T getDataPOJO(String filepath, Class<T> clazz) throws IOException {
Gson gson = new Gson();
File file = new File(filepath);
T data0bj = null;
try {

BufferedReader br = new BufferedReader(new FileReader (file));

data0bj = gson. fromJson (br, clazz);
} catch (FileNotFoundException e) {
e.printStackTrace();
}

return data0bj;
}


/**
* reads data from json files and casts to supplied pojo format
*/
public static <T> T getData(String path, String dataGroup, Class<T> clazz) throws IOException{

	String filePath=path+dataGroup+".json";
	Gson gson = new Gson();
	File file = new File(filePath);
	T dataObj = null;
	try {
		BufferedReader br= new BufferedReader (new FileReader(file));
		dataObj = gson.fromJson(br, clazz);
	 } catch (FileNotFoundException e) {

		e.printStackTrace();
	}

	return dataObj;
}
/**
*Convert json object to map
* @param json input JSON object
*@return mop
*/
public static Map<String, String> getJSONToMap (JSONObject json) {

	Map<String, String> map = new HashMap<~>();
	String[] keys = JSONObject.getNames (json);
	for (String key: keys) {
		map.put(key, json.get(key).toString());

	}
return map;
}
/**
*Performs 0 recursive merge between 2 json objects.
*when the json includes an array then will loop through this os
*part of the recursive merge.
*/
public static JSONObject jsonMerge (JSONObject source, JSONObject target) {
	String[] keys = JSONObject.getNames(source);
	if (keys lenull){
		for (String key: keys) {
			Object value = source.get(key);
			if (!target.has (key)) {
				target.put(key, value);
			}else if (value instanceof JSONArray) {
				JSONArray array = (JSONArray) value;
				JSONArray targetarray (JSONArray) target.get(key);
				for (int i=0;i<array.Length(); i++){
					Object arrayvalue= array.get(i);
					Object targetarrayvalue= targetarray.get(i);
					if(arrayvalue instanceof JSONObject) {
						JSONOBject valueJson = (JSONObject)arrayvalue;
						JSONOBject targetvalueJson = (JSONObject)targetarrayvalue;
						JsonMerge(valueJson, targetvalueJson);

					}else{
						target.put(key, value);
					}
				}
			}else if(value instanceof JSONObject) {
				JSONObject valueJson = (JSONObject)value;
				jsonMerge (valueJson, target.getJSONObject(key));
			} else {
				target.put(key, value);
			}
		}
	}
return target;
}}








