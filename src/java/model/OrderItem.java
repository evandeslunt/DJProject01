/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Liz Ife Van Deslunt 
 */
public class OrderItem implements Product {
    private String name;
    private String description;
    private double price;
    private double quantity;
    
    public OrderItem(String name, String description, double price, double quantity){
        setName(name);
        setDescription(description);
        setPrice(price);
        setQuantity(quantity);
    }
    
    @Override
    public final String getName(){
        return name;
    }
    @Override
    public final String getDescription(){
        return description;
    }
    @Override
    public final double getPrice(){
        return price;
    }
    
    public final double getQuantity(){
        return quantity;
    }
    
    public final double getTotalCost(){
        return price * quantity;
    }
    
    
     
    /**
     * Sets the name of the menu item.
     * @param name - The name of the menu item.
     * @throws IllegalArgumentException if name is null or empty
     */
    @Override
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
    @Override
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
    @Override
    public final void setPrice(double price){
        if(price < 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }
    
    
    /**
     * Sets the quantity ordered.
     * @param quantity The quantity ordered
     */
    public final void setQuantity(double quantity){
        if(quantity < 0){
            throw new IllegalArgumentException();
        }
        this.quantity = quantity;
    }
    
}
