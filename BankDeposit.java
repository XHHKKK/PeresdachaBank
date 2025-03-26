import java.time.LocalDate;//класс для работы с датами

abstract class BankDeposit implements InterestBearing, Manageable {
    //Объявление абстрактного класса, который реализ интерфейсы
    private String depositId; //поле для id вклада
    private double balance; //поле для баланса вклада
    private LocalDate openingDate;//поле для даты открытия вклада
    private Client owner; // Композиция. Вклад принадлежит клиенту

    public BankDeposit(String depositId, double balance, Client owner) {
        //Конструктор класса, принимает Id, баланс и клиента
        this.depositId = depositId;
        this.balance = balance;
        this.openingDate = LocalDate.now();//Установка даты открытия
        this.owner = owner;
    }

    public String getDepositId() { //метод для получения id вклада
        return depositId; //возврат id вклада
    }

    public double getBalance() {
        //метод для получения баланса вклада
        return balance;
    }

    public void setBalance(double balance) { //метод для установки нового баланса вклада
        this.balance = balance; //обновление баланса
    }

    public LocalDate getOpeningDate() { //метод для получения даты открытия вклада
        return openingDate;
    }

    public Client getOwner() { //получение клиента
        return owner;
    }

    @Override
    public void deposit(double amount) { //метод для внесения суммы на вклад
        //из интерфейса
        balance += amount; //увеличение баланса на внес сумму
        System.out.println("На вклад " + depositId + " внесено " + amount + " (баланс: " + balance + ")");
    }//вывод инфы о внесении суммы

    @Override
    public void withdraw(double amount) { //метод для снятия суммы
        if (amount <= balance) { //проверяем достаточно ли средств
            balance -= amount; //уменьшение на сумму снятия
            System.out.println("Со вклада " + depositId + " снято " + amount + " (баланс: " + balance + ")");
        } else { //вывод, что сняты
            System.out.println("Недостаточно средств на вкладе " + depositId); //вывод, недостаточно средств
        }
    }

    @Override
    public abstract double calculateInterest(); // Абстрактный метод для расчет процентов
    @Override
    public abstract void applyInterest(); // Абстрактный метод для применения процентов

    public abstract String getDepositType(); // метод для определения типа вклада

}