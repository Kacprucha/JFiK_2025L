# Instalacja LLVM - Windows
W pierwszej kolejności należy sprawdzić czy instalacja LLVMA była zupełna tj.:
```
>lli -version
>llc -version
```
Jeśli dostajemy jakikolwiek output to jest dobrze. W przeciwnym wypadku należy przejść poniższe kroki:
```
>cmake --version
```
Jeśli cmake nie ma -- należy zainstalować jakiś pakiet od GNU. W pierwszej kolejności clonujemy repo i dodajemy folder na binarki:
```
>git clone https://github.com/llvm/llvm-project.git
>cd llvm-project
>mkdir build
>cd build
```
Następnie tworzymy folder docelowy, w którym ma być zainstalowany LLVM -- zapisz ścieżkę.

Następnie przechodzimy do budowy oraz instalacji LLVMa. Można wybrać inny format generatora plików niż ninja. W miejsce `DCMAKE_INSTALL_PREFIX` należy wstawić wcześniej zapisaną ścieżkę do instalacji :)
```
>cmake -G "Ninja" -A x64 -Thost=x64 -DLLVM_TARGETS_TO_BUILD="X86;ARM;AArch64;WebAssembly" -DLLVM_ENABLE_PROJECTS="clang;lld" -DLLVM_ENABLE_RUNTIMES="libcxx;libcxxabi" -DCMAKE_INSTALL_PREFIX="C:\llvm" -DCMAKE_BUILD_TYPE=Release ../llvm
>ninja
    ...
    (godziny agonii)
    ...
>ninja install
```
Przechodzimy pod ścieżkę instalacyjną do folderu bin, kopiujemy ją i dodajemy do PATH. Po restarcie terminala sprawdzamy czy początkowe komendy z tej sekcji działają.

# Fixy do kodu z wykładów 
Wszelkie problemy z kompilacją wynikają z faktu, że Make'i ale także pliki Javy były pisane pod Linuxa.

## Fixy - Makefiles
Błędy związane z brakiem widoczności Antlera wynikają z niepoprawnych definicji ścieżek, wystarczy zamienić:
```
$(ANTLR):output:. --> "$(ANTLR);output;."
```

## Fixy - Java
Gdy podczas runowania lli dostajemy error o braku symbolu, oznacza to najpewniej, że w plikach Javowych użyto operacji typowych dla innego kompilatora C. Przykład z LangX/block:
```
lli test.ll
JIT session error: Symbols not found: [ __isoc99_scanf ]
JIT session error: Failed to materialize symbols: { (main.impl, { main }) }
```
Albo szukamy zastępnika albo pytamy chata (DeepSeek dobrze działa jak coś). Później w plikach Javowych zastępujemy (dla tego przypadku):
```
__isoc99_scanf --> scanf
```
Sprawdzamy też czy `declare` jest poprawne. I w sumie to tyle.