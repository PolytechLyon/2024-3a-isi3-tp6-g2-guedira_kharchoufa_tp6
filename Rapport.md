# Compte Rendu du TP 6 : Patrons de Conceptions

Noms des étudiants du binôme : Zainab Kharchoufa et Rania Guedira

## Exercices 1

Le patron de conception qui reflète ce modèle est le patron Composite. Dans ce modèle, la classe « Vehicle » joue le rôle du composé, c'est-à-dire l'objet complexe qui peut avoir d'autres objets (les composants) à l'intérieur de lui-même. La classe « MobileObject » joue le rôle du composant, c'est-à-dire l'objet de base qui peut être utilisé individuellement ou comme partie d'un ensemble plus complexe. Il n’est pas nécessaire de réécrire les méthodes getVelocity() et getMass(), vu qu’elles sont implémentées dans la classe Vehicle dont hérite la classe TagAlongBike.

## Exercices 2

La méthode « getVelocity() » de la classe « Vehicle », telle qu'elle est présentée, utilise le patron de conception Iterator. L'avantage de l'utilisation du patron de conception Iterator dans ce contexte est qu'il permet de parcourir une collection d'objets de manière séquentielle sans exposer la structure interne de la collection. Il offre une interface standardisée pour itérer à travers les éléments d'une collection, ce qui permet de parcourir les éléments de manière uniforme quel que soit le type de collection utilisé (tableau, liste, ensemble, etc.). Par conséquent, il nous permet de passer de « Set » à « List » pour stocker les composants d'un véhicule sans modifier la logique de la méthode « getVelocity() ».

## Exercices 3

Pour garantir qu'il n'y a qu'une seule instance de la classe « Clock » dans l'application, nous utilisons le patron de conception Singleton. Voici les étapes pour réaliser ce patron dans le code :

1. Changer la déclaration du constructeur en private. Cela empêche les instances d'être créées directement en dehors de la classe.
2. Définir une méthode statique pour récupérer l'instance unique. Nous créons une méthode statique, appelée « getInstance() », qui permet aux autres classes d'obtenir l'instance unique de « Clock ».
3. Stocker l'instance unique. Nous stockons l'instance unique de « Clock » dans une variable statique pour y accéder depuis la méthode « getInstance() ».

## Exercices 4

Les classes Bike et Wheel ne sont pas dans le même paquetage. Bike appartient au paquetage "fr.polytech.sim.cycling", tandis que Wheel appartient au paquetage "fr.polytech.sim.transport". La dépendance entre les deux classes est de type bidirectionnel, car Bike a une référence à Wheel pour obtenir l'effort appliqué, nécessaire pour le calcul de sa vitesse, et vice versa, Wheel a une référence à Bike pour obtenir cet effort. Cette dépendance cyclique entre Bike et Wheel ne suit pas les bonnes pratiques de conception, car elle crée une forte couplage entre les deux classes, ce qui rend le code moins flexible, moins évolutif et plus difficile à maintenir. La fonctionnalité de la classe Bike utilisée par la classe Wheel est la méthode getPush(), qui fournit l'effort de poussée du vélo. Il y a donc une abstraction de la classe Bike en vehicule qui permet de résoudre ce problème.

## Exercices 5

CF code

## Exercices 6

Le patron de conception Méthode de fabrique permet de créer des instances d'une classe alors que le patron de conception Singleton permet de créer une seule instance d'une classe.

## Exercices 7

CF code

## Exercices 8

La classe Context suit le patron de conception Façade car elle simplifie l'utilisation de ServiceLoader. Il est envisageable d'avoir plusieurs lignes, donc plusieurs instances de Bike. Par conséquent, elle représente une liste de vélos que ServiceLoader peut charger.

## Exercices 9

La méthode injectAll()de la classe Context retourne un itérateur sur tous les objets du type donné disponibles dans le contexte applicatif. Ce patron de conception est connu sous le nom de "Iterator" dans le modèle de conception des collections. Il permet de parcourir séquentiellement les éléments d'une collection sans exposer sa structure interne.
