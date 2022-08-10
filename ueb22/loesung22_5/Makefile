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

INCLUDES = str.h

OBJECTS = str_test.o  str.o

loesung22_5: $(OBJECTS)
	$(CC) $(CFLAGS) $(OBJECTS) $(CLIBS) -o loesung22_5


str_test.o: str_test.c $(INCLUDES)

str.o: str.c $(INCLUDES)

clean:
	rm loesung22_5 *.o

