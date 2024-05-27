public class OrganizationTester {
    public static void main(String[] args) {

        Trainer trainer1 = new Trainer("John Doe", "Strength Training", 35);
        Trainer trainer2 = new Trainer("Jane Smith", "Yoga", 28);
        Trainer trainer3 = new Trainer("Bob Johnson", "Cardio", 42);


        FitnessCenter fitnessCenter = new FitnessCenter("Fit Life Gym");
        fitnessCenter.addTrainer(trainer1);
        fitnessCenter.addTrainer(trainer2);
        fitnessCenter.addTrainer(trainer3);


        fitnessCenter.displayTrainers();


        fitnessCenter.saveState();


        fitnessCenter.removeTrainer(trainer2);
        System.out.println("\nAfter removing a trainer:");
        fitnessCenter.displayTrainers();


        fitnessCenter.restoreState();
        System.out.println("\nAfter restoring state:");
        fitnessCenter.displayTrainers();
    }
}