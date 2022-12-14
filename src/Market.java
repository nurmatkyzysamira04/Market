import java.util.List;

public class Market {
    private String marketName;
    private List<Grocerys> grocerys;
    private double bankAccount;

    public Market(String marketName, List<Grocerys> grocerys, double bankAccount) {
        this.marketName = marketName;
        this.grocerys = grocerys;
        this.bankAccount = bankAccount;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public List<Grocerys> getGrocerys() {
        return grocerys;
    }

    public void setGrocerys(List<Grocerys> grocerys) {
        this.grocerys = grocerys;
    }

    @Override
    public String toString() {
        return "  \n Market :\n" +
                " \nmarketName : " + marketName +
                "\n grocerys :" + grocerys +
                "\n bankAccount :" + bankAccount +
                "\n===========================";
    }



}
