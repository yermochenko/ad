package ad.dao.mysql;

import ad.dao.SpecialtyDao;
import ad.dao.exception.DaoException;
import ad.objects.Discipline;
import ad.objects.Specialty;
import ad.objects.bean.SpecialtyImpl;
import ad.objects.factory.EntityFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class SpecialtyDaoImpl extends DaoImpl<Specialty> implements SpecialtyDao{
    private EntityFactory<Specialty> specialtyFactory;

    public void setSpecialtyFactory(EntityFactory<Specialty> specialtyFactory) {
        this.specialtyFactory = specialtyFactory;
    }

    @Override
    protected int createRaw(Specialty specialtyImpl) throws DaoException {
        String sql = "INSERT INTO specialties (code, name, parent_id, qualification, shortname, specialty_direction) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement s = null;
        try {
            s = connection.prepareStatement(sql);
            s.setString(1, specialtyImpl.getCode());
            s.setString(2, specialtyImpl.getName());
            if(specialtyImpl.getParent()==null){
                s.setString(3,null);
            }else{
                s.setInt(3, specialtyImpl.getParent().getId());
            }
            s.setString(4, specialtyImpl.getQualification());
            s.setString(5, specialtyImpl.getShortName());
            s.setString(6, specialtyImpl.getSpecialtyDirection());
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
                return 0;
            }
        }
        return 1;
    }
    @Override
    protected void deleteRaw(int id) throws DaoException {
        String sql = "DELETE FROM specialties WHERE id=?";
        PreparedStatement s = null;
        try {
            s = connection.prepareStatement(sql);
            s.setInt(1, id);
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
    }
    @Override
    protected void updateRaw(Specialty specialtyImpl) throws DaoException {
        String sql = "UPDATE specialties SET code = ?, id = ?, name = ?, parent_id = ?, qualification = ?, shortname = ?, specialty_direction = ? WHERE id = ?";
        PreparedStatement s = null;
        try {
            s = connection.prepareStatement(sql);
            s.setString(1, specialtyImpl.getCode());
            s.setInt(2, specialtyImpl.getId());
            s.setString(3, specialtyImpl.getName());
            if(specialtyImpl.getParent()==null){
                s.setString(4,null);
                s.setNull(4, Types.INTEGER);
            }else{
                s.setInt(4, specialtyImpl.getParent().getId());
            }
            s.setString(5, specialtyImpl.getQualification());
            s.setString(6, specialtyImpl.getShortName());
            s.setString(7, specialtyImpl.getSpecialtyDirection());
            s.setInt(8, specialtyImpl.getId());
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
        }

        //specialties.put(specialtyImpl.getId(), specialtyImpl);
    }
    @Override
    protected Specialty readRaw(int id) throws DaoException {
        String sql = "SELECT  id, code, name, parent_id, qualification, shortname, specialty_direction FROM specialties WHERE id = ?";
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            s = connection.prepareStatement(sql);
            s.setInt(1, id);
            r = s.executeQuery();
            SpecialtyImpl specialtyImpl = null;
            if (r.next()) {
                specialtyImpl = new SpecialtyImpl();
                specialtyImpl.setId(r.getInt("id"));
                specialtyImpl.setCode(r.getString("code"));
                specialtyImpl.setName(r.getString("name"));
                specialtyImpl.setParent((SpecialtyImpl) read(r.getInt("parent_id")));
                specialtyImpl.setQualification(r.getString("qualification"));
                specialtyImpl.setShortName(r.getString("shortname"));
                specialtyImpl.setSpecialtyDirection(r.getString("specialty_direction"));
            }
            return specialtyImpl;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                r.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
        }

        //return specialties.get(id);
    }

    public Collection<Specialty> readAll() throws  DaoException {
        String sql = "SELECT  id, code, name, parent_id, qualification, shortname, specialty_direction FROM specialties";
        Statement s = null;
        ResultSet r = null;
        try {
            s = connection.createStatement();
            r = s.executeQuery(sql);
            Collection<Specialty> specialties = new ArrayList<>();
            while (r.next()) {
                SpecialtyImpl specialtyImpl =new SpecialtyImpl();
                specialtyImpl.setId(r.getInt("id"));
                specialtyImpl.setCode(r.getString("code"));
                specialtyImpl.setName(r.getString("name"));
                specialtyImpl.setParent((SpecialtyImpl) read(r.getInt("parent_id")));
                specialtyImpl.setQualification(r.getString("qualification"));
                specialtyImpl.setShortName(r.getString("shortname"));
                specialtyImpl.setSpecialtyDirection(r.getString("specialty_direction"));
                specialties.add(specialtyImpl);
            }
            return specialties;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                r.close();
            } catch (NullPointerException | SQLException e) {
            }
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
        }
    }

}
