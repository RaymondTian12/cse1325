#ifndef __CLOCK_H
#define __CLOCK_H

#include <iostream>

class Clock
{
	protected:
		int _hours;
		int _minutes;
		int _seconds;
	
	public:
		Clock(int hours, int minutes, int seconds);
		virtual ~Clock();
		void tic();
		void print();
};

#endif
