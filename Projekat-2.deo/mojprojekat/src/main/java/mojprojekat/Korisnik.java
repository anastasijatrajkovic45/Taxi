package mojprojekat;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="korisnik")
public class Korisnik {
	
	// atributi
	@Id
	@Column(name = "jmbg")
	private double jmbg;

	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "godine")
	private int godine;
	
	@Column(name = "grad")
	private String grad;
	
	@Column(name = "drzava")
	private String drzava;
	
	// konstruktor
	public Korisnik(double jmbg, String ime, String prezime, int godine, String grad, String drzava)
	{
		this.setJmbg(jmbg);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setGodine(godine);
		this.setGrad(grad);
		this.setDrzava(drzava);
	}
	
	public Korisnik() { }
	
	// setters
	public void setJmbg(double jmbg) { this.jmbg = jmbg; }
	public void setIme(String ime) { this.ime = ime; }
	public void setPrezime(String prezime) { this.prezime = prezime; }
	public void setGodine(int godine) { this.godine = godine; }
	public void setGrad(String grad) { this.grad = grad; }
	public void setDrzava(String drzava) { this.drzava = drzava; }
	
	// getters
	public double getJmbg() { return this.jmbg; }
	public String getIme() { return this.ime; }
	public String getPrezime() { return this.prezime; }
	public int getGodine() { return this.godine; }
	public String getGrad() { return this.grad; }
	public String getDrzava() { return this.drzava; }
	
	@Override
	public String toString() { return this.getIme()+ " " + this.getPrezime() + " " + this.getGrad() + " " + this.getDrzava(); }
}
