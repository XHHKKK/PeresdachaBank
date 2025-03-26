class CurrencyDeposit extends BankDeposit {
    private String currencyType; //для хранения типа валюты
    private double exchangeRate; //для хранения курса обмена валюты

    public CurrencyDeposit(String depositId, double balance, Client owner, String currencyType, double exchangeRate) {
        //конструктор класса, принимает параметры все
        super(depositId, balance, owner); //вызывает конструктор род класса, передает значения для Id, баланса и клиента
        this.currencyType = currencyType;
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyType() { //возвращает тип валюты
        return currencyType;
    }

    public double getExchangeRate() { //метод, возвращает курс обмена валюты
        return exchangeRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.03 * exchangeRate; // 3% годовых, пересчитанных по курсу
    }
    //вычисляет и возвращает сумму процентов

    @Override
    public void applyInterest() { //метод для род класса
        double interest = calculateInterest();//вызывает метод чтобы рассчитать сумму проц и сохр ее в перем интерест
        setBalance(getBalance() + interest);//увелич баланс вклада на сумму начисл процентов
        System.out.println("На валютный вклад " + getDepositId() + " начислены проценты: " + interest + " (баланс: " + getBalance() + ")");
    } //выводит сообщение с инфой о начисл проц и текущем балансе

    @Override
    public String getDepositType() {
        return "Валютный вклад (" + currencyType + ")";
    }
}