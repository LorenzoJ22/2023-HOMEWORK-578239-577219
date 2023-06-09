package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;


import java.util.*;
import java.util.Iterator;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
//	public List<Stanza> getStanzeAdiacenti() {
//		return stanzeAdiacenti;
//	}
//
//	public void setStanzeAdiacenti(List<Stanza> stanzeAdiacenti) {
//		this.stanzeAdiacenti = stanzeAdiacenti;
//	}
//
//	public int getNumeroStanzeAdiacenti() {
//		return numeroStanzeAdiacenti;
//	}
//
//	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
//		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
//	}
//
//	public void setDirezioni(List<String> direzioni) {
//		this.direzioni = direzioni;
//	}
//	public int getNumeroAttrezziPossibili() {
//		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
//	}
	
	public List<Stanza> getStanzeAdiacenti() {
		return (List<Stanza>) direzioni2stanze.values();
	}

	public void setStanzeAdiacenti(Map<String, Stanza> stanzeAdiacenti) {
		this.direzioni2stanze = stanzeAdiacenti;
	}

	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
//	private String nome;
//	private List<Attrezzo> attrezzi;
//    private int numeroAttrezzi;
//    private List<Stanza> stanzeAdiacenti; 
//    private int numeroStanzeAdiacenti;
//	private List<String> direzioni;
	private String nome;
	private Map<String, Attrezzo> nome2attrezzi;
	private int numeroAttrezzi;

	private Map<String, Stanza> direzioni2stanze;
	private int numeroStanzeAdiacenti;
    
	
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
//        this.direzioni = new ArrayList<>();
//        this.stanzeAdiacenti = new ArrayList<>();
//        this.attrezzi = new ArrayList<>();
        //this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        //this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        //this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.direzioni2stanze = new HashMap<>();
		this.nome2attrezzi = new HashMap<>();
    
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
        /*Iterator<Stanza> iteratore2 = this.stanzeAdiacenti.iterator();
        Iterator<String> iteratore = this.direzioni.iterator();
        while(iteratore.hasNext() && iteratore2.hasNext()) {
        	if(direzione.equals(iteratore.next())) {
        		this.stanzeAdiacenti.add(stanza);
        		aggiornato = true;
        		//iteratore2.next() = stanza;
        	}
        }*/
        
//    	for(int i=0; i<this.direzioni.size(); i++)
//   					if (direzione.equals(this.direzioni.get(i))) {
//   						stanza = stanzeAdiacenti.get(i);
//   						//this.stanzeAdiacenti.add(stanza);
//   						aggiornato = true;
//    					}
//    	if(!aggiornato)
//    		if(stanzeAdiacenti.size() < NUMERO_MASSIMO_ATTREZZI) {
//    			direzioni.add(direzione);
//    			    stanzeAdiacenti.add(stanza);
//    			    aggiornato = true;
//    			    this.numeroStanzeAdiacenti++;
//    		}
        if (direzioni2stanze.containsKey(direzione)) {
			this.direzioni2stanze.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni2stanze.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
        
    }
    /*	for(int i=0; i<this.direzioni.length; i++)
        	if (direzione.equals(this.direzioni[i])) {
        		this.stanzeAdiacenti[i] = stanza;
        		aggiornato = true;
        	}
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni[numeroStanzeAdiacenti] = direzione;
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
    		    this.numeroStanzeAdiacenti++;
    		}
    		*/

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        Stanza stanza = null;
//		for(int i=0; i<stanzeAdiacenti.size(); i++)
//			if (direzione.equals(this.direzioni.get(i))) {
//				stanza = stanzeAdiacenti.get(i);
//			}
        if (this.direzioni2stanze.containsKey(direzione))
			stanza = this.direzioni2stanze.get(direzione);
        return stanza;
	}
	/*if (this.direzioni[i].equals(direzione))
        		stanza = this.stanzeAdiacenti[i];*/

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
//    public List<Attrezzo> getAttrezzi() {
//        return this.attrezzi;
//    }
    public Collection<Attrezzo> getAttrezzi() {
		return this.nome2attrezzi.values();
	}


    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
//    public boolean addAttrezzo(Attrezzo attrezzo) {
//        if (this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI ) {
//        	attrezzi.add(attrezzo);
//        	//this.attrezzi[numeroAttrezzi] = attrezzo;
//        	this.numeroAttrezzi++;
//        	return true;
//        }
//        else {
//        	return false;
//        }
//    }
    public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null && this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.nome2attrezzi.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}
	}

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
//    	StringBuilder risultato = new StringBuilder();
//    	risultato.append(this.nome);
//    	risultato.append("\nUscite: ");
//    	for (String direzione : this.direzioni)
//    		if (direzione!=null)
//    			risultato.append(" " + direzione);
//    	risultato.append("\nAttrezzi nella stanza: ");
//    	for (Attrezzo attrezzo : this.attrezzi){
//    		if (attrezzo != null) {
//    		    risultato.append(attrezzo.toString() + " ");
//    		}
//    	}
//    	return risultato.toString();
    	StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		risultato.append(this.getDirezioni().toString());
		risultato.append("\nAttrezzi nella stanza: ");
		risultato.append(this.getAttrezzi().toString());
		return risultato.toString();
    }

    
    
    
    
    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
//		boolean trovato;
//		trovato = false;
//		for(int i=0; i<attrezzi.size(); i++) {
//		//for (Attrezzo attrezzo : this.attrezzi) {
//			//vedere se è compatto o non compatto
//			//e a seconda di come è mettere un for normale o foreach
//			//if (attrezzo.getNome().equals(nomeAttrezzo))
//			if(nomeAttrezzo.equals(this.attrezzi.get(i).getNome()))
//			//if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
//				trovato = true;
//		}
//		return trovato;
		return this.nome2attrezzi.containsKey(nomeAttrezzo);

	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
//		for (Attrezzo attrezzo : this.attrezzi) {
//			if(attrezzo!=null)
//			if ( attrezzo.getNome().equals(nomeAttrezzo))
//				attrezzoCercato = attrezzo;
//			
//		}
		if (this.nome2attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.nome2attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		Attrezzo a = null;
//		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
//		if(attrezzo!=null) {
//		while(iteratore.hasNext()) {
//			a = iteratore.next();
//			if(a.getNome().equals(attrezzo.getNome()))
//				iteratore.remove();
//			  this.numeroAttrezzi--;
//		}
//		return true;
//	}
//		else 
//			return false;
		if(attrezzo!=null){
			this.nome2attrezzi.remove(attrezzo.getNome(), attrezzo);

			return true;
		}
		else
			return false;
	}

		/*if(attrezzo!=null){
			int i = 0;
			for(Attrezzo a : this.attrezzi) {
				if(a != null) {
					if(a.getNome().equals(attrezzo.getNome())) {
						this.attrezzi[i] = null;
						this.numeroAttrezzi--;
					}
				}
				i++;

			}
			return true;
		}
		else
			return false;
*/
	public Set<String> getDirezioni() {

		return direzioni2stanze.keySet();
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}

//	public List<String> getDirezioni() {
//		List<String> direzioni = new ArrayList<>(stanzeAdiacenti.size());
//	    for(int i=0; i<this.stanzeAdiacenti.size(); i++) {
//	    	direzioni.add(this.direzioni.get(i));
//	    }
//		return direzioni;
//		/*String[] direzioni = new String[this.numeroStanzeAdiacenti];
//	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
//	    	direzioni[i] = this.direzioni[i];
//	    return direzioni;*/
//    }
//
}