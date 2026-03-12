---
name: parallel-orchestration
description: Multi-agent coordination pattern for Codex-style repository work. Use when a task needs separate passes for architecture, security, implementation, or review.
---

# Parallel Orchestration

## Overview
Coordinate specialized passes when one perspective is not enough.
Use parallel or staged analysis only when the task benefits from separation of concerns.

## Domain Teams
| Team | Roles involved | Trigger |
| :--- | :--- | :--- |
| New Feature | `@architect` -> `@doc-planner` -> implementation role | New repository behavior |
| Security Audit | `@architect` -> security-focused reviewer | Sensitive change or publication review |
| Doc Polish | `@doc-planner` -> `@architect` | Documentation cleanup or contract drift |

## Pattern
1. Explorer maps the current state.
2. Specialists review from their domain perspective.
3. A final synthesis reconciles conflicts into one decision record or plan.

## Rules
- Keep handoffs explicit.
- Keep outputs unified.
- Do not duplicate context unless it changes the result.
