package challenge.level1.kiosk;

import java.util.LinkedHashMap;
import java.util.Map;

public class Discount {

    /*속성*/
    private Map<String, Integer> discountMap = new LinkedHashMap<>();

    /*생성자*/
    public Discount() {
        discountMap.put("국가유공자", 10);
        discountMap.put("군인", 5);
        discountMap.put("학생", 3);
        discountMap.put("일반", 0);
    }

    /*기능*/
    /*게터*/
    public Map<String, Integer> getDiscountMap() {
        return discountMap;
    }
    public Integer getDiscount(String type) {
        return discountMap.get(type);
    }
    /*세터*/
    public void addDiscount(String type, int discount) {
        this.discountMap.put(type, discount);
    }
}
