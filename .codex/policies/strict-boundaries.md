# Strict Domain Boundaries

## Purpose
Prevent context pollution and cross-domain edits without an explicit handoff.

## Iron Rule
An agent should stay within the domain implied by the active task and stack profile.
If it must cross domains, it should do so deliberately and document why.

## Default Generic Profiles
### `@architect`
- Domain: `docs/`, `.codex/`, repository-level architecture, delivery rules, and enforcement design.
- Avoid: implementation details that belong to stack-specific application code.

### `@doc-planner`
- Domain: `.orchestrator/plans/`, `docs/`, repository workflow design, and execution logs.
- Avoid: unrelated application refactors.

### `@implementation`
- Domain: only the files required by the active task and declared stack profile.
- Avoid: broad repo-wide edits without plan coverage.

## Optional Stack-Specific Overlays
Apply these only when the target repository declares the stack in `docs/architecture.md`.

### Backend Overlay
- Domain: server code, runtime config, persistence, and backend tests.
- Avoid: frontend assets unless the task explicitly spans both sides.

### Frontend Overlay
- Domain: UI code, client state, styling, and frontend tests.
- Avoid: backend code unless the task explicitly spans both sides.

## Error Prevention
If a task requires files outside the active domain, document the handoff or expand the plan before editing.
