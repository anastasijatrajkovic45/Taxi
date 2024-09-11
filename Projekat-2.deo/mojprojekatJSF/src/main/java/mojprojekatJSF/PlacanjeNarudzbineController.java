package mojprojekatJSF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class PlacanjeNarudzbineController 
{
	private String idRacuna;
	private String Cena;
	private String predjeniKm;
	private String jmbgKorisnika;
	private String idNarudzbineKorisnika;
	
	@EJB
	private PlacanjeNarudzbineService service;
	
	//setter
	public void setIdRacuna(String idRacuna) { this.idRacuna=idRacuna; }
	public void setCena(String Cena) { this.Cena=Cena; }
	public void setpredjeniKm(String predjeniKm) { this.predjeniKm=predjeniKm; }
	public void setJmbgKorisnika(String jmbgKorisnika) { this.jmbgKorisnika=jmbgKorisnika; }
	public void setIdNarudzbineKorisnika(String idNarudzbineKorisnika) { this.idNarudzbineKorisnika=idNarudzbineKorisnika; }
	
	//getter
	public String getIdRacuna() {return this.idRacuna; }
	public String getCena() {return this.Cena; }
	public String getpredjeniKm() {return this.predjeniKm; }
	public String getJmbgKorisnika() { return this.jmbgKorisnika; }
	public String getIdNarudzbineKorisnika() { return this.idNarudzbineKorisnika; }
	
	public void addPlacanjeNarudzbine(String jmbgKorisnika, String idNarudzbineKorisnika)
	{
		//int brojKilometra= Integer.parseInt(predjeniKm);
		/*int cena=service.getCenuZaUslugu(predjeniKm);
		String cenaString=String.valueOf(cena);
		this.setCena(cenaString);*/
		service.createPlacanjeNarudzbine("0", "0" ,jmbgKorisnika, idNarudzbineKorisnika);
	}
	
	public void deleteTransakcija(String idRacuna)
	{
		/*PlacanjeNarudzbine obj = service.getPlacanjeRacunaObj(idRacuna);
		int jmbgKorisnika=obj.getJmbgKorisnikaPlacanje();
		int idNarudzbine= obj.getIdNarudzbine();
		
		String jmbgKorisnikaString=Integer.toString(jmbgKorisnika);
		String idNarudzbineString= Integer.toString(idNarudzbine);
		
		NarudzbinaService serviceNarudzbina=new NarudzbinaServiceImpl();
		Narudzbina objNarudzbina= serviceNarudzbina.getNarudzbinaObj(idNarudzbineString);
		
		KorisnikService serviceKorisnik=new KorisnikServiceImpl();
		
		int pibTaksiStanice= objNarudzbina.getPibTaksiStanice();
		String pibTaksiStaniceString =Integer.toString(pibTaksiStanice);
		
		this.service.deletePlacanjeNarudzbine(idRacuna);
		serviceKorisnik.deleteKorisnik(jmbgKorisnikaString);
		serviceNarudzbina.deleteNarudzbina(idNarudzbineString);*/
		
		
		this.service.deletePlacanjeNarudzbine(idRacuna);
	}
	
	public void sendGET(String idRacuna, String predjeniKm)
    {
    	try {
			service.sendGET(idRacuna, predjeniKm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
