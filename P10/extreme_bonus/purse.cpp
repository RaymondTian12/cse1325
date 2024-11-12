#include "purse.h"

std::string Purse::pound_utf8 = "£"; 

Purse::Purse(int pounds, int shillings, int pence)
	: _pounds{pounds}, _shillings{shillings}, _pence{pence}
{
	rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse)
{
	// Format: £3 4s5d - 3 pounds, 4 is shillings, and 5 is pence 
	ost << Purse::pound_utf8 << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
	return ost;
}

std::istream& operator>>(std::istream& ist, Purse& purse)
{
	int pounds, shillings, pence;
	char shillingSymbol, penceSymbol;
	char temp;
	std::string poundSymbol = "";
	
	for (int i = 0; i < 2; i++)
	{
		ist >> temp;
		poundSymbol += temp;
	}
	
	if (poundSymbol != Purse::pound_utf8)
	{
		std::cerr << "Invalid input format: expected " << Purse::pound_utf8 << " symbol\n";
		return ist;
	}	
	ist >> pounds >> shillings >> shillingSymbol >> pence >> penceSymbol;
	
	purse = Purse(pounds, shillings, pence);
	purse.rationalize();
	
	return ist;
} 

Purse& Purse::operator++()
{
	_pence++;
	rationalize();
	return *this;
}

Purse Purse::operator++(int)
{
	Purse temp = *this;  
    	++(*this);             
   	return temp;  
}

Purse Purse::operator+(const Purse& purse)
{
	Purse result(_pounds + purse._pounds, _shillings + purse._shillings, _pence + purse._pence);
    	result.rationalize();  
    	return result;
}

Purse Purse::operator-(const Purse& purse)
{
	Purse result(_pounds - purse._pounds, _shillings - purse._shillings, _pence - purse._pence);
    	result.rationalize();  
    	return result;
}

Purse& Purse::operator+=(const Purse& purse)
{
	_pounds += purse._pounds;
	_shillings += purse._shillings;
	_pence += purse._pence;
	rationalize();
	return *this;
}

Purse& Purse::operator-=(const Purse& purse) 
{
   	_pounds -= purse._pounds;
    	_shillings -= purse._shillings;
   	_pence -= purse._pence;
    	rationalize();
    	return *this;
}

int& Purse::operator[](std::string type)
{
	if (type == "£") 
	{
        	return _pounds;
    	} 
    	else if (type == "s") 
    	{
        	return _shillings;
    	} 
    	else if (type == "d") 
    	{
        	return _pence;
    	} 
    	else 
    	{
       		throw std::invalid_argument("Invalid type: " + type);
    	}
}

void Purse::rationalize() 
{
	if (_pence >= 12)
	{
		_shillings += _pence / 12; 
        	_pence %= 12;

	}
	else if (_pence < 0)
   	{
		int borrow = (-_pence + 11) / 12; 
		_shillings -= borrow;
		_pence += borrow * 12;
    	}
	
	if (_shillings >= 20)
	{
		_pounds += _shillings / 20;
       		_shillings %= 20;
	}
	else if (_shillings < 0)
  	{
		int borrow = (-_shillings + 19) / 20; 
		_pounds -= borrow;
		_shillings += borrow * 20;
   	}
}

