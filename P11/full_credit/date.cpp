#include "date.h"

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
