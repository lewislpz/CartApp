---
name: subagent-driven-development
description: Use when executing implementation plans. Dispatches a fresh execution context per atomic task with review and verification.
---

# Subagent-Driven Development (SDD)

## Loop
1. Dispatch one fresh execution context for one task.
2. Validate spec compliance.
3. Validate quality, docs sync, and verification output.
4. Record the result in `plan.md` and `implementation.md`.

## Laws
- One task per execution context.
- Pass the exact task text, not just the file path.
- Re-review fixes through the same review lens.
- Include the verify command and outcome in the log.
