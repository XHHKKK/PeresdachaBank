public class Main { //класс main
    public static void main(String[] args) {
        //массив строк, принимает аргументы командной строки
        //сюда буду добавлять клиентов и вклады
        /**
         * Создание банка
         **/
        Bank bank = new Bank(); //создаем банк

        /**
         * Создание клиентов
         **/
        Client client1 = new Client("Валерий Тюкавкин", 1, "Valerka@gmail.com");
        Client client2 = new Client("Анастасия Коротаева", 2, "Nastya@mail.com");//создала 2 клиентов с именем, id и почтой
        bank.addClient(client1);//добавила их в банк
        bank.addClient(client2);

        /** Открытие вкладов
        Делаю три типа вкладов:
        fixedDeposit-срочный с Id 1, нач. баланс 1000, на 12 месяцев под 5% в год
         savingsDeposit-накопительный вклад с id 2, нач. балансом 500, миним остатком 500 и лимитом на пополнение 100
         currencyDeposit-валютный вклад с id 3, нач балансом 2000, в usd за 90 дней
                **/
        FixedTermDeposit fixedDeposit = new FixedTermDeposit("1", 1000, client1, 12, 5.0);
        SavingsDeposit savingsDeposit = new SavingsDeposit("2", 500, client2, 500, 100);
        CurrencyDeposit currencyDeposit = new CurrencyDeposit("3", 2000, client1, "USD", 90.0);

        client1.openDeposit(fixedDeposit);
        client2.openDeposit(savingsDeposit);
        client1.openDeposit(currencyDeposit);
        //открыть вклад для каждого клиента
        bank.addDeposit(fixedDeposit);
        bank.addDeposit(savingsDeposit);
        bank.addDeposit(currencyDeposit);

        // Пополнение вкладов в общий список
        fixedDeposit.deposit(500);//попытка снять досрочно со срочного
        savingsDeposit.deposit(200);//снятие с накопительного

        // Попытка снятия с срочного вклада досрочно
        fixedDeposit.withdraw(200);

        // Снятие с накопительного вклада
        savingsDeposit.withdraw(100);

        // Начисление процентов
        System.out.println("\nНачисление процентов в конце месяца:");
        bank.processDayEndInterest();

        // Дополнительная информация о вкладах
        System.out.println("\nИнформация о вкладах:");
        for (Client client : bank.getClients()) {
            //выводится заголовок для доп инфы, потом проходит по клиентам
            System.out.println("Клиент: " + client.getName());
            for (BankDeposit deposit : client.getDeposits()) {
                //выводят инфу о каждом клиенте
                System.out.println("  - Тип: " + deposit.getDepositType() + ", ID: " + deposit.getDepositId() + ", Баланс: " + deposit.getBalance());
                //выводит инфу о каждом типе вклада, id, баланс
            }
        }
    }
}