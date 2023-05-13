package it.uniroma3.diadia;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	Labirinto labirinto;
	Partita p;
	Stanza s;

//	Partita p = new Partita();
//	Stanza s = new Stanza("Stanza");
	
	@BeforeEach
	public void setUp() {
		 labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}
	
	@Test
	public void testVinta() {
		assertFalse(p.vinta());
	}

	@Test
	public void testIsFinita() {
    assertFalse(p.isFinita());
	}

}
