import java.util.ArrayList;

public class AgenciaBancaria {
    public int agencyNumber;
    ArrayList<ContaBancaria> accounts = new ArrayList<ContaBancaria>();

    public AgenciaBancaria(int agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public int getAgencyNumber() {
        return this.agencyNumber;
    }

    public void addAccount(ContaBancaria account) {
        this.accounts.add(account);
    }

    public void removeAccount(ContaBancaria account) {
        this.accounts.remove(account);
    }

    public void printAccounts() {
        for (ContaBancaria account : this.accounts) {
            System.out.println(account);
        }
    }

    public ContaBancaria getAccount(int accountNumber) {
        for (ContaBancaria account : this.accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    
}
