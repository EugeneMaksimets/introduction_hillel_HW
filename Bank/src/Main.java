public class Main {

    public static void main(String[] args) {
        Account BankAccount = new Account();
        BankAccount.setCustomerName("Eugene");
        BankAccount.setCustomerEmailAddress("whitefunnnyboy@gmail.com");
        BankAccount.setCustomerPhoneNumber("380986717294");
        BankAccount.setNumber(66778);
        BankAccount.setBalance(600.67);
        BankAccount.deposit(100);
        BankAccount.deposit(1000);
        BankAccount.withdrawal(100);



        Account BankAccount1 = new Account();
        BankAccount1.setCustomerName("Alex");
        BankAccount1.setCustomerEmailAddress("ulianovh@gmail.com");
        BankAccount.setCustomerPhoneNumber("380674563274");
        BankAccount1.setNumber(1234);
        BankAccount1.setBalance(60.7);
        BankAccount1.deposit(10);
        BankAccount1.deposit(26.69);
        BankAccount1.withdrawal(100);


    }
}
