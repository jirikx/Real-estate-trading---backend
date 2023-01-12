# BI-TJV

## Spuštění aplikace
Aplikace běží na http://localhost:8080 a pro svůj běh potřebuje PostgreSQL server (na portu 5432), který je potřeba spustit ještě před startem aplikace pomocí `docker-compose up -d`. 

OpenAPI specifikace je k dispozici na http://localhost:8080/swagger-ui/index.html a je generována vždy se spuštěním aplikace.
Frontend k aplikaci běží na http://localhost:8081, více info je o něm v repozitáři "BI-TJV frontend". 

Pár testovacích API dotazů pro Postmana je uloženo ve složce `src/main/resources`.

## Téma: aplikace pro inzerci a poptávání bydlení a nemovitostí
V této aplikaci budou moci uživatelé poptávat bydlení či rovnou přidávat nabídky na prodej či pronájem. Bydlení půjde filtrovat podle nabízím/poptávám a také dle vlastnosti hledaného bydlení (výměr, cena, adresa, datum nastěhování atd.). Registrovaní uživatelé si můžou ukládat inzeráty do seznamu oblíbených a v případě zájmu kontaktují autora inzerátu přes e-mail.

### Business operace v klientovi
Uživatel bude moct vytvořit vlastní inzerát kde nabízí bydlení, a pokud bude vložené PSČ a cena podobné již existující poptávce, bude o tom uživatel informován a bude tak rovnou tušit, kdo má o podobnou věc zájem. To znamená, že při odeslání inzerátu program zkontroluje, zda již v databázi existuje poptávka v okolí s podobnou cenou, a pokud tomu tak je, načte z databáze kontakt na člověka který poptává takové bydlení a zobrazí ho v UI uživateli jenž přidal inzerát.

### Popis komplexního dotazu v serverové části
Nalezení všech uživatelů, kteří na stránce prodali nemovitosti v Praze v celkové hodnotě přes 20 miliónů (GET na `/api/users/rich`).

![Schéma entit a jejich vztahů v aplikaci](/source/scheme.png "Schéma")
