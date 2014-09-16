
package model;

/**
 * Describes the items available at Volcano Sushi
 * @author Liz Ife Van Deslunt 
 */
public interface Product {
    
    public abstract String getName();
    public abstract String getDescription();
    public abstract double getPrice();
    
    public abstract void setName(String name);
    public abstract void setDescription(String description);
    public abstract void setPrice(double price);

}
