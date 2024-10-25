#include <iostream>

int main(int argc, char* argv[])
{
	std::vector <std::string> numbers; // Numbers on the stack
	std::vector <std::string>* words = new std::vector <std::string>(); // Words on the heap
	
	try
	{
		if (argc == 1) 
		{
			throw new std::runtime_error("");
		}
		
		for (int i = 1; i < argc; i++) // Start at 1 to skip the program name
		{
			std::string arg = argv[i]; // Convert argument immediately to a std::string
			
			if (isdigit(arg[0]))
			{
				numbers.push_back(arg);
			}
			else
			{	
				words->push_back(arg);
			}
		}
		
		std::cout << "Numbers (shuffled):" << std::endl;
		for (std::string number : numbers)
		{
			std::cout << number << std::endl;
		}
		
		std::cout << "Words (sorted):" << std::endl;
		for (std::string word : *words)
		{
			std::cout << word << std::endl;
		}
		
		delete words; // Free the memory
	}
	catch(...)
	{
		std::cerr << "Usage: Must enter arguments on command line" << std::endl;
		delete words; // Free the memory
		return -1;
	}
}
