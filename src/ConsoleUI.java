import java.util.Scanner;

public class ConsoleUI {
    public ToysList tl;
    public ConsoleUI(){
        this.tl = new ToysList();
    }
    public int consoleMenu() {
        Scanner sc = new Scanner(System.in);

            System.out.print("""
                    Main menu:
                    1 - Добавить игрушку
                    2 - Изменить частоту выпадения игрушки
                    3 - Провести розыгрыш
                    0 - Выход
                    >\s""");
            String selection = sc.next();
            if(isDigit(selection)) {
                return Integer.parseInt(selection);
            }
               else
                System.out.println("Неверный ввод!");
               return -1;
    }
    public void execute(){
        while (true) {
            int choice = consoleMenu();
            switch (choice) {
                case 1 -> {
                    Scanner scan = new Scanner(System.in);
                    String name;
                    int weight;
                    int quan = 0;

                        System.out.print("Введите название: ");
                        name = scan.nextLine();
                        if (name.isEmpty()) {
                            System.out.println("Некорректный ввод!!!");

                        }
                        System.out.print("Ведите количество игрушек: ");
                        var val = scan.nextLine();
                        if (isDigit(val)) {
                            quan = Integer.parseInt(val);
                            if (quan <= 0) {
                                System.out.println("Некорректный ввод!!!");

                            }
                        }
                        System.out.print("Введите частоту выпадения игрушки: ");
                        String value = scan.nextLine();
                        if (isDigit(value)) {
                            weight = Integer.parseInt(value);
                            if (weight <= 0) {
                                System.out.println("Некорректный ввод!!!");
                            } else {
                                if (tl.addToy(name, quan, weight)) {
                                    System.out.println("Игрушка добавлена в список розыгрыша!");

                                } else {
                                    System.out.println("Такая игрушка уже есть!");

                                }

                            }
                        }

                }
                case 2 -> {
                    Scanner scan = new Scanner(System.in);
                    System.out.print("введите ID игрушки для изменения частоты выпадения: ");
                    String value = scan.nextLine();
                    if (isDigit(value)) {
                        int selectId = Integer.parseInt(value);
                        if ((selectId >= 0) && (selectId < tl.getToys().size())) {
                            System.out.printf("текущая частота выпадения игрушки" +
                                    " %s : %d", tl.getToys().get(selectId).getName(), tl.getToys().get(selectId).getWeight());
                            System.out.print("введите новую частоту выпадения:");
                            value = scan.nextLine();
                            if (isDigit(value)) {
                                int newWeight = Integer.parseInt(value);
                                tl.weigthChange(selectId, newWeight);
                            } else {
                                System.out.println("Неверный ввод!");
                            }
                        } else {
                            System.out.println("Неверный ввод!");
                        }
                    }

                }
                case 3 -> {
                    Lottery lot = new Lottery(tl);
                    lot.raffle();
                }

                case 0 -> System.exit(0);
                default -> System.out.println("Некорректный ввод!!!");
            }
        }

    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
