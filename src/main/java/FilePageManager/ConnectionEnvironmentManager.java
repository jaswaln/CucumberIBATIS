package FilePageManager;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import enums.EnvironmentType;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.Reader;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by Neeraj on 05-05-2019.
 */
public class ConnectionEnvironmentManager {
    private Connection connection;
    private static EnvironmentType environmentType;
    private static SqlMapClient sqlMapClient;
    private static SqlMapClientBuilder sqlMapClientBuilder;

    public ConnectionEnvironmentManager()
    {
        environmentType=FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

   public SqlMapClient getsqlMapClient(){
        if(sqlMapClientBuilder==null)sqlMapClient=createConnection();
        return sqlMapClient;
    }
    private SqlMapClient createConnection()
    {
        switch (environmentType)
        {
            case QA_CVA: sqlMapClient=createQAConnection();
               break;
            case PREPROD:sqlMapClient=createPREConnection();
                break;
        }
        return sqlMapClient;

    }
    private SqlMapClient createPREConnection()
    {
        return sqlMapClient;
    }
    private SqlMapClient createQAConnection()
    {
        try {
            Configuration sqlConfig = new PropertiesConfiguration(FileReaderManager.getInstance().getConfigReader().getSqlPropertyLocation());
            Properties databaseProperty = new Properties();
            databaseProperty.put("driver", sqlConfig.getString("driver").trim());
            databaseProperty.put("jdbcURL", sqlConfig.getString("jdbcURL").trim());
            databaseProperty.put("username", sqlConfig.getString("username").trim());
            databaseProperty.put("password", sqlConfig.getString("password").trim());

            System.out.println( "Creating Oracle Database connection using"
                    + "\n username :: " + databaseProperty.getProperty("username")
                    + "\n password :: " + databaseProperty.getProperty("password")
                    + "\n jdbcURL  :: " + databaseProperty.getProperty("jdbcURL")
                    + "\n driver   :: " + databaseProperty.getProperty("driver"));

            Reader reader = Resources.getResourceAsReader(FileReaderManager.getInstance().getConfigReader().getSqlConfigLocation());
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader, databaseProperty);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
            return  sqlMapClient;
    }
}
