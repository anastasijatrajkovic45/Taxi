package mojprojekatJSF;

import java.io.IOException;
import java.util.List;

public interface PlacanjeNarudzbineService 
{
	//CRUD
		public void createPlacanjeNarudzbine(String cena, String brojPredjKM, String jmbgKor, String idNarudzbine);
		public String getPlacanjeNarudzbine(String idRacuna);
		public void updatePlacanjeNarudzbine(String idRacuna, String predjeniKm);
		public void deletePlacanjeNarudzbine(String idRacuna);
		
		public PlacanjeNarudzbine getPlacanjeRacunaObj(String idRacuna);
		public List<PlacanjeNarudzbine> prikazSvihPlacanjaNarudzbine();
		public int getCenuZaUslugu(String brPredjenihKM);
		//public int createPlacanjeNarudzbineZaTest(String cena, String brojPredjKM, String jmbgKor, String idNarudzbine);
		
		public void sendGET(String ckid, String ckm) throws IOException;

}
