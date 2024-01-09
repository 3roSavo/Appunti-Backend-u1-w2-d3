import entities.InverterString;
import entities.User;
import functional_interfaces.StringModifierOneParams;
import functional_interfaces.StringModifierTwoParams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] strs) {

        // Come aggiungiamo elementi alla creazione di una istanza List?
        // TODO: Manipolazione delle List
        List<String> proveStringhe = new ArrayList<>();
        proveStringhe.add("telefono");
        proveStringhe.add("cellulare");
        proveStringhe.add("smartphone");
        System.out.println(proveStringhe);

        // però ci sono metodi più veloci e immediati per aggiungere elementi direttamente alla creazione dell'istanza!
        // con Arrays.asList() e List.of() posso convertire un array o una sequenza di elementi in una lista
        // TODO: Arrays.asList() VS List.of()

        // Proviamo con Arrays.asList() ad aggiungere una sequenza di elementi direttamente alla creazione dell'istanza
        List<String> listaSpesa = Arrays.asList("pane", "latte", "farina", "uova");
        // Però in questo caso la lista sarà IMMUTABILE in lunghezza, cioè non potrò aggiungere o rimuovere elementi, solo modificarli
        listaSpesa.set(1, "formaggio"); // l'importante è che rimanga invariato il n° di elementi!
        System.out.println("lista spesa: " + listaSpesa);



        // Proviamo invece con List.of()
        List<String> words = List.of("prova", "ciaone", "cucu");
        // words.add("ciao");  ERRORE, List.of() crea liste immutabili nella loro lunghezza
        //words.set(1, "weee"); ERRORE, List.of() crea liste immutabili anche nella modifica di un elemento
        System.out.println(words);

        // Vediamo il caso di un ARRAY da convertire

        Double[] arrayVoti = {5.0, 7.5, 9.0, 6.0};
        System.out.println(arrayVoti[1]);
        List<Double> voti = Arrays.asList(arrayVoti); // IMMUTABILE
        // utilizzando Arrays.asList su un primitivo come double dovrai sostituirlo con Double (Double[] arrayVoti)
        // perché non è presente alcun controllo sul tipo del primitivo, quindi dovrai fare tu stesso attenzione alla tipizzazione
        System.out.println(voti);

        Integer[] arrayVotiInteri = {5, 7, 9, 6};
        // anche qui sostituisco la tipizzazione da int a Integer così la List non si lamenta del tipo
        List<Integer> votiInteri = Arrays.asList(arrayVotiInteri); // IMMUTABILE
        System.out.println(votiInteri);

        // Esempio con List.of()
        Integer[] arrayOfNumbers = {32,23,72};
        List<Integer> numeriCasualii = List.of(arrayOfNumbers); // IMMUTABILE
        System.out.println(numeriCasualii);

        // Ecco una prova con un array di stringhe
        String[] proveee = {"bowgiorno", "codroipo", "rick sanchez"};
        List<String> listaACaso = Arrays.asList(proveee); // IMMUTABILE
        System.out.println( "lista a caso: " + listaACaso);

        // Ok ma nel caso volessi creare liste MUTABILI?
        // TODO: Liste MUTABILI

        // Nel caso avessi voluto crearmi una List MUTABILE con un contenuto iniziale già stabilito sarebbe
        // bastato creare un'istanza di arrayList e usarci dentro le tonde Arrays.asList() oppure List.of()
        // con dentro la sequenza di elementi o array da utilizzare

        // Proviamo con Arrays.asList()
        List<String> listaSpesa2 = new ArrayList<>(Arrays.asList("pane", "latte", "farina", "uova"));
        listaSpesa2.add("C3PO");
        listaSpesa2.add("R2D2");
        listaSpesa2.remove(2);
        System.out.println("listaSpesa2: " + listaSpesa2);

        // Proviamo anche con List.of()
        List<String> listaSpesa3 = new ArrayList<>(List.of("dolci", "biscotti", "caffè"));
        listaSpesa3.add("mele");
        listaSpesa3.remove("dolci");
        System.out.println( "listaSpesa3: " + listaSpesa3);


        //Altro esempio con List.of()
        List<String> parole;
        parole = new ArrayList<>(List.of("ciao", "salut", "hello"));
        // qui stiamo creando una istanza di arrayList a partire da una lista creata da una sequenza di elementi col metodo List.of()
        // il metodo List.of() genera liste IMMUTABILI ma viene dichiarata all'interno di un arrayList
        // così facendo la lista derivante sarà totalmente MUTABILE
        parole.add("buongiorno");
        parole.remove(3);
        parole.remove(2);
        parole.set(1,"hi");
        System.out.println(parole.size());
        System.out.println(parole);

        List<String> hhhhh = Arrays.asList("lala", "lola", "lula");
        hhhhh.set(1, "bibi"); // puoi settare un elemento con Arrays.asList() ma NON con List.of()
        System.out.println(hhhhh);

        // TODO: Manipolazione delle Map
        Map<String, Integer> eta = new HashMap<>();
        eta.put("giovanni", 34);
        eta.put("marco", 26);
        eta.put("giada", 37);
        // metodo keySet()
        System.out.println("keySet() = " + eta.keySet());

        System.out.println(eta);

        // metodo isEmpty()
        System.out.println("isEmpty() = " + eta.isEmpty());

        // Proviamo ora ad aggiungere elementi direttamente alla creazione dell'istanza
        Map<String, Integer> booh = new HashMap<>() {{
            put("Mattia", 23);
            put("Luisa", 35);
            put("Gabriele", 54);
        }};
        // sto inizializzando la mia collection Map booh subito alla creazione dell'istanza, attraverso doppie
        // graffe e metodo put. È MUTABILE, ricordati invece che con list.of, set.of e map.of è IMMUTABILE
        System.out.println("----" + booh);

        // TODO: Metodo replace()
        eta.replace("marco", 19);
        // naturalmente replace() modifica il valore, NON la chiave. Non si può modificare direttamente la chiave.
        System.out.println(eta);
        System.out.println("---------------------");
          eta.forEach((name, age) -> {
             System.out.println("Nome : " + name + ", Età : " + age);
        });
          // qui aprendo le graffe non serve il return perché il forEach() è una funzione che ritorna void!

        // TODO: Metodo replaceAll()
        eta.replaceAll((name, oldAge) -> name.equals("marco") ? oldAge : oldAge + 5);
        System.out.println(eta);
        eta.replaceAll((name, oldAge) -> oldAge + 10);
        System.out.println(eta);

        Map<String , Integer> nuoveEta = new HashMap<>();
        // qui riempio nuoveEta con le chiavi/valore di eta, però ci faccio delle modifiche
        eta.forEach((name, age) -> nuoveEta.put("Ciao " + name, age + 50));
        System.out.println(nuoveEta);

        System.out.println("-------------------------------------------------------------");
        // ---------------------------------------------------------------------------------

        // TODO: INTERFACCE FUNZIONALI
        // Ci sono molte INTERFACCE FUNZIONALI già presenti in java (Runnable, Predicate, Supplier ecc), ma proviamo a crearne una custom

        // TODO: INTERFACCE CUSTOM
        String paperone = "Zio Paperone";
        String bersani = "Pierluigi Bersani";

        // Dopo aver creato la mia interfaccia funzionale a parte con un metodo astratto
        // senza il corpo ne definisco il comportamento proprio qui
        StringModifierTwoParams wrapped = (str1, str2) -> "------" + str1 + "------" + str2;
        StringModifierTwoParams comparazione = (str1, str2) -> str2 + " è più povero di " + str1;
        System.out.println(wrapped.modify(paperone, bersani));
        System.out.println(comparazione.modify(paperone, bersani));
        // la peculiarità sta proprio nel fatto che posso crearmi quanti metodi personalizzati voglio senza dover
        // necessariamente creare classi per ogni esigenza e istanziare oggetti ogni volta.

        // Metodo che inverte una stringa data (mi faccio un'altra interfaccia funzionale che accetti un solo parametro)

        StringModifierOneParams inverter = str -> {
            String[] word = str.split("");
            String invertedWord = "";
            for (int i = word.length -1; i >= 0; i--) {
                invertedWord = invertedWord + word[i];
            }
            return invertedWord;
        };
        System.out.println(inverter.modify("CIAO"));

        // TODO: OLDSTYLE con CLASSI, senza interfacce

        // creo la classe InverterString con il metodo di cui ho bisogno,
        // poi creata l'istanza invoco su di essa il metodo
        // il problema è che se avessi bisogno di un altro metodo
        // per modificare le stringhe dovrei farmi una nuova classe
        InverterString parola = new InverterString();
        System.out.println(parola.modify("EROS"));


        // TODO: INTERFACCE FUNZIONALI INCLUSE IN JAVA
        System.out.println("INTERFACCE DI JAVA (PREDICATE)");

        // TODO: PREDICATE

        Predicate<Integer> isMoreThanZero = num -> num > 0;
        System.out.println("il numero è maggiore di 0? " + isMoreThanZero.test(12));

        Predicate<Integer> isLessThanZero = num -> num < 0;
        System.out.println("il numero è minore di 0? " + isLessThanZero.test(12));

        Predicate<Integer> isLessThanHundred = num -> num < 100;
        System.out.println("il numero è minore di 100? " + isLessThanHundred.test(120));

        // Possiamo anche concatenare i predicate!

        Predicate<Integer> traZeroECentoSenza60 = isMoreThanZero.and(isLessThanHundred).and(num -> num != 60);
        int num = 120; // perché qui non mi crea problemi il tipo Integer col tipo int? per la presenza di
                      // un meccanismo noto come autoboxing e unboxing in Java. Se ti ricordi questo
                      // non vale per Arrays.asList(), dove devo opportunamente tenere d'occhio il tipo di primitivo
        System.out.println("il numero " + num + " è compreso tra 0 e 100 ed è diverso da 60? " + traZeroECentoSenza60.test(num));

        System.out.println(isMoreThanZero.and(isLessThanHundred).negate().test(90)); // qui nega il risultato

        System.out.println(isMoreThanZero.and(isLessThanHundred).and(num1 -> num1 != 34).test(39));

        Predicate<String> containString = str -> str.toLowerCase().contains("eros");
        System.out.println(containString.test("ciao mi chiamo erosa"));

        // TODO: SUPPLIER
        System.out.println("------------ESEMPIO SUPPLIER------------");
        Supplier<String> saluto = () -> "Ciao!!!";
        System.out.println(saluto.get());

        Supplier<Integer> integerSupplier = () -> {
            Random rndm = new Random();
            return rndm.nextInt(0, 101);
        };

        Supplier<User> userSupplier = () -> new User("Nome", "Cognome", integerSupplier.get());

        List<Integer> numbersList = new ArrayList<>();   // prenderò come riferimento questa lista anche per gli streams
        List<User> users = new ArrayList<>();            // prenderò come riferimento questa lista anche per gli streams

        for (int i = 0; i < 100; i++) {
            numbersList.add(integerSupplier.get());
            users.add(userSupplier.get());
        }

        // TODO: CONSUMER
        System.out.println("---------ESEMPIO CONSUMER-------------");
        Consumer<Integer> incrementoDiDue = number -> System.out.println(number + " + 2 = " + (number + 2));
        incrementoDiDue.accept(8);

        // PICCOLA RINFRESCATA....
        // TODO: GLI ITERATORS
        // servono per modificare in corsa una collection, cioè consentono di attraversare sequenzialmente la lista,
        // per esempio durante un ciclo, ottenendo appunto la possibilità di eseguire operazioni di accesso, rimozione
        // e verifica della presenza di elementi all'interno della collection. Non puoi farlo con un forEach
        // perché è di sola lettura, mentre puoi con un iterator.
        // PRINCIPALI METODI OTTENIBILI CON gli ITERATORS
        // 1) boolean hasNext(): Restituisce true se c'è almeno un altro elemento nella sequenza, altrimenti restituisce false.
        // 2) E next(): Restituisce l'elemento successivo nella sequenza. Se non ci sono altri elementi, lancia
        // un'eccezione NoSuchElementException.
        // 3) void remove(): Rimuove l'ultimo elemento restituito dalla collezione associata all'iteratore.
        // Questo metodo può essere chiamato solo una volta dopo una chiamata a next() e non può essere chiamato
        // più volte consecutive senza una chiamata intermedia a next().

        // ESEMPIO
        String[] sese = {"qwerty", "bonjour"};
        List<String> stringList = new ArrayList<>();
        List<String> listaStringhe = new ArrayList<>(List.of("cane", "gatto")); // MUTABILE!! creo una List mutabile a partire
                                                                     // da un'array o sequenza di elementi IMMUTABILE!

        listaStringhe.add("cammello");
        listaStringhe.add("giustino");
        listaStringhe.remove("gatto");
        System.out.println(listaStringhe);

        List<String> ggggg = List.of("weee", "ciaone", "bulabulabula"); // IMMUTABILE


        stringList.add("Uno");
        stringList.add("Due");
        stringList.add("Tre");
        stringList.add("Quattro");

        // Utilizzo di un iteratore per rimuovere elementi che iniziano con la lettera "T"
        Iterator<String> iterator = stringList.iterator();

        // hasNext(): Questo metodo restituisce true se ci sono ancora elementi nella sequenza,
        // altrimenti restituisce false. Viene spesso utilizzato come condizione di uscita da
        // un ciclo mentre si attraversa la collezione.
        // next(): Questo metodo restituisce l'elemento successivo nella sequenza e sposta
        // l'iteratore alla posizione successiva. È comunemente chiamato dopo hasNext() per
        // ottenere e processare l'elemento corrente.

        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.startsWith("T")) {
                iterator.remove();
            }
        }
        // Stampa la lista dopo la rimozione
        System.out.println("Lista dopo la rimozione: " + stringList);


        // TODO: STREAMS------
        System.out.println("---------------STREAMS----------------");

        // TODO: STREAM map()
        System.out.println(users.stream().map(user -> user.getSurname()).toList());
        System.out.println(users.stream().map(user -> user.getAge()).toList());
        System.out.println(users.stream().map(user -> user.getId()).toList());
        System.out.println(users.stream().map(user -> user.getName()).toList());

        Stream<Integer> streamAdds =  numbersList.stream().map(nums -> nums + 100);
        //streamAdds.forEach(numero -> System.out.println(numero));
        // oppure con un solo print line
        System.out.println("stream mappato aggiungendo 100 ad ogni elemento e terminato in lista = " + streamAdds.collect(Collectors.toList()));

        // proviamo invece a raccogliere gli elementi in una lista e stamparla
        // ATTENZIONE, abbiamo già consumato il nostro stream (streamAdds), quindi devo crearne uno nuovo
        Stream<Integer> transformedList = numbersList.stream().map(numero -> numero + 1000).filter(n -> n > 1080);
        System.out.println("stream mappato, filtrato e trasformato in lista: " + transformedList.collect(Collectors.toList()));
        // forma abbreviata da java 16 in poi = transformedList.toList()

        // TODO: STREAM filter()
        System.out.println("-------------FILTER SU STREAM--------------");

        users.stream().filter(user -> user.getAge() < 10).forEach(user -> System.out.println(user));

        List<Integer> numeriACaso = new ArrayList<>(List.of(32,85,93,22,12,54,74,19));
        Stream<String> stream = numeriACaso.stream().map(numerii -> "numero: " + numerii );
        stream.forEach(stringa -> System.out.println(stringa));

        List<String> listaRandom = new ArrayList<>(List.of("parola", "frase", "espressioni", "verbi", "esperto"));

        List<String> ttt = listaRandom.stream().filter(word -> word.contains("es")).toList();
        System.out.println(ttt);
        // ttt.add("ciaoooo"); ERRORE, lista immutabile
        //ttt.set(1, "abbellaa"); ERRORE, lista immutabile
        // Per la mutabilità avrei dovuto creare un'istanza arrayList per ttt!
        // cioè: List<String> ttt = new ArrayList<>(listaRandom.stream().filter(word -> word.contains("es")).toList());
        Stream<String> provaRandom = listaRandom.stream().filter(word -> word.contains("es"));
        provaRandom.forEach(elem -> System.out.println(elem)); // ecco chiuso lo stream con un forEach()
        listaRandom.add("espropriato");
        //System.out.println("filtro per 'es': " + ttt);
        Stream<Integer> streamNumbers = Stream.of(2,1,43,89); // è una variante di List.of() Set.of() ecc...


        users.stream().filter(user -> user.getAge() < 18).forEach(user -> System.out.println(user.getAge()));
        // così ottengo tutte le età della lista users sotto i 18 anni
        // facciamo ora la stessa cosa con gli id ma conserviamo i valori in una lista
        List<Integer> usersIdListUnder25Years = users.stream().filter(user -> user.getAge() < 25).map(User::getId).toList(); // forma tradizionale = user -> user.getId()
        System.out.println("lista di users-id sotto i 25 anni= " + usersIdListUnder25Years);

        // proviamo a inserire uno stream in un array
        Integer[] etaa = users.stream().filter(user -> user.getAge() > 85).map(User::getAge).toArray(size -> new Integer[size]);
        // Spieghiamo che diavolo succede qui
        // il toArray() accetta una lambda con un parametro, quel parametro conterrà la lunghezza del nostro futuro array,
        // lunghezza determinata dalla quantità di elementi nello stream.
        // Come ritorno viene istanziato l'array della lunghezza stabilita e infine gli
        // elementi dello stream vengono quindi copiati nell'array appena creato.
        System.out.println("elementi dell'array trasformato in lista = " + Arrays.stream(etaa).toList());

        // nel caso volessi stampare senza trasformare in lista posso utilizzare il toString()
        System.out.println("stampa dell'array = " + Arrays.toString(etaa));

        // Facciamo ora un esempio prendendoci un PREDICATE che creiamo al momento, si potrebbero anche riprendere quelli creati in precedenza
        // proviamo anche a stampare il tutto in una singola riga senza creare variabili di tipo stream
        // proviamo inoltre a utilizzare un predicato con uno short circuit per non dover fare due predicati!
        Predicate<Integer> between60And80 = numb -> numb >= 60 && numb <= 80;
        System.out.println(between60And80.test(34));  // qui otteniamo solo un booleano
        System.out.println(numbersList.stream().filter(between60And80).toList()); // qui otteniamo una lista di valori che soddisfano la condizione del predicato

        // ATTENZIONE, spieghiamo meglio come usare gli stream una volta completate le trasformazioni
        // con i metodi intermedi tipo map() e filter().
        // Avremo bisogno di alcuni metodi che terminano lo stream in qualcos'altro, tipo in un primitivo o una lista

        // TODO: Terminatori di streams
        // forEach() -> void type
        // reduce() -> torna UN elemento compatibile con la tipizzazione fornita
        // collect(Collectors.toList()) -> List type
        // toList() -> List type
        // collect(Collectors.joining()) -> String type ??
        // count() -> long
        // toArray() -> array type
        // allMatch() -> boolean type
        // anyMatch() -> boolean type

        // TODO: STREAM reduce()
        // il reduce() è un metodo TERMINATORE degli streams
        // diciamo che la differenza principale con il reduce() di javascript è la posizione dell'identità che
        // in java si mette all'inizio e non alla fine, per identità si intende il valore di partenza del reduce,
        // "" o 0 per esempio. Il secondo parametro del reduce è dato da una lambda che accetta DUE parametri, dove
        // il primo parametro terrà il conteggio dell'operazione per ogni elemento della lista o array che sia,
        // il secondo parametro sarà l'elemento corrente, cioè l'elemento in quel preciso momento preso singolarmente.
        // Il ritorno sarà il risultato dell'operazione di riduzione, che può essere di qualsiasi tipo, ma deve essere
        // coerente con la tipizzazione dichiarata. Con riduzione ci riferiamo al rimpicciolimento,
        // cioè al ridursi di una serie di elementi a un solo elemento.

        List<Integer> numeriCasuali = new ArrayList<>(Arrays.asList(2,7,3));
        //sommiamo tutti gli elementi della lista
        int somma = numeriCasuali.stream().reduce(0, (total, element ) -> total + element);

        // Proviamo a stampare con un nuovo metodo:
        // TODO: Il LOGGER!
        // Logger è uno strumento di registrazione più avanzato rispetto a System.out.println()
        // puoi impostare il tipo di messaggio come .info, .warning, oppure .severe, così si capisce meglio il tipo di problema
        Logger logger = Logger.getLogger(Main.class.getName()); // qui ottengo un'istanza del logger associata alla classe Main, cioè questa classe
        logger.info("Somma: " + somma);

        // Posso anche stampare tanti Logger quanti sono gli elementi all'interno della lista
        numeriCasuali.forEach(numero -> logger.info("forEach() di numeriCasuali = " + numero.toString()));
        // il logger torna una stringa, in questo caso avrei potuto omettere il toString() dato che è concatenato
        // a una stringa e quindi tornerebbe comunque una stringa

        // proviamo ora a utilizzare il reduce per concatenare stringhe
        List<String> lettere = new ArrayList<>(List.of("B","U","O","N","G","I","O","R","N","O"));
        String stringaConcatenata = lettere.stream().reduce("", (stringaParziale, lettera) -> stringaParziale + lettera);
        logger.info("stringa concatenata: " + stringaConcatenata);

        // Proviamo a sommare tutte le età della lista di users col reduce()
        int sommaEta = users.stream().map(user -> user.getAge()).reduce(0, (partialSum, age) -> partialSum + age);
        System.out.println("somma di tutte le età degli users = " + sommaEta);

        // posso addirittura saltare il map! il combiner consente di sommare correttamente i risultati parziali quando si lavora con uno stream di oggetti Integer.
        int sommaEta2 = users.stream().reduce(0, (partialSum, user) -> partialSum + user.getAge(), (a, b) -> a + b);
        System.out.println("somma di tutte le età degli users senza il map = " + sommaEta2);

        // Proviamo ora a stampare un array passando da uno stream. In questo caso dovrai utilizzare Arrays.stream(array)
        // per ottenere uno stream degli elementi presenti in esso.
        String[] array = {"paral", "lelep", "ipedo"};

        // esempio con
        // TODO: count()
        Stream<Integer> listaNumeri;
        listaNumeri = numbersList.stream();
        System.out.println("numero di elementi presenti in listaNumeri : " + listaNumeri.count());
        // .count() è un'operazione terminale degli stream, torna il conteggio degli elementi nello stream
        System.out.println("numero elementi lista : " + numbersList.size() + " = " + numbersList);
        users.forEach(user -> System.out.println(user));

        String concat = Arrays.stream(array).reduce("", (partialString, string) -> partialString + string);

        // Ci sono diversi modi per stampare successivamente a console, vediamoli.

        logger.info("Unione stringa finale con Logger: " + concat); // attraverso il Logger

        Arrays.stream(array).forEach(string -> System.out.println(string));  // qui stampiamo tanti println() quanti sono gli elementi
                                                                             // ricordati che il forEach non ritorna niente, ed è solo in lettura
        // i successivi 4 metodi prendono l'array, lo convertono in lista e stampano
        System.out.println("Arrays.stream(array).toList() = " + Arrays.stream(array).toList());
        System.out.println("Arrays.stream(array).collect(Collectors.toList()) = " + Arrays.stream(array).collect(Collectors.toList()));  // forma lunga (datata)
        // toList() e collect(Collectors.toList() creano liste MUTABILI a differenza degli altri metodi sottostanti

        System.out.println("Arrays.asList(array) = " + Arrays.asList(array));
        System.out.println("List.of(array) = " + List.of(array));

        // TODO: allMatch()
        // corrisponderebbe al metodo every() di javascript

        boolean boooohUsers = users.stream().allMatch(user -> user.getName().equals("Nome"));
        boolean boooh2 = users.stream().allMatch(user -> user.getAge() < 18);
        System.out.println(boooohUsers); // true, tutti gli users si chiamano "Nome"
        System.out.println(boooh2); // false, non tutti gli user hanno più di 18 anni

        // è un metodo utile con un if()
        if (users.stream().allMatch(user -> user.getAge() >= 18)) { // quasi sicuro false
            System.out.println("Tutti gli utenti sono maggiorenni!!!");
        } else {
            System.out.println("NON tutti gli utenti sono maggiorenni :(");
        }
        // ovviamente ci saranno quasi sempre utenti minorenni, ma filtriamo per eliminarli e riproviamo!
        if (users.stream().filter(user -> user.getAge() >= 18).allMatch(user -> user.getAge() >= 18)) { // true per forza!
            System.out.println("Tutti gli utenti sono maggiorenni");
        } else {
            System.out.println("NON tutti gli utenti sono maggiorenni");
        }

        // TODO: anyMatch()
        // corrisponderebbe al metodo some() di javascript

         if (users.stream().anyMatch(user -> user.getAge() > 99)) {
             System.out.println("almeno uno user ha più di 99 anni");
         } else {
             System.out.println("nessun user ha più di 99 anni");
         }


         // ----------------------PROVIAMO A LAVORARE CON LE DATE-------------------------
        System.out.println("--------------------LocalDate()--------------------");
        // TODO: LocalDate()  VS  Date()
        //Date() è deprecato e più complesso da utilizzare, lasciamolo stare
        LocalDate today = LocalDate.now();
         System.out.println("giorno di oggi = " + today);
         // prendiamoci la data di domani
        System.out.println("giorno di oggi + 1 giorno = " + today.plusDays(1));
        // prendiamoci la data di ieri
        System.out.println("giorno di oggi - 1 giorno = " + today.minusDays(1));
        // prendiamoci la data di oggi tra due anno
        System.out.println("giorno di oggi + 1 anno = " + today.plusYears(2));

        LocalDate dataRandom = LocalDate.parse("2022-04-12");

        System.out.println(dataRandom);
        System.out.println(dataRandom.isBefore(today)); // confronta se la data rispetta la condizione e ritorna un boolean
        System.out.println(dataRandom.isAfter(today));
        // otteniamo il giorno del mese
        System.out.println(dataRandom.getDayOfMonth());

        // otteniamo il nome dei giorni/mesi/anni!
        //possiamo farlo con getMonth() ecc...
        //getDisplayName() accetta due parametri, cioè la lunghezza del testo (FULL, SHORT, NARROW) e la lingua.
        System.out.println(dataRandom.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALIAN));
        System.out.println(dataRandom.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ITALIAN));

        // stampiamo tutta la data in parole!
        System.out.println(
                dataRandom + " = "
                        + dataRandom.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ITALIAN) + " "
                        + dataRandom.getDayOfMonth() + " "
                        + dataRandom.getMonth().getDisplayName(TextStyle.FULL, Locale.ITALIAN) + " "
                        + dataRandom.getYear());

        // ma c'è un altro metodo più veloce e logico
        System.out.println("-----metodo semplificato------");

        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(dataRandom));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dataRandom));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(dataRandom));



        // formattiamo una data
        // e invece no, t'arrangi


    }
}
