# API REST With MySQL

Il s'agit d'une simple API REST pour la gestion des employés de cours pour une plateforme
de E-learning.
Les employées sont stockés dans une base de données MySQL. 
L'API implémente les opérations CRUD pour l'exploitation de cette base de données.


## Installation
L'API n'est pas fournit en un fichier d'installation. Il s'agit simplement  d'un dossier à télécharger et à importer dans votre IDE préféré.
Toutefois, notez les points suivants :
- Vous devez disposez d'une base de données MySQL (locale ou distant);
- Configurez le fichier **application.properties** en renseignant les bons identifiants de votre base de données. 

## Contrat
Cette section décrit la manière de communiquer et d'interagir avec l'API.

### Récupération de tous les cours
```
Request
  URI: http://localhost:9002/
  HTTP Verb: GET
  Body: Empty

Response:
  HTTP Status:
    200 OK if all courses are successfully retrieved
    204 NO CONTENT The request has been processed but no course exists in the database

  Response Body Type: JSON
  
  Example Response Body:
    [
        {
            "id": 1,
            "title": "Découvrez Spring Boot",
            "description": "Le lorem ipsum est, en imprimerie.",
            "category": "Développement",
            "level": "facile",
            "postedAt": "2023-04-23T20:54:39"
        },
        {
            "id": 2,
            "title": "Trouvez votre niche",
            "description": "Le lorem ipsum est, en imprimerie.",
            "category": "Marketing",
            "level": "moyen",
            "postedAt": "2023-04-23T20:54:39"
        }
    ]
```

### Récupération d'un cours
```
Request
  URI: http://localhost:9002/{id}
  HTTP Verb: GET
  Body: Empty

Response:
  HTTP Status:
    200 OK if the Course was successfully retrieved
    404 NOT FOUND if Course cannot be found
    
  Response Body Type: JSON
  
  Example Response Body:
    {
        "id": 1,
        "title": "Découvrez Spring Boot",
        "description": "Le lorem ipsum est, en imprimerie.",
        "category": "Développement",
        "level": "facile",
        "postedAt": "2023-04-23T20:54:39"
    }
```
### Ajout d'un cours
```
Request
  URI: http://localhost:9002/
  HTTP Verb: POST
  Body: 
    {
        "title": "A Title",
        "description": "Short description of course",
        "category": "Cloud",
        "level": "difficile"
    }

Response:
  HTTP Status:
    201 CREATED The request has been fulfilled and a new course being created.
    
  Response Body Type: JSON
  
  Example Response Body:
    {
        "id": 5,
        "title": "A Title",
        "description": "Short description of course",
        "category": "Cloud",
        "level": "difficile",
        "postedAt": "2023-04-23T20:57:21"
    }
```
### Modification totale d'un cours
```
Request
  URI: http://localhost:9002/{id}
  HTTP Verb: PUT
  Body: 
    {
        "title": "Title updated",
        "description": "Updating description of course",
        "category": "Cloud",
        "level": "moyen"
    }

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if the id does not exist
```
### Modification partielle d'un cours
```
Request
  URI: http://localhost:9002/{id}
  HTTP Verb: PATCH
  Body: 
    {
        "title": "Just title updated"
    }

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if the id does not exist
```
### Suppression d'un cours
```
Request
  URI: http://localhost:9002/{id}
  HTTP Verb: DELETE
  Body: Empty

Response:
  HTTP Status:
    204 NO CONTENT The server successfully processed the request, but is not returning any content.
    404 NOT FOUND if the id does not exist
```
