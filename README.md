# SecureNotesJourney

A hands-on security learning project: a deliberately vulnerable Spring Boot
REST API that walks through the OWASP Top 10, then fixes each issue step by
step — with the git history, tests, and CI/CD pipeline telling the whole story.

> ⚠️ **Intentionally insecure.** The early code contains deliberate
> vulnerabilities for educational purposes.

## What this project demonstrates

- Common OWASP Top 10 vulnerabilities, introduced on purpose and documented
- A git history that moves from vulnerable to fixed, one commit at a time
- Each vulnerability tracked as a GitHub Issue, with proof and OWASP category
- (Planned) automated tests proving each vulnerability, and a CI/CD pipeline
  that scans for them

## Vulnerabilities

| # | Vulnerability | OWASP | Issue | Status |
|---|---------------|-------|-------|--------|
| 1 | Passwords stored in plaintext | A02:2021 Cryptographic Failures | [#1](../../issues/1) | 🔴 Open |
| 2 | All users + passwords exposed without authorization | A01:2021 Broken Access Control | [#2](../../issues/2) | 🔴 Open |
| 3 | Note responses leak the owner's password | A02 / A01:2021 | [#3](../../issues/3) | 🔴 Open |
| 4 | Authentication disabled on all endpoints | A07:2021 Auth Failures | [#4](../../issues/4) | 🔴 Open |
| 5 | IDOR — notes created for any user via URL id | A01:2021 Broken Access Control | [#5](../../issues/5) | 🔴 Open |
| 6 | CSRF disabled with cookie-based sessions | A01:2021 Broken Access Control | [#6](../../issues/6) | 🔴 Open |

## Tech stack

- Java 21, Spring Boot 4.1
- Maven
- Spring Web, Spring Data JPA, Spring Security, Validation
- H2 (in-memory database)

## Running locally

```bash
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`. Sample requests are in the
`.http` files (`users.http`, `notes.http`), runnable from IntelliJ's HTTP client.