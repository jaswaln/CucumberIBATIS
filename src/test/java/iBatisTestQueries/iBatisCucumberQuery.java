package iBatisTestQueries;

import FilePageManager.ConnectionEnvironmentManager;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Neeraj on 06-05-2019.
 */
public class iBatisCucumberQuery  {

    Connection con;
  public static   ConnectionEnvironmentManager connectionEnvironmentManager;
   public static SqlMapClient sqlMapClient;
    public iBatisCucumberQuery()
    {
        connectionEnvironmentManager=new ConnectionEnvironmentManager();
        sqlMapClient=connectionEnvironmentManager.getsqlMapClient();

    }
    @Test
    public static void testInsertQuery()
    {
        System.out.println( " testInsertQueryUsingiBatis executed");
        Map<String, Object> searchparams = new HashMap<String, Object>();
        searchparams.put("emp_id",6);
        searchparams.put("emp_name","Gaurav");
        searchparams.put("emp_salary",8898);
        if (sqlMapClient != null) {
            try {
                sqlMapClient.insert("Common.addEmpDetails",searchparams);


                System.out.println("|Record Inserted Successfully|");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public static void testSelectQuery()
    {
        System.out.println( " testSelecttQueryUsingiBatis executed");
        Map<String, Object> searchparams = new HashMap<String, Object>();
        searchparams.put("emp_id",6);
        //searchparams.put("emp_name","Gaurav");
       // searchparams.put("emp_salary",8898);
        if (sqlMapClient != null) {
            try {
                List<Employee> e = sqlMapClient.queryForList("Common.useResultMap", searchparams);
                for (Employee emp : e) {
                    /*System.out.println("ID:  " + emp.getEmpId());
                    System.out.println("First Name:  " + emp.getEmpName());
                    System.out.println("Salary:  " + emp.getEmpSalary());*/
                    System.out.println(""+emp.toString());
                    System.out.println("|All recorded selected Successfully|");

                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
