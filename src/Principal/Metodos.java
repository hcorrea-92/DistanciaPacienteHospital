package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class Metodos {

	// private static final String URIUtil = null;

	private Map<Long, Paciente> Pacientes = new TreeMap<>();

	private Map<Long, Hospital> Hospitais = new TreeMap<>();

	public void incluirPaciente(Long id, String nome, String cpf, String dtNascimento, String sexo, String dtEntrada) {
		Pacientes.put(id, new Paciente(id, nome, cpf, dtNascimento, sexo, dtEntrada));
		// find coordinates

		System.out.println(getCoordinates("Riachuelo, 609, Americana, Sao Paulo"));
		
		System.out.println(getCoordinates("R Dom Pedro II, 1101, Americana, Sao Paulo"));
		
		System.out.println(getCoordinates("Av Paulista, 1101, Sao Paulo, Sao Paulo"));

	}

	public void incluirHospital(Long id, String nome, String endereco, Long numLeitos, Long numLeitosDisponiveis) {
		Hospitais.put(id, new Hospital(id, nome, endereco, numLeitos, numLeitosDisponiveis));
	}

	
	public String getCoordinates(String c)

	{
		String lng = null;
		String lat = null;

		try {

			String thisLine;

			String adresa = c;

			adresa = adresa.replace(' ', '+');

			URL u = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + adresa + "&key="
					+ "AIzaSyC7iDyIpDFwqfgFsRFPIBs2WcSe4QN27lc");

			BufferedReader theHTML = new BufferedReader(new InputStreamReader(u.openStream()));

			FileWriter fstream = new FileWriter("url.xml");

			BufferedWriter out = new BufferedWriter(fstream);

			while ((thisLine = theHTML.readLine()) != null)

				out.write(thisLine);

			out.close();

		}

		catch (MalformedURLException e) {

			JOptionPane.showMessageDialog(null, this, "error=" + e.getMessage(), 0);

			return null;

		}

		catch (IOException e) {

			JOptionPane.showMessageDialog(null, this, "error=" + e.getMessage(), 0, null);

			return null;

		}

		catch (Exception e) {

			JOptionPane.showMessageDialog(null, this, "error=" + e.getMessage(), 0);

			return null;

		}
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		try {

			Object obj = jsonParser.parse(new FileReader("url.xml"));

			JSONObject jsonObject = new JSONObject(obj.toString());

			JSONObject results = jsonObject.getJSONArray("results").getJSONObject(0);
			
			JSONObject lngLat = results.getJSONObject("geometry").getJSONObject("location");
			
			lng = lngLat.optString("lng");
			lat = lngLat.optString("lat");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lat+ lng;
	}

}
