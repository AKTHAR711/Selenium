/**
*gets properties file
**/
public static PropertiesConfiguration getProperties (String propsPath) { 
   PropertiesConfiguration props = new PropertiesConfiguration();
   try{
       File propsfile = new File(propsPath);
       FileInputStream inputStream = new FileInputStream (propsFile);
       props.load(inputstream);
       inputstream.close();
  }catch(Exception e) {
    return null;
  }
  return props;
}

/**
*gets default properties file
**/
public static PropertiesConfiguration getDefaultProperties() { 
    PropertiesConfiguration props = new PropertiesConfiguration();
    try{
       File propsFile = new File(Constants.DEFAULTSETTINGS);
       FileInputStream inputStream = new FileInputStream(propsFile);
       props.load(inputstream); 
       inputStream.close();
}catch(Exception e) { 
   return null;
}
return props;
}

/**
*gets string data from any properties file on given path 
**/

public static string getEnvSpecificAppParameters(String key) { 
   String environmentsettings = PropertHyelper.getVariable(propname: "env") != null ? PropertyHelper.getVariable(propname:"env")
          : PropertyHelper.getDefaultProperty(key: "defaultEnvironment");
   return getProperties(propsPath: Constants.ENVIRONMENTPATH + environmentSettings+".properties").getstring(key);
 }

/**
*gets string data from any properties file en given path 
**/
public static String getDefaultProperty(String key) { return getProperties(Constants.DEFAULTSETTINGS).getString(key); }

/**
*gets string array data from any properties file an given poth
**/
public static string[] getPropertyArray(String propsPath, String key) {
   return getProperties (propsPath).getStringArray(key);
 }

/**
*gets value for variable based on preference of system property first then environment variable
**/
public static string getVariable(string propname) {
        String val= System.getProperty(propname,def:null);
        val=(val==null?System.getEnv(propname):val);
	return val;

 }

}