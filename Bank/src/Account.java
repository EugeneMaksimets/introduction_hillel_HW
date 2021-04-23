public class Account {
    private int number;

    private double balance;

    private String customerName;

    private String customerEmailAddress;

    private String customerPhoneNumber;

    public int getNumber() {
        return number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Сумма пополнения: " + amount + "\n Ваш баланс: " + balance);
    }

    public void withdrawal(double cash) {
        if (balance - cash < 0) {
            System.out.println("Не доостаточно средств, введите сумму не превишиающию: " + balance);

        } else {
            this.balance -= cash;
            System.out.println("Сумма ввывода средств: " + cash + "\n Ваш баланс: " + balance);
        }
    }


}
