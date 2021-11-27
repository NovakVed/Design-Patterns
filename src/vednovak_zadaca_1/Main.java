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
                "-------------------------------------------------------%n" +
                "Upišite jednu od sljedećih komanda%n" +
                "-------------------------------------------------------%n" +
                "Pregled ljestvice kola:        T [kolo]%n" +
                "Pregled ljestvica strijelaca:  S [kolo]%n" +
                "Pregled ljestvice kartona:     K [kolo]%n" +
                "Pregčed rezultata utakmica:    R [klub] [kolo]%n" +
                "Zatvaranje programa:           0 %n" +
                "-------------------------------------------------------%n");
    }
}
