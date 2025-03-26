import java.time.LocalDate;//импорт класса для работы с датами

class FixedTermDeposit extends BankDeposit {
    private int termMonths;//переменная для хранения срока вклада в месяцах
    private double interestRate;//переменная для хранения процентной ставки по вкладу
    private LocalDate maturityDate;//переменная для хранения даты окончания срока вклада

    public FixedTermDeposit(String depositId, double balance, Client owner, int termMonths, double interestRate) {
        super(depositId, balance, owner);//конструктор, принимает id, баланс, клиента, срок и ставку проц
        this.termMonths = termMonths; //установка значения срока вклада
        this.interestRate = interestRate; //устновка процентной ставки
        this.maturityDate = getOpeningDate().plusMonths(termMonths);//расчет даты окончания вклада
    }

    public int getTermMonths() { //метод для получения срока вклада
        return termMonths;
    }

    public double getInterestRate() { //метод для получения процентной ставки
        return interestRate;
    }

    public LocalDate getMaturityDate() { //метод для получения даты окончания вклада
        return maturityDate;
    }

    @Override
    public double calculateInterest() {
        //для расчета процентов
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyInterest() { //метод для применения начисленных процентов
        double interest = calculateInterest();//рассчит проценты
        setBalance(getBalance() + interest);//увелич баланс на сумму процентов
        System.out.println("На срочный вклад " + getDepositId() + " начислены проценты: " + interest + " (баланс: " + getBalance() + ")");
    } //вывод инфы о начислении процентов и балансе

    @Override
    public void withdraw(double amount) {
        if (LocalDate.now().isBefore(maturityDate)) {
            System.out.println("Снятие средств до окончания срока вклада невозможно.");
        } else {
            super.withdraw(amount); // Вызываем метод из родительского класса
        }
    }

    @Override
    public String getDepositType() {
        return "Срочный вклад";
    }
}