
package model;

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
    private double foodTotal;
    private double taxRate; 
    private double gratuityRate; 
    
    private final double DEFAULT_TAX_RATE = .05;
    private final double DEFAULT_GRATUITY_RATE = .20;
    
    public OrderService(){
        foodTotal = 0;
        setTaxRate(DEFAULT_TAX_RATE);
        setGratuityRate(DEFAULT_GRATUITY_RATE);
    }
    
    public OrderService(double taxRate, double gratuityRate){
        setTaxRate(taxRate);
        setGratuityRate(gratuityRate);
    }
    
    /**
     * Returns the total price of food for the order, excluding tax and gratuity.
     * @return the total price of food
     */
    public final double getFoodTotal(){
        return foodTotal;
    }
    
    /**
     * Returns the tax rate as a value between 0 and 1.
     * @return the tax rate
     */
    public final double getTaxRate(){
        return taxRate;
    }
    
    /**
     * Returns the gratuity rate used to calculate the suggested tip, as a value
     * between 0 and 1.
     * @return the gratuity rate
     */
    public final double getGratuityRate(){
        return gratuityRate;
    }
    
    /**
     * Sets the sales tax rate.
     * @param taxRate The tax rate, a percent value between 0 and 1.
     */
    public final void setTaxRate(double taxRate){
        
    }
    
    /**
     * Sets the gratuity rate used to calculate the suggested tip.
     * @param gratuityRate The gratuity rate, a percent value between 0 and 1.
     */
    public final void setGratuityRate(double gratuityRate){
        
    }
    /**
     * Returns the total bill with tax included.
     * @return total bill with tax included.
     */
    public final double getTotalWithTax(){
        return foodTotal + (foodTotal * taxRate);
    }
    
    /**
     * Returns the total bill including tax and suggested tip.
     * @return the total bill including tax and suggested tip.
     */
    public final double getTotalWithTip(){
        return getTotalWithTax() + (foodTotal * gratuityRate);
    }
    
    /**
     * Adds the given amount to the food total.
     * @param amount The amount to add to the food total.
     * @throws IllegalArgumentException if the amount is less than 0.
     */
    public final void addToFoodTotal(double amount){
        if(amount < 0){
            throw new IllegalArgumentException();
        }
        
        foodTotal += amount;
    }
    
}
