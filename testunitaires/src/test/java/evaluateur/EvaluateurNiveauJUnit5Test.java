package evaluateur;

//import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Tests fonctionnels de la classe EvaluateurNiveau")
class EvaluateurNiveauJUnit5Test {

	private static EvaluateurNiveau evaluateur;

	@DisplayName("Tests aux limites EvaluateurNiveau")
	@ParameterizedTest(name = "{index} => cours={0}, examen={1}, attendu={2}")
	@CsvFileSource(resources = "/test-data.csv")
	void testsLimitesEvaluateurNiveau(String cours, String examen, String attendu) throws Exception {
		assertEquals(evaluateur.evaluerNiveau(cours, examen), attendu);
		assertThat(evaluateur.evaluerNiveau(cours, examen), is(attendu));
	}

	@Test
	public void testMauvaisFormatCours() {
		Assertions.assertThrows(Exception.class, () -> {
			evaluateur.evaluerNiveau("1C", "70");
		});
	}

	@Test
	public void testValeurHorsBornesExamen() {
		Assertions.assertThrows(Exception.class, () -> {
			evaluateur.evaluerNiveau("20", "76");
		});
	}
}
