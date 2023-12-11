package decoratorPattern;

public class GSave implements BankAccountDecorator {
    private final BankAccountDecorator account;

    public GSave(BankAccountDecorator account) {
        this.account = account;
    }

    @Override
    public String showAccountType() {
        return "GSave";
    }

    @Override
    public double getInterestRate() {
        return 0.025;
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }

    @Override
    public String showBenefits() {
        return account.showBenefits() + ", GCash Transfer";
    }

    @Override
    public double computeBalanceWithInterest() {
        return account.getBalance() * (1 + getInterestRate());
    }

    @Override
    public String showInfo() {
        return account.showInfo(); 
    }
}

