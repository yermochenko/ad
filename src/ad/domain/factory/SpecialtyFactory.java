package ad.domain.factory;

import ad.dao.SpecialtyDao;
import ad.domain.Specialty;
import ad.domain.bean.SpecialtyImpl;
import ad.domain.factory.exception.EntityCreateException;
import ad.domain.proxy.SpecialtyProxy;

public class SpecialtyFactory implements EntityFactory<Specialty> {
    private SpecialtyDao specialtyDao;

    public void setSpecialtyDao(SpecialtyDao specialtyDao) {
        this.specialtyDao = specialtyDao;
    }

    @Override
    public Specialty create() throws EntityCreateException {
        Specialty specialty = new SpecialtyImpl();
        SpecialtyProxy proxy = new SpecialtyProxy();
        proxy.setEntity(specialty);
        proxy.setSpecialtyDao(specialtyDao);
        return proxy;
    }
}
