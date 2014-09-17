
package model;

import java.util.List;

/**
 * This class performs the following functions for the Sushi website:
 *  (1) Calculates the total price of the order
 *      (a) food total
 *      (b) tax
 *      (c) suggested gratuity 
 *  (2) Stores the customer's information in the database, if indicated
 * @author Liz Ife Van Deslunt 
 */
public class OrderService {
    private Double foodTotal;
    private Double taxRate; 
    private Double gratuityRate; 
    
    private final Double DEFAULT_TAX_RATE = .05;
    private final Double DEFAULT_GRATUITY_RATE = .20;
    
    public OrderService(){
        foodTotal = 0.0;
        setTaxRate(DEFAULT_TAX_RATE);
        setGratuityRate(DEFAULT_GRATUITY_RATE);
    }
    
    public OrderService(List<OrderItem> items){
        setTaxRate(DEFAULT_TAX_RATE);
        setGratuityRate(DEFAULT_GRATUITY_RATE);
        addOrderItems(items);
    }
    
    public OrderService(Double taxRate, Double gratuityRate, List<OrderItem> items){
        setTaxRate(taxRate);
        setGratuityRate(gratuityRate);
        addOrderItems(items);
    }
    
    /**
     * Returns the total price of food for the order, excluding tax and gratuity.
     * @return the total price of food
     */
    public final Double getFoodTotal(){
        return foodTotal;
    }
    
    /**
     * Returns the tax rate as a value between 0 and 1.
     * @return the tax rate
     */
    public final Double getTaxRate(){
        return taxRate;
    }
    
    /**
     * Returns the gratuity rate used to calculate the suggested tip, as a value
     * between 0 and 1.
     * @return the gratuity rate
     */
    public final Double getGratuityRate(){
        return gratuityRate;
    }
    
    /**
     * Sets the sales tax rate.
     * @param taxRate The tax rate, a percent value between 0 and 1.
     */
    public final void setTaxRate(Double taxRate){
        if(taxRate == null || taxRate < 0){
            throw new IllegalArgumentException();
        }
        this.taxRate = taxRate;
    }
    
    /**
     * Sets the gratuity rate used to calculate the suggested tip.
     * @param gratuityRate The gratuity rate, a percent value between 0 and 1.
     */
    public final void setGratuityRate(Double gratuityRate){
        if(gratuityRate == null || gratuityRate < 0){
            throw new IllegalArgumentException();
        }
        this.gratuityRate = gratuityRate;
    }
    /**
     * Returns the total bill with tax included.
     * @return total bill with tax included.
     */
    public final Double getTotalWithTax(){
        return foodTotal + (foodTotal * taxRate);
    }
    
    /**
     * Returns the total bill including tax and suggested tip.
     * @return the total bill including tax and suggested tip.
     */
    public final Double getTotalWithTip(){
        return getTotalWithTax() + (foodTotal * gratuityRate);
    }
    
    /**
     * Adds the given amount to the food total.
     * @param items A List of OrderItems to add to the order.
     * @throws IllegalArgumentException if the list is null.
     */
    public final void addOrderItems(List<OrderItem> items){
        if(items == null){
            throw new IllegalArgumentException();
        }
        if(foodTotal == null){
            foodTotal = 0.0;
        }
        for(int i = 0; i < items.size(); i++){
            foodTotal += items.get(i).getPrice();
        }
    }
    
    
    
}
