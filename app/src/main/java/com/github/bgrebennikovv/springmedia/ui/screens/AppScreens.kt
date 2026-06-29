package com.github.bgrebennikovv.springmedia.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() { Box(Modifier.fillMaxSize(), Alignment.Center) { Text("Главная", fontSize = 24.sp) } }

@Composable
fun ShortsScreen() { Box(Modifier.fillMaxSize(), Alignment.Center) { Text("Shorts", fontSize = 24.sp) } }

@Composable
fun CreatePostScreen() { Box(Modifier.fillMaxSize(), Alignment.Center) { Text("Создать контент (+)", fontSize = 24.sp) } }

@Composable
fun SubscriptionsScreen() { Box(Modifier.fillMaxSize(), Alignment.Center) { Text("Подписки", fontSize = 24.sp) } }

@Composable
fun ProfileScreen() { Box(Modifier.fillMaxSize(), Alignment.Center) { Text("Мой канал", fontSize = 24.sp) } }