#include <stdio.h>
#include <mpi.h>

MPI_Datatype IntDoubleType = 0;

typedef struct {
	int value_int;
	double value_double;
}IntDouble;

MPI_Datatype create_int_double_type() {
	if(IntDoubleType == 0) {
		MPI_Aint array_of_displacements[2];
        MPI_Datatype array_of_types[2];
        int array_of_blocklengths[2];

        array_of_displacements[0] = 0;
        array_of_types[0] = MPI_INT;
        array_of_blocklengths[0] = sizeof(int);

        array_of_displacements[1] = sizeof(int);
        array_of_types[1] = MPI_DOUBLE;
        array_of_blocklengths[1] = sizeof(double);

        MPI_Type_struct(1, array_of_blocklengths, array_of_displacements,
                        array_of_types, &IntDoubleType);
        MPI_Type_commit(&IntDoubleType);

	}

	return IntDoubleType;
}

int main (int argc, char** argv) {
	int rank, size, value_int, i;
	double value_double;
	IntDouble value;
	MPI_Status status;

	MPI_Init (&argc, &argv);   /* starts MPI */
	MPI_Comm_rank (MPI_COMM_WORLD, &rank);        /* get current process id */
	MPI_Comm_size (MPI_COMM_WORLD, &size);        /* get number of processes */
	create_int_double_type();

	do {
		if(rank == 0) {
			printf("give me an int value: ");
			scanf("%d", &value_int);
			printf("give me a double value: ");
			scanf("%lf", &value_double);
			value.value_int = value_int;
			value.value_double = value_double;
		}

		MPI_Bcast(&value, 1, IntDoubleType, 0, MPI_COMM_WORLD);
		printf("process %d received %d %lf\n", rank, value.value_int,
				value.value_double);
		fflush(stdout);
	} while(value.value_int >= 0);
	printf("negative value, closing\n");

	MPI_Finalize();
	return 0;
}
