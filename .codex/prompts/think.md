---
description: Read-only planning workflow for investigation, design, and actionable plans.
---
// turbo-all

# Think Prompt

Use this prompt for read-only architectural analysis.

## Contract
- Read `docs/00-general-docs.md` first and follow its links.
- Align recommendations with `.codex/policies/` and relevant `.codex/knowledge/` files.
- Do not edit code, config, or docs outside `.orchestrator/plans/`.

## Phase Flow
1. Create `.orchestrator/plans/<timestamp>-think-<slug>/status.md`
2. Investigate current state and write `investigation.md`
3. Design the target approach and write `design.md`
4. Break the work into atomic tasks in `plan.md`
5. Update `status.md` after each phase

## Required Outputs
- `status.md`
- `investigation.md`
- `design.md`
- `plan.md`

## Final Response
- Summarize findings, design direction, and proposed plan
- State that no source files were modified
- Suggest `/forge execute` when the plan is approved
