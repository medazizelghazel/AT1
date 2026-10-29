# Fiche : Strategy

**Famille :** comportementale (GoF)

## Intention
Définir une famille d'algorithmes, encapsuler chacun d'eux et les rendre
interchangeables. L'algorithme varie indépendamment du client qui l'utilise.

## Problème résolu
Un objet contient plusieurs variantes d'un même calcul, choisies par
des `if/else` ou un `switch`. Chaque nouvelle variante oblige à modifier
cette classe (violation de l'OCP).

## Participants
- **Strategy** : interface commune à tous les algorithmes.
- **ConcreteStrategy** : une implémentation par algorithme.
- **Context** : détient une référence vers une Strategy et lui délègue
  le travail. Il ne connaît que l'interface.

## Situation dans la médiathèque
Le calcul de l'amende de retard :
- `PolitiqueAmende` (Strategy) : `double calculer(long joursRetard)`
- `AmendeLivre` : 0,10 par jour
- `AmendeDvd` : 0,50 par jour
- `AmendeAbonne` : gratuite pendant 3 jours, puis tarif normal
- `Emprunt` (Context) reçoit une `PolitiqueAmende` et l'appelle au retour,
  sans `if (type == ...)`.

Autre cas : le tri du catalogue (par titre, par année), déjà présent
dans `documents.sort(Comparator.comparing(...))`.

## Remarque
Non implémenté ici : prévu pour la séance 9.