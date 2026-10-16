package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seanagueiro.a1076012510014_assignmentweek4vp.model.Hero
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroBorder
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroCardBg
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroGold
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroInner
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroMuted
import com.seanagueiro.a1076012510014_assignmentweek4vp.util.loadScaledBitmap
@Composable
fun HeroCard(
    hero: Hero,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    val accent = Color(hero.accentColor)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = HeroCardBg),
        // biar hero yang sudah masuk squad garisnya emas
        border = BorderStroke(
            width = if (hero.inSquad) 1.5.dp else 1.dp,
            color = if (hero.inSquad) HeroGold else HeroBorder
        )
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Rank
                    Box(
                        modifier = Modifier
                            .border(1.dp, rankColor(hero.rank), RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(hero.rank, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = rankColor(hero.rank))
                    }
                    Spacer(Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(accent.copy(alpha = 0.18f))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(hero.heroClass, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = accent)
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⚔ ${hero.cp} CP", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = HeroGold)
                    if (hero.inSquad) {
                        Spacer(Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .border(1.dp, HeroGold, RoundedCornerShape(4.dp))
                                .padding(horizontal = 5.dp, vertical = 1.dp)
                        ) {
                            Text("IN SQUAD", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = HeroGold)
                        }
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(2.dp, accent, RoundedCornerShape(12.dp))
                ) {
                    HeroImage(hero.imageName, hero.name, Modifier.fillMaxSize())
                    Text(
                        "Lvl ${hero.level}",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .background(Color(0xCC000000), RoundedCornerShape(topStart = 6.dp))
                            .padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }

                Spacer(Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(hero.name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text(if (isExpanded) "▲" else "▼", fontSize = 11.sp, color = HeroMuted)
                    }
                    Spacer(Modifier.height(6.dp))
                    StatBar("HP", hero.hp, hero.maxHp, Color(0xFFFF3B5C))
                    Spacer(Modifier.height(6.dp))
                    StatBar("MP", hero.mp, hero.maxMp, Color(0xFF1E88E5))
                }
            }

            if (isExpanded) {
                Spacer(Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(HeroBorder)
                )
                Spacer(Modifier.height(12.dp))

                // Hero Statistic
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StatBox("ATK", "${hero.atk}", Color(0xFFF97316), Modifier.weight(1f))
                    StatBox("DEF", "${hero.def}", Color(0xFF22C55E), Modifier.weight(1f))
                    StatBox("CRIT", hero.crit, Color(0xFFEAB308), Modifier.weight(1f))
                    StatBox("SPD", "${hero.spd}", Color(0xFF22D3EE), Modifier.weight(1f))
                }

                Spacer(Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(HeroInner)
                        .border(1.dp, HeroBorder, RoundedCornerShape(10.dp))
                        .padding(12.dp)
                ) {
                    Text("★ ${hero.skillName}", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = HeroGold)
                    Spacer(Modifier.height(4.dp))
                    Text(hero.skillDesc, fontSize = 12.sp, color = HeroMuted)
                }

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF14291F))
                            .border(1.dp, Color(0xFF22C55E), RoundedCornerShape(10.dp))
                            .clickable { }
                            .padding(vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Heal (+250 HP)", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4ADE80))
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF2A2412))
                            .border(1.dp, HeroGold, RoundedCornerShape(10.dp))
                            .clickable { }
                            .padding(vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("⚔ Add to Squad", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = HeroGold)
                    }
                }
            }
        }
    }
}

@Composable
fun HeroImage(
    imageName: String,
    name: String,
    modifier: Modifier = Modifier,
    reqWidth: Int = 300,
    reqHeight: Int = 300
) {
    val context = LocalContext.current

    val resourceId = remember(imageName) {
        context.resources.getIdentifier(
            imageName.lowercase().trim(),
            "drawable",
            context.packageName
        )
    }

    if (resourceId != 0) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = name,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = modifier.background(HeroInner),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name.take(1),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
@Composable
private fun StatBar(label: String, value: Int, maxValue: Int, barColor: Color) {
    var fraction = value.toFloat() / maxValue.toFloat()
    if (fraction > 1f) {
        fraction = 1f
    }
    if (fraction < 0f) {
        fraction = 0f
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = HeroMuted,
            modifier = Modifier.width(26.dp)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF05050B))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
                    .background(barColor)
            )
        }
        Text(
            "$value / $maxValue",
            fontSize = 11.sp,
            color = HeroMuted,
            textAlign = TextAlign.End,
            modifier = Modifier.width(78.dp)
        )
    }
}
@Composable
private fun StatBox(label: String, value: String, labelColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(HeroInner)
            .border(1.dp, HeroBorder, RoundedCornerShape(8.dp))
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = labelColor)
        Text(value, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}

fun rankColor(rarity: String): Color {
    return when (rarity) {
        "MYTHIC" -> Color(0xFFEF4444)
        "LEGENDARY" -> Color(0xFFF59E0B)
        else -> Color(0xFFA855F7)
    }
}