# Projet : Gestion de Pharmacie

## Description

Ce projet est une application de gestion simplifiée d'une pharmacie. Elle permet d'administrer le stock de médicaments, de traiter les achats des clients en tenant compte des ordonnances, et de générer un ticket de caisse. Le projet a été développé dans le cadre du module **Génie Logiciel** au cours de notre formation en **troisième année licence informatique, spécialité Ingénierie des Systèmes d'Informations et Logiciels**.

Ce projet a été réalisé en **2 heures de travail continu en présentiel**.

## Fonctionnalités

- **Gestion du stock de médicaments** :

  - Ajouter des médicaments avec leur prix et condition d'achat (sur ordonnance ou non).
  - Afficher la liste des médicaments disponibles.
  - Retirer un médicament du stock.

- **Validation des ordonnances** :

  - Vérifier si un médicament nécessite une ordonnance valide pour l'achat.

- **Traitement des achats** :

  - Ajouter des médicaments au panier avec une quantité désirée.
  - Appliquer une remise de 10% si le total dépasse 100 euros.
  - Générer et afficher un ticket de caisse.

## Technologies Utilisées

- **Java** : Langage principal pour le développement.
- **IDE** : Visual Studio Code.



## Exécution du Projet

1. Cloner ce dépôt :
   ```bash
   git clone https://github.com/dibabdelkrimyt98/gestion-pharmacie.git
   ```
2. Ouvrir le projet dans votre IDE Java.
3. Compiler et exécuter le fichier `GestionPharmacie.java`.

## Structure du Projet

```
/gestion-pharmacie
  |-- GestionPharmacie.java       # Point d'entrée principal du programme
  |-- Medicament.java             # Classe représentant un médicament
  |-- Client.java                 # Classe pour gérer les clients
  |-- Pharmacie.java              # Classe contenant les méthodes de gestion
  |-- README.md                   # Document actuel
```

## Exemple d'Exécution

1. Menu principal :
   ```
   --- Menu Gestion Pharmacie ---
   1. Gestion du stock
   2. Validation d'ordonnance
   3. Traitement des achats
   4. Quitter
   ```
2. Exemple d'achat :
   ```
   Paracetamol x2 - 10.0 EUR
   Antibiotique x3 - 60.0 EUR
   Une remise de 10% a été appliquée.
   Total: 63.0 EUR
   ```

## Auteur

- **DIB Abdelkrim Yassine Taki Eddine**
- Université : Université Djillali Liabes - Sidi Bel Abbes
- Année : Licence 3 - Ingénierie des Systèmes d'Informations et Logiciels

## Licence

Ce projet est réalisé à but pédagogique dans le cadre du module Génie Logiciel.



