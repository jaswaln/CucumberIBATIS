package iBatisTestQueries;

/**
 * Created by Neeraj on 04-05-2019.
 */
public class Employee {
    private int emp_id;
    private String emp_name;
    private String last_name;
    private int emp_salary;

    /* Define constructors for the iBatisTestQueries.Employee class. */
    public Employee() {}

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", emp_salary=" + emp_salary +
                '}';
    }

    public Employee(int emp_id, String emp_name, int emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
    }

    public int getEmpId()
    {
        return emp_id;
    }
    public void setEmp_id(int emp_id)
    {
        this.emp_id=emp_id;
    }
    public String getEmpName()
    {
        return emp_name;
    }
    public void SetEmpName(String emp_name)
    {
        this.emp_name=emp_name;

    }
    public int getEmpSalary()
    {
        return emp_salary;
    }
    public void setEmpSalary(int emp_salary)
    {
        this.emp_salary=emp_salary;
    }
}
