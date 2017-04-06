package ad.domain.proxy;

import java.util.List;

import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.domain.Specialty;

public class SpecialtyProxy extends BaseProxy<Specialty> implements Specialty {
    private SpecialtyDao specialtyDao;
    private boolean parentNotLoaded = true;
    private boolean childrenNotLoaded = true;

    public void setSpecialtyDao(SpecialtyDao specialtyDao) {
        this.specialtyDao = specialtyDao;
    }

    @Override
    public String getCode() {
        return getEntity().getCode();
    }

    @Override
    public void setCode(String code) {
        getEntity().setCode(code);
    }

    @Override
    public String getShortName() {
        return getEntity().getShortName();
    }

    @Override
    public void setShortName(String shortName) {
        getEntity().setShortName(shortName);
    }

    @Override
    public String getName() {
        return getEntity().getName();
    }

    @Override
    public void setName(String name) {
        getEntity().setName(name);
    }

    @Override
    public String getQualification() {
        return getEntity().getQualification();
    }

    @Override
    public void setQualification(String qualification) {
        getEntity().setQualification(qualification);
    }

    @Override
    public Specialty getParent() throws DaoException {
        if(parentNotLoaded) {
            Specialty parent = getEntity().getParent();
            if(parent != null && parent.getId() != null) {
                parent = specialtyDao.read(parent.getId());
                getEntity().setParent(parent);
            }
            parentNotLoaded = false;
        }
        return getEntity().getParent();
    }

    @Override
    public void setParent(Specialty parent) {
        getEntity().setParent(parent);
    }

    @Override
    public List<Specialty> getChildren() throws DaoException {
        if(childrenNotLoaded) {
            List<Specialty> children = specialtyDao.readByParent(getEntity().getId());
            getEntity().setChildren(children);
            childrenNotLoaded = false;
        }
        return getEntity().getChildren();
    }

    @Override
    public void setChildren(List<Specialty> children) {
        getEntity().setChildren(children);
    }
}
