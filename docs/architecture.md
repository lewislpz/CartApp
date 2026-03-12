# Architecture

## Purpose
This repository defines an agent operating model for Codex-driven development.

## Layers
1. `docs/` defines project facts and repository contracts.
2. `.codex/policies/` defines stable invariants.
3. `.codex/prompts/` provides thin phase entrypoints.
4. `.codex/roles/` scopes responsibilities by role.
5. `.codex/knowledge/` stores reusable heuristics and implementation standards.

## Phase Flow
1. `think` - read-only investigation, design, and plan generation
2. `forge` - implementation against an approved plan
3. `test` - test strategy and verification loops
4. `audit` - read-only health and security review
5. `ship` / `pr` - manual delivery workflows

## Stack Profile
Default profile: generic repository orchestration.
Only load framework-specific backend or frontend rules when the target repository actually contains that stack.

## Enforcement Principle
A documented rule without a real verification step is advisory.
Prefer lightweight repository checks when the workflow starts to drift, but keep the base template simple.
