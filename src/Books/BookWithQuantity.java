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
    public Bookable book;
    int quantity;
    private double pricePerDay;
    private double pricePerExtraDay;
    int id;
    static int id_all;
    
    public BookWithQuantity(Bookable book){
        this.book=book;
        this.quantity = (int) Math.floor(Math.random()*5+1);
        this.pricePerDay = Math.random()*10+1;
        this.pricePerExtraDay = this.pricePerDay*2;
        id=id_all++;
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

    public double getPricePerDay() {
        return pricePerDay;
    }

    public double getPricePerExtraDay() {
        return pricePerExtraDay;
    }

    public int getId() {
        return id;
    }

    public Bookable getBook() {
        return book;
    }
    
}
