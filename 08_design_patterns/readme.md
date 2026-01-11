# Introduction to Design Patterns

## 1. Core Concept (First Principles)

### The Problem
As software grows, code becomes complex.  
Requirements change.  
Human brains have limits.

Without structure:
- Small changes break many things
- Code becomes hard to read and maintain

We need a **standard way** to organize code so changes don’t break everything.

### Definition
A **Design Pattern** is a **reusable solution to a common problem** in software design.

It is **not just code**.

Think of it as a **language of experience**.

Example:
- Saying **Sliding Door** is easier than explaining every hinge, rail, and movement.
- Same way, saying **Observer Pattern** avoids explaining the whole logic again and again.

---

## 2. Why Use Design Patterns?

### 1. Proven Solutions
- These patterns are tested by **thousands of developers**
- No need to reinvent the wheel
- You learn from years of real-world experience

### 2. Shared Vocabulary
- Makes communication faster and clearer
- Example:
  - ❌ “When one object changes, many others should update automatically…”
  - ✅ “Use the **Observer Pattern**”

### 3. Helps Follow SOLID Principles
Design patterns naturally support **SOLID**, especially:
- **Open/Closed Principle**
- **Dependency Inversion Principle**

They guide you toward better architecture.

---

## 3. The Three Categories of Design Patterns

### 1. Creational Patterns  
**Problem:** How do I create objects?

Focus: Object creation logic

Examples:
- Singleton
- Factory
- Builder

---

### 2. Structural Patterns  
**Problem:** How do I assemble objects?

Focus: Relationships between classes and objects

Examples:
- Adapter
- Decorator

---

### 3. Behavioral Patterns  
**Problem:** How do objects talk to each other?

Focus: Communication and responsibility

Examples:
- Observer
- Strategy

---

## 4. How to Learn Design Patterns (Important)

### ❌ Don’t Memorize Patterns
Memorizing all 23 patterns is a bad idea.

### ✅ Focus on the Problem First
- Write **bad or messy code**
- Feel the pain:
  - Too many `if-else`
  - Tight coupling
  - Hard to change logic

### ✅ Refactor Using a Pattern
- Identify the problem
- Apply the pattern to fix it
- Understand **why** the pattern exists

> Patterns make sense only when you experience the problem they solve.

---

## Final Thought
Design patterns are **tools**, not rules.

Learn them slowly:
- Problem → Pain → Pattern → Refactor

That’s the right way.
