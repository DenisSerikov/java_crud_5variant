package interfaceLine;

import controller.OrganizerController;

public class CommandLineInterface {
    private OrganizerController controller;

    public CommandLineInterface() {
        controller = new OrganizerController();
    }

    public void start() {
        System.out.println("ОРГАНАЙЗЕР");

        while (true) {
            System.out.println();
            System.out.print("Введите команду органайзера (ВсеСобытия, ДобавитьСобытие, ОбновитьСобытие, УдалитьСобытие): ");
            String command = controller.getCommand();

            switch (command) {
                case "ВсеСобытия":
                    controller.getAllPrograms();
                    break;
                case "ДобавитьСобытие":
                    controller.addProgram();
                    break;
                case "ОбновитьСобытие":
                    controller.updateProgram();
                    break;
                case "УдалитьСобытие":
                    controller.deleteProgram();
                    break;
                case "Выход":
                    return;
                default:
                    System.out.println("Неверная команда. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }
}