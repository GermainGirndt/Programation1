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

INCLUDES = autoTypen.h auto.h

OBJECTS = loesung22_2+4.o  auto.o

loesung22_2+4: $(OBJECTS)
	$(CC) $(CFLAGS) $(OBJECTS) $(CLIBS) -o loesung22_2+4


loesung22_2+4.o: loesung22_2+4.c $(INCLUDES)


auto.o: auto.c $(INCLUDES)

run:
	./loesung22_2+4


clean:
	rm loesung22_2+4 *.o
