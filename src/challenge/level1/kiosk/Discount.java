package challenge.level1.kiosk;

import java.util.LinkedHashMap;
import java.util.Map;

public class Discount {

    /*속성*/
    private Map<String, Integer> discount = new LinkedHashMap<>();

    /*생성자*/
    public Discount() {
        discount.put("국가유공자", 10);
        discount.put("군인", 5);
        discount.put("학생", 3);
        discount.put("일반", 0);
    }

    /*기능*/
    /*게터*/
    public Map<String, Integer> getDiscountMap() {
        return discount;
    }
    public Integer getDiscount(String type) {
        return discount.get(type);
    }
    /*세터*/
    public void addDiscount(String type, int discount) {
        this.discount.put(type, discount);
    }
}
