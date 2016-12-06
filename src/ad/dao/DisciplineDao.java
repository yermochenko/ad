package ad.dao;

import java.util.Collection;

import ad.objects.bean.DisciplineImpl;

public interface DisciplineDao extends Dao<DisciplineImpl> {
	Collection <DisciplineImpl> readAll() throws Exception;
}
