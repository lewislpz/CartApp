---
description: Execute an approved plan with checkpoints, verification, and docs synchronization.
---
// turbo-all

# Forge Prompt

Use this prompt to implement the latest approved plan.

## Contract
- Read `docs/00-general-docs.md` first.
- Follow `.codex/policies/global.md`, `.codex/policies/strict-boundaries.md`, and relevant `.codex/knowledge/` files.
- Do not auto-commit or auto-push.
- Work from a feature branch, not `main`.

## Resume Rules
- If the user says `execute`, `resume`, or provides `PATH`, use the latest or provided plan directory.
- Read `status.md` and resume from the first pending phase.
- Do not recreate completed phase artifacts.

## Implementation Loop
1. Ensure `investigation.md`, `design.md`, and `plan.md` exist.
2. Create `implementation.md` if missing.
3. For each unchecked task:
   - execute the task
   - run its verify command
   - mark the task `[x]` or `[-]`
   - append the result to `implementation.md`
4. Stop after 3 consecutive verification failures on the same task.
5. Update docs referenced by `docs/00-general-docs.md` when behavior changes.
6. Update `status.md` when implementation is complete.

## Final Response
- Report branch name, files changed, verification status, and skipped tasks
- Suggest `/ship` or `/pr` when ready
