# Autentifikacija i autorizacija koristeći JWT

- **Registracija korisnika**: Omogućava novim korisnicima da kreiraju svoj nalog.
- **Autentifikacija**: Prijavljivanje korisnika uz JWT.
- **Autorizacija**: Pristup resursima je ograničen na osnovu uloge korisnika.

## Ključne Komponente

- **JwtRequestFilter**: Filter za obradu zahteva i validaciju JWT-a.
- **JwtUtil**: Pomoćna klasa za generisanje i validaciju JWT-a.
- **CustomUserDetailsService**: impl UserDetailsServisa za učitavanje korisničkih podataka.

Java 17
