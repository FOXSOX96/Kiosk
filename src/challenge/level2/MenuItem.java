package challenge.level2;

public class MenuItem {

    /*속성*/
    private String menuName;
    private double menuPrice;
    private String menuDetail;


    /*생성자*/
    public MenuItem(String menuName, double menuPrice, String menuDetail) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDetail = menuDetail;
    }

    /*게터*/
    public String getMenuName() {
        return menuName;
    }
    public double getMenuPrice() {
        return menuPrice;
    }
    public String getMenuDetail() {
        return menuDetail;
    }

    /*세터*/
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }
    public void setMenuDetail(String menuDetail) {
        this.menuDetail = menuDetail;
    }
}
