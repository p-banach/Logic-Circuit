Logic Circuit

Obwód logiczny to obiekt matematyczny składający się z bramek połączonych drutami. 
Każda bramka wartościuje się do wartości prawda lub fałsz, dochodzi do niej pewna liczba drutów wejściowych i wychodzi zeń pewna liczba drutów wyjściowych. 
Obwód składa się z następujących typów bramek:
  (1) Bramki wejściowe: bramki bez drutów wejściowych, ustawiane na początku na pewną konkretną wartość boolowską.
  (2) Bramki AND: bramki z nieujemną (lecz dowolnie dużą) liczbą drutów wejściowych. Wartość bramki ustawia się na koniunkcję (logiczne AND) wartości bramek podłączonych drutami wejściowymi.
  (3) Bramki OR: tak samo jak AND, tylko dysjunkcja (logiczny OR) zamiast AND.
  (4) Bramki NOT: bramki z jednym drutem wejściowym, ustawiające się na negację bramki podłączonej tym drutem.
Można sobie wyobrażać też inne bramki, na przykład:
  (5) Bramki PARITY: ustawiają się na true wtedy i tylko wtedy gdy nieparzyście wiele wejściowych bramek ustawia się na true.
  (6) Bramki MAJORITY: ustawiają się na true wtedy i tylko wtedy gdy ścisła większość bramek wejściowych ustawi się na true.

Obwód logiczny ma jedną wyszczególnioną bramkę wyjściową, której wartość dla danego wejścia rozumiemy jako wartość wynikową całego obwodu. 
W ten sposób obwód definiuje nam funkcję z ciągów wartości boolowskich jakie wkładamy na bramkach wejściowych w pojedyńczą wartość boolowską na bramce wyjściowej. 
Możesz założyć, że w budowanych obwodach nie będzie cykli (tzn. nie trzeba tego sprawdzać w czasie budowy). 
Więcej informacji o obwodach można znaleźć na http://en.wikipedia.org/wiki/Logic_gate oraz http://en.wikipedia.org/wiki/Circuit_complexity .

Proszę zaplanować i zaimplementować hierarchię klas pozwalającą na konstrukcję takich obwodów logicznych. Docelowo, powinna być klasa Circuit, która oferuje następujące metody:
  (1) inputLength() : ilość bramek wejściowych.
  (2) depth() : głębokość obwodu, rozumiana jako długość najdłuższej ścieżki od bramki wyjściowej do jakiejkolwiek bramki wejściowej.
  (3) size() : ilość bramek w obwodzie (można założyć, że każda bramka znajduje się pod bramką wyjściową).
  (4) evaluate(boolean[] input) : wartość wynikowa obwodu dla wartości zapisanych w tablicy input wstawionych do bramek wejściowych.
UWAGA: metody te powinny się liczyć w czasie co najwyżej *liniowym* od wielkości obwodu (liczby drutów). Proszę uważać, żeby złożoność nie stała się wykładnicza przez niespamiętywanie wyników.

Proszę napisać kilka prostych przykładów pokazujących, że rozwiązanie działa. 
