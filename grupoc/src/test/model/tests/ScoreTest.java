package tests;

import org.junit.Assert;
import org.junit.Test;

import builders.ScoreBuilder;
import model.Score;

public class ScoreTest {

	@Test
	public void testIfCreateNewScoreThenTheStatusIsPendingIsTrue() {
		Score score = new ScoreBuilder().build();

		Assert.assertTrue(score.isPending());
		Assert.assertFalse(score.isFinish());
	}

	@Test
	public void testIfCreateNewScoreAndHasAScoreThenTheStatusIsPendingIsFalse() {
		Score score = new ScoreBuilder().build();
		score.setScore(3);
		Assert.assertEquals(score.getValue(), new Integer(3));
		Assert.assertFalse(score.isPending());
		Assert.assertTrue(score.isFinish());

	}
}
