package ad.dao;

import ad.dao.mysql.DaoContainerImpl;

public class DaoContainerFactory {
    public static DaoContainer create() {
        return new DaoContainerImpl();
    }
}
