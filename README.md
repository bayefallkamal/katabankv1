# katabankv1
Katabank project for Spring Boot back-end rest api

# Description : Dans ce projet , je vais développer un service de gestion de compte bancaire personnel. 
	
- Dépôt et Retrait (Deposit and Withdrawal)
- Relevé de compte (date, montant, solde) (Account statement (date, amount, balance))
- Impression de relevés (Statement printing)


# Listes des end point

Listes des clients:
http://localhost:8080/clients

Listes des comptes:
http://localhost:8080/comptes

Lister une compte par némero de comptes
http://localhost:8080/comptes/66551234567



Faire un depot:
http://localhost:8080/comptes/versement

{
    "TYPE_OPERATION": "V",
    "numero": 66551234567,
    "montant": 220.0
  }
  

Lister les opération d'un compte donné:  
http://localhost:8080/operations/66551234568


Faire un retrait
http://localhost:8080/comptes/retrait

{
    "TYPE_OPERATION": "R",
    "numero": 66551234568,
    "montant": 3333.0
  }

Lister tous Opération  
http://localhost:8080/operations


