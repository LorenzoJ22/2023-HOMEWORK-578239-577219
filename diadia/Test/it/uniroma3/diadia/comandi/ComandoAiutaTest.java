package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.fixture.Fixture;

class ComandoAiutaTest {
	List<String> righeDaLeggere;
	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testPartitaConComandoAiuto() {
		righeDaLeggere.add("aiuto");
		righeDaLeggere.add("fine");
		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		for(int i=0; i < ComandoAiuto.ELENCO_COMANDI.length; i++) {
			assertTrue(io.hasNextMessaggio());
			assertEquals(ComandoAiuto.ELENCO_COMANDI[i]+" ", io.nextMessaggio());
		}
		assertTrue(io.hasNextMessaggio());
		io.nextMessaggio();
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

}
