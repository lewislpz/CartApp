# Global Rules for Development

These rules define the canonical operating contract for this repository.

## 1. Documentation Contract
- `docs/` is the primary source of truth for project-specific facts.
- Every task must start by reading `docs/00-general-docs.md` and following its links.
- Required baseline docs are `docs/tech-stack.md`, `docs/architecture.md`, `docs/commands.md`, and `docs/security-publishing.md`.
- If implementation changes behavior, update the relevant indexed docs in the same checkpoint.

## 2. Planning and Execution
- Create a timestamped directory in `.orchestrator/plans/` for every task-oriented workflow.
- Follow the phase lifecycle: Investigation, Design, Plan, Implementation.
- Record major decisions in plan artifacts.
- Abort after 3 failed verification attempts on the same task.

## 3. Git and Delivery
- Use Conventional Commits for manual delivery.
- Do not run `git commit` or `git push` automatically during planning or implementation prompts.
- Only `/ship` and `/pr` may perform manual delivery steps after explicit user confirmation.
- Implementation work should happen on a feature branch, not directly on `main`.

## 4. Enforcement
- Do not use `git add -f` for ignored runtime or tool artifacts.
- No hardcoded secrets. Use environment files or platform secret stores.
- Add automation only when it reduces real risk or maintenance cost.

## 5. Stack Discovery
- Do not assume a specific framework stack.
- Consult `docs/tech-stack.md` and `docs/architecture.md` before loading framework-specific guidance.
