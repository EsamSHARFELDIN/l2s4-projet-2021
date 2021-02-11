# l2s4-projet-2021

# Equipe

- Simon LEGROS
- Kilian MONCHEAUX
- Zo_Tahina RATEFIARIVONY
- Esam SHARFELDIN

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1

Modélisation des personnages et des joueurs du jeu.

### Atteinte des objectifs

Pour modéliser les personnages des différents jeux, nous avons supposé
l'existence d'une classe `Tile` représentant une tuile du plateau de jeu. Nous
avons également supposé que chaque instance d'une classe représentant un
personnage possédait comme attribut la tuile sur laquelle il se trouvait.

Nous avons également utilisé une énumération `Resource` représentant les
différents types de ressources que peuvent récolter les personnages du jeu
sur les différentes tuiles.

La classe abstraite `Unit` permet de représenter un personnage contrôlé par
un joueur, qui possède une tuile et un stock d'or. Outre des accesseurs, la
classe `Unit` définit des méthodes permettant d'interagir avec les personnages :
- `destroy()` pour détruire une unité et libérer sa tuile
- `receiveGold(int)` pour incrémenter le stock d'or du personnage
- `provideResource(): Resource` pour obtenir le type de la ressource
  correspondant à la tuile occupée
- `points(): int` pour obtenir les points que valent l'unité
- `cost(): int` est une méthode abstraite permettant d'obtenir le coût
  d'entretien d'une unité

Les classes `Army` et `Worker` qui héritent de `Unit` implémentent la méthode
`cost` et définissent des comportements supplémentaires qui correspondent à
leur rôle dans les deux jeux proposés.

### Difficultés restant à résoudre

- Nous avons prévu des méthodes, dans les classes `Unit`, `Player` et les
  classes héritant de ces classes, qui doivent permettre de réaliser les
  traitements résultant d'une action. Il n'est cependant pas encore clair
  comment les instances de classes implémentant l'interface `Action` accèderont
  à ces méthodes.

## Livrable 2

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1

## Semaine 2

## Semaine 3

## Semaine 4

## Semaine 5

## Semaine 6

## Semaine 7

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
