# Codex Orchestration Manual

This repository is a Codex-oriented orchestration template for docs-first planning, implementation, testing, auditing, and manual delivery.

## Core Idea
- `docs/` contains repository facts and required contracts.
- `.codex/policies/` contains stable rules.
- `.codex/prompts/` are phase entrypoints, not the source of truth.
- Keep the base template lean; add repo-specific automation only when it earns its maintenance cost.

## Phase Entry Points
- `/think` - read-only investigation, design, and planning
- `/forge execute` - implement the latest approved plan on a feature branch
- `/test` - run the testing workflow for a feature or module
- `/audit` - produce a read-only health report
- `/ship` / `/pr` - manual delivery only

## Non-Negotiable Rules
1. Read `docs/00-general-docs.md` first.
2. Do not work directly on `main` for implementation tasks.
3. Do not auto-commit or auto-push outside manual delivery prompts.
4. Keep tasks atomic and verifiable.
5. Update indexed docs when implementation changes repository behavior.

## Execution Notes
- The latest plan lives in `.orchestrator/plans/`.
- `think` creates `investigation.md`, `design.md`, and `plan.md`.
- `forge` creates `implementation.md` and advances tasks one by one.
- Add extra automation only when the repository actually benefits from it.

## Stack Profiles
This template is generic by default.
Load framework-specific frontend or backend guidance only when the target repository actually uses that stack and the docs contract says so.
