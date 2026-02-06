# Collaboration Guidelines - agendaApp

## Branch Structure

This repository uses the following branch structure:

- **`development`**: De hoofdontwikkelingsbranch. Alle nieuwe features en fixes worden hier geïntegreerd.
- **Feature branches**: Individuele branches voor nieuwe features of bugfixes.

## Workflow voor Collaborators

### 1. Een nieuwe branch maken

Maak altijd een nieuwe branch vanaf `development`:

```bash
# Zorg ervoor dat je de laatste versie van development hebt
git checkout development
git pull origin development

# Maak een nieuwe feature branch
git checkout -b feature/jouw-feature-naam
# of
git checkout -b bugfix/jouw-bugfix-naam
```

### 2. Werken aan je branch

Voer je wijzigingen door en commit regelmatig:

```bash
# Wijzigingen toevoegen
git add .

# Commit met een duidelijke boodschap
git commit -m "Beschrijving van je wijzigingen"
```

### 3. Pushen naar je eigen branch

Je kunt vrij pushen naar je eigen feature/bugfix branch:

```bash
git push origin feature/jouw-feature-naam
```

**Let op**: Je kunt NIET direct pushen naar de `development` branch. Dit is beveiligd.

### 4. Pull Request maken

Wanneer je feature of bugfix klaar is:

1. Ga naar de GitHub repository
2. Klik op "Pull requests" → "New pull request"
3. Selecteer:
   - Base branch: `development`
   - Compare branch: `feature/jouw-feature-naam`
4. Vul een duidelijke titel en beschrijving in
5. Klik op "Create pull request"

### 5. Review en Merge

- De repository eigenaar (@erwinhenraat) zal je pull request reviewen
- Er kunnen comments of aanpassingen gevraagd worden
- Na goedkeuring zal de eigenaar de pull request mergen naar `development`

## Branch Protection Rules

De `development` branch heeft de volgende bescherming:

- ❌ Directe pushes zijn niet toegestaan
- ✅ Pull requests zijn vereist
- ✅ Review door de repository eigenaar is verplicht
- ✅ Collaborators kunnen hun eigen branches maken en pushen

## Naamconventies voor Branches

Gebruik duidelijke en beschrijvende namen voor je branches:

- `feature/add-new-event-type` - Voor nieuwe features
- `bugfix/fix-calendar-display` - Voor bugfixes
- `refactor/improve-deadline-logic` - Voor code refactoring
- `docs/update-readme` - Voor documentatie updates

## Best Practices

1. **Houd branches klein en gefocust**: Één feature of één bugfix per branch
2. **Commit vaak**: Met duidelijke, beschrijvende commit messages
3. **Pull regelmatig van development**: Voorkom merge conflicts
   ```bash
   git checkout development
   git pull origin development
   git checkout jouw-branch
   git merge development
   ```
4. **Test je code**: Voordat je een pull request maakt
5. **Schrijf duidelijke PR beschrijvingen**: Leg uit wat je hebt veranderd en waarom

## Hulp Nodig?

Neem contact op met @erwinhenraat als je vragen hebt over de workflow.
