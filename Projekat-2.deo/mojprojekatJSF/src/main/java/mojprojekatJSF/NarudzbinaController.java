package mojprojekatJSF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class NarudzbinaController 
{
	private String pocetnaAdesa;
	private String krajnjaAdresa;
	private String vremePorudzbine;
	private String brojOsoba;
	private String idTaksiStanice;
	private String idNarudzbine;
	
	@EJB
	private NarudzbinaService service;
	
	//setter
	public void setPocetnaAdesa(String pocetnaAdesa) { this.pocetnaAdesa=pocetnaAdesa;}
	public void setKrajnjaAdresa(String krajnjaAdresa) { this.krajnjaAdresa=krajnjaAdresa; }
	public void setVremePorudzbine(String vremePorudzbine) {this.vremePorudzbine=vremePorudzbine; }
	public void setBrojOsoba(String brojOsoba) { this.brojOsoba=brojOsoba;}
	public void setidTaksiStanice(String idTaksiStanice) {this.idTaksiStanice=idTaksiStanice;}
	public void setIdNarudzbine(String idNarudzbine) { this.idNarudzbine=idNarudzbine; } 
	
			
	//getter
	public String getPocetnaAdesa() {return this.pocetnaAdesa; };
	public String getKrajnjaAdresa() { return this.krajnjaAdresa; };
	public String getVremePorudzbine() { return this.vremePorudzbine; }
	public String getBrojOsoba() { return this.brojOsoba; }
	public String getidTaksiStanice() { return this.idTaksiStanice; }
	public String getIdNarudzbine() { return this.idNarudzbine;}
	
	public void addNarudzbina(String pocetnaAdesa, String krajnjaAdresa, String vremePorudzbine, String brojOsoba, String idTaksiStanice)
	{
		this.service.createNarudzbina(pocetnaAdesa, krajnjaAdresa, vremePorudzbine, brojOsoba, idTaksiStanice);
	}
	
	public void deleteNarudzbina(String idNarudzbine)
	{
		this.service.deleteNarudzbina(idNarudzbine);
	}
	
	public void updateNarudzbina(String jmbg, String grad, String drzava)
	{
		this.service.updateNarudzbina(idNarudzbine, krajnjaAdresa, vremePorudzbine, brojOsoba);
	}
	

	public List<Narudzbina> allNarudzbina()
	{
		List<Narudzbina> orders=this.service.prikazSvihNarudzbina();
		return orders;
	}
	

	
}
