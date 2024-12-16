import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Pharmacie {
    List<Medicament> stock = new ArrayList<>();

    // Ajouter un médicament au stock
    public void ajouterMedicament(Medicament m) {
        stock.add(m);
        System.out.println(m.nom + " ajouté au stock.");
    }

    // Retirer un médicament du stock
    public void retirerMedicament(String nom) {
        if (stock.removeIf(m -> m.nom.equals(nom))) {
            System.out.println(nom + " retiré du stock.");
        } else {
            System.out.println(nom + " non trouvé dans le stock.");
        }
    }

    // Afficher l'état du stock
    public void afficherStock() {
        System.out.println("\n--- Stock actuel ---");
        for (Medicament m : stock) {
            System.out.println("Nom: " + m.nom + ", Prix: " + m.prix + " EUR, Sur ordonnance: " + (m.surOrdonnance ? "Oui" : "Non"));
        }
    }

    // Vérifier si une ordonnance est valide
    public boolean verifierOrdonnance(Medicament m, boolean ordonnanceValide) {
        return !m.surOrdonnance || ordonnanceValide;
    }

    // Traiter un achat
    public void traiterAchats(Scanner scanner) {
        Map<Medicament, Integer> achats = new HashMap<>();
        System.out.println("Ajoutez les médicaments au panier (tapez 'fin' pour terminer):");
        afficherStock();
        scanner.nextLine();

        while (true) {
            System.out.print("Nom du médicament: ");
            String nom = scanner.nextLine();
            if (nom.equalsIgnoreCase("fin")) break;

            Medicament med = stock.stream()
                    .filter(m -> m.nom.equalsIgnoreCase(nom))
                    .findFirst().orElse(null);

            if (med == null) {
                System.out.println("Médicament non trouvé.");
                continue;
            }

            System.out.print("Quantité: ");
            int quantite = scanner.nextInt();
            scanner.nextLine();

            achats.put(med, quantite);
        }

        System.out.print("L'ordonnance est-elle valide? (true/false): ");
        boolean ordonnanceValide = scanner.nextBoolean();
        scanner.nextLine();

        traiterAchat(new Client("ordinaire"), achats, ordonnanceValide);
    }

    // Traiter un achat
    private void traiterAchat(Client client, Map<Medicament, Integer> achats, boolean ordonnanceValide) {
        double total = 0;

        for (Map.Entry<Medicament, Integer> entry : achats.entrySet()) {
            Medicament m = entry.getKey();
            int quantite = entry.getValue();

            if (!verifierOrdonnance(m, ordonnanceValide)) {
                System.out.println("Erreur: " + m.nom + " nécessite une ordonnance valide.");
                return;
            }

            total += m.prix * quantite;
        }

        if (total > 100) {
            System.out.println("\nUne remise de 10% a été appliquée.");
            total *= 0.9;
        }

        afficherTicket(achats, total);
    }

    // Afficher un ticket de caisse
    private void afficherTicket(Map<Medicament, Integer> achats, double total) {
        System.out.println("\n--- Ticket de caisse ---");
        for (Map.Entry<Medicament, Integer> entry : achats.entrySet()) {
            Medicament m = entry.getKey();
            int quantite = entry.getValue();
            System.out.println(m.nom + " x" + quantite + " - " + (m.prix * quantite) + " EUR");
        }
        System.out.println("Total: " + total + " EUR");
    }

    // Gestion du stock
    public void gestionStock(Scanner scanner) {
        System.out.println("\n--- Gestion du stock ---");
        System.out.println("1. Afficher le stock");
        System.out.println("2. Ajouter un médicament");
        System.out.println("3. Retirer un médicament");
        System.out.print("Votre choix: ");
        int choixStock = scanner.nextInt();
        scanner.nextLine();

        if (choixStock == 1) {
            afficherStock();
        } else if (choixStock == 2) {
            System.out.print("Nom du médicament: ");
            String nom = scanner.nextLine();
            System.out.print("Prix du médicament: ");
            double prix = scanner.nextDouble();
            System.out.print("Sur ordonnance (true/false): ");
            boolean surOrdonnance = scanner.nextBoolean();
            ajouterMedicament(new Medicament(nom, prix, surOrdonnance));
        } else if (choixStock == 3) {
            System.out.print("Nom du médicament à retirer: ");
            String nom = scanner.next();
            retirerMedicament(nom);
        }
    }
}
