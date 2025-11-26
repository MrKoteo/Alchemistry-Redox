# <img src="src/main/resources/assets/alchemistry/textures/logo.png" alt="Catalyx" height="42" width="42"> Alchemistry - Redox

<!---freshmark description
output = [
link(shield("Kotlin", "Kotlin", "{{kotlin_version}}", "blue"), "https://kotlinlang.org/"),
link(shield("Maven artifact", "Maven", "{{root_package}}:{{mod_id}}", "blue"), "https://maven.ender-development.org/" + "{{root_package}}/{{mod_id}}/".replaceAll("\\.", "/")),
link(shield("Version", "Version", "{{mod_version}}", "blue"), "{{mod_url}}/commits/master"),
link(shield("License", "License", "LGPL-3.0", "blue"), "{{mod_url}}/blob/master/LICENSE"),
"",
"{{mod_description}}".replace("Minechem", link("Minechem", "https://www.curseforge.com/minecraft/mc-mods/minechem-archive")),"",
'<a href="https://www.akliz.net/enderman"><img src="https://raw.githubusercontent.com/Ender-Development/Catalyx-Template/refs/heads/master/assets/ender_development/banner.png" align="center"/></a>'
].join("\n")
-->
[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.20-blue.svg)](https://kotlinlang.org/)
[![Maven artifact](https://img.shields.io/badge/Maven-org.ender__development%3Aalchemistry-blue.svg)](https://maven.ender-development.org/org/ender_development/alchemistry/)
[![Version](https://img.shields.io/badge/Version-1.3.1-blue.svg)](https://github.com/Ender-Development/Alchemistry-Redox/commits/master)
[![License](https://img.shields.io/badge/License-LGPL--3.0-blue.svg)](https://github.com/Ender-Development/Alchemistry-Redox/blob/master/LICENSE)

Alchemistry is a tech mod, inspired by the classic [Minechem](https://www.curseforge.com/minecraft/mc-mods/minechem-archive), that allows you to decompose items into their constituent elements, then recombine them to create new items.

<a href="https://www.akliz.net/enderman"><img src="https://raw.githubusercontent.com/Ender-Development/Catalyx-Template/refs/heads/master/assets/ender_development/banner.png" align="center"/></a>
<!---freshmark /description -->

## Changes compared to the original Alchemistry mod

- switched to [Catalyx](https://github.com/Ender-Development/Catalyx) as the base mod framework and build system
- rewrote large parts of the codebase to improve maintainability and performance
- the new config system can be edited in-game
- custom compounds and elements are now translatable and can be added via CraftTweaker/GroovyScript
- backported updated textures from the modern version of the mod
- largely overhauled both reactor multiblocks, adding glass blocks and an upgrade system
- redid all GUI textures, while adding additional functionality to all machines

## Dependencies

<!---freshmark dependencies
output = [
	link(shield("Forgelin-Continuous", "required", "Forgelin-Continuous", "red"), "https://www.curseforge.com/minecraft/mc-mods/forgelin-continuous"),
	"Forgelin-Continuous is an updated version of " + link("Shadowfacts' Forgelin", "https://www.curseforge.com/minecraft/mc-mods/shadowfacts-forgelin") + ", which packs latest versions of Kotlin libraries for mod developers to use with.",
	link(shield("Patchouli", "optional", "Patchouli", "green"), "https://www.curseforge.com/minecraft/mc-mods/patchouli-rofl-edition"),
	"Alchemistry comes with a Patchouli book that explains the basics of the mod.",
	link(shield("HadEnoughItems", "optional", "HadEnoughItems", "green"), "https://www.curseforge.com/minecraft/mc-mods/had-enough-items"),
	"All recipes are integrated into JEI.",
	link(shield("JSON_Paintings", "optional", "JSON Paintings", "green"), "https://modrinth.com/mod/json-paintings"),
	"Alchemistry adds a painting that displays the periodic table, given JSON Paintings is present.",
	link(shield("CraftTweaker", "optional", "CraftTweaker", "green"), "https://www.curseforge.com/minecraft/mc-mods/crafttweaker"),
	"Alchemistry provides CraftTweaker support for all recipes as well as adding custom elements and compounds.",
	link(shield("GroovyScript", "optional", "GroovyScript", "green"), "https://www.curseforge.com/minecraft/mc-mods/groovyscript"),
	"The groovy-equivalent of CraftTweaker is also supported.",
	link(shield("Game_Stages", "optional", "Game Stages", "green"), "https://www.curseforge.com/minecraft/mc-mods/game-stages"),
	"The Chemical Combiner recipes can be locked behind Game Stages.",
	link(shield("The_One_Probe", "optional", "The One Probe", "green"), "https://www.curseforge.com/minecraft/mc-mods/the-one-probe-community-edition"),
	"Reactors and the Chemical Combiner display extra information in The One Probe."
].join("\n\n")
-->
[![Forgelin-Continuous](https://img.shields.io/badge/required-Forgelin--Continuous-red.svg)](https://www.curseforge.com/minecraft/mc-mods/forgelin-continuous)

Forgelin-Continuous is an updated version of [Shadowfacts' Forgelin](https://www.curseforge.com/minecraft/mc-mods/shadowfacts-forgelin), which packs latest versions of Kotlin libraries for mod developers to use with.

[![Patchouli](https://img.shields.io/badge/optional-Patchouli-green.svg)](https://www.curseforge.com/minecraft/mc-mods/patchouli-rofl-edition)

Alchemistry comes with a Patchouli book that explains the basics of the mod.

[![HadEnoughItems](https://img.shields.io/badge/optional-HadEnoughItems-green.svg)](https://www.curseforge.com/minecraft/mc-mods/had-enough-items)

All recipes are integrated into JEI.

[![JSON_Paintings](https://img.shields.io/badge/optional-JSON_Paintings-green.svg)](https://modrinth.com/mod/json-paintings)

Alchemistry adds a painting that displays the periodic table, given JSON Paintings is present.

[![CraftTweaker](https://img.shields.io/badge/optional-CraftTweaker-green.svg)](https://www.curseforge.com/minecraft/mc-mods/crafttweaker)

Alchemistry provides CraftTweaker support for all recipes as well as adding custom elements and compounds.

[![GroovyScript](https://img.shields.io/badge/optional-GroovyScript-green.svg)](https://www.curseforge.com/minecraft/mc-mods/groovyscript)

The groovy-equivalent of CraftTweaker is also supported.

[![Game_Stages](https://img.shields.io/badge/optional-Game_Stages-green.svg)](https://www.curseforge.com/minecraft/mc-mods/game-stages)

The Chemical Combiner recipes can be locked behind Game Stages.

[![The_One_Probe](https://img.shields.io/badge/optional-The_One_Probe-green.svg)](https://www.curseforge.com/minecraft/mc-mods/the-one-probe-community-edition)

Reactors and the Chemical Combiner display extra information in The One Probe.
<!---freshmark /dependencies -->

## Contributing

Please make sure to read our [contributing guidelines](.github/CONTRIBUTING.md) first.
Furthermore, you have to agree to our [code of conduct](.github/CODE_OF_CONDUCT.md) if you want to contribute.

## Partnership with Akliz

> It's a pleasure to be partnered with Akliz. Besides being a fantastic server provider, which makes it incredibly easy
> to set up a server of your choice, they help me to push myself and the quality of my projects to the next level.
> Furthermore, you can click on the banner below to get a discount. :')

<a href="https://www.akliz.net/enderman"><img src="https://raw.githubusercontent.com/Ender-Development/Catalyx-Template/refs/heads/master/assets/ender_development/partnership.png" align="center"/></a>

If you aren't located in the [US](https://www.akliz.net/enderman), Akliz now offers servers in:

- [Europe](https://www.akliz.net/enderman-eu)
- [Oceania](https://www.akliz.net/enderman-oce)
