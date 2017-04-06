package ad.domain.factory;

import ad.domain.Specialty;
import ad.domain.bean.SpecialtyImpl;
import ad.domain.factory.exception.EntityCreateException;

public class SpecialtyFactory implements EntityFactory<Specialty> {
    @Override
    public Specialty create() throws EntityCreateException {
        Specialty specialty = new SpecialtyImpl();
        specialty.setParent(new SpecialtyImpl());
        return specialty;
    }
}
