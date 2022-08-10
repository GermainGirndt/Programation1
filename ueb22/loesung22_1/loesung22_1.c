#include <stdio.h>
#include "phys_lib_motion.h"
#include "phys_lib_quantities.h"
#include "wpy_eingabe_fkts.h"


int main(void)
{
	Distance delta_d = leseDoubleZahl(" Geben Sie die Distanz in Metern ein : ");
	Time delta_t     = leseDoubleZahl(" Geben Sie die Zeitdauer in Sekunden ein : ");
	Mass m           = leseDoubleZahl( " Geben Sie die Mass in Kilogramm ein : ");

	Velocity     v = calc_velocity(delta_d, delta_t);
  	Acceleration a = calc_acceleration(v, delta_t);
  	Pulse        p = calc_pulse(m, v);

	printf("\n\tdelta d: %.2fm, delta t: %.2fs --> v: %.2fm/s\n", delta_d, delta_t, v);
	printf("\n\tdelta v: %.2fm/s, delta t: %.2fs --> a: %.2fm/sˆ2\n", v, delta_t, a);
	printf("\n\tm: %.2fkg, v: %.2fm/s --> p: %.2fNs\n", m, v, p);
  	
  	Distance dist  = rectilinear_motion_distance(v, delta_t, 0);
	Distance adist = rectilinear_accelerated_motion_distance(v, 0, a);
	Velocity av    = rectilinear_accelerated_motion_velocity(a, delta_t, 0, 0);

	printf("\n\tv: %.2fm/s, t: %.2fs, t0: %.2fs --> d: %.2fm\n", delta_d, delta_t, 0.0, dist);
	printf("\n\tv: %.2fm/s, v0: %.2fm/s, a: %.2fm/sˆs --> d: %.2fm\n", v, 0.0, a, adist);
	printf("\n\ta: %.2fm/sˆs, t: %.2fs, t0: %.2fs, v0: %.2fm/s --> v: %.2fm/s\n", a, delta_t, 0.0, 0.0, av);
  return 0;
}
