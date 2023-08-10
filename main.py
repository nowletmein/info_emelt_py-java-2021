

def felszam(num):
    # Use a breakpoint in the code line below to debug your script.
    print( f'{num}. feladat')  # Press Ctrl+F8 to toggle the breakpoint.


feladat = []
lepesek = []
felszam(1)

beFile = input("Adja meg a bemeneti fájl nevét! ")
SorSzam = input("Adja meg egy sor számát! ")
OszlopSzam = input("Adja meg egy oszlop számát! ")
#beFile = "konnyu.txt"

felszam(2)
with open(beFile ,'r', encoding='utf-8') as file:
    for sor in file:
        egySor = sor.strip().split(" ")
        egySor = list(map(int, egySor))
        if len(egySor) == 9:
            feladat.append(egySor)
        else:
            lepesek.append(egySor)

#print(feladat, lepesek)
def rsztabla(sor, oszlop, szam):
    van = False
    for j in range(9):
        for i in range(9):
            if feladat[j][i] == szam and getResz(j+1,i+1) == getResz(sor,oszlop):
                van = True
    return van
def getResz(sor, oszlop):
    return sor // 3 * 3 + oszlop //3 + 1
def sorbanVan(sor, szam):
    van = False
    if szam in feladat[sor]:
        van = True
    return van
def oszlopban(oszlop, szam):
    i = 0
    while i < 9 and  feladat[i][oszlop] != szam:
        i += 1
    van = i < 9
    return van
felszam(3)
answare = feladat[int(SorSzam) - 1][int(OszlopSzam) -1]
ans = getResz(int(SorSzam),int(OszlopSzam))
if answare == 0:
    print("Az adott helyet még nem töltötték ki.")
else:
    print("Az adott helyen szereplő szám: ",answare)
print(f"A hely a(z) {ans} résztáblázathoz tartozik.")

felszam(4)

kitoltetlen = 0
for i in feladat:
    for egyAat in i:
        if egyAat == 0:
            kitoltetlen += 1



arany = kitoltetlen / 81 * 100
print(f"Az üres helyek aránya: {arany:.1f} %\n")

felszam(5)
for adat in lepesek:
    ksor = adat[1]
    koszlop = adat[2]
    kszam = adat[0]
    print(f"A kiválasztott sor: {ksor} oszlop: {koszlop} a szám: {kszam}")
    lepes = feladat[ksor - 1][koszlop - 1]
    if lepes != 0:
        print("A helyet már kitöltötték.\n")
    elif sorbanVan(ksor - 1, kszam):
        print("Az adott sorban már szerepel a szám\n")
    elif oszlopban(koszlop - 1,kszam):
            print("Az adott oszlopban már szerepel a szám\n")
    elif rsztabla(ksor - 1,koszlop - 1,kszam):
            print("Az adott résztáblázatban már szerepel a szám\n")
    else:
            print("A lépés megtehető\n")