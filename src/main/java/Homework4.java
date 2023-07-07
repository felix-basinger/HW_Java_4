import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Homework4 {
    static Scanner scanner;
    public static void main(String[] args) {
         scanner = new Scanner(System.in);

        ArrayList<String> ma = new ArrayList<>();
        ArrayList<String> ms = new ArrayList<>();
        ArrayList<String> md = new ArrayList<>();
        ArrayList<Integer> mf = new ArrayList<>();
        ArrayList<Boolean> mg = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();

        while (true) {
            System.out.println("Введите фамилию: ");
            ma.add(scanner.nextLine());
            System.out.println("Введите имя: ");
            ms.add(scanner.nextLine());
            System.out.println("Введите отчество: ");
            md.add(scanner.nextLine());
            System.out.println("Введите возраст: ");
            mf.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол: ");
            mg.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(mg.size() - 1);
            System.out.println("Продолжить ввод? y/n: ");
            System.out.println();
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("n")) break;
        }
        for (int i = 0; i < ma.size(); i++) {
            System.out.println(ma.get(i) + " " + ms.get(i).toUpperCase().charAt(0)
                    + ". " + md.get(i).toUpperCase().charAt(0) + ". " + mf.get(i) + " " + (mg.get(i)?"Ж":"М"));
        }
        System.out.println();
        System.out.println("Сортировать по возрасту? y/n: ");
        String tmp = scanner.nextLine();
        if (tmp.toLowerCase().contains("y")) {
            id.sort(Comparator.comparingInt(mf::get));
            for (Integer integer : id) {
                System.out.println(ma.get(integer) + " " + ms.get(integer).toUpperCase().charAt(0)
                        + ". " + md.get(integer).toUpperCase().charAt(0) + ". " + mf.get(integer) + " " + (mg.get(integer) ? "Ж" : "М"));
            }
        }

        System.out.println();
        System.out.println("Сортировать по возрасту и полу? y/n: ");
        String tmp1 = scanner.nextLine();
        if (tmp1.toLowerCase().contains("y")) {
            id.sort((o1, o2) -> {
                if (mg.get(o1)) return 1;
                else return -1;
            });
            id.sort((o1, o2) -> {
                if (mg.get(o1) == mg.get(o2)) return mf.get(o1) - mf.get(o2);
                return 0;
            });
            for (Integer integer : id) {
                System.out.println(ma.get(integer) + " " + ms.get(integer).toUpperCase().charAt(0)
                        + ". " + md.get(integer).toUpperCase().charAt(0) + ". " + mf.get(integer) + " " + (mg.get(integer) ? "Ж" : "М"));
            }
        }
    }
}
