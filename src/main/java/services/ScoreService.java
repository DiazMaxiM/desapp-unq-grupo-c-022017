package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.Menu;
import model.Score;
import repositories.MenuRepository;
import repositories.ScoreRepository;

public class ScoreService extends GenericService<Score> {

	private static final long serialVersionUID = 1L;
    
	@Transactional
	public boolean hasPendingScoreForClient(String idClient) {
		
		ScoreRepository repo = (ScoreRepository) this.getRepository();
		List<Score> scoresList = repo.scoresOfUser(idClient);

		Long countPending = scoresList.stream().filter(score -> score.isPending()).count();
		
		return countPending > 0;
	}
    
	@Transactional
	public List<Score> getAllScore() {
		
		 ScoreRepository repo = (ScoreRepository) this.getRepository();
		 return repo.findAll();

	}

	@Transactional
	public  List<Score> scores(String idClient) {
		ScoreRepository repo = (ScoreRepository) this.getRepository();
		return repo.scoresOfUser(idClient);

	}

}
