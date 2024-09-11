package mojprojekatJSF;

import java.util.List;

public interface NarudzbinaService 
{
	//CRUD
	public void createNarudzbina(String pocAdr, String krajnjaAdr, String vremePorudzbine, String brOsoba, String idTaksiStanice);
	public String getNarudzbina(String idNarudzbine);
	public void updateNarudzbina(String idNarudzbine, String krajnjaAdr, String vremePorudzbine, String brOsoba);
	public void deleteNarudzbina(String idNarudzbine);
	
	public Narudzbina getNarudzbinaObj(String idNarudzbina);
	public List<Narudzbina> prikazSvihNarudzbina();

}