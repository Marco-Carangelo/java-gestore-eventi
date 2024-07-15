# Gestore Eventi
---
Lo scopo di questo programma è di gestire degli eventi di diverso tipo (concerti, conferenze, spettacoli etc.), consentendo all'utente di crearne di nuovi e di gestire la prenotazione dei posti.


---
### Classe Event

La classe Event rappresenta un singolo evento, che avrà un nome, una data di svolgimento ed un numero di posti disponibili. 
Avrà a disposizione metodi sia per restituire informazioni riguardo alle caratteristiche dell'evento e per gestire la prenotazione dei posti e la loro eventuale cancellazione.

#### Attributi della classe:

- **eventTitle** di tipo String e con visibilità private, servirà ad accogliere il nome dell'evento.
- **eventDate** di tipo Calendar e con visibilità private, punterà ad un oggetto di tipo Calendar che conterrà la data dell'evento.
- **seatsNumber** di tipo int e con visibilità private, servirà ad accogliere il numero di posti disponibili per l'evento.
- **eventReservation** di tipo int e con visibilità private, servirà ad accogliere il numero di posti prenotati per l'evento. Al momento della creazione dell'oggetto è inizializzato a 0.
- **currentDate** di tipo calendar e con visibilità private, farà riferimento alla data attuale e servirà per dei confronti con le date inserite.

#### Metodo costruttore

Nel metodo costruttore verranno passati come parametri ed inizializzati gli attributi **eventTitle**, **eventDate** e **seatsNumber**. 

Per l'attributo **eventDate** si applica un controllo per cui valorizziamo la variabile locale solo se la data ricevuta come parametro è successiva a quella odierna, perchè non avrebbe senso programmare un evento in una data già passata.
In caso contrario il valore rimane NULL.

Per l'attributo **seatsNumber** si applica un controllo per cui valorizziamo la variabile locale solo se il numero passato come parametro è maggiore di 0. In caso contrario il valore rimane NULL.


#### Getters e Setters

- **eventTitle** è accessibile sia in lettura che in scrittura quindi avrà sia il metodo getter che il metodo setter.
- **eventDate** è accessibile sia in lettura che in scrittura quindi avrà sia il metodo getter che il metodo setter.
- **seatsNumber** è accessibile solo in lettura, quindi avrà solo il metodo getter.
- **eventReservation** è accessibile solo in lettura, quindi avrà solo il metodo getter.

#### Metodi della classe

**reserveSeat()** è un metodo con visibilità public, che non restituisce nulla, è usato per aggiungere una singola prenotazione, incrementando di uno il valore della variabile **eventReservation**.

Strutturalmente sono due IF ELSE annidate. Nella prima condizione viene verificato che l'evento preso in esame non sia già passato e nel caso lo fosse restituisce un messaggio d'avviso.
La seconda condizione verifica che l'evento abbia posti a disposizione.

Il valore di **eventReservation** viene incrementato solo se queste due condizioni non si verificano.

**reserveSeat(int resNumber)** è l'overload del metodo precedente, strutturalmente analogo, ma che accetta come parametro un intero che rappresenta il numero di posti che si vogliono prenotare in una singola operazione

**cancelReservation()** è un metodo con visibilità public, che non restituisce nulla, è usato per disdire una singola prenotazione, decrementando di uno il valore della variabile eventReservation.

Strutturalmente sono due IF ELSE annidate. Nella prima condizione viene verificato che l'evento preso in esame non sia già passato e nel caso lo fosse restituisce un messaggio d'avviso.
La seconda condizione verifica se ci sono delle prenotazioni da cancellare e nel caso non ce ne siano avvisa l'utente.

Il valore di **eventReservation** viene decrementato solo se queste due condizioni non si verificano.

**cancelReservation((int cancNumber))** è l'overload del metedo precendente. Strutturalmente è analogo, ma accetta un intero come parametro che servirà a cancellare più prenotazioni in una sola operazione.

**toString()** è l'override del metodo toString() e restituisce una stringa formattata nella forma "dataEvento - nomeEvento". All'interno usa il metodo d'utillità **dateFormatter**  della classe **EventManagerUtil**.

**availableSeats()** restituisce il numero di posti ancora disponibile, calcolando facendo la differenza tra il numero di posti totali e quelli prenotati.

**seatsInfo()** metodo che stampa a schermo il numero di prenotazioni effettuate ed il numero di posti ancora disponibili per un determinato evento.


---
### Classe EventManagerUtil

Classe creta per contenere metodi di utilità che potrebbero essere usati potenzialmente anche in altre classi.

#### Metodi della classe

**choiceManager()** è un metodo statico che restituisce un valore booleano. Gestisce la scelta dell'utente tra due possibilità, cioè Y per sì e N per no.

Se la scelta è Y restituisce un valore true, se la scelta è N restituisce un valore false. 

Gestisce anche il controllo di eventuali valori incoerenti inseriti dall'utente

**dateFormatter(Calendar date)** è un metodo statico che prende come parametro un oggetto Calendar e restituisce una stringa formattata nel formato data "YYYY/MM/DD".

Per formattare la data viene usato un oggetto di tipo SimpleDateFormatter della libreria java.text.SimpleDateFormat, il cui costruttore prende come parametro una stringa i cui caratteri indicano come formattare la data. Il suo metodo .format() prende in ingresso la data dell'oggetto Calendar e restituisce una stringa formattata.

**priceFormatter( float price)** è un metodo statico che prende in ingresso un numero in formato float e restituisce una stringa con il prezzo formattato nella forma "##,##€".

Viene usato il metodo .format della classe String, che prende come parametri una stringa che indica la formattazione che si vuole venga restituita e gli eventuali valori che da utilizzare all'interno di essa.


---
### Classe Main

Classe che contiene il metodo main e che viene usata per testare le funzionalità di altre classi e metodi. È usata divisa in tre sezioni:
1.  La prima per testare le funzionalità della classe Event
2.  La seconda per testare la funzionalità della classe Concert
3.  La terza per testare le funzionalità della classe EventProgram
   
1 **Test classe Event**

Come prima cosa istanziamo le variabili che verranno passate come argomenti al costruttore della classe Event e prepariamo un oggetto scanner della classe Scanner che ci servirà ad acquisirli da tastiera.

Istanzieremo anche due variabili di tipo int numberOfReservations e numberOfCancellation, che serviranno per accogliere il numero di prenotazioni e disdette che l'utente vorrà eventualmente fare.

*In tutti i cicli in cui vorremo fare un controllo sui dati inseriti dall'utente, useremo la variabile booleana check, che farà ripetere il ciclo while quando il suo valore sarà true. Prima di ogni ciclo verrà inizializzata a true e diventerà falsa quando i dati inseriti saranno coerenti con il tipo di dato.

##### Acquisizione dei dati e creazione di un'istanza di Event

Acquisiamo da tastiera i dati relativi al titolo dell'evento, anno, mese e giorno e numero totale di posti disponibili. Nell'acquisizione della variabile relativa al mese viene sottratta un'unità, perchè la formattazione del mese nell'oggetto Calendar va da 0 per gennaio ad 11 per dicembre, mentre è più comodo far digitare all'utente i classici numeri da 1 a 12 per identificare il mese.

*ScannerNextLine è usato dopo l'acquisizione di dati numerici per evitare che lo scanner salti una riga in un'eventuale acquisizione di una successiva stringa.

Nel momento in cui verrà istanziato un oggetto di tipo Event, se i dati inseriti come data e numero di posti disponibili saranno incoerenti con quello che è stato chiesto, il valore delle variabi corrispondenti **this.eventDate** e **this.seatsNumber** rimarrà uguale a quello di default, rispettivamente NULL e 0. 

Possiamo usare questi valori all'interno della condizione di una struttura IF ELSE, in questo modo, se i valori sono corretti possiamo stampare i dati relativi all'evento tramite il metodo toString() e passare alla parte relativa al controllo delle prenotazioni, altrimenti si avvisa l'utente che l'inserimento dei dati è uguale va ripetuto, check rimane uguale a true ed il processo si ripete.

##### Gestione della prenotazizone dei posti

Come prima cosa chiediamo all'utente se vuole prenotare uno o più posti. Gestiremo la risposta alla domanda tramite il metodo choiceManager della classe EventManagerUtil, che verrà richiamato direttamente nella condizione di una struttura IF ELSE.

Se l'utente desidera prenotare dei posti entriamo nel ramo IF e gli chiediamo quanti posti desideri prenotare. Una volta acquisito il dato, verifichiamo se i posti disponibili sono sono maggiori del numero appena acquisito.
Se sì, richiamiamo il metodo **newEvent.reserveSeat(numberOfReservations)** passandogli come parametro il dato e poi impostiamo check come false per uscire dal ciclo.

Se il numero inserito è maggiore di quelli disponibili, informiamo l'utente e non cambiamo il valore di check, in modo che l'utente possa decidere se ripetere l'operazione in base all'informazione appena ricevuta.

Successivamente entriamo nel ciclo per gestire le disdette, che è perfettamente analogo a quello appena visto. La richiesta è gestita sempre con il metodo choiceManager usato come condizione di una struttura IF ELSE.

Le differenze sostanziali sono che, la verifica del numero di disdette inserito dall'utente sarà effettuata controllando che siano minori o uguali al numero di posti già prenotati ed in seguito verrà richiamato il metodo **newEvent.cancelReservation(numnerOfCancellations)** a cui passeremo il numero inserito dall'utente e che andrà a modificare il valore della variabile locale **this.eventReservation**, sottraendone il valore appena inserito.


2 **Test classe Concert**

La classe Concert estende la classe Event, quindi possiamo usare molte delle strutture appena viste per testarne le funzionalità.

**Avremo bisogno di alcune variabili aggiuntive che serviranno come argomenti del costruttore di Concert:**

- **concertHour** di tipo int, servirà ad accogliere il dato relativo all'ora del concerto e settare la variabile di tipo LocalTime
- **concertMinutes** di tipo int, servirà ad accogliere il dato relativo ai minuti del concerto e settare la variabile di tipo LocalTime
- concertTime  di tipo LocalTime ed inizializzata NULL, è l'oggetto che rappresenterà l'orario che passeremo al costruttore di Concert
- **concertPrice** di tipo float, servirà ad accogliere il dato relativo al prezzo del concerto e servirà come argomento del costruttore dell'oggetto Concert

Acquisiamo questi dati da tastiera sempre all'interno di un ciclo while analogo a quelli visti in precedenza, che usa la variabile booleana check per verificare se entrare nel loop.

Una volta acquisiti i dati da tastiera istanziamo un oggetto di tipo Concert e passiamo come argomenti tutti i dati di cui necessita, cioè titolo dell'evento, data dell'evento, orario del concerto, prezzo del concerto e numero di posti disponibili.

Se i dati relativi a data e numero di posti disponibili sono incoerenti o se è stato inserito un prezzo negativo, il programma avvisa l'utente, la variabile check viene lasciata true e l'inserimento si ripete.

Se l'inserimento va a buon fine, vengono stampati a schermo i dati relativi al nuovo oggetto Concert tramite il metodo toString() ed il metodo seatsInfo della classe Event.


---
### Classe Concert

È una classe figlia di Event, che ne eredita metodi ed attributi e ne estende le caratteristiche.

Presenta gli attributi aggiuntivi

- **concertHour** di tipo LocalTime e con visibilità private, che servirà ad accogliere i dati relativi all'orario del concerto 
- **concertPrice** di tipo float che servirà ad accogliere il dato relativo al prezzo del concerto


#### Metodi

Presenta un metodo costruttore che prende come parametri i dati relativi alla classe Event(String title, Calendar eventDate, int seatsNumber) e gli attributi specifici della classe Concert (LocalTime concertHour, float concertPrice).

Il costruttore richiama quello della classe Event per gestire i primi tre parametri, dopodichè assegna il valore alla variabile locale **this.concertHour** e **this.concertPrice**, eseguendo un controllo sul dato su quest'ultima.

In questo controllo, che consiste in due strutture IF ELSE nidificate, si controlla prima che il numero passato non sia negativo, in quel caso restituisce un messaggio d'errore, ma controlla anche se il prezzo impostato è uguale a 0, avvisando l'utente che si sta creando un evento ad ingresso gratuito.

N.B. Rispetto ai controlli effettuati nel costruttore di Event, in questo caso si è deciso di assegnare comunque il valore negativo alla variabile, in modo da poterlo usare in una struttura di controllo nel main. In caso contrario rimarrebbe il valore di default 0 che sarebbe comunque coerente con un evento gratuito.

