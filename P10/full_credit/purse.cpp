#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence)
	: _pounds{pounds}, _shillings{shillings}, _pence{pence}
{
	rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse)
{
	// Format: £3 4s5d - 3 pounds, 4 is shillings, and 5 is pence 
	ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
	return ost;
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
    	++*this;             
   	return temp;  
}

Purse Purse::operator+(const Purse& purse)
{
	return Purse(_pounds + purse._pounds, _shillings + purse._shillings, _pence + purse._pence);
}

Purse Purse::operator-(const Purse& purse)
{
	return Purse(_pounds - purse._pounds, _shillings - purse._shillings, _pence - purse._pence);
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

void Purse::rationalize() 
{
	if (_pence >= 20)
	{
		_pence -= 20;
		_shillings++;
	}
	
	if (_shillings >= 12)
	{
		_shillings -= 12;
		_pounds++;
	}
}

