---
description: Testing workflow for strategy, verification, and quality gates.
---
// turbo-all

# Test Prompt

Use this prompt to define and execute a testing workflow for a feature or module.

## Contract
- Read `docs/00-general-docs.md` first.
- Use the stack-specific testing guidance only if the repository declares that stack.
- Prefer explicit verify commands and behavior-focused tests.

## Phase Flow
1. Create a timestamped test workspace in `.orchestrator/plans/`
2. Write a test matrix
3. Prepare test data, factories, or mocks
4. Execute the TDD loop
5. Run the project or module quality gate

## Final Response
- Report pass rate, coverage if available, and unresolved risks
- Suggest `/ship` only after verification succeeds
