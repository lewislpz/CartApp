# Repository Guidelines

## Project Structure & Module Organization
The active application lives in `cartapp-backend/`, a Spring Boot 4 service built with Maven and Java 17. Source code is under `cartapp-backend/src/main/java/com/lewis/cartapp/backend/cartapp_backend/`, split by layer: `controllers/`, `services/`, `repositories/`, and `models/entities/`. Runtime config and seed data live in `cartapp-backend/src/main/resources/`, including `application.properties` and `import.sql`. Tests belong in `cartapp-backend/src/test/java/` and should mirror the main package structure. `cartapp-backend/compose.yaml` defines the local MySQL dependency. `cartapp-frontend/` exists but is currently empty.

## Build, Test, and Development Commands
Run all project commands from `cartapp-backend/`.

- `./mvnw spring-boot:run`: starts the API with devtools reload.
- `./mvnw test`: runs the JUnit test suite.
- `./mvnw clean package`: compiles, tests, and builds the jar in `target/`.
- `docker compose up -d`: starts the MySQL 8.4 container defined in `compose.yaml`.

The application expects a local MySQL database matching `spring.datasource.*` settings or equivalent environment-backed Compose values.

## Coding Style & Naming Conventions
Use 4-space indentation and standard Java formatting. Keep packages lower-case and class names PascalCase, for example `ProductController` and `ProductRepository`. Prefer descriptive method names such as `findAllProducts` over placeholders like `getMethodName`. Follow the existing layered Spring pattern: controller -> service -> repository -> entity. Use the Maven wrapper for consistent builds; no separate formatter is configured in the repo yet, so keep imports tidy and let your IDE apply standard Java style.

## Testing Guidelines
This repository uses JUnit 5 through Spring Boot test starters. Add tests under `src/test/java/` with names ending in `Tests`, matching the package of the code under test. Favor focused service and controller tests over only relying on `contextLoads()`. Run `./mvnw test` before opening a PR.

## Commit & Pull Request Guidelines
Recent history mixes plain messages and Conventional Commit style, but `feat:` and `fix:` prefixes are already in use and should be preferred. Keep commits small and scoped, for example `feat: add product listing endpoint`. PRs should include a short description, linked issue if applicable, test evidence, and sample request/response details when API behavior changes.

## Configuration & Data Notes
Do not commit real credentials. `application.properties` currently contains local development defaults; override them with environment-specific values when needed. If you change schema or seed behavior, update both `import.sql` and any Compose or database setup notes in the same PR.
