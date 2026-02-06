# Branch Protection Setup Instructions

## Voor de Repository Eigenaar (@erwinhenraat)

Dit document beschrijft de stappen om branch protection in te stellen voor de `development` branch via de GitHub web interface.

## Stap 1: Maak de Development Branch

Als de `development` branch nog niet bestaat, maak deze dan eerst aan:

```bash
git checkout -b development
git push -u origin development
```

## Stap 2: Stel Branch Protection Rules in

1. **Ga naar Repository Settings**
   - Open https://github.com/erwinhenraat/agendaApp
   - Klik op "Settings" (rechtsboven)

2. **Navigeer naar Branches**
   - Klik in het linkermenu op "Branches" (onder "Code and automation")

3. **Voeg Branch Protection Rule toe**
   - Klik op "Add branch protection rule" (of "Add rule")
   - Bij "Branch name pattern" voer in: `development`

4. **Configureer de volgende opties:**

   ✅ **Require a pull request before merging**
   - Schakel deze optie in
   - Dit voorkomt directe pushes naar development
   
   Onder deze optie:
   - ✅ **Require approvals**: Stel in op minimaal 1 approval
   - ❌ **Dismiss stale pull request approvals when new commits are pushed**: Optioneel
   - ❌ **Require review from Code Owners**: Optioneel, maar aanbevolen (werkt met .github/CODEOWNERS)

   ✅ **Require status checks to pass before merging** (optioneel)
   - Als je later CI/CD toevoegt, kun je dit inschakelen

   ✅ **Require conversation resolution before merging** (optioneel maar aanbevolen)
   - Zorgt ervoor dat alle comments zijn opgelost voordat mergen

   ❌ **Require signed commits**: Optioneel, voor extra security
   
   ❌ **Require linear history**: Optioneel

   ✅ **Do not allow bypassing the above settings**
   - Dit voorkomt dat administrators (inclusief jij) de regels kunnen omzeilen
   - **Let op**: Als je dit aanzet, moet je ook via PR's werken
   - Optioneel: laat dit uit als je soms direct wilt kunnen pushen als eigenaar

   ❌ **Restrict who can push to matching branches**
   - Laat dit leeg of voeg alleen jezelf toe
   - Als dit leeg is, kunnen alleen mensen via PR's mergen (wat we willen)

   ✅ **Allow force pushes**: Schakel UIT (standaard uit)
   - Dit voorkomt force pushes naar development

   ✅ **Allow deletions**: Schakel UIT (standaard uit)
   - Dit voorkomt dat de development branch per ongeluk wordt verwijderd

5. **Klik op "Create" of "Save changes"**

## Stap 3: Configureer Collaborator Permissies

1. **Ga naar Collaborators**
   - In Settings, klik op "Collaborators and teams"

2. **Voeg Collaborators toe**
   - Klik op "Add people"
   - Voer hun GitHub gebruikersnaam in
   - Selecteer permission level: **"Write"**
   
   Met "Write" permissies kunnen collaborators:
   - ✅ Branches maken
   - ✅ Naar hun eigen branches pushen
   - ✅ Pull requests maken
   - ❌ Niet direct naar protected branches (development) pushen
   - ❌ Niet settings wijzigen

## Stap 4: Test de Setup

Test of de configuratie werkt door:

1. Als collaborator, probeer direct te pushen naar development:
   ```bash
   git checkout development
   git commit --allow-empty -m "Test commit"
   git push origin development
   ```
   Dit zou moeten falen met een error zoals:
   ```
   remote: error: GH006: Protected branch update failed for refs/heads/development.
   ```

2. Maak een feature branch en PR:
   ```bash
   git checkout -b test-feature
   git commit --allow-empty -m "Test feature"
   git push origin test-feature
   ```
   Maak vervolgens een PR via de GitHub web interface.

## Samenvatting van Rechten

### Repository Eigenaar (jij)
- ✅ Kan PR's reviewen en approven
- ✅ Kan PR's mergen naar development
- ✅ Kan development branch beheren
- ✅ Kan settings aanpassen

### Collaborators
- ✅ Kunnen branches maken vanaf development
- ✅ Kunnen naar hun eigen branches pushen
- ✅ Kunnen PR's maken naar development
- ❌ Kunnen NIET direct naar development pushen
- ❌ Moeten wachten op jouw approval voor merge

## Aanvullende Beveiligingsopties (optioneel)

- **Require signed commits**: Voor extra verificatie van commit authenticiteit
- **Status checks**: Voeg later CI/CD workflows toe (tests, linting, etc.)
- **Required reviewers**: Specificeer minimaal aantal reviewers
- **CODEOWNERS enforcement**: Automatisch de juiste reviewers toewijzen

## Documentatie

Wijs je collaborators naar het `CONTRIBUTING.md` bestand voor instructies over de workflow.

## Ondersteuning

Voor meer informatie, zie de GitHub documentatie:
- https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/about-protected-branches
- https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-code-owners
