package interfaceLine;

import domain.Program;
import manager.ProgramDAO;

import java.util.Date;
import java.util.Scanner;

public class CommandLineInterface {
    private ProgramDAO programDAO;
    private Scanner scanner;

    public CommandLineInterface() {
        programDAO = new ProgramDAO();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("ОРГАНАЙЗЕР");

        while (true) {
            System.out.println();
            System.out.print("Ввведите команду органайзера(ВсеСобытия, ДобавитьСобытие, ОбновитьСобытие, УдалитьСобытие: ");
            String command = scanner.nextLine();

            if (command.equals("ВсеСобытия")) {
                System.out.println(programDAO.getAllPrograms());
            } else if (command.equals("ДобавитьСобытие")) {
                System.out.print("Введите событие, которое вы хотите запомнить: ");
                String type = scanner.nextLine();
                System.out.print("Введите дату события: ");
                String date = scanner.nextLine();
                System.out.print("Введите время события: ");
                String time = scanner.nextLine();
                System.out.print("Напишите описание события: ");
                String description = scanner.nextLine();

                Program program = new Program(type,date,time,description);
                programDAO.addProgram(program);
                System.out.println("Событие успешно добавлено!");
            } else if (command.equals("ОбновитьСобытие")) {
                System.out.print("Введите id события: ");
                int id = Integer.parseInt(scanner.nextLine());


                System.out.print("Введите событие, которое вы хотите запомнить: ");
                String type = scanner.nextLine();
                System.out.print("Введите дату события: ");
                String date = scanner.nextLine();
                System.out.print("Введите время события: ");
                String time = scanner.nextLine();
                System.out.print("Напишите описание события: ");
                String description = scanner.nextLine();

                Program updatedProgram = new Program(type,date,time,description);
                updatedProgram.setId(id);
                programDAO.updateProgram(updatedProgram);
                System.out.println("Событие успешно обновлено!");
            } else if (command.equals("УдалитьСобытие")) {
                System.out.print("Введите id события: ");
                int id = Integer.parseInt(scanner.nextLine());


                programDAO.deleteProgram(id);
                System.out.println("Событие успешно удалено!");
            } else if (command.equals("Выход")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
