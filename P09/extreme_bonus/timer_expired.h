#ifndef __TIMER_EXPIRED_H
#define __TIMER_EXPIRED_H



class Timer_expired : public std::runtime_error
{
	public:
		Timer_expired();
};

#endif

