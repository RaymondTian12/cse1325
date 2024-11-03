#include "clock.h"

Clock::Clock(int hours, int minutes, int seconds)
	:  _hours{hours}, _minutes{minutes}, _seconds{seconds}
{
	if (hours < 0 || hours > 23)
	{
		throw std::out_of_range("Invalid hour: " + hours);
	}
	if (minutes < 0 || minutes > 59)
	{
		throw std::out_of_range("Invalid minute: " + minutes);
	}
	if (seconds < 0 || seconds > 59)
	{
		throw std::out_of_range("Invalid second: " + seconds);
	}
}

Clock::~Clock()
{
}

void Clock::print()
{
	std::cout << std::setfill('0') << std::setw(2) << hours << ":" < std::setw(2) << minutes << ":" << std::setw(2) << seconds << std::endl;
}

void Clock::tic()
{

}
