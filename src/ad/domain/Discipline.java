package ad.domain;

/**
 * Created by HomeInc on 06.12.2016.
 */
public interface Discipline extends Entity {
    String getName();
    void setName(String name);

    String getShortName();
    void setShortName(String shortname);
}
