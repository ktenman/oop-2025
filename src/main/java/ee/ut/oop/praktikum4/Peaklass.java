package ee.ut.oop.praktikum4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Peaklass {
	public static void main(String[] args) {
		Tanstupaar tanstupaar = new Tanstupaar(
				"Nils Jaagup Kask",
				2001,
				"Ann-Marleen Tamm",
				1995
		);
		
		System.out.println(tanstupaar.pereNimed());
		LocalDate now = LocalDate.now();
		System.out.println(tanstupaar.vanemaPartneriVanus(now.getYear()));
		System.out.println(tanstupaar);
		System.out.println(tanstupaar.toString());
		
		tanstupaar = new Tanstupaar(
				"Indrek Kala",
				1902,
				"Kaja Kallas",
				2014
		);
		
		System.out.println(tanstupaar.vanemaPartneriVanus(now.getYear()));
		System.out.println(tanstupaar);
		
		System.out.println(sugu(3));
		System.out.println(sugu(4));
		
		System.out.println(sugu2(3));
		System.out.println(sugu2(4));
		
		File fail = new File("taara.txt");
		
		Map<String, List<Taara>> tagastajadJaTaarad = new HashMap<>();
		try (Scanner scanner = new Scanner(fail, StandardCharsets.UTF_8)) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] tykid = line.split("; ");
				
				Taara taara = new Taara(tykid[0], tykid[1].charAt(0));
				String tagastaja = tykid[2];
				if (!tagastajadJaTaarad.containsKey(tagastaja)) {
					tagastajadJaTaarad.put(tagastaja, new ArrayList<>());
				}
				tagastajadJaTaarad.get(tagastaja).add(taara);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static String sugu(int idKoodiAlgus) {
		return idKoodiAlgus % 2 == 0 ? "naine" : "mees";
	}
	
	public static String sugu2(int idKoodiAlgus) {
		Map<Integer, String> map = Map.of(
				1, "mees",
				2, "naine",
				3, "mees",
				4, "naine",
				5, "mees",
				6, "naine"
		);
		return map.get(idKoodiAlgus);
	}
}
