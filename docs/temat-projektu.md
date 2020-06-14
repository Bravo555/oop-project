# Propozycje projektu

## Symulacja ekosystemu

Symulacja środowiska naturalnego, składającego się ze zwierząt, roślin, etc.

Świat będzie dwuwymiarową siatką. Każda z komórek siatki będzie posiadała pewne właściwości a także będzie mogła
zawierać jakiś organizm (roślinę lub zwierzę).

### Rośliny

Rośliny będą ogranizmami bardziej pasywnymi, tzn. będą reagowały na zmiany środowiska w pewnym, tudzież ograniczonym,
stopniu, np. jeżeli środowisko będzie miało odpowiednie nasłonecznienie i wilgotność, będą rosnąć; w przeciwnym wypadku,
będą umierać. Będą miały również bardzo ograniczoną możliwość wpływania na środowisko czy inne organizmy.

Rośliny będą właściwością komórki. Komórka będzie miała poziom roślinności. Roślinożercy przebywający na tej komórce 
będą żywić się zmniejszając poziom roślinności w komórce.

### Zwierzęta

Elementami wyróżniającymi organizmy zwierzęce będzie przede wszystkim możliwość zmiany swojej pozycji oraz większy
zakres wpływu na swoje środowisko. Zwierzę będzie musiało w sposób aktywny zaspokajać swoje potrzeby fizjologiczne:
głód, odpoczynek, etc. W sposób aktywny, tj. podejmować kroki do osiągnięcia celu, np. szukając pożywienia, unikać
potencjalnych zagrożeń, etc.

Każdy gatunek będzie miał określone statystyki: wytrzymałość, siła i szybkość. Statystyki zwierząt tego samego gatunku
mogą się delikatnie różnić. Jeśli wytrzymałość spadnie do 0 to osobnik umiera. Wytrzymałość można stracić podczas
konfrontacji z innymi zwierzętami oraz można ją odzyskać odpoczywając i jedząc. Siła odpowiada za to jak dobrze zwierze
radzi sobie w walce, a szybkość jak sprawnie przemieszcza się po świecie.

Będą różne typy zwierząt różniące się pod wieloma względami: roślinożercy i mięsożercy, samiec i samica, młode i
dorosłe, jak dużo potomstwa będą produkować, jakich strategii będą używać aby przeżyć, etc.

Jeśli wytrzymałość spadnie do 0 to osobnik umiera. Wytrzymałość można stracić podczas konfrontacji z innymi zwierzętami
oraz można ją odzyskać odpoczywając i jedząc. Siła odpowiada za to jak dobrze zwierze radzi sobie w walce, a szybkość
jak sprawnie przemieszcza się po świecie.

#### Gatunki

Organizmy zwierzęce będą dzielić się na **gatunki**. Rozmnażanie będzie się odbywać tylko w obrębie gatunku (brak
crossbreedingu). Statystyki potomstwa będą generowane na podstawie statystyk rodziców.

Oprócz tego, gatunki mogą mieć różne wzorce zachowań. Przykładowo: roślinożerca po znalezieniu pożywienia wchodzi np. w
stan `JEDZ`, który polega po prostu przemieszczeniu się w jego kierunku pożywienia i spożyciu go; mięsożerca natomiast
po wypatrzeniu pożywienia (innego zwierzęcia) przejdzie w stan `POLUJ`, w którym zwierzę będzie starało się najpierw
zabić swój cel. Po udanym polowaniu mięsożerca może zjeść swoją zdobycz, w wypadku porażki zwierzę poszuka innego celu.
Z pozoru takie same stany, np. `POLUJ` mogą również różnić się pomiędzy gatunkami, np. gepard będzie polował samotnie,
ale wilki będą polować w grupie, co będzie wymagało koordynacji i kooperacji pomiędzy przedstawicielami gatunku zarówno
podczas polowania, jak i po (dzielenie się pożywieniem).
