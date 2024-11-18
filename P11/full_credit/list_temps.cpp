#include "date.h"

typedef double Temp; 

int main(int argc, char* argv[])
{
	if (argc != 2)
	{
		std::cerr << "usage: <program name> <data file>\n";
		return -1; 
	}
	
	std::string filename = argv[1]; // Convert argument into filename string
	std::ifstream ist{filename};
	if (!ist)
	{
		std::cerr << "Can't open input file " << filename << "\n";
		return -2;
	}
	
	std::map<Date, Temp> temps;
	std::string line;
	
	// Line Format: continent, country, state, region, month, day, year, and temperature in °F
	// Ignore the first 4 fields 
	while (std::getline(ist, line))
	{
		std::istringstream stream{line};
		std::string continuent, country, state, region; 
		int month, day, year;
		Temp temperature;
		
		std::getline(stream, string, ' ,');
	}
}
