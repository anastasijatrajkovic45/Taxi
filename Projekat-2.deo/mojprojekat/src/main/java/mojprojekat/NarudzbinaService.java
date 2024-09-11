package mojprojekat;

public interface NarudzbinaService {

	//CRUD
	public void createNarudzbina(int id, String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice);
	public void createNarudzbina(String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice);
	public String getNarudzbina(int idNarudzbine);
	public void updateNarudzbina(int idNarudzbine, String krajnjaAdr, String vremePorudzbine, int brOsoba);
	public void deleteNarudzbina(int idNarudzbine);
		
	public Narudzbina getNarudzbinaObj(int idNarudzbine);
	public String prikazSvihNarudzbina();
	//ova metoda se koristi za testiranje, razlika u odnosu na orginalnu metodu je ta sto se vraca ID
	public int createNarudzbinaForTest(String pocAdr, String krajnjaAdr, String vremePorudzbine, int brOsoba, int idTaksiStanice);
}
