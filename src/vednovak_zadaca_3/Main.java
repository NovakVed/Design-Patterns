package vednovak_zadaca_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LoadData(args);

        Scanner scan;
        String userInput;
        TaskDirector taskDirector = new TaskDirector();
        do {
            System.out.println(ProgramManual());
            scan = new Scanner(System.in);
            userInput = scan.nextLine();
            String[] userInputValues = userInput.split(" ");
            taskDirector.directTask(userInputValues);
        } while (!userInput.equals("0"));
        scan.close();
        System.out.println("Program je završio sa svojim radom");
        System.exit(0);
    }

    private static void LoadData(String[] args) {
        StoredData.getInstance();
        LoadDirector loadDirector = new LoadDirector();

        if (args.length % 2 == 0) {
            for (int i = 0; i < args.length; i += 2) {
                if (!args[i + 1].matches("^-"))
                    loadDirector.loadData(args[i], args[i + 1]);
                else System.out.println("ERROR: nepravilno uneseni argumenti");
            }
        } else System.out.println("ERROR: nepravilno uneseni argumenti");
    }

    private static String ProgramManual() {
        return String.format("%n" +
                "---------------------------------------------------------------------%n" +
                "Upišite jednu od sljedećih komanda%n" +
                "---------------------------------------------------------------------%n" +
                "Pregled ljestvice kola:            T [kolo]%n" +
                "Pregled ljestvica strijelaca:      S [kolo]%n" +
                "Pregled ljestvice kartona:         K [kolo]%n" +
                "Pregled rezultata utakmica:        R [klub] [kolo]%n" +
                "Dodavanje podataka za utakmice:    NU [datoteka]%n" +
                "Dodavanje podataka za sastave:     NS [datoteka]%n" +
                "Dodavanje podataka za događaje:    ND [datoteka]%n" +
                "Ispis utakmica za utakmicu:        D [kolo] [klub1] [klub2] [sekundi]%n" +
                "Zatvaranje programa:               0%n" +
                "---------------------------------------------------------------------%n" +
                "Vaša komanda: ");
    }
}
