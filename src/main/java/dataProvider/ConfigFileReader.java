package dataProvider;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Neeraj on 05-05-2019.
 */
public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= System.getProperty("user.dir")+"//config//configuration.properties";

    public ConfigFileReader()
    {
        BufferedReader reader;
        try{
            reader=new BufferedReader(new FileReader(propertyFilePath));
            properties=new Properties();
            try{
                properties.load(reader);
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
        }

    }
    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if(environmentName == null || environmentName.equalsIgnoreCase("QA_CVA")) return EnvironmentType.QA_CVA;
        else if(environmentName.equals("QA_CVA")) return EnvironmentType.QA_CVA;
        else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }
    public String getSqlPropertyLocation()
    {
        String sqlpropertylocation=properties.getProperty("sqlPropertyLocation");
        System.out.println(sqlpropertylocation);
        if(sqlpropertylocation!=null) return sqlpropertylocation;
        else throw new RuntimeException("SqlPropertyLocation is not specified in Configuration.properties file.");
    }
    public String getSqlConfigLocation()
    {
        String sqlConfigLocation=properties.getProperty("sqlConfigLocation");
        if(sqlConfigLocation!=null) return sqlConfigLocation;
        else throw new RuntimeException("sqlConfigLocation is not specified in Configuration.properties file.");
    }
}
