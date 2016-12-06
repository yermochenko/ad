package ad.dao.mysql;

import ad.dao.SpecialtyDao;
import ad.objects.bean.SpecialtyImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class SpecialtyDaoImpl extends BasicStorage implements SpecialtyDao{
    public int create(SpecialtyImpl specialtyImpl) throws SQLException {
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
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
                return 0;
            }
        }
        return 1;
    }
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM specialties WHERE id=?";
        PreparedStatement s = null;
        try {
            s = connection.prepareStatement(sql);
            s.setInt(1, id);
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
        }

        //specialties.remove(id);
    }
    public void update(SpecialtyImpl specialtyImpl) throws SQLException {
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
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
        }

        //specialties.put(specialtyImpl.getId(), specialtyImpl);
    }
    public SpecialtyImpl read(int id) throws SQLException {
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
                specialtyImpl.setParent(read(r.getInt("parent_id")));
                specialtyImpl.setQualification(r.getString("qualification"));
                specialtyImpl.setShortName(r.getString("shortname"));
                specialtyImpl.setSpecialtyDirection(r.getString("specialty_direction"));
            }
            return specialtyImpl;
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
    public Collection<SpecialtyImpl> readAll() throws SQLException {
        String sql = "SELECT  id, code, name, parent_id, qualification, shortname, specialty_direction FROM specialties";
        Statement s = null;
        ResultSet r = null;
        try {
            s = connection.createStatement();
            r = s.executeQuery(sql);
            Collection<SpecialtyImpl> specialties = new ArrayList<>();
            while (r.next()) {
                SpecialtyImpl specialtyImpl =new SpecialtyImpl();
                specialtyImpl.setId(r.getInt("id"));
                specialtyImpl.setCode(r.getString("code"));
                specialtyImpl.setName(r.getString("name"));
                specialtyImpl.setParent(read(r.getInt("parent_id")));
                specialtyImpl.setQualification(r.getString("qualification"));
                specialtyImpl.setShortName(r.getString("shortname"));
                specialtyImpl.setSpecialtyDirection(r.getString("specialty_direction"));
                specialties.add(specialtyImpl);
            }
            return specialties;
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

        //return specialties.values();
    }
}
