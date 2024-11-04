#include "clock.h"
#include <iostream>

int main(int argc, char* argv[])
{
	if (argc != 4)
	{
		std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
		return -1;
	}
	
	try
	{
		int hours = std::stoi(argv[1]);
		int minutes = std::stoi(argv[2]);
		int seconds = std::stoi(argv[3]);
		
		// Clock::Clock(int hours, int minutes, int seconds)
		Clock clock(hours, minutes, seconds);
		
		std::cout << "Enter 'q' to quit." << std::endl;
		
		std::string input = "";
		while (input != "q")
		{
			clock.print();
			std::getline(std::cin, input);
			if (input != "q")
			{
				clock.tic();
			}
		}
	}
	catch(std::out_of_range& e)
	{
		std::cerr << "Exception: " << e.what() << std::endl;
		return -2;
	}
	
	return 0;
}
