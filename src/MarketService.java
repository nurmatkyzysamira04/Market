

import java.util.List;

    public interface MarketService {

        String entranceToTheMarket () throws Exception;

        List<Market> getAllMarkets(List<Market> markets);

        String marketDB(List<Market> markets);
        String createdDB(List<Person> people);
        String createdPerson ();
        List<Person> getAllPerson();
        String findByProductName (List<Grocerys> grocerys);










}
