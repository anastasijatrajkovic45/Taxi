package mojprojekat;

import javax.ejb.Remote;

public interface TaksiStanicaService {
	//CRUD
	public void createTaksiStanica(int id, String ime, int brojSlobodnihVozila, int brojZauzetihVozila, int cenaPoKilometru);
	public String getTaksiStanica(int id);
	public void updateTaksiStanica(int id, String ime, int brojSlobodnihVozila, int brojZauzetihVozila, int cenaPoKilometru);
	public void deleteTaksiStanica(int id);
	
	public TaksiStanica getTaksiStanicaObj(int id);
	public String prikazTaksiStanica();
	public void updateTaksiStanicaSlobodnaVozila(int id); //vozilo je zavrsilo zadatak
	public void updateTaksiStanicaVozilaNaZadatku(int id); //vozilo krece na zadatak
}