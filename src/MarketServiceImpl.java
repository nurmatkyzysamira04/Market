import java.time.LocalDate;
import java.util.*;

public class MarketServiceImpl implements MarketService{
    private List<Market> marketList = new ArrayList<>();

    private List<Person> personList = new ArrayList<>();

    public List<Market> getMarketList() {
        return marketList;
    }

    public void setMarketList(List<Market> marketList) {
        this.marketList = marketList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String entranceToTheMarket() throws Exception {
        Map<String, Double> discountCheck = new LinkedHashMap<>();
        discountCheck.clear();
        double disCountPrice = 0;
        double priceAll = 0;
        System.out.println("ENTER CUSTOMER NAME :");
        String name = new Scanner(System.in).nextLine();
        for (Person person : personList) {
            if (person.getFirstName().equals(name)) {
                for (Market market : marketList) {
                    System.out.println("========== "+market.getMarketName()+" ==========");
                }
                System.out.println(" Market name :");
                String marketN = new Scanner(System.in).nextLine();
                for (Market market : marketList) {
                    if (market.getMarketName().equals(marketN)) {
                        while (true) {
                            System.out.println(market.getGrocerys());
                            System.out.println("Exit() - выход.\ncheckout() -чек");
                            System.out.println(" Choose your product :");
                            String productName = new Scanner(System.in).nextLine();
                            if (productName.equals("Exit()")) {
                                person.setBasket(new ArrayList<>());
                                break;
                            }

                            if (productName.equals("checkout()")) {
                                for (Grocerys grocerys : person.getBasket()) {
                                    priceAll += grocerys.getPrice();
                                    if (grocerys.getDisCountPrice() == 0) {
                                        disCountPrice += grocerys.getPrice();

                                    } else {
                                        disCountPrice += grocerys.getPrice() - grocerys.getPrice() * grocerys.getDisCountPrice();
                                        discountCheck.put(grocerys.getName(), grocerys.getDisCountPrice());
                                    }
                                }
                                person.setBankAccount(person.getBankAccount() - disCountPrice);
                                market.setBankAccount(market.getBankAccount()+ disCountPrice);
                                return "==========CHECK==========" +
                                        "\nPERSON NAME :" + person.getFirstName() +
                                        "\nMARKET NAME :" + market.getMarketName() +
                                        "\nALL PRODUCT :" + person.getBasket() +
                                        "\nALL SUMMA :" + priceAll +
                                        "\nDISCOUNT : " + discountCheck +
                                        "\nAFTER DISCOUNT : " + disCountPrice +
                                        "\n~~~~~~~~~~~~~~~~~~~~~~~"+
                                        "\n Thank you for your purchase."+
                                        "\nWe are still waiting for you !"+
                                        "\n===============================";


                            }
                            for (Grocerys grocery : market.getGrocerys()) {
                                if (grocery.name().equals(productName)) {
                                    System.out.println(" Want to buy (yes/no)");
                                    boolean yes = new Scanner(System.in).nextLine().equals("yes");
                                    if (yes) {
                                        person.getBasket().add(grocery);
                                        System.out.println("Product successfully added to cart !");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return " WRONG INPUT !";
    }

    @Override
    public List<Market> getAllMarkets(List<Market> markets) {
        return markets;
    }

    @Override
    public String marketDB(List<Market> markets) {
        this.marketList.addAll(markets);
        return "SUCCESSFULLY CREATED DATABASE !";
    }

    @Override
    public String createdDB(List<Person> people) {
        this.personList.addAll(people);
        return "SUCCESSFULLY CREATED DATABASE ! ";
    }

    @Override
    public String createdPerson() {
        try {
            System.out.println("ENTER BY FIRST NAME :");
            String firstName = new Scanner(System.in).nextLine();
            System.out.println(" ENTER BY LAST NAME :");
            String lastName = new Scanner(System.in).nextLine();
            System.out.println("DATE OF BIRTH (year_month_day) : ");
            Scanner scanner = new Scanner(System.in);
            LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            System.out.println(" ENTER BY BANK-ACCOUNT :");
            double bankAccount = new Scanner(System.in).nextDouble();
            List<Grocerys> basket = new ArrayList<>();
            personList.add(new Person(firstName, lastName, date, bankAccount,basket));
            return " SUCCESSFULLY CREATED ! ";
        }catch (Exception e){
            return " Error ! ";
        }
    }

    @Override
    public List<Person> getAllPerson() {
        return this.personList;
    }

    @Override
    public String findByProductName(List<Grocerys> grocerys) {
        System.out.println(" ENTER BY PRODUCT NAME :");
        String productName = new Scanner(System.in).nextLine();
        for (Grocerys grocery : grocerys) {
            if (grocery.name().equals(productName)) {
                return grocery + " " + grocery.getPrice();
            }
        }
        return " NO SUCH PRODUCT !";
    }

}
