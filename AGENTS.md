# Repository Guidelines

## Project Structure & Module Organization
This repository is split into:
- `cartapp-backend/`: Spring Boot API (Java 17, Maven).
- `cartapp-frontend/`: reserved for frontend code (currently empty).

Backend source layout follows standard Spring conventions:
- `src/main/java/com/lewis/cartapp/backend/cartapp_backend/`
  - `controllers/` (HTTP endpoints)
  - `services/` (business logic)
  - `repositories/` (JPA data access)
  - `models/entities/` (JPA entities)
- `src/main/resources/application.properties` (runtime config)
- `src/test/java/...` (unit/integration tests)

## Build, Test, and Development Commands
Run commands from `cartapp-backend/`:
- `./mvnw spring-boot:run`: start API locally.
- `./mvnw test`: run test suite.
- `./mvnw clean package`: compile, test, and build JAR in `target/`.
- `docker compose -f compose.yaml up -d`: start local dependencies (e.g., MySQL).
- `docker compose -f compose.yaml down`: stop local containers.

## Coding Style & Naming Conventions
- Java: 4-space indentation, UTF-8, one public class per file.
- Packages are lowercase (`controllers`, `services`, `repositories`).
- Classes use PascalCase (`ProductController`, `ProductServiceImp`).
- Methods/fields use camelCase (`findAll`, `productService`).
- Keep controllers thin; move logic to service layer.
- Prefer constructor injection for new code over field injection.

## Testing Guidelines
- Frameworks: JUnit 5, Spring Boot Test, MockMvc, Mockito.
- Test classes should end with `Tests` (e.g., `ProductControllerTests`).
- Test methods should describe behavior (`getProductsReturnsProductList`).
- Add tests for every controller/service change and key error path.
- Run `./mvnw test` before opening a PR.

## Commit & Pull Request Guidelines
Recent history uses concise, imperative commits with `feat:` prefixes. Follow:
- Format: `type(scope): short description` (e.g., `feat(controller): add product list endpoint`).
- Keep commits focused; avoid mixing refactors with behavior changes.
- PRs should include:
  - what changed and why,
  - linked issue/ticket (if any),
  - test evidence (`./mvnw test` output summary),
  - API examples (request/response) for endpoint changes.

## Security & Configuration Tips
- Do not commit secrets; keep credentials in local `.env` or environment variables.
- Review `.gitignore` before adding new config or build artifacts.
