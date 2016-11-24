package ad.dao;

public interface Dao <T> {
	T read(int id) throws Exception;
	int create(T object) throws Exception;
	void update(T object) throws Exception;
	void delete(int id) throws Exception;
}
