package mojprojekatJSF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TaksiStanicaController 
{
	private String ime;
	private String id;
	private String brojSlobodnihVozila;
	private String brojZauzetihVozila;
	
	@EJB
	private TaksiStanicaService service;
	
	//setter
	public void setime(String ime) { this.ime=ime; }
	public void setid(String id) { this.id=id; }
	public void setBrojSlobodnihVozila(String brojSlobodnihVozila){ this.brojSlobodnihVozila=brojSlobodnihVozila; }
	public void setbrojZauzetihVozila(String brojZauzetihVozila) { this.brojZauzetihVozila=brojZauzetihVozila; }
			
	//getter
	public String getime() {return this.ime; }
	public String getid() {return this.id; }
	public String getBrojSlobodnihVozila() { return this.brojSlobodnihVozila;}
	public String getbrojZauzetihVozila() { return this.brojZauzetihVozila; }
	
	public void addTaksiStanica(String id, String ime, String brojSlobodnihVozila, String brojZauzetihVozila)
	{
		this.service.createTaksiStanica(id, ime, brojSlobodnihVozila, brojZauzetihVozila);
	}
	
	public void deleteTaksiStanica(String id)
	{
		this.service.deleteTaksiStanica(id);
	}
	
	public void updateTaksiStanica(String id, String ime, String brojSlobodnihVozila, String brojZauzetihVozila)
	{
		service.updateTaksiStanica(id, ime, brojSlobodnihVozila, brojZauzetihVozila);
	}
}

