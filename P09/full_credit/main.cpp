#include "clock.h"
#include <iostream>

int main(int argc, char* argv[])
{
	if (argc != 4)
	{
		std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
		return -1;
	}
	
	int hours = std::stoi(argv[1]);
	int minutes = std::stoi(argv[2]);
	int seconds = std::stoi(argv[3]);
	
	return 0;
}
