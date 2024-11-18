    import java.util.Scanner;

    public class ElectricityBillCalculator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter total electricity consumption in kWh: ");
                double consumption = scanner.nextDouble();
                System.out.print("Enter rates for slabs (first 100 kWh, next 200 kWh, above 300 kWh): ");
                double rate1 = scanner.nextDouble(), rate2 = scanner.nextDouble(), rate3 = scanner.nextDouble();
                double totalBill = calculateBill(consumption, rate1, rate2, rate3);
                displayBillBreakdown(consumption, rate1, rate2, rate3, totalBill);
                System.out.print("Do you want to calculate another bill? (yes/no): ");
                if (!scanner.next().equalsIgnoreCase("yes")) break;
            }

            scanner.close();
            System.out.println("Thank you for using the Electricity Bill Calculator!");
        }

    private static double calculateBill(double consumption, double rate1, double rate2, double rate3) {
        if (consumption <= 100) return consumption * rate1;
        if (consumption <= 300) return (100 * rate1) + ((consumption - 100) * rate2);
        return (100 * rate1) + (200 * rate2) + ((consumption - 300) * rate3);
    }

    private static void displayBillBreakdown(double consumption, double rate1, double rate2, double rate3, double totalBill) {
        System.out.println("\nTotal Consumption: " + consumption + " kWh");
        System.out.println("Total Bill: $" + totalBill);
        System.out.println("Breakdown:");

        if (consumption <= 100) {
            System.out.printf("- First 100 kWh: $%.2f\n", consumption * rate1);
        } else if (consumption <= 300) {
            System.out.printf("- First 100 kWh: $%.2f\n", 100 * rate1);
            System.out.printf("- Next 200 kWh: $%.2f\n", (consumption - 100) * rate2);
        } else {
            System.out.printf("- First 100 kWh: $%.2f\n", 100 * rate1);
            System.out.printf("- Next 200 kWh: $%.2f\n", 200 * rate2);
            System.out.printf("- Above 300 kWh: $%.2f\n", (consumption - 300) * rate3);
        }
        System.out.println();
    }
}