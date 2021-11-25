package vednovak_zadaca_1;

import vednovak_zadaca_1.load.LoadFactory;
import vednovak_zadaca_1.task.TaskFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 10) {
            System.out.println("Nisu učitane sve datoteke!");
        } else {
            LoadData(args);
            System.out.println(ProgramManual());

            String userInput;
            TaskFactory taskFactory = new TaskFactory();
            do {
                System.out.print("Vaša komanda: ");
                Scanner scan = new Scanner(System.in);
                userInput = scan.nextLine();
                String[] userInputValues = userInput.split(" ");
                taskFactory.getTaskResult(userInputValues);
            } while (!userInput.equals("0"));
        }
        System.out.println("Program je završio sa svojim radom");
        System.exit(0);
    }

    private static void LoadData(String[] args) {
        StoredData.getInstance();
        LoadFactory loadFactory = new LoadFactory();

        for (int i = 0; i < args.length; i += 2) {
            String[] temp = new String[2];
            temp[0] = args[i];
            temp[1] = args[i + 1];
            loadFactory.loadData(temp);
        }
    }

    private static String ProgramManual() {
        return String.format("%n" +
                "--------------------------------------------------------------------------%n" +
                "Upišite jednu od sljedećih komanda%n" +
                "--------------------------------------------------------------------------%n" +
                "T: Pregled ljestvice za sva odigrana kola u prvenstvu %n" +
                "T [kolo]: Pregled ljestvice nakon određenog kola prvenstva %n" +
                "S: Pregled ljestvice strijelaca za sva odigrana kola u prvenstvu %n" +
                "S [kolo]: Pregled ljestvice strijelaca nakon određenog kola prvenstva %n" +
                "K: Pregled ljestvice kartona po klubovima  za odigrana kola u prvenstvu %n" +
                "K [kolo]: Pregled ljestvice kartona po klubovima nakon određenog kola prvenstva %n" +
                "R [klub]: Pregled rezultata utakmica za klub za odigrana kola u prvenstvu %n" +
                "R [klub] [kolo]: Pregled rezultata utakmica za klub nakon određenog kola prvenstva %n" +
                "0: Zatvaranje programa %n");
    }
}
