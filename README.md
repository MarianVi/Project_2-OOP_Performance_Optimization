Exercițiu - Obținerea detaliilor numărului
Prezentare generală

Implementează o clasă, numită LazyNumberDetails, a căror obiecte stochează fiecare un număr natural și oferă utilizatorului (obiectului respectiv) următoarele detalii despre numărul stocat:

    Este un număr prim?
    Este un număr perfect?
    Este un număr magic?

Toate cele 3 operații implementate de clasă sunt considerate a fi operații intens computaționale. Prin urmare, acestea trebuie efectuate de un număr cât mai mic de ori, doar atunci când este strict necesar. Devenind treptat un programator din ce în ce mai iscusit, pasionat și determinat, sarcina ta este să realizezi o implementare eficientă a clasei LazyNumberDetails, care integrează cele două mecanisme puternice de optimizare: Lazy evaluation și Caching.

Concret, clasa LazyNumberDetails va conține cel puțin următoarele câmpuri și metode:

LazyNumberDetails.java

    public class LazyNumberDetails {
      private int number;
     
      public LazyNumberDetails(int number) {...}
     
      public void updateNumber(int number) {...}
     
      public boolean isPrime() {...}
      public boolean isPerfect() {...}
      public boolean isMagic() {...}
    }

Metodele publice prezentate în schița anterioară sunt doar cele care vor fi apelate de utilizator. În cadrul implementării, va trebui să definești orice alte metode și câmpuri necesare pentru a respecta funcționalitatea cerută, detaliată în continuare.
Funcționalitate

Un obiect de tip LazyNumberDetails va conține întotdeauna un număr natural (i.e. câmpul number) despre care va răspunde, prin intermediul metodelor publice, la intrebările aferente (i.e. isPrime?, isPerfect?, isMagic?).

Numărul respectiv este primit (obligatoriu) la construirea obiectului, iar acesta poate fi schimbat (oricând) pe parcursul programului de către utilizatorul obiectului, folosind metoda updateNumber(int). Din momentul în care numărul intern a fost schimbat, toate metodele de interogare (i.e. isPrime?, isPerfect?, isMagic?) vor returna rezultate aferente noii valori. Cu alte cuvinte, metodele de interogare vor afișa mereu informații actualizate, despre ultimul / cel mai recent număr stocat.
Optimalitate

Deoarece toate cele 3 interogări (i.e. isPrime?, isPerfect?, isMagic?) sunt considerate operații costisitoare, acestea trebuie executate de un număr minim de ori. Acest lucru va fi asigurat prin implementarea celor două modele de optimizare:

    Modelul Lazy evaluation asigură faptul că oricare algoritm intens computațional
      este executat doar dacă / atunci când utilizatorul solicită rezultatul.
    Mecanismul de Caching realizează stocarea rezultatului pentru oricare algoritm intens computațional
      (i.e. după execuția acestuia). Astfel, rezultatul memorat este disponibil pe viitor, dacă utilizatorul
      efectuează din nou aceeași interogare, și poate fi returnat direct (i.e. fără a executa din nou algoritmul în cauză).

Exemplu de rulare

Să consideram un scenariu concret de rulare, pentru a înțelege mai bine funcționarea obiectelor clasei:

LazyNumberDetails lnd;\
lnd = new LazyNumberDetails(23); // (1) **none (lazy eval.)** -> no user action\
 
    // User instruction        |    What happens?            |  Explanation       
    lnd.updateNumber(10); // (2)  **none (lazy eval.)**    -> no user action
    lnd.updateNumber(17); // (3)  **none (lazy eval.)**    -> no user action
    lnd.isPrime();        // (4)  !!intensiveComputation!! -> prime algorithm for 17
    lnd.isPrime();        // (5)  **cached**               -> saved result from prime alg
    lnd.updateNumber(28); // (6)  **none (lazy eval.)**    -> no user action
    lnd.isPerfect();      // (7)  !!intensiveComputation!! -> perfect algorithm for 28
    lnd.isPrime();        // (8)  !!intensiveComputation!! -> prime algorithm for 28
    lnd.isPerfect();      // (9)  **cached**               -> saved result from perfect alg
    lnd.isMagic();        // (10) !!intensiveComputation!! -> magic algorithm for 28
    lnd.isPrime();        // (11) **cached**               -> saved result from prime alg
    lnd.updateNumber(12); // (12) **none (lazy eval.)**    -> no user action
    lnd.isMagic();        // (13) !!intensiveComputation!! -> magic algorithm for 12
    lnd.isMagic();        // (14) **cached**               -> saved result from magic alg
    ...
