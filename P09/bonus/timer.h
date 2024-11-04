#ifndef __TIMER_H
#define __TIMER_H

#include <iostream>
#include "clock.h"

class Timer
{
	public:
		Timer(int hours, int minutes, int seconds) : Clock(hours, minutes, seconds);
		virtual ~Timer();
		void Tic();
};

#endif
