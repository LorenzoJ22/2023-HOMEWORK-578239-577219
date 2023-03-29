package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaTest1Test {
	Stanza s1 = new Stanza("s1");
	Stanza s2= new Stanza("s2");
	Attrezzo m = new Attrezzo("martello", 42);
	private Stanza vuota;
	private Stanza nonVuota;
	private Attrezzo osso;
	
	@BeforeEach
	public void setUp() {
		this.vuota = new Stanza("vuota");
		System.out.println("sto eseguendo il setUp");
		this.nonVuota = new Stanza("nonVuota");
		this.osso = new Attrezzo("osso", 1);
		//this.vuota.addAttrezzo(new Attrezzo("osso", 1));
	}
	@Test
	public void testHasAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("osso"));
	}
	@Test
	final void testAddAttrezzo() {
		this.vuota.addAttrezzo(new Attrezzo("osso", 1));
		assertTrue(this.vuota.hasAttrezzo("osso"));
	}
	/*
	final void testGetAttrezzo() {
		assertEquals(new Attrezzo("osso",1), this.nonVuota.getAttrezzo("osso"));
	}*/
	
	/*final void testRemoveAttrezzo(){
	 * assertTrue(this.nonVuota.removeAttrezzo(this.osso));
	 * assertFalse(this.vuota.removeAttrezzo(this.osso));
	 * 
 }	*/
	
	
/*	
		public void testAddAttrezzo() {
			
			assertTrue(s1.addAttrezzo(m));
		}*/
		
	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2, s1.getStanzaAdiacente("sud"));
	}
	@Test
	public void testRemoveAttrezzo() {
		assertTrue(s1.removeAttrezzo(m));
	}
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
	}
	
	
	
	
	
}
