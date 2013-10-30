/*
 * This can really be applied to anything tree-like with weights.
 * I think it's fairly clear what's going on here, but be sure
 * to realize it's not a digraph; links are uni-directional
 */
public class map
{
	city Oradea =		new city ("Oradea", 380);
	city Zerind =		new city ("Zerind", 374);
	city Arad =		new city ("Arad", 366);
	city Timisoara =	new city ("Timisoara", 329);
	city Lugoj =		new city ("Lugoj", 244);
	city Mehadia =		new city ("Mehadia", 241);
	city Drobeta =		new city ("Drobeta", 242);
	city Craiova =		new city ("Craiova", 160);
	city Rimnicu =		new city ("Rimnicu", 193);
	city Sibiu =		new city ("Sibiu", 253);
	city Pitesi =		new city ("Pitesi", 100);
	city Fagaras =		new city ("Fagaras", 176);
	city Bucharest =	new city ("Bucharest", 0);
	city Giurgiu =		new city ("Giurgiu", 77);
	city Hirsova =		new city ("Hirsova", 151);
	city Eforie =		new city ("Eforie", 161);
	city Urziceni =		new city ("Urziceni", 80);
	city Vaslui =		new city ("Vaslui", 199);
	city Iasi =		new city ("Iasi", 226);
	city Neamt =		new city ("Neamt", 234);

	public map ()
	{
		Oradea.addconnection (Zerind, 71);
		Oradea.addconnection (Sibiu, 151);

		Zerind.addconnection (Oradea, 71);
		Zerind.addconnection (Arad, 75);

		Arad.addconnection (Sibiu, 140);
		Arad.addconnection (Zerind, 75);
		Arad.addconnection (Timisoara, 118);

		Timisoara.addconnection (Arad, 118);
		Timisoara.addconnection (Lugoj, 111);

		Lugoj.addconnection (Timisoara, 111);
		Lugoj.addconnection (Mehadia, 70);

		Mehadia.addconnection (Drobeta, 75);
		Mehadia.addconnection (Lugoj, 70);

		Drobeta.addconnection (Mehadia, 75);
		Drobeta.addconnection (Craiova, 120);

		Craiova.addconnection (Drobeta, 120);
		Craiova.addconnection (Rimnicu, 146);
		Craiova.addconnection (Pitesi, 120);

		Rimnicu.addconnection (Craiova, 146);
		Rimnicu.addconnection (Sibiu, 80);
		Rimnicu.addconnection (Pitesi, 97);

		Sibiu.addconnection (Arad, 140);
		Sibiu.addconnection (Oradea, 151);
		Sibiu.addconnection (Fagaras, 99);
		Sibiu.addconnection (Rimnicu, 80);
		
		Pitesi.addconnection (Craiova, 120);
		Pitesi.addconnection (Rimnicu, 97);
		Pitesi.addconnection (Bucharest, 101);

		Fagaras.addconnection (Sibiu, 99);
		Fagaras.addconnection (Bucharest, 211);

		Bucharest.addconnection (Fagaras, 211);
		Bucharest.addconnection (Pitesi, 101);
		Bucharest.addconnection (Giurgiu, 90);
		Bucharest.addconnection (Urziceni, 85);

		Giurgiu.addconnection (Bucharest, 90);
		
		Urziceni.addconnection (Hirsova, 98);
		Urziceni.addconnection (Bucharest, 85);
		Urziceni.addconnection (Vaslui, 142);

		Hirsova.addconnection (Eforie, 86);
		Hirsova.addconnection (Urziceni, 98);

		Eforie.addconnection (Hirsova, 86);

		Vaslui.addconnection (Urziceni, 142);
		Vaslui.addconnection (Iasi, 92);

		Iasi.addconnection (Vaslui, 92);
		Iasi.addconnection (Neamt, 87);

		Neamt.addconnection (Iasi, 87);
	}
}
