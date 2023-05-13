package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JFormattedTextField.AbstractFormatter;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	//private Attrezzo[] attrezzi;
	private Map<String, Attrezzo> nome2attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		//this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.nome2attrezzi = new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.pesoAttuale = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		/*if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo; 
		return true;*/
//		this.numeroAttrezzi++;
//		return this.attrezzi.add(attrezzo);
		this.nome2attrezzi.put(attrezzo.getNome(),attrezzo);
		this.numeroAttrezzi++;
		this.pesoAttuale += attrezzo.getPeso();
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		/*for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];*/
//		if(nomeAttrezzo!=null) {
//		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
//		while (iteratore.hasNext()) {
//			a = iteratore.next();
//			if (a.getNome().equals(nomeAttrezzo)) {
//				return a;
//			}
//		}
//		}
//		return null;
		if(nomeAttrezzo != null && this.nome2attrezzi.containsKey(nomeAttrezzo))
			a = this.nome2attrezzi.get(nomeAttrezzo);
		return a;
	}

	public int getPeso() {
		return this.pesoAttuale;
//		int peso = 0;
//		Attrezzo a = null;
//		/*for (int i= 0; i<this.numeroAttrezzi; i++)
//			peso += this.attrezzi[i].getPeso();*/
//		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
//		while(iteratore.hasNext()) {
//			a = iteratore.next();
//			peso += a.getPeso();
//		}
//		
//		return peso;
		
	}
	
	public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo!=null){
			a = nome2attrezzi.remove(nomeAttrezzo);
		}
		return a;
//		Iterator<Attrezzo> iteratore =
//				this.attrezzi.iterator();
//		while (iteratore.hasNext()) {
//			a = iteratore.next();
//			if (a.getNome().equals(nomeAttrezzo)) {
//
//				iteratore.remove();
//
//				return a;
//			}
//		}
//
//		return null;
	}
			/*if(nomeAttrezzo!=null) {
			int i = 0;
			for(Attrezzo at : this.attrezzi) {
				if(at!=null) {
				if(at.getNome().equals(nomeAttrezzo)) {
					a = at;
					this.attrezzi[i] = null;
					this.numeroAttrezzi--;
					}	
				}
				i++;
			}
			
		}*/

	public String toString() {
		StringBuilder s = new StringBuilder();
		//Attrezzo a = null;
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
//			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
//			/*for (int i= 0; i<this.numeroAttrezzi; i++)
//				s.append(attrezzi[i].toString()+" ");*/
//			Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
//			while (iteratore.hasNext()) {
//				a = iteratore.next();
//				s.append(a.toString()+" ");
//		}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		s.addAll(this.nome2attrezzi.values());
		return s;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
//		 List <Attrezzo> risultato = new ArrayList<Attrezzo>();
//		 getContenutoOrdinatoPerPeso comparator = new getContenutoOrdinatoPerPeso();
//		risultato.addAll(this.attrezzi);
//		Collections.sort(risultato);
//		return risultato;
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.nome2attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezziPerPeso());
		return l;
		
	}
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
//		final Sorted<Attrezzo> risultato = new TreeSet<Attrezzo>(new Comparator());
//		risultato.addAll(this.attrezzi.values());
//		return risultato;
		return new TreeSet<Attrezzo>(this.nome2attrezzi.values());
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> a2p = new TreeMap<>();
		//il for e' stato inserito successivamente all'esercizio 2 (nell'esercizio 3)
		for(Attrezzo a : this.nome2attrezzi.values()){
			if(a2p.containsKey(a.getPeso())) {
				a2p.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo>  s =new HashSet<Attrezzo>();
				s.add(a);
				a2p.put(a.getPeso(), s);
			}
		}
		return a2p;
	}

}