#include "date.h"
#include <iomanip>
#include <map>

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
		std::string continent, country, state, region; 
		int month, day, year;
		Temp temperature;
		
		// Ignore the first 4 fields
		std::getline(stream, continent, ',');
		std::getline(stream, country, ',');
		std::getline(stream, state, ',');
		std::getline(stream, region, ',');
		
		stream >> month;
		stream.ignore(1, ',');  
		stream >> day;
		stream.ignore(1, ','); 
		stream >> year;
		stream.ignore(1, ',');
		stream >> temperature;
		
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
               			std::cout << std::fixed << std::setprecision(2) << temp << "\n";
        		}
        		it++;
        	}
        	

        	
	}
}
