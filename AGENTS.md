# AGENTS.md

## Project overview
This repository contains a shopping cart application with:
- `cartapp-backend/`: active Spring Boot backend
- `cartapp-frontend/`: frontend directory exists but is currently empty

At this stage, the backend is the primary working application. Do not assume frontend code exists unless it is added later.

---

## Repository structure
Follow the real repository layout:

- `cartapp-backend/`
  - `src/main/java/com/lewis/cartapp/backend/cartapp_backend/`
    - `controllers/`
    - `services/`
    - `repositories/`
    - `models/entities/`
  - `src/main/resources/`
    - `application.properties`
    - `import.sql`
  - `src/test/java/`
  - `compose.yaml`

- `cartapp-frontend/`
  - currently empty

All backend work should be done relative to `cartapp-backend/`.

---

## General working rules
- Make the smallest change that fully solves the task.
- Preserve the existing architecture and naming conventions.
- Prefer modifying existing files over introducing new abstractions.
- Do not perform unrelated refactors.
- Do not add new frameworks or dependencies unless clearly necessary.
- Keep code production-oriented, readable, and consistent with the current project style.
- If a task mentions frontend behavior, first verify whether frontend code actually exists before planning changes there.

---

## Primary working area
The active application currently lives in `cartapp-backend/`.

Unless the task explicitly requires otherwise:
- treat the backend as the source of truth
- run commands from `cartapp-backend/`
- avoid creating speculative frontend code in `cartapp-frontend/` just because the directory exists

---

## Backend architecture rules
Follow the existing layered Spring structure:

- controller -> service -> repository -> entity

Use the existing package organization:
- `controllers/` for REST controllers
- `services/` for business logic
- `repositories/` for persistence
- `models/entities/` for JPA entities

Rules:
- Keep controllers thin.
- Put business logic in services.
- Keep repositories focused on persistence concerns.
- Do not move business logic into controllers or repositories.
- Reuse existing patterns before introducing new classes or layers.
- Keep endpoint naming and response behavior consistent with the current API style.

---

## Java and Spring conventions
- Use Java 17.
- Use Maven via the wrapper script.
- Use 4-space indentation.
- Keep packages lower-case.
- Use PascalCase for classes.
- Prefer descriptive method names, for example:
  - `findAllProducts`
  - `createCart`
  - `deleteProductById`
- Keep imports tidy and rely on standard Java/IDE formatting.
- No separate formatter is configured, so match the existing style already present in the repository.

### Spring-specific guidance
- Prefer standard Spring Boot patterns and conventions already in use.
- Use constructor injection if the surrounding codebase uses it consistently.
- Keep request handling, validation, and exception behavior aligned with existing code.
- Do not introduce alternative architectural patterns unless the task requires it.

---

## API and controller rules
When changing or adding endpoints:
- use the appropriate HTTP method
- keep route naming consistent with the existing API
- return sensible and consistent HTTP status codes
- avoid breaking existing consumers unless the task explicitly requires a contract change

If request/response behavior changes:
- update the relevant controller, service, and persistence flow together
- verify whether tests should also be updated
- mention API contract changes clearly in the final response

Do not silently change:
- field names
- nullability
- status codes
- payload structure
- validation rules

unless the task explicitly calls for it.

---

## Persistence and database rules
The backend uses MySQL locally through `compose.yaml`.

Rules:
- Do not change schema behavior unless the task requires it.
- If seed or startup data behavior changes, update `src/main/resources/import.sql` when appropriate.
- If configuration or database expectations change, also update the relevant setup notes or config references in the same change.
- Do not commit real credentials.
- Treat `application.properties` as local-development-oriented unless the task explicitly concerns environment configuration.

Be careful with:
- entity field changes
- table/column mapping changes
- seed data assumptions
- startup behavior dependent on MySQL state

---

## Configuration rules
Relevant runtime configuration lives in:
- `cartapp-backend/src/main/resources/application.properties`
- `cartapp-backend/compose.yaml`

Rules:
- Prefer environment-aware configuration where appropriate.
- Do not hardcode secrets, tokens, or production credentials.
- Keep local development defaults intact unless the task requires changing them.
- If datasource or container behavior changes, make sure config and setup remain aligned.

The application expects a local MySQL database matching the configured datasource settings or equivalent environment-backed Compose values.

---

## Testing rules
This project uses JUnit 5 through Spring Boot test starters.

Testing expectations:
- Add tests under `cartapp-backend/src/test/java/`
- Mirror the package structure of the code under test
- Use test class names ending in `Tests`
- Favor focused controller and service tests over relying only on `contextLoads()`

Before concluding work, run the smallest relevant verification possible.

Preferred commands from `cartapp-backend/`:
- `./mvnw test` for the test suite
- `./mvnw clean package` when build verification is relevant

Do not claim tests passed unless you actually ran them.

If you could not run tests, say so explicitly.

---

## Development commands
Run all commands from `cartapp-backend/` unless explicitly required otherwise.

Common commands:
- `./mvnw spring-boot:run` → start the API with devtools reload
- `./mvnw test` → run tests
- `./mvnw clean package` → compile, test, and build the jar
- `docker compose up -d` → start the MySQL 8.4 container defined in `compose.yaml`

Before suggesting a command, prefer the commands already used by this repository over generic alternatives.

---

## Dependency rules
- Prefer built-in Spring Boot and JDK capabilities before adding libraries.
- Do not add new dependencies unless necessary for the task.
- If a new dependency is required, keep it minimal and explain why in the final response.
- Continue using the Maven wrapper for build consistency.

---

## File change boundaries
- Do not rename packages, classes, methods, or endpoints unless required.
- Do not reformat unrelated files.
- Do not "clean up" unrelated warnings or style issues as part of the same task.
- Do not update docs, tests, config, or seed data unless the task requires it or the code change makes it necessary.

---

## Frontend guidance
`cartapp-frontend/` currently exists but is empty.

Rules:
- Do not assume an active React application is present.
- Do not create frontend scaffolding unless the task explicitly asks for frontend work.
- If frontend code is added in the future, follow the actual structure and conventions present there rather than guessing.

If a future task touches both backend and frontend:
- verify the frontend actually exists and is in use
- keep API contracts aligned between both sides
- update request/response field usage consistently

---

## Commit and PR conventions
Recent history mixes plain commit messages and Conventional Commits, but `feat:` and `fix:` are already in use and should be preferred.

Prefer small, scoped commits such as:
- `feat: add product listing endpoint`
- `fix: handle missing cart item id`

When preparing changes, optimize for:
- clear scope
- minimal diff
- easy review

If a task changes API behavior, include:
- a short description of the change
- test evidence if available
- example request/response details where relevant

---

## Preferred approach for common tasks

### Adding a new backend feature
1. Inspect existing controller/service/repository/entity patterns.
2. Implement the smallest consistent backend change.
3. Add or update focused tests.
4. Run relevant verification.
5. Summarize behavior changes clearly.

### Fixing a bug
1. Identify the actual layer responsible.
2. Apply the narrowest safe fix.
3. Avoid speculative refactors.
4. Verify with the nearest relevant tests or build command.

### Changing data or startup behavior
1. Inspect entity, repository, config, and seed data implications.
2. Update `import.sql` if seed behavior changes.
3. Keep MySQL setup expectations aligned with `compose.yaml` and config.
4. State any local setup implications clearly.

### Adding frontend support later
1. First inspect whether `cartapp-frontend/` now contains real app code.
2. Follow the real structure and conventions found there.
3. Keep backend and frontend contracts aligned.
4. Do not invent architecture without evidence from the repo.

---

## Final response requirements
In the final response:
- summarize exactly what changed
- mention which files or layers were touched
- call out any API contract changes explicitly
- state which commands/tests were actually run
- mention assumptions, limitations, or anything not verified

Do not say something was tested, built, or validated unless it was actually done.

---

## Notes for agents
- Prefer consistency over cleverness.
- Prefer explicit behavior over hidden magic.
- Prefer the existing repository pattern over generic best practices that conflict with the codebase.
- Treat `cartapp-backend/` as the active application until the frontend contains real code.