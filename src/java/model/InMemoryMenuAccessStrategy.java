package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liz Ife Van Deslunt 
 */
public class InMemoryMenuAccessStrategy implements MenuItemAccessStrategy{
    List<MenuItem> menuItems;
    
    public InMemoryMenuAccessStrategy(){
        setMenuItems();
    }
    
    @Override
    public List<MenuItem> getMenuItems(){
      return menuItems; 
    }
    
    private void setMenuItems(){
        if(menuItems == null){
            menuItems = new ArrayList<MenuItem>();
        }
        
        menuItems.add(new MenuItem("Alaska Roll", "Salmon, cucumber, and avocado", 5.50));
        menuItems.add(new MenuItem("Avocado Roll", "Avocado rolled in seaweed and rice", 5.00));
        menuItems.add(new MenuItem("Boston Roll", "Shrimp, Cucumber, Lettuce, Mayo", 6.00));
        menuItems.add(new MenuItem("California Roll", "Crab meat, cucumber, and avocado", 6.00));
        menuItems.add(new MenuItem("Dragon Roll", "Crab meat, eel, avocado, cucumber, topped with Avocado and Eel sauce", 6.50));
        menuItems.add(new MenuItem("Eel Avocado Roll", "Eel and avocado in red rice paper and rice", 5.50));
        menuItems.add(new MenuItem("Philadelphia Roll", "Smoked salmon, cream cheese, and cucumber", 6.50));
        menuItems.add(new MenuItem("Rainbow Roll", "Crab meat, avocado, and cucumber topped with tuna, salmon, shirmp, and yellowtail tuna", 7.50));
        menuItems.add(new MenuItem("Salmon Roll", "Salmon wrapped in rice and seaweed", 5.00));
        menuItems.add(new MenuItem("Spider Roll", "Soft shell crab, masago, lettuce, cucumber, and eel sauce", 7.00));
        menuItems.add(new MenuItem("Super Tempura Roll", "Spicy tuna and avocado deep fried in tempura batter topped with spicy mayo and eel sauce", 6.50));
        menuItems.add(new MenuItem("Tempura Roll", "Your choice of shrimp or crab and avocado deep fried in tempura batter topped with spicy mayo", 6.00));
        menuItems.add(new MenuItem("Tuna Roll", "Tuna with rice wrapped in seaweed", 5.00));
        menuItems.add(new MenuItem("Vegetable Roll", "Cucumber, avocado, and asparagus", 5.00));
        menuItems.add(new MenuItem("Yellowtail Roll", "Yellowtail tuna with rice wrapped in seaweed", 6.00));
        menuItems.add(new MenuItem("Waukesha Roll", "A specialty roll named after our hometown! Salmon, tuna, and spicy mayo topped with salmon and roe.", 14.50));
        menuItems.add(new MenuItem("Milwaukee Roll", "A classy specialty roll, and a chef favorite. Salmon, cilantro, and cucumber, topped with salmon and green onion", 15.50));
        menuItems.add(new MenuItem("Rock n Roe", "Salmon, tempura crisp, and avocado inside, topped with spicy mayo, sesame seeds, and salmon roe.", 17.50));
        menuItems.add(new MenuItem("Tuna Loca Roll", "Tuna, shrimp, and cucumber come together in this roll, spiced with spicy sauce and jalapeno", 18.00));
        menuItems.add(new MenuItem("Fire Breather Roll", "This roll is HOT. Jalapenos, crab, yellowtail, and tempura crisp, infused with chili powder and wasabi, all wrapped up in red soypaper", 5.50));
        menuItems.add(new MenuItem("Salmon Sashimi (Sake)", "Six fresh cuts of salmon (sake). Our most popular sashimi.", 6.00));
        menuItems.add(new MenuItem("Tuna Sashimi (Maguro)", "Six fresh cuts of tuna (sake).", 6.00));
        menuItems.add(new MenuItem("Yellowtail Sashimi (Hamachi)", "Six fresh cuts of yellowtail (hamachi)", 6.00));
        menuItems.add(new MenuItem("Salmon Nigiri", "Fresh salmon over rice.", 6.00));
        menuItems.add(new MenuItem("Tuna Nigiri", "Fresh tuna over rice.", 6.00));
        menuItems.add(new MenuItem("Yellowtail Nigiri", "Fresh yellowtail over rice.", 6.00));
    }
}
