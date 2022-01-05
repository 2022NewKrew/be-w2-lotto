<<<<<<< HEAD
package lotto.domain;public class Money {
=======
package lotto.domain;

public class Money {
    private Integer amount;
    public Money(Integer amount){
        this.amount = amount;
    }
    public Money(){
        this(0);
    }

    public Integer getAmount(){
        return this.amount;
    }

    public void decrement(Integer decAmount) throws IllegalArgumentException{
        if (amount - decAmount < 0){
            throw new IllegalArgumentException("금액이 모자랍니다.");
        }
        this.amount -= decAmount;
    }
>>>>>>> 73407950a993c8ab02b196cc1f9fecf44a984723
}
