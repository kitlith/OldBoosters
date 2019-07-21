# Old Boosters -- Fabric Edition
*A simple mod utilizing mixins to reenable the old minecart boosters from Alpha*

Licensed under the MIT license.

![](oldboosters.gif)

## Features
 - The booster bug can be turned on an off on a per-minecart basis.
 - There are config settings to change what newly placed minecarts are.
   - This is not currently true, as config is not implemented in the port.
 - You can override the defaults by using NBT tags.
   - `EnableBoosters` is the equivalent to the "Enable Boosters" config option.
   - `RemoveCap` is the equivalent to the "Disable 'Speed' Cap" option.
   - `SpeedCap` is the equivalent to the "'Speed' Cap Value" option.
   - example: `/summon minecraft:minecart ~ ~ ~ {EnableBoosters: true, RemoveCap: false, SpeedCap: 500}`

Based off of @Exalm's [olddays](https://github.com/Exalm/Minecraft-mods) mod
and @jpmac26's [OldDaysRevisited](https://github.com/jpmac26/OldDaysRevisited)
