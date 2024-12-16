import java.util.Scanner;

public class GestionPharmacie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pharmacie pharmacie = new Pharmacie();

        // Médicaments de test
        Medicament med1 = new Medicament("Paracetamol", 5, false);
        Medicament med2 = new Medicament("Antibiotique", 20, true);
        Medicament med3 = new Medicament("Vitamine C", 10, false);

        pharmacie.ajouterMedicament(med1);
        pharmacie.ajouterMedicament(med2);
        pharmacie.ajouterMedicament(med3);

        boolean continuer = true;

        while (continuer) {
            System.out.println("\n--- Menu Gestion Pharmacie ---");
            System.out.println("1. Gestion du stock");
            System.out.println("2. Validation d'ordonnance");
            System.out.println("3. Traitement des achats");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    pharmacie.gestionStock(scanner);
                    break;

                case 2:
                    System.out.println("\n--- Validation d'ordonnance ---");
                    System.out.print("Entrez 'true' si l'ordonnance est valide, sinon 'false': ");
                    boolean ordonnanceValide = scanner.nextBoolean();
                    System.out.println("Ordonnance valide: " + ordonnanceValide);
                    break;

                case 3:
                    pharmacie.traiterAchats(scanner);
                    break;

                case 4:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide.");
            }
        }

        scanner.close();
    }
}
