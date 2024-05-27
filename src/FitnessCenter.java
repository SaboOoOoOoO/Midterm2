import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FitnessCenter {
    private String name;
    private List<Trainer> trainers;

    public FitnessCenter(String name) {
        this.name = name;
        this.trainers = new ArrayList<>();
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void removeTrainer(Trainer trainer) {
        trainers.remove(trainer);
    }

    public void displayTrainers() {
        System.out.println("Trainers at " + name + ":");
        for (Trainer trainer : trainers) {
            System.out.println(trainer);
        }
    }

    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Trainer trainer : trainers) {
                writer.write(trainer.getName() + "," + trainer.getExpertise() + "," + trainer.getAge() + "\n");
            }
            System.out.println("State saved to state.csv");
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    public void restoreState() {
        trainers.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] trainerData = line.split(",");
                String name = trainerData[0];
                String expertise = trainerData[1];
                int age = Integer.parseInt(trainerData[2]);
                Trainer trainer = new Trainer(name, expertise, age);
                trainers.add(trainer);
            }
            System.out.println("State restored from state.csv");
        } catch (IOException e) {
            System.out.println("Error restoring state: " + e.getMessage());
        }
    }
}