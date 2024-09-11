package mojprojekatJSF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="placanjenarudzbine")
public class PlacanjeNarudzbine 
{
	@TableGenerator(name="key_genNarudzbine", table="id_gen", pkColumnName="gen_name", valueColumnName="gen_val", allocationSize=1,
	pkColumnValue="key_genNarudzbine")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "key_genNarudzbine")
	@Column(name = "idRacuna",updatable=false,nullable=false)
	private int idRacuna;
	
	@Column(name="Cena")
	private int Cena;
	
	@Column(name="predjeniKm")
	private int predjeniKm;
	
	@Column(name="jmbgKorisnika")
	private int jmbgKorisnika;
	
	@Column(name="idNarudzbineKorisnika")
	private int idNarudzbineKorisnika;
	
	//konstruktor
	public PlacanjeNarudzbine(int cena, int brojPredjKM, int jbmbgKor, int idNarudzbiine)
	{
		this.setCena(cena);
		this.setpredjeniKm(brojPredjKM);
		this.setJmbgKorisnika(jbmbgKor);
		this.setIDNarudzbine(idNarudzbiine);
	}
	
	public PlacanjeNarudzbine() { }
	
	//setters
	public void setCena(int cena) {this.Cena=cena;}
	public void setpredjeniKm(int km) {this.predjeniKm=km; }
	public void setJmbgKorisnika(int jmbg) { this.jmbgKorisnika=jmbg;}
	public void setIDNarudzbine(int idNarudzbine) {this.idNarudzbineKorisnika=idNarudzbine; }
	
	//getters
	public int getCena() { return this.Cena; }
	public int getpredjeniKm() { return this.predjeniKm; }
	public int getJmbgKorisnikaPlacanje() { return this.jmbgKorisnika;}
	public int getIdNarudzbine() { return this.idNarudzbineKorisnika; }
	public int getIdRacuna() { return this.idRacuna; }
	public int getIdPlacanjeNarudzbine() {return this.idRacuna;}
	
	@Override
	public String toString() 
	{
		return this.getpredjeniKm()+ " " + this.getCena();
	}
}

