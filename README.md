### API 
 
 URI | action  | description
 ---------|-------- | ---------------------------------- 
 /trajet   | GET     | retourne la liste des trajets ainsi que le nombre de place disponible
 /trajet/{trajetID}   | POST    | reserve un trajet
 /trajet/{trainID}/{nbPlace} | PUT | ajout {nbPlace} pour le train {trainID}
 
 
### RAML 

/trajet:
  get:
    description: retourne la liste des trajets ainsi que le nombre de place disponible
    responses:
      200: 
  
/trajet/{trajetID}
    post:
        description: reserve une place sur un trajet (décrémente de 1 le nb de place disponible...)
        responses:
              200 
              
 /trajet/{trainID}/{nbPlace} ( pas implémenté )
 
 