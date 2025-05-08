package ee.ut.oop.praktikum11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ArvutiParandus {

    private static Set<String> LUBATUD_TÖÖ_TÜÜBID = Set.of("kiirtöö", "tavatöö");
    private List<Arvuti> ootelTööd = new ArrayList<>();
    private List<TehtudTöö> tehtudTööd = new ArrayList<>();
    private Map<String, Double> parandajateTunnitasud = new HashMap<>();

    public ArvutiParandus() throws IOException {
        loeOotelTööd("ootel_arvutid.txt");
        loeParandajetTunnitasud();

    }

    private static Arvuti loeArvuti(String rida) throws FormaadiErind {
        String[] osad = rida.split("@");
        LocalDateTime registreerimiseAeg;
        if (osad.length == 2) {
            registreerimiseAeg = LocalDateTime.parse(osad[1]);
        } else if (osad.length == 1) {
            registreerimiseAeg = LocalDateTime.now();
        } else {
            throw new FormaadiErind("@ oli puudu");
        }

        String[] väljad = osad[0].split(";");
        if (väljad.length < 2 || väljad.length > 3) {
            throw new FormaadiErind("Väljade arv on vale!");
        }

        String tootja = väljad[0];
        String tööTüüp = väljad[1];
        if (!LUBATUD_TÖÖ_TÜÜBID.contains(tööTüüp)) {
            throw new FormaadiErind("Töö tüüp ei ole 'tavatöö' ega 'kiirtöö'");
        }

        boolean kiirtöö = tööTüüp.equals("kiirtöö");

        if (väljad.length == 3) {
            if (!väljad[2].equals("monitoriga")) {
                throw new FormaadiErind("Kolmanda välja väärtus peab olema 'monitoriga'");
            }
            return new VäliseMonitorigaArvuti(tootja, kiirtöö, registreerimiseAeg);
        } else {
            return new Arvuti(tootja, kiirtöö, registreerimiseAeg);
        }

    }

    public static void main(String[] args) throws IOException {
        ArvutiParandus arvutiParandus = new ArvutiParandus();
        System.out.println(arvutiParandus);

        Scanner scanner = new Scanner(System.in);
        String valik;

        do {
            System.out.println("Valige tegevus: (P)aranda, (R)egistreeri uus töö, (L)õpeta");
            valik = scanner.nextLine().toUpperCase();

            switch (valik) {
                case "P" -> arvutiParandus.parandaArvuti(scanner);
                case "R" -> arvutiParandus.registreeriTöö(scanner);
                case "L" -> {
                    arvutiParandus.salvestaOotelTööd();
                    arvutiParandus.salvestaTehtudTööd();
                }
                default -> System.out.println("Vigane valik. Palun proovi uuesti");
            }
        } while (!valik.equals("L"));
        scanner.close();

        arvutiParandus.kuvatöödeKokkuvõte();
    }

    private void loeParandajetTunnitasud() {
        try (DataInputStream sisendVoog =
                     new DataInputStream(new FileInputStream("tunnitasud.dat"))) {
            int parandajateArv = sisendVoog.readInt();
            for (int i = 0; i < parandajateArv; i++) {
                String parandajaNimi = sisendVoog.readUTF();
                double tunnitasu = sisendVoog.readDouble();
                parandajateTunnitasud.put(parandajaNimi, tunnitasu);
            }
        } catch (IOException e) {
            System.out.println("Tunnitasude faili lugemisel tekkis viga: " + e.getMessage());
        }
    }

    private void loeOotelTööd(String sisend) throws IOException {
        boolean onVeebist = sisend.startsWith("https://") || sisend.startsWith("http://");
        InputStream sisendVoog = onVeebist ? URI.create(sisend).toURL().openStream() : new FileInputStream(sisend);
        try (BufferedReader lugeja = new BufferedReader(new InputStreamReader(sisendVoog, UTF_8))) {
            String rida;
            while ((rida = lugeja.readLine()) != null) {
                try {
                    Arvuti arvuti = loeArvuti(rida);
                    this.ootelTööd.add(arvuti);
                } catch (FormaadiErind e) {
                    System.out.println("Vigane rida: " + rida);
                    System.out.println("Viga: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ArvutiParandus{" +
                "parandajateTunnitasud=" + parandajateTunnitasud +
                ", ootelTööd=" + ootelTööd +
                '}';
    }

    private void kuvatöödeKokkuvõte() {
        double teenitudRaha = tehtudTööd.stream().mapToDouble(t -> t.getHind()).sum();
        System.out.printf("Teenitud raha: %.2f €%n", teenitudRaha);

        Map<String, Long> parandatudTootjateKaupa = new HashMap<>();
        tehtudTööd.forEach(tehtudTöö -> {
            String tootja = tehtudTöö.getArvuti().getTootja();
            parandatudTootjateKaupa.put(tootja, parandatudTootjateKaupa.getOrDefault(tootja, 0L) + 1);
        });
        System.out.println("Parandatud arvutite arv tootjate kaupa: " + parandatudTootjateKaupa);

        System.out.println("Ootel arvutite arv: " + ootelTööd.size());
    }

    private void salvestaTehtudTööd() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("tehtud.dat"))) {
            dos.writeInt(tehtudTööd.size());
            for (TehtudTöö töö : tehtudTööd) {
                dos.writeUTF(töö.getArvuti().getTootja());
                dos.writeUTF(töö.getArvuti().getRegistreerimisAeg().toString());
                dos.writeDouble(töö.getHind());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvestaOotelTööd() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("ootel_arvutid.txt"), UTF_8)) {
            for (Arvuti arvuti : ootelTööd) {
                writer.write(arvuti.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void registreeriTöö(Scanner scanner) {
        while (true) {
            System.out.print("Sisestage töö kirjeldus: ");
            String rida = scanner.nextLine();
            try {
                Arvuti arvuti = loeArvuti(rida);
                this.ootelTööd.add(arvuti);
                System.out.println("Töö edukalt registreeritud.");
                break;
            } catch (FormaadiErind e) {
                System.out.println("Vigane kirjeldus! " + e.getMessage());
            }
        }
    }

    private void parandaArvuti(Scanner scanner) {
        if (ootelTööd.isEmpty()) {
            System.out.println("Ootel töid ei ole");
            return;
        }

        Arvuti arvuti = ootelTööd.removeFirst();

        System.out.println("Parandamisel läheb: " + arvuti);

        System.out.println("Sisesta tööle kulunud aeg (minutites): ");
        int kulunudAeg = scanner.nextInt();

        System.out.println("Sisesta parandaja nimi: ");
        String parandajaNimi = scanner.nextLine();

        double tunnitasu = parandajateTunnitasud.getOrDefault(parandajaNimi, 0.0);
        double baasHind = tunnitasu * kulunudAeg / 60.0;
        double arveSumma = arvuti.arvutaArveSumma(baasHind);

        System.out.println("Arvuti parandamine lõpetatud. Arve summa: " + arveSumma);
        tehtudTööd.add(new TehtudTöö(arvuti, arveSumma));
    }
}