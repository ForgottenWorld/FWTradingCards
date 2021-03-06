package it.forgottenworld.tradingcards.commands.subcommands

import it.forgottenworld.tradingcards.data.BoosterPacks
import it.forgottenworld.tradingcards.data.Messages
import it.forgottenworld.tradingcards.util.tC
import it.forgottenworld.tradingcards.util.sendPrefixedMessage
import org.bukkit.command.CommandSender

fun cmdListPacks(sender: CommandSender): Boolean {

    if (!sender.hasPermission("fwtradingcards.listpacks")) {
        sendPrefixedMessage(sender, Messages.NoPerms)
        return true
    }

    sender.sendMessage(tC("&6--- Booster Packs ---"))

    BoosterPacks.values.forEachIndexed { i, b ->

        sender.sendMessage(tC(
                "&6${i + 1}) &e$b${
                    if (b.price > 0.0) " &7(&aPrice: ${b.price})" else ""
                }"))

        sender.sendMessage(tC(
                "  &7- &f&o${b.numNormalCards} ${b.normalCardRarity.name}, ${
                    if (b.numExtraCards > 0)
                        "${b.numExtraCards} ${b.extraCardRarity?.name}, "
                    else ""
                }, ${
                    b.numSpecialCards
                } ${b.specialCardRarity}")
        )
    }

    return true
}