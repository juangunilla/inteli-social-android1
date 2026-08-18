package com.inteli.social

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent { MaterialTheme { InteliSocialApp() } }
 }
}

@Composable
fun InteliSocialApp() {
 var tab by remember { mutableIntStateOf(0) }
 Scaffold(bottomBar={ NavigationBar {
  NavigationBarItem(selected=tab==0,onClick={tab=0},icon={},label={Text("Inicio")})
  NavigationBarItem(selected=tab==1,onClick={tab=1},icon={},label={Text("Métricas")})
  NavigationBarItem(selected=tab==2,onClick={tab=2},icon={},label={Text("Publicar")})
  NavigationBarItem(selected=tab==3,onClick={tab=3},icon={},label={Text("Cuentas")})
 }}) { p -> Column(Modifier.padding(p).padding(20.dp).verticalScroll(rememberScrollState())) {
  Text("INTELI SOCIAL", style=MaterialTheme.typography.headlineMedium)
  Text("Instagram + LinkedIn", style=MaterialTheme.typography.titleMedium)
  Spacer(Modifier.height(20.dp))
  when(tab) {
   0 -> Dashboard()
   1 -> Metrics()
   2 -> Publisher()
   else -> Accounts()
  }
 }}
}

@Composable fun Dashboard(){
 Text("Panel general",style=MaterialTheme.typography.headlineSmall); Spacer(Modifier.height(12.dp))
 Card(Modifier.fillMaxWidth()){Column(Modifier.padding(16.dp)){Text("Instagram");Text("Seguidores —");Text("Alcance —   Interacciones —")}}
 Spacer(Modifier.height(12.dp)); Card(Modifier.fillMaxWidth()){Column(Modifier.padding(16.dp)){Text("LinkedIn");Text("Seguidores —");Text("Impresiones —   Interacciones —")}}
 Spacer(Modifier.height(18.dp)); Text("Conectá tus cuentas para cargar métricas reales.")
}
@Composable fun Metrics(){
 Text("Métricas",style=MaterialTheme.typography.headlineSmall); Spacer(Modifier.height(12.dp));
 Text("• Seguidores y crecimiento\n• Alcance e impresiones\n• Interacciones\n• Rendimiento por publicación\n• Comparación Instagram / LinkedIn")
 Spacer(Modifier.height(14.dp)); Text("Los valores se obtendrán desde el backend mediante las APIs oficiales.")
}
@Composable fun Publisher(){
 var text by remember{mutableStateOf("")}; Text("Nueva publicación",style=MaterialTheme.typography.headlineSmall);Spacer(Modifier.height(12.dp));
 OutlinedTextField(value=text,onValueChange={text=it},label={Text("Texto")},modifier=Modifier.fillMaxWidth(),minLines=5);Spacer(Modifier.height(12.dp));
 Row{Button(onClick={}){Text("Instagram")};Spacer(Modifier.width(8.dp));Button(onClick={}){Text("LinkedIn")}}
 Spacer(Modifier.height(12.dp));Button(onClick={},modifier=Modifier.fillMaxWidth()){Text("Programar publicación")}
}
@Composable fun Accounts(){
 Text("Cuentas",style=MaterialTheme.typography.headlineSmall);Spacer(Modifier.height(12.dp));
 Card(Modifier.fillMaxWidth()){Column(Modifier.padding(16.dp)){Text("Instagram Professional");Spacer(Modifier.height(8.dp));Button(onClick={}){Text("Conectar Instagram")}}}
 Spacer(Modifier.height(12.dp));Card(Modifier.fillMaxWidth()){Column(Modifier.padding(16.dp)){Text("LinkedIn");Spacer(Modifier.height(8.dp));Button(onClick={}){Text("Conectar LinkedIn")}}}
 Spacer(Modifier.height(16.dp));Text("Los botones quedan preparados para OAuth. Los secretos y tokens se administrarán únicamente desde el backend seguro.")
}