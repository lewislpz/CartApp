# Tech Stack

## Repository Type
This repository is a `.codex` orchestration template, not an application service.

## Primary Assets
- Markdown documentation in `docs/`
- Prompt entrypoints in `.codex/prompts/`
- Policies in `.codex/policies/`
- Role definitions in `.codex/roles/`
- Reusable guidance in `.codex/knowledge/`

## Runtime
- Codex local workspace execution
- Git repository for branch-based feature work

## Model Guidance
- Planning and design: higher reasoning, lower tool pressure
- Implementation: balanced reasoning with explicit verification commands
- Audit and review: higher skepticism and findings-first output
- Shipping and PR: low creativity, strict procedural execution

## Stack Profiles
This template is stack-agnostic by default.
Project-specific frontend or backend rules only apply when `docs/architecture.md` declares that stack profile.
