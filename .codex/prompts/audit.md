---
description: Read-only audit workflow for code quality, security, and architecture drift.
---
// turbo-all

# Audit Prompt

Use this prompt for a read-only repository audit.

## Contract
- Read `docs/00-general-docs.md` first.
- Load only the docs and skills relevant to the detected stack.
- Write results only under `.orchestrator/audits/`.

## Phase Flow
1. Create `.orchestrator/audits/<timestamp>-audit/status.md`
2. Review guideline compliance
3. Review security and publication posture
4. Review architecture and performance risks
5. Synthesize `audit-report.md`

## Final Response
- Present findings by severity
- Point to concrete files
- Recommend a follow-up `/think` or `/forge` task
