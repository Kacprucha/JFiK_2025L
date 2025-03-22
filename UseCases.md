# Przetestowane przypadki

## Testy dla wersji 15.03 - Karaś

Wstępna gramatyka ala C z usunięciem ; na końcu linii 
Usunięciem nazw słów funkcjonalnch zastąpenie ich dowolnym ciągiem znaków o określonej długości
Nazwy zmiennych muszą zaczynać się dużą literą

```
int Main()
{
    int Test
    Test = 0
    nm (Test == 1) {
        Test = 0
    }

    njiqpe 0
}
```

## Testy dla wersji 16.03 22:30 - Karaś

Dodanie różnych typów zmiennych

```
int Main()
{
    int Test = 0
}
```

```
int Main()
{
    char Tett = 'c'
}
```

```
int Main()
{
    double Test = 0.0
}
```

```
int Main()
{
    float Test = 0.0f
}
```

## Testy dla wersji 16.03 23:00 - Karaś

Dodanie operacji --,++,+=.-=

```
int Maine () {
    int Dlu = 4
    int Zmiena = 0
    for (int Iter = 0; Iter < Dlu; Iter++) {
        Zmienna += 1
    }
    return 0
}
```

```
int Main()
{
    int Test = 0
    Test++
}
```

## Testy dla wersji 16.03 23:10 - Brzoza
Zmiany:
- dodanie tablic 
- dodanie macierzy
- dodanie regexu do chara
- dodanie deklaracji z jednoczesną inicjalizacją
- dodanie znaku `value` który jest rozumiany jako liczba (znak `numeric`) dowolnego formatu, char lub id zmiennej

Please jak będziesz robił floata to dodaj rzeczy do numeric :>

Nowa składnia:
```
int Test = 0    // Jednoczesna incjalizacja i deklaracja
int Matrix<x, y, z> = <wiersz; wiersz>  // Tworzenie macierzy o wymiarach x, y, z, przypisanie ma format <wiersz; wiersz; wiersz>
int Array[x][y][z] = [1, 2, 3, 4]       // Przypisywanie wartości kolejnym komórkom pamięci

```

## Testy dla wersji 16.03 23:30 - Karaś

```
int Maine () {
    int Test = 0
    print(Test)
    print(1)
    read(Test)
}
```

## Test dla wersji 22.03 13:25 - Karaś

Dodanie operacji logicznych
Dodanie zmiennych booleańskich

```
int Main () {
int Test = 1
int Test2 = 2
if (Test1 < Test2 && false) {
print("pass")
}
return 0
}
```
## Test dla wersji 22.03 14:48 - Karaś

Dodanie operacji struktur

```
struct MyS {
int MyNum
char MyLet
}
int Main () {
struct MyS Stru1
Stru1.MyNum = 1
Stru1.MyLet = 'c'
print(Stru1.MyNum)
}
```