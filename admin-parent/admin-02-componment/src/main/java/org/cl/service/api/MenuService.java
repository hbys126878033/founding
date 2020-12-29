package org.cl.service.api;

import org.cl.entity.Menu;

import java.util.List;

/**
 * @author chenlin
 * @create 2020-06-14 22:12
 * @description: TODO
 * @version：1.0
 **/
public interface MenuService {

    public List<Menu> getAll();

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void removeMenu(Integer id);
}
