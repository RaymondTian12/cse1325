#include "timer.h"

Timer::Timer(int hours, int minutes, int seconds)
    : Clock(hours, minutes, seconds)
{
}

Timer::~Timer()
{
}

void Timer::tic()
{
	_seconds--;
	if (_seconds == -1)
	{
		_seconds = 59;
		_minutes--;
		
		if (_minutes == -1)
		{
			_minutes = 59;
			_hours--;
			
			if (_hours == -1)
			{
				_seconds = 0;
				_minutes = 0;
				_hours = 0;
				
				throw std::runtime_error("Timer expired");
			}
		}
	}
}


