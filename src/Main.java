import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Поехали!
        StepTracker stepTracker  = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int inputUser = scanner.nextInt();

        while (inputUser != 0) {
            if ( inputUser == 1 ){
                System.out.println("Введите номер месяца:");
                int month = scanner.nextInt();
                if (month <= 12 && month > 0){
                    System.out.println("Введите день:");
                    int day = scanner.nextInt();
                    if (day<=30 && day > 0){
                        System.out.println("Введите кол-во шагов:");
                        int steps = scanner.nextInt();
                        if (steps > 0){
                            stepTracker.addStepsMonth(month,day,steps);
                            System.out.println("Данные добавлены успешно!");
                        }else{
                            System.out.println("Введите корректное значение шагов(больше 0)!");
                        }
                    }else{
                        System.out.println("Введите корректное значение дня (от 1 до 30)!");
                    }
                }else{
                    System.out.println("Введите корректный номер масяца (от 1 до 12)!");
                }
            }
            else if( inputUser == 2 ){
                System.out.println("За какой месяц напечатать статистику?");
                int month = scanner.nextInt();
                stepTracker.statsMonth(month);
            }
            else if ( inputUser == 3 ){
                System.out.println("Какое кол-во шагов будет новой целью?");
                int stat = scanner.nextInt();
                stepTracker.newLimitSteps(stat);
                System.out.println("Добавлена новая цель: " + stat + " шагов.");
            }
            printMenu();
            inputUser = scanner.nextInt();
        }
        System.out.println("Программа завершена!");
    }
    public static void printMenu(){
        System.out.println("Меню:");
        System.out.println("1 - Ввести кол-во шагов за определенный день месяца.");
        System.out.println("2 - Напечатать статистику за определенный месяц.");
        System.out.println("3 - Изменить цель по кол-ву шагов в день.");
        System.out.println("0 - Выход из приложения.");
    }
}