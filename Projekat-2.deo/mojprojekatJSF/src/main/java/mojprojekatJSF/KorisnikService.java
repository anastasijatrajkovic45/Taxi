package mojprojekatJSF;

import java.util.List;

public interface KorisnikService {
	//CRUD
	public void createKorisnik(double jmbg, String ime, String prezime, int godine, String grad, String drzava);
	public String getKorisnik(double jmbg);
	public void updateKorisnik(double jmbg, String grad, String drzava);
	public void deleteKorisnik(double jmbg);
	
	public Korisnik getKorisnikObj(double jmbg);
	public List<Korisnik> prikazSvihKorisnika();
}