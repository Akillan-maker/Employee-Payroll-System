import java.util.Comparator;

public class Employee implements Comparable<Employee>{

    private int id;
    private String name;
    private String dept;
    private long salary;

    public Employee(int id,String name,String dept,long salary){

        this.id=id;
        this.name= name;
        this.dept=dept;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return "Employee id: "+this.getId()+"\nEmployee Name: "+this.getName()+"\nDepartment: "+this.getDept()+"\nSalary: "+String.format("₹%,d.2f",this.getSalary());
    }

    @Override
    public int compareTo(Employee a){

        return Integer.compare(this.getId(),a.getId());

    }
}