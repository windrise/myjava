import com.sun.corba.se.impl.ior.IORTemplateListImpl;

/*
通过super 关键字 实现对父类构造方法与成员方法的访问

 */
class Employee {
    private String name;
    private int salary;
    public Employee(String name,int salary){
        this.name=name;
        this.salary=salary;
    }

    public String getDetails(){
        return "Name: "+name+"\nSalary: "+salary;
    }
}

class Manager extends Employee{
    private String department;
    public Manager(String name, int salary, String department){
        super(name,salary);
        this.department=department;
    }
    public String getDetails(){
        return super.getDetails()+"\nDepartment: "+ department;
    }

}

public class TestSuper{
    public static void main(String[] args){
        Manager m = new Manager("Tom",2000,"Finance");
        System.out.println(m.getDetails());
    }
}
