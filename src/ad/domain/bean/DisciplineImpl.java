package ad.domain.bean;

import ad.domain.Discipline;

/*
 * Дисциплины
 */
public class DisciplineImpl extends EntityImpl implements Discipline {
    private String name;
    private String shortname;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getShortName() {
        return shortname;
    }

    @Override
    public void setShortName(String shortname) {
        this.shortname = shortname;
    }
}
