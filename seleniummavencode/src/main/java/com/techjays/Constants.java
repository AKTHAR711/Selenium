package com.techjays;

import java.nio.file.Files;
import java.nio.file.Paths;

//import ...

/**
*POJO used to define constants of selenium
**/

public class Constants {

private static final String targetPath = Helper.getAbsolutePath() + Helper.getFiteSeparator()+ "target" +Helper.getFileSeparator()+"test-classes";
public static final String BASEPATH = Files.isDirectory(Paths.get(targetPath)) ? targetPath + Helper.getFileSeparator(): Helper.getAbsolutePath() +  Helper.ge
public static final String DEFAULTSETTINGS = BASEPATH + "config" + Helper.getFileSeparator() + "defaultSettings.properties";
public static final String ENVIRONMENTPATH= BASEPATH +  "config" + Helper.getFileSeparator () +  "environments" +Helper.getFileseparator ();
public static final String DRIVERSTACKSPATH= BASEPATH +  "config" +  Helper.getFileSeparator()+ "driver"+ Helper.getFileSeparator();
public static final String TESTDATAPATH= BASEPATH+ "testData" Helper.getFileSeparator();
public static final String APISTRUCTUREPATH = BASEPATH +"apischema" + Helper.getFileSeparator();
public static final String BACKENDLOGS = Helper.getAbsolutePath() + Helper.getFileSeparator ()+"aws"+Helper.getFileSeparator();
public static final String DEFAULTEXCELPATH= System.getProperty("user.dir")+File.separator+"RunReports"+ File.separator+"ExcelReports";
public static final String EXCELREPORTPATH =DEFAULTEXCELPATH+File.separator +PropertyHelper.getDefaultProperty("defaultEnvironment")+"_ExcelReport_"+ new

}
