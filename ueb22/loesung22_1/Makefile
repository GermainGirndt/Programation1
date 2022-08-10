#
#
#
#   Makefile ---> persoenliches Makefile
#
#
#


# Voreinstellungen fuer den gcc und g++
#vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

include /export/home_pm/bin/gnu-make.rules


# Eigene Make-Regeln
#vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

INCLUDES = phys_types.h phys_lib_motion.h  phys_lib_quantities.h   wpy_eingabe_fkts.h

OBJECTS = loesung22_1.o  phys_lib_motion.o  phys_lib_quantities.o wpy_eingabe_fkts.o

loesung22_1: $(OBJECTS)
	$(CC) $(CFLAGS) $(OBJECTS) $(CLIBS) -o loesung22_1


loesung22_1.o: loesung22_1.c $(INCLUDES)

phys_lib_motion.o: phys_lib_motion.c $(INCLUDES)

phys_lib_quantities.o: phys_lib_quantities.c $(INCLUDES)

run:
	./loesung22_1


clean:
	rm loesung22_1 *.o
