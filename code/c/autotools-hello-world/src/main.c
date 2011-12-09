#include <stdio.h>
#include <config.h>

#include "hello.h"

int
main (void) {
	int a, b;

	a = 2;
	b = 3;

	printf("%d + %d = %d\n", a, b, hello_add(a, b));

	return 0;
}
