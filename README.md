# ProgettoOOP

Scopo del progetto 
Il progetto che viene presentato ha come obiettivo quello di implementare un servizio meteo che faccia visualizzare tutte le informazioni relative alla temperatura e alle condizioni meteo di una città presa in esame, che restituisca statistiche su un particolare campo specificato e che esegua dei filtraggi specifici per restituirci specifiche informazioni. 
Il sistema software che abbiamo utilizzato è SpringBoot. Grazie a questo WebService possiamo consentire agli utenti che si collegano di usufruire delle funzioni disponibili. SpringBoot è il software che lancia l'intera webApp comunicando con il client tramite il protocollo HTTP.

Nello specifico l'applicazione presentata permette di richiedere tramite l'utilizzo di API REST (GET o POST):
* metadata (JSON) : alias degli attributi e formato degli stessi
* dati (JSON) : dati riguardanti i record
* dati filtrati (JSON) : dati riguardanti i record filtrati secondo qualche criterio
* statistiche (JSON) : statistiche fatte su uno specifico campo (Es. valori numerici delle temperature percepite)
* statistiche filtrate (JSON) :  statistiche fatte su uno specifico campo filtrate secondo qualche criterio
* record specifico (JSON) : record (che viene poi salvato nei dati) riguardante una citta specifica, in una lingua specifica con attributi in una specifica unità di misura.

Inoltre l'applicazione, dopo un quarto d'ora dall'avvio e successivamente ogni ora, richiede un record specifico direttamente all'API in maniera automatica, così da andare a popolare i nostri dati e ad effettuare statistiche su un campo più ampio.

![casi d'uso](/img/Casid'uso.png)

## Inizializzare l'applicazione
Per scaricare l'applicazione nell'ide Eclipse dobbiamo anzitutto clonare la repository git nello show view di Eclipse. Successivamente incollare l'URL di questa repository e continuare. Dopo che il clone viene correttamente importato clicchiamo con il tasto destro del mouse e importiamo i progetti. A questo punto si può eseguire il codice cliccando con il tasto destro nel nome del progetto, selezionare "Run As" e successivamente "SpringBoot App". L'applicazione Web Service sarà in ascolto alla porta http://localhost:8080.
## Descrizione richieste e rotte
Per effettuare le richieste è necessario utilizzare un programma che permetta di eseguire chiamate HTTP (Es. Postman). Richieste possibili:


|    TIPO        |rotta                          |descrizione                                |
|----------------|-------------------------------|-------------------------------------------|
|GET             |/metadata                      |restituisce gli alias degli attributi           |
|GET             |/data                          |restituisce tutti i record salvati nei dati     |
|GET             |/statistiche?field="statistica"      |restituisce media, minima, massima e varianza delle temperature reali o percepite     |
|GET           |/statistichestring?field="statistica"                          |restituisce in percentuale quante volte ogni tipo di meteo è apparso                                     |
|GET            |/request?city="città"&lang="lingua"&unit="unita"      |restituisce il meteo della città specificata, nella lingua specificata nel formato dell'unità di misura. specificata  |
|POST             |/data                          |restituisce i record che rispettano i filtri specificati nel body     |
|POST             |/statistiche?field="statistiche                          |restituisce le statistiche specificate filtrate secondo i filtri specificati nel body     |

## Diagramma classi

**com.progetto.OOP.controller**

![classeController](/img/ClasseController.png)

**com.progetto.OOP.archivio**

![ArchivioClass](/img/ArchivioClass.png)

**com.progetto.OOP.model**

![model](/img/model.png)

**com.progetto.OOP.service**

![service](/img/service.png)

**com.progetto.OOP.eccezioni**

![eccezioni](/img/eccezioni.png)
