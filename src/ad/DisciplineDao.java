package ad;

import java.util.Collection;

import ad.objects.Discipline;

public interface DisciplineDao extends Dao<Discipline> {
	Collection <Discipline> readAll() throws Exception;
}
