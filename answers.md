## 1

### Class
Ex: Basket
### Object
Un ensemble de propriétés et de méthodes, i.e. une instance d'une classe. 
### Primitive types
int (cell.x), float, ...
### Encapsulation
L'encapsulation est le principe selon lequel un objet ne peut accéder qu'à certaines données (on le définit avec private, protected, public).
### properties
Les variables contenues dans une classe.
### getter and setter
Des méthodes qui permettent à des classes d'accéder à des propriétés qui leur sont normalement inaccessibles. (Ex : cell.setX, @getter de cell.x)
### final
Rend impossible la modification d'une variable
### Instantiation of objects
L'action de créer un objet en mémoire.
### Constructors
Une méthode spéciale, qui sert à créer les instances des classes
### Static fields, static methods
Des propriétés ou méthodes qui appartiennent à la classe elle-même, pas à l'objet. Il ne peut y en avoir qu'une seule copie.
### What are the particularity of "static" ?
"static" permet de déclarer une variable ou une méthode de classe
### Composition
Lorsqu'une classe possède une propriété de type autre classe (Ex : la classe "Grid" possède plusieurs cellules de classe "Cell")
### Inheritance
Lorsqu'une classe hérite d'une autre, elle récupère toutes ses propriétés et ses méthodes. (Ex : GamePanel extends JPanel)
### interface
Template pour définir des classes. (Ex : GamePanel implements ActionListener, KeyListener)
### polymorphism
Lorsque plusieurs méthodes différentes portent le même nom mais n'ont pas la même signature ou ne s'appliquent pas à la même classe (Ex : @override).
### Static VS dynamic types
Possibilité ou non de pouvoir changer le type d'une variable durant l'exécution (Ex : java typage fort vs JavaScript typage faible).
### Separation of concerns (design principle)
Design principle. On segmente les différents aspects du problème en problèmes plus petits (Ex : dossiers exception, model et ui).
### Collections>
Une classe qui contient plusieurs objets (Ex : HashMap<>, Grid).
### Exceptions
Un type particulier de classes qui permettent de lever une erreur. (Ex : OutOfPlayException)
### Functional interfaces / Lambda
Fonction anonyme qui est utilisée à un instant t puis jamais réutilisée.
### Lombok
Bibliothèque qui permet de générer auto-magiquement constructeurs, getters/setters, toString(), etc.

