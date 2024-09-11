package mojprojekat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taksi_stanica")

public class TaksiStanica {
	
	// atributi
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="brojSlobodnihVozila")
	private int brojSlobodnihVozila;
	
	@Column(name="brojZauzetihVozila")
	private int brojZauzetihVozila;
	
	@Column(name="cenaPoKilometru")
	private int cenaPoKilometru;
	
	// konstruktor
	public TaksiStanica(int id, String ime, int brojSlobodnihVozila, int brojZauzetihVozila, int cenaPoKilometru)
	{
		this.setId(id);
		this.setIme(ime);
		this.setBrojSlobodnihVozila(brojSlobodnihVozila);
		this.setBrojZauzetihVozila(brojZauzetihVozila);
		this.setCenaPoKilometru(cenaPoKilometru);
	}
	
	public TaksiStanica() { }
	
	// setters
	public void setId(int id) { this.id = id; }
	public void setIme(String ime) { this.ime = ime; }
	public void setBrojSlobodnihVozila(int brojSlobodnihVozila) { this.brojSlobodnihVozila = brojSlobodnihVozila; }
	public void setBrojZauzetihVozila(int brojZauzetihVozila) { this.brojZauzetihVozila = brojZauzetihVozila; }
	public void setCenaPoKilometru(int cenaPoKilometru) { this.cenaPoKilometru = cenaPoKilometru; }
	
	// getters
	public int getId() { return this.id; }
	public String getIme() { return this.ime; }
	public int getBrojSlobodnihVozila() { return this.brojSlobodnihVozila; }
	public int getBrojZauzetihVozila() {return this.brojZauzetihVozila; }
	public int getCenaPoKilometru() {return this.cenaPoKilometru; }
	
	@Override
	public String toString() 
	{
		return this.getIme()+ " " + this.getBrojSlobodnihVozila() + " " + this.getBrojZauzetihVozila();
	}
}
