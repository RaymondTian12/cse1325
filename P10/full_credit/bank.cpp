#include <map>
#include "purse.h"

int main(int argc, char* argv[])
{
	std::map<std::string, Purse> vault;
	int numberOfAccounts;
	
	std::cout << "==========================\n";
	std::cout << "Welcome to the Bank Vault!\n";
	std::cout << "==========================\n";

	std::cout << "How many accounts would you like to create? ";
	std::cin >> numberOfAccounts;
	std::cin.ignore();
	
	for (int i = 0; i < numberOfAccounts; i++)
	{
		std::string accountName;
		int pounds, shillings, pence;
		
		std::cout << "Enter the name of the account " << i << ": ";
       		std::getline(std::cin, accountName);
       		
       		std::cout << "Enter initial deposit (pounds shillings pence): ";
       		std::cin >> pounds >> shillings >> pence;
		std::cin.ignore();
		std::cout << "Account " << accountName << " created with £" << pounds << " " << shillings << "s" << pence << "d\n\n";
		
		vault[accountName] = Purse(pounds, shillings, pence);
	}	
	
	Purse total; // Default Purse object
	std::cout << "\nAccount List:\n";
	
	for (const auto& [name, purse] : vault) 
	{
        	std::cout << name << ": " << purse << "\n";
        	total += purse;
  	}
  	
  	std::cout << "Total amount in bank: " << total << "\n";
	
	return 0;
}
