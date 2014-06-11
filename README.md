#EnderTech

##Introduction
This is my first foray in to Minecraft modding. It's intended to be a tech themed mod, starting at around Thermal Expansion's end-game, and as such will contain tech (and likely Ender) themed things that make my own personal game more fun. At the time of writing there's a fully functional item called the 'Exchanger' - for swapping blocks from your inventory with blocks in the world, inspired by Thaumcraft's ``Wand of Equal Trade'', but using a decent amount of RF and with a lot of modified behaviour.

I don't promise to finish it, or keep it stable, and I'm not interested in formal feature requests, but feel free to suggest things to me in #MultiMC on Esper anyway. I've opened the repository up because other open source projects are proving extremely helpful in learning my way around Forge. If it did become popular, or get included in a larger modpack, I'll commit to something more formal to make things better for users and modpack makers.

There are no textures (or I've used debug textures) whilst I figure out what sort of aesthetic I want, get a design document sorted, and bribe a texture artist with false claims of fame and fortune.

If you spot that I'm doing something particularly heinous, it's because I don't know any better. Tell me on IRC (Esper/#MultiMC)!

##License and terms
Things I want you to do:
* Learn from the source,
  * Include a thank-you, or put me in your credits (as "Drayshak"),
* If you're feeling generous:
  * Tell me you enjoy using the mod in IRC (Esper/#MultiMC) or on Twitter ([@Drayshak](https://twitter.com/drayshak)),
* Enjoy the mod.

Things I don't want you to do:
* Copy large sections of source (functions and ideas are examples of things that are, generally, fine),
* Redistribute custom built jars (all the jars on Vaen are signed appropriately),
  * Building your own jar is fine, but don't make it public,
  * Redistributing a signed jar from Vaen is fine.
* Copy ideas and pass them off as your own,
* Make money from the mod (no paywalls, adf.ly links, charging for access to items or any other bullshit like that).

These terms are formally defined by the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International (CC BY-NC-ND 4.0) license.

http://creativecommons.org/licenses/by-nc-nd/4.0/

##Builds
Signed jars are available on Vaen.

http://vaen.emberwalker.cc/job/EnderTech/

##Building
This mod uses Forge's Gradle wrapper for pretty easy setup and building. There are better guides around the internet for using it, and I don't do anything particularly special.

The general idea:
* **Setup**: `gradlew [setupDevWorkspace/setupDecompWorkspace] [idea/eclipse]`
* **Building**: `gradlew build`

If you run in to odd Gradle issues, doing `gradlew clean` usually fixes it.

## With thanks to
* Pahimar (Modding guides and [EE3](https://github.com/pahimar/Equivalent-Exchange-3)),
* Team CoFH ([Thermal Expansion](http://teamcofh.com/)),
* Azanor ([Thaumcraft](http://www.minecraftforum.net/topic/2011841-thaumcraft-41114-updated-2052014/)),
* [Arkan](https://github.com/emberwalker) (Build server).

## Things planned
* Tank infrastructure,
* Teleportation infrastructure,
* Multiblocks,
* Exchanger rewrite to make things per-player.
