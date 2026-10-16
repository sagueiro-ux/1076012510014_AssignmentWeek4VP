package com.seanagueiro.a1076012510014_assignmentweek4vp.model
data class Hero(
    val id: Int,
    val name: String,
    val rank: String,
    val heroClass: String,
    val cp: Int, //Combat Power
    val level: Int,
    val hp: Int,
    val maxHp: Int,
    val mp: Int,
    val maxMp: Int,
    val atk: Int,
    val def: Int,
    val crit: String,
    val spd: Int,
    val skillName: String,
    val skillDesc: String,
    val imageName: String,
    val accentColor: Long,
    val inSquad: Boolean
)