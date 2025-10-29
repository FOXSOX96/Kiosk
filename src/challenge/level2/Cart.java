package challenge.level2;

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
    /*1.cartMap 기능*/
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

    /*2.cartCount 기능*/
    /*담기*/
    public void addCartCount(Double key) {
        this.cartCount.putIfAbsent(key, 0);
        this.cartCount.replace(key, this.cartCount.get(key) + 1);
    }

    /*뺴기*/
    public void subCartCount(Double key) {
        try {
            this.cartCount.replace(key, this.cartCount.get(key) - 1);
            if (this.cartCount.get(key) == 0) {
                this.cartCount.remove(key);
                this.cartMap.remove(key);
            }
        } catch (NullPointerException e) {
            this.cartCount.remove(key);
            this.cartMap.remove(key);
            System.out.println("선택하신 상품이 장바구니에 담겨있지 않습니다.");
        }
    }

    /*게터*/
    public Optional<Integer> getCartCount(Double key) {
        return Optional.ofNullable(cartCount.get(key));
    }

    public Map<Double, Integer> getCartCountMap() {
        return cartCount;
    }

    /*3.공통 기능*/
    /*cart 맵 일괄 삭제*/
    public void cartClear() {
        cartMap.clear();
        cartCount.clear();
    }

    /*장바구니 현재 상태 안내매서드*/
    public void cartState() {
        System.out.println("[ 장바구니 ]");
        getCartMap().entrySet().stream()
                .forEach( entry ->   System.out.printf("%-14s | W %4.1f | 수량: %d\n",
                        entry.getValue().getMenuName(), entry.getValue().getMenuPrice(), getCartCount(entry.getKey()).orElse(0)));
        if (getCartMap().isEmpty()) {
            System.out.println("비어있음");
        }
    }

}
