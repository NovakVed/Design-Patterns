package vednovak_zadaca_1;

import vednovak_zadaca_1.task.TaskFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LoadData(args);

        Scanner scan;
        String userInput;
        TaskFactory taskFactory = new TaskFactory();
        do {
            System.out.println(ProgramManual());
            scan = new Scanner(System.in);
            userInput = scan.nextLine();
            String[] userInputValues = userInput.split(" ");
            taskFactory.getTaskResult(userInputValues);
        } while (!userInput.equals("0"));
        scan.close();
        System.out.println("Program je završio sa svojim radom");
        System.exit(0);
    }

    private static void LoadData(String[] args) {
        StoredData.getInstance();
        LoadFactory loadFactory = new LoadFactory();

        if (args.length % 2 == 0) {
            for (int i = 0; i < args.length; i += 2) {
                if (!args[i + 1].matches("^-"))
                    loadFactory.loadData(args[i], args[i + 1]);
                else System.out.println("ERROR: nepravilno uneseni argumenti");
            }
        } else System.out.println("ERROR: nepravilno uneseni argumenti");
    }

    private static String ProgramManual() {
        return String.format("%n" +
                "----------------------------------------------------------------%n" +
                "Upišite jednu od sljedećih komanda%n" +
                "----------------------------------------------------------------%n" +
                "Pregled ljestvice kola:            T [kolo]%n" +
                "Pregled ljestvica strijelaca:      S [kolo]%n" +
                "Pregled ljestvice kartona:         K [kolo]%n" +
                "Pregled rezultata utakmica:        R [klub] [kolo]%n" +
                "Dodavanje podataka za utakmice:    NU [datoteka]%n" +
                "Dodavanje podataka za sastave:     NS [datoteka]%n" +
                "Dodavanje podataka za događaje:    ND [datoteka]%n" +
                "Zatvaranje programa:               0%n" +
                "----------------------------------------------------------------%n" +
                "Vaša komanda: ");
    }
}
