package ad.dao;

import ad.dao.mysql.DaoContainerImpl;

/**
 * Created by HomeInc on 09.12.2016.
 */
public class DaoContainerFactory {
    public static DaoContainer create(){
        return new DaoContainerImpl();
    }
}
