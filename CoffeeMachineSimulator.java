import java.util.Scanner;

public class CoffeeMachineSimulator {
    private int water;
    private int milk;
    private int beans;
    private int moneyEarned;
    private int espressoPrice = 4;
    private int lattePrice = 7;
    private int cappuccinoPrice = 6;
    private int espressoWater = 250;
    private int espressoMilk = 0;
    private int espressoBeans = 16;
    private int latteWater = 350;
    private int latteMilk = 75;
    private int latteBeans = 20;
    private int cappuccinoWater = 200;
    private int cappuccinoMilk = 100;
    private int cappuccinoBeans = 12;
    private int espressoCount;
    private int latteCount;
    private int cappuccinoCount;

    public CoffeeMachineSimulator() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.moneyEarned = 0;
        this.espressoCount = 0;
        this.latteCount = 0;
        this.cappuccinoCount = 0;
    }

    public void buyCoffee(String type) {
        int price = 0;
        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;

        if ("espresso".equalsIgnoreCase(type)) {
            price = espressoPrice;
            waterNeeded = espressoWater;
            milkNeeded = espressoMilk;
            beansNeeded = espressoBeans;
        } else if ("latte".equalsIgnoreCase(type)) {
            price = lattePrice;
            waterNeeded = latteWater;
            milkNeeded = latteMilk;
            beansNeeded = latteBeans;
        } else if ("cappuccino".equalsIgnoreCase(type)) {
            price = cappuccinoPrice;
            waterNeeded = cappuccinoWater;
            milkNeeded = cappuccinoMilk;
            beansNeeded = cappuccinoBeans;
        }

        if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded) {
            System.out.println("Dispensing " + type + ". Enjoy your coffee!");
            moneyEarned += price;
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;

            if ("espresso".equalsIgnoreCase(type)) {
                espressoCount++;
            } else if ("latte".equalsIgnoreCase(type)) {
                latteCount++;
            } else if ("cappuccino".equalsIgnoreCase(type)) {
                cappuccinoCount++;
            }
        } else {
            System.out.println("Error: Not enough ingredients to make " + type + " coffee.");
        }
    }

    public void fillIngredients(int addedWater, int addedMilk, int addedBeans) {
        water += addedWater;
        milk += addedMilk;
        beans += addedBeans;
    }

    public void takeMoney() {
        System.out.println("Taking $" + moneyEarned + " from the money box.");
        moneyEarned = 0;
    }

    public void showIngredients() {
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Beans: " + beans + " units");
    }

    public void showAnalytics() {
        System.out.println("Coffee sold: ");
        System.out.println("Espresso: " + espressoCount + " cups");
        System.out.println("Latte: " + latteCount + " cups");
        System.out.println("Cappuccino: " + cappuccinoCount + " cups");
        System.out.println("Total money earned: $" + moneyEarned);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachineSimulator coffeeMachine = new CoffeeMachineSimulator();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Buy Coffee");
            System.out.println("2. Fill Ingredients");
            System.out.println("3. Take Money");
            System.out.println("4. Show Ingredients");
            System.out.println("5. Analytics");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the type of coffee (espresso/latte/cappuccino): ");
                    String coffeeType = scanner.nextLine();
                    coffeeMachine.buyCoffee(coffeeType);
                    break;
                case 2:
                    System.out.print("Enter the amount of water (ml): ");
                    int addedWater = scanner.nextInt();
                    System.out.print("Enter the amount of milk (ml): ");
                    int addedMilk = scanner.nextInt();
                    System.out.print("Enter the amount of beans (units): ");
                    int addedBeans = scanner.nextInt();
                    coffeeMachine.fillIngredients(addedWater, addedMilk, addedBeans);
                    break;
                case 3:
                    coffeeMachine.takeMoney();
                    break;
                case 4:
                    coffeeMachine.showIngredients();
                    break;
                case 5:
                    coffeeMachine.showAnalytics();
                    break;
                case 6:
                    System.out.println("Exiting Coffee Machine Simulator.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}