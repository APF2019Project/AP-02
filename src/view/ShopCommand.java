package view;

public enum ShopCommand {
    MONEY, SHOW_SHOP , SHOW_BOUGHT_CARDS, BUY ;
    private String name ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
