import java.util.Scanner;

public class yogunlukvehata {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("   FİZİK LAB: YOĞUNLUK VE HATA HESAPLAMA KODU    ");
        System.out.println("==================================================");
        System.out.println("1 - Dikdörtgenler Prizması");
        System.out.println("2 - Silindir");
        System.out.print("Cisim türünü seçiniz (1 veya 2): ");
        int secim = scanner.nextInt();

        System.out.print("\nKütle m (gram): ");
        double m = scanner.nextDouble();
        
        System.out.print("Kütle Mutlak Hatası dm (gram) [Örn: 0.01]: ");
        double dm = scanner.nextDouble();

        if (secim == 1) {
            // DİKDÖRTGENLER PRİZMASI
            System.out.print("Kenar a (cm): ");
            double a = scanner.nextDouble();
            System.out.print("a Mutlak Hatası da (cm) [Örn: 0.005]: ");
            double da = scanner.nextDouble();

            System.out.print("Kenar b (cm): ");
            double b = scanner.nextDouble();
            System.out.print("b Mutlak Hatası db (cm): ");
            double db = scanner.nextDouble();

            System.out.print("Kenar c (cm): ");
            double c = scanner.nextDouble();
            System.out.print("c Mutlak Hatası dc (cm): ");
            double dc = scanner.nextDouble();

            double V = a * b * c;
            double rho = m / V;
            double bagilHata = (dm / m) + (da / a) + (db / b) + (dc / c);
            double mutlakHata = rho * bagilHata;

            sonucYazdir(V, rho, bagilHata, mutlakHata);

        } else if (secim == 2) {
            // SİLİNDİR
            System.out.print("Yarıçap r (cm): ");
            double r = scanner.nextDouble();
            System.out.print("r Mutlak Hatası dr (cm) [Örn: 0.005]: ");
            double dr = scanner.nextDouble();

            System.out.print("Yükseklik h (cm): ");
            double h = scanner.nextDouble();
            System.out.print("h Mutlak Hatası dh (cm): ");
            double dh = scanner.nextDouble();

            double V = Math.PI * Math.pow(r, 2) * h;
            double rho = m / V;
            double bagilHata = (dm / m) + (2 * (dr / r)) + (dh / h);
            double mutlakHata = rho * bagilHata;

            sonucYazdir(V, rho, bagilHata, mutlakHata);

        } else {
            System.out.println("Geçersiz seçim yaptınız.");
        }

        scanner.close();
    }

    private static void sonucYazdir(double V, double rho, double bagilHata, double mutlakHata) {
        System.out.println("\n----------------- HESAPLAMA SONUÇLARI -----------------");
        System.out.printf("Hacim (V)                  : %.4f cm³\n", V);
        System.out.printf("Yoğunluk (ρ)               : %.4f g/cm³\n", rho);
        System.out.printf("Bağıl Hata (Δρ/ρ)          : %.6f\n", bagilHata);
        System.out.printf("Yüzde Bağıl Hata           : %%%.2f\n", bagilHata * 100);
        System.out.printf("Yoğunluk Mutlak Hatası (Δρ): ±%.6f g/cm³\n", mutlakHata);
        System.out.println("-------------------------------------------------------");
        System.out.printf("Rapor Gösterimi            : ρ = (%.4f ± %.4f) g/cm³\n", rho, mutlakHata);
        System.out.println("-------------------------------------------------------");
    }
}
