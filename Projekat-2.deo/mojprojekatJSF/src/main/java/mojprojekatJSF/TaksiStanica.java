package mojprojekatJSF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taksi_stanica")
public class TaksiStanica 
{
	//atributi
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="brojSlobodnihVozila")
	private int brojSlobodnihVozila;
	
	@Column(name="brojZauzetihVozila")
	private int brojZauzetihVozila;
	
	public TaksiStanica() { }
	
	//konstruktor
	public TaksiStanica(int id, String ime, int brSlobodnihVozila, int brVozilaNaZadaktu)
	{
		this.setid(id);
		this.setime(ime);
		this.setBrojSlobodnihVozila(brSlobodnihVozila);
		this.setbrojZauzetihVozila(brVozilaNaZadaktu);
	}
	
	//setters
	public void setid(int id) { this.id=id; }
	public void setime(String ime) { this.ime=ime; }
	public void setBrojSlobodnihVozila(int brSlobodnaVozila) { this.brojSlobodnihVozila=brSlobodnaVozila; }
	public void setbrojZauzetihVozila(int brVozilaNaZadatku) {this.brojZauzetihVozila=brVozilaNaZadatku; }
	
	//getters
	public int getid() { return this.id; }
	public String getime() { return this.ime; }
	public int getBrojSlobodnihVozila() { return this.brojSlobodnihVozila; }
	public int getbrojZauzetihVozila() {return this.brojZauzetihVozila; }
	
	@Override
	public String toString() 
	{
		return this.getime()+ " "+ this.getBrojSlobodnihVozila() + " " + this.getbrojZauzetihVozila();
	}
	

}
