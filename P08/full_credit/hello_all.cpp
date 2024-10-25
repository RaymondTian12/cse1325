#include <iostream>

int main(int argc, char* argv[])
{
	std::cout << "What's your name? ";
	std::string name;
	std::getline(std::cin, name);
	std::cout << "Hello, " << name << "!" << std::endl;
	
	return 0;
}


