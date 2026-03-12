# Repository Guidelines

## Project Structure & Module Organization
Document authority lives in `README.md` and the `docs/` folder (see `00-general-docs.md` for the entry contract). `docs/architecture.md` defines the operating model, `docs/commands.md` explains the supported workflow, `docs/security-publishing.md` captures policy, and `docs/tech-stack.md` outlines the template stance. Every Codex-facing artifact stays under `.codex/` (`policies/`, `prompts/`, `roles/`, `knowledge/`), so add new guidance inside the appropriate subfolder rather than scattering it elsewhere.

## Build, Test, and Development Commands
- `/think` (generates a plan in `.orchestrator/plans/` for review). 
- `/forge execute` (implements approved plans; work off a feature branch). 
- `/test` or repo-specific validation commands described in `docs/commands.md` (runs your verification loop). 
- `/ship` or `/pr` (manual delivery once verification and documentation updates are complete). 
Log which command you ran, what it touched, and any retries in the implementation log fields listed in `docs/commands.md`.

## Coding Style & Naming Conventions
Keep content Markdown-native: short paragraphs, descriptive headings, and consistent lists. When you touch `.codex` describe steps in present tense and keep prompts/policies in simple sentences. Add new files under a descriptive name (e.g., `docs/my-feature.md` or `.codex/prompts/my-context.md`) and avoid mixing feature scope within unrelated directories.

## Testing Guidelines
No framework is pre-baked. If you add tests, colocate them in a `tests/` folder using descriptive filenames like `feature-name.test.js` or `feature-name.test.md`. Always run `/test` (or the project’s documented verification step) after changes and note what was executed in the PR summary.

## Commit & Pull Request Guidelines
Follow the conventional format seen in `git log` (`type(scope): short description`). Use scopes that reflect areas such as `codex`, `docs`, or `security`. Every PR should summarize the change, list the validation commands you ran, reference linked issues or specs, and call out relevant screenshots or logs when the change affects behavior or policies.

## Security & Configuration Tips
Consult `docs/security-publishing.md` before adding external dependencies or publishing artifacts. Keep sensitive decisions inside `.codex/policies/`, and avoid committing generated state (see the existing `.gitignore` for runtime artifacts).
