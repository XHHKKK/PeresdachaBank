class SavingsDeposit extends BankDeposit {
    private double minBalance;
    private double monthlyTopUp;
    //объявляет перем мин баланс и ежемесячное пополнение
    public SavingsDeposit(String depositId, double balance, Client owner, double minBalance, double monthlyTopUp) {
        //конструктор класса, прин параметры
        super(depositId, balance, owner); //выз констр для насл полей
        this.minBalance = minBalance;
        this.monthlyTopUp = monthlyTopUp;
    }

    public double getMinBalance() {
        return minBalance;
        //для полученияь значения мин баланса
    }

    public double getMonthlyTopUp() {
        return monthlyTopUp;
        //для получения знач ежем пополн
    }

    @Override
    public double calculateInterest() { //опред способ расчета проц для накоп вклада
        double minBalanceForMonth = Math.min(getBalance(), minBalance);
        //вычисляет мин баланс для расчета проц
        return minBalanceForMonth * 0.05; // 5% годовых
    }

    @Override
    public void applyInterest() {
        //переопр метод для прим проц к текущему балансу
        double interest = calculateInterest();
        //вызывает метод и сохраняет результат
        setBalance(getBalance() + interest);
        //обновляет баланс, добавляет к нему начисл проц
        System.out.println("На накопительный вклад " + getDepositId() + " начислены проценты: " + interest + " (баланс: " + getBalance() + ")");
    } //выводит сообщение сколько проц было начислено и какой баланс

    @Override
    public void deposit(double amount) {
        super.deposit(amount); // Разрешаем пополнение
        //выз род метод чтобы добавить пополн сумму к балансу
        System.out.println("На накопительный вклад " + getDepositId() + " внесено " + amount + " (баланс: " + getBalance() + ")");
    } //выводит инфу о внесенной сумме и обновленном балансе

    @Override
    public String getDepositType() { //переопр метод для предост инфы о типе вклада
        return "Накопительный вклад";
    }
}