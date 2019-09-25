package iBatisTestQueries;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

/**
 * Created by Neeraj on 04-05-2019.
 */
public class IbatisInsert {
    public static void main(String[] args)throws IOException,SQLException{
        Reader rd = Resources.getResourceAsReader("META-INF/SqlMapConfig1.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

      /* This would insert one record in iBatisTestQueries.Employee table. */
        System.out.println("Going to insert record.....");
        Employee em = new Employee(4, "Ali", 5000);

        smc.insert("iBatisTestQueries.Employee.insert", em);

        System.out.println("Record Inserted Successfully ");
    }
}
