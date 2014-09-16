

package model;

import java.util.List;

/**
 * Interface for accessing menu items.
 * @author Liz Ife Van Deslunt 
 */
public interface MenuItemAccessStrategy {

    /**
     * Returns a list of menu items.
     * @return 
     */
    public abstract List<MenuItem> getMenuItems();
    
}
