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
	
	while (std::cin)
	{
		int startYear, startMonth, startDay;
        	int endYear, endMonth, endDay;
        	
        	std::cout << "Enter the starting date to list (year month day): ";
        	std::cin >> startYear >> startMonth >> startDay;
        	
        	std::cout << "Enter the ending date to list (year month day): ";
        	std::cin >> endYear >> endMonth >> endDay;
        	
        	Date start(startYear, startMonth, startDay);
        	Date end(endYear, endMonth, endDay);
        	
        	std::map<Date, Temp>::iterator it = temps.begin();
        	while (it != temps.end())
        	{
        		Date date = it -> first;
        		Temp temp = it -> second;
        		
        		if (date >= start && date <= end)
        		{
        			std::cout << std::setw(10) << date << "\t";
               			std::cout << std::fixed << std::setprecision(1) << temp << "\n";
        		}
        		it++;
        	}
        	

        	
	}
}
