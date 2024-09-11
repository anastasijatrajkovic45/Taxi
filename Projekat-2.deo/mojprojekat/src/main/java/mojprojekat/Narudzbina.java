package mojprojekat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="narudzbina")

public class Narudzbina {

	@TableGenerator(name="key_gen", table="id_gen", pkColumnName="gen_name", valueColumnName="gen_val", allocationSize=1,
	pkColumnValue="key_gen")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "key_gen")
	
	// atributi
	@Column(name = "idNarudzbine",updatable=false,nullable=false)
	private int idNarudzbine;
	
	@Column(name="pocetnaAdresa")
	private String pocetnaAdesa;
	
	@Column(name="krajnjaAdresa")
	private String krajnjaAdresa;
	
	@Column(name="vremePorudzbine")
	private String vremePorudzbine;  //PITANJE: obratiti paznju da sam u bazi stavio DataTime tip
	
	@Column(name="brojOsoba")
	private int brojOsoba;
	
	@Column(name="idTaksiStanice") //FK na taksi stanicu
	private int idTaksiStanice;
	
	// konstruktor
	public Narudzbina(int idNarudzbine_, String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice)
	{
		this.idNarudzbine = idNarudzbine_;
		this.setPocetnaAdresa(pocAdr);
		this.setKrajnjaAdresa(krajnjaAdr);
		this.setvremePorudzbine(vremePorudzbine);
		this.setBrojOsoba(brOsoba);
		this.setIdTaksiStanice(idTaksiStanice);
	}
	
	public Narudzbina(String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice)
	{
		this.setPocetnaAdresa(pocAdr);
		this.setKrajnjaAdresa(krajnjaAdr);
		this.setvremePorudzbine(vremePorudzbine);
		this.setBrojOsoba(brOsoba);
		this.setIdTaksiStanice(idTaksiStanice);
	}
	

	
	public Narudzbina() { }
	
	// setters
	public void setIdNarudzbine(int id) { this.idNarudzbine = id; }
	public void setPocetnaAdresa(String pocAdr) { this.pocetnaAdesa = pocAdr; }
	public void setKrajnjaAdresa(String krajnjaAdr) { this.krajnjaAdresa = krajnjaAdr; }
	public void setvremePorudzbine(String vremePorudzbine) { this.vremePorudzbine = vremePorudzbine; }
	public void setBrojOsoba(int brOsoba) { this.brojOsoba = brOsoba; }
	public void setIdTaksiStanice(int pib) { this.idTaksiStanice = pib; }	
	
	// getters
	public int getIdNarudzbine() { return idNarudzbine; }
	public String getPocetnaAdresa() {return this.pocetnaAdesa; }
	public String getKrajnjaAdresa() { return this.krajnjaAdresa; }
	public String getVremePorudzbine() {return this.vremePorudzbine; }
	public int getBrojOsoba() { return this.brojOsoba; }
	public int getIdTaksiStanice() { return this.idTaksiStanice; } //mozda ovo ne bi trebalo da se vraca

	@Override
	public String toString() 
	{
		return this.getPocetnaAdresa() + " " + this.getKrajnjaAdresa() + " " + this.getBrojOsoba() + " " + this.getIdTaksiStanice();
	}
}