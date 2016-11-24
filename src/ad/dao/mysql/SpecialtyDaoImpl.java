package ad.dao.mysql;

import ad.BasicStorage;
import ad.dao.SpecialtyDao;
import ad.objects.Specialty;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class SpecialtyDaoImpl extends BasicStorage implements SpecialtyDao{
    public int create(ad.objects.Specialty specialty) throws SQLException {
        String sql = "INSERT INTO specialties (code, name, parent_id, qualification, shortname, specialty_direction) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement s = null;
        try {
            s = connection.prepareStatement(sql);
            s.setString(1, specialty.getCode());
            s.setString(2,specialty.getName());
            if(specialty.getParent()==null){
                s.setString(3,null);
            }else{
                s.setInt(3,specialty.getParent().getId());
            }
            s.setString(4,specialty.getQualification());
            s.setString(5, specialty.getShortName());
            s.setString(6, specialty.getSpecialtyDirection());
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
    public void update(ad.objects.Specialty specialty) throws SQLException {
        String sql = "UPDATE specialties SET code = ?, id = ?, name = ?, parent_id = ?, qualification = ?, shortname = ?, specialty_direction = ? WHERE id = ?";
        PreparedStatement s = null;
        try {
            s = connection.prepareStatement(sql);
            s.setString(1, specialty.getCode());
            s.setInt(2, specialty.getId());
            s.setString(3,specialty.getName());
            if(specialty.getParent()==null){
                s.setString(4,null);
                s.setNull(4, Types.INTEGER);
            }else{
                s.setInt(4,specialty.getParent().getId());
            }
            s.setString(5,specialty.getQualification());
            s.setString(6, specialty.getShortName());
            s.setString(7, specialty.getSpecialtyDirection());
            s.setInt(8, specialty.getId());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
            }
        }

        //specialties.put(specialty.getId(), specialty);
    }
    public ad.objects.Specialty read(int id) throws SQLException {
        String sql = "SELECT  id, code, name, parent_id, qualification, shortname, specialty_direction FROM specialties WHERE id = ?";
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            s = connection.prepareStatement(sql);
            s.setInt(1, id);
            r = s.executeQuery();
            Specialty specialty = null;
            if (r.next()) {
                specialty = new Specialty();
                specialty.setId(r.getInt("id"));
                specialty.setCode(r.getString("code"));
                specialty.setName(r.getString("name"));
                specialty.setParent(read(r.getInt("parent_id")));
                specialty.setQualification(r.getString("qualification"));
                specialty.setShortName(r.getString("shortname"));
                specialty.setSpecialtyDirection(r.getString("specialty_direction"));
            }
            return specialty;
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
    public Collection<Specialty> readAll() throws SQLException {
        String sql = "SELECT  id, code, name, parent_id, qualification, shortname, specialty_direction FROM specialties";
        Statement s = null;
        ResultSet r = null;
        try {
            s = connection.createStatement();
            r = s.executeQuery(sql);
            Collection<Specialty> specialties = new ArrayList<>();
            while (r.next()) {
                Specialty specialty=new Specialty();
                specialty.setId(r.getInt("id"));
                specialty.setCode(r.getString("code"));
                specialty.setName(r.getString("name"));
                specialty.setParent(read(r.getInt("parent_id")));
                specialty.setQualification(r.getString("qualification"));
                specialty.setShortName(r.getString("shortname"));
                specialty.setSpecialtyDirection(r.getString("specialty_direction"));
                specialties.add(specialty);
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
