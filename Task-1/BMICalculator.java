import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input: Weight in kilograms
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();
        
        // Input: Height in meters
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();
        
        // Calculate BMI
        double bmi = calculateBMI(weight, height);
        
        // Interpretation and Health Category
        String interpretation = interpretBMI(bmi);
        
        // Display BMI and Health Category
        System.out.println("Your BMI is: " + bmi);
        System.out.println("Interpretation: " + interpretation);
        
        scanner.close();
    }
    
    // Function to calculate BMI
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    
    // Function to interpret BMI and provide health category
    public static String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
