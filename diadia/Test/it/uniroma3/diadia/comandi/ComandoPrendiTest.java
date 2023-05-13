package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private Attrezzo attrezzoNull;
	private Comando comando;
	private IO io;
	Labirinto labirinto;

//	@BeforeEach
//	public void setUp() throws Exception {
//		partita = new Partita();
//		attrezzo = new Attrezzo("martello", 2);
//		attrezzoPesante = new Attrezzo("incudine", 11);
//		attrezzoNull = null;
//		comando = new ComandoPrendi();
//		io = new IOConsole();
//		comando.setIo(io);
//	}
	@BeforeEach
	public void setUp() throws Exception {
		labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		partita = new Partita(labirinto);
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("incudine", 11);
		attrezzoNull = null;
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIo(io);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	public boolean attrezzoPresente(String s) {
//		List<Attrezzo> array = partita.getStanzaCorrente().getAttrezzi();
//		for(Attrezzo a : array) {
//			if(a != null && s.equals(a.getNome()))
//					return true;
//		}
//		return false;
		if(partita.getStanzaCorrente().getAttrezzo(s)==null)
			return false;
		return true;
	}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}
	@Test
	public void testAttrezzoNonPresente() {
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("incudine");
		comando.esegui(partita);
		assertTrue(attrezzoPresente("incudine"));
	}
	
}
