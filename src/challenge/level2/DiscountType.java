package challenge.level2;

public enum DiscountType {
    /*속성*/
   국가유공자(10),
    군인(5),
    학생(3),
    일반(0);

    private final int discount;

    /*생성자*/
    DiscountType(int discount){
this.discount = discount;
    }

    /*기능*/
    /*게터*/
    public int getDiscount(){
        return discount;
    }
    /*할인율 계산*/
/*    public double discountCalcuate(int discount){
        this.discount = discount;
        return discount * discount;
    }*/

}
