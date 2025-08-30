class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    public void calculateSalary() {
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {
    private double basicSalary;
    private double bonus;

    public FullTimeEmployee(int id, String name, double basicSalary, double bonus) {
        super(id, name);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    @Override
    public void calculateSalary() {
        setSalary(basicSalary + bonus);
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculateSalary() {
        setSalary(hourlyRate * hoursWorked);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        FullTimeEmployee ftEmployee = new FullTimeEmployee(101, "Alice", 50000, 5000);
        ftEmployee.calculateSalary();
        ftEmployee.displayDetails();

        PartTimeEmployee ptEmployee = new PartTimeEmployee(102, "Bob", 200, 120);
        ptEmployee.calculateSalary();
        ptEmployee.displayDetails();
    }
}
