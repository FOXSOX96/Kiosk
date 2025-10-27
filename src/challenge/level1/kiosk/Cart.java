package challenge.level1.kiosk;

import challenge.level1.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Cart {

    /*속성*/
    private Map<Double, MenuItem> cartMap = new LinkedHashMap<>();
    private Map<Double, Integer> cartCount = new LinkedHashMap<>();

    /*생성자*/
    public Cart() {
    }

    /*기능*/
    /*cartMap 기능*/
    /*게터*/
    public Map<Double, MenuItem> getCartMap() {
        return cartMap;
    }

    /*세터*/
    public void addCartMap(Double key, MenuItem menuItem) {
        this.cartMap.put(key, menuItem);
    }

    public void setCartMap(Map<Double, MenuItem> cartMap) {
        this.cartMap = cartMap;
    }

    /*cartCount 기능*/
    /*담기*/
    public void addCartCount(Double key) {
        this.cartCount.putIfAbsent(key, 0);
        this.cartCount.replace(key, this.cartCount.get(key)+1);
    }

    /*뺴기*/
    public void subCartCount(Double key) {
        try{
        this.cartCount.replace(key, this.cartCount.get(key)-1);
        if(this.cartCount.get(key) == 0) {
            this.cartCount.remove(key);
            this.cartMap.remove(key);
        }
        } catch (NullPointerException e) {
            this.cartCount.remove(key);
            this.cartMap.remove(key);
            System.out.println("선택하신 상품이 장바구니에 담겨있지 않습니다.");
            return;
        }
    }

    /*게터*/
    public Optional<Integer> getCartCount(Double key) {
        return Optional.ofNullable(cartCount.get(key));
    }

}
