package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.BorderStroke
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroBackground
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroBorder
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroCardBg
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroGold
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.HeroMuted
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.Week4Theme
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets.HeroCard
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets.HeroImage
import com.seanagueiro.a1076012510014_assignmentweek4vp.viewmodel.Soal2ViewModel

@Composable
fun Soal2(viewModel: Soal2ViewModel = viewModel()) {
    val shownHeroes = viewModel.getShownHeroes()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(HeroBackground)
            .statusBarsPadding(),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Judul
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Party Roster", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(
                        "Guild Vanguard • ${viewModel.heroes.size} Heroes Available",
                        fontSize = 12.sp,
                        color = HeroMuted
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(HeroGold.copy(alpha = 0.15f))
                        .border(1.dp, HeroGold, RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text("★ Expedition", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = HeroGold)
                }
            }
        }

        // Kartu buat squadnya
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1B1830)),
                border = BorderStroke(1.dp, HeroGold.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    // Title + Total CP
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF22C55E))
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(
                                "EXPEDITION SQUAD (${viewModel.getSquadCount()}/4)",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = HeroMuted
                            )
                        }
                        Text(
                            "⚔ ${viewModel.getSquadCp()} CP",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = HeroGold
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        for (hero in viewModel.heroes) {
                            if (hero.inSquad) {
                                Box(
                                    modifier = Modifier
                                        .size(52.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .border(2.dp, Color(hero.accentColor), RoundedCornerShape(10.dp))
                                ) {
                                    HeroImage(hero.imageName, hero.name, Modifier.fillMaxSize())
                                }
                                Spacer(Modifier.width(8.dp))
                            }
                        }

                        // Kotak kosong buat ngisi kalau belum terpenuhi squadnya
                        if (viewModel.getSquadCount() < 4) {
                            Box(
                                modifier = Modifier
                                    .size(52.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .border(1.dp, HeroBorder, RoundedCornerShape(10.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("+", fontSize = 20.sp, color = HeroMuted)
                            }
                        }

                        Spacer(Modifier.weight(1f))

                        // Deploy
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(HeroGold)
                                .clickable { }
                                .padding(horizontal = 20.dp, vertical = 14.dp)
                        ) {
                            Text("Deploy ⚡", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A1200))
                        }
                    }
                }
            }
        }

        // Searching
        item {
            OutlinedTextField(
                value = viewModel.searchText,
                onValueChange = { viewModel.updateSearch(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Search by hero name, class, or rarity...", fontSize = 14.sp) },
                leadingIcon = { Text("🔍") },
                singleLine = true,
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = HeroCardBg,
                    unfocusedContainerColor = HeroCardBg,
                    focusedBorderColor = HeroGold,
                    unfocusedBorderColor = HeroBorder,
                    focusedPlaceholderColor = HeroMuted,
                    unfocusedPlaceholderColor = HeroMuted,
                    cursorColor = HeroGold
                )
            )
        }

        // Filter
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                LazyRow(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(viewModel.filterNames) { name ->
                        val isSelected = viewModel.selectedFilter == name

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(if (isSelected) HeroGold.copy(alpha = 0.15f) else HeroCardBg)
                                .border(
                                    width = 1.dp,
                                    color = if (isSelected) HeroGold else HeroBorder,
                                    shape = RoundedCornerShape(50)
                                )
                                .clickable { viewModel.selectFilter(name) }
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Text(
                                "$name (${viewModel.countOf(name)})",
                                fontSize = 13.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) HeroGold else HeroMuted
                            )
                        }
                    }
                }

                Spacer(Modifier.width(8.dp))

                // Sort
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(HeroGold.copy(alpha = 0.2f))
                        .border(1.dp, HeroGold, RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Text("Sort: Power", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = HeroGold)
                }
            }
        }

        // List Hero
        items(shownHeroes) { hero ->
            HeroCard(
                hero = hero,
                isExpanded = viewModel.expandedHeroId == hero.id,
                onClick = { viewModel.toggleExpand(hero.id) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2Preview() {
    Week4Theme {
        Soal2()
    }
}