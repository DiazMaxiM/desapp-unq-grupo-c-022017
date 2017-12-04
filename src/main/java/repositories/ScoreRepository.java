package repositories;

import java.io.Serializable;
import java.util.List;

import model.Score;

public class ScoreRepository extends HibernateGenericDAO<Score> implements GenericRepository<Score> {


	@Override
	protected Class<Score> getDomainClass() {
		
		return Score.class;
	}

	public List<Score> scoresOfUser(String idClient) {
		List<Score> find = (List<Score>) this.getHibernateTemplate()
				.find("from " + this.persistentClass.getName() + " where client.id ='" + idClient + "'");
		return find; 
	}


}
