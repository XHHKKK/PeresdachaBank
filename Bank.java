import java.util.ArrayList;
import java.util.List;

class Bank {
    private List<Client> clients; //список клиентов банка
    private List<BankDeposit> deposits; //список вкладов

    public Bank() {
        this.clients = new ArrayList<>();//список клиентов как вы новый аррайлист
        this.deposits = new ArrayList<>();//список вкладов как вы новый аррайлист
    }

    public List<Client> getClients() {//метод для получения списка клиентов
        return clients;
    }

    public List<BankDeposit> getDeposits() { //метод для получения списка вкладов
        return deposits;
    }

    public void addClient(Client client) { //метод для добавления клиента в банк
        clients.add(client);//доб переданного клиента в список клиентов
        System.out.println("В банк добавлен клиент: " + client.getName()); //Вывод сообщения о добавлении клиента с его именем
    }

    public void processDayEndInterest() { //метод для обработки процентов по вкладам в конце дня
        for (BankDeposit deposit : deposits) { //цикл по всем вкладам в списке
            deposit.applyInterest();//применяет проценты к вкладу
        }
    }

    public void addDeposit(BankDeposit deposit) { //добавление вклада в банк
        deposits.add(deposit); //добавляет вклад в список
    }
}