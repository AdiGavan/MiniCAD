"Copyright [2017] Gavan Adrian-George, 324CA"
Nume, prenume: Gavan, Adrian-George
Grupa, seria: 324CA

Tema 2 - MiniCAD

Prezentarea implementarii
=========================

Consider ca cele 3 pattern-uri (Singleton, Factory si Visitor) au fost corect
implementate.
Pattern-ul Singleton a fost implementat cu ajutorul clasei ShapeFactory, pentru
ca este necesara o singura instanta a acestei clase. ShapeFactory nu poate fi
instantiata, dar contine o metoda statica ce returneaza o instanta de tipul
ShapeFactory.
Pattern-ul Factory a fost implementat cu ajutorul interfetei Factory, clasei
ShapeFactory ce implementeaza interfata si creeaza formele si clasa enum
Strategy.
Pattern-ul Visitor a fost implementat cu ajutorul intefetelor Visitor si
Visitable, cu ajutorul clasei Shape (si inclusiv toate clasele ce repretinza o
forma care extind clasa Shape) ce implementeaza Visitable si cu ajutorul clasei
DrawVisitor ce implementeaza Visitor si reprezinta un vizitator care deseneaza
si umple formele.

A. Clase utilizate (toate clasele sunt detaliate si in codurile sursa):

1. In radacina
a) Clasa Main:
- Clasa Main reprezinta entry-point-ul programului.
- Clasa Main prezinta metoda "main" ce primeste ca parametru fisierul de
input.
- Se citeste numarul total de forme din fisier. Se initializeaza un vizitator
drawVisitor(pentru desenarea figurilor) si un ShapeFactory care creeaza
formele. Se initializeaza Canvas-ul (prima figura va fi mereu Canvas-ul) si
acesta primeste vizitatorul drawVisitor. Se realizeaza un loop in care, pentru
fiecare linie in parte, se initializeaza forma folosind factory-ul si fiecare
noua figura accepta vizitatorul drawVisitor v (pentru a fi desenata). Dupa ce
toate figurile au fost reprezentate pe canvas, se apeleaza metoda createImage()
din Canvas care realizeaza fisierul PNG.

2. Pachetul interfaces
a) Interfata Factory:
- Interfata care contine metoda de creare a formelor.
- Interfata este utilizata pentru implementarea pattern-ului Factory.

b) Interfata Visitable:
- Interfata este utilizata pentru a putea accepta un Visitor.
- Interfata este utilizata pentru implementarea pattern-ului Visitor.

c) Interfata Visitor:
- Interfata este utilizata pentru ca visitor-ul sa poate vizita o forma.
- Interfata este utilizata pentru implementarea pattern-ului Visitor.

3. Pachetul shapes (pachetul contine aproape tot ce are legatura cu crearea si
desenarea formelor: formele, factory-ul si vizitatorul ce deseneaza formele)
a) Clasa Shape:
- Clasa Shape contine campuri si metode generale pentru fiecare forma.
- Aceasta clasa implementeaza Visitable, pentru a realiza pattern-ul Visitor.
- Contine metoda accept (pe care toate clasele o vor spurascrie pentru a
putea accepta un Visitor).
- O metoda importanta este metoda calcRGBA, care primeste variabila de tipul
FileReader, parseaza datele pentru fiecare culoare din RGB si Alpha "A",
calculeaza RGBA-ul folosind clasa Color din Java si returneaza RGBA-ul.
- Metoda createImage este folosita doar de clasa Canvas pentru a crea fisierul
drawing.png.

b) Clasele Canvas, Line, Square, Rectangle, Circle, Triangle, Diamond si
Polygon:
- Aceste clase mostenesc clasa abstracta Shape, suprascriu metoda visitor si
contin campurile si metodele specifice fiecarei clase in parte (toate campurile
au fost detaliate in codurile sursa). Clasa Canvas utilizeaza si metoda
createImage pentru a realiza fisierul PNG. Fiecare constructor primeste, pe
langa numale formei, o variabila de tipul FileReader astfel incat fiecare clasa
isi citeste datele din fisierul de intrare in constructor si isi atribuie
datele campurilor corespunzatoare. Modul de parsare al datelor a fost descris
in codurile sursa (modul de parsare difera de la forma la forma).

c) Clasa ShapeFactory:
- Clasa ShapeFactory implementeaza interfata Factory si este utilizata pentru
crearea formelor.
- Aceasta clasa utilizeaza Singleton Pattern, pentru ca este nevoie de o
singura instanta a clasei ShapeFactory.
- Metoda createShape primeste numele formei si variabila de tipul FileReader,
compara numele formei cu campurile din clasa enum Strategy si initializeaza
forma corespunzatoare.
- Conform Singleton Pattern, clasa nu poate fi instantiata, asa ca aceasta
contine o instanta de tipul ShapeFactory si o metoda prin care poate returna
aceasta instanta.

d) Clasele Strategy si StructPoint:
- Clasa Strategy este o clasa de tipul enum folosita de catre ShapeFactory
pentru crearea formelor.
- Clasa StructPoint este o clasa in care se retin coordonatele unui punct.

e) Clasa drawVisitor:
- Clasa DrawVisitor represinta un visitor (pentru pattern-ul Visitor) si
realizeaza desenarea formelor, in functie de tipul fiecareia. Clasa contine
metoda visit pentru fiecare tip de forma (overload).
- Metoda visit va apela algoritmul pentru desenarea conturului si algoritmul
de desenare specific fiecarei forme in parte (din pachetul utils).

4. Pachetul utils
a) Clasa Algoritms:
- Clasa contine algoritmii pentru desenarea contururilor formelor.
- Metoda bresenhamAlgLine reprezinta algoritmul pentru desenarea unei linii din
cerinta temei.
- Metodele rectangleAlg si squareAlg fac acelasi lucru: traseaza liniile
formelor cu ajutorul for-urilor, liniile fiind perfect drepte. squareAlg
apeleaza metoda rectangleAlg, diferenta fiind ca in loc de 2 dimensiuni
diferite pentru laturi, acesta are aceeasi dimensiune pentru laturi.
- Metoda bresenhamAlgCircle reprezinta algoritmul pentru desenarea conturului
unui cerc din referinta cerintei.
- Metodele polygonAlg, triangleAlg si diamondAlg fac acelasi lucru. polygonAlg
trece prin lista de puncte si foloseste bresenhamAlgLine pentru a trasa o linie
intre 2 puncte. La final, se traseaza si linia dintre ultimul punct si primul.
triangleAlg apeleaza metoda polygonAlg. diamondAlg face acelasi lucru ca si
polygonAlg, doar ca traseaza ultima linie din primul punct in ultimul.
- exitCanvas este utilizata pentru a vedea daca punctul (X,Y) este in Canvas.

b) Clasa Color:
- Clasa Color contine algoritmii folositi pentru umplerea formelor.
- Metodele colorRectangle si colorSquare fac acelasi lucru. colorRectangle
utilizeaza 2 for-uri pentru a trece prin fiecare pixel din interiorul
dreptunghiului (nu si prin pixelii din contur). Se verifica daca pixelul este
in Canvas. Daca este in Canvas, se coloreaza. colorSquare face acelasi lucru,
diferenta fiind ca laturile au aceeasi dimensiune, asa ca colorSquare va apela
metoda colorRectangle (va trimite ca parametrii de 2 ori variabile dimensionL).
- Metoda floodFill este utilizata de Polygon, Triangle, Circle si Diamond
pentru a colora forma. Se foloseste flood fill cu 4 directii. Se adauga punctul
care este verificat in stiva. Cat timp stiva nu este goala, se iau pe rand
punctele din stiva si se verifica daca punctul trebuie colorat. Daca da, atunci
se coloreaza punctul si se adauga cele 4 puncte din jurul punctului curent in
stiva.

B. Algoritmul utilizat:
- Se retine numarul total de forme.
- Se initializeaza un DrawShape si un ShapeFactory.
- Cu ajutorul factory-ului se instantiaza si se retine Canvas-ul
(va fi mereu primul) si acesta va accepta vizitatorul DrawShape (pentru a se
colora Canvas-ul).
- Pentru fiecare forma se apeleaza metoda createShape din factory pentru a
realiza Shape-ul dorit. Apoi forma nou creata accepta vizitatorul DrawShape.
Vizitatorul va apela algoritmii pentru contur si pentru umplere (din utils)
specifici fiecarei forme.
- Dupa ce au fost desenate toate formele, se apeleaza metoda createImage din
clasa Canvas, pentru a se realiza fisierul drawing.png.
