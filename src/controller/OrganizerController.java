package controller;

import programDatabase.OrganizerDatabase;
import models.Organizer;
import java.util.List;
import java.util.Scanner;

public class OrganizerController {
    private OrganizerDatabase programDatabase;

    public OrganizerController() {
        programDatabase = new OrganizerDatabase();
    }

    public String getCommand() {
        return new Scanner(System.in).nextLine();
    }

    public void getAllPrograms() {
        List<Organizer> programs = programDatabase.getAllPrograms();
        for (Organizer program : programs) {
            System.out.println(program);
        }
    }

    public void addProgram() {
        System.out.print("Введите событие, которое вы хотите запомнить: ");
        String type = new Scanner(System.in).nextLine();
        System.out.print("Введите дату события: ");
        String date = new Scanner(System.in).nextLine();
        System.out.print("Введите время события: ");
        String time = new Scanner(System.in).nextLine();
        System.out.print("Напишите описание события: ");
        String description = new Scanner(System.in).nextLine();

        Organizer program = new Organizer(type, date, time, description);
        programDatabase.addProgram(program);
        System.out.println("Событие успешно добавлено!");
    }

    public void updateProgram() {
        System.out.print("Введите id события: ");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.print("Введите событие, которое вы хотите запомнить: ");
        String type = new Scanner(System.in).nextLine();
        System.out.print("Введите дату события: ");
        String date = new Scanner(System.in).nextLine();
        System.out.print("Введите время события: ");
        String time = new Scanner(System.in).nextLine();
        System.out.print("Напишите описание события: ");
        String description = new Scanner(System.in).nextLine();

        Organizer updatedProgram = new Organizer(type, date, time, description);
        updatedProgram.setId(id);
        programDatabase.updateProgram(updatedProgram);
        System.out.println("Событие успешно обновлено!");
    }

    public void deleteProgram() {
        System.out.print("Введите id события: ");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());

        programDatabase.deleteProgram(id);
        System.out.println("Событие успешно удалено!");
    }
}