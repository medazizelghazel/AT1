# Fiche : Iterator

**Famille :** comportementale (GoF)

## Intention
Fournir un moyen de parcourir séquentiellement les éléments d'une
collection sans exposer sa représentation interne.

## Problème résolu
`Catalogue.afficherTout()` figeait un seul parcours (l'affichage) dans la
classe. Chaque nouveau besoin (export, comptage, filtre) obligeait à
modifier `Catalogue`.

## Participants
- **Iterable<T>** (l'agrégat) : interface qui promet un itérateur.
- **Iterator<T>** : `hasNext()` et `next()`.
- **Catalogue<T>** (agrégat concret) : implémente `iterator()`.
- **Client** (`Main`) : parcourt le catalogue avec un for-each.

## Application dans la médiathèque
`Catalogue<T extends Document> implements Iterable<T>`. Le client écrit
`for (Document d : catalogue)` sans savoir que les documents sont dans
une `ArrayList`. `afficherTout()` a été supprimée.

## Conséquences
**Avantages**
- Le client ne dépend pas de la structure interne : on peut remplacer
  l'`ArrayList` par une autre structure sans le modifier.
- Plusieurs parcours indépendants peuvent coexister.
- Compatible avec le for-each et les API standard (`Stream`, etc.).
- Le Catalogue n'a plus à connaître les besoins d'affichage (SRP).

**Inconvénients**
- Un peu plus de code qu'une boucle directe sur un tableau.
- Modifier la collection pendant le parcours lève
  `ConcurrentModificationException`.
- Exposer `remove()` casserait l'encapsulation : d'où
  `Collections.unmodifiableList(...)` dans `iterator()`.