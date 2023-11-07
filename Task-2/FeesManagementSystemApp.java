import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private double totalFee;
    private double feePaid;

    public Student(String studentId, String name, double totalFee) {
        this.studentId = studentId;
        this.name = name;
        this.totalFee = totalFee;
        this.feePaid = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(double feePaid) {
        this.feePaid = feePaid;
    }

    public double getRemainingBalance() {
        return totalFee - feePaid;
    }
}

class FeesManagementSystem {
    private List<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentId, String name, double totalFee) {
        Student student = new Student(studentId, name, totalFee);
        students.add(student);
    }

    public void makePayment(String studentId, double amount) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                double remainingBalance = student.getRemainingBalance();
                if (amount <= remainingBalance) {
                    double updatedFeePaid = student.getFeePaid() + amount;
                    student.setFeePaid(updatedFeePaid);
                    System.out.println("Fees paid successfully: $" + amount);
                    if (updatedFeePaid == student.getTotalFee()) {
                        System.out.println("Full fees paid. Thank you!");
                    } else {
                        System.out.println("Remaining balance: $" + student.getRemainingBalance());
                    }
                } else {
                    System.out.println("Invalid payment amount. Remaining balance: $" + remainingBalance);
                }
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }
}

public class FeesManagementSystemApp {
    public static void main(String[] args) {
        FeesManagementSystem feesManagementSystem = new FeesManagementSystem();
        feesManagementSystem.addStudent("101", "Alice", 15000);
        feesManagementSystem.addStudent("102", "Bob", 20000);
        feesManagementSystem.addStudent("103", "Jessi", 24000);
        feesManagementSystem.addStudent("104", "Mark", 10000);
        feesManagementSystem.addStudent("105", "Antony", 12000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Student Roll Number: ");
            String studentId = scanner.next();
            System.out.print("Enter Payment Amount: $");
            double paymentAmount = scanner.nextDouble();
            feesManagementSystem.makePayment(studentId, paymentAmount);
        }
    }
}
