import java.util.ArrayList; //реализация интерфейса лист
import java.util.List;// он описывает списки

class Client { //класс клиент, создаем с ним объекты с клиентами банка
    private String name;//Имя клиента
    //поле недоступно напрямую из других классов
    private int id; // Id клиента
    //тип инт и Id
    private String contactInfo; //Инфа
    private List<BankDeposit> deposits; //Композиция, Клиент владеет вкладами
    //депозитс-список объектов БанкДепозит
    public Client(String name, int id, String contactInfo) {
        this.name = name;
        this.id = id;
        this.contactInfo = contactInfo;
        this.deposits = new ArrayList<>();//создать новый оьъект аррайлист, будет хранить вклады клиента
    }

    public String getName() {
        return name;
        //возвращает имя клиента
    }

    public int getId() {
        return id;
        //возвращает id клиента
    }

    public String getContactInfo() {
        return contactInfo;
        //возвращает инфу клиента
    }

    public List<BankDeposit> getDeposits() {
        return deposits;
        //возвращает список вкладов клиента
    }

    public void openDeposit(BankDeposit deposit) {//открытие нового вклада
        deposits.add(deposit); //в список депозитс добавляется новый вклад депозит
        System.out.println("Клиент " + name + " открыл вклад " + deposit.getDepositId());
    }
    //выводит сообщение, что клиент открыл новый вклад, Id, имя клиента

    public void closeDeposit(BankDeposit deposit) { //Закрытие вклада
        deposits.remove(deposit); //удаляет вклад из списка
        System.out.println("Клиент " + name + " закрыл вклад " + deposit.getDepositId());//выводит сообщение, что клиент закрыл вклад с id
    }
}