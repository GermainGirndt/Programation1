#include "phys_lib_quantities.h"

Velocity calc_velocity(Distance delta_d, Time delta_t)
{
	return delta_d/delta_t;
}
	
Acceleration calc_acceleration(Velocity delta_g, Time delta_t)
{
	return delta_g/delta_t;
}

Pulse calc_pulse(Mass m, Velocity v)
{
	return m * v;
}