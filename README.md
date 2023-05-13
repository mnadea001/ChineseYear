# ChineseYear

## cahier des charges:

- thème choisi : Nouvel an chinois 
- Site vendant des articles en lien avec la fete du Nouvel an chinois. 
- projet en Java Spring:
  site web
  Fonctionnant en locale
  Qui utilise Spring pour le back-end
  Avec une base de donnée SQL
  Avec une page web pour chaque élément de CRUD.
- site miniature servant de POC.


### règles de gestion liées à l’achat des utilisateurs.

- A chaque rechargement de la page d'accueil, un proverbe généré aléatoirement s'affiche.
- Depuis le header, il est possible de creer un utilisateur. A partir de l'annee de naissance de l'utilisateur,
son signe chinois est defini. 
- Depuis la page produits, l'utilisateur peut rajouter/retirer des elements dans son panier.
A partir de 50 euros, une reduction de 8 euros est appliquee. 



### installation 

Afin de recuperer une base de donnees de produits, un fichier productSQL.md est joint au projet avec les requetes SQL necessaires.
De meme pour les proverbes : proverbSQl.md
De plus il faut configurer le fichier application.properties afin de renseigner sa base de donnees locale. 

 