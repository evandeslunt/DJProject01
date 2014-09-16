
package model;

/**
 * This class represents a menu item at Volcano Sushi.
 * @author Liz Ife Van Deslunt 
 */
public class MenuItem {
    private String name;
    private String description;
    private double price;
    
    public MenuItem(String name, String description, double price){
        setName(name);
        setDescription(description);
        setPrice(price);
    }
    
    
    /**
     * Returns the name of the menu item.
     * @return The name of the menu item
     */
    public final String getName(){
        return name;
    }
    
    /**
     * Returns the description of the menu item.
     * @return The description of the menu item
     */
    public final String getDescription(){
        return description;
    }
    
    /**
     * Returns the price of the menu item.
     * @return The price of the menu item
     */
    public final double getPrice(){
        return price;
    }
    
    /**
     * Sets the name of the menu item.
     * @param name - The name of the menu item.
     * @throws IllegalArgumentException if name is null or empty
     */
    public final void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        
        this.name = name;
        
    }
    
    /**
     * Sets the description of the menu item.
     * @param description - The name of the menu item.
     * @throws IllegalArgumentException if description is null or empty
     */
    public final void setDescription(String description){
        if(description == null || description.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.description = description;
    }
    
    /**
     * Sets the price of the menu item.
     * @param price - The name of the menu item.
     * @throws IllegalArgumentException if price is less than 0
     */
    public final void setPrice(double price){
        if(price < 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }
}
