package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	
	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.io = console;

	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
//		System.out.println(MESSAGGIO_BENVENUTO);
//		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando daEseguire = new Comando(istruzione);
		if(daEseguire.getNome()==null) {
			//System.out.println("Non hai inserito niente!");
			io.mostraMessaggio("Non hai inserito niente!");
		//if("fine".equals(nome))
		}
		else if(daEseguire.getNome().equals("prendi")) {
			this.prendi(daEseguire.getParametro());
		}
		else if(daEseguire.getNome().equals("posa")) {
			this.posa(daEseguire.getParametro());
		}
		else if (daEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
			//if("vai".equals(nome))
		} else if (daEseguire.getNome().equals("vai"))
			this.vai(daEseguire.getParametro());
		else if (daEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			//System.out.println("Comando sconosciuto");
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			//System.out.println("Hai vinto!");
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
		  io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		    
		
		    String istruzione;
//		    Scanner	scannerDiLinee = new Scanner(System.in);	
		    
			do		
			/*istruzione = scannerDiLinee.nextLine();*/
				istruzione = io.leggiRiga();
			while (!processaIstruzione(istruzione)); io.leggiRiga(); //scannerDiLinee = new Scanner(System.in);		
			do		
				istruzione = io.leggiRiga();
			while (!processaIstruzione(istruzione));
		}
		
	
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
		/*	System.out.println("Direzione inesistente");*/
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio("Stanza corrente:");
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa: ");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	private void prendi(String NomeAttrezzo) {
		
		Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(NomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		this.partita.getStanzaCorrente().removeAttrezzo(a);	}
		
	
  private void posa(String NomeAttrezzo) {
	  Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(NomeAttrezzo);
		this.partita.getStanzaCorrente().addAttrezzo(a);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(NomeAttrezzo);
  
  }
	
	
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
;		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}