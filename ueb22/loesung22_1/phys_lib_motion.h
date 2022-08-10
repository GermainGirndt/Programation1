#include "phys_types.h"

Distance rectilinear_motion_distance(Velocity v, Time t, Time t0);
	
Distance rectilinear_accelerated_motion_distance(Velocity v, Velocity v0, Acceleration a);

Velocity rectilinear_accelerated_motion_velocity(Acceleration a, Time t, Time t0, Velocity v0);