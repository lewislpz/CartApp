# Security Publishing Guide

## Goal
Publish this workspace without leaking credentials, local state, logs, or planning artifacts.

## Default denylist
- `.codex/auth.json`
- `.codex/history.jsonl`
- `.codex/log/`
- `.codex/state_*.sqlite*`
- `.codex/sessions/`
- `.codex/tmp/`
- `.codex/shell_snapshots/`
- `.orchestrator/plans/`

## Pre-Publish Checklist
1. Ensure `.gitignore` contains the required sensitive runtime patterns.
2. Confirm denylisted files are not tracked by git.
3. Review local `.codex/` runtime state before any push.
4. Resolve any secret-scanning findings before publishing.

## Local Validation
Use your repository's preferred checks or pre-commit tooling if you need automated publication gates.

## Incident Response
1. Revoke or rotate leaked credentials immediately.
2. Remove secrets from history with `git filter-repo` or equivalent.
3. Re-run your publication checks until they pass.
4. Document root cause and prevention updates.
