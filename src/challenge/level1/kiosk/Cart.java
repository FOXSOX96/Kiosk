package challenge.level1.kiosk;

import challenge.level1.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    /*속성*/
    private Map<Double, MenuItem> cartMap = new LinkedHashMap<>();

    /*생성자*/
    public Cart(Map<Double, MenuItem> cartMap) {
        this.cartMap = cartMap;
    }

    /*기능*/
    /*게터*/
    public Map<Double, MenuItem> getCartMap() {
        return cartMap;
    }

    /*세터*/
    public void addCartMap(Double key, MenuItem menuItem) {
        this.cartMap.put(key,menuItem);
    }
    public void setCartMap(Map<Double, MenuItem> cartMap) {
        this.cartMap = cartMap;
    }

}
