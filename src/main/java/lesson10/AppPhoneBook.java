package lesson10;

import java.util.ArrayList;
import java.util.List;

public class AppPhoneBook {
    public static void main(String[] args) {
        new AppPhoneBook().run();
    }

    private void run() {
        TelephoneBook telephoneBook = new TelephoneBook();
        //Добавляем слиентов как лист
        System.out.println(telephoneBook.addClientsToList(fillTelephoneBook()));
        System.out.println("Размер базы " + telephoneBook.getAllClientList().size() + " клиента.");
        System.out.println("=============================================");
        try {
            //добавляем клиента по одному
            System.out.println(telephoneBook.addOneClientToList(new Client("Саня", "3222232")));
            System.out.println("Размер базы " + telephoneBook.getAllClientList().size() + " клиента.");
            System.out.println("=============================================");
        } catch (NumberClientException e) {
            System.out.println("Идентичных клиентов в базе более одного - непорядок!!!");;
        }

        //Ищем клиентов по имени, если более одного, выводим всех
        System.out.println("Ищем Павлов в справочнике...");
        System.out.println(telephoneBook.getClientByName("павел"));
        System.out.println("Размер базы " + telephoneBook.getAllClientList().size() + " клиента.");
        System.out.println("=============================================");

        //Удаляем всех Павлов из справочника
        System.out.println("Удаляем Павлов из справочника...");
        System.out.println(telephoneBook.removeClientByName("Павел" ));
        System.out.println("Размер базы " + telephoneBook.getAllClientList().size() + " клиента.");
        System.out.println("=============================================");

        //Ищем клиентов по номеру телефона 7 - (921) 123+45+67 (будут соответствовать Константин и Елена)
        System.out.println("Ищем клиентов по номеру телефона(будут соответствовать Константин и Елена)" );
        System.out.println(telephoneBook.getClientByPhone("7 - (921) 123+45+67" ));
        System.out.println("=============================================");

        //Удаляем клиентов по номеру телефона из справочника
        System.out.println("Удаляем клиентов по номеру телефона 7 - (921) 123+45+67 из справочника(будут соответствовать Константин и Елена)" );
        System.out.println(telephoneBook.removeClientByPhone("7 - (921) 123 45-67" ));
        System.out.println("Размер базы " + telephoneBook.getAllClientList().size() + " клиента.");
        System.out.println("=============================================");

        System.out.println();
    }

    private List<Client> fillTelephoneBook() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Константин", "+7(921)1234567"));
        clients.add(new Client("Павел", "79211134567"));
        clients.add(new Client("Дмитрий", "+7_921_1234555"));
        clients.add(new Client("Сергей", "+7(9211233333"));
        clients.add(new Client("Илья", "8(921)1444567"));
        clients.add(new Client("Борис", "+7(921)1245643"));
        clients.add(new Client("Максим", "+7(921)333-45-67"));
        clients.add(new Client("павел", "7-921-333-45-67"));
        clients.add(new Client("Лёха", "7 921 333 45 67"));
        clients.add(new Client("Руслан", "7(921)333-45-64"));
        clients.add(new Client("Николай", "+7(921)663-45-67"));
        clients.add(new Client("Олег", "+7(952)663-45-67"));
        clients.add(new Client("сергей", "8(921)663-45-55"));
        clients.add(new Client("Евгений", "+7(921)663-55-55"));
        clients.add(new Client("Владимир", "+7(921)111-11-67"));
        clients.add(new Client("Антонина", "+7(921)663-45-88"));
        clients.add(new Client("Мария", "+7(921)6622567"));
        clients.add(new Client("Жанна", "7(921)333-45-64"));
        clients.add(new Client("мария", "81235600000"));
        clients.add(new Client("Елена", "7 (921) 123-45-67"));

        return clients;
    }
}
