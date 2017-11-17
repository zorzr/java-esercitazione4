# java-esercitazione4
Esercitazione 4 - Collections

Si scriva un programma che permetta di gestire dei conti bancari attraverso una banca.

Ogni conto è caratterizzato da un proprietario (identificato dal suo CF), un iban e un saldo. I conti possono essere di tre tipi:

	conto corrente: dove si può prelevare e depositare denaro

	conto web: come il conto corrente ma richiede di loggarsi tramite una password prima di poter eseguire le operazioni

	conto deposito: dove si può solo depositare (e non prelevare) denaro


1. Creazione conti

Tutti i conti possono essere aperti tramite la banca comunicando il CF del proprietario e il tipo di conto da aprire.

	Il saldo iniziale dei conti all'apertura è sempre 0 e I'iban viene assegnato automaticamente dalla banca.

	Non possono esistere due conti con Io stesso iban nella stessa banca.

	Per il conto web la password viene inizialmente impostata a "changeme" e può essere cambiata con una a scelta al primo 
	accesso al conto. Finche' la password non è stata cambiata:

		a. non possono essere fatte operazioni;

		b. non si può effettuare il login nel conto.

		
2. Operazioni sui conti

Le operazioni sui conti devono essere svolte tramite la banca. La banca contiene 0...n conti dei diversi tipi, ognuno identificato 

dal suo iban. Su ogni conto deve essere possibile:

	eseguire un’operazione (aggiungere o togliere denaro)

	richiedere il saldo e l'iban

	stampare i dettagli del conto (CF intestatario, iban e saldo).

	
3. Accrediti/Domiciliazioni

Ad ogni conto, tramite la banca, è possibile associare degli (O...n) Accountable. Ogni Accountable definisce una cifra da accreditare

 (es. uno stipendio) o da pagare (es. un abbonamento pay-tv) alla fine di ogni mese.

Sarà compito della banca eseguire l'operazione di fine mese su tutti i conti registrati e scalare/accreditare le cifre definite dalla lista 

 di Accountable associata ad ogni conto.

	Attenzione a come si gestiscono le operazioni a fine mese

	Attenzione al conto deposito