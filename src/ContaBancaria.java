public class ContaBancaria {
    private int accountNumber;
    private double accountBalance;
    private String accountHolderName;

    public ContaBancaria(int accountNumber, double accountBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void deposit(double amount) {
        this.accountBalance += amount;
        System.out.println("Depósito realizado com sucesso");
    }

    public void withdraw(double amount) {
            if (amount <= this.accountBalance){
                this.accountBalance -= amount;
            } else {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
    }

    public void transfer(double ammount, ContaBancaria account){
        try{
            this.withdraw(ammount);
            account.deposit(ammount);
            System.out.printf("%s transferiu R$ %.2f para %s\n", this.accountHolderName, ammount, account.getAccountHolderName());

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return String.format("\nNúmero da conta: %s\nSaldo: R$ %.2f\nTitular: %s\n", this.accountNumber, this.accountBalance, this.accountHolderName); 
    }


}
