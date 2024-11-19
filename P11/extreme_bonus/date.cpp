#include "date.h"
#include <iomanip>
#include <sstream>

Date::Date(int year, int month, int day)
	: _year{year}, _month{month}, _day{day}
{
} // No data validation required

std::ostream& operator<<(std::ostream& ost, const Date& date)
{
	char old_setfill = ost.fill();
	
	ost << std::setw(4) << date._year << "/"
            << std::setfill('0') << std::setw(2) << date._month << "/"
            << std::setw(2) << date._day;
            
        std::setfill(old_setfill);
        
        return ost;
}

std::istream& operator>>(std::istream& ist, Date& date)
{
	char separator1, separator2;
    	int year, month, day;

   	
   	if ((is >> year >> separator1 >> month >> separator2 >> day) && separator1 == '/' && separator2 == '/') 
   	{
		date._year = year;
		date._month = month;
		date._day = day;
    	} 
    	else 
    	{
		is.setstate(std::ios::failbit);
    	}

    return ist;
}
