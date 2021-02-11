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

Pour modéliser les joueurs et les actions qu'ils peuvent entreprendre dans
différents jeux, nous avons supposé l'existence d'une interface permettant de
représenter les actions des personnages. A ce stade de la modélisation, on
suppose que `Action` est une interface comportant une méthode permettant à
un joueur qui a choisi une action de l'exécuter `execute()`.

La classe abstraite `Player` permet de représenter un joueur. Un joueur
possède un nom, une liste de personnages qu'il contrôle, ainsi que des stocks
de ressources. Des méthodes permettant d'interagir avec les stocks et les
personnages possédés par un joueur sont définies. On définit également des
comportements permettant de réaliser les actions qui sont communes aux
joueurs de différents jeux :
- `chooseAction(): Action` renvoie une instance d'une classe implémentant
  l'interface `Action` et représentant l'action choisie par le joueur parmi
  celles qui sont disponibles dans un jeu particulier
- `collectResources()` permet d'effectuer la collecte des ressources
  qui sont fournies par les unités possédées par le joueur
- `remunerate(Unit)` permet de payer le coût lié à l'entretien d'une unité
- `canRemunerate(Unit): boolean` permet de savoir si les ressources du
  joueur lui permettent d'entretenir une de ses unités à un moment donné
- `convertResource()` est une méthode abstraite permettant de convertir
  les ressources (naturelles) d'un joueur en d'autres ressources (par exemple
  de la nourriture, ou de l'or). Cette méthode est abstraite car il n'existe
  pas de comportement valable par défaut

Il doit être possible d'utiliser des classes héritant de `Player` dans
différents jeux, à conditions de définir des classes implémentant `Action`,
représentant les actions qui sont disponibles à un joueur dans un jeu quelconque.
Les classes `WarPlayer` et `AgricolPlayer` sont proposées et correspondent
aux deux jeux demandés. Ces classes définissent des comportements spécifiques
à ces jeux.

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
