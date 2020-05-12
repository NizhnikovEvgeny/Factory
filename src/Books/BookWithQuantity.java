/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

/**
 *
 * @author Женя
 */
public class BookWithQuantity {
    Bookable book;
    int quantity;
    private double pricePerDay;
    private double pricePerExtraDay;
    
    public BookWithQuantity(Bookable book){
        this.book=book;
        this.quantity = (int) Math.floor(Math.random()*5+1);
        this.pricePerDay = Math.random()*300+1;
        this.pricePerExtraDay = this.pricePerDay+100;
    }
    
    public void increaseQuantity(){
        this.quantity++;
    }
    public void decreaseQuantity(){
        this.quantity--;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
