# l2s4-projet-2021

# Equipe

- Simon LEGROS
- Kilian MONCHEAUX
- Zo_Tahina RATEFIARIVONY
- Esam SHARFELDIN

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Instructions

## Makefile

A la racine du projet se trouve un `Makefile` dans lequel sont définies les
cibles suivantes :

```console
doc
guerre.jar
agricol.jar
cls
clean
all
```

La cible `doc` permet de générer la documentation des classes du projet, qui est
placée à l'intérieur d'un répertoire `doc` à la racine du projet :

```console
$ make doc
$ firefox doc/index.html
```

La cible `guerre.jar` permet de générer une archive jar exécutable pour le jeu
de guerre, qui est placée à l'intérieur d'un répertoire `jar` à la racine du
projet. L'exécutable correspond à une partie du jeu de guerre, sur un plateau
aléatoire de dimensions `10 x 10`. Les noms des joueurs (au moins 1) doivent
être passés en arguments, par exemple :

```console
$ make guerre.jar
$ java -jar jar/guerre.jar Alina Baptiste Charlotte Denis
```

La cible `agricole.jar` permet de générer un jar exécutable similaire pour le
jeu agricole, par exemple :

```console
$ make agricole.jar
$ java -jar jar/agricole.jar Alina Baptiste Charlotte Denis
```

La cible `cls` permet de compiler l'ensemble des classes java présentes dans le
répertoire `src` à la racine du projet. Les classes compilées sont placées dans
le répertoire `classes` à la racine.

La cible `clean` permet de supprimer les archives jar exécutables, la
documentation générée, les fichiers `.class` dans le répertoire `classes` et
dans le répertoire contenant les classes de test `tests`.

La cible `all` (choisie par défaut en exécutant `make` sans argument à la racine
du projet) permet de générer les jar exécutables des deux jeux.

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

#### Choix de modélisation des Tuiles :

- Classe abstraite Tuile, qui possède une unité, et des comportements
  concernant cette unité. Définit une méthode abstraite renvoyant une
  instance de Resource correspondant à la ressource produite par le
  terrain de la tuile (roche, sable...)

- Classes concrètes MoutainTile, DesertTile... correspondant aux cinq
  natures de terrain. Ces classes implémentent la méthode abstraite
  de signature getResource(): Resource.

- Interfaces WarTile et AgricolTile qui correspondent chacune au contrat
  que doivent respecter les tuiles d'un même jeu. Par exemple, toutes les
  tuiles dans le jeu militaire jouent un rôle dans le coût d'entretien
  des unités qui les occupent, elles jouent également un rôle concernant
  la taille maximale des armées, et peuvent causer un surplus de
  puissance militaire ou de points pour les armées occupantes. Ces
  interfaces jouent le rôle de contrat : elles contiennent les comportements
  que doivent implémenter les tuiles d'un jeu.

- Les méthodes définies dans ces interfaces sont implémentées dans des
  classes qui correspondent à la fois à un type "naturel" de tuile et
  à un jeu spécifique. Noter que sur le diagramme de classes, les méthodes
  ne sont pas figurées pour que le schéma reste lisible.

Synopsis : les unités qui occupent les tuiles possèdent une référence
à la tuile occupée, et peuvent appeler les méthodes de ces tuiles afin
de se comporter de manière conforme aux spécifications du jeu.

#### On a examiné une autre possibilité pour représenter les tuiles :

class abstraite Tile:
  + Unit unit;

  + // méthodes concrétes de gestion des unités
  + abstract getResource(): Resource

class MountainTile extends Tile:
  + static int cost;
  + static int maxArmySize;
  + static int additionalPower;
  + static int additionalPoints;
  + // méthodes correspondantes (getters)
  + getResource(): Resource { return Resource.Stone; }

// autres classes pour chaque type...

Dans cette solution, les comportements spécifiques sont accessibles
dans les deux jeux. On a jugé qu'il pouvait y avoir un problème
concernant le principe ouvert-fermé. En effet, ajouter des comportements
aux tuiles afin de créer un nouveau jeu implique de modifier les tuiles
existantes. Une autre difficulté était la nécessité de "setter" tous les
attributs statiques des tuiles au moment de l'initialisation d'un jeu.

#### Autre proposition non retenue pour les tuiles et leurs comportements spécifiques :

Les comportements spécifiques des tuiles selon les jeux sont considérés comme
des règles du jeu : on les implémente par des méthodes publiques statiques
d'une classe Game. On imagine que ces méthodes prennent en paramètres les
informations utiles (tuile...) et renvoie une valeur en fonction du type de
la tuile (structures if (Tile est de type...) else if (Tile de type...)).

Exemple :
WarGame
  + cost(Tile): int -> renvoie le coût d'entretien...
  + maximumArmySize(Tile): int -> renvoie la taille maximale...
  + additionalMilitaryStrength(Tile): int -> renvoie le surplus de puissance...
  + additionalPoints(Tile): int -> renvoie le surplus de points...

... en fonction du type de la tuile

Les méthodes des classes unités peuvent appeler ces méthodes statiques pour
renvoyer des valeurs correctes en fonction du type de la tuile occupée.

#### Implications de la modélisation pour la création d'un jeu :

Pour créer un jeu, il faut créer l'interface correspondant aux
comportements des tuiles dans ce jeu. Il faut ensuite définir des classes
étendant les classes MountainTile, DesertTile, ..., et implémentant
l'interface définie. Il pourra être nécessaire de dériver Board pour
chaque jeu, afin que les tuiles d'un plateau soient du type de l'interface
correspondant au jeu (besoin d'y réfléchir encore).

#### Choix de la modélisation pour les Ressources (et conversion) :

Pour représenter les différentes ressources (Roche, Sable, ...)
nous avons choisi d'utiliser une énumération.
Les informations sur les valeurs de conversion sont aussi gérées
par cette énumération via des variables statiques. Ces variables
statiques doivent être définies quelques part avant utilisation.
Pour'une ressource `r`, il suffit de faire:
  * `Resource.setConversionValue(r, <n>)` pour fixer la valeur de conversion de `r` à n.
  * `r.getConversionValue()` pour avoir la valeur de conversion de r.

#### Choix de modélisation pour le Plateau de jeu :

Pour représenter un plateau (Board), on choisit d'utiliser un tableau à 2 dimensions de tuiles (Tile).

On a choisi d'implémenter quelques méthodes permettant de gêrer les unités
présentes sur les tuiles du plateau : on peut obtenir une unité, la remplacer,
savoir si les tuiles occupables sont toutes occupées. Il y a également une
méthode permettant d'obtenir les tuiles voisines d'une tuile (a priori utile
seulement pour le plateau du jeu militaire).

### Difficultés restant à résoudre

L'implémentation du constructeur de Board (algorithme pour placer les tuiles
en suivant les règles définies) nous paraît un peu problématique.

La difficulté indiquée dans la description du livrable reste non résolue
à ce stade.

## Livrable 3

### Atteinte des objectifs
#### Modélisation des actions :

Nous avons choisi de modéliser les actions en utilisant une interface.
Celle-ci déclare une méthode de signature `execute(Board, Player): void`.
Les actions des différents jeux doivent définir cette méthode, qui
correspond à l'éxecution d'une action (avec des effets potentiels sur
les ressources des joueurs, sur les unités, sur les tuiles du plateau...).

On a considéré les actions suivantes :
- déployer une unité (disponible dans les deux jeux)
- ne rien faire (disponible dans les deux jeux)
- échanger des ressources (disponible comme action seulement dans
  le jeu agricole ; en effet dans le jeu militaire, cette action est
  automatique)

Cinq classes concrètes permettent de représenter toutes ces actions :

On définit la classe `DeployAction` qui représente l'action de placer une
unité sur une tuile du plateau définie par ses coordonnées. Cette classe
est étendue par la classe `WarDeployAction` qui ajoute au comportement par
défaut les mécanismes spécifiques au jeu militaire.

On définit également une classe `DoNothingAction` qui représente l'action
de ne rien faire, et dont la méthode `execute` est sans effet. Cette classe
est étendue par `AgricolDoNothingAction` qui correspond au comportement de
rémunération des unités en cas "d'attente" qui est spécifique au jeu agricole.

On définit finalement une classe AgricolExchangeAction qui correspond au
à l'action de conversion des ressources en or dans le jeu agricol.

#### Synopsis pour l'utilisation des actions :

Dans la boucle de jeu, les joueurs sont amenés chacun leur tour à choisir
une action (le constructeur d'une action spécifique est appelé dans le
corps de la méthode `chooseAction` des classes dérivant `Player` avec les
paramètres qui sont utilisés par l'implémentation de `Action`). La méthode
`execute` peut ensuite être appelé au niveau de la boucle de jeu. Les
références au plateau et au joueur qui éxecute l'action sont passées
en paramètre en la méthode `execute`.

On a discuté de la manière la plus convenable de rendre accessibles les
informations nécessaires à l'éxecution d'une action, et il nous a semblé
qu'il était correct de passer le plateau et le joueur en paramètre au
moment de l'appel à `execute` et non à la construction, car il ne semble
pas souhaitable que le joueur dispose d'une référence vers le plateau et
vers lui-même.

#### Modélisation du jeu :

Afin de modéliser le jeu, une classe abstraite `Game` est mise en place.
Il est possible d'instancier un jeu avec un plateau de taille variable;
puis, on peut y ajouter des joueurs, en enlever et lancer 
la partie (respectivement `addPlayer()`, `removePlayer()` et `play()`).
Concrètement, un mode de jeu (exemple: jeu de guerre) est une sous-classe
de `Game`. Un tel jeu devra redéfinir `play()`. Cette dernière représente
le déroulement du jeu en question (début, étapes, fin, ...).  
Il est important de noter que dans `play()` doit être initialisé les
variables statiques publiques des filles de `Tile`. Ces variables
définissent des caractéristiques du jeu tel que la taille maximale
d'unité autorisée sur une tuile, le coût de maintenance d'une unité sur une
tuile .... Sans cette initialisation, la partie se comportera indéfiniment: 
erreur lors de l'execution ou valeurs inattendues
(car il n'y a pas de valeur par défaut).  

Le jeu de guerre et le jeu agricole sont modélisées respectivement par les
classes `WarGame` et `AgricolGame`.

Afin de créer un nouveau mode de jeu, il suffit de définir une nouvelle classe
qui hérite de `Game` (et bien évidemment, définir les méthodes nécessaires). La 
partie "essentielle" qui caractérise un nouveau jeu sera représentée par la 
redéfinition de `play()` et par la même occasion la définition des valeurs des
variables statiques publiques évoquées précedemment.

### Difficultés restant à résoudre

## Livrable 4

Modifications de la modélisation depuis les livrables précédents :

- Simplification de la modélisation des tuiles de jeu, par rapport à la
  proposition du livrable 2. Cette Simplification est détaillée dans l'entrée
  du journal de bord correspondant à la semaine 6.

- Ajout de classes d'exceptions, `UnknownTileException` et
  `IllegalGameActionException`. La première est censée indiquer qu'on a tenté
  d'accéder à une tuile n'existant pas dans le plateau de jeu. La deuxième est
  utilisée pour indiquer l'occurrence d'une situation illégale. Elle pourra être
  levée par exemple si l'on essaye d'obtenir les ressources d'une tuile de type
  océan, ou encore si on essaye de supprimer un joueur qui n'est pas en train de
  jouer, ou si on essaye de placer une unité sur une tuile de type océan.
 
- Ajout de la méthode `unsetUnit()` pour la classe `Tile`.
Pour enlever un unité d'un tuile `t`, au lieu de faire `t.setUnit(null)`, on préfèrera faire
`t.unsetTile()`. Desormais, t.setUnit(null) déclenchera un `IllegalArgumentException`.

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1

## Semaine 2

## Semaine 3

## Semaine 4
Nous avons commencé à écrire les javadocs, implémenter les différentes entités (classes, interfaces, ...) et écrire les tests unitaires depuis la semaine 3. Nous n'avions pas pu achever complètement le codage et les tests car elles dépendent encore d'autres entités qui ne sont pas défini à ce stade d'avancement.  
Pour le livrable 2, nous avons débatu longuement sur une meilleure modélisation des tuiles. Nous avons décidé d'adopter une solution qui est assez "complexe" car elle nécessite la définition de beaucoup de plusieurs entités. Cependant, nous n'avons pas reculé devant cette difficulté et nous nous sommes convenu de prendre cette solution qui nous semble mieux respecter le principe ouvert-fermé.
Nous comptons continuer l'implémentation, les javadocs et les tests pour cette semaine.
 
## Semaine 5
Nous avons discuté de la modélisation des actions. 
Nous ne l'avons pas encore fini et nous avons encore quelques questions à propos de l'énoncé.  
Nous avons décidé aussi de revenir sur notre modélisation des tuiles afin de le simplifier. 
Nous en discuterons la semaine prochaine.

## Semaine 6

Tuiles :

Sur les conseils de notre enseignante, nous avons transformé notre Modélisation
des tuiles. La modélisation du livrable 2 avait pour objet de respecter le
principe "ouvert-fermé", en utilisant des interfaces définissant les contrats
que devaient respecter les tuiles de chaque jeu. Cependant, elle était plus
compliquée que nécessaire.

On définit une classe abstraite `Tile`, qui définit des comportements
relatifs à la gestion des unités occupant une case, et une méthode abstraite
permettant d'obtenir la ressource correspondant à une tuile (comme dans la
première modélisation proposée).

Cette classe abstraite est étendue par 5 classes concrètes qui correspondent
aux 5 types de terrain que peuvent avoir les tuiles des jeux. Ces classes
implémentent la méthode `getResource`. Pour gêrer les comportements différents
des tuiles dans chacun des jeux (le coût d'entretien, la taille maximale
d'armée, le surplus de puissance militaire, le surplus de points, la quantité
d'or en cas d'attente sont tous des comportements qui dépendent du type de
terrain), on a décidé d'utiliser des attributs statiques. On a pris la
décision de déclarer ces attributs publics (pour éviter la multiplication
des accesseurs dans ces classes).

Lors de son initialisation, le jeu sera responsable de l'initialisation
des valeurs de ces attributs statiques publics (les attributs non utilisés
par un jeu, comme maxArmySize dans le jeu agricole, seront mis à des valeurs
par défaut).

Ces attriburs ne pouvaient pas être factorisés dans la classe mère, car ils
sont statiques et différents pour chaque type de terrain.

Actions :

Nous avons terminé le travail sur les classes représentant les actions. Nous
avons choisi d'utiliser l'héritage pour définir les classes implémentant
l'interface `Action` (il était possible de s'en passer, et de se contenter
de 5 classes implémentant directement Action) pour factoriser quelques
comportements.

Game :

Nous avons terminé le travail sur les classes Game, en réfléchissant sur
l'initialisation des variables spécifiques à chaque jeu (à l'intérieur des
tuiles, mais aussi les valeurs de conversion des différentes ressources),
ainsi que sur le status de la méthode `play` (finalement abstraite car
la boucle de jeu n'est pas exactement la même dans les deux jeux à réaliser,
malgré de fortes similitudes).

## Semaine 7

- Modifications concernant la classe `OceanTile` (redéfinition de méthodes et
  levées d'exceptions). La classe redéfinit `isBusy` (renvoie `false`),
  `getUnit` (renvoie `null`) et `setUnit` (lève une exception).

- Documentation des classes implémentant l'interface `Action`.

- Documentation des classes `Tile` et des classes qui l'étendent.

- Documentation des classes `Game`, `WarGame` et `AgricolGame`.

- Documentation du type énuméré `Resource`.

- Implementation de classes étendant `Exception`, qui servent à indiquer
  l'occurence d'une situation impossible ou illégale.

- Implémentation de la classe `Board` (en cours).

## Semaine 8

- tests pour les classes:
    * `Action` et ses filles
    * `Board`
    * `Tile`
    * `Game` et ses filles
    * `Resource`

- implémentation de la classe `Board`

- quelques corrections mineures sur la modélisation: 
    * signature des méthodes: pour `Resource#setConversionValue()` et `Resource#getConversionValue()`
    * ajout de la méthode `unsetUnit()` pour la classe Tile qui sert à enlever un unité d'une tuile. 


## Semaine 9
- Implémentation de `Player`: classe abstraite qui est la classe mère de tout
les joueurs dans le jeu.

- Implémentation de `AgricolPlayer`: classe du joueur dans le jeu agricol.

- Dans `Tile`, ajout des informations qui permet à une tuile de connaître à quelle 
position dans le plateau elle est placée.

- Changement du prototype de `Player::chooseAction` en ajoutant un paramètre de
type `Board`. Ce paramètre représente le plateau du jeu, ce qui permet à un 
joueur de choisir une action légale dans `chooseAction`.  
Implémentation de `Board::freeTiles()` qui facilitera au joueur le choix d'une
tuile libre pour une action de déploiement.

- Ajout de constructeur plus "simple" dans `Unit` et ses sous-classes, par exemple, le constructeur qui ne prend pas de joueur et de tuile en paramètre, car
on peut construire une unité sans forcément savoir a quel joueur ou à quelle tuile
elle appartient.


## Semaine 10
* nous avons ajouter les classes tests de `AgricolDoNothingActionTest`, `BoardTest`et`DoNothingAction`.

* Modification concernant les classes `Player` , `AgricolPlayer`:
  - Implémentation le javadoc de la class et le codage sur le classe `Player`.
  
* Modification concernant la classe `Unit`, `Army` and `Worker`:
  - ajoutent des construire de les classe `Unit`, `Army` et `Worker`. 

* Modification concernant la classe `Board` :
  - implémentation de la classe `Board`  ajouter un method `freeTiles`.

* Modification concernant la classe `Game`: 
  - Implémentation de `Game`, ajouter un throws IllegalArgumentException au constructeur de Game

## Semaine 11

- Modélisation : 
	* Ajout d'un nouvel UML représentant l'ensemble des classes et des classes Test.
	
- Tests pour les classes : 
	* `AgricolDoNothingAction`.
	* `Board`.
	* `DoNothingAction`.
	* Filles de `Action`.
	
- implémentation :
	* Méthodes goldCoinWhenPlayerDoesNothing() et cost() dépendants de Tile#getAddCost de la classe 'Worker'.
	* Méthodes militaryStrength(), points(), cost() dépendants de Tile#getCostFactor de la classe 'Army'.
	* Méthodes hasUnit() de la classe 'Unit'.
	* Suppresion de getCost() pour 'Tile' et ses filles.
	* Ajout de méthodes costAdd() et costFactor() pour 'Tile' et ses filles.
	* Ajout de variables statiques pour 'Tile' et ses filles.
	* Ajout de abstract getter pour les variables statiques de 'Tile' et ses filles.
	* Ajout de méthodes abstraites liées au bon fonctionnement du jeu de guerre dans 'Tile' et ses filles.
	* Taille maximale d'une armée en fonction de la tuile.
	* Implémentation des classes filles de 'Action'.
	* Classe 'AgricolGame', 'WarGame' et l'énumération 'Ressources'.

- Corrections mineures :
	* Bugs pour 'Player' et 'AgricolPlayer'.
	* Decrement warrior stock et remove unit from the list.
	* AgricolGame::play. et ajout d'une méthode findWinner() pour 'AgricolGame'.
	* Play throws et isGameOver() abstraite.
	* Ajout d'un compteur de tour pour 'AgricolGame'.
	
## Semaine 12

- Création de packages pour organiser les classes du projet.

- `Board` devient une classe abstraite, qui contient les méthodes utiles pour
  manipuler les tuiles d'un plateau, mais qui n'impose pas de règles sur le
  contenu du plateau (notamment sur la répartition des tuiles). Cette classe
  est étendue par `ExampleBoard` (dont le contenu fixe correspond à l'exemple
  de l'énoncé) et `RandomBoard` qui correspond à un plateau aléatoire suivant
  les règles des jeux de guerre et agricole.

- Implémentation de `WarGame` et réécriture des boucles de la logique des jeux
  dans les méthodes `AgricolGame::play` et `WarGame::play`.

- Achèvement et correction de la documentation. Notamment, rédaction de
  documentation pour les méthodes privées ou protégées.

- Correction des classes de test (notamment dans les packages `player`, `game`,
  `action` et `board`).

- Correction de bugs divers.

- Implémentation de mécanismes pour l'affichage d'une trace du jeu sur la sortie
  standard (dont un affichage rudimentaire du plateau sous forme de texte).

- Ajout de classes exécutables correspondant aux deux jeux demandés.

- Ecriture du Makefile et ajout d'instructions de compilation dans le README.

- Organisation du dépôt selon les consignes de rendu.
