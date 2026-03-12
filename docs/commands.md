# Commands

## Dry-Run Workflow

1. Run `/think` to generate a plan in `.orchestrator/plans/`
2. Review and edit the generated `plan.md` if needed
3. Run `/forge execute` from a feature branch
4. Run `/test` or your repository's own validation commands
5. Run `/ship` or `/pr` manually

## Operational Guidance

- Use a feature branch for implementation work
- Keep tasks atomic and verifiable
- Update indexed docs in the same checkpoint as code changes
- Add repository-specific validation commands only when they provide clear value

## Observability Conventions

Record these fields in implementation logs when possible:

- task name
- files changed
- verify command
- retry count
- outcome
- finished timestamp
