public enum Grocerys {
    BANANA("BANANA",50),
    MILK("MILK",100),
    WATER("WATER",30,0.2),
    BREAD("BREAD",25,0.5),
    COLA("COLA",80),
    FISH_SEAFOOD("FISH_SEAFOOD",200),
    COOKIE("COOKIE",150),
    CHOCOLATE("CHOCOLATE",130,0.1),
    FOOD_FAT("FOOD_FAT",180),
    MEAT("MEAT",350,0.1),
    TEA("TEA",70);


    String name;
    double price;
    double disCountPrice;

    Grocerys (String name,double price){
        this.name = name;
        this.price = price;
    }
    Grocerys(String name, double price, double disCountPrice) {
        this.name = name;
        this.price = price;
        this.disCountPrice = disCountPrice;
    }

    public double getDisCountPrice() {
        return disCountPrice;
    }

    public void setDisCountPrice(double disCountPrice) {
        this.disCountPrice = disCountPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
