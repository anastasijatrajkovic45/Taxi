package mojprojekat;

public interface PlacanjeNarudzbineService {
	//CRUD
	public void createPlacanjeNarudzbine(int cena, int brojPredjKM, int jmbgKor, int idNarudzbine);
	public String getPlacanjeNarudzbine(int idRacuna);
	public void updatePlacanjeNarudzbine(int idRacuna, int brojPredjenihKM);
	public void deletePlacanjeNarudzbine(int idRacuna);
	
	public PlacanjeNarudzbine getPlacanjeRacunaObj(int idRacuna);
	public String prikazSvihPlacanjaNarudzbine();
	public int getCenuZaUslugu(int brPredjenihKM);
	public int createPlacanjeNarudzbineZaTest(int cena, int brojPredjKM, int jmbgKor, int idNarudzbine);
}
