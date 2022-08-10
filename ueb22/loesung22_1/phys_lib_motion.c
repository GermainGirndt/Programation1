#include "phys_lib_motion.h"

Distance rectilinear_motion_distance(Velocity v, Time t, Time t0)
{
	return v * (t - t0);
}
	
Distance rectilinear_accelerated_motion_distance(Velocity v, Velocity v0, Acceleration a)
{
	return ((v * v) - (v0 * v0))/(2 * a);
}

Velocity rectilinear_accelerated_motion_velocity(Acceleration a, Time t, Time t0, Velocity v0)
{
	return a * (t - t0) + v0;
}