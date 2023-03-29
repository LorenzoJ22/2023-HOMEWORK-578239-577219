package it.uniroma3.diadia;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartitaTest {
	Partita p = new Partita();
	Stanza s = new Stanza("Stanza");
	
	
	@Test
	public void testVinta() {
		assertFalse(p.vinta());
	}

	@Test
	public void testIsFinita() {
    assertFalse(p.isFinita());
	}

}
