#ifndef __PURSE_H
#define __PURSE_H

#include <iostream>

class Purse
{
	private:
		int _pounds;
		int _shillings;
		int _pence;
		
	public:
		Purse(int pounds = 0, int shillings = 0, int pence = 0);
		friend std::ostream& operator(std::ostream& os, const Purse& purse);
		
		
}

