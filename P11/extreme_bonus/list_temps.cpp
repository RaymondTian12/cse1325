#include "date.h"
#include <iomanip>
#include <map>
#include <sstream>
#include <fstream>

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
		std::istringstream iss{line};
		std::string continent, country, state, region; 
		int month, day, year;
		Temp temperature;
		
		// Ignore the first 4 fields
		std::getline(iss, continent, ',');
		std::getline(iss, country, ',');
		std::getline(iss, state, ',');
		std::getline(iss, region, ',');
		
		iss >> month;
		iss.ignore(1, ',');  
		iss >> day;
		iss.ignore(1, ','); 
		iss >> year;
		iss.ignore(1, ',');
		iss >> temperature;
		
		Date date(year, month, day);
		temps[date] = temperature;
	}
	
	while (true)
	{
		std::cout << "Enter the starting date to list (YYYY/MM/DD): ";
       		Date start;
       		
        	if (!(std::cin >> start))
        	{
            		break;
        	}

        	std::cout << "Enter the ending date to list (year/month/day): ";
		Date end;
		
		if (!(std::cin >> end))
		{
		    break;
		}

		if (start > end)
		{
		    std::cerr << end << " is earlier than " << start << "\n";
		    continue;
		}

		auto it = temps.find(start);
		
		if (temps.find(start) == temps.end())
	    	{
			std::cerr << start << " is not in the database!\n";
			continue; 
	    	}
	    	
		if (it == temps.end())
		{
		    std::cerr << start << " is not in the database!\n";
		    continue;
		}

		// Iterate and print results
		while (it != temps.end() && it->first <= end)
		{
		    Date date = it->first;
		    Temp temp = it->second;

		    std::cout << std::setw(10) << date << "\t";
		    std::cout << std::fixed << std::setprecision(1) << temp << "\n";

		    ++it;
		}
	}
}
