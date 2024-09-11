package mojprojekatJSF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class KorisnikController 
{
	private double jmbg;
	private String ime;
	private String prezime;
	private int godine;
	private String grad;
	private String drzava;
	
	@EJB
	private KorisnikService service;
	
	//setter
	public void setJmbg(double jmbg) { this.jmbg=jmbg; }
	public void setIme(String ime) { this.ime=ime; }
	public void setPrezime(String prezime) {this.prezime=prezime; }
	public void setGodine(int godine) {this.godine=godine; }
	public void setGrad(String grad) { this.grad=grad; }
	public void setDrzava(String drzava) { this.drzava=drzava; }
	
	//getter
	public double getJmbg() { return this.jmbg; } 
	public String getIme() {return this.ime;}
	public String getPrezime() {return this.prezime;}
	public int getGodine() {return this.godine; }
	public String getGrad() {return this.grad; }
	public String getDrzava() { return this.drzava; }
	
	public void addKorisnik(double jmbg, String ime, String prezime, int godine, String grad, String drzava)
	{
		this.service.createKorisnik(jmbg, ime, prezime, godine, grad, drzava);
	}
	
	public void deleteKorisnik(double jmbg)
	{
		this.service.deleteKorisnik(jmbg);
	}
	
	public void updateKorisnik(double jmbg, String grad, String drzava)
	{
		this.service.updateKorisnik(jmbg, grad, drzava);
	}
	
	public List<Korisnik> allKorisnik()
	{
		List<Korisnik> users=this.service.prikazSvihKorisnika();
		return users;
	}
}
