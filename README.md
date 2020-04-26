# Propozycje projektu

## Symulacja ekosystemu

Symulacja środowiska naturalnego, składającego się ze zwierząt, roślin, etc.

Świat będzie dwuwymiarową siatką. Każda z komórek siatki będzie posiadała pewne właściwości a także będzie mogła
zawierać jakiś organizm (roślinę lub zwierzę).

### Rośliny

<<<<<<< Updated upstream
Rośliny będą ogranizmami bardziej pasywnymi, tzn. będą reagowały na zmiany środowiska w pewnym, tudzież ograniczonym,
=======
>>>>>>> Stashed changes
stopniu, np. jeżeli środowisko będzie miało odpowiednie nasłonecznienie i wilgotność, będą rosnąć; w przeciwnym wypadku,
będą umierać. Będą miały również bardzo ograniczoną możliwość wpływania na środowisko czy inne organizmy.

### Zwierzęta

Elementami wyróżniającymi organizmy zwierzęce będzie przede wszystkim możliwość zmiany swojej pozycji oraz większy
zakres wpływu na swoje środowisko. Zwierzę będzie musiało w sposób aktywny zaspokajać swoje potrzeby fizjologiczne:
głód, odpoczynek, etc. W sposób aktywny, tj. podejmować kroki do osiągnięcia celu, np. szukając pożywienia, unikać
potencjalnych zagrożeń, etc.

Każdy gatunek będzie miał określone statystyki: wytrzymałość, siła i szybkość. Statystyki zwierząt tego samego gatunku
mogą się delikatnie różnić. Jeśli wytrzymałość spadnie do 0 to osobnik umiera. Wytrzymałość można stracić podczas
konfrontacji z innymi zwierzętami oraz można ją odzyskać odpoczywając i jedząc. Siła odpowiada za to jak dobrze zwierze
radzi sobie w walce, a szybkość jak sprawnie przemieszcza się po świecie.
<<<<<<< Updated upstream

Będą różne typy zwierząt różniące się pod wieloma względami: roślinożercy i mięsożercy, samiec i samica, młode i
dorosłe, jak dużo potomstwa będą produkować, jakich strategii będą używać aby przeżyć, etc.

Jeśli wytrzymałość spadnie do 0 to osobnik umiera. Wytrzymałość można stracić podczas konfrontacji z innymi zwierzętami
oraz można ją odzyskać odpoczywając i jedząc. Siła odpowiada za to jak dobrze zwierze radzi sobie w walce, a szybkość
jak sprawnie przemieszcza się po świecie.

#### Gatunki

Organizmy zwierzęce będą dzielić się na **gatunki**. Rozmnażanie będzie się odbywać tylko w obrębie gatunku (brak
crossbreedingu), ponadto gatunek będzie wyznaczał średnie statystyki tego gatunku (można powiedzieć że będzie istniał
_model_ gatunku, o określonych statystykach wg. którego będą generowani przedstawiciele tego gatunku). Statystyki
zwierząt tego samego gatunku będą się różnić, jednak będą to różnice dość małe (+/-5%) w porównaniu do Różnic między
modelami gatunków.

Oprócz tego, gatunki mogą mieć różne wzorce zachowań. Przykładowo: roślinożerca po znalezieniu pożywienia wchodzi np. w
stan `JEDZ`, który polega po prostu przemieszczeniu się w jego kierunku pożywienia i spożyciu go; mięsożerca natomiast
po wypatrzeniu pożywienia (innego zwierzęcia) przejdzie w stan `POLUJ`, w którym zwierzę będzie starało się najpierw
zabić swój cel. Po udanym polowaniu mięsożerca może zjeść swoją zdobycz, w wypadku porażki zwierzę poszuka innego celu.
Z pozoru takie same stany, np. `POLUJ` mogą również różnić się pomiędzy gatunkami, np. gepard będzie polował samotnie,
ale wilki będą polować w grupie, co będzie wymagało koordynacji i kooperacji pomiędzy przedstawicielami gatunku zarówno
podczas polowania, jak i po (dzielenie się pożywieniem).
=======

Będą różne typy zwierząt różniące się pod wieloma względami: roślinożercy i mięsożercy, samiec i samica, młode i
dorosłe, jak dużo potomstwa będą produkować, jakich strategii będą używać aby przeżyć, etc.
>>>>>>> Stashed changes

#### Gatunki

Organizmy zwierzęce będą dzielić się na **gatunki**. Rozmnażanie będzie się odbywać tylko w obrębie gatunku (brak
crossbreedingu). Statystyki potomstwa będą generowane na podstawie statystyk rodziców.

<<<<<<< Updated upstream
### Odrzucone pomysły

System gatunków z którym wyszliśmy na początek, zakładał istnienie **genów** jako obiektu definiującego statystyki
organizmów. Urodzeni przedstawiciele gatunków dziedziczyliby geny po swoich rodzicach. Również występowałyby przy
poczęciu mutacje genów, które zmieniałyby w jakiś sposób statystyki ogranizmu. W ten sposób, można by symulować selekcję
naturalną i w konsekwencji ewolucję organizmów.

Na stan obecny ten system znajduje się poza zakresem i zamiast niego zaimplementowany zostanie prostszy system **modelu
gatunków** wg. którego średnie statystyki gatunku są stałe i nie zmieniają się w czasie. Jego odrzucenie spowodowało
istnienie następujących problemów:

#### Problem #1 - Możemy się nie wyrobić

Ponieważ nie została jeszcze wykonana żadna dokumentacja, a tym bardziej nie została napisana ani jedna linijka kodu,
nie wiemy jak szybko jesteśmy w stanie zaimplementować całą symulację, dlatego w myśl
[zasady 90/90](https://en.wikipedia.org/wiki/Ninety-ninety_rule) **system genów** znajduje się poza zakresem symulacji
do momentu zakończenia całego projektu z prostszym **systemem modeli gatunków**. Jeżeli zostanie trochę czasu oraz
zostaną rozwiązane kluczowe problemy projektowe, system gatunków może zostać zmieniony.

#### Problem #2 - Ewolucja gatunków

Ewolucja zakłada zmianę gatunków w czasie. Jeżeli przedstawiciele danego gatunku np. średnio zwiększają swoją maksymalną
szybkość, to model tego gatunku powinien również zmienić się, aby stale w sposób poprawny opisywać przeciętnego
przedstawiciela gatunku. Mogą również powstawać nowe gatunki, kiedy np. część populacji migruje do nowego środowiska w
którym optymalne do przeżycia statystyki i zachowania są trochę inne. Wówczas nie jest jasne od kiedy ten podzbiór
populacji można nazwać nowym gatunkiem oraz czy powinien zachować lub stracić kompatybilność reprodukcyjną z
przedstawicielami rodzicielskiego gatunku.

Najważniejszą konsekwencją tego problemu jest to, że ponieważ niektóre gatunki wywodzą się z innych i, konsekwentnie, są
do nich bardziej podobne niż inne, gatunki zamiast listy osobnych elementów, powinny być zaimplementowane jako drzewo
reflektujące związki między nimi.

## System POP

> Symulacja populacji w stylu gry [Stellaris](https://store.steampowered.com/app/281990/Stellaris/)

Szczegółowy opis systemu populacji znajduje się na [stronie wiki gry](https://stellaris.paradoxwikis.com/Population).
Niniejszy opis definiuje zakres systemu który będzie zaimplementowany.

Symulacja będzie się składać ze światów, które będą zawierać jednostki populacji, które będą wykonywać prace i
produkować zasoby.

### Zakres symulacji

Ponieważ system znajdujący się w grze jest dość duży, zaimplementowany zostanie tylko jej podzbiór.

Zaimplementowane będą:

- [Demographics](https://stellaris.paradoxwikis.com/Population#Demographics) (pop growth, pop assembly, pop decline,
  migration)
- [Happiness](https://stellaris.paradoxwikis.com/Population#Demographics)
- [Upkeep](https://stellaris.paradoxwikis.com/Population#Demographics)
- [Stratum](https://stellaris.paradoxwikis.com/Population#Stratum) (Ruler, Specialist, Worker, Criminal)
- [Slavery](https://stellaris.paradoxwikis.com/Population#Slavery) (tylko roboty)

Poza zakresem (nie będą zaimplementowane):

- [Purges](https://stellaris.paradoxwikis.com/Population#Purges)
- [Refugees](https://stellaris.paradoxwikis.com/Population#Refugees)

### Obiekty

#### Państwo

**Państwo (state)** znajduje się na najwyższym poziomie symulacji, zawiera **światy (worlds)** i w obrębie państwa
występuje migracja ludności między światami. Państwo posiada również globalny (dzielony między wszystkimi światami) stan
posiadanych zasobów, takich jak minerały, dobra konsumpcyjne, etc.

#### Świat

**Światy (worlds)** zawierają populacje, miejsca pracy, dobra naturalne możliwe do wydobywania, etc. W grze Stellaris są
to np. planety kolonizowane przez gracza. Światy posiadają swoje właściwości, np. rozmiar, który wpływa na to jak dużą
populację świat jest w stanie utrzymać, możliwe do wybudowania budowle - np. na świecie A gracz może wybudować więcej
kopalni, a na świecie B - farm. Światy mogą też mieć dowolne modyfikatory - np. +10% więcej punktów badań lub -10%
zadowolenia populacji.

#### Popy

**Popy (Pops)** to jednostki reprezentujące jakąś część populacji. Popy posiadają pewien koszt utrzymania (zasoby które
zużywają i miejsce zamieszkania które należy im zapewnić). Ponadto mogą pracować i konsekwentnie produkować nowe zasoby,
lub - z braku miejsc pracy - nie pracować. Popy mogą być orgraniczne i rozmnażać się samoczynnie, lub syntetyczne
(roboty) które inne popy mogą produkować jeżeli są zatrudnione w odpowiednim miejscu pracy. Zużycie zasobów przez popa
jest zależne od jego **warstwy społecznej (stratum)** oraz innych możliwych modyfikatorów.

### Warstwy społeczne

Populacja dzieli wg. zawodu się na 3 warstwy społeczne - robotnicy, specjaliści i władcy.

- Robotnicy: produkują podstawowe zasoby takie jak minerały, żywność, mają najniższe standardy życiowe i zużycie zasobów
- Specjaliści: zamieniają podstawowe zasoby w inne, bardziej wartościowe zasoby, np. minerały -> dobra konsumpcyjne i
  stopy metali, dobra konsumpcyjne -> punkty badań, stopy metali -> produkcja syntetycznych popów. Mają wyższe zużycie
  zasobów
- Władcy są najbardziej wpływową grupą społeczną i mają najwyższe zużycie zasobów. Zazwyczaj nie produkują niczego ale
  są potrzebni do funkcjonowania świata.

#### Miejsca pracy

Dzielą się na **dystrykty** czyli zależne w ilości od świata podstawowe miejsca pracy i miejsca zamieszkania oraz
**budynki** których możliwa do wybudowania ilość jest zależna od ilości populacji zamieszkującej świat. Miejsca pracy
zapewniane przez dystrykty są najczęściej miejscami pracy robotników (kopalnie, farmy, elektrownie).

#### Zasoby

Zasoby są produkowane i konsumowane przez populacje:

- kredyty energetyczne: "waluta" gry, używana do utrzymania budynków oraz można za nie kupować inne zasoby na rynku
  (rynek nie leży w zakresie symulacji)
- minerały: używane do budowania budynków oraz podstawowy surowiec przerabiany przez populacje w inne dobra np. dobra
  konsumpcyjne
- żywność: zużywana przez organiczne populacje
- dobra konsumpcyjne: produkowane przez rzemieślików z minerałów; jw. oraz zamieniane przez naukowców w punkty badań
- stopy metali: produkowane przez metalurgów w hutach; używane do budowy statków (poza zakresem) oraz nowych
  syntetycznych popów.
- punkty badań: produkowane przez naukowców; szybkość odkrywania technologii

Więcej informacji na [wiki](https://stellaris.paradoxwikis.com/Planet_interface).

### Modelowanie zewnętrznych elementów

System populacji działa w grupie z innymi elementami i mechanikami gry, takimi jak:

- kolonizacja (tworzenie nowych światów)
- wynajdywanie nowych technologii (zmiany właściwości dystryktów, nowe opcje ulepszania budynków, zmiany właściwości
  popów, nowe modyfikatory, etc.)
- budowanie i ulepszanie budynków przez gracza (nowe miejsca pracy)
- wyprodukowane dobra zwiększają globalny (jeden dla wielu światów) licznik zasobów (mogą to być fizyczne dobra, jak
  materiały konsumpcyjne lub niefizyczne, jak punkty badań)

Niektóre z tych elementów są "wejściem" (interakcje gracza) a inne "wyjściem" (otrzymane zasoby). Aby zapewnić możliwość
interakcji z symulacją, wykonany zostanie prosty, tekstowy interfejs.
=======
Oprócz tego, gatunki mogą mieć różne wzorce zachowań. Przykładowo: roślinożerca po znalezieniu pożywienia wchodzi np. w
stan `JEDZ`, który polega po prostu przemieszczeniu się w jego kierunku pożywienia i spożyciu go; mięsożerca natomiast
po wypatrzeniu pożywienia (innego zwierzęcia) przejdzie w stan `POLUJ`, w którym zwierzę będzie starało się najpierw
zabić swój cel. Po udanym polowaniu mięsożerca może zjeść swoją zdobycz, w wypadku porażki zwierzę poszuka innego celu.
Z pozoru takie same stany, np. `POLUJ` mogą również różnić się pomiędzy gatunkami, np. gepard będzie polował samotnie,
ale wilki będą polować w grupie, co będzie wymagało koordynacji i kooperacji pomiędzy przedstawicielami gatunku zarówno
podczas polowania, jak i po (dzielenie się pożywieniem).

Ze względu na rozdzielczość symulacji (jedna komórka reprezentująca powierzchnię 10-100m^2) nie będą symulowane
zwierzęta małe jak np. owady lub będą one symulowane w sposób pasywny (np. jak rośliny lub jako właściwość komórki).
>>>>>>> Stashed changes
