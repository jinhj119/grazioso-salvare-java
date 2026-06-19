import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {

        initializeDogList();
        initializeMonkeyList();
        
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        // menu loop
        while (!input.equalsIgnoreCase("q")) {
            
            displayMenu();
            input = scanner.nextLine();
            
            switch(input) {
            case "1":
                intakeNewDog(scanner);
                break;
            
            case "2":
                intakeNewMonkey(scanner);
                break;
            
            case "3":
                reserveAnimal(scanner);
                break;
            
            case "4":
                printAnimals("dog");
                break;
            
            case "5":
                printAnimals("monkey");
                break;
            
            case "6":
                printAnimals("available");
                break;
            
            case "q":
                System.out.println("quitting application.");
                break;
            
            default:
                System.out.println("Try again.");
            }
        }
        
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    public static void initializeMonkeyList() {
        // optional
    }

    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();

        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return;
            }
        }

        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();

        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();

        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();

        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();

        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();

        System.out.println("Is the dog reserved? Enter true or false.");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("What is the dog's in service country?");
        String inServiceCountry = scanner.nextLine();

        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate,
                acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        dogList.add(dog);
        System.out.println("Dog added.");
    }

    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();

        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;
            }
        }

        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        if (!(species.equalsIgnoreCase("Capuchin") ||
              species.equalsIgnoreCase("Guenon") ||
              species.equalsIgnoreCase("Macaque") ||
              species.equalsIgnoreCase("Marmoset") ||
              species.equalsIgnoreCase("Squirrel monkey") ||
              species.equalsIgnoreCase("Tamarin"))) {
            System.out.println("Invalid species.");
            return;
        }

        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();

        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();

        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();

        System.out.println("What is the monkey's tail length?");
        double tailLength = Double.parseDouble(scanner.nextLine());

        System.out.println("What is the monkey's height?");
        double height = Double.parseDouble(scanner.nextLine());

        System.out.println("What is the monkey's body length?");
        double bodyLength = Double.parseDouble(scanner.nextLine());

        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();

        System.out.println("Is the monkey reserved? Enter true or false.");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("What is the monkey's in service country?");
        String inServiceCountry = scanner.nextLine();

        Monkey monkey = new Monkey();
        monkey.setName(name);
        monkey.setSpecies(species);
        monkey.setGender(gender);
        monkey.setAge(age);
        monkey.setWeight(weight);
        monkey.setTailLength(tailLength);
        monkey.setHeight(height);
        monkey.setBodyLength(bodyLength);
        monkey.setAcquisitionDate(acquisitionDate);
        monkey.setAcquisitionLocation(acquisitionCountry);
        monkey.setTrainingStatus(trainingStatus);
        monkey.setReserved(reserved);
        monkey.setInServiceCountry(inServiceCountry);

        monkeyList.add(monkey);
        System.out.println("Monkey added successfully.");
    }

    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter animal type:");
        String animalType = scanner.nextLine();

        System.out.println("Enter service country:");
        String country = scanner.nextLine();

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getInServiceCountry().equalsIgnoreCase(country) && !dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println(dog.getName() + " has been reserved.");
                    return;
                }
            }
            System.out.println("No available dog found.");
        }
        else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceCountry().equalsIgnoreCase(country) && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println(monkey.getName() + " has been reserved.");
                    return;
                }
            }
            System.out.println("No available monkey found.");
        }
        else {
            System.out.println("Invalid animal type.");
        }
    }

    public static void printAnimals(String listType) {

        if (listType.equalsIgnoreCase("available")) {

            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    System.out.println("Name: " + dog.getName() +
                            " Status: " + dog.getTrainingStatus() +
                            " Country: " + dog.getAcquisitionLocation() +
                            " Reserved: " + dog.getReserved());
                }
            }

            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    System.out.println("Name: " + monkey.getName() +
                            " Status: " + monkey.getTrainingStatus() +
                            " Country: " + monkey.getAcquisitionLocation() +
                            " Reserved: " + monkey.getReserved());
                }
            }

        } 
        else if (listType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                System.out.println("Name: " + dog.getName() +
                        " Status: " + dog.getTrainingStatus() +
                        " Country: " + dog.getAcquisitionLocation() +
                        " Reserved: " + dog.getReserved());
            }
        } 
        else if (listType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName() +
                        " Status: " + monkey.getTrainingStatus() +
                        " Country: " + monkey.getAcquisitionLocation() +
                        " Reserved: " + monkey.getReserved());
            }
        }
    }
}