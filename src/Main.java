import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MarketServiceImpl marketService = new MarketServiceImpl();

    public static void main(String[] args) throws Exception {

        List<Grocerys> grocerys = new ArrayList<>(List.of(Grocerys.BANANA, Grocerys.COOKIE, Grocerys.WATER, Grocerys.BREAD,
                Grocerys.CHOCOLATE, Grocerys.COLA, Grocerys.FISH_SEAFOOD,
                Grocerys.FOOD_FAT, Grocerys.MEAT, Grocerys.TEA, Grocerys.MILK));

        List<Grocerys> basket = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        people.add(new Person("Samira", "Nurmatova", LocalDate.of(2004, 8, 4), 14000, basket));

        List<Market> markets = new ArrayList<>();
        markets.add(new Market("Globus", grocerys, 0));
        markets.add(new Market("Chekit", grocerys, 0));
        markets.add(new Market("Frunze", grocerys, 2000));
        markets.add(new Market("Narodnyi", grocerys, 1000));

        while (true) {
            System.out.println("""
                    1.PERSON DATABASE :
                    2.CREATED PERSON :
                    3.MARKET DATABASE :
                    4.ENTRANCE TO THE MARKET :
                    5. GET ALL PERSONS :
                    6.FIND BY PRODUCT NAME :
                    7.GET ALL MARKET :
                    """);
            System.out.println("Enter by command :");
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> System.out.println(marketService.createdDB(people));
                case 2 -> System.out.println(marketService.createdPerson());
                case 3 -> System.out.println(marketService.marketDB(markets));
                case 4 -> System.out.println(marketService.entranceToTheMarket());
                case 5 -> System.out.println(marketService.getAllPerson());
                case 6 -> System.out.println(marketService.findByProductName(grocerys));
                case 7 -> System.out.println(marketService.getAllMarkets(markets));
                default -> System.out.println(" Invalid command !");
            }

        }
    }
}