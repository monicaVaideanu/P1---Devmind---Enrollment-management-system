# P1---Devmind---Enrollment-management-system

Specificații tehnice
Aplicația va fi alcătuită din 3 părți componente:

o reprezentare a unui participant - clasa Guest
o clasă care implementează gestiunea listei de participanți - clasa GuestsList
o clasă principală, care reprezintă motorul aplicației. Aceasta va accepta comenzi de la utilizator, va efectua acțiunile potrivite asupra listelor de participare și va răspunde la interogări - clasa Main

Class 'Guest'
Un invitat va fi definit în sistem prin următoarele câmpuri, aferente Formularului de înscriere la eveniment:

last name / first name / email /phone number
În funcție de acțiunile necesare în cadrul aplicației, va trebui să implementezi un set de metode aferente clasei Guest. 

Class 'GuestsList'

Această clasă va ține evidența înscrierilor la un eveniment. Prin urmare, va conține (cel puțin) următoarele detalii: numărul de locuri disponibile la eveniment (i.e. număr oferit la inițializare), lista de participanți și persoane aflate în așteptare.

Clasa va implementa următoarele funcționalități:

1. adăugarea unei noi persoane (înscrise)

căutarea persoanei se poate face după:    lastName și firstName SAU email SAU phoneNumber
la adăugare, persoana înscrisă va fi notificată corespunzător, în funcție de lista în care a fost înscrisă:
Obs: notificarea se face prin afișarea la tastatură a unui mesaj simplu:
 * confirmare participare → Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.
 * lista de așteptare → Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <X>. Te vom notifica daca un loc devine disponibil.
metoda va returna o valoare întreagă, astfel:
-1 - dacă persoana a fost deja înscrisă la eveniment
0 - dacă a primit un loc la eveniment
X - dacă persoana este pe locul X în lista de așteptare

2. determină dacă o persoană este înscrisă la eveniment (în oricare listă)
3. eliminarea unei persoane (înscrise)
4. actualizarea detaliilor unei persoane înscrise
5. obținerea listei de persoane care au loc la eveniment (i.e. lista de participare)
6. obținerea listei de persoane din lista de așteptare
7. obținerea numărului de locuri disponibile
8. obținerea numărului de persoane participante (i.e. aflate în lista de participare)
9. obținerea numărului de persoane din lista de așteptare
10. obținerea numărului total de persoane
11. căutare parțială, după un subșir de caractere: metoda primește ca parametru un șir de caractere. Acesta este căutat oriunde în cadrul contactului (i.e. în fiecare câmp, începând cu orice poziție).

Class 'Main'

Functionalitate:
Similar cu orice aplicație modernă, folosită în linia de comandă, sistemul de gestiune al înscrierilor va oferi utilizatorului un set de comenzi posibile și o comandă de închidere a aplicației. 
Programul va primi comenzi (și va răspunde, pe rând, fiecărei comenzi în parte) până la primirea comenzii de închidere. Setul de comenzi pe care programul îl poate primi este prezentat în continuare. Se observă faptul că acestea sunt în conformitate cu acțiunile implementate de clasa GuestsList, 
prin urmare implementarea acestora se va baza pe apelarea metodelor clasei GuestsList.

Setul de comenzi:
    help         - Afiseaza aceasta lista de comenzi
    add          - Adauga o noua persoana (inscriere)
    check        - Verifica daca o persoana este inscrisa la eveniment
    remove       - Sterge o persoana existenta din lista
    update       - Actualizeaza detaliile unei persoane
    guests       - Lista de persoane care participa la eveniment
    waitlist     - Persoanele din lista de asteptare
    available    - Numarul de locuri libere
    guests_no    - Numarul de persoane care participa la eveniment
    waitlist_no  - Numarul de persoane din lista de asteptare
    subscribe_no - Numarul total de persoane inscrise
    search       - Cauta toti invitatii conform sirului de caractere introdus
    quit         - Inchide aplicatia
