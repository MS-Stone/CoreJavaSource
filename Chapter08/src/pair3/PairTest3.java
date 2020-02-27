package pair3;
import pair1.Pair;

import java.time.LocalDate;

/**
 * @author Stone
 */
public class PairTest3 {
    public static void main(String[] args) {
        var ceo = new Manager("Gus", 800000, 2003, 12, 15);
        var cfo = new Manager("Sid", 600000, 2003, 12, 15);
        var buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo, cfo};

        var result = new Pair<Employee>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
         + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if(a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for(int i = 0; i < a.length; i++) {
            if(min.getBonus() > a[i].getBonus()) min = a[i];
            if(max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        if(a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for(int i = 0; i < a.length; i++) {
            if(min.getBonus() > a[i].getBonus()) min = a[i];
            if(max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(max);
        result.setSecond(min);
    }
}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {swapHelper(p);}

    public static <T> void swapHelper(Pair<T> p) {
            T temp = p.getFirst();
            p.setFirst(p.getSecond());
            p.setSecond(temp);
    }
}

class Employee{
    private String name;
    private double salary;
    private LocalDate hireDay;

    Employee() {name = null; salary = 0; hireDay = null;}
    Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent;
    }
}

class Manager extends Employee {
    private double bonus;

    Manager() {
        super();
        bonus = 0;
    }
    Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
