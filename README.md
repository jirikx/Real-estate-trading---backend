# BI-TJV

## Téma: aplikace pro inzerci a poptávání bydlení a nemovitostí
V této aplikaci budou moci uživatelé poptávat bydlení či rovnou přidávat nabídky na prodej či pronájem. Bydlení půjde filtrovat podle nabízím/poptávám a také dle vlastnosti hledaného bydlení (výměr, cena, adresa, datum nastěhování atd.). Registrovaní uživatelé si můžou ukládat inzeráty do seznamu oblíbených a v případě zájmu kontaktují autora inzerátu přes e-mail.

### Business operace v klientovi
Uživatel bude moct vytvořit vlastní inzerát kde nabízí bydlení, a pokud bude vložené PSČ a cena podobné již existující poptávce, bude o tom uživatel informován a bude tak rovnou tušit, kdo má o podobnou věc zájem. To znamená, že při odeslání inzerátu program zkontroluje, zda již v databázi existuje poptávka v okolí s podobnou cenou, a pokud tomu tak je, načte z databáze kontakt na člověka který poptává takové bydlení a zobrazí ho v UI uživateli jenž přidal inzerát.

### Popis komplexního dotazu v serverové části
Nalezení všech uživatelů, kteří na stránce prodali nemovitosti v Praze v celkové hodnotě přes 20 miliónů.

![Schéma entit a jejich vztahů v aplikaci](/source/scheme.png "Schéma")
