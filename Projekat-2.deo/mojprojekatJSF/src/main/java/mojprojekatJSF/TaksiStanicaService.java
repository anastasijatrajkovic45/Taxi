package mojprojekatJSF;

import java.util.List;

public interface TaksiStanicaService 
{
	//CRUD
		public void createTaksiStanica(String id, String ime, String brSlobodnihVozila, String brVozilaNaZadaktu);
		public String getTaksiStanica(String id);
		public void updateTaksiStanica(String id, String ime, String brSlobodnihVozila, String brVozilaNaZadaktu);
		public void deleteTaksiStanica(String id);
		
		public TaksiStanica getTaksiStanicaObj(String id);
		public List<TaksiStanica> prikazTaksiStanica();
		public void updateTaksiStanicaSlobodnaVozila(String id); //vozilo je zavrsilo zadatak
		public void updateTaksiStanicaVozilaNaZadatku(String id); //vozilo krece na zadatak
		
}