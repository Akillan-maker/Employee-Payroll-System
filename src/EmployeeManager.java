import java.util.*;

public class EmployeeManager {

    public static HashMap<Integer,Employee> employeeHashMap=new HashMap<>();

    public static void managerOptions(Scanner scanner){

        b:while (true){
            System.out.println("*** Menu ***");
            System.out.println("1)Search\n2)Add\n3)Remove\n4)Sorted List\n5)Exit\nEnter the choice: ");
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    searchEmployee(scanner);
                    break;
                case 2:
                    addEmployee(scanner);
                    break;
                case 3:
                    removeEmployee(scanner);
                    break;
                case 4:
                    sortedList();
                    break;
                case 5:
                    break b;
            }
        }
    }

    public static void searchEmployee(Scanner scanner){

        try {
            System.out.println("Enter Employee id to search: ");
            int empId = Integer.parseInt(scanner.nextLine());
            if (employeeHashMap.containsKey(empId)) {
                Employee cur = employeeHashMap.get(empId);
                System.out.println(cur.toString());

            }
            else{
                System.out.println("No id Found...");
            }
        }catch (Exception e){
            System.out.println("No id Found...");
        }
    }

    public static void addEmployee(Scanner scanner){

        System.out.println("Enter Employee id to add: ");
        int etoAdd=Integer.parseInt(scanner.nextLine());
        if(!employeeHashMap.containsKey(etoAdd)){
            System.out.println("Enter Employee name: ");
            String ename=scanner.nextLine();
            System.out.println("Enter Department: ");
            String edept=scanner.nextLine();
            System.out.println("Enter Salary: ");
            long esalary=Long.parseLong(scanner.nextLine());

            Employee curEmp=new Employee(etoAdd,ename,edept,esalary);

            employeeHashMap.put(etoAdd,curEmp);
            System.out.println("Employee Added Successfully...");
            return;
        }
        System.out.println("Employee id Already Exists...");
    }

    public static void removeEmployee(Scanner scanner){

        System.out.println("Enter Employee id to remove: ");
        int etoRemove=Integer.parseInt(scanner.nextLine());
        if(employeeHashMap.containsKey(etoRemove)){
            Employee cur=employeeHashMap.get(etoRemove);
            employeeHashMap.remove(etoRemove,cur);
            System.out.println("Employee Removed Successfully...");
            return;
        }
        System.out.println("No id Found...");
    }

    public static void sortedList(){

        ArrayList<Employee> list=new ArrayList<>();

        for(int e:employeeHashMap.keySet()){
            Employee temp=employeeHashMap.get(e);
            list.add(temp);
        }

        if(!list.isEmpty()){
            Collections.sort(list);
            for(Employee l:list){
                System.out.println(l);
            }
        }
        else{
            System.out.println("No employee Found...");
        }
    }
}
