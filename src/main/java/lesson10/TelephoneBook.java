package lesson10;

import java.util.ArrayList;
import java.util.List;

public class TelephoneBook {
    private List<Client> clients = new ArrayList<>();

    public List<Client> getAllClientList() {
        return clients;
    }

    public Client addOneClientToList(Client client) throws NumberClientException {
        Client temClient = getClientsByNameAndPhone(client);
        if (temClient == null) {
            this.clients.add(client);
        }
        return client;
    }

    public List<Client> addClientsToList(List<Client> cls) {
        this.clients.addAll(cls);
        if (this.clients.containsAll(cls)) {
            return cls;
        } else {
            return new ArrayList<Client>();
        }
    }

    public List<Client> getClientByName(String name) {
        List<Client> clientsByName = new ArrayList<>();
        for (Client client: clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                clientsByName.add(client);
            }
        }
        return clientsByName;
    }

    public List<Client> getClientByPhone(String phone) {
        List<Client> clientsByPhone = new ArrayList<>();
        for (Client client: clients) {
            if (client.getTelNumber().equalsIgnoreCase(phone.replaceAll("\\D", ""))) {
                clientsByPhone.add(client);
            }
        }
        return clientsByPhone;
    }

    public String removeClientByName(String name) {
        List<Client> clientsToRemove = getClientByName(name);
        clients.removeAll(clientsToRemove);
        return clientsToRemove.toString();
    }

    public List<Client> removeClientByPhone(String phone) {
        List<Client> clientsToRemove = getClientByPhone(phone);
        clients.removeAll(clientsToRemove);
        return clientsToRemove;
    }

    private Client getClientsByNameAndPhone(Client client) throws NumberClientException {
        List<Client> tempClients = new ArrayList<>();
        for (Client c: clients) {
            if (c.getName().equalsIgnoreCase(client.getName()) && c.getTelNumber().equals(client.getTelNumber())) {
                tempClients.add(c);
            }
        }
        if(tempClients.size() > 1) {
            throw new NumberClientException("Ошибка базы, в базе больше одного клиента с одинаковым именем и телефоном");
        } else if (tempClients.size() == 1) {
            return tempClients.get(0);
        } else {
            return null;
        }
    }
}

class Client {
    private final String name;
    private final String telNumber;

    public Client(String name, String telNumber) {
        this.name = name;
        this.telNumber = telNumber.replaceAll("\\D", "");
    }

    public String getName() {
        return name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}

class NumberClientException extends Exception {
    public NumberClientException(String message) {
        super(message);
    }
}