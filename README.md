# The Moovie App

## Objectifs fonctionnels  
Dans ce projet, nous allons créer l'application AnneFlix (The new Netflix). L'objectif est d'exploiter la base de données TheMoovieDB (https://developers.themoviedb.org/3) afin de permettre aux utilisateurs de l'application de visualiser, noter et voir la bande annonce des films de la base de données. 

## Objectifs techniques 
Techniquement, ce projet devrait nous permettre d'expérimenter de manière plus approfondie les notions vues en cours: 
- Kotlin
- Architecture Components 
- Data Binding
- Retrofit 
- Room 
- .... 

## Quelques librairies à utiliser 
- Navigation-fragment 
- Hilt : Injection de dépendances 
- Gson/Moshi : Sérialisation et Désérialisation JSON 
- Retrofit: Pour consommer l'API The Moovie DB
- Picasso/Glide/Coil/ : Pour afficher les images 
- OkHttp: Client HTTP

## Critères d'acceptance
- Une seule activité
- Au moins 5 vues différentes (fragments) + un fragment About qui présente le projet et les membres du groupe
- Gestion de données via une API et Room
- Gestion de la navigation avec Navigation-fragment
- Tests unitaires (Datasource et Repository)
- Au moins 2 tests instrumentaires par vues


## Différentes étapes 
1. Fork le repository.  

2. Afficher les catégories de films. Les étapes sont décrites [ici](https://github.com/eamosse/the-movie-app/blob/master/home_tuto.md)

3. Afficher les films d'une catégorie. Les consignes sont par [ici](https://github.com/eamosse/the-movie-app/blob/master/movie_list.md)

## Fonctionnalités
Voici la liste des fonctionnalités de notre application :
- L'affichage des catégories de films.
- L'affichage des films par catégorie.
- L'affichage du détails des films avec :
    - L'affiche du film.
    - Le nom.
    - La date de sortie.
    - La durée.
    - La langue.
    - La note.
    - Les compagnies de production.
    - Le résumé.
    - Les films similaires.
    - Les bandes annonces (nous nous sommes fixées un nombre maximale de 3 bandes annonces).
- La possibilité de mettre des films en favoris.
- L'affichage des films favories

## Membres du groupe
Notre équipe est composée de :
- Nisserine EZZAIMI
- Tessir FAHMI ALI
- Pauline GHIRLANDA
- Adeline FEURTÉ

## Captures d'écran des vues principales
Voici les captures d'écran des vues principales :
- La page d'accueil "Home" :

![271905313_928635881120924_5957247146511578862_n](https://user-images.githubusercontent.com/93370036/150416517-b6d9faff-b57f-4186-b066-67d2cdf4fd92.jpg)

- La page avec la liste des films d'une catégorie :

![271640955_473162890872341_570587164281020192_n](https://user-images.githubusercontent.com/93370036/150416514-aa7eec8d-93fd-4bd0-b559-87111ff8e240.jpg)

- Le page avec le détail d'un film :

![271748049_478587153879273_2664357021286134120_n](https://user-images.githubusercontent.com/93370036/150416524-9aab269c-8056-474e-9dd9-89c24807919e.jpg)
![271726736_648689389815488_3836486060359291585_n](https://user-images.githubusercontent.com/93370036/150416525-e574b595-4616-4332-8e9a-790327bfdb1d.jpg)

- La page avec la liste des films "découverte" :

![271729609_644286820224935_2267847053115978208_n](https://user-images.githubusercontent.com/93370036/150416519-a5b8894e-4c4a-4d54-b564-e7bb3411c7e5.jpg)

- La page des favoris :

![271921744_1264519574027873_5410307658121576991_n](https://user-images.githubusercontent.com/93370036/150416520-fb59a65a-960b-4292-9f22-055117ee437e.jpg)

- La page 'A propos de nous' :

![271811004_623193265401704_5576232667990172331_n](https://user-images.githubusercontent.com/93370036/150416522-a99e00d6-27b3-4f85-9fcb-f0d5aa6e4c0c.jpg)
![271719184_1095770784591393_4946466142636953418_n](https://user-images.githubusercontent.com/93370036/150416527-419f2e7c-8f28-4643-b40e-d5fa59cbcff1.jpg)

## Vidéo de démonstration
Voici le lien vers la vidéo de démonstration de notre application :



