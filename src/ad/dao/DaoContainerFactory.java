package ad.dao;

/**
 * Created by HomeInc on 09.12.2016.
 */
public class DaoContainerFactory {
    public static DaoContainer create(){
        return new DaoContainerImpl();
    }
}
