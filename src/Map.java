/*
 * This can really be applied to anything tree-like with weights.
 * I think it's fairly clear what's going on here, but be sure
 * to realize it's not a digraph; links are uni-directional
 */
public class Map
{
	City Oradea =		new City ("Oradea", 380);
	City Zerind =		new City ("Zerind", 374);
	City Arad =		new City ("Arad", 366);
	City Timisoara =	new City ("Timisoara", 329);
	City Lugoj =		new City ("Lugoj", 244);
	City Mehadia =		new City ("Mehadia", 241);
	City Drobeta =		new City ("Drobeta", 242);
	City Craiova =		new City ("Craiova", 160);
	City Rimnicu =		new City ("Rimnicu", 193);
	City Sibiu =		new City ("Sibiu", 253);
	City Pitesi =		new City ("Pitesi", 100);
	City Fagaras =		new City ("Fagaras", 176);
	City Bucharest =	new City ("Bucharest", 0);
	City Giurgiu =		new City ("Giurgiu", 77);
	City Hirsova =		new City ("Hirsova", 151);
	City Eforie =		new City ("Eforie", 161);
	City Urziceni =		new City ("Urziceni", 80);
	City Vaslui =		new City ("Vaslui", 199);
	City Iasi =		new City ("Iasi", 226);
	City Neamt =		new City ("Neamt", 234);

	public Map ()
	{
		Oradea.addConnection (Zerind, 71);
		Oradea.addConnection (Sibiu, 151);

		Zerind.addConnection (Oradea, 71);
		Zerind.addConnection (Arad, 75);

		Arad.addConnection (Sibiu, 140);
		Arad.addConnection (Zerind, 75);
		Arad.addConnection (Timisoara, 118);

		Timisoara.addConnection (Arad, 118);
		Timisoara.addConnection (Lugoj, 111);

		Lugoj.addConnection (Timisoara, 111);
		Lugoj.addConnection (Mehadia, 70);

		Mehadia.addConnection (Drobeta, 75);
		Mehadia.addConnection (Lugoj, 70);

		Drobeta.addConnection (Mehadia, 75);
		Drobeta.addConnection (Craiova, 120);

		Craiova.addConnection (Drobeta, 120);
		Craiova.addConnection (Rimnicu, 146);
		Craiova.addConnection (Pitesi, 120);

		Rimnicu.addConnection (Craiova, 146);
		Rimnicu.addConnection (Sibiu, 80);
		Rimnicu.addConnection (Pitesi, 97);

		Sibiu.addConnection (Arad, 140);
		Sibiu.addConnection (Oradea, 151);
		Sibiu.addConnection (Fagaras, 99);
		Sibiu.addConnection (Rimnicu, 80);
		
		Pitesi.addConnection (Craiova, 120);
		Pitesi.addConnection (Rimnicu, 97);
		Pitesi.addConnection (Bucharest, 101);

		Fagaras.addConnection (Sibiu, 99);
		Fagaras.addConnection (Bucharest, 211);

		Bucharest.addConnection (Fagaras, 211);
		Bucharest.addConnection (Pitesi, 101);
		Bucharest.addConnection (Giurgiu, 90);
		Bucharest.addConnection (Urziceni, 85);

		Giurgiu.addConnection (Bucharest, 90);
		
		Urziceni.addConnection (Hirsova, 98);
		Urziceni.addConnection (Bucharest, 85);
		Urziceni.addConnection (Vaslui, 142);

		Hirsova.addConnection (Eforie, 86);
		Hirsova.addConnection (Urziceni, 98);

		Eforie.addConnection (Hirsova, 86);

		Vaslui.addConnection (Urziceni, 142);
		Vaslui.addConnection (Iasi, 92);

		Iasi.addConnection (Vaslui, 92);
		Iasi.addConnection (Neamt, 87);

		Neamt.addConnection (Iasi, 87);
	}
}
