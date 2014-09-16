
package model;

import java.util.List;

/**
 * Retrieves menu information from the data source.
 * @author Liz Ife Van Deslunt 
 */
public class MenuService {
    private List<MenuItem> menu;

    public MenuService(){
        menu = new InMemoryMenuAccessStrategy().getMenuItems();
    }
    
    public List<MenuItem> getMenuItems(){
        return menu;
    }
}
