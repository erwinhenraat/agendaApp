# Quick Setup Guide - Voltooien van Branch Protection

## Snel Overzicht

Deze repository is nu voorbereid voor branch protection. Om de configuratie te voltooien, moet je als repository eigenaar nog 2 stappen uitvoeren in GitHub:

## ✅ Wat is al klaar

- ✅ `.github/CODEOWNERS` - Vereist jouw approval voor wijzigingen
- ✅ `CONTRIBUTING.md` - Uitgebreide instructies voor collaborators
- ✅ `BRANCH_PROTECTION_SETUP.md` - Gedetailleerde setup instructies
- ✅ `.github/workflows/pr-validation.yml` - Automatische PR validatie
- ✅ `.github/pull_request_template.md` - PR template voor collaborators
- ✅ `README.md` - Project documentatie met verwijzingen

## 🔧 Wat je nog moet doen

### Stap 1: Maak de "development" branch (indien nog niet bestaat)

```bash
git checkout -b development
git push -u origin development
```

**Of**, als de branch al bestaat, zorg dat deze up-to-date is:
```bash
git checkout development
git pull origin development
```

### Stap 2: Stel Branch Protection in via GitHub UI

1. Ga naar: https://github.com/erwinhenraat/agendaApp/settings/branches
2. Klik op "Add branch protection rule"
3. Branch name pattern: `development`
4. Schakel IN:
   - ✅ **Require a pull request before merging**
     - Require approvals: 1
   - ✅ **Require conversation resolution before merging** (aanbevolen)
5. Schakel UIT:
   - ❌ Allow force pushes
   - ❌ Allow deletions
6. Klik "Create" / "Save changes"

### Stap 3: Test de Setup (Optioneel)

Vraag een collaborator om te proberen direct naar development te pushen - dit zou moeten falen.

## 📚 Meer Info

Voor gedetailleerde instructies, zie:
- **Voor jou**: [BRANCH_PROTECTION_SETUP.md](BRANCH_PROTECTION_SETUP.md)
- **Voor collaborators**: [CONTRIBUTING.md](CONTRIBUTING.md)

## 🎯 Resultaat

Na deze stappen:
- ✅ Collaborators kunnen branches maken vanaf development
- ✅ Collaborators kunnen naar hun eigen branches pushen
- ✅ Collaborators kunnen PR's maken naar development
- ❌ Niemand kan direct naar development pushen (alleen via PR)
- 👤 Alleen jij kunt PR's approven en mergen

## ❓ Vragen?

Check de documentatie of neem contact op met het support team.
