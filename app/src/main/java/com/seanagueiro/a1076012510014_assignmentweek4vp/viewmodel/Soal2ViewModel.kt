package com.seanagueiro.a1076012510014_assignmentweek4vp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.seanagueiro.a1076012510014_assignmentweek4vp.model.Hero

class Soal2ViewModel : ViewModel() {

    val heroes = listOf(
        Hero(
            id = 1,
            name = "Alistair",
            rank= "MYTHIC",
            heroClass = "High Templar",
            cp = 5600,
            level = 50,
            hp = 1650,
            maxHp = 1800,
            mp = 650,
            maxMp = 800,
            atk = 380,
            def = 540,
            crit = "22%",
            spd = 105,
            skillName = "Wrath of the Heavens",
            skillDesc = "Calls down a celestial hammer, stunning all enemies for 3 seconds and taunting survivors.",
            imageName = "hero_alistair",
            accentColor = 0xFFF59E0B, inSquad = false
        ),
        Hero(
            id = 2,
            name = "Theresa",
            rank = "MYTHIC",
            heroClass = "Divine Oracle",
            cp = 5480,
            level = 49,
            hp = 1100,
            maxHp = 1200,
            mp = 2100,
            maxMp = 2400,
            atk = 210,
            def = 310,
            crit = "12%",
            spd = 98,
            skillName = "Divine Blessing",
            skillDesc = "Heals the whole party and removes every negative effect for 5 seconds.",
            imageName = "hero_theresa",
            accentColor = 0xFF22C55E, inSquad = false
        ),
        Hero(
            id = 3,
            name = "Vespera",
            rank = "MYTHIC",
            heroClass = "Shadowblade",
            cp = 5350,
            level = 48,
            hp = 890,
            maxHp = 950,
            mp = 410,
            maxMp = 600,
            atk = 460,
            def = 230,
            crit = "38%",
            spd = 142,
            skillName = "Shadow Step",
            skillDesc = "Teleports behind the strongest enemy and strikes twice with guaranteed critical hits.",
            imageName = "hero_vespera",
            accentColor = 0xFFD946EF, inSquad = false
        ),
        Hero(
            id = 4,
            name = "Elaria",
            rank = "MYTHIC",
            heroClass = "Archmage",
            cp = 5120,
            level = 47,
            hp = 450,
            maxHp = 600,
            mp = 1850,
            maxMp = 2000,
            atk = 520, def = 180, crit = "25%", spd = 110,
            skillName = "Arcane Storm",
            skillDesc = "Summons a storm of arcane energy that hits all enemies and drains their mana.",
            imageName = "hero_elaria", accentColor = 0xFF22D3EE, inSquad = true
        ),
        Hero(
            id = 5,
            name = "Seraphina",
            rank = "LEGENDARY",
            heroClass = "Berserker",
            cp = 4980,
            level = 46,
            hp = 1500,
            maxHp = 1700,
            mp = 120,
            maxMp = 300,
            atk = 500,
            def = 260, crit = "30%", spd = 120,
            skillName = "Blood Rage",
            skillDesc = "Gains attack speed for every enemy defeated and ignores part of enemy defense.",
            imageName = "hero_theresa", accentColor = 0xFFF43F5E, inSquad = true
        ),
        Hero(
            id = 6,
            name = "Zephyr",
            rank = "LEGENDARY",
            heroClass = "Berserker",
            cp = 4720,
            level = 44,
            hp = 300,
            maxHp = 1600, mp = 200, maxMp = 250,
            atk = 480, def = 280, crit = "20%", spd = 90,
            skillName = "Unbreakable Roar",
            skillDesc = "Roars loudly to boost all allies' attack while lowering his own defense.",
            imageName = "hero_elaria", accentColor = 0xFFF97316, inSquad = false
        ),
        Hero(
            id = 7,
            name = "Grommash",
            rank = "LEGENDARY",
            heroClass = "High Templar",
            cp = 4650,
            level = 45,
            hp = 1300,
            maxHp = 1400,
            mp = 700,
            maxMp = 700,
            atk = 340,
            def = 500,
            crit = "15%",
            spd = 100,
            skillName = "Holy Shield",
            skillDesc = "Creates a barrier that absorbs damage for the whole squad for 4 seconds.",
            imageName = "hero_grommash", accentColor = 0xFFFBBF24, inSquad = true
        ),
        Hero(
            id = 8,
            name = "Throne",
            rank = "EPIC",
            heroClass = "Archmage",
            cp = 4410,
            level = 42,
            hp = 700,
            maxHp = 700,
            mp = 300,
            maxMp = 1500,
            atk = 430,
            def = 150,
            crit = "18%",
            spd = 115,
            skillName = "Frost Nova",
            skillDesc = "Freezes nearby enemies in place and reduces their speed for the next turns.",
            imageName = "hero_alistair", accentColor = 0xFF60A5FA, inSquad = false
        )
    )

    val filterNames = listOf("All", "Berserker", "Archmage", "High Templar", "Divine Oracle", "Shadowblade")

    // ---- STATE ----
    var selectedFilter by mutableStateOf("All")
    var searchText by mutableStateOf("")
    var expandedHeroId by mutableStateOf<Int?>(null)

    fun countOf(filterName: String): Int {
        if (filterName == "All") {
            return heroes.size
        }
        var total = 0
        for (hero in heroes) {
            if (hero.heroClass == filterName) {
                total = total + 1
            }
        }
        return total
    }
    fun getShownHeroes(): List<Hero> {
        val result = mutableListOf<Hero>()
        val keyword = searchText.lowercase()

        for (hero in heroes) {
            val classOk = selectedFilter == "All" || hero.heroClass == selectedFilter
            val searchOk = keyword == "" ||
                    hero.name.lowercase().contains(keyword) ||
                    hero.heroClass.lowercase().contains(keyword) ||
                    hero.rank.lowercase().contains(keyword)

            if (classOk && searchOk) {
                result.add(hero)
            }
        }
        return result
    }

    fun getSquadCount(): Int {
        var total = 0
        for (hero in heroes) {
            if (hero.inSquad) {
                total = total + 1
            }
        }
        return total
    }
    fun getSquadCp(): Int {
        var total = 0
        for (hero in heroes) {
            if (hero.inSquad) {
                total = total + hero.cp
            }
        }
        return total
    }

    fun selectFilter(name: String) {
        selectedFilter = name
    }

    fun updateSearch(text: String) {
        searchText = text
    }

    // Kalau ditekan sekali buka ditekan dua kali nutup
    fun toggleExpand(heroId: Int) {
        if (expandedHeroId == heroId) {
            expandedHeroId = null
        } else {
            expandedHeroId = heroId
        }
    }
}