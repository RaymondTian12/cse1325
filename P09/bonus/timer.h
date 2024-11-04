#ifndef __TIMER_H
#define __TIMER_H

#include <iostream>
#include "clock.h"

class Timer
{
	public:
		Timer(int hours, int minutes, int seconds);
		virtual ~Timer();
		void Tic() override;
};

#endif
